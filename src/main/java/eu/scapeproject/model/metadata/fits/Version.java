package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class Version {
    @XmlValue
    private String value;
    @XmlAttribute(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsStatus status;
    @XmlAttribute(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolName;
    @XmlAttribute(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolVersion;

    private Version() {
        super();
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
