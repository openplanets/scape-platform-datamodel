package eu.scapeproject.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.mets.MetsMarshaller;
import eu.scapeproject.model.test.TestUtil;
import eu.scapeproject.model.test.ValidationUtil;

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
        java.io.File xmlFile=new java.io.File("target/mets_entity_1.xml");
        IntellectualEntity entity=TestUtil.createRandomEntity();
        FileOutputStream out=new FileOutputStream(xmlFile);
        MetsMarshaller.getInstance().serialize(entity, out);
        ValidationUtil.validateXML(new FileInputStream(xmlFile),this.getClass().getClassLoader().getResourceAsStream("mets.xsd"));
    }
    
    @Test
    public void testFitsSerialization() throws Exception{
        FitsMetadata md=TestUtil.createRandomFitsMetadata();
        FileOutputStream out=new FileOutputStream("target/fits_1.xml");
        marshaller.marshal(md, out);
    }
}
