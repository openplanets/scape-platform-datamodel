package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.ProvenanceMetadata;

@XmlRootElement(name = "digiprovMD", namespace = "http://www.loc.gov/standards/premis")
public class PremisProvenanceMetadata extends ProvenanceMetadata {
    @XmlElement(name = "event",namespace="http://www.loc.gov/standards/premis")
    private List<Event> events;

    private PremisProvenanceMetadata() {
        super("premis");
    }

    public PremisProvenanceMetadata(List<Event> events) {
        super("premis");
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
}
