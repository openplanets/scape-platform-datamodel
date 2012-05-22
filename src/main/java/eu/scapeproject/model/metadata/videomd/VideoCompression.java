package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="compression",namespace="http://www.loc.gov/videoMD/")
public class VideoCompression {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name="codeccreatorapp",namespace="http://www.loc.gov/videoMD/")
    private String codecCreatorApp;
    @XmlElement(name="codeccreatorappversion",namespace="http://www.loc.gov/videoMD/")
    private String codecCreatorAppVersion;
    @XmlElement(name="codecname",namespace="http://www.loc.gov/videoMD/")
    private String codecName;
    @XmlElement(name="codecquality",namespace="http://www.loc.gov/videoMD/")
    private String codecQuality;

    private VideoCompression() {
        super();
    }

    private VideoCompression(Builder builder) {
        this.id = builder.id;
        this.codecCreatorApp = builder.codecCreatorApp;
        this.codecCreatorAppVersion = builder.codecCreatorAppVersion;
        this.codecName = builder.codecName;
        this.codecQuality = builder.codecQuality;
    }

    public String getCodecCreatorApp() {
        return codecCreatorApp;
    }

    public String getCodecCreatorAppVersion() {
        return codecCreatorAppVersion;
    }

    public String getCodecName() {
        return codecName;
    }

    public String getCodecQuality() {
        return codecQuality;
    }

    public String getId() {
        return id;
    }

    public static class Builder {
        private String id;
        private String codecCreatorApp;
        private String codecCreatorAppVersion;
        private String codecName;
        private String codecQuality;

        public VideoCompression build() {
            return new VideoCompression(this);
        }

        public Builder codecCreatorApp(String codecCreatorApp) {
            this.codecCreatorApp = codecCreatorApp;
            return this;
        }

        public Builder codecCreatorAppVersion(String codecCreatorAppVersion) {
            this.codecCreatorAppVersion = codecCreatorAppVersion;
            return this;
        }

        public Builder codecName(String codecName) {
            this.codecName = codecName;
            return this;
        }

        public Builder codecQuality(String codecQuality) {
            this.codecQuality = codecQuality;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }
    }
}
