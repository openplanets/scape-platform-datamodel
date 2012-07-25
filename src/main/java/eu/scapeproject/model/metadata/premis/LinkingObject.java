package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.jaxb.PremisLinkingObjectIdentifierAdapter;

@XmlRootElement(name="linkingObject",namespace="http://www.loc.gov/standards/premis")
public class LinkingObject {
    @XmlElement(name="linkingObjectIdentifier",namespace="http://www.loc.gov/standards/premis")
    @XmlJavaTypeAdapter(PremisLinkingObjectIdentifierAdapter.class)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((linkingObjectIdentifier == null) ? 0 : linkingObjectIdentifier.hashCode());
        result = prime * result + ((linkingObjectRole == null) ? 0 : linkingObjectRole.hashCode());
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
        LinkingObject other = (LinkingObject) obj;
        if (linkingObjectIdentifier == null) {
            if (other.linkingObjectIdentifier != null)
                return false;
        } else if (!linkingObjectIdentifier.equals(other.linkingObjectIdentifier))
            return false;
        if (linkingObjectRole == null) {
            if (other.linkingObjectRole != null)
                return false;
        } else if (!linkingObjectRole.equals(other.linkingObjectRole))
            return false;
        return true;
    }
    
}
