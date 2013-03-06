package eu.scapeproject.model;

import org.junit.Test;
import static org.junit.Assert.*; 

import eu.scapeproject.util.CopyUtil;

public class CopyTest {
    @Test
    public void testCopyIntellectualEntity() throws Exception{
        IntellectualEntity ent = TestUtil.createTestEntity();
        IntellectualEntity copy = CopyUtil.deepCopy(IntellectualEntity.class, ent);
        assertTrue(ent.getIdentifier().getValue().equals(copy.getIdentifier().getValue()));
        assertTrue(ent != copy);
        assertTrue(ent.getRepresentations().size() == copy.getRepresentations().size());
        System.out.println(ent.getDescriptive().getClass());
        assertTrue(ent.getRepresentations().get(0).getTitle().equals(copy.getRepresentations().get(0).getTitle()));
    }
}
