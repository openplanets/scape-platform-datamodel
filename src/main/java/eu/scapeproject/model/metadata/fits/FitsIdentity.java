package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsIdentity {
    @XmlElement(name = "tool", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final List<FitsTool> tool;
    @XmlElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final List<Version> versions;
    @XmlElement(name = "externalIdentifier", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final List<ExternalIdentifier> externalIdentifiers;
    @XmlElement(name = "format", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String format;
    @XmlElement(name = "mimetype", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String mimeType;
    @XmlElement(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolName;
    @XmlElement(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolVersion;

    private FitsIdentity() {
    	super();
    	this.externalIdentifiers=null;
    	this.mimeType=null;
    	this.format=null;
    	this.tool=null;
    	this.toolName=null;
    	this.toolVersion=null;
    	this.versions=null;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FitsIdentity other = (FitsIdentity) obj;
        if (externalIdentifiers == null) {
            if (other.externalIdentifiers != null)
                return false;
        } else if (!externalIdentifiers.equals(other.externalIdentifiers))
            return false;
        if (format == null) {
            if (other.format != null)
                return false;
        } else if (!format.equals(other.format))
            return false;
        if (mimeType == null) {
            if (other.mimeType != null)
                return false;
        } else if (!mimeType.equals(other.mimeType))
            return false;
        if (tool == null) {
            if (other.tool != null)
                return false;
        } else if (!tool.equals(other.tool))
            return false;
        if (toolName == null) {
            if (other.toolName != null)
                return false;
        } else if (!toolName.equals(other.toolName))
            return false;
        if (toolVersion == null) {
            if (other.toolVersion != null)
                return false;
        } else if (!toolVersion.equals(other.toolVersion))
            return false;
        if (versions == null) {
            if (other.versions != null)
                return false;
        } else if (!versions.equals(other.versions))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((externalIdentifiers == null) ? 0 : externalIdentifiers.hashCode());
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
        result = prime * result + ((tool == null) ? 0 : tool.hashCode());
        result = prime * result + ((toolName == null) ? 0 : toolName.hashCode());
        result = prime * result + ((toolVersion == null) ? 0 : toolVersion.hashCode());
        result = prime * result + ((versions == null) ? 0 : versions.hashCode());
        return result;
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
