package eu.scapeproject.model;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBElement;

import org.junit.Test;

import eu.scapeproject.util.ScapeMarshaller;
import gov.loc.marc21.slim.RecordType;
import gov.loc.mets.MetsType;

public class JaxbTests {

    @Test
    public void testONBMarc21Deserialization() throws Exception{
        Object o = ScapeMarshaller.getInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_marc_example.xml"));
        assertTrue(o instanceof JAXBElement<?>);
        JAXBElement<RecordType> e = (JAXBElement<RecordType>) o;
        assertTrue(e.getValue() instanceof RecordType);
    }
    @Test
    public void testONBGoogleBookScanDeserialization() throws Exception{
        Object o = ScapeMarshaller.getInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_gbs_example.xml"));
        assertTrue(o instanceof MetsType);
    }
    @Test
    public void testONBMETSDeserialization() throws Exception{
        Object o = ScapeMarshaller.getInstance().deserialize(this.getClass().getClassLoader().getResourceAsStream("ONB_mets_example.xml"));
        assertTrue(o instanceof MetsType);
    }

}
