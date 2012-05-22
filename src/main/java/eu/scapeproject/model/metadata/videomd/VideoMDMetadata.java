package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "videoMD", namespace = "http://www.loc.gov/videoMD/")
public class VideoMDMetadata extends TechnicalMetadata {
    @XmlElement(name = "videomd", namespace = "http://www.loc.gov/videoMD/")
    private Video videoMD;
    @XmlElement(name = "videosrc", namespace = "http://www.loc.gov/videoMD/")
    private Video videoSrc;

    private VideoMDMetadata(){
        super(TechnicalMetadata.MetadataType.VIDEOMD);
    }
    
    public VideoMDMetadata(Video videoMD, Video videoSrc) {
        this();
        this.videoMD = videoMD;
        this.videoSrc = videoSrc;
    }

    public Video getVideoMD() {
        return videoMD;
    }

    public Video getVideoSrc() {
        return videoSrc;
    }

}
