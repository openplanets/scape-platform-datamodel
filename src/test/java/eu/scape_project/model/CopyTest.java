/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.model;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import eu.scape_project.util.CopyUtil;

/**
*
* @author frank asseg
*
*/
public class CopyTest {
    @Test
    public void testCopyIntellectualEntity() throws Exception{
        IntellectualEntity ent = TestUtil.createTestEntity(UUID.randomUUID().toString());
        IntellectualEntity copy = CopyUtil.deepCopy(IntellectualEntity.class, ent);
        assertTrue(ent.getIdentifier().getValue().equals(copy.getIdentifier().getValue()));
        assertTrue(ent != copy);
        assertTrue(ent.getRepresentations().size() == copy.getRepresentations().size());
        assertTrue(ent.getRepresentations().get(0).getIdentifier().getValue().equals(copy.getRepresentations().get(0).getIdentifier().getValue()));
    }
}
