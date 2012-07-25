package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.jaxb.PremisLinkingAgentIdentifierAdapter;

@XmlRootElement(name = "linkingAgent", namespace = "http://www.loc.gov/standards/premis")
public class LinkingAgent {
    @XmlElement(name = "linkingAgentIdentifier", namespace = "http://www.loc.gov/standards/premis")
    @XmlJavaTypeAdapter(PremisLinkingAgentIdentifierAdapter.class)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((linkingAgentIdentifier == null) ? 0 : linkingAgentIdentifier.hashCode());
        result = prime * result + ((linkingAgentRole == null) ? 0 : linkingAgentRole.hashCode());
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
        LinkingAgent other = (LinkingAgent) obj;
        if (linkingAgentIdentifier == null) {
            if (other.linkingAgentIdentifier != null)
                return false;
        } else if (!linkingAgentIdentifier.equals(other.linkingAgentIdentifier))
            return false;
        if (linkingAgentRole == null) {
            if (other.linkingAgentRole != null)
                return false;
        } else if (!linkingAgentRole.equals(other.linkingAgentRole))
            return false;
        return true;
    }
    
    
}
