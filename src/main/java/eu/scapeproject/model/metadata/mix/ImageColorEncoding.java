package eu.scapeproject.model.metadata.mix;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class ImageColorEncoding {
    private String bitsPerSampleValue;
    private BitsPerSampleUnit bitsPerSampleUnit;
    private int samplesPerPixel;
    private ExtraSamples extraSamples;
    private URI colorMapReference;
    private byte[] embeddedColorMap;
    private short grayResponseCurve;
    private GrayResponseUnit grayResponseUnit;
    private List<WhitePoint> whitePoints;

    private ImageColorEncoding(Builder builder) {
        this.bitsPerSampleValue = builder.bitsPerSampleValue;
        this.bitsPerSampleUnit = builder.bitsPerSampleUnit;
        this.samplesPerPixel = builder.samplesPerPixel;
        this.extraSamples = builder.extraSamples;
        this.colorMapReference = builder.colorMapReference;
        this.embeddedColorMap = builder.embeddedColorMap;
        this.grayResponseCurve = builder.grayResponseCurve;
        this.grayResponseUnit = builder.grayResponseUnit;
        this.whitePoints = builder.whitePoints;
    }

    public BitsPerSampleUnit getBitsPerSampleUnit() {
        return bitsPerSampleUnit;
    }

    public String getBitsPerSampleValue() {
        return bitsPerSampleValue;
    }

    public URI getColorMapReference() {
        return colorMapReference;
    }

    public byte[] getEmbeddedColorMap() {
        return embeddedColorMap;
    }

    public ExtraSamples getExtraSamples() {
        return extraSamples;
    }

    public short getGrayResponseCurve() {
        return grayResponseCurve;
    }

    public GrayResponseUnit getGrayResponseUnit() {
        return grayResponseUnit;
    }

    public int getSamplesPerPixel() {
        return samplesPerPixel;
    }

    public List<WhitePoint> getWhitePoints() {
        return whitePoints;
    }

    public enum BitsPerSampleUnit {
        FLOAT, INTEGER;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bitsPerSampleUnit == null) ? 0 : bitsPerSampleUnit.hashCode());
        result = prime * result + ((bitsPerSampleValue == null) ? 0 : bitsPerSampleValue.hashCode());
        result = prime * result + ((colorMapReference == null) ? 0 : colorMapReference.hashCode());
        result = prime * result + Arrays.hashCode(embeddedColorMap);
        result = prime * result + ((extraSamples == null) ? 0 : extraSamples.hashCode());
        result = prime * result + grayResponseCurve;
        result = prime * result + ((grayResponseUnit == null) ? 0 : grayResponseUnit.hashCode());
        result = prime * result + samplesPerPixel;
        result = prime * result + ((whitePoints == null) ? 0 : whitePoints.hashCode());
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
        ImageColorEncoding other = (ImageColorEncoding) obj;
        if (bitsPerSampleUnit != other.bitsPerSampleUnit)
            return false;
        if (bitsPerSampleValue == null) {
            if (other.bitsPerSampleValue != null)
                return false;
        } else if (!bitsPerSampleValue.equals(other.bitsPerSampleValue))
            return false;
        if (colorMapReference == null) {
            if (other.colorMapReference != null)
                return false;
        } else if (!colorMapReference.equals(other.colorMapReference))
            return false;
        if (!Arrays.equals(embeddedColorMap, other.embeddedColorMap))
            return false;
        if (extraSamples != other.extraSamples)
            return false;
        if (grayResponseCurve != other.grayResponseCurve)
            return false;
        if (grayResponseUnit != other.grayResponseUnit)
            return false;
        if (samplesPerPixel != other.samplesPerPixel)
            return false;
        if (whitePoints == null) {
            if (other.whitePoints != null)
                return false;
        } else if (!whitePoints.equals(other.whitePoints))
            return false;
        return true;
    }

    public static class Builder {
        private String bitsPerSampleValue;
        private BitsPerSampleUnit bitsPerSampleUnit;
        private int samplesPerPixel;
        private ExtraSamples extraSamples;
        private URI colorMapReference;
        private byte[] embeddedColorMap;
        private short grayResponseCurve;
        private GrayResponseUnit grayResponseUnit;
        private List<WhitePoint> whitePoints;

        public Builder bitsPerSampleUnit(BitsPerSampleUnit bitsPerSampleUnit) {
            this.bitsPerSampleUnit = bitsPerSampleUnit;
            return this;
        }

        public Builder bitsPerSampleValue(String bitsPerSampleValue) {
            this.bitsPerSampleValue = bitsPerSampleValue;
            return this;
        }

        public ImageColorEncoding build() {
            return new ImageColorEncoding(this);
        }

        public Builder colorMapReference(URI colorMapReference) {
            this.colorMapReference = colorMapReference;
            return this;
        }

        public Builder embeddedColorMap(byte[] embeddedColorMap) {
            this.embeddedColorMap = embeddedColorMap;
            return this;
        }

        public Builder extraSamples(ExtraSamples extraSamples) {
            this.extraSamples = extraSamples;
            return this;
        }

        public Builder grayResponseCurve(short grayResponseCurve) {
            this.grayResponseCurve = grayResponseCurve;
            return this;
        }

        public Builder grayResponseUnit(GrayResponseUnit grayResponseUnit) {
            this.grayResponseUnit = grayResponseUnit;
            return this;
        }

        public Builder samplesPerPixel(int samplesPerPixel) {
            this.samplesPerPixel = samplesPerPixel;
            return this;
        }

        public Builder whitePoints(List<WhitePoint> whitePoints) {
            this.whitePoints = whitePoints;
            return this;
        }
    }

    public enum ExtraSamples {
        UNSPECIFIED_DATA, ASSOCIATED_ALPHA_DATA, UNASSOCIATED_ALPHA_DATA, RANGE_OR_DEPTH_DATA;
    }

    public enum GrayResponseUnit {
        TENTH_OF_A_UNIT, HUNDREDS_OF_A_UNIT, THOUSANDS_OF_A_UNIT, TEN_THOUSANDS_OF_A_UNIT, HUNDRED_THOUSANDS_OF_A_UNIT;
    }

    public static class PrimaryChromaticies {
        private String primaryChromaticiesRedX;
        private String primaryChromaticiesRedY;
        private String primaryChromaticiesGreenX;
        private String primaryChromaticieGreenY;
        private String primaryChromaticiesBlueX;
        private String primaryChromaticiesBlueY;
        public String getPrimaryChromaticieGreenY() {
            return primaryChromaticieGreenY;
        }
        public String getPrimaryChromaticiesBlueX() {
            return primaryChromaticiesBlueX;
        }
        public String getPrimaryChromaticiesBlueY() {
            return primaryChromaticiesBlueY;
        }
        public String getPrimaryChromaticiesGreenX() {
            return primaryChromaticiesGreenX;
        }
        public String getPrimaryChromaticiesRedX() {
            return primaryChromaticiesRedX;
        }
        public String getPrimaryChromaticiesRedY() {
            return primaryChromaticiesRedY;
        }
        
        
    }

    public static class WhitePoint {
        private String whitePointXValue;
        private String whitePointYValue;

        public WhitePoint(String whitePointXValue, String whitePointYValue) {
            super();
            this.whitePointXValue = whitePointXValue;
            this.whitePointYValue = whitePointYValue;
        }

        public String getWhitePointXValue() {
            return whitePointXValue;
        }

        public String getWhitePointYValue() {
            return whitePointYValue;
        }

    }
}
