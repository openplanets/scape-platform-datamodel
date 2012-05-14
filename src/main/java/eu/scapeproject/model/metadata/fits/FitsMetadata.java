package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "fits", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsMetadata extends TechnicalMetadata {
    @XmlElement(name = "identification", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsIdentification identification;
    @XmlElement(name = "fileinfo", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsFileInfo fileInfo;
    @XmlElement(name = "filestatus", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsFileStatus fileStatus;
    @XmlElement(name = "metadata", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsGeneratedMetadata metadata;
    @XmlElement(name = "toolOutput", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private ToolOutput toolOutput;
    @XmlElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String version;
    @XmlElement(name = "timestamp", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String timeStamp;

    private FitsMetadata() {
        super(MetadataType.FITS);
    }

    private FitsMetadata(Builder builder) {
        this();
        this.identification = builder.identification;
        this.fileInfo = builder.fileInfo;
        this.fileStatus = builder.fileStatus;
        this.metadata = builder.metadata;
        this.toolOutput = builder.toolOutput;
        this.version = builder.version;
        this.timeStamp = builder.timeStamp;
    }

    public FitsFileInfo getFileInfo() {
        return fileInfo;
    }

    public FitsFileStatus getFileStatus() {
        return fileStatus;
    }

    public FitsIdentification getIdentification() {
        return identification;
    }

    public FitsGeneratedMetadata getMetadata() {
        return metadata;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public ToolOutput getToolOutput() {
        return toolOutput;
    }

    public String getVersion() {
        return version;
    }

    public static class Builder {
        private FitsIdentification identification;
        private FitsFileInfo fileInfo;
        private FitsFileStatus fileStatus;
        private FitsGeneratedMetadata metadata;
        private ToolOutput toolOutput;
        private String version;
        private String timeStamp;

        public FitsMetadata build() {
            return new FitsMetadata(this);
        }

        public Builder fileInfo(FitsFileInfo fileInfo) {
            this.fileInfo = fileInfo;
            return this;
        }

        public Builder fileStatus(FitsFileStatus fileStatus) {
            this.fileStatus = fileStatus;
            return this;
        }

        public Builder identification(FitsIdentification identification) {
            this.identification = identification;
            return this;
        }

        public Builder metadata(FitsGeneratedMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder timeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder toolOutput(ToolOutput toolOutput) {
            this.toolOutput = toolOutput;
            return this;
        }

        public Builder version(String version) {
            this.version = version;
            return this;
        }
    }
}
