package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name="linkingObject",namespace="http://www.loc.gov/standards/premis")
public class LinkingObject {
    @XmlElement(name="linkingObjectIdentifier",namespace="http://www.loc.gov/standards/premis")
    private Identifier linkingObjectIdentifier;
    @XmlElement(name="linkingObjectRole",namespace="http://www.loc.gov/standards/premis")
    private List<String> linkingObjectRole;

    @SuppressWarnings("unused")
    private LinkingObject() {
        super();
    }

    public LinkingObject(Identifier linkingObjectIdentifier, List<String> linkingObjectRole) {
        super();
        this.linkingObjectIdentifier = linkingObjectIdentifier;
        this.linkingObjectRole = linkingObjectRole;
    }

    public Identifier getLinkingObjectIdentifier() {
        return linkingObjectIdentifier;
    }

    public List<String> getLinkingObjectRole() {
        return linkingObjectRole;
    }
}
