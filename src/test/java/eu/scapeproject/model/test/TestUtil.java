package eu.scapeproject.model.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import eu.scapeproject.model.Entity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.UUIDIdentifier;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.premis.Event;

public abstract class TestUtil {

    public static final Random rand=new Random();

    public static Entity createRandomEntity() {
        return new Entity.Builder()
                .descriptive(createRandomDescriptive())
                .identifier(new UUIDIdentifier())
                .representations(createRandomRepresentations())
                .build();

    }

    private static List<Representation> createRandomRepresentations() {
        int num = rand.nextInt(4) + 1;
        List<Representation> representations = new ArrayList<Representation>();
        while (num-- > 0) {
            representations.add(createRandomRepresentation());
        }
        return representations;
    }

    private static Representation createRandomRepresentation() {
        return new Representation.Builder()
                .provenance(createRandomEvents())
                .build();
    }

    private static List<Event> createRandomEvents() {
        int num = rand.nextInt(4) + 1;
        List<Event> events = new ArrayList<Event>();
        while (num-- > 0) {
            events.add(createRandomEvent());
        }
        return events;
    }

    private static Event createRandomEvent() {
        return new Event.Builder()
                .identifier(new UUIDIdentifier())
                .build();
    }

    private static DescriptiveMetadata createRandomDescriptive() {
        return new DescriptiveMetadata.Builder()
                .title(RandomStringUtils.randomAlphabetic(16))
                .build();
    }
}
