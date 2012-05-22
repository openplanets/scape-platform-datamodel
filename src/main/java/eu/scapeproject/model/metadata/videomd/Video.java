package eu.scapeproject.model.metadata.videomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "videomd", namespace = "http://www.loc.gov/videoMD/")
public class Video {
    @XmlElement(name = "filedata", namespace = "http://www.loc.gov/videoMD/")
    private List<VideoFileData> filedata;

    public List<VideoFileData> getFiledata() {
        return filedata;
    }

    @SuppressWarnings("unused")
    private Video() {
        super();
    }
    public Video(List<VideoFileData> filedata) {
        super();
        this.filedata = filedata;
    }

}
