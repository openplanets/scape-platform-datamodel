package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.RightsMetadata;

@XmlRootElement(name="premisRightsMetadata",namespace="http://www.loc.gov/standards/premis")
public class PremisRightsMetadata extends RightsMetadata{
    @XmlElement(name="rightsStatements",namespace="http://www.loc.gov/standards/premis")
    private List<RightsStatement> rightsStatements;

    private PremisRightsMetadata(){
        super(Type.PREMIS);
    }

    public PremisRightsMetadata(List<RightsStatement> rightsStatements) {
        this();
        this.rightsStatements = rightsStatements;
    }

    public List<RightsStatement> getRightsStatements() {
        return rightsStatements;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rightsStatements == null) ? 0 : rightsStatements.hashCode());
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
        PremisRightsMetadata other = (PremisRightsMetadata) obj;
        if (rightsStatements == null) {
            if (other.rightsStatements != null)
                return false;
        } else if (!rightsStatements.equals(other.rightsStatements))
            return false;
        return true;
    }

}
