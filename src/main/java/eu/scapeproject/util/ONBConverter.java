package eu.scapeproject.util;

import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;

import org.purl.dc.elements._1.ElementContainer;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import generated.TextMD;
import gov.loc.audiomd.AudioType;
import gov.loc.mets.DivType;
import gov.loc.mets.FileType;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MetsType;
import gov.loc.mets.StructMapType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mix.v20.Mix;
import gov.loc.videomd.VideoType;

public class ONBConverter extends IntellectualEntityConverter {
    public ONBConverter() {
        super("gbs");
    }

    @Override
    public MetsType convertEntity(IntellectualEntity entity) {
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
         * in Scape terms a Volume consists of three Representations: One using
         * text, html and images each
         */
        String idPrefix = UUID.randomUUID().toString();
        List<Representation> reps = new ArrayList<Representation>();
        Representation.Builder text = new Representation.Builder(new Identifier("text-" + idPrefix));
        text.title("Text representation");
        Representation.Builder image = new Representation.Builder(new Identifier("image-" + idPrefix));
        image.title("Image representaion");
        Representation.Builder html = new Representation.Builder(new Identifier("html-" + idPrefix));
        html.title("HTML representation");

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

}
