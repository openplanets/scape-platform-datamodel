package eu.scapeproject.model.mets;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.SerializationException;

import eu.scapeproject.dto.mets.MetsDMDSec;
import eu.scapeproject.dto.mets.MetsDocument;
import eu.scapeproject.dto.mets.MetsFile;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.IntellectualEntityCollection;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.VersionList;
import eu.scapeproject.model.LifecycleState.State;
import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;
import eu.scapeproject.model.util.MetsUtil;

public class MetsMarshaller {
    private static final String SCAPE_PROFILE = "http://example.com/scape-mets-profile.xml";
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private static MetsMarshaller INSTANCE;

    public static MetsMarshaller getInstance() throws JAXBException {
        if (INSTANCE == null) {
            INSTANCE = new MetsMarshaller();
        }
        return INSTANCE;
    }

    private MetsMarshaller() throws JAXBException {
        super();
        final JAXBContext ctx = JAXBContext.newInstance(
                MetsDocument.class,
                DCMetadata.class,
                TextMDMetadata.class,
                NisoMixMetadata.class,
                PremisProvenanceMetadata.class,
                PremisRightsMetadata.class,
                AudioMDMetadata.class,
                VideoMDMetadata.class,
                FitsMetadata.class,
                LifecycleState.class,
                Identifier.class,
                VersionList.class,
                IntellectualEntityCollection.class);
        marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
        unmarshaller = ctx.createUnmarshaller();
    }

    public void serialize(Object subject, OutputStream out) throws SerializationException {
        if (subject instanceof IntellectualEntity) {
            try {
                serializeEntity((IntellectualEntity) subject, out);
            } catch (JAXBException e) {
                throw new SerializationException(e);
            }
        } else if (subject instanceof List<?>) {
            try {
                serializeList((List) subject, out);
            } catch (JAXBException e) {
                throw new SerializationException(e);
            }
        } else if (subject instanceof File) {
            try {
                serializeFile((File) subject, out);
            } catch (JAXBException e) {
                throw new SerializationException(e);
            }
        } else if (subject instanceof Identifier) {
            try {
                serializeIdentifier((Identifier) subject, out);
            } catch (JAXBException e) {
                throw new SerializationException(e);
            }
        } else if (subject instanceof LifecycleState) {
            try {
                serializeLifecycleState((LifecycleState) subject, out);
            } catch (JAXBException e) {
                throw new SerializationException(e);
            }
        } else {
            throw new SerializationException("unable to serialize objects of type " + subject.getClass());
        }
    }

    private void serializeList(List subject, OutputStream out) throws JAXBException {
        marshaller.marshal(subject, out);
    }

    private void serializeLifecycleState(LifecycleState subject, OutputStream out) throws JAXBException {
        marshaller.marshal(subject, out);
    }

    private void serializeIdentifier(Identifier subject, OutputStream out) throws JAXBException {
        marshaller.marshal(subject, out);
    }

    private void serializeFile(File subject, OutputStream out) throws JAXBException {
        MetsFile file = MetsUtil.convertFile(subject);
        marshaller.marshal(file, out);
    }

    public <T> T deserialize(Class<T> type, InputStream in) throws SerializationException {
        if (type == IntellectualEntity.class) {
            return (T) deserializeEntity(in);
        } else if (type == DCMetadata.class) {
            return (T) deserializeDC(in);
        } else {
            throw new SerializationException("unable to deserialize into objects of type " + type);
        }
    }

    private DCMetadata deserializeDC(InputStream in) throws SerializationException {
        try {
            MetsDMDSec dmd = (MetsDMDSec) unmarshaller.unmarshal(in);
            return (DCMetadata) MetsUtil.getDescriptiveMetadadata(dmd);
        } catch (JAXBException e) {
            throw new SerializationException(e);
        }
    }

    private IntellectualEntity deserializeEntity(InputStream in) throws SerializationException {
        try {
            MetsDocument doc = (MetsDocument) unmarshaller.unmarshal(in);
            IntellectualEntity.Builder entityBuilder = new IntellectualEntity.Builder()
                    .identifier(new Identifier(doc.getObjId()))
                    .descriptive(MetsUtil.getDescriptiveMetadadata(doc.getDmdSec()))
                    .representations(MetsUtil.getRepresentations(doc))
                    .alternativeIdentifiers(MetsUtil.getAlternativeIdentifiers(doc.getHeaders()));
            if (doc.getHeaders().get(0).getRecordStatus() != null) {
                entityBuilder.lifecycleState(new LifecycleState("", State.valueOf(doc.getHeaders().get(0).getRecordStatus())));
            }
            return entityBuilder.build();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new SerializationException(e);
        }
    }

    public IntellectualEntity deserializeEntity(MetsDocument doc) {
        IntellectualEntity.Builder entityBuilder = new IntellectualEntity.Builder()
                .identifier(new Identifier(doc.getObjId()))
                .descriptive(MetsUtil.getDescriptiveMetadadata(doc.getDmdSec()))
                .representations(MetsUtil.getRepresentations(doc))
                .alternativeIdentifiers(MetsUtil.getAlternativeIdentifiers(doc.getHeaders()));
        if (doc.getHeaders().get(0).getRecordStatus() != null) {
            entityBuilder.lifecycleState(new LifecycleState("", State.valueOf(doc.getHeaders().get(0).getRecordStatus())));
        }
        return entityBuilder.build();
    }

    private void serializeEntity(IntellectualEntity entity, OutputStream out) throws JAXBException {
        MetsDocument doc = MetsUtil.convertEntity(entity);
        marshaller.marshal(doc, out);
    }

    public Marshaller getJaxbMarshaller() {
        return marshaller;
    }

    public Unmarshaller getJaxbUnmarshaller() {
        return unmarshaller;
    }

}
