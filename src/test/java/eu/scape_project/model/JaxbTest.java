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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import info.lc.xmlns.textmd_v3.TextMD;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.purl.dc.elements._1.ElementContainer;

import com.google.books.gbs.GbsType;

import eu.scape_project.model.LifecycleState.State;
import eu.scape_project.model.plan.PlanData;
import eu.scape_project.model.plan.PlanDataCollection;
import eu.scape_project.model.plan.PlanExecutionState;
import eu.scape_project.model.plan.PlanExecutionState.ExecutionState;
import eu.scape_project.model.plan.PlanExecutionStateCollection;
import eu.scape_project.model.plan.PlanLifecycleState;
import eu.scape_project.util.ScapeMarshaller;
import gov.loc.marc21.slim.RecordType;
import gov.loc.mets.MetsType;

/**
*
* @author frank asseg
*
*/
public class JaxbTest {

    @Test
    public void testONBMarc21Deserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_marc_example.xml"));
        assertTrue(o instanceof JAXBElement<?>);
        JAXBElement<RecordType> e = (JAXBElement<RecordType>) o;
        assertTrue(e.getValue() instanceof RecordType);
    }

    @Test
    public void testONBGoogleBookScanDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_gbs_example.xml"));
        assertTrue(o instanceof MetsType);
    }

    @Test
    public void testONBMETSDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        assertTrue(o instanceof MetsType);
    }

    @Test
    public void testONBMETSDeserializationTransientFiles() throws Exception {
        IntellectualEntity e = ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class, this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        for (Representation r: e.getRepresentations()) {
        	for (File f: r.getFiles()) {
        		assertTrue(f.getUri().toASCIIString().startsWith("file:/tmp/scape/aboonb/linktree/%5E2/bZ/35/07/20/01/abo/"));
        	}
        }
    }

    @Test
    public void testONBEntityDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class,
                this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        assertTrue(o instanceof IntellectualEntity);
        IntellectualEntity ent = (IntellectualEntity) o;
        assertTrue(ent.getDescriptive() instanceof RecordType);
        assertTrue(ent.getRepresentations().size() == 3);
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        m.setMarshallerProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        for (Representation r : ent.getRepresentations()) {
            assertTrue(r.getFiles().size() == 924);
            if (r.getTechnical() != null) {
                assertTrue("technical md of representation " + r.getIdentifier().getValue() + " is of type "
                        + r.getTechnical().getClass().getName(), r.getTechnical() instanceof GbsType);
                m.getJaxbMarshaller().marshal(r.getTechnical(), new ByteArrayOutputStream());
            }
            assertNotNull(r.getProvenance());
            for (File f : r.getFiles()) {
                if (f.getTechnical() != null) {
                    assertTrue("technical md of file " + f.getFilename() + " is of type " + f.getTechnical().getClass().getName(),
                            f.getTechnical() instanceof GbsType);
                    m.getJaxbMarshaller().marshal(f.getTechnical(), new ByteArrayOutputStream());
                }
                assertNotNull(f.getUri());
                assertTrue(f.getUri().toASCIIString().length() > 0);
            }
        }
    }

    @Test
    public void testEntitySerializationNoIds() throws Exception {
        BitStream bs_1 = new BitStream.Builder()
                .technical(TestUtil.createTextMDRecord())
                .build();

        File f = new File.Builder()
                .bitStreams(Arrays.asList(bs_1))
                .uri(URI.create("http://example.com/data"))
                .technical(TestUtil.createTextMDRecord())
                .build();

        Representation rep = new Representation.Builder()
                .files(Arrays.asList(f))
                .technical(TestUtil.createTextMDRecord())
                .title("Text representation")
                .provenance(TestUtil.createPremisDigiProvRecord())
                .rights(TestUtil.createPremisRightsRecord())
                .source(TestUtil.createDCSourceRecord())
                .build();

        IntellectualEntity e = new IntellectualEntity.Builder()
                .representations(Arrays.asList(rep))
                .descriptive(TestUtil.createDCRecord())
                .build();

        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();

        /* marshall to a temp file */
        java.io.File tmp = new java.io.File("target/entity-noids.xml");
        FileOutputStream sink = new FileOutputStream(tmp);
        marshaller.setMarshallerProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.serialize(e, sink);

        FileInputStream src = new FileInputStream(tmp);
        /* and create a new instance from the marshalled XML */
        IntellectualEntity des = marshaller.deserialize(IntellectualEntity.class, src);

        ElementContainer dcorig = (ElementContainer) e.getDescriptive();
        ElementContainer dcdes = (ElementContainer) des.getDescriptive();
        assertTrue("DC metadata does not match",
                dcorig.getAny().get(0).getValue().getContent().equals(dcdes.getAny().get(0).getValue().getContent()));
    }

    @Test
    public void testEntitySetSerializationDeserialization() throws Exception {
        IntellectualEntityCollection c = new IntellectualEntityCollection(Arrays.asList(TestUtil.createTestEntity("entity-1"),
                TestUtil.createTestEntity("entity-2"), TestUtil.createTestEntity("entity-3")));
        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        marshaller.serialize(c, sink);
        __IntellectualEntityCollection internal_coll = (__IntellectualEntityCollection) marshaller.deserialize(new ByteArrayInputStream(
                sink.toByteArray()));
        assertTrue(internal_coll.getMets().size() == 3);
        IntellectualEntityCollection coll = marshaller.deserialize(IntellectualEntityCollection.class,
                new ByteArrayInputStream(sink.toByteArray()));
        assertTrue(coll.getEntities().size() == 3);
    }

    @Test
    public void testEntitySerialization() throws Exception {
        BitStream bs_1 = new BitStream.Builder()
                .identifier(new Identifier("bitstream:1"))
                .technical(TestUtil.createTextMDRecord())
                .build();

        File f = new File.Builder()
                .bitStreams(Arrays.asList(bs_1))
                .identifier(new Identifier("file-1"))
                .uri(URI.create("http://example.com/data"))
                .technical(TestUtil.createTextMDRecord())
                .build();

        Representation rep = new Representation.Builder(new Identifier("representation-1"))
                .files(Arrays.asList(f))
                .technical(TestUtil.createTextMDRecord())
                .title("Text representation")
                .provenance(TestUtil.createPremisDigiProvRecord())
                .rights(TestUtil.createPremisRightsRecord())
                .source(TestUtil.createDCSourceRecord())
                .build();

        IntellectualEntity e = new IntellectualEntity.Builder()
                .identifier(new Identifier("entity-1"))
                .representations(Arrays.asList(rep))
                .descriptive(TestUtil.createDCRecord())
                .build();

        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();

        /* marshall to a temp file */
        java.io.File tmp = new java.io.File("target/entity-minimal.xml");
        FileOutputStream sink = new FileOutputStream(tmp);
        marshaller.setMarshallerProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.serialize(e, sink);

        FileInputStream src = new FileInputStream(tmp);
        /* and create a new instance from the marshalled XML */
        IntellectualEntity des = marshaller.deserialize(IntellectualEntity.class, src);

        assertTrue("Identifier does not match", e.getIdentifier().getValue().equals(des.getIdentifier().getValue()));

        ElementContainer dcorig = (ElementContainer) e.getDescriptive();
        ElementContainer dcdes = (ElementContainer) des.getDescriptive();
        assertTrue("DC metadata does not match",
                dcorig.getAny().get(0).getValue().getContent().equals(dcdes.getAny().get(0).getValue().getContent()));

        Representation rorig = e.getRepresentations().get(0);
        Representation rdes = des.getRepresentations().get(0);
        assertTrue("Representation identifier does not match", rorig.getIdentifier().getValue().equals(rdes.getIdentifier().getValue()));

        File forig = rorig.getFiles().get(0);
        File fdes = rdes.getFiles().get(0);
        assertTrue("File identifiers do not match", forig.getIdentifier().getValue().equals(fdes.getIdentifier().getValue()));
        assertNotNull("technical md does not match", fdes.getTechnical());

        BitStream bsorig = forig.getBitStreams().get(0);
        BitStream bsdes = fdes.getBitStreams().get(0);
        assertTrue("BitStream identifiers do not match", bsorig.getIdentifier().getValue().equals(bsdes.getIdentifier().getValue()));
    }

    @Test
    public void testEntityDeserializationTitleAndUsage() throws Exception {
        Representation rep = new Representation.Builder(new Identifier("representation-1"))
                .technical(TestUtil.createTextMDRecord())
                .title("Text representation")
                .provenance(TestUtil.createPremisDigiProvRecord())
                .rights(TestUtil.createPremisRightsRecord())
                .source(TestUtil.createDCSourceRecord())
                .build();

        IntellectualEntity e = new IntellectualEntity.Builder()
                .identifier(new Identifier("entity-1"))
                .representations(Arrays.asList(rep))
                .descriptive(TestUtil.createDCRecord())
                .build();

        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        marshaller.serialize(e, sink);
        IntellectualEntity des = marshaller.deserialize(IntellectualEntity.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals("Title does not match on representation", rep.getTitle(), des.getRepresentations().get(0).getTitle());
    }

    @Test
    public void testEntityDeserialization() throws Exception {
        Object o = ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class,
                this.getClass().getClassLoader().getResourceAsStream("entity-minimal.xml"));
        assertTrue(o instanceof IntellectualEntity);
        IntellectualEntity e = (IntellectualEntity) o;
        assertTrue(e.getRepresentations().size() == 1);
        Representation r = e.getRepresentations().get(0);
        assertTrue(r.getFiles().size() == 1);
    }

    @Test
    public void testSerializeLifecycle() throws Exception {
        ScapeMarshaller marshaller = ScapeMarshaller.newInstance();
        LifecycleState state = new LifecycleState("updated by system", State.INGESTING);
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        marshaller.serialize(state, sink);
        LifecycleState des = (LifecycleState) marshaller.deserialize(new ByteArrayInputStream(sink.toByteArray()));
    }

    @Test
    public void testSerializeRepresentation() throws Exception {
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        Representation r = TestUtil.createTestEntity("entity-4").getRepresentations().get(0);
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(r, sink);
        assertTrue(sink.toString().length() > 0);
    }

    @Test
    public void testDeserializeRepresentation() throws Exception {
        ScapeMarshaller m = ScapeMarshaller.newInstance();

        Representation r = new Representation.Builder()
            .identifier(new Identifier("rep-1"))
            .technical(TestUtil.createTextMDRecord())
            .source(TestUtil.createDCSourceRecord())
            .provenance(TestUtil.createPremisDigiProvRecord())
            .rights(TestUtil.createPremisRightsRecord())
            .build();

        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(r, sink);
        Representation deserialized = m.deserialize(Representation.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals("Ids do not match", r.getIdentifier().getValue(), deserialized.getIdentifier().getValue());
        assertTrue(sink.toString().length() > 0);
        assertNotNull(deserialized.getTechnical());
        assertNotNull(deserialized.getSource());
        assertNotNull(deserialized.getRights());
        assertNotNull(deserialized.getProvenance());

        assertEquals(TextMD.class, deserialized.getTechnical().getClass());
        assertEquals(ElementContainer.class, deserialized.getSource().getClass());
        assertEquals(JAXBElement.class, deserialized.getRights().getClass());
        assertEquals(JAXBElement.class, deserialized.getProvenance().getClass());
    }

    @Test
    public void testSerializeTextMD() throws Exception {
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        Object o = TestUtil.createTextMDRecord();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(o, sink);
        assertTrue(sink.toString().length() > 0);
    }

    @Test
    public void testSerializeVersionList() throws Exception {
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        Object o = TestUtil.createVersionList();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(o, sink);
        assertTrue(sink.toString().length() > 0);
    }

    @Test
    public void testAlternativeIds() throws Exception {
        List<Identifier> altIds = new ArrayList<Identifier>();
        altIds.add(new Identifier("alt-1"));
        altIds.add(new Identifier("alt-2"));
        altIds.add(new Identifier("alt-3"));
        altIds.add(new Identifier("alt-4"));
        altIds.add(new Identifier("alt-5"));

        IntellectualEntity e = new IntellectualEntity.Builder()
                .alternativeIdentifiers(altIds)
                .build();

        ScapeMarshaller m = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(e, sink);

        IntellectualEntity des = m.deserialize(IntellectualEntity.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals(5, des.getAlternativeIdentifiers().size());
    }

    @Test
    public void testPlanExecutionStateDeserialization() throws Exception {
        PlanExecutionState state = new PlanExecutionState(new Date(),eu.scape_project.model.plan.PlanExecutionState.ExecutionState.EXECUTION_SUCCESS);
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(state, sink);
        PlanExecutionState des = m.deserialize(PlanExecutionState.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals(state.getTimeStamp(), des.getTimeStamp());
        assertEquals(state.getState(), des.getState());
    }

    @Test
    public void testPlanExecutionStateCollectionDeserialization() throws Exception {
        List<PlanExecutionState> states = new ArrayList<PlanExecutionState>();
        states.add(new PlanExecutionState(new Date(),eu.scape_project.model.plan.PlanExecutionState.ExecutionState.EXECUTION_FAIL));
        states.add(new PlanExecutionState(new Date(),eu.scape_project.model.plan.PlanExecutionState.ExecutionState.EXECUTION_IN_PROGRESS));
        states.add(new PlanExecutionState(new Date(),eu.scape_project.model.plan.PlanExecutionState.ExecutionState.EXECUTION_SUCCESS));

        PlanExecutionStateCollection coll = new PlanExecutionStateCollection("http://localhost:8080/rest/objects/plans/plan-1",states);

        ScapeMarshaller m = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(coll, sink);
        PlanExecutionStateCollection des = m.deserialize(PlanExecutionStateCollection.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals(coll.getExecutionStates().size(), des.getExecutionStates().size());
    }

    @Test
    public void testPlanDataSerialization() throws Exception {
        SortedSet<PlanExecutionState> states = new TreeSet<PlanExecutionState>();
        states.add(new PlanExecutionState(new Date(), ExecutionState.EXECUTION_SUCCESS));
        states.add(new PlanExecutionState(new Date(), ExecutionState.EXECUTION_FAIL));
        PlanData data = new PlanData.Builder()
            .description("A unit test plan")
            .identifier(new Identifier("plan-1"))
            .title("Unit test plan 1")
            .lifecycleState(new PlanLifecycleState(eu.scape_project.model.plan.PlanLifecycleState.PlanState.ENABLED, "created"))
            .executionStates(states)
            .build();
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(data, sink);
        PlanData deserialized = m.deserialize(PlanData.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals(data.getIdentifier().getValue(), deserialized.getIdentifier().getValue());
        assertEquals(data.getDescription(), deserialized.getDescription());
        assertEquals(data.getExecutionStates().size(), deserialized.getExecutionStates().size());
        assertEquals(data.getLifecycleState().getState(), deserialized.getLifecycleState().getState());
        assertEquals(data.getTitle(), deserialized.getTitle());
    }

    @Test
    public void testPlanDataCollectionSerialization() throws Exception {
        SortedSet<PlanExecutionState> states = new TreeSet<PlanExecutionState>();
        states.add(new PlanExecutionState(new Date(), ExecutionState.EXECUTION_SUCCESS));
        states.add(new PlanExecutionState(new Date(), ExecutionState.EXECUTION_FAIL));
        PlanData data = new PlanData.Builder()
            .description("A unit test plan")
            .identifier(new Identifier("plan-1"))
            .title("Unit test plan 1")
            .lifecycleState(new PlanLifecycleState(eu.scape_project.model.plan.PlanLifecycleState.PlanState.ENABLED, "created"))
            .executionStates(states)
            .build();
        PlanDataCollection coll = new PlanDataCollection(Arrays.asList(data));
        ScapeMarshaller m = ScapeMarshaller.newInstance();
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        m.serialize(coll, sink);
        PlanDataCollection deserialized = m.deserialize(PlanDataCollection.class, new ByteArrayInputStream(sink.toByteArray()));
        assertEquals(1, deserialized.getPlanData().size());
    }
}
