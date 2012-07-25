package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "fileinfo", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsFileInfo {
    @XmlElement(name = "filepath", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement filePath;
    @XmlElement(name = "filename", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement fileName;
    @XmlElement(name = "size", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement size;
    @XmlElement(name = "md5checksum", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement md5Checksum;
    @XmlElement(name = "lastmodified", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement lastModified;
    @XmlElement(name = "fslastmodified", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement fsLastModified;
    @XmlElement(name = "created", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement created;
    @XmlElement(name = "creatingapplicationname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement creatingApplicationName;
    @XmlElement(name = "creatingapplicationversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement creatingApplicationVersion;
    @XmlElement(name = "inhibitortype", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement inhibitorType;
    @XmlElement(name = "inhibitortarget", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement inhibitorTarget;
    @XmlElement(name = "rightsbasis", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement rightsBasis;
    @XmlElement(name = "copyrightbasis", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement copyRightBasis;
    @XmlElement(name = "copyrightnote", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement copyRightNote;
    @XmlElement(name = "creatingos", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FileInfoElement creatingOs;

    private FitsFileInfo() {
        super();
    }

    private FitsFileInfo(Builder builder) {
        this.filePath = builder.filePath;
        this.fileName = builder.fileName;
        this.size = builder.size;
        this.md5Checksum = builder.md5Checksum;
        this.lastModified = builder.lastModified;
        this.fsLastModified = builder.fsLastModified;
        this.created = builder.created;
        this.creatingApplicationName = builder.creatingApplicationName;
        this.creatingApplicationVersion = builder.creatingApplicationVersion;
        this.inhibitorType = builder.inhibitorType;
        this.inhibitorTarget = builder.inhibitorTarget;
        this.rightsBasis = builder.rightsBasis;
        this.copyRightBasis = builder.copyRightBasis;
        this.copyRightNote = builder.copyRightNote;
        this.creatingOs = builder.creatingOs;
    }

    public FileInfoElement getCopyRightBasis() {
        return copyRightBasis;
    }

    public FileInfoElement getCopyRightNote() {
        return copyRightNote;
    }

    public FileInfoElement getCreated() {
        return created;
    }

    public FileInfoElement getCreatingApplicationName() {
        return creatingApplicationName;
    }

    public FileInfoElement getCreatingApplicationVersion() {
        return creatingApplicationVersion;
    }

    public FileInfoElement getCreatingOs() {
        return creatingOs;
    }

    public FileInfoElement getFileName() {
        return fileName;
    }

    public FileInfoElement getFilePath() {
        return filePath;
    }

    public FileInfoElement getFsLastModified() {
        return fsLastModified;
    }

    public FileInfoElement getInhibitorTarget() {
        return inhibitorTarget;
    }

    public FileInfoElement getInhibitorType() {
        return inhibitorType;
    }

    public FileInfoElement getLastModified() {
        return lastModified;
    }

    public FileInfoElement getMd5Checksum() {
        return md5Checksum;
    }

    public FileInfoElement getRightsBasis() {
        return rightsBasis;
    }

    public FileInfoElement getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((copyRightBasis == null) ? 0 : copyRightBasis.hashCode());
        result = prime * result + ((copyRightNote == null) ? 0 : copyRightNote.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((creatingApplicationName == null) ? 0 : creatingApplicationName.hashCode());
        result = prime * result + ((creatingApplicationVersion == null) ? 0 : creatingApplicationVersion.hashCode());
        result = prime * result + ((creatingOs == null) ? 0 : creatingOs.hashCode());
        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
        result = prime * result + ((fsLastModified == null) ? 0 : fsLastModified.hashCode());
        result = prime * result + ((inhibitorTarget == null) ? 0 : inhibitorTarget.hashCode());
        result = prime * result + ((inhibitorType == null) ? 0 : inhibitorType.hashCode());
        result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
        result = prime * result + ((md5Checksum == null) ? 0 : md5Checksum.hashCode());
        result = prime * result + ((rightsBasis == null) ? 0 : rightsBasis.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
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
        FitsFileInfo other = (FitsFileInfo) obj;
        if (copyRightBasis == null) {
            if (other.copyRightBasis != null)
                return false;
        } else if (!copyRightBasis.equals(other.copyRightBasis))
            return false;
        if (copyRightNote == null) {
            if (other.copyRightNote != null)
                return false;
        } else if (!copyRightNote.equals(other.copyRightNote))
            return false;
        if (created == null) {
            if (other.created != null)
                return false;
        } else if (!created.equals(other.created))
            return false;
        if (creatingApplicationName == null) {
            if (other.creatingApplicationName != null)
                return false;
        } else if (!creatingApplicationName.equals(other.creatingApplicationName))
            return false;
        if (creatingApplicationVersion == null) {
            if (other.creatingApplicationVersion != null)
                return false;
        } else if (!creatingApplicationVersion.equals(other.creatingApplicationVersion))
            return false;
        if (creatingOs == null) {
            if (other.creatingOs != null)
                return false;
        } else if (!creatingOs.equals(other.creatingOs))
            return false;
        if (fileName == null) {
            if (other.fileName != null)
                return false;
        } else if (!fileName.equals(other.fileName))
            return false;
        if (filePath == null) {
            if (other.filePath != null)
                return false;
        } else if (!filePath.equals(other.filePath))
            return false;
        if (fsLastModified == null) {
            if (other.fsLastModified != null)
                return false;
        } else if (!fsLastModified.equals(other.fsLastModified))
            return false;
        if (inhibitorTarget == null) {
            if (other.inhibitorTarget != null)
                return false;
        } else if (!inhibitorTarget.equals(other.inhibitorTarget))
            return false;
        if (inhibitorType == null) {
            if (other.inhibitorType != null)
                return false;
        } else if (!inhibitorType.equals(other.inhibitorType))
            return false;
        if (lastModified == null) {
            if (other.lastModified != null)
                return false;
        } else if (!lastModified.equals(other.lastModified))
            return false;
        if (md5Checksum == null) {
            if (other.md5Checksum != null)
                return false;
        } else if (!md5Checksum.equals(other.md5Checksum))
            return false;
        if (rightsBasis == null) {
            if (other.rightsBasis != null)
                return false;
        } else if (!rightsBasis.equals(other.rightsBasis))
            return false;
        if (size == null) {
            if (other.size != null)
                return false;
        } else if (!size.equals(other.size))
            return false;
        return true;
    }

    public static class Builder {
        private FileInfoElement filePath;
        private FileInfoElement fileName;
        private FileInfoElement size;
        private FileInfoElement md5Checksum;
        private FileInfoElement lastModified;
        private FileInfoElement fsLastModified;
        private FileInfoElement created;
        private FileInfoElement creatingApplicationName;
        private FileInfoElement creatingApplicationVersion;
        private FileInfoElement inhibitorType;
        private FileInfoElement inhibitorTarget;
        private FileInfoElement rightsBasis;
        private FileInfoElement copyRightBasis;
        private FileInfoElement copyRightNote;
        private FileInfoElement creatingOs;

        public FitsFileInfo build() {
            return new FitsFileInfo(this);
        }

        public Builder copyRightBasis(FileInfoElement copyRightBasis) {
            this.copyRightBasis = copyRightBasis;
            return this;
        }

        public Builder copyRightNote(FileInfoElement copyRightNote) {
            this.copyRightNote = copyRightNote;
            return this;
        }

        public Builder created(FileInfoElement created) {
            this.created = created;
            return this;
        }

        public Builder creatingApplicationName(FileInfoElement creatingApplicationName) {
            this.creatingApplicationName = creatingApplicationName;
            return this;
        }

        public Builder creatingApplicationVersion(FileInfoElement creatingApplicationVersion) {
            this.creatingApplicationVersion = creatingApplicationVersion;
            return this;
        }

        public Builder creatingOs(FileInfoElement creatingOs) {
            this.creatingOs = creatingOs;
            return this;
        }

        public Builder fileName(FileInfoElement fileName) {
            this.fileName = fileName;
            return this;
        }

        public Builder filePath(FileInfoElement filePath) {
            this.filePath = filePath;
            return this;
        }

        public Builder fsLastModified(FileInfoElement fsLastModified) {
            this.fsLastModified = fsLastModified;
            return this;
        }

        public Builder inhibitorTarget(FileInfoElement inhibitorTarget) {
            this.inhibitorTarget = inhibitorTarget;
            return this;
        }

        public Builder inhibitorType(FileInfoElement inhibitorType) {
            this.inhibitorType = inhibitorType;
            return this;
        }

        public Builder lastModified(FileInfoElement lastModified) {
            this.lastModified = lastModified;
            return this;
        }

        public Builder md5Checksum(FileInfoElement md5Checksum) {
            this.md5Checksum = md5Checksum;
            return this;
        }

        public Builder rightsBasis(FileInfoElement rightsBasis) {
            this.rightsBasis = rightsBasis;
            return this;
        }

        public Builder size(FileInfoElement size) {
            this.size = size;
            return this;
        }
    }

    @XmlRootElement(name = "fileinfo", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    public static class FileInfoElement {
        @XmlAttribute(name = "toolname", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
        private String toolName;
        @XmlAttribute(name = "toolversion", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
        private String toolVersion;
        @XmlValue
        private String value;

        @SuppressWarnings("unused")
        private FileInfoElement() {
            super();
        }

        public FileInfoElement(String toolName, String toolVersion, String value) {
            super();
            this.toolName = toolName;
            this.toolVersion = toolVersion;
            this.value = value;
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
            FileInfoElement other = (FileInfoElement) obj;
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

    }
}
