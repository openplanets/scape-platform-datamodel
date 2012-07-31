package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="format",namespace="http://www.loc.gov/videoMD/")
public class VideoFormat {
    @XmlElement(name="annotation",namespace="http://www.loc.gov/videoMD/")
    private final String annotation;
    @XmlElement(name="creatorapp",namespace="http://www.loc.gov/videoMD/")
    private final String creatorApp;
    @XmlElement(name="creatorlib",namespace="http://www.loc.gov/videoMD/")
    private String creatorLib;
    @XmlElement(name="creatorlibdate",namespace="http://www.loc.gov/videoMD/")
    private final String creatorLibDate;
    @XmlElement(name="creatorlibsettings",namespace="http://www.loc.gov/videoMD/")
    private final String creatorLibSettings;
    @XmlElement(name="name",namespace="http://www.loc.gov/videoMD/")
    private final String name;
    @XmlElement(name="encodingdate",namespace="http://www.loc.gov/videoMD/")
    private final String encodingDate;
    @XmlElement(name="taggeddate",namespace="http://www.loc.gov/videoMD/")
    private final String taggedDate;
    @XmlElement(name="commercialname",namespace="http://www.loc.gov/videoMD/")
    private final String commercialName;
    @XmlElement(name="mimetype",namespace="http://www.loc.gov/videoMD/")
    private final String mimeType;
    @XmlElement(name="profile",namespace="http://www.loc.gov/videoMD/")
    private final String profile;
    @XmlElement(name="settings",namespace="http://www.loc.gov/videoMD/")
    private final String settings;
    @XmlElement(name="version",namespace="http://www.loc.gov/videoMD/")
    private final String version;

    protected VideoFormat(){
        super();
        this.annotation = null;
        this.creatorApp = null;
        this.creatorLib = null;
        this.creatorLibDate = null;
        this.creatorLibSettings = null;
        this.name = null;
        this.encodingDate = null;
        this.taggedDate = null;
        this.commercialName = null;
        this.mimeType = null;
        this.profile = null;
        this.settings = null;
        this.version = null;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoFormat other = (VideoFormat) obj;
        if (annotation == null) {
            if (other.annotation != null)
                return false;
        } else if (!annotation.equals(other.annotation))
            return false;
        if (commercialName == null) {
            if (other.commercialName != null)
                return false;
        } else if (!commercialName.equals(other.commercialName))
            return false;
        if (creatorApp == null) {
            if (other.creatorApp != null)
                return false;
        } else if (!creatorApp.equals(other.creatorApp))
            return false;
        if (creatorLib == null) {
            if (other.creatorLib != null)
                return false;
        } else if (!creatorLib.equals(other.creatorLib))
            return false;
        if (creatorLibDate == null) {
            if (other.creatorLibDate != null)
                return false;
        } else if (!creatorLibDate.equals(other.creatorLibDate))
            return false;
        if (creatorLibSettings == null) {
            if (other.creatorLibSettings != null)
                return false;
        } else if (!creatorLibSettings.equals(other.creatorLibSettings))
            return false;
        if (encodingDate == null) {
            if (other.encodingDate != null)
                return false;
        } else if (!encodingDate.equals(other.encodingDate))
            return false;
        if (mimeType == null) {
            if (other.mimeType != null)
                return false;
        } else if (!mimeType.equals(other.mimeType))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (profile == null) {
            if (other.profile != null)
                return false;
        } else if (!profile.equals(other.profile))
            return false;
        if (settings == null) {
            if (other.settings != null)
                return false;
        } else if (!settings.equals(other.settings))
            return false;
        if (taggedDate == null) {
            if (other.taggedDate != null)
                return false;
        } else if (!taggedDate.equals(other.taggedDate))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((annotation == null) ? 0 : annotation.hashCode());
        result = prime * result + ((commercialName == null) ? 0 : commercialName.hashCode());
        result = prime * result + ((creatorApp == null) ? 0 : creatorApp.hashCode());
        result = prime * result + ((creatorLib == null) ? 0 : creatorLib.hashCode());
        result = prime * result + ((creatorLibDate == null) ? 0 : creatorLibDate.hashCode());
        result = prime * result + ((creatorLibSettings == null) ? 0 : creatorLibSettings.hashCode());
        result = prime * result + ((encodingDate == null) ? 0 : encodingDate.hashCode());
        result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((profile == null) ? 0 : profile.hashCode());
        result = prime * result + ((settings == null) ? 0 : settings.hashCode());
        result = prime * result + ((taggedDate == null) ? 0 : taggedDate.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
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
