package eu.scapeproject.model.metadata.mix;

public class PhotometricInterpretation {
    private String colorSpace;
    private ColorProfile colorProfile;
    private YCbCr ybCbCr;
    private SpecialFormatCharacteristics specialFormatCharacteristics;
    private ReferencedBlackWhite referencedBlackWhite;

    private PhotometricInterpretation() {
        super();
    }

    private PhotometricInterpretation(Builder builder) {
        this.colorSpace = builder.colorSpace;
        this.colorProfile = builder.colorProfile;
        this.ybCbCr = builder.ybCbCr;
        this.specialFormatCharacteristics = builder.specialFormatCharacteristics;
        this.referencedBlackWhite = builder.referencedBlackWhite;
    }

    public ColorProfile getColorProfile() {
        return colorProfile;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    public ReferencedBlackWhite getReferencedBlackWhite() {
        return referencedBlackWhite;
    }

    public SpecialFormatCharacteristics getSpecialFormatCharacteristics() {
        return specialFormatCharacteristics;
    }

    public YCbCr getYbCbCr() {
        return ybCbCr;
    }

    public static class Builder {
        private String colorSpace;
        private ColorProfile colorProfile;
        private YCbCr ybCbCr;
        private SpecialFormatCharacteristics specialFormatCharacteristics;
        private ReferencedBlackWhite referencedBlackWhite;

        public PhotometricInterpretation build() {
            return new PhotometricInterpretation(this);
        }

        public Builder colorProfile(ColorProfile colorProfile) {
            this.colorProfile = colorProfile;
            return this;
        }

        public Builder colorSpace(String colorSpace) {
            this.colorSpace = colorSpace;
            return this;
        }

        public Builder referencedBlackWhite(ReferencedBlackWhite referencedBlackWhite) {
            this.referencedBlackWhite = referencedBlackWhite;
            return this;
        }

        public Builder specialFormatCharacteristics(SpecialFormatCharacteristics specialFormatCharacteristics) {
            this.specialFormatCharacteristics = specialFormatCharacteristics;
            return this;
        }

        public Builder ybCbCr(YCbCr ybCbCr) {
            this.ybCbCr = ybCbCr;
            return this;
        }
    }
}
