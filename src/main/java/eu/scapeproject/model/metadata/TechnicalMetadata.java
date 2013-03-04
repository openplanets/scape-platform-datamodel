package eu.scapeproject.model.metadata;


public abstract class TechnicalMetadata {
    private MetadataType metadataType;
    private String id;

    public TechnicalMetadata(MetadataType type, String id) {
        this.metadataType = type;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public MetadataType getMetadataType() {
        return metadataType;
    }

    public enum MetadataType {
        TEXTMD, NISO_MIX, FITS, AUDIOMD, VIDEOMD, GOOGLE_BOOK_SCAN, GOOGLE_PRODUCTION_NOTES;
    }

    @Override
    public String toString() {
        return "TechnicalMetadata [metadataType=" + metadataType + "]";
    }

}
