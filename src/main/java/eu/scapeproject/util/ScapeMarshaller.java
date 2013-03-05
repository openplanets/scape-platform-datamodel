package eu.scapeproject.util;

import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.purl.dc.elements._1.ElementContainer;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.Representation.Builder;
import generated.TextMD;
import gov.loc.audiomd.AudioType;
import gov.loc.mets.DivType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mets.AmdSecType;
import gov.loc.mets.FileType;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MetsType;
import gov.loc.mets.StructMapType;
import gov.loc.mix.v20.Mix;
import gov.loc.videomd.VideoType;

public class ScapeMarshaller {
    private static ScapeMarshaller INSTANCE;

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final JAXBContext context;

    private ScapeMarshaller() throws JAXBException {
        this.context = JAXBContext.newInstance("edu.harvard.hul.ois.xml.ns.fits.fits_output:generated:gov.loc.audiomd:gov.loc.marc21.slim:gov.loc.mets:gov.loc.mix.v20:gov.loc.videomd:info.lc.xmlns.premis_v2:org.purl.dc.elements._1");
        this.marshaller = context.createMarshaller();
        this.unmarshaller = context.createUnmarshaller();
    }

    public static ScapeMarshaller getInstance() throws JAXBException {
        if (INSTANCE == null) {
            INSTANCE = new ScapeMarshaller();
        }
        return INSTANCE;
    }

    public Object deserialize(InputStream src) throws JAXBException {
        return unmarshaller.unmarshal(src);
    }

    public void serialize(Object obj, OutputStream sink) throws JAXBException {
        marshaller.marshal(obj, sink);
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> type, InputStream src) throws JAXBException {
        if (type == IntellectualEntity.class) {
            return (T) createEntity(unmarshaller.unmarshal(src));
        } else {
            throw new IllegalArgumentException("Unable to deserilialize type " + type.getName());
        }
    }

    private IntellectualEntity createEntity(Object obj) {
        MetsType mets = (MetsType) obj;
        if (mets.getPROFILE() == null || mets.getPROFILE().equals("scape")) {
            /* create a SCAPE entity */
            List<Representation> reps = createScapeRepresentations(mets);
            IntellectualEntity.Builder entity = new IntellectualEntity.Builder()
                    .identifier(new Identifier(mets.getOBJID()))
                    .representations(reps);
            return entity.build();
        } else if (mets.getPROFILE().equals("gps")) {
            /* create an ONB entity */
            List<Representation> reps = createONBRepresentations(mets);
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
        } else {
            return null;
        }
    }

    private List<Representation> createScapeRepresentations(MetsType mets) {
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

    private Representation createScapeRepresentation(DivType div, MetsType mets) {
        Representation.Builder rep = new Representation.Builder(new Identifier("rep" + UUID.randomUUID().toString()));
        for (Object o : div.getADMID()) {
            AmdSecType amdSec = (AmdSecType) o;
            if (amdSec.getTechMD().size() > 0) {
                rep.technical(amdSec.getTechMD().get(0));
            }
            if (amdSec.getSourceMD().size() > 0) {
                rep.source(amdSec.getSourceMD().get(0));
            }
            if (amdSec.getRightsMD().size() > 0) {
                rep.rights(amdSec.getRightsMD().get(0));
            }
            if (amdSec.getDigiprovMD().size() > 0) {
                rep.provenance(amdSec.getDigiprovMD().get(0));
            }
        }
        for (Fptr ptr : div.getFptr()) {
            File.Builder f = new File.Builder();
            FileType metsFile = (FileType) ptr.getFILEID();
            f.identifier(new Identifier(metsFile.getID()));
            if (metsFile.getADMID() != null && metsFile.getADMID().size() > 0) {
                AmdSecType amd = (AmdSecType) metsFile.getADMID().get(0);
                if (amd.getTechMD() != null && amd.getTechMD().size() > 0) {
                    MdSecType mdSec = (MdSecType) amd.getTechMD().get(0);
                    f.technical(mdSec.getMdWrap().getXmlData());
                }
            }
            f.uri(URI.create(metsFile.getFLocat().get(0).getHref()));
            rep.file(f.build());
        }
        return rep.build();
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

    private List<Representation> createONBRepresentations(MetsType mets) {
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
        String idPrefix = UUID.randomUUID().toString();
        List<Representation> reps = new ArrayList<Representation>();
        Representation.Builder text = new Representation.Builder(new Identifier("text-" + idPrefix));
        Representation.Builder image = new Representation.Builder(new Identifier("image-" + idPrefix));
        Representation.Builder html = new Representation.Builder(new Identifier("html-" + idPrefix));

        /* and try to find the metadata in the mets document */
        for (Object mdSec : div.getADMID()) {
            MdSecType md = (MdSecType) mdSec;
            Object o = md.getMdWrap().getXmlData();
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
                textFiles.add(getPage("TXT", subDiv, mets));
                htmlFiles.add(getPage("HTML", subDiv, mets));
                imageFiles.add(getPage("IMG", subDiv, mets));
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

    private File getPage(String prefix, DivType subDiv, MetsType mets) {
        File.Builder f = new File.Builder();
        for (Fptr ptr : subDiv.getFptr()) {
            FileType metsFile = (FileType) ptr.getFILEID();
            if (metsFile.getID().startsWith(prefix)) {
                /* get the technical metadata for this file */
                List<Object> admIds = metsFile.getADMID();
                if (admIds != null && admIds.size() > 0) {
                    MdSecType mdSec = (MdSecType) metsFile.getADMID().get(0);
                    Object o = mdSec.getMdWrap().getXmlData().getAny().get(0);
                    f.technical(o);
                }
                f.identifier(new Identifier(metsFile.getID()));
                f.uri(URI.create("file://" + metsFile.getID()));
            }
        }
        return f.build();
    }
}
