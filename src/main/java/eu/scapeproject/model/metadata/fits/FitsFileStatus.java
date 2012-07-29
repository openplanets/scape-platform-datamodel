package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filestatus", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsFileStatus {
    @XmlElement(name = "message", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String message;
    @XmlElement(name = "well-formed", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String wellFormed;
    @XmlElement(name = "valid", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final String valid;

    @SuppressWarnings("unused")
    private FitsFileStatus() {
        super();
        this.message=null;
        this.wellFormed=null;
        this.valid=null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result + ((valid == null) ? 0 : valid.hashCode());
        result = prime * result + ((wellFormed == null) ? 0 : wellFormed.hashCode());
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
        FitsFileStatus other = (FitsFileStatus) obj;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        if (valid == null) {
            if (other.valid != null)
                return false;
        } else if (!valid.equals(other.valid))
            return false;
        if (wellFormed == null) {
            if (other.wellFormed != null)
                return false;
        } else if (!wellFormed.equals(other.wellFormed))
            return false;
        return true;
    }

    public FitsFileStatus(String message, String wellFormed, String valid) {
        super();
        this.message = message;
        this.wellFormed = wellFormed;
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public String getValid() {
        return valid;
    }

    public String getWellFormed() {
        return wellFormed;
    }
}
