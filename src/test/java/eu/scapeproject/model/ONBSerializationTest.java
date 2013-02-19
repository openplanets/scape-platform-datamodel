package eu.scapeproject.model;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import eu.scapeproject.model.metadata.marc.ControlField;
import eu.scapeproject.model.metadata.marc.Datafield;
import eu.scapeproject.model.metadata.marc.Leader;
import eu.scapeproject.model.metadata.marc.Marc21Metadata;
import eu.scapeproject.model.metadata.marc.SubField;
import eu.scapeproject.model.mets.SCAPEMarshaller;
import eu.scapeproject.model.util.TestUtil;

public class ONBSerializationTest {

	@Test
	public void testMarcSerialization() throws Exception{
		IntellectualEntity.Builder e = new IntellectualEntity.Builder();
		ControlField f = new ControlField.Builder()
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
			.controlFields(Arrays.asList(f))
			.leader(new Leader.Builder().name("leader1").build())
			.build();
		
		e.descriptive(rec);
		ByteArrayOutputStream sink = new ByteArrayOutputStream();
		SCAPEMarshaller.getInstance().serialize(e.build(),sink);
		IntellectualEntity copy = SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class, sink.toString());
		assertTrue(copy.getDescriptive() instanceof Marc21Metadata);
		SCAPEMarshaller.getInstance().serialize(copy,System.out);
	}
	
    @Test
    public void testDCSerialization() throws Exception {
    	IntellectualEntity e = TestUtil.createMinimalEntity();
    	SCAPEMarshaller.getInstance().serialize(e,System.out);
    }
    
    @Test
    public void testONBMetsDeserialization() throws Exception {
    	InputStream src = this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example_1.xml");
    	SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class,src);
    }

}
