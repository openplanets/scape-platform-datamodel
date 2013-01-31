package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.marc.Marc21Metadata;

@XmlSeeAlso({ DCMetadata.class, Marc21Metadata.class })
@XmlRootElement(name = "descriptive", namespace = "http://scapeproject.eu/model")
public abstract class DescriptiveMetadata extends MetsMetadata {
    private final MetadataType type;

    private DescriptiveMetadata() {
        super();
        this.type = null;
    }

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
