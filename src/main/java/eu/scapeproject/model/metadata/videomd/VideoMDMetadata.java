package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "videoMD", namespace = "http://www.loc.gov/videoMD/")
public class VideoMDMetadata extends TechnicalMetadata {
    @XmlElement(name = "videomd", namespace = "http://www.loc.gov/videoMD/")
    private final Video videoMD;
    @XmlElement(name = "videosrc", namespace = "http://www.loc.gov/videoMD/")
    private final Video videoSrc;

    private VideoMDMetadata(){
        super(MetadataType.VIDEOMD);
        this.videoMD=null;
        this.videoSrc=null;
    }
    
    public VideoMDMetadata(Video videoMD, Video videoSrc) {
        super(MetadataType.VIDEOMD);
        this.videoMD = videoMD;
        this.videoSrc = videoSrc;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoMDMetadata other = (VideoMDMetadata) obj;
        if (videoMD == null) {
            if (other.videoMD != null)
                return false;
        } else if (!videoMD.equals(other.videoMD))
            return false;
        if (videoSrc == null) {
            if (other.videoSrc != null)
                return false;
        } else if (!videoSrc.equals(other.videoSrc))
            return false;
        return true;
    }

    public Video getVideoMD() {
        return videoMD;
    }

    public Video getVideoSrc() {
        return videoSrc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((videoMD == null) ? 0 : videoMD.hashCode());
        result = prime * result + ((videoSrc == null) ? 0 : videoSrc.hashCode());
        return result;
    }

}
