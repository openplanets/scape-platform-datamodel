package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.dc.DCMetadata;

@XmlSeeAlso({DCMetadata.class})
public class DescriptiveMetadata {
    @XmlAttribute(name="type")
    public MetadataType metadataType;

    @SuppressWarnings("unused")
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
