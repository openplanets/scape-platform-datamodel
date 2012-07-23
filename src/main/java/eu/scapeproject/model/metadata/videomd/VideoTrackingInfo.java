package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trackinginfo", namespace = "http://www.loc.gov/videoMD/")
public class VideoTrackingInfo {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name = "trackingtype", namespace = "http://www.loc.gov/videoMD/")
    private String trackingType;
    @XmlElement(name = "trackingvalue", namespace = "http://www.loc.gov/videoMD/")
    private String trackingValue;

    public String getId() {
        return id;
    }

    public String getTrackingType() {
        return trackingType;
    }

    public String getTrackingValue() {
        return trackingValue;
    }
    
    @SuppressWarnings("unused")
    private VideoTrackingInfo(){
        super();
    }

    public VideoTrackingInfo(String id, String trackingType, String trackingValue) {
        super();
        this.id = id;
        this.trackingType = trackingType;
        this.trackingValue = trackingValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((trackingType == null) ? 0 : trackingType.hashCode());
        result = prime * result + ((trackingValue == null) ? 0 : trackingValue.hashCode());
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
        VideoTrackingInfo other = (VideoTrackingInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (trackingType == null) {
            if (other.trackingType != null)
                return false;
        } else if (!trackingType.equals(other.trackingType))
            return false;
        if (trackingValue == null) {
            if (other.trackingValue != null)
                return false;
        } else if (!trackingValue.equals(other.trackingValue))
            return false;
        return true;
    }
    
}
