package eu.scapeproject.model.metadata.mix;

public class ColorProfile {
    private ICCProfile iccProfile;
    private LocalProfile localProfile;
    private EmbeddedProfile embeddedProfile;
    
    public static class ICCProfile{
        private String iccProfileName;
        private String iccProfileVersion;
        private String iccProfileUrl;
    }
    public static class LocalProfile{
        private String localProfileVersion;
        private String localProfileUrl;
    }
    public static class EmbeddedProfile{
        private String base64EncodedProfile;
    }
}
