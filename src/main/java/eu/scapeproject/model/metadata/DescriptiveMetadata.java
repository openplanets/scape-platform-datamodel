package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;

@XmlSeeAlso({ DCMetadata.class })
@XmlRootElement(name = "descriptive", namespace = "http://scapeproject.eu/model")
public abstract class DescriptiveMetadata extends MetsMetadata {
    private final MetadataType type;

    public DescriptiveMetadata(MetadataType type) {
        super();
        this.type = type;
    }

    public DescriptiveMetadata(MetadataType type, String id) {
        super(id);
        this.type = type;
    }

    public enum MetadataType {
        DC, MARC21;
    }

}
