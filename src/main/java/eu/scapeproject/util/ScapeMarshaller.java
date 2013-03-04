package eu.scapeproject.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.TechnicalMetadata;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import gov.loc.mets.DivType;
import gov.loc.mets.MetsType;
import gov.loc.mets.StructMapType;
import gov.loc.mets.MetsType.MetsHdr.MetsDocumentID;

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
    public <T> T deserialize(Class<T> type, InputStream src) throws JAXBException{
        if (type == IntellectualEntity.class){
            return (T) createEntity(unmarshaller.unmarshal(src));
        }else{
            throw new IllegalArgumentException("Unable to deserilialize type " + type.getName());
        }
    }

    private IntellectualEntity createEntity(Object obj) {
        MetsType mets = (MetsType) obj;
        List<Representation> reps = createRepresentations(mets);
        List<Identifier> altIds = createAlternateIdentifiers(mets);
        DescriptiveMetadata desc = createDescriptive(mets);
        LifecycleState lifecycle = createLifecycleState(mets);
        int versionNumber = createVersionNumber(mets);
        IntellectualEntity entity = new IntellectualEntity.Builder()
            .representations(reps)
            .descriptive(desc)
            .alternativeIdentifiers(altIds)
            .lifecycleState(lifecycle)
            .versionNumber(versionNumber)
            .build();
}

    private List<Representation> createRepresentations(MetsType mets) {
        List<Representation> reps = new ArrayList<Representation>();
        for (StructMapType structmap : mets.getStructMap()){
            DivType div = structmap.getDiv();
            if (div.getLABEL3().equals("Volume")){
                reps.add(createVolume(div, mets));
            }
        }
    }

    /* create a representation from an ONB volume */
    private Representation createVolume(DivType div, MetsType mets) {
        TechnicalMetadata techMd = createTechnical();
        RightsMetadata rightsMd = createRigths();
        ProvenanceMetadata provMd = createProvenance();
        DescriptiveMetadata sourceMd = createSource();
        Representation rep = new Representation.Builder("rep-" + UUID.randomUUID())
            .provenance(provMd)
            .source(sourceMd)
            .provenance(provMd)
            .technical(techMd)
            .build();
    }
