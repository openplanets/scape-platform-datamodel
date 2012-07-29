package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="externalidentifier",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class ExternalIdentifier {
    @XmlElement(name="value",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String value;
    @XmlElement(name="type",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String type;
    @XmlElement(name="toolname",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolName;
    @XmlElement(name="toolversion",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolVersion;

    private ExternalIdentifier() {
        super();
        this.value=null;
        this.toolName=null;
        this.type=null;
        this.toolVersion=null;
    }

    private ExternalIdentifier(Builder builder) {
        this.value = builder.value;
        this.type = builder.type;
        this.toolName = builder.toolName;
        this.toolVersion = builder.toolVersion;
    }

    public String getToolName() {
        return toolName;
    }

    public String getToolVersion() {
        return toolVersion;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((toolName == null) ? 0 : toolName.hashCode());
        result = prime * result + ((toolVersion == null) ? 0 : toolVersion.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        ExternalIdentifier other = (ExternalIdentifier) obj;
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
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
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
        private String type;
        private String toolName;
        private String toolVersion;

        public ExternalIdentifier build() {
            return new ExternalIdentifier(this);
        }

        public Builder toolName(String toolName) {
            this.toolName = toolName;
            return this;
        }

        public Builder toolVersion(String toolVersion) {
            this.toolVersion = toolVersion;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }
    }
}
