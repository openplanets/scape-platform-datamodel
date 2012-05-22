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
