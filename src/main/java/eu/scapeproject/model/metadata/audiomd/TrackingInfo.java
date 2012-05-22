package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trackinginfo", namespace = "http://www.loc.gov/AMD/")
public class TrackingInfo {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name = "trackingtype", namespace = "http://www.loc.gov/AMD/")
    private List<String> trackingTypes;
    @XmlElement(name = "trackingvalue", namespace = "http://www.loc.gov/AMD/")
    private List<String> trackingValues;

    @SuppressWarnings("unused")
    private TrackingInfo() {
        super();
    }

    public TrackingInfo(String id, List<String> trackingTypes, List<String> trackingValues) {
        super();
        this.id = id;
        this.trackingTypes = trackingTypes;
        this.trackingValues = trackingValues;
    }

    public String getId() {
        return id;
    }

    public List<String> getTrackingTypes() {
        return trackingTypes;
    }

    public List<String> getTrackingValues() {
        return trackingValues;
    }

}
