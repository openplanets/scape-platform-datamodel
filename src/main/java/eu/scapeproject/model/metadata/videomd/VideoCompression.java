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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoCompression other = (VideoCompression) obj;
        if (codecCreatorApp == null) {
            if (other.codecCreatorApp != null)
                return false;
        } else if (!codecCreatorApp.equals(other.codecCreatorApp))
            return false;
        if (codecCreatorAppVersion == null) {
            if (other.codecCreatorAppVersion != null)
                return false;
        } else if (!codecCreatorAppVersion.equals(other.codecCreatorAppVersion))
            return false;
        if (codecName == null) {
            if (other.codecName != null)
                return false;
        } else if (!codecName.equals(other.codecName))
            return false;
        if (codecQuality == null) {
            if (other.codecQuality != null)
                return false;
        } else if (!codecQuality.equals(other.codecQuality))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codecCreatorApp == null) ? 0 : codecCreatorApp.hashCode());
        result = prime * result + ((codecCreatorAppVersion == null) ? 0 : codecCreatorAppVersion.hashCode());
        result = prime * result + ((codecName == null) ? 0 : codecName.hashCode());
        result = prime * result + ((codecQuality == null) ? 0 : codecQuality.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
