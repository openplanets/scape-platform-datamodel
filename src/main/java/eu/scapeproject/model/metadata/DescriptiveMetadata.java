package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlAttribute;

public class DescriptiveMetadata {
    @XmlAttribute(name="type")
    public MetadataType metadataType;

    private DescriptiveMetadata() {
        super();
    }

    public DescriptiveMetadata(MetadataType type) {
        super();
        this.metadataType = type;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }

    public enum MetadataType {
        DC;
    }

}
