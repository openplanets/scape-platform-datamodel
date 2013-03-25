package eu.scapeproject.model;

import static org.junit.Assert.*;

import info.lc.xmlns.textmd_v3.TextMD;
import info.lc.xmlns.textmd_v3.TextMD.Encoding;
import info.lc.xmlns.textmd_v3.TextMD.Encoding.EncodingAgent;
import info.lc.xmlns.textmd_v3.TextMD.Encoding.EncodingPlatform;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.Arrays;

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
        BitStream bs_1 = new BitStream.Builder()
            .identifier(new Identifier("bitstream:1"))
            .title("Sequence 1")
            .technical(TestUtil.createTextMDRecord())
            .build();
        
        File f = new File.Builder()
            .bitStreams(Arrays.asList(bs_1))
            .identifier(new Identifier("file-1"))
            .uri(URI.create("http://example.com/data"))
            .technical(TestUtil.createTextMDRecord())
            .build();
        
        Representation rep = new Representation.Builder(new Identifier("representation-1"))
            .files(Arrays.asList(f))
            .technical(TestUtil.createTextMDRecord())
            .title("Text representation")
            .provenance(TestUtil.createPremisDigiProvRecord())
            .rights(TestUtil.createPremisRightsRecord())
            .source(TestUtil.createDCSourceRecord())
            .build();
            
        IntellectualEntity e = new IntellectualEntity.Builder()
            .identifier(new Identifier("entity-1"))
            .representations(Arrays.asList(rep))
            .descriptive(TestUtil.createDCRecord())
            .build();
        
        assertNotNull("test entity is not complete check deserialization first", e.getDescriptive());
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0));
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0));
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0).getTechnical());
        assertNotNull("test entity is not complete check deserialization first", e.getRepresentations().get(0).getFiles().get(0).getUri());
        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();

        /* marshall to a temp file */
        java.io.File tmp = new java.io.File("target/entity_serialized.xml");
        FileOutputStream sink = new FileOutputStream(tmp);
        marshaller.setMarshallerProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.serialize(e, sink);
        
        FileInputStream src = new FileInputStream(tmp);
        /* and create a new instance from the marshalled XML */
        IntellectualEntity des = marshaller.deserialize(IntellectualEntity.class, src);
        assertTrue("Identifier does not match", e.getIdentifier().getValue().equals(des.getIdentifier().getValue()));
        
        
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
