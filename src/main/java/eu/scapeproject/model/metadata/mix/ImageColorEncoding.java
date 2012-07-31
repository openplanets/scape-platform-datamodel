package eu.scapeproject.model.metadata.mix;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="imageColorEncoding",namespace="http://www.loc.gov/mix/v10")
public class ImageColorEncoding {
    @XmlElement(name="bitsPerSampleValue",namespace="http://www.loc.gov/mix/v10")
    private final String bitsPerSampleValue;
    @XmlElement(name="bitsPerSampleUnit",namespace="http://www.loc.gov/mix/v10")
    private final BitsPerSampleUnit bitsPerSampleUnit;
    @XmlElement(name="samplesPerPixel",namespace="http://www.loc.gov/mix/v10")
    private final int samplesPerPixel;
    @XmlElement(name="extraSamples",namespace="http://www.loc.gov/mix/v10")
    private final ExtraSamples extraSamples;
    @XmlElement(name="colorMapReference",namespace="http://www.loc.gov/mix/v10")
    private final URI colorMapReference;
    @XmlElement(name="embeddedColorMap",namespace="http://www.loc.gov/mix/v10")
    private final byte[] embeddedColorMap;
    @XmlElement(name="grayResponseCurve",namespace="http://www.loc.gov/mix/v10")
    private final short grayResponseCurve;
    @XmlElement(name="grayResponseUnit",namespace="http://www.loc.gov/mix/v10")
    private final GrayResponseUnit grayResponseUnit;
    @XmlElement(name="whitePoints",namespace="http://www.loc.gov/mix/v10")
    private final List<WhitePoint> whitePoints;

	private ImageColorEncoding() {
		super();
        this.bitsPerSampleValue = null;
        this.bitsPerSampleUnit = null;
        this.samplesPerPixel = 0;
        this.extraSamples = null;
        this.colorMapReference = null;
        this.embeddedColorMap = null;
        this.grayResponseCurve = 0;
        this.grayResponseUnit = null;
        this.whitePoints = null;
	}
    
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

    @XmlRootElement(name="primaryChromaticies",namespace="http://www.loc.gov/mix/v10")
    public static class PrimaryChromaticies {
        @XmlElement(name="primaryChromaticiesRedX",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticiesRedX;
        @XmlElement(name="primaryChromaticiesRedY",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticiesRedY;
        @XmlElement(name="primaryChromaticiesGreenX",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticiesGreenX;
        @XmlElement(name="primaryChromaticieGreenY",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticieGreenY;
        @XmlElement(name="primaryChromaticiesBlueX",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticiesBlueX;
        @XmlElement(name="primaryChromaticiesBlueY",namespace="http://www.loc.gov/mix/v10")
        private String primaryChromaticiesBlueY;
        
		private PrimaryChromaticies() {
			super();
		}

        @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PrimaryChromaticies other = (PrimaryChromaticies) obj;
			if (primaryChromaticieGreenY == null) {
				if (other.primaryChromaticieGreenY != null)
					return false;
			} else if (!primaryChromaticieGreenY.equals(other.primaryChromaticieGreenY))
				return false;
			if (primaryChromaticiesBlueX == null) {
				if (other.primaryChromaticiesBlueX != null)
					return false;
			} else if (!primaryChromaticiesBlueX.equals(other.primaryChromaticiesBlueX))
				return false;
			if (primaryChromaticiesBlueY == null) {
				if (other.primaryChromaticiesBlueY != null)
					return false;
			} else if (!primaryChromaticiesBlueY.equals(other.primaryChromaticiesBlueY))
				return false;
			if (primaryChromaticiesGreenX == null) {
				if (other.primaryChromaticiesGreenX != null)
					return false;
			} else if (!primaryChromaticiesGreenX.equals(other.primaryChromaticiesGreenX))
				return false;
			if (primaryChromaticiesRedX == null) {
				if (other.primaryChromaticiesRedX != null)
					return false;
			} else if (!primaryChromaticiesRedX.equals(other.primaryChromaticiesRedX))
				return false;
			if (primaryChromaticiesRedY == null) {
				if (other.primaryChromaticiesRedY != null)
					return false;
			} else if (!primaryChromaticiesRedY.equals(other.primaryChromaticiesRedY))
				return false;
			return true;
		}
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((primaryChromaticieGreenY == null) ? 0 : primaryChromaticieGreenY.hashCode());
			result = prime * result + ((primaryChromaticiesBlueX == null) ? 0 : primaryChromaticiesBlueX.hashCode());
			result = prime * result + ((primaryChromaticiesBlueY == null) ? 0 : primaryChromaticiesBlueY.hashCode());
			result = prime * result + ((primaryChromaticiesGreenX == null) ? 0 : primaryChromaticiesGreenX.hashCode());
			result = prime * result + ((primaryChromaticiesRedX == null) ? 0 : primaryChromaticiesRedX.hashCode());
			result = prime * result + ((primaryChromaticiesRedY == null) ? 0 : primaryChromaticiesRedY.hashCode());
			return result;
		}
        
    }

    @XmlRootElement(name="whitePoint",namespace="http://www.loc.gov/mix/v10")
    public static class WhitePoint {
        @XmlElement(name="whitePointXValue",namespace="http://www.loc.gov/mix/v10")
        private String whitePointXValue;
        @XmlElement(name="whitePointYValue",namespace="http://www.loc.gov/mix/v10")
        private String whitePointYValue;

        @SuppressWarnings("unused")
        private WhitePoint() {
			super();
		}
		
        public WhitePoint(String whitePointXValue, String whitePointYValue) {
            super();
            this.whitePointXValue = whitePointXValue;
            this.whitePointYValue = whitePointYValue;
        }

        @Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WhitePoint other = (WhitePoint) obj;
			if (whitePointXValue == null) {
				if (other.whitePointXValue != null)
					return false;
			} else if (!whitePointXValue.equals(other.whitePointXValue))
				return false;
			if (whitePointYValue == null) {
				if (other.whitePointYValue != null)
					return false;
			} else if (!whitePointYValue.equals(other.whitePointYValue))
				return false;
			return true;
		}

        public String getWhitePointXValue() {
            return whitePointXValue;
        }

		public String getWhitePointYValue() {
            return whitePointYValue;
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((whitePointXValue == null) ? 0 : whitePointXValue.hashCode());
			result = prime * result + ((whitePointYValue == null) ? 0 : whitePointYValue.hashCode());
			return result;
		}

    }
}
