package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;


@XmlSeeAlso({NisoMixMetadata.class,FitsMetadata.class,TextMDMetadata.class, AudioMDMetadata.class})
public abstract class TechnicalMetadata {
    protected MetadataType metadataType;

    private TechnicalMetadata(){
        super();
    }
    
    public TechnicalMetadata(MetadataType type) {
        this.metadataType = type;
    }

    public enum MetadataType {
        TEXTMD, NISO_MIX, FITS,AUDIOMD,VIDEOMD;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }
}
