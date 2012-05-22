package eu.scapeproject.model.metadata.videomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mediadata", namespace = "http://www.loc.gov/videoMD/")
public abstract class MediaDataType {
    @XmlElement(name = "trackinginfo", namespace = "http://www.loc.gov/videoMD/")
    protected List<VideoTrackingInfo> trackingInfos;
    @XmlElement(name = "duration", namespace = "http://www.loc.gov/videoMD/")
    protected String duration;
    @XmlElement(name = "language", namespace = "http://www.loc.gov/videoMD/")
    protected List<VideoLanguage> language;
    @XmlElement(name = "security", namespace = "http://www.loc.gov/videoMD/")
    protected String security;
    @XmlElement(name = "size", namespace = "http://www.loc.gov/videoMD/")
    protected int size;
    @XmlElement(name = "datarate", namespace = "http://www.loc.gov/videoMD/")
    protected VideoVariableRate dataRate;
    @XmlElement(name = "timecode", namespace = "http://www.loc.gov/videoMD/")
    protected List<VideoTimeCode> timeCodes;
    @XmlElement(name = "use", namespace = "http://www.loc.gov/videoMD/")
    protected List<String> uses;
    @XmlElement(name = "otheruse", namespace = "http://www.loc.gov/videoMD/")
    protected List<String> otherUses;

    public List<VideoTrackingInfo> getTrackingInfos() {
        return trackingInfos;
    }

    public String getDuration() {
        return duration;
    }

    public List<VideoLanguage> getLanguage() {
        return language;
    }

    public String getSecurity() {
        return security;
    }

    public int getSize() {
        return size;
    }

    public VideoVariableRate getDataRate() {
        return dataRate;
    }

    public List<VideoTimeCode> getTimeCodes() {
        return timeCodes;
    }

    public List<String> getUses() {
        return uses;
    }

    public List<String> getOtherUses() {
        return otherUses;
    }
}
