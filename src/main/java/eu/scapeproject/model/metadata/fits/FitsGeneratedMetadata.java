package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsGeneratedMetadata {
    @XmlElement(name = "any", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final List<String> any;
    @XmlElement(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsStatus status;
    @XmlElement(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolName;
    @XmlElement(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String toolVersion;

    private FitsGeneratedMetadata() {
        super();
        this.any=null;
        this.status=null;
        this.toolName=null;
        this.toolVersion=null;
    }

    private FitsGeneratedMetadata(Builder builder) {
        this.any = builder.any;
        this.status = builder.status;
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
        FitsGeneratedMetadata other = (FitsGeneratedMetadata) obj;
        if (any == null) {
            if (other.any != null)
                return false;
        } else if (!any.equals(other.any))
            return false;
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
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((any == null) ? 0 : any.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((toolName == null) ? 0 : toolName.hashCode());
        result = prime * result + ((toolVersion == null) ? 0 : toolVersion.hashCode());
        return result;
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
