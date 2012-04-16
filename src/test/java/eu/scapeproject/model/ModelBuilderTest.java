package eu.scapeproject.model;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.premis.Event;
import eu.scapeproject.model.test.TestUtil;

public class ModelBuilderTest {

    @Test
    public void testEntity() {
        Entity e=TestUtil.createRandomEntity();
        assertNotNull(e);
        assertNotNull(e.getDescriptive());
        assertNotNull(e.getIdentifier());
        assertNotNull(e.getRepresentations());
    }

}
