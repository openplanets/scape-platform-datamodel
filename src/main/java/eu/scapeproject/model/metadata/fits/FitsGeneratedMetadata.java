package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsGeneratedMetadata {
    @XmlElement(name = "any", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private List<String> any;
    @XmlElement(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsStatus status;
    @XmlElement(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolName;
    @XmlElement(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String toolVersion;

    private FitsGeneratedMetadata() {
        super();
    }

    private FitsGeneratedMetadata(Builder builder) {
        this.any = builder.any;
        this.status = builder.status;
        this.toolName = builder.toolName;
        this.toolVersion = builder.toolVersion;
    }

    public List<String> getAny() {
        return any;
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

    public static class Builder {
        private List<String> any;
        private FitsStatus status;
        private String toolName;
        private String toolVersion;

        public Builder any(List<String> any) {
            this.any = any;
            return this;
        }

        public FitsGeneratedMetadata build() {
            return new FitsGeneratedMetadata(this);
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
    }
}
