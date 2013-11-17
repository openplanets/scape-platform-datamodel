/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.util;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scape_project.model.File;
import eu.scape_project.model.Identifier;
import eu.scape_project.model.IntellectualEntity;
import eu.scape_project.model.LifecycleState;
import eu.scape_project.model.Representation;
import gov.loc.audiomd.AudioType;
import gov.loc.mets.DivType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mets.FileType;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MetsType;
import gov.loc.mets.StructMapType;
import gov.loc.mix.v20.Mix;
import gov.loc.repository.pairtree.Pairtree;
import gov.loc.videomd.VideoType;
import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;
import info.lc.xmlns.textmd_v3.TextMD;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ElementContainer;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.books.gbs.FocusParametersType;
import com.google.books.gbs.GbsType;
import com.google.books.gbs.ImageMethodType;
import com.google.books.gbs.ObjectFactory;
import com.google.books.gbs.ProductionNotesType;

/**
*
* @author frank asseg
*
*/
public class ONBConverter extends IntellectualEntityConverter {

	private final String basePath;

	private final String encapsulatingDir;


	public ONBConverter(String basePath, String encapsulatingDir) {
		super("gbs");
		this.basePath = basePath;
		this.encapsulatingDir = encapsulatingDir;
	}

	@Override
	public MetsType convertEntity(IntellectualEntity entity, boolean useMdRef) {
		throw new UnsupportedOperationException("Serialization to ONB documents iis not available");
	}

	@Override
	public IntellectualEntity convertMets(MetsType mets) {
		/* create an ONB entity */
		List<Representation> reps = createRepresentations(mets);
		Object desc = createDescriptive(mets);
		if (desc == null) {
			throw new IllegalArgumentException("Unable to find descriptive metadata in METS file");
		}
		LifecycleState lifecycle = createLifecycleState(mets);
		List<Identifier> altIds = createAlternateIdentifiers(mets);
		int versionNumber = createVersionNumber(mets);
		IntellectualEntity.Builder entity = new IntellectualEntity.Builder()
				.identifier(new Identifier(mets.getOBJID()))
				.representations(reps)
				.descriptive(desc)
				.alternativeIdentifiers(altIds)
				.lifecycleState(lifecycle)
				.versionNumber(versionNumber);
		return entity.build();
	}

	private List<Representation> createRepresentations(MetsType mets) {
		List<Representation> reps = new ArrayList<Representation>();
		for (StructMapType structmap : mets.getStructMap()) {
			DivType div = structmap.getDiv();
			if (div.getTYPE().equals("volume")) {
				reps.addAll(createVolume(div, mets));
			}
		}
		return reps;
	}

	private List<Representation> createVolume(DivType div, MetsType mets) {
		/*
		 * in Scape terms a Volume consists of three Representations: One using text, html and images each
		 */
		String idPrefix = UUID.randomUUID().toString();
		List<Representation> reps = new ArrayList<Representation>();
		Representation.Builder text = new Representation.Builder(new Identifier("text-" + idPrefix));
		text.title("Text representation");
		Representation.Builder image = new Representation.Builder(new Identifier("image-" + idPrefix));
		image.title("Image representaion");
		Representation.Builder html = new Representation.Builder(new Identifier("html-" + idPrefix));
		html.title("HTML representation");

		/* get the non linked PREMIS1 md set */
		MdSecType digiprov = mets.getAmdSec().get(0).getDigiprovMD().get(0);
		if (digiprov != null) {
			JAXBElement<?> j = (JAXBElement<?>) digiprov.getMdWrap().getXmlData().getAny().get(0);
			text.provenance(j.getValue());
			image.provenance(j.getValue());
			html.provenance(j.getValue());
		}

		/* and try to find the metadata in the mets document */
		for (Object mdSec : div.getADMID()) {
			MdSecType md = (MdSecType) mdSec;
			Object o = md.getMdWrap().getXmlData().getAny().get(0);
			if (o instanceof Element) {
				if (md.getID().startsWith("TMD")) {
					Element el = (Element) o;
					Object tech = deserializeElement(el);
					text.technical(tech);
					image.technical(tech);
					html.technical(tech);
				}else if (md.getID().startsWith("PD")) {
					/* TODO: Dont know! */
				}else if (md.getID().startsWith("S")){
					/* source metadata */
					Object source = deserializeElement((Element) o);
					text.source(source);
					html.source(source);
					image.source(source);
				}
			}
			if (o instanceof ElementContainer) {
				text.source(o);
				image.source(o);
				html.source(o);
			}
			if (o instanceof Fits || o instanceof Mix || o instanceof VideoType || o instanceof AudioType || o instanceof TextMD) {
				text.technical(o);
				image.technical(o);
				html.technical(o);
			}
			if (o instanceof PremisComplexType) {
				text.provenance(o);
				image.provenance(o);
				html.provenance(o);
			}
			if (o instanceof RightsComplexType) {
				text.rights(o);
				image.rights(o);
				html.rights(o);
			}
		}

		/* create the files belonging to this volume */
		List<File> textFiles = new ArrayList<File>();
		List<File> htmlFiles = new ArrayList<File>();
		List<File> imageFiles = new ArrayList<File>();
		for (DivType subDiv : div.getDiv()) {
			if (subDiv.getTYPE().equals("page")) {
				textFiles.add(createPages("TXT", subDiv, mets));
				htmlFiles.add(createPages("HTML", subDiv, mets));
				imageFiles.add(createPages("IMG", subDiv, mets));
			}
		}

		text.files(textFiles);
		html.files(htmlFiles);
		image.files(imageFiles);
		reps.add(text.build());
		reps.add(html.build());
		reps.add(image.build());
		return reps;
	}

	private File createPages(String prefix, DivType subDiv, MetsType mets) {
		File.Builder f = new File.Builder();
		for (Fptr ptr : subDiv.getFptr()) {
			FileType metsFile = (FileType) ptr.getFILEID();
			if (metsFile.getID().startsWith(prefix)) {
				/* get the technical metadata for this file */
				List<Object> admIds = metsFile.getADMID();
				if (admIds != null && admIds.size() > 0) {
					MdSecType mdSec = (MdSecType) metsFile.getADMID().get(0);
					Object o = mdSec.getMdWrap().getXmlData().getAny().get(0);
					if (o instanceof Element) {
						f.technical(deserializeElement((Element) o));
					} else {
						f.technical(o);
					}
				}
				f.identifier(new Identifier(metsFile.getID()));
				final int separatorPos = metsFile.getFLocat().get(0).getHref().lastIndexOf('.');
				if (separatorPos == -1) {
					throw new RuntimeException("Unable to retrieve file id from filename for Pairtree Path conversion");
				}
				final String fileId = metsFile.getFLocat().get(0).getHref().substring(0, separatorPos);
				final String fileExtension = metsFile.getFLocat().get(0).getHref().substring(separatorPos + 1);
				try {
					f.uri(new URI("file",getPathFromBarcodePageId(mets.getOBJID(), fileId, fileExtension), null));
				} catch (URISyntaxException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return f.build();
	}

	private Object deserializeElement(Element e) {
		if (e.getNamespaceURI().equals("http://books.google.com/gbs")) {
			// parse gbs type;
			ObjectFactory fac = new ObjectFactory();
			GbsType gbs = fac.createGbsType();
			if (e.getLocalName().equals("productionNotes")) {
				ProductionNotesType prod = fac.createProductionNotesType();
				NodeList children = e.getChildNodes();
				for (int i = 0; i < children.getLength(); i++) {
					if (children.item(i) instanceof Element) {
						Element c = (Element) children.item(i);
						if (c.getLocalName().equals("badPages")) {
							prod.setBadPages(Float.parseFloat(c.getFirstChild().getTextContent()));
						} else if (c.getLocalName().equals("missingPages")) {
							prod.setMissingPages(Float.parseFloat(c.getFirstChild().getTextContent()));
						} else if (c.getLocalName().equals("tightBoundPages")) {
							prod.setTightBoundPages(Float.parseFloat(c.getFirstChild().getTextContent()));
						}
					}
				}
				gbs.setProductionNotes(prod);
			}

			if (e.getLocalName().equals("imageMethod")) {
				ImageMethodType img = fac.createImageMethodType();
				img.setValue(e.getTextContent());
				if (e.getAttributeNode("scanner") != null) {
					img.setScanner(e.getAttribute("scanner"));
				}
				gbs.setImageMethod(img);
			}

			if (e.getLocalName().equals("focusParameters")) {
				FocusParametersType focus = fac.createFocusParametersType();
				if (e.getAttributeNode("threshold") != null) {
					focus.setThreshold(e.getAttribute("threshold"));
				}
				gbs.setFocusParameters(focus);
			}

			if (e.getLocalName().equals("pageTag")) {
				if (e.getAttributeNode("pageTag") != null) {
					gbs.setPageTag(e.getNodeValue());
				}
			}

			if (e.getLocalName().equals("sourceLibrary")) {
				if (e.getAttributeNode("sourceLibrary") != null) {
					gbs.setSourceLibrary(e.getNodeValue());
				}
			}

			if (e.getLocalName().equals("sourceIdentifier")) {
				if (e.getAttributeNode("sourceIdentifier") != null) {
					gbs.setSourceIdentifier(e.getNodeValue());
				}
			}

			return gbs;
		} else {
			throw new IllegalArgumentException("Unable to serialize element with namespace \"" + e.getNamespaceURI() + "\"");
		}
	}

	private int createVersionNumber(MetsType mets) {
		// TODO think about a version numbering and mets serialization mechanism
		// for versioning
		return 1;
	}

	private List<Identifier> createAlternateIdentifiers(MetsType mets) {
		// TODO parse for dc descriptive metadata
		return new ArrayList<Identifier>();
	}

	private LifecycleState createLifecycleState(MetsType mets) {
		String state = mets.getMetsHdr().getRECORDSTATUS();
		if (state == null || state.length() == 0) {
			state = "NEW";
		}
		return new LifecycleState("", LifecycleState.State.valueOf(state));
	}

	@SuppressWarnings("unchecked")
	private Object createDescriptive(MetsType mets) {
		for (MdSecType dmd : mets.getDmdSec()) {
			JAXBElement<Object> e = (JAXBElement<Object>) dmd.getMdWrap().getXmlData().getAny().get(0);
			return e.getValue();
		}
		return null;
	}

    public String getPathFromBarcodePageId(String objectId, String fileId,String extension) {
        if (objectId.startsWith("ONB_")) {
            objectId = objectId.substring(4);
        }
        Pairtree pt = new Pairtree();
        String path = pt.mapToPPath(this.basePath, objectId, this.encapsulatingDir);
        path += java.io.File.separator + fileId+"."+extension;
        return path;
    }


}
