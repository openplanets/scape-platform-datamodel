package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name = "linkingAgent", namespace = "http://www.loc.gov/standards/premis")
public class LinkingAgent {
    @XmlElement(name = "linkingAgentIdentifier", namespace = "http://www.loc.gov/standards/premis")
    private Identifier linkingAgentIdentifier;
    @XmlElement(name = "linkingAgentRole", namespace = "http://www.loc.gov/standards/premis")
    private List<String> linkingAgentRole;

    @SuppressWarnings("unused")
    private LinkingAgent() {
        super();
    }

    public LinkingAgent(Identifier linkingAgentIdentifier, List<String> linkingAgentRole) {
        super();
        this.linkingAgentIdentifier = linkingAgentIdentifier;
        this.linkingAgentRole = linkingAgentRole;
    }

    public Identifier getLinkingAgentIdentifier() {
        return linkingAgentIdentifier;
    }

    public List<String> getLinkingAgentRole() {
        return linkingAgentRole;
    }
}
