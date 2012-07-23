package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name = "licenseInformation", namespace = "http://www.loc.gov/standards/premis")
public class LicenseInformation {
    @XmlElement(name = "licenseIdentifier", namespace = "http://www.loc.gov/standards/premis")
    private Identifier licenseIdentifier;
    @XmlElement(name = "licenseTerms", namespace = "http://www.loc.gov/standards/premis")
    private String licenseTerms;
    @XmlElement(name = "licenseNotes", namespace = "http://www.loc.gov/standards/premis")
    private List<String> licenseNotes;

    @SuppressWarnings("unused")
    private LicenseInformation() {
        super();
    }

    public LicenseInformation(Identifier licenseIdentifier, String licenseTerms, List<String> licenseNotes) {
        super();
        this.licenseIdentifier = licenseIdentifier;
        this.licenseTerms = licenseTerms;
        this.licenseNotes = licenseNotes;
    }

    public Identifier getLicenseIdentifier() {
        return licenseIdentifier;
    }

    public List<String> getLicenseNotes() {
        return licenseNotes;
    }

    public String getLicenseTerms() {
        return licenseTerms;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((licenseIdentifier == null) ? 0 : licenseIdentifier.hashCode());
        result = prime * result + ((licenseNotes == null) ? 0 : licenseNotes.hashCode());
        result = prime * result + ((licenseTerms == null) ? 0 : licenseTerms.hashCode());
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
        LicenseInformation other = (LicenseInformation) obj;
        if (licenseIdentifier == null) {
            if (other.licenseIdentifier != null)
                return false;
        } else if (!licenseIdentifier.equals(other.licenseIdentifier))
            return false;
        if (licenseNotes == null) {
            if (other.licenseNotes != null)
                return false;
        } else if (!licenseNotes.equals(other.licenseNotes))
            return false;
        if (licenseTerms == null) {
            if (other.licenseTerms != null)
                return false;
        } else if (!licenseTerms.equals(other.licenseTerms))
            return false;
        return true;
    }
    
}
