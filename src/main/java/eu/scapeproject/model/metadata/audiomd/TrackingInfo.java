package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trackinginfo", namespace = "http://www.loc.gov/AMD/")
public class TrackingInfo {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name = "trackingtype", namespace = "http://www.loc.gov/AMD/")
    private final List<String> trackingTypes;
    @XmlElement(name = "trackingvalue", namespace = "http://www.loc.gov/AMD/")
    private final List<String> trackingValues;

    @SuppressWarnings("unused")
    private TrackingInfo() {
        super();
        this.id=null;
        this.trackingTypes=null;
        this.trackingValues=null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((trackingTypes == null) ? 0 : trackingTypes.hashCode());
        result = prime * result + ((trackingValues == null) ? 0 : trackingValues.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TrackingInfo other = (TrackingInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (trackingTypes == null) {
            if (other.trackingTypes != null)
                return false;
        } else if (!trackingTypes.equals(other.trackingTypes))
            return false;
        if (trackingValues == null) {
            if (other.trackingValues != null)
                return false;
        } else if (!trackingValues.equals(other.trackingValues))
            return false;
        return true;
    }

}
