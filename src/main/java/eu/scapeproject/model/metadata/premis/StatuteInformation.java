package eu.scapeproject.model.metadata.premis;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "statuteInformation", namespace = "http://www.loc.gov/standards/premis")
public class StatuteInformation {
    @XmlElement(name = "statuteJurisdiction", namespace = "http://www.loc.gov/standards/premis")
    private String statuteJurisdiction;
    @XmlElement(name = "statuteCitation", namespace = "http://www.loc.gov/standards/premis")
    private String statuteCitation;
    @XmlElement(name = "statuteInformationDeterminationDate", namespace = "http://www.loc.gov/standards/premis")
    private Date statuteInformationDeterminationDate;
    @XmlElement(name = "statuteNotes", namespace = "http://www.loc.gov/standards/premis")
    private List<String> statuteNotes;

    @SuppressWarnings("unused")
    private StatuteInformation() {
        super();
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

}
