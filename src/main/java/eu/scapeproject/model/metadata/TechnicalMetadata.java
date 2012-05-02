package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.mix.NisoMixMetadata;


@XmlSeeAlso({NisoMixMetadata.class})
public abstract class TechnicalMetadata {
    protected MetadataType metadataType;

    private TechnicalMetadata(){
        super();
    }
    
    public TechnicalMetadata(MetadataType type) {
        this.metadataType = type;
    }

    public enum MetadataType {
        TEXTMD, NISO_MIX;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }
}
