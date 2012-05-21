package eu.scapeproject.model;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.mets.MetsFactory;
import eu.scapeproject.model.test.TestUtil;

public class JaxbXMLSerializationTest {
    private static Marshaller marshaller;
    
    @BeforeClass
    public static void setup() throws Exception{
        marshaller=JAXBContext.newInstance(FitsMetadata.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
    }
    
    @Test
    public void testEntitySerialization1() throws Exception{
        IntellectualEntity entity=TestUtil.createRandomEntity();
        FileOutputStream out=new FileOutputStream("target/entity_serialization_test.xml");
        MetsFactory.getInstance().serialize(entity, out);
    }
    
    @Test
    public void testFitsSerialization() throws Exception{
        FitsMetadata md=TestUtil.createRandomFitsMetadata();
        marshaller.marshal(md, System.out);
    }
}
