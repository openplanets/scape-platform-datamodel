package eu.scapeproject.model;

import static eu.scapeproject.model.test.ValidationUtil.validateDescriptiveMetadata;
import static eu.scapeproject.model.test.ValidationUtil.validateRightsRecord;
import static eu.scapeproject.model.test.ValidationUtil.validateTechMDRecord;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import eu.scapeproject.model.util.TestUtil;

public class ModelBuilderTest {

    @Test
    public void testEntity() {
        IntellectualEntity e=TestUtil.createRandomEntity();
        assertNotNull(e);
        validateDescriptiveMetadata(e.getDescriptive());
        for (Representation r:e.getRepresentations()){
            assertNotNull(r.getFiles());
            assertNotNull(r.getProvenance());
            validateDescriptiveMetadata(r.getSource());
            validateTechMDRecord(r.getTechnical());
            validateRightsRecord(r.getRights());
        }
        assertNotNull(e.getIdentifier());
        assertNotNull(e.getRepresentations());
    }


}
