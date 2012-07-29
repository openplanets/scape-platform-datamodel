package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grantedRights", namespace = "http://www.loc.gov/standards/premis")
public class GrantedRights {
    @XmlElement(name = "act", namespace = "http://www.loc.gov/standards/premis")
    private final String act;
    @XmlElement(name = "restriction", namespace = "http://www.loc.gov/standards/premis")
    private final String restriction;
    @XmlElement(name = "termOfGrant", namespace = "http://www.loc.gov/standards/premis")
    private final TermOfGrant termOfGrant;
    @XmlElement(name = "rightsGrantedNotes", namespace = "http://www.loc.gov/standards/premis")
    private final List<String> rightsGrantedNotes;

    @SuppressWarnings("unused")
    private GrantedRights() {
        super();
        this.act=null;
        this.restriction=null;
        this.termOfGrant=null;
        this.rightsGrantedNotes=null;
    }

    public GrantedRights(String act, String restriction, TermOfGrant termOfGrant, List<String> rightsGrantedNotes) {
        super();
        this.act = act;
        this.restriction = restriction;
        this.termOfGrant = termOfGrant;
        this.rightsGrantedNotes = rightsGrantedNotes;
    }

    public String getAct() {
        return act;
    }

    public String getRestriction() {
        return restriction;
    }

    public List<String> getRightsGrantedNotes() {
        return rightsGrantedNotes;
    }

    public TermOfGrant getTermOfGrant() {
        return termOfGrant;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((act == null) ? 0 : act.hashCode());
        result = prime * result + ((restriction == null) ? 0 : restriction.hashCode());
        result = prime * result + ((rightsGrantedNotes == null) ? 0 : rightsGrantedNotes.hashCode());
        result = prime * result + ((termOfGrant == null) ? 0 : termOfGrant.hashCode());
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
        GrantedRights other = (GrantedRights) obj;
        if (act == null) {
            if (other.act != null)
                return false;
        } else if (!act.equals(other.act))
            return false;
        if (restriction == null) {
            if (other.restriction != null)
                return false;
        } else if (!restriction.equals(other.restriction))
            return false;
        if (rightsGrantedNotes == null) {
            if (other.rightsGrantedNotes != null)
                return false;
        } else if (!rightsGrantedNotes.equals(other.rightsGrantedNotes))
            return false;
        if (termOfGrant == null) {
            if (other.termOfGrant != null)
                return false;
        } else if (!termOfGrant.equals(other.termOfGrant))
            return false;
        return true;
    }
    
    
}
