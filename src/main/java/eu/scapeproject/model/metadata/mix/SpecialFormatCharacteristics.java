package eu.scapeproject.model.metadata.mix;

public abstract class SpecialFormatCharacteristics {
    protected Format format;

    public enum Format {
        JPG_2000, MR_SID, DJVU;
    }

    public SpecialFormatCharacteristics(Format format) {
        super();
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

}
