package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;

public class PhotometricInterpretation {
    @XmlElement(name="colorSpace",namespace="http://www.loc.gov/mix/v10")
    private String colorSpace;
    @XmlElement(name="colorProfile",namespace="http://www.loc.gov/mix/v10")
    private ColorProfile colorProfile;
    @XmlElement(name="YCbCr",namespace="http://www.loc.gov/mix/v10")
    private YCbCr ybCbCr;
    @XmlElement(name="specialFormatCharacteristics",namespace="http://www.loc.gov/mix/v10")
    private SpecialFormatCharacteristics specialFormatCharacteristics;
    @XmlElement(name="referenceBlackWhite",namespace="http://www.loc.gov/mix/v10")
    private ReferenceBlackWhite referencedBlackWhite;

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

    public ReferenceBlackWhite getReferencedBlackWhite() {
        return referencedBlackWhite;
    }

    public SpecialFormatCharacteristics getSpecialFormatCharacteristics() {
        return specialFormatCharacteristics;
    }

    public YCbCr getYbCbCr() {
        return ybCbCr;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colorProfile == null) ? 0 : colorProfile.hashCode());
        result = prime * result + ((colorSpace == null) ? 0 : colorSpace.hashCode());
        result = prime * result + ((referencedBlackWhite == null) ? 0 : referencedBlackWhite.hashCode());
        result = prime * result + ((specialFormatCharacteristics == null) ? 0 : specialFormatCharacteristics.hashCode());
        result = prime * result + ((ybCbCr == null) ? 0 : ybCbCr.hashCode());
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
        PhotometricInterpretation other = (PhotometricInterpretation) obj;
        if (colorProfile == null) {
            if (other.colorProfile != null)
                return false;
        } else if (!colorProfile.equals(other.colorProfile))
            return false;
        if (colorSpace == null) {
            if (other.colorSpace != null)
                return false;
        } else if (!colorSpace.equals(other.colorSpace))
            return false;
        if (referencedBlackWhite == null) {
            if (other.referencedBlackWhite != null)
                return false;
        } else if (!referencedBlackWhite.equals(other.referencedBlackWhite))
            return false;
        if (specialFormatCharacteristics == null) {
            if (other.specialFormatCharacteristics != null)
                return false;
        } else if (!specialFormatCharacteristics.equals(other.specialFormatCharacteristics))
            return false;
        if (ybCbCr == null) {
            if (other.ybCbCr != null)
                return false;
        } else if (!ybCbCr.equals(other.ybCbCr))
            return false;
        return true;
    }

    public static class Builder {
        private String colorSpace;
        private ColorProfile colorProfile;
        private YCbCr ybCbCr;
        private SpecialFormatCharacteristics specialFormatCharacteristics;
        private ReferenceBlackWhite referencedBlackWhite;

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

        public Builder referencedBlackWhite(ReferenceBlackWhite referencedBlackWhite) {
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
