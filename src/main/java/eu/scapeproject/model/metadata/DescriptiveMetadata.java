package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "descriptive", namespace = "http://scapeproject.eu/model")
public abstract class DescriptiveMetadata {

    private MetadataType type;
    private String id;

    public DescriptiveMetadata() {
        super();
    }

    public DescriptiveMetadata(String id, MetadataType type) {
        this.id = id;
        this.type = type;
    }

    public MetadataType getType() {
        return type;
    }

    public enum MetadataType {
        DC, MARC21;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(MetadataType type) {
        this.type = type;
    }
}
