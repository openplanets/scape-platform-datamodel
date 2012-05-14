package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "identification", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsIdentification {
    @XmlElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private List<FitsIdentity> identities;
    @XmlElement(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private FitsStatus status;

    private FitsIdentification() {
        super();
    }

    public FitsIdentification(List<FitsIdentity> identities, FitsStatus status) {
        super();
        this.identities = identities;
        this.status = status;
    }

    public List<FitsIdentity> getIdentities() {
        return identities;
    }

    public FitsStatus getStatus() {
        return status;
    }
}
