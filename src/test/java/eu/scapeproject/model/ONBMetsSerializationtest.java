package eu.scapeproject.model;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import eu.scapeproject.model.mets.SCAPEMarshaller;

public class ONBMetsSerializationtest {

	// this test still fails
	// work on deserialization of ONB mets data is a work in progress
	@Test(expected=Exception.class)
	public void testDeserializeEntity1() throws Exception{
		InputStream src = this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example_1.xml");
		IntellectualEntity entity = SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class,src);
		src.close();
	}

}
