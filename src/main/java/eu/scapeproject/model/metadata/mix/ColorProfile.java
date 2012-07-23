package eu.scapeproject.model.metadata.mix;

public class ColorProfile {
    private ICCProfile iccProfile;
    private LocalProfile localProfile;
    private EmbeddedProfile embeddedProfile;

    public ColorProfile(EmbeddedProfile embeddedProfile) {
        super();
        this.embeddedProfile = embeddedProfile;
    }

    public ColorProfile(ICCProfile iccProfile) {
        super();
        this.iccProfile = iccProfile;
    }

    public ColorProfile(LocalProfile localProfile) {
        super();
        this.localProfile = localProfile;
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

    public void setEmbeddedProfile(EmbeddedProfile embeddedProfile) {
        this.embeddedProfile = embeddedProfile;
    }

    public void setIccProfile(ICCProfile iccProfile) {
        this.iccProfile = iccProfile;
    }

    public void setLocalProfile(LocalProfile localProfile) {
        this.localProfile = localProfile;
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

        private String base64EncodedProfile;

        public EmbeddedProfile(String base64EncodedProfile) {
            super();
            this.base64EncodedProfile = base64EncodedProfile;
        }

        public String getBase64EncodedProfile() {
            return base64EncodedProfile;
        }
    }

    public static class ICCProfile {
        private String iccProfileName;
        private String iccProfileVersion;
        private String iccProfileUrl;

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
    }

    public static class LocalProfile {
        private String localProfileVersion;
        private String localProfileUrl;

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
    }
}
