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
}
