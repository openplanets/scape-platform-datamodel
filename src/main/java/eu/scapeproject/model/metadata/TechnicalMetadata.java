package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

@XmlSeeAlso({ NisoMixMetadata.class, FitsMetadata.class, TextMDMetadata.class, AudioMDMetadata.class, VideoMDMetadata.class })
public abstract class TechnicalMetadata{
    protected MetadataType metadataType;

    @SuppressWarnings("unused")
    private TechnicalMetadata() {
        super();
    }

    public TechnicalMetadata(MetadataType type) {
        this.metadataType = type;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }

    public enum MetadataType {
        TEXTMD, NISO_MIX, FITS, AUDIOMD, VIDEOMD;
    }
}
