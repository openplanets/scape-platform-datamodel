package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "colorProfile",namespace="http://www.loc.gov/mix/v10")
@XmlAccessorType(XmlAccessType.FIELD)
public class ColorProfile {
    @XmlElement(name="iccProfile",namespace="http://www.loc.gov/mix/v10")
    private final ICCProfile iccProfile;
    @XmlElement(name="localProfile",namespace="http://www.loc.gov/mix/v10")
    private final LocalProfile localProfile;
    @XmlElement(name="embeddedProfile",namespace="http://www.loc.gov/mix/v10")
    private final EmbeddedProfile embeddedProfile;

    @SuppressWarnings("unused")
    private ColorProfile(){
        super();
        this.iccProfile=null;
        this.localProfile=null;
        this.embeddedProfile=null;
    }
    
    public ColorProfile(EmbeddedProfile embeddedProfile) {
        super();
        this.embeddedProfile = embeddedProfile;
        this.localProfile=null;
        this.iccProfile=null;
    }

    public ColorProfile(ICCProfile iccProfile) {
        super();
        this.iccProfile = iccProfile;
        this.localProfile=null;
        this.embeddedProfile=null;
    }

    public ColorProfile(LocalProfile localProfile) {
        super();
        this.localProfile = localProfile;
        this.iccProfile=null;
        this.embeddedProfile=null;
    }

    public EmbeddedProfile getEmbeddedProfile() {
        return embeddedProfile;
    }

    public ICCProfile getIccProfile() {
        return iccProfile;
    }

    public LocalProfile getLocalProfile() {
        return localProfile;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((embeddedProfile == null) ? 0 : embeddedProfile.hashCode());
        result = prime * result + ((iccProfile == null) ? 0 : iccProfile.hashCode());
        result = prime * result + ((localProfile == null) ? 0 : localProfile.hashCode());
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
        ColorProfile other = (ColorProfile) obj;
        if (embeddedProfile == null) {
            if (other.embeddedProfile != null)
                return false;
        } else if (!embeddedProfile.equals(other.embeddedProfile))
            return false;
        if (iccProfile == null) {
            if (other.iccProfile != null)
                return false;
        } else if (!iccProfile.equals(other.iccProfile))
            return false;
        if (localProfile == null) {
            if (other.localProfile != null)
                return false;
        } else if (!localProfile.equals(other.localProfile))
            return false;
        return true;
    }



    public static class EmbeddedProfile {
        @XmlElement(name="base64EncodedProfile",namespace="http://www.loc.gov/mix/v10")
        private String base64EncodedProfile;

        @SuppressWarnings("unused")
        private EmbeddedProfile(){
            super();
        }
        
        public EmbeddedProfile(String base64EncodedProfile) {
            super();
            this.base64EncodedProfile = base64EncodedProfile;
        }

        public String getBase64EncodedProfile() {
            return base64EncodedProfile;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((base64EncodedProfile == null) ? 0 : base64EncodedProfile.hashCode());
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
            EmbeddedProfile other = (EmbeddedProfile) obj;
            if (base64EncodedProfile == null) {
                if (other.base64EncodedProfile != null)
                    return false;
            } else if (!base64EncodedProfile.equals(other.base64EncodedProfile))
                return false;
            return true;
        }
        
    }

    public static class ICCProfile {
        @XmlElement(name="iccProfileName",namespace="http://www.loc.gov/mix/v10")
        private String iccProfileName;
        @XmlElement(name="iccProfileVersion",namespace="http://www.loc.gov/mix/v10")
        private String iccProfileVersion;
        @XmlElement(name="iccColorSpace",namespace="http://www.loc.gov/mix/v10")
        private String iccProfileUrl;

        @SuppressWarnings("unused")
        private ICCProfile(){
            super();
        }
        
        public ICCProfile(String iccProfileName, String iccProfileVersion, String iccProfileUrl) {
            super();
            this.iccProfileName = iccProfileName;
            this.iccProfileVersion = iccProfileVersion;
            this.iccProfileUrl = iccProfileUrl;
        }

        public String getIccProfileName() {
            return iccProfileName;
        }

        public String getIccProfileUrl() {
            return iccProfileUrl;
        }

        public String getIccProfileVersion() {
            return iccProfileVersion;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((iccProfileName == null) ? 0 : iccProfileName.hashCode());
            result = prime * result + ((iccProfileUrl == null) ? 0 : iccProfileUrl.hashCode());
            result = prime * result + ((iccProfileVersion == null) ? 0 : iccProfileVersion.hashCode());
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
            ICCProfile other = (ICCProfile) obj;
            if (iccProfileName == null) {
                if (other.iccProfileName != null)
                    return false;
            } else if (!iccProfileName.equals(other.iccProfileName))
                return false;
            if (iccProfileUrl == null) {
                if (other.iccProfileUrl != null)
                    return false;
            } else if (!iccProfileUrl.equals(other.iccProfileUrl))
                return false;
            if (iccProfileVersion == null) {
                if (other.iccProfileVersion != null)
                    return false;
            } else if (!iccProfileVersion.equals(other.iccProfileVersion))
                return false;
            return true;
        }
        
    }

    public static class LocalProfile {
        @XmlElement(name="localProfileVersion",namespace="http://www.loc.gov/mix/v10")
        private String localProfileVersion;
        @XmlElement(name="localProfileUrl",namespace="http://www.loc.gov/mix/v10")
        private String localProfileUrl;

        @SuppressWarnings("unused")
        private LocalProfile(){
            super();
        }
        
        public LocalProfile(String localProfileVersion, String localProfileUrl) {
            super();
            this.localProfileVersion = localProfileVersion;
            this.localProfileUrl = localProfileUrl;
        }

        public String getLocalProfileUrl() {
            return localProfileUrl;
        }

        public String getLocalProfileVersion() {
            return localProfileVersion;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((localProfileUrl == null) ? 0 : localProfileUrl.hashCode());
            result = prime * result + ((localProfileVersion == null) ? 0 : localProfileVersion.hashCode());
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
            LocalProfile other = (LocalProfile) obj;
            if (localProfileUrl == null) {
                if (other.localProfileUrl != null)
                    return false;
            } else if (!localProfileUrl.equals(other.localProfileUrl))
                return false;
            if (localProfileVersion == null) {
                if (other.localProfileVersion != null)
                    return false;
            } else if (!localProfileVersion.equals(other.localProfileVersion))
                return false;
            return true;
        }
        
    }
}
