package eu.scapeproject.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import eu.scapeproject.dto.mets.MetsDocument;
import eu.scapeproject.model.IntellectualEntity.Builder;
import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.marc.ControlField;
import eu.scapeproject.model.metadata.marc.Leader;
import eu.scapeproject.model.metadata.marc.Marc21Record;
import eu.scapeproject.model.mets.SCAPEMarshaller;
import eu.scapeproject.model.util.MetsUtil;

public class ONBMetsSerializationtest {

	// this test still fails
	// work on deserialization of ONB mets data is a work in progress
	// still need ok to publish test file on github
	@Test
	// (expected=Exception.class)
	public void testDeserializeEntity1() throws Exception {
		InputStream src = this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example_1.xml");
		java.io.File normFile = new java.io.File("target/ONB_mets_example_1_normalized.xml");
		OutputStream sink = new FileOutputStream(normFile);
		MetsUtil.normalizeONBXml(src, sink);
		src.close();
		sink.close();

		src = new FileInputStream(normFile);
		IntellectualEntity entity = SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class, src);
		src.close();
	}

	@Test
	public void testNormalizeXML() throws Exception {
		InputStream src = this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example_1.xml");
		MetsUtil.normalizeONBXml(src, new FileOutputStream("target/test_ONB_out_normalized.xml"));
	}

	@Test
	public void serializeMarc21Record() throws Exception {
		List<ControlField> fields = new ArrayList<ControlField>();
		fields.add(new ControlField.Builder().value("ahan").build());
		DescriptiveMetadata rec = new Marc21Record.Builder()
				.leader(new Leader.Builder().value("odod").build())
				.controlFields(fields)
				.build();
		JAXBContext ctx = JAXBContext.newInstance(DescriptiveMetadata.class);
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
		m.marshal(rec, System.out);
	}

	@Test
	public void deserializeMarc21Record() throws Exception {
		InputStream src = this.getClass().getClassLoader().getResourceAsStream("marc21_record.xml");
		JAXBContext ctx = JAXBContext.newInstance(DescriptiveMetadata.class);
		Unmarshaller unm = ctx.createUnmarshaller();
		Object o = unm.unmarshal(src);
		assertNotNull(o);
		assertTrue(o instanceof Marc21Record);

		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
		m.marshal(o, System.out);
	}

	@Test
	public void deserializeDCRecord() throws Exception {
		InputStream src = this.getClass().getClassLoader().getResourceAsStream("dc_record.xml");
		JAXBContext ctx = JAXBContext.newInstance(DescriptiveMetadata.class);
		Unmarshaller unm = ctx.createUnmarshaller();
		Object o = unm.unmarshal(src);
		assertNotNull(o);
		assertTrue(o instanceof DCMetadata);

		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
		m.marshal(o, System.out);
	}

}
