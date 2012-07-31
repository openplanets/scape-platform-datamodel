package eu.scapeproject.model.metadata.fits;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "identification", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class FitsIdentification {
    @XmlElement(name = "identity", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final List<FitsIdentity> identities;
    @XmlElement(name = "status", namespace = "http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
    private final FitsStatus status;

    @SuppressWarnings("unused")
    private FitsIdentification() {
        super();
        this.identities=null;
        this.status=null;
    }

    public FitsIdentification(List<FitsIdentity> identities, FitsStatus status) {
        super();
        this.identities = identities;
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FitsIdentification other = (FitsIdentification) obj;
        if (identities == null) {
            if (other.identities != null)
                return false;
        } else if (!identities.equals(other.identities))
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    public List<FitsIdentity> getIdentities() {
        return identities;
    }

    public FitsStatus getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identities == null) ? 0 : identities.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }
    
}
