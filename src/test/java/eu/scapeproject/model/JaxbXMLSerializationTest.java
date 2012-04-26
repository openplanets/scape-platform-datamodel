package eu.scapeproject.model;

import org.junit.Test;

import eu.scapeproject.model.mets.MetsFactory;
import eu.scapeproject.model.test.TestUtil;

public class JaxbXMLSerializationTest {
    @Test
    public void testEntitySerialization1() throws Exception{
        IntellectualEntity entity=TestUtil.createRandomEntity();
        MetsFactory.getInstance().serialize(entity, System.out);
    }
}
