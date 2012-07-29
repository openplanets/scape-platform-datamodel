package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class Version {
    @XmlValue
    private final String value;
    @XmlAttribute(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsStatus status;
    @XmlAttribute(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolName;
    @XmlAttribute(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolVersion;

    private Version() {
        super();
        this.value=null;
        this.status=null;
        this.toolName=null;
        this.toolVersion=null;
    }

    private Version(Builder builder) {
        this.value = builder.value;
        this.status = builder.status;
        this.toolName = builder.toolName;
        this.toolVersion = builder.toolVersion;
    }

    public FitsStatus getStatus() {
        return status;
    }

    public String getToolName() {
        return toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((toolName == null) ? 0 : toolName.hashCode());
        result = prime * result + ((toolVersion == null) ? 0 : toolVersion.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        Version other = (Version) obj;
        if (status != other.status)
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
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    public static class Builder {
        private String value;
        private FitsStatus status;
        private String toolName;
        private String toolVersion;

        public Version build() {
            return new Version(this);
        }

        public Builder status(FitsStatus status) {
            this.status = status;
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

        public Builder value(String value) {
            this.value = value;
            return this;
        }
    }
}
