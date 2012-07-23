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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataRate == null) ? 0 : dataRate.hashCode());
        result = prime * result + ((duration == null) ? 0 : duration.hashCode());
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((otherUses == null) ? 0 : otherUses.hashCode());
        result = prime * result + ((security == null) ? 0 : security.hashCode());
        result = prime * result + size;
        result = prime * result + ((timeCodes == null) ? 0 : timeCodes.hashCode());
        result = prime * result + ((trackingInfos == null) ? 0 : trackingInfos.hashCode());
        result = prime * result + ((uses == null) ? 0 : uses.hashCode());
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
        MediaDataType other = (MediaDataType) obj;
        if (dataRate == null) {
            if (other.dataRate != null)
                return false;
        } else if (!dataRate.equals(other.dataRate))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (otherUses == null) {
            if (other.otherUses != null)
                return false;
        } else if (!otherUses.equals(other.otherUses))
            return false;
        if (security == null) {
            if (other.security != null)
                return false;
        } else if (!security.equals(other.security))
            return false;
        if (size != other.size)
            return false;
        if (timeCodes == null) {
            if (other.timeCodes != null)
                return false;
        } else if (!timeCodes.equals(other.timeCodes))
            return false;
        if (trackingInfos == null) {
            if (other.trackingInfos != null)
                return false;
        } else if (!trackingInfos.equals(other.trackingInfos))
            return false;
        if (uses == null) {
            if (other.uses != null)
                return false;
        } else if (!uses.equals(other.uses))
            return false;
        return true;
    }
    
    
}
