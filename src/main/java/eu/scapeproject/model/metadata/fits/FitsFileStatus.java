package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filestatus", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsFileStatus {
    @XmlElement(name = "message", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String message;
    @XmlElement(name = "well-formed", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String wellFormed;
    @XmlElement(name = "valid", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private String valid;

    @SuppressWarnings("unused")
    private FitsFileStatus() {
        super();
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
