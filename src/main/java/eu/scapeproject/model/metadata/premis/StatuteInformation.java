package eu.scapeproject.model.metadata.premis;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "statuteInformation", namespace = "http://www.loc.gov/standards/premis")
public class StatuteInformation {
    @XmlElement(name = "statuteJurisdiction", namespace = "http://www.loc.gov/standards/premis")
    private final String statuteJurisdiction;
    @XmlElement(name = "statuteCitation", namespace = "http://www.loc.gov/standards/premis")
    private final String statuteCitation;
    @XmlElement(name = "statuteInformationDeterminationDate", namespace = "http://www.loc.gov/standards/premis")
    private final Date statuteInformationDeterminationDate;
    @XmlElement(name = "statuteNotes", namespace = "http://www.loc.gov/standards/premis")
    private final List<String> statuteNotes;

    @SuppressWarnings("unused")
    private StatuteInformation() {
        super();
        this.statuteInformationDeterminationDate=null;
        this.statuteCitation=null;
        this.statuteJurisdiction=null;
        this.statuteNotes=null;
    }

    public StatuteInformation(String statuteJurisdiction, String statuteCitation, Date statuteInformationDeterminationDate, List<String> statuteNotes) {
        super();
        this.statuteJurisdiction = statuteJurisdiction;
        this.statuteCitation = statuteCitation;
        this.statuteInformationDeterminationDate = statuteInformationDeterminationDate;
        this.statuteNotes = statuteNotes;
    }

    public String getStatuteCitation() {
        return statuteCitation;
    }

    public Date getStatuteInformationDeterminationDate() {
        return statuteInformationDeterminationDate;
    }

    public String getStatuteJurisdiction() {
        return statuteJurisdiction;
    }

    public List<String> getStatuteNotes() {
        return statuteNotes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((statuteCitation == null) ? 0 : statuteCitation.hashCode());
        result = prime * result + ((statuteInformationDeterminationDate == null) ? 0 : statuteInformationDeterminationDate.hashCode());
        result = prime * result + ((statuteJurisdiction == null) ? 0 : statuteJurisdiction.hashCode());
        result = prime * result + ((statuteNotes == null) ? 0 : statuteNotes.hashCode());
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
        StatuteInformation other = (StatuteInformation) obj;
        if (statuteCitation == null) {
            if (other.statuteCitation != null)
                return false;
        } else if (!statuteCitation.equals(other.statuteCitation))
            return false;
        if (statuteInformationDeterminationDate == null) {
            if (other.statuteInformationDeterminationDate != null)
                return false;
        } else if (!statuteInformationDeterminationDate.equals(other.statuteInformationDeterminationDate))
            return false;
        if (statuteJurisdiction == null) {
            if (other.statuteJurisdiction != null)
                return false;
        } else if (!statuteJurisdiction.equals(other.statuteJurisdiction))
            return false;
        if (statuteNotes == null) {
            if (other.statuteNotes != null)
                return false;
        } else if (!statuteNotes.equals(other.statuteNotes))
            return false;
        return true;
    }

}
