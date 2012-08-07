package eu.scapeproject.model;

import junit.framework.Assert;

import org.junit.Test;

import eu.scapeproject.model.test.TestUtil;
import eu.scapeproject.model.util.CopyUtil;

public class DeepCopyTest {
    @Test
    public void testDeepCopy1() throws Exception{
        IntellectualEntity e=TestUtil.createMinimalEntity();
        IntellectualEntity copy=CopyUtil.deepCopy(IntellectualEntity.class, e);
        Assert.assertEquals(e.getVersionNumber(), copy.getVersionNumber());
    }
}
