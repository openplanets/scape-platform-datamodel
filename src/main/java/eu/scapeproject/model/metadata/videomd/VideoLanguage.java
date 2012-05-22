package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "language", namespace = "http://www.loc.gov/videoMD/")
public class VideoLanguage {
    @XmlValue
    private char[] language;

    private VideoLanguage() {
        super();
    }

    private VideoLanguage(char[] language) {
        super();
        this.language = language;
    }

    public char[] getLanguage() {
        return language;
    }

    public static VideoLanguage fromString(String lang) {
        if (lang.length() > 3) {
            return new VideoLanguage(lang.substring(0, 3).toCharArray());
        } else {
            return new VideoLanguage(lang.toCharArray());
        }
    }
}
