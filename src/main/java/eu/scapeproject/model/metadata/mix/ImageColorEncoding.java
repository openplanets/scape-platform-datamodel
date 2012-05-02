package eu.scapeproject.model.metadata.mix;

import java.net.URI;
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
