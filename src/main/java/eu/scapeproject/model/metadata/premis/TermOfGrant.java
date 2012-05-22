package eu.scapeproject.model.metadata.premis;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="termOfGrant",namespace="http://www.loc.gov/standards/premis")
public class TermOfGrant {
    @XmlElement(name="startDate",namespace="http://www.loc.gov/standards/premis")
    private Date startDate;
    @XmlElement(name="endDate",namespace="http://www.loc.gov/standards/premis")
    private Date endDate;

    @SuppressWarnings("unused")
    private TermOfGrant() {
        super();
    }

    public TermOfGrant(Date startDate, Date endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

}
