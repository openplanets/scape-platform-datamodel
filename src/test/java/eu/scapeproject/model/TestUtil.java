package eu.scapeproject.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.xml.bind.JAXBException;

import eu.scapeproject.util.ScapeMarshaller;

public abstract class TestUtil {

    public static final Random rand = new Random();
    public static final DateFormat dateFormatter = new SimpleDateFormat("d-M-y hh:mm:ss");

    public static IntellectualEntity createTestEntity() throws JAXBException {
        return ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class, TestUtil.class.getClassLoader().getResourceAsStream("SCAPE_entity_example.xml"));
    }

}
