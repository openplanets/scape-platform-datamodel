package eu.scapeproject.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.dto.mets.MetsDocument;

@XmlRootElement(name="entity-list",namespace="http://scapeproject.eu/model")
public class IntellectualEntityCollection {
    @XmlElement(name="mets",namespace="http://www.loc.gov/METS/")
    private final List<MetsDocument> entities;
    
    @SuppressWarnings("unused")
    private IntellectualEntityCollection(){
        this.entities=null;
    }
    
    public IntellectualEntityCollection(List<MetsDocument> documents) {
        this.entities=documents;
    }
    
    public List<MetsDocument> getEntities() {
        return entities;
    }
}
