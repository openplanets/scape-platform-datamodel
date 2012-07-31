package eu.scapeproject.model.metadata.premis;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="termOfGrant",namespace="http://www.loc.gov/standards/premis")
public class TermOfGrant {
    @XmlElement(name="startDate",namespace="http://www.loc.gov/standards/premis")
    private final Date startDate;
    @XmlElement(name="endDate",namespace="http://www.loc.gov/standards/premis")
    private final Date endDate;

    @SuppressWarnings("unused")
    private TermOfGrant() {
        super();
        this.endDate=null;
        this.startDate=null;
    }

    public TermOfGrant(Date startDate, Date endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TermOfGrant other = (TermOfGrant) obj;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        return true;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

}
