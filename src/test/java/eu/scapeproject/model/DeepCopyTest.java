package eu.scapeproject.model;

import junit.framework.Assert;

import org.junit.Test;

import eu.scapeproject.model.util.CopyUtil;
import eu.scapeproject.model.util.TestUtil;

public class DeepCopyTest {
    @Test
    public void testDeepCopyIntellectualMinimalEntity() throws Exception{
        IntellectualEntity e=TestUtil.createMinimalEntity();
        IntellectualEntity copy=CopyUtil.deepCopy(IntellectualEntity.class, e);
        Assert.assertEquals(e.getVersionNumber(), copy.getVersionNumber());
        Assert.assertEquals(e, copy);
    }
    @Test
    public void testDeepCopyIntellectualEntity() throws Exception{
        IntellectualEntity e=TestUtil.createRandomEntity();
        IntellectualEntity copy=CopyUtil.deepCopy(IntellectualEntity.class, e);
        Assert.assertEquals(e.getVersionNumber(), copy.getVersionNumber());
        Assert.assertEquals(e, copy);
    }
}
