package eu.scapeproject.model.metadata.premis;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="copyRightInformation",namespace="http://www.loc.gov/standards/premis")
public class CopyRightInformation {
    @XmlElement(name="copyrightJurisdiction",namespace="http://www.loc.gov/standards/premis")
    private final String copyrightJurisdiction;

    @XmlElement(name="copyrightStatusDeterminationDate",namespace="http://www.loc.gov/standards/premis")
    private final Date copyrightStatusDeterminationDate;
    @XmlElement(name="copyrightNote",namespace="http://www.loc.gov/standards/premis")
    private final List<String> copyrightNote;
    @SuppressWarnings("unused")
    private CopyRightInformation(){
        super();
        this.copyrightJurisdiction=null;
        this.copyrightNote=null;
        this.copyrightStatusDeterminationDate=null;
    }

    public CopyRightInformation(String copyrightJurisdiction, Date copyrightStatusDeterminationDate, List<String> copyrightNote) {
        super();
        this.copyrightJurisdiction = copyrightJurisdiction;
        this.copyrightStatusDeterminationDate = copyrightStatusDeterminationDate;
        this.copyrightNote = copyrightNote;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CopyRightInformation other = (CopyRightInformation) obj;
        if (copyrightJurisdiction == null) {
            if (other.copyrightJurisdiction != null)
                return false;
        } else if (!copyrightJurisdiction.equals(other.copyrightJurisdiction))
            return false;
        if (copyrightNote == null) {
            if (other.copyrightNote != null)
                return false;
        } else if (!copyrightNote.equals(other.copyrightNote))
            return false;
        if (copyrightStatusDeterminationDate == null) {
            if (other.copyrightStatusDeterminationDate != null)
                return false;
        } else if (!copyrightStatusDeterminationDate.equals(other.copyrightStatusDeterminationDate))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((copyrightJurisdiction == null) ? 0 : copyrightJurisdiction.hashCode());
        result = prime * result + ((copyrightNote == null) ? 0 : copyrightNote.hashCode());
        result = prime * result + ((copyrightStatusDeterminationDate == null) ? 0 : copyrightStatusDeterminationDate.hashCode());
        return result;
    }
    
    



    @Override
	public String toString() {
		return "CopyRightInformation [copyrightJurisdiction="
				+ copyrightJurisdiction + ", copyrightStatusDeterminationDate="
				+ copyrightStatusDeterminationDate + ", copyrightNote="
				+ copyrightNote + "]";
	}





	public enum CopyrightStatus {
        COPYRIGHTED, PUBLIC_DOMAIN, UNKNOWN;
    }
    
}
