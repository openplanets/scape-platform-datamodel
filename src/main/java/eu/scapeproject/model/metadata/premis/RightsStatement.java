package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.jaxb.PremisRightsIdentifierAdapter;

@XmlRootElement(name="rightsStatement",namespace="http://www.loc.gov/standards/premis")
public class RightsStatement {
    @XmlElement(name="rightsStatementIdentifier",namespace="http://www.loc.gov/standards/premis")
    @XmlJavaTypeAdapter(PremisRightsIdentifierAdapter.class)
    private final Identifier rightsStatementIdentifier;
    @XmlElement(name="rightsBasis",namespace="http://www.loc.gov/standards/premis")
    private final String rightsBasis;
    @XmlElement(name="copyrightInformation",namespace="http://www.loc.gov/standards/premis")
    private final CopyRightInformation copyrightInformation;
    @XmlElement(name="licenseInformation",namespace="http://www.loc.gov/standards/premis")
    private final LicenseInformation licenseInformation;
    @XmlElement(name="statuteInformation",namespace="http://www.loc.gov/standards/premis")
    private final List<StatuteInformation> statuteInformation;
    @XmlElement(name="rightsGranted",namespace="http://www.loc.gov/standards/premis")
    private final List<GrantedRights> rightsGranted;
    @XmlElement(name="linkingObjects",namespace="http://www.loc.gov/standards/premis")
    private final List<LinkingObject> linkingObjects;
    @XmlElement(name="linkingagents",namespace="http://www.loc.gov/standards/premis")
    private final List<LinkingAgent> linkingagents;

    private RightsStatement(){
        super();
        this.rightsStatementIdentifier = null;
        this.rightsBasis = null;
        this.copyrightInformation = null;
        this.licenseInformation = null;
        this.statuteInformation = null;
        this.rightsGranted = null;
        this.linkingObjects = null;
        this.linkingagents = null;
     }
    
    private RightsStatement(Builder builder) {
        this.rightsStatementIdentifier = builder.rightsStatementIdentifier;
        this.rightsBasis = builder.rightsBasis;
        this.copyrightInformation = builder.copyrightInformation;
        this.licenseInformation = builder.licenseInformation;
        this.statuteInformation = builder.statuteInformation;
        this.rightsGranted = builder.rightsGranted;
        this.linkingObjects = builder.linkingObjects;
        this.linkingagents = builder.linkingagents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RightsStatement other = (RightsStatement) obj;
        if (copyrightInformation == null) {
            if (other.copyrightInformation != null)
                return false;
        } else if (!copyrightInformation.equals(other.copyrightInformation))
            return false;
        if (licenseInformation == null) {
            if (other.licenseInformation != null)
                return false;
        } else if (!licenseInformation.equals(other.licenseInformation))
            return false;
        if (linkingObjects == null) {
            if (other.linkingObjects != null)
                return false;
        } else if (!linkingObjects.equals(other.linkingObjects))
            return false;
        if (linkingagents == null) {
            if (other.linkingagents != null)
                return false;
        } else if (!linkingagents.equals(other.linkingagents))
            return false;
        if (rightsBasis == null) {
            if (other.rightsBasis != null)
                return false;
        } else if (!rightsBasis.equals(other.rightsBasis))
            return false;
        if (rightsGranted == null) {
            if (other.rightsGranted != null)
                return false;
        } else if (!rightsGranted.equals(other.rightsGranted))
            return false;
        if (rightsStatementIdentifier == null) {
            if (other.rightsStatementIdentifier != null)
                return false;
        } else if (!rightsStatementIdentifier.equals(other.rightsStatementIdentifier))
            return false;
        if (statuteInformation == null) {
            if (other.statuteInformation != null)
                return false;
        } else if (!statuteInformation.equals(other.statuteInformation))
            return false;
        return true;
    }

    public CopyRightInformation getCopyrightInformation() {
        return copyrightInformation;
    }

    public LicenseInformation getLicenseInformation() {
        return licenseInformation;
    }

    public List<LinkingAgent> getLinkingagents() {
        return linkingagents;
    }

    public List<LinkingObject> getLinkingObjects() {
        return linkingObjects;
    }

    public String getRightsBasis() {
        return rightsBasis;
    }

    public List<GrantedRights> getRightsGranted() {
        return rightsGranted;
    }

    public Identifier getRightsStatementIdentifier() {
        return rightsStatementIdentifier;
    }

    public List<StatuteInformation> getStatuteInformation() {
        return statuteInformation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((copyrightInformation == null) ? 0 : copyrightInformation.hashCode());
        result = prime * result + ((licenseInformation == null) ? 0 : licenseInformation.hashCode());
        result = prime * result + ((linkingObjects == null) ? 0 : linkingObjects.hashCode());
        result = prime * result + ((linkingagents == null) ? 0 : linkingagents.hashCode());
        result = prime * result + ((rightsBasis == null) ? 0 : rightsBasis.hashCode());
        result = prime * result + ((rightsGranted == null) ? 0 : rightsGranted.hashCode());
        result = prime * result + ((rightsStatementIdentifier == null) ? 0 : rightsStatementIdentifier.hashCode());
        result = prime * result + ((statuteInformation == null) ? 0 : statuteInformation.hashCode());
        return result;
    }
    
    
    

    @Override
	public String toString() {
		return "RightsStatement [rightsStatementIdentifier="
				+ rightsStatementIdentifier + ", rightsBasis=" + rightsBasis
				+ ", copyrightInformation=" + copyrightInformation
				+ ", licenseInformation=" + licenseInformation
				+ ", statuteInformation=" + statuteInformation
				+ ", rightsGranted=" + rightsGranted + ", linkingObjects="
				+ linkingObjects + ", linkingagents=" + linkingagents + "]";
	}




	public static class Builder {
        private Identifier rightsStatementIdentifier;
        private String rightsBasis;
        private CopyRightInformation copyrightInformation;
        private LicenseInformation licenseInformation;
        private List<StatuteInformation> statuteInformation;
        private List<GrantedRights> rightsGranted;
        private List<LinkingObject> linkingObjects;
        private List<LinkingAgent> linkingagents;

        public RightsStatement build() {
            return new RightsStatement(this);
        }

        public Builder copyrightInformation(CopyRightInformation copyrightInformation) {
            this.copyrightInformation = copyrightInformation;
            return this;
        }

        public Builder licenseInformation(LicenseInformation licenseInformation) {
            this.licenseInformation = licenseInformation;
            return this;
        }

        public Builder linkingAgents(List<LinkingAgent> linkingagents) {
            this.linkingagents = linkingagents;
            return this;
        }

        public Builder linkingObjects(List<LinkingObject> linkingObjects) {
            this.linkingObjects = linkingObjects;
            return this;
        }

        public Builder rightsBasis(String rightsBasis) {
            this.rightsBasis = rightsBasis;
            return this;
        }

        public Builder rightsGranted(List<GrantedRights> rightsGranted) {
            this.rightsGranted = rightsGranted;
            return this;
        }

        public Builder rightsStatementIdentifier(Identifier rightsStatementIdentifier) {
            this.rightsStatementIdentifier = rightsStatementIdentifier;
            return this;
        }

        public Builder statuteInformation(List<StatuteInformation> statuteInformation) {
            this.statuteInformation = statuteInformation;
            return this;
        }
    }
}
