package eu.scapeproject.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "version-list", namespace = "http://scapeproject.eu/model")
public class VersionList {

    @XmlAttribute(name = "id")
    private final String entityId;
    @XmlElement(name = "version", namespace = "http://scapeproject.eu/model")
    private final List<String> versionIdentifiers;

    @SuppressWarnings("unused")
    private VersionList() {
        this.versionIdentifiers = null;
        this.entityId = null;
    }

    public VersionList(String entitiyId, List<String> versionIdentifiers) {
        this.versionIdentifiers = versionIdentifiers;
        this.entityId = entitiyId;
    }

    public String getEntityId() {
        return entityId;
    };

    public List<String> getVersionIdentifiers() {
        return versionIdentifiers;
    }

    @Override
    public String toString() {
        return "VersionList ["
                + "entityId=" + entityId
                + ", versionIdentifiers=" + versionIdentifiers
                + "]";
    }

}