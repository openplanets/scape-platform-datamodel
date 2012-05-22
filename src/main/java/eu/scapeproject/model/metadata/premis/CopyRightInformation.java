package eu.scapeproject.model.metadata.premis;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="copyRightInformation",namespace="http://www.loc.gov/standards/premis")
public class CopyRightInformation {
    @XmlElement(name="copyrightJurisdiction",namespace="http://www.loc.gov/standards/premis")
    private String copyrightJurisdiction;

    @XmlElement(name="copyrightStatusDeterminationDate",namespace="http://www.loc.gov/standards/premis")
    private Date copyrightStatusDeterminationDate;
    @XmlElement(name="copyrightNote",namespace="http://www.loc.gov/standards/premis")
    private List<String> copyrightNote;
    @SuppressWarnings("unused")
    private CopyRightInformation(){
        super();
    }

    public CopyRightInformation(String copyrightJurisdiction, Date copyrightStatusDeterminationDate, List<String> copyrightNote) {
        super();
        this.copyrightJurisdiction = copyrightJurisdiction;
        this.copyrightStatusDeterminationDate = copyrightStatusDeterminationDate;
        this.copyrightNote = copyrightNote;
    }
    
    public String getCopyrightJurisdiction() {
        return copyrightJurisdiction;
    }

    public List<String> getCopyrightNote() {
        return copyrightNote;
    }

    public Date getCopyrightStatusDeterminationDate() {
        return copyrightStatusDeterminationDate;
    }

    public enum CopyrightStatus {
        COPYRIGHTED, PUBLIC_DOMAIN, UNKNOWN;
    }
    
}
