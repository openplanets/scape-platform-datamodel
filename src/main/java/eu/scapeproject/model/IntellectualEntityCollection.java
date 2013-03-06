package eu.scapeproject.model;

import gov.loc.mets.MetsType;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entity-list", namespace = "http://scapeproject.eu/model")
public class IntellectualEntityCollection {
    @XmlElement(name = "mets", namespace = "http://www.loc.gov/METS/")
    private final List<MetsType> entities;

    @SuppressWarnings("unused")
    private IntellectualEntityCollection() {
        this.entities = null;
    }

    public IntellectualEntityCollection(List<MetsType> documents) {
        this.entities = documents;
    }

    public List<MetsType> getEntities() {
        return entities;
    }
}