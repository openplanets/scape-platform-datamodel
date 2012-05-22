package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="format",namespace="http://www.loc.gov/videoMD/")
public class VideoFormat {
    @XmlElement(name="annotation",namespace="http://www.loc.gov/videoMD/")
    private String annotation;
    @XmlElement(name="creatorapp",namespace="http://www.loc.gov/videoMD/")
    private String creatorApp;
    @XmlElement(name="creatorlib",namespace="http://www.loc.gov/videoMD/")
    private String creatorLib;
    @XmlElement(name="creatorlibdate",namespace="http://www.loc.gov/videoMD/")
    private String creatorLibDate;
    @XmlElement(name="creatorlibsettings",namespace="http://www.loc.gov/videoMD/")
    private String creatorLibSettings;
    @XmlElement(name="name",namespace="http://www.loc.gov/videoMD/")
    private String name;
    @XmlElement(name="encodingdate",namespace="http://www.loc.gov/videoMD/")
    private String encodingDate;
    @XmlElement(name="taggeddate",namespace="http://www.loc.gov/videoMD/")
    private String taggedDate;
    @XmlElement(name="commercialname",namespace="http://www.loc.gov/videoMD/")
    private String commercialName;
    @XmlElement(name="mimetype",namespace="http://www.loc.gov/videoMD/")
    private String mimeType;
    @XmlElement(name="profile",namespace="http://www.loc.gov/videoMD/")
    private String profile;
    @XmlElement(name="settings",namespace="http://www.loc.gov/videoMD/")
    private String settings;
    @XmlElement(name="version",namespace="http://www.loc.gov/videoMD/")
    private String version;

    protected VideoFormat(){
        super();
    }
    
    private VideoFormat(Builder builder) {
        this.annotation = builder.annotation;
        this.creatorApp = builder.creatorApp;
        this.creatorLib = builder.creatorLib;
        this.creatorLibDate = builder.creatorLibDate;
        this.creatorLibSettings = builder.creatorLibSettings;
        this.name = builder.name;
        this.encodingDate = builder.encodingDate;
        this.taggedDate = builder.taggedDate;
        this.commercialName = builder.commercialName;
        this.mimeType = builder.mimeType;
        this.profile = builder.profile;
        this.settings = builder.settings;
        this.version = builder.version;
    }

    public String getAnnotation() {
        return annotation;
    }

    public String getCommercialName() {
        return commercialName;
    }

    public String getCreatorApp() {
        return creatorApp;
    }

    public String getCreatorLib() {
        return creatorLib;
    }

    public String getCreatorLibDate() {
        return creatorLibDate;
    }

    public String getCreatorLibSettings() {
        return creatorLibSettings;
    }

    public String getEncodingDate() {
        return encodingDate;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        return profile;
    }

    public String getSettings() {
        return settings;
    }

    public String getTaggedDate() {
        return taggedDate;
    }

    public String getVersion() {
        return version;
    }

    public static class Builder {
        private String annotation;
        private String creatorApp;
        private String creatorLib;
        private String creatorLibDate;
        private String creatorLibSettings;
        private String name;
        private String encodingDate;
        private String taggedDate;
        private String commercialName;
        private String mimeType;
        private String profile;
        private String settings;
        private String version;

        public Builder annotation(String annotation) {
            this.annotation = annotation;
            return this;
        }

        public VideoFormat build() {
            return new VideoFormat(this);
        }

        public Builder commercialName(String commercialName) {
            this.commercialName = commercialName;
            return this;
        }

        public Builder creatorApp(String creatorApp) {
            this.creatorApp = creatorApp;
            return this;
        }

        public Builder creatorLib(String creatorLib) {
            this.creatorLib = creatorLib;
            return this;
        }

        public Builder creatorLibDate(String creatorLibDate) {
            this.creatorLibDate = creatorLibDate;
            return this;
        }

        public Builder creatorLibSettings(String creatorLibSettings) {
            this.creatorLibSettings = creatorLibSettings;
            return this;
        }

        public Builder encodingDate(String encodingDate) {
            this.encodingDate = encodingDate;
            return this;
        }

        public Builder mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder profile(String profile) {
            this.profile = profile;
            return this;
        }

        public Builder settings(String settings) {
            this.settings = settings;
            return this;
        }

        public Builder taggedDate(String taggedDate) {
            this.taggedDate = taggedDate;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }
    }
}
