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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filedata == null) ? 0 : filedata.hashCode());
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
        Video other = (Video) obj;
        if (filedata == null) {
            if (other.filedata != null)
                return false;
        } else if (!filedata.equals(other.filedata))
            return false;
        return true;
    }

}
