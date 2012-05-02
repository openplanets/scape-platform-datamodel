package eu.scapeproject.model.metadata.mix;

public class ColorProfile {
    private ICCProfile iccProfile;
    private LocalProfile localProfile;
    private EmbeddedProfile embeddedProfile;

    public ColorProfile(ICCProfile iccProfile) {
        super();
        this.iccProfile = iccProfile;
    }

    public ColorProfile(LocalProfile localProfile) {
        super();
        this.localProfile = localProfile;
    }

    public ColorProfile(EmbeddedProfile embeddedProfile) {
        super();
        this.embeddedProfile = embeddedProfile;
    }

    public void setIccProfile(ICCProfile iccProfile) {
        this.iccProfile = iccProfile;
    }

    public void setLocalProfile(LocalProfile localProfile) {
        this.localProfile = localProfile;
    }

    public void setEmbeddedProfile(EmbeddedProfile embeddedProfile) {
        this.embeddedProfile = embeddedProfile;
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

        public String getIccProfileVersion() {
            return iccProfileVersion;
        }

        public String getIccProfileUrl() {
            return iccProfileUrl;
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

        public String getLocalProfileVersion() {
            return localProfileVersion;
        }

        public String getLocalProfileUrl() {
            return localProfileUrl;
        }
    }

    public static class EmbeddedProfile {

        public EmbeddedProfile(String base64EncodedProfile) {
            super();
            this.base64EncodedProfile = base64EncodedProfile;
        }

        private String base64EncodedProfile;

        public String getBase64EncodedProfile() {
            return base64EncodedProfile;
        }
    }
}
