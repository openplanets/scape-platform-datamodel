package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsIdentity {
    @XmlElement(name = "tool", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private List<FitsTool> tool;
    @XmlElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private List<Version> versions;
    @XmlElement(name = "externalIdentifier", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private List<ExternalIdentifier> externalIdentifiers;
    @XmlElement(name = "format", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String format;
    @XmlElement(name = "mimetype", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String mimeType;
    @XmlElement(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolName;
    @XmlElement(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolVersion;

    private FitsIdentity() {
        super();
    }

    private FitsIdentity(Builder builder) {
        this.tool = builder.tool;
        this.versions = builder.versions;
        this.externalIdentifiers = builder.externalIdentifiers;
        this.format = builder.format;
        this.mimeType = builder.mimeType;
        this.toolName = builder.toolName;
        this.toolVersion = builder.toolVersion;
    }

    public List<ExternalIdentifier> getExternalIdentifiers() {
        return externalIdentifiers;
    }

    public String getFormat() {
        return format;
    }

    public String getMimeType() {
        return mimeType;
    }

    public List<FitsTool> getTool() {
        return tool;
    }

    public String getToolName() {
        return toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public static class Builder {
        private List<FitsTool> tool;
        private List<Version> versions;
        private List<ExternalIdentifier> externalIdentifiers;
        private String format;
        private String mimeType;
        private String toolName;
        private String toolVersion;

        public FitsIdentity build() {
            return new FitsIdentity(this);
        }

        public Builder externalIdentifiers(List<ExternalIdentifier> externalIdentifiers) {
            this.externalIdentifiers = externalIdentifiers;
            return this;
        }

        public Builder format(String format) {
            this.format = format;
            return this;
        }

        public Builder mimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }

        public Builder tool(List<FitsTool> tool) {
            this.tool = tool;
            return this;
        }

        public Builder toolName(String toolName) {
            this.toolName = toolName;
            return this;
        }

        public Builder toolVersion(String toolVersion) {
            this.toolVersion = toolVersion;
            return this;
        }

        public Builder versions(List<Version> versions) {
            this.versions = versions;
            return this;
        }
    }
}
