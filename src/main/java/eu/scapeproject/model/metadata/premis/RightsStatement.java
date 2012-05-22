package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name="rightsStatement",namespace="http://www.loc.gov/standards/premis")
public class RightsStatement {
    @XmlElement(name="rightsStatementIdentifier",namespace="http://www.loc.gov/standards/premis")
    private Identifier rightsStatementIdentifier;
    @XmlElement(name="rightsBasis",namespace="http://www.loc.gov/standards/premis")
    private String rightsBasis;
    @XmlElement(name="copyrightInformation",namespace="http://www.loc.gov/standards/premis")
    private CopyRightInformation copyrightInformation;
    @XmlElement(name="licenseInformation",namespace="http://www.loc.gov/standards/premis")
    private LicenseInformation licenseInformation;
    @XmlElement(name="statuteInformation",namespace="http://www.loc.gov/standards/premis")
    private List<StatuteInformation> statuteInformation;
    @XmlElement(name="rightsGranted",namespace="http://www.loc.gov/standards/premis")
    private List<GrantedRights> rightsGranted;
    @XmlElement(name="linkingObjects",namespace="http://www.loc.gov/standards/premis")
    private List<LinkingObject> linkingObjects;
    @XmlElement(name="linkingagents",namespace="http://www.loc.gov/standards/premis")
    private List<LinkingAgent> linkingagents;

    private RightsStatement(){
        super();
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
