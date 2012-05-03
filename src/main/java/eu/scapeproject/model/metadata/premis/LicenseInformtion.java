package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name = "licenseInformation", namespace = "http://www.loc.gov/standards/premis")
public class LicenseInformtion {
    @XmlElement(name = "licenseIdentifier", namespace = "http://www.loc.gov/standards/premis")
    private Identifier licenseIdentifier;
    @XmlElement(name = "licenseTerms", namespace = "http://www.loc.gov/standards/premis")
    private String licenseTerms;
    @XmlElement(name = "licenseNotes", namespace = "http://www.loc.gov/standards/premis")
    private List<String> licenseNotes;

    private LicenseInformtion() {
        super();
    }

    public LicenseInformtion(Identifier licenseIdentifier, String licenseTerms, List<String> licenseNotes) {
        super();
        this.licenseIdentifier = licenseIdentifier;
        this.licenseTerms = licenseTerms;
        this.licenseNotes = licenseNotes;
    }

    public Identifier getLicenseIdentifier() {
        return licenseIdentifier;
    }

    public String getLicenseTerms() {
        return licenseTerms;
    }

    public List<String> getLicenseNotes() {
        return licenseNotes;
    }

}
