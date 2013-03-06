package eu.scapeproject.model;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import eu.scapeproject.util.ONBConverter;
import eu.scapeproject.util.ScapeMarshaller;
import gov.loc.marc21.slim.RecordType;
import gov.loc.mets.MetsType;

public class JaxbTests {

    @Test
    public void testONBMarc21Deserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_marc_example.xml"));
        assertTrue(o instanceof JAXBElement<?>);
        JAXBElement<RecordType> e = (JAXBElement<RecordType>) o;
        assertTrue(e.getValue() instanceof RecordType);
    }

    @Test
    public void testONBGoogleBookScanDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_gbs_example.xml"));
        assertTrue(o instanceof MetsType);
    }

    @Test
    public void testONBMETSDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        assertTrue(o instanceof MetsType);
    }

    @Test
    public void testONBIntellectualEntityDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance(new ONBConverter()).deserialize(IntellectualEntity.class,
                this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        assertTrue(o instanceof IntellectualEntity);
        IntellectualEntity ent = (IntellectualEntity) o;
        assertTrue(ent.getDescriptive() instanceof RecordType);
        assertTrue(ent.getRepresentations().size() == 3);
        for (Representation r : ent.getRepresentations()) {
            assertTrue(r.getFiles().size() == 924);
            for (File f : r.getFiles()) {
                assertNotNull(f.getUri());
                assertTrue(f.getUri().toASCIIString().length() > 0);
            }
        }
    }

    @Test
    public void testIntellectualEntitySerialization() throws Exception {
        IntellectualEntity e = TestUtil.createTestEntity();
        assertNotNull("test entity is not complete check deserialization first", e.getDescriptive());
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0));
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0));
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0).getTechnical());
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0).getUri());
        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();
        marshaller.setMarshallerProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.serialize(e, System.out);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testONBIntellectualEntityDeserializationMissingProfileName() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class,
                this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
    }

    @Test
    public void testScapeEntityDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class,
                this.getClass().getClassLoader().getResourceAsStream("SCAPE_entity_example.xml"));
        assertTrue(o instanceof IntellectualEntity);
        IntellectualEntity e = (IntellectualEntity) o;
        assertTrue(e.getRepresentations().size() == 1);
        Representation r = e.getRepresentations().get(0);
        assertTrue(r.getFiles().size() == 1);
    }
}
