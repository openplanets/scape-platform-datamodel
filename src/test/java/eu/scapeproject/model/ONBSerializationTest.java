package eu.scapeproject.model;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import eu.scapeproject.model.metadata.gbs.GoogleBookScanMetadata;
import eu.scapeproject.model.metadata.marc.ControlField;
import eu.scapeproject.model.metadata.marc.Datafield;
import eu.scapeproject.model.metadata.marc.Leader;
import eu.scapeproject.model.metadata.marc.Marc21Metadata;
import eu.scapeproject.model.metadata.marc.SubField;
import eu.scapeproject.model.mets.SCAPEMarshaller;
import eu.scapeproject.model.util.TestUtil;

public class ONBSerializationTest {

    @Test
    public void testEntitySerialization() throws Exception {
        IntellectualEntity.Builder e = new IntellectualEntity.Builder();
        
        // create a MARC21 record as it is used in the ONB assets
        ControlField cf = new ControlField.Builder()
                .tag("245")
                .id("id1")
                .build();
        SubField sf = new SubField.Builder()
                .id("id2")
                .value("balh")
                .build();
        Datafield df = new Datafield.Builder()
                .id("id3")
                .tag("2552")
                .subfields(Arrays.asList(sf))
                .build();
        Marc21Metadata rec = new Marc21Metadata.Builder()
                .dataField(Arrays.asList(df))
                .controlFields(Arrays.asList(cf))
                .leader(new Leader.Builder().name("leader1").build())
                .build();

        // create a dummy google book scan technical metadata
        GoogleBookScanMetadata gbs = new GoogleBookScanMetadata.Builder()
            .coverTag("The Cover Tag")
            .build();
        File scapeFile = new File.Builder()
            .identifier(new Identifier(UUID.randomUUID().toString()))
            .build();
        Representation r = new Representation.Builder(new Identifier("rep" + UUID.randomUUID().toString()))
            .technical(gbs)
            .file(scapeFile)
            .build();
        
        e.representations(Arrays.asList(r));
        e.descriptive(rec);
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        SCAPEMarshaller.getInstance().serialize(e.build(), sink);
        IntellectualEntity copy = SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class, sink.toString());
        assertTrue(copy.getDescriptive() instanceof Marc21Metadata);
        SCAPEMarshaller.getInstance().serialize(copy, System.out);
    }

    @Test
    public void testDCSerialization() throws Exception {
        IntellectualEntity e = TestUtil.createMinimalEntity();
        SCAPEMarshaller.getInstance().serialize(e, System.out);
    }

    @Test
    public void testONBMetsDeserialization() throws Exception {
        InputStream src = this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml");
        IntellectualEntity e = SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class, src);
        assertNotNull(e);
        assertNotNull(e.getDescriptive());
        assertTrue(e.getDescriptive() instanceof Marc21Metadata);
    }

    
    @Test
    public void testONBGooglBookScan() throws Exception {
        GoogleBookScanMetadata.Builder g = new GoogleBookScanMetadata.Builder();
        g.coverTag("The Cover Tag");
        String xml = SCAPEMarshaller.getInstance().serialize(g.build());
        assertTrue(xml.indexOf("The Cover Tag") > 0);
        System.out.println(xml);
    }
    
    @Test
    public void testONBMarcDeserialization() throws Exception {
        Unmarshaller u = SCAPEMarshaller.getInstance().getJaxbUnmarshaller();
        Object o = u.unmarshal(this.getClass().getClassLoader().getResourceAsStream("ONB_marc_example.xml"));
        assertTrue(o instanceof Marc21Metadata);
        Marc21Metadata marc = (Marc21Metadata) o;
        assertTrue(marc.getLeader().getValue().equals("     nam  2200000 u 4500"));
        assertTrue(marc.getControlFields().size() == 4);
        assertTrue(marc.getDataFields().size() == 5);
        for (Datafield df : marc.getDataFields()) {
            assertNotNull(df.getTag());
            assertTrue(df.getTag().length() > 0);
            assertNotNull(df.getSubfields());
            assertTrue(df.getSubfields().size() > 0);
            for (SubField sf : df.getSubfields()) {
                assertNotNull(sf.getValue());
                assertTrue(sf.getValue().length() > 0);
            }
        }
    }

}
