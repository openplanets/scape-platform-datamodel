package eu.scapeproject.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.text.html.parser.Entity;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import junit.framework.Assert;

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
    public void testEntityDeserialization1() throws Exception {
        IntellectualEntity orig = TestUtil.createRandomEntity();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        MetsMarshaller.getInstance().serialize(orig, bos);
        IntellectualEntity deserialized=MetsMarshaller.getInstance().deserialize(IntellectualEntity.class, new ByteArrayInputStream(bos.toByteArray()));
//        MetsMarshaller.getInstance().serialize(deserialized, System.out);
        Assert.assertEquals(orig, deserialized);
    }
    
    @Test
    public void testMinimalEntityDeserialization() throws Exception {
    	IntellectualEntity orig=TestUtil.createMinimalEntity();
    	ByteArrayOutputStream bos=new ByteArrayOutputStream();
    	MetsMarshaller.getInstance().serialize(orig, bos);
    	System.out.println(bos.toString("UTF-8"));
    	IntellectualEntity desr=MetsMarshaller.getInstance().deserialize(IntellectualEntity.class, new ByteArrayInputStream(bos.toByteArray()));
    	Assert.assertEquals(orig, desr);
    }

    @Test
    public void testEntitySerialization2() throws Exception {
    	MetsMarshaller.getInstance().serialize(TestUtil.createMinimalEntity(), System.out);
    }
    
    @Test
    public void testEntitySerialization1() throws Exception{
        java.io.File xmlFile=new java.io.File("target/mets_entity_1.xml");
        IntellectualEntity entity=TestUtil.createRandomEntity();
        FileOutputStream out=new FileOutputStream(xmlFile);
        MetsMarshaller.getInstance().serialize(entity, out);
//        ValidationUtil.validateXML(new FileInputStream(xmlFile),this.getClass().getClassLoader().getResourceAsStream("mets.xsd"));
    }
    
    @Test
    public void testFitsSerialization() throws Exception{
        FitsMetadata md=TestUtil.createRandomFitsMetadata();
        FileOutputStream out=new FileOutputStream("target/fits_1.xml");
        marshaller.marshal(md, out);
    }
}
