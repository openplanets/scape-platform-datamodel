package eu.scapeproject.model.mets;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.SerializationException;

import eu.scapeproject.dto.mets.MetsDocument;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
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
				FitsMetadata.class);
		marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
		unmarshaller = ctx.createUnmarshaller();
	}

	public void serialize(Object subject,OutputStream out) throws SerializationException{
		if (subject instanceof IntellectualEntity) {
			try {
				serializeEntity((IntellectualEntity) subject,out);
			} catch (JAXBException e) {
				throw new SerializationException(e);
			}
		}else  {
			throw new SerializationException("unable to serialize objects of type " + subject.getClass());
		}
	}
	
	public <T> T deserialize(Class<T> type,InputStream in) throws SerializationException {
		if (type == IntellectualEntity.class){
			return (T) deserializeEntity(in);
		}else{
			throw new SerializationException("unable to deserialize into objects of type " + type);
		}
	}
	
	private IntellectualEntity deserializeEntity(InputStream in) throws SerializationException{
		try {
            MetsDocument doc=(MetsDocument) unmarshaller.unmarshal(in);
            IntellectualEntity.Builder entityBuilder=new IntellectualEntity.Builder()
                .identifier(new Identifier(doc.getObjId()))
                .descriptive((DescriptiveMetadata) doc.getDmdSec().getMetadataWrapper().getXmlData().getData())
                .representations(MetsUtil.getRepresentations(doc))
                .alternativeIdentifiers(MetsUtil.getAlternativeIdentifiers(doc.getHeaders()));
            return entityBuilder.build();
        } catch (JAXBException e) {
            throw new SerializationException(e);
        }
	}

	private void serializeEntity(IntellectualEntity entity,OutputStream out) throws JAXBException{
		MetsDocument doc=MetsUtil.convertEntity(entity);
		marshaller.marshal(doc, out);
	}
	

	
}
