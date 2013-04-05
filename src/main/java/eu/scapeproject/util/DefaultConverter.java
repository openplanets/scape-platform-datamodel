package eu.scapeproject.util;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scapeproject.model.BitStream;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import gov.loc.audiomd.AudioType;
import gov.loc.mets.AmdSecType;
import gov.loc.mets.DivType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mets.FileType;
import gov.loc.mets.FileType.FLocat;
import gov.loc.mets.FileType.Stream;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MdSecType.MdWrap;
import gov.loc.mets.MdSecType.MdWrap.XmlData;
import gov.loc.mets.Mets;
import gov.loc.mets.MetsType;
import gov.loc.mets.MetsType.FileSec;
import gov.loc.mets.MetsType.FileSec.FileGrp;
import gov.loc.mets.MetsType.MetsHdr;
import gov.loc.mets.StructMapType;
import gov.loc.mix.v20.Mix;
import gov.loc.videomd.VideoType;
import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;
import info.lc.xmlns.textmd_v3.TextMD;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.purl.dc.elements._1.ElementContainer;
import org.w3c.dom.Node;

public class DefaultConverter extends IntellectualEntityConverter {

	private final ScapeMarshaller marshaller;

	public DefaultConverter(ScapeMarshaller marshaller) {
		super("scape");
		this.marshaller = marshaller;
	}

	@Override
	public MetsType convertEntity(IntellectualEntity entity) {
		Mets mets = new Mets();
		if (entity.getIdentifier() != null) {
			mets.setID(entity.getIdentifier().getValue());
			mets.setOBJID(entity.getIdentifier().getValue());
		}
		mets.setPROFILE("scape");

		/* the header part of the mets document */
		addMetsHeader(mets, entity);

		/* create the dmdSec part holding the descriptive metadata */
		addDmdSec(mets, entity);

		/* create the interlocked filesec, structmap and amdsec part */
		AmdSecType amdSec = new AmdSecType();
		FileSec fileSec = new FileSec();
		FileGrp fileGrp = new FileGrp();
		fileSec.getFileGrp().add(fileGrp);
		StructMapType structMap = new StructMapType();
		DivType mainDiv = new DivType();
		mainDiv.setTYPE("Intellectual entity");

		/* handle all representations of the intellectual entity */
		if (entity.getRepresentations() != null) {
			for (Representation r : entity.getRepresentations()) {
				String repId = (r.getIdentifier() != null) ? r.getIdentifier().getValue() : "METS_ID:" + UUID.randomUUID().toString();
				DivType repDiv = new DivType();
				repDiv.setTYPE("Representation");
				repDiv.setID(repId);

				/* convert the technical metadata of this representation */
				addMetadata(repDiv.getADMID(), amdSec.getTechMD(), r.getTechnical());

				/* convert the provenance metadata of this representation */
				addMetadata(repDiv.getADMID(), amdSec.getDigiprovMD(), r.getProvenance());

				/* convert the source metadata of this representation */
				addMetadata(repDiv.getADMID(), amdSec.getSourceMD(), r.getSource());

				/* convert the rights metadata of this representation */
				addMetadata(repDiv.getADMID(), amdSec.getRightsMD(), r.getRights());

				/* handle all files of this representation */
				for (File f : r.getFiles()) {
					/* add each file to the file and Fptr sets */
					addFile(amdSec, repDiv.getFptr(), fileGrp.getFile(), f);
				}
				mainDiv.getDiv().add(repDiv);
			}
		}
		structMap.setDiv(mainDiv);
		mets.getStructMap().add(structMap);
		mets.setFileSec(fileSec);
		mets.getAmdSec().add(amdSec);

		return mets;
	}

	private void addFile(AmdSecType amdSec, List<Fptr> pointerList, List<FileType> fileList, File f) {
		Fptr ptr = new Fptr();
		FileType metsFile = new FileType();
		String fileId = (f.getIdentifier() != null) ? f.getIdentifier().getValue() : "FILE-" + UUID.randomUUID().toString();
		metsFile.setID(fileId);
		metsFile.setSEQ(0);
		metsFile.setMIMETYPE(f.getMimetype());
		FLocat locat = new FLocat();
		locat.setTitle(f.getFilename());
		if (f.getUri() != null) {
			locat.setLOCTYPE("URL");
			locat.setHref(f.getUri().toASCIIString());
		}
		Object filemd = f.getTechnical();
		MdSecType filemdsec = createMdSec(filemd);
		amdSec.getTechMD().add(filemdsec);
		metsFile.getADMID().add(filemdsec);
		metsFile.getFLocat().add(locat);

		/* iterate over and add the bitstreams to the mets file and amdsec elements */
		if (f.getBitStreams() != null) {
			for (BitStream bs : f.getBitStreams()) {
				Object md = bs.getTechnical();
				MdSecType mdsec = createMdSec(md);
				amdSec.getTechMD().add(mdsec);
				FileType.Stream stream = new FileType.Stream();
				String bsId = (bs.getIdentifier() != null) ? bs.getIdentifier().getValue() : "BITSTREAM-" + UUID.randomUUID().toString();
				stream.setID(bsId);
				stream.getADMID().add(mdsec);
				metsFile.getStream().add(stream);
			}
		}
		ptr.setFILEID(metsFile);
		pointerList.add(ptr);
		fileList.add(metsFile);
	}

	private MdSecType createMdSec(Object metadata) {
		MdSecType mdSec = new MdSecType();
		MdWrap wrap = new MdWrap();
		XmlData data = new XmlData();
		data.getAny().add(metadata);
		wrap.setXmlData(data);
		mdSec.setMdWrap(wrap);
		mdSec.setID("MD-" + UUID.randomUUID().toString());
		return mdSec;
	}

	private void addMetadata(List<Object> adm, List<MdSecType> mdSet, Object metadata) {
		String mdId = "MD-" + UUID.randomUUID().toString();
		MdSecType mdSec = new MdSecType();
		MdWrap mdWrap = new MdWrap();
		XmlData data = new XmlData();
		data.getAny().add(metadata);
		mdWrap.setXmlData(data);
		mdSec.setMdWrap(mdWrap);
		mdSec.setID(mdId);
		adm.add(mdSec);
		mdSet.add(mdSec);
	}

	private void addDmdSec(Mets mets, IntellectualEntity entity) {
		MdSecType dmdSec = new MdSecType();
		MdWrap wrap = new MdWrap();
		XmlData data = new XmlData();
		Object md = entity.getDescriptive();
		data.getAny().add(entity.getDescriptive());
		wrap.setXmlData(data);
		dmdSec.setMdWrap(wrap);
		mets.getDmdSec().add(dmdSec);
	}

	private void addMetsHeader(Mets mets, IntellectualEntity entity) {
		MetsHdr header = new MetsHdr();
		if (entity.getLifecycleState() == null) {
			header.setRECORDSTATUS(LifecycleState.State.NEW.toString());
		} else {
			header.setRECORDSTATUS(entity.getLifecycleState().getState().toString());
		}
		mets.setMetsHdr(header);
	}

	@Override
	public IntellectualEntity convertMets(MetsType mets) throws JAXBException {
		/* create a SCAPE entity */
		List<Representation> reps = createScapeRepresentations(mets);
		IntellectualEntity.Builder entity = new IntellectualEntity.Builder()
				.identifier(new Identifier(mets.getOBJID()))
				.descriptive(createDC(mets))
				.representations(reps);
		return entity.build();
	}

	private Object createDC(MetsType mets) {
		/* use the first dmdSec as the descriptive metadata */
		MdSecType dmdSec = mets.getDmdSec().get(0);
		if (dmdSec.getMdWrap().getXmlData().getAny().size() > 0) {
			return dmdSec.getMdWrap().getXmlData().getAny().get(0);
		}
		return null;
	}

	private List<Representation> createScapeRepresentations(MetsType mets) throws JAXBException {
		List<Representation> reps = new ArrayList<Representation>();
		for (StructMapType structmap : mets.getStructMap()) {
			DivType div = structmap.getDiv();
			if (div.getTYPE().equals("Intellectual entity")) {
				for (DivType subDiv : div.getDiv()) {
					reps.add(createScapeRepresentation(subDiv, mets));
				}
			}
		}
		return reps;
	}

	private Representation createScapeRepresentation(DivType div, MetsType mets) throws JAXBException {
		String repId = (div.getID() != null) ? div.getID() : "rep" + UUID.randomUUID().toString();
		Representation.Builder rep = new Representation.Builder(new Identifier(repId));
		for (Object o : div.getADMID()) {
			if (o instanceof AmdSecType) {
				AmdSecType amdSec = (AmdSecType) o;
				if (amdSec.getTechMD().size() > 0) {
					rep.technical(amdSec.getTechMD().get(0).getMdWrap().getXmlData().getAny().get(0));
				}
				if (amdSec.getSourceMD().size() > 0) {
					rep.source(amdSec.getSourceMD().get(0).getMdWrap().getXmlData().getAny().get(0));
				}
				if (amdSec.getRightsMD().size() > 0) {
					rep.rights(amdSec.getRightsMD().get(0).getMdWrap().getXmlData().getAny().get(0));
				}
				if (amdSec.getDigiprovMD().size() > 0) {
					rep.provenance(amdSec.getDigiprovMD().get(0).getMdWrap().getXmlData().getAny().get(0));
				}
			} else if (o instanceof MdSecType) {
				MdSecType mdSec = (MdSecType) o;
				if (mdSec.getMdWrap().getXmlData().getAny().size() == 0){
					continue;
				}
				Object mdObj = mdSec.getMdWrap().getXmlData().getAny().get(0);
				if (mdObj instanceof TextMD || mdObj instanceof Fits || mdObj instanceof Mix || mdObj instanceof VideoType
						|| mdObj instanceof AudioType) {
					/* it's tech md */
					rep.technical(mdObj);
				} else if (mdObj instanceof JAXBElement<?>) {
					JAXBElement<?> jaxb = (JAXBElement<?>) mdObj;
					if (jaxb.getDeclaredType() == PremisComplexType.class) {
						/* it's provenance md */
						rep.provenance(jaxb.getValue());
					} else if (jaxb.getDeclaredType() == RightsComplexType.class) {
						/* it's rights md */
						rep.rights(jaxb.getValue());
					}
				} else if (mdObj instanceof ElementContainer) {
					/* it's dc metadata in the representation therefore it's source md */
					rep.source(mdObj);
				} else {
					throw new JAXBException("Unable to deserialize objects of type " + ((JAXBElement<?>) mdObj).getDeclaredType().getName());
				}
			}
		}
		List<File> files = new ArrayList<File>();
		for (Fptr ptr : div.getFptr()) {
			File.Builder f = new File.Builder();
			FileType metsFile = (FileType) ptr.getFILEID();
			f.identifier(new Identifier(metsFile.getID()));
			if (metsFile.getADMID() != null && metsFile.getADMID().size() > 0) {
				MdSecType mdSec = (MdSecType) metsFile.getADMID().get(0);
				if (mdSec != null) {
					f.technical(mdSec.getMdWrap().getXmlData().getAny().get(0));
				}
			}
			List<BitStream> bitstreams = new ArrayList<BitStream>();
			for (Stream stream : metsFile.getStream()) {
				MdSecType mdSec = (MdSecType) stream.getADMID().get(0);
				BitStream bs = new BitStream.Builder()
						.identifier(new Identifier(stream.getID()))
						.technical(mdSec.getMdWrap().getXmlData().getAny().get(0))
						.build();
				bitstreams.add(bs);
			}
			f.bitStreams(bitstreams);
			if (metsFile.getFLocat().get(0).getHref() != null) {
				f.uri(URI.create(metsFile.getFLocat().get(0).getHref()));
			}
			if (metsFile.getFLocat().get(0).getTitle() != null) {
			    f.filename(metsFile.getFLocat().get(0).getTitle());
			}
			f.mimetype(metsFile.getMIMETYPE());
			files.add(f.build());
		}
		rep.files(files);
		return rep.build();
	}
}
