package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="externalidentifier",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class ExternalIdentifier {
    @XmlElement(name="value",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String value;
    @XmlElement(name="type",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String type;
    @XmlElement(name="toolname",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolName;
    @XmlElement(name="toolversion",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolVersion;

    private ExternalIdentifier() {
        super();
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
