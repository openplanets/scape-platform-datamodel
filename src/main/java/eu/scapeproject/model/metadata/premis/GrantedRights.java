package eu.scapeproject.model.metadata.premis;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grantedRights", namespace = "http://www.loc.gov/standards/premis")
public class GrantedRights {
    @XmlElement(name = "act", namespace = "http://www.loc.gov/standards/premis")
    private String act;
    @XmlElement(name = "restriction", namespace = "http://www.loc.gov/standards/premis")
    private String restriction;
    @XmlElement(name = "termOfGrant", namespace = "http://www.loc.gov/standards/premis")
    private TermOfGrant termOfGrant;
    @XmlElement(name = "rightsGrantedNotes", namespace = "http://www.loc.gov/standards/premis")
    private List<String> rightsGrantedNotes;

    private GrantedRights() {
        super();
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
}
