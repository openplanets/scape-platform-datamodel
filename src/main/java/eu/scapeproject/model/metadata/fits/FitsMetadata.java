package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "fits", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsMetadata extends TechnicalMetadata {
    @XmlElement(name = "identification", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsIdentification identification;
    @XmlElement(name = "fileinfo", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsFileInfo fileInfo;
    @XmlElement(name = "filestatus", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsFileStatus fileStatus;
    @XmlElement(name = "metadata", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsGeneratedMetadata metadata;
    @XmlElement(name = "toolOutput", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final ToolOutput toolOutput;
    @XmlElement(name = "version", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String version;
    @XmlElement(name = "timestamp", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String timeStamp;

    private FitsMetadata() {
        super(MetadataType.FITS);
        this.identification=null;
        this.fileInfo=null;
        this.fileStatus=null;
        this.metadata=null;
        this.toolOutput=null;
        this.version=null;
        this.timeStamp=null;
    }

    private FitsMetadata(Builder builder) {
    	super(MetadataType.FITS);
        this.identification = builder.identification;
        this.fileInfo = builder.fileInfo;
        this.fileStatus = builder.fileStatus;
        this.metadata = builder.metadata;
        this.toolOutput = builder.toolOutput;
        this.version = builder.version;
        this.timeStamp = builder.timeStamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FitsMetadata other = (FitsMetadata) obj;
        if (fileInfo == null) {
            if (other.fileInfo != null)
                return false;
        } else if (!fileInfo.equals(other.fileInfo))
            return false;
        if (fileStatus == null) {
            if (other.fileStatus != null)
                return false;
        } else if (!fileStatus.equals(other.fileStatus))
            return false;
        if (identification == null) {
            if (other.identification != null)
                return false;
        } else if (!identification.equals(other.identification))
            return false;
        if (metadata == null) {
            if (other.metadata != null)
                return false;
        } else if (!metadata.equals(other.metadata))
            return false;
        if (timeStamp == null) {
            if (other.timeStamp != null)
                return false;
        } else if (!timeStamp.equals(other.timeStamp))
            return false;
        if (toolOutput == null) {
            if (other.toolOutput != null)
                return false;
        } else if (!toolOutput.equals(other.toolOutput))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fileInfo == null) ? 0 : fileInfo.hashCode());
        result = prime * result + ((fileStatus == null) ? 0 : fileStatus.hashCode());
        result = prime * result + ((identification == null) ? 0 : identification.hashCode());
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
        result = prime * result + ((toolOutput == null) ? 0 : toolOutput.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        return result;
    }

    public static class Builder {
        private FitsIdentification identification;
        private FitsFileInfo fileInfo;
        private FitsFileStatus fileStatus;
        private FitsGeneratedMetadata metadata;
        private ToolOutput toolOutput;
        private String version;
        private String timeStamp;

        public Builder(){
        	super();
        }
        
        public Builder(FitsMetadata orig){
        	// TODO: deep copy
        	this.identification=orig.identification;
        	this.fileInfo=orig.fileInfo;
        	this.fileStatus=orig.fileStatus;
        	this.metadata=orig.metadata;
        	this.toolOutput=orig.toolOutput;
        	this.version=orig.version;
        	this.timeStamp=orig.timeStamp;
        }
        
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
