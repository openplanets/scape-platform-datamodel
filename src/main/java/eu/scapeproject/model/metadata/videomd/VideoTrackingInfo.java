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

}
