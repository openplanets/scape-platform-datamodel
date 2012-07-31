package eu.scapeproject.model.metadata.videomd;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "language", namespace = "http://www.loc.gov/videoMD/")
public class VideoLanguage {
    public static VideoLanguage fromString(String lang) {
        if (lang.length() > 3) {
            return new VideoLanguage(lang.substring(0, 3).toCharArray());
        } else {
            return new VideoLanguage(lang.toCharArray());
        }
    }

    @XmlValue
    private final char[] language;

    private VideoLanguage() {
        super();
        language=null;
    }

    private VideoLanguage(char[] language) {
        super();
        this.language = language;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoLanguage other = (VideoLanguage) obj;
        if (!Arrays.equals(language, other.language))
            return false;
        return true;
    }

    public char[] getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(language);
        return result;
    }
    
    
}
