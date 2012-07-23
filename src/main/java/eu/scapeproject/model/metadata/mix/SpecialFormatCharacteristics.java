package eu.scapeproject.model.metadata.mix;

public abstract class SpecialFormatCharacteristics {
    protected Format format;

    public SpecialFormatCharacteristics(Format format) {
        super();
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((format == null) ? 0 : format.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpecialFormatCharacteristics other = (SpecialFormatCharacteristics) obj;
        if (format != other.format)
            return false;
        return true;
    }

    public enum Format {
        JPG_2000, MR_SID, DJVU;
    }

}
