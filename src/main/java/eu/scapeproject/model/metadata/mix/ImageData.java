package eu.scapeproject.model.metadata.mix;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="imageData", namespace = "http://www.loc.gov/mix/v10")
public class ImageData {
    @XmlElement(name="fNumber", namespace = "http://www.loc.gov/mix/v10")
    private final double fNumber;
    @XmlElement(name="exposureTime", namespace = "http://www.loc.gov/mix/v10")
    private final double exposureTime;
    @XmlElement(name="exposureProgram", namespace = "http://www.loc.gov/mix/v10")
    private final ExposureProgram exposureProgram;
    @XmlElement(name="spectralSensitivity", namespace = "http://www.loc.gov/mix/v10")
    private final List<String> spectralSensitivity;
    @XmlElement(name="isoSpeedRatings", namespace = "http://www.loc.gov/mix/v10")
    private final int isoSpeedRatings;
    @XmlElement(name="oECF", namespace = "http://www.loc.gov/mix/v10")
    private final double oECF;
    @XmlElement(name="exifVersion", namespace = "http://www.loc.gov/mix/v10")
    private final ExifVersion exifVersion;
    @XmlElement(name="shutterSpeedValue", namespace = "http://www.loc.gov/mix/v10")
    private final double shutterSpeedValue;
    @XmlElement(name="apertureValue", namespace = "http://www.loc.gov/mix/v10")
    private final double apertureValue;
    @XmlElement(name="brightnessValue", namespace = "http://www.loc.gov/mix/v10")
    private final double brightnessValue;
    @XmlElement(name="exposeBiasValue", namespace = "http://www.loc.gov/mix/v10")
    private final double exposeBiasValue;
    @XmlElement(name="maxApertureValue", namespace = "http://www.loc.gov/mix/v10")
    private final double maxApertureValue;
    @XmlElement(name="subjectDistance", namespace = "http://www.loc.gov/mix/v10")
    private final double subjectDistance;
    @XmlElement(name="meteringMode", namespace = "http://www.loc.gov/mix/v10")
    private final MeteringMode meteringMode;
    @XmlElement(name="lightSource", namespace = "http://www.loc.gov/mix/v10")
    private final LightSource lightSource;
    @XmlElement(name="flash", namespace = "http://www.loc.gov/mix/v10")
    private final Flash flash;
    @XmlElement(name="focalLength", namespace = "http://www.loc.gov/mix/v10")
    private final double focalLength;
    @XmlElement(name="flashEnergy", namespace = "http://www.loc.gov/mix/v10")
    private final double flashEnergy;
    @XmlElement(name="backLight", namespace = "http://www.loc.gov/mix/v10")
    private final BackLight backLight;
    @XmlElement(name="exposureIndex", namespace = "http://www.loc.gov/mix/v10")
    private final double exposureIndex;
    @XmlElement(name="sensingMode", namespace = "http://www.loc.gov/mix/v10")
    private final SensingMode sensingMode;
    @XmlElement(name="cfaPattern", namespace = "http://www.loc.gov/mix/v10")
    private final int cfaPattern;
    @XmlElement(name="autoFocus", namespace = "http://www.loc.gov/mix/v10")
    private final AutoFocus autoFocus;
    @XmlElement(name="xPrintAspectRatio", namespace = "http://www.loc.gov/mix/v10")
    private final double xPrintAspectRatio;
    @XmlElement(name="yPrintAspectRatio", namespace = "http://www.loc.gov/mix/v10")
    private final double yPrintAspectRatio;

    private ImageData(){
        super();
        this.fNumber = 0;
        this.exposureTime =0;
        this.exposureProgram = null;
        this.spectralSensitivity = null;
        this.isoSpeedRatings = 0;
        this.oECF = 0;
        this.exifVersion = null;
        this.shutterSpeedValue = 0;
        this.apertureValue = 0;
        this.brightnessValue = 0;
        this.exposeBiasValue = 0;
        this.maxApertureValue = 0;
        this.subjectDistance = 0;
        this.meteringMode = null;
        this.lightSource = null;
        this.flash = null;
        this.focalLength = 0;
        this.flashEnergy = 0;
        this.backLight = null;
        this.exposureIndex = 0;
        this.sensingMode = null;
        this.cfaPattern = 0;
        this.autoFocus = null;
        this.xPrintAspectRatio = 0;
        this.yPrintAspectRatio = 0;
    }
    
    private ImageData(Builder builder) {
        this.fNumber = builder.fNumber;
        this.exposureTime = builder.exposureTime;
        this.exposureProgram = builder.exposureProgram;
        this.spectralSensitivity = builder.spectralSensitivity;
        this.isoSpeedRatings = builder.isoSpeedRatings;
        this.oECF = builder.oECF;
        this.exifVersion = builder.exifVersion;
        this.shutterSpeedValue = builder.shutterSpeedValue;
        this.apertureValue = builder.apertureValue;
        this.brightnessValue = builder.brightnessValue;
        this.exposeBiasValue = builder.exposeBiasValue;
        this.maxApertureValue = builder.maxApertureValue;
        this.subjectDistance = builder.subjectDistance;
        this.meteringMode = builder.meteringMode;
        this.lightSource = builder.lightSource;
        this.flash = builder.flash;
        this.focalLength = builder.focalLength;
        this.flashEnergy = builder.flashEnergy;
        this.backLight = builder.backLight;
        this.exposureIndex = builder.exposureIndex;
        this.sensingMode = builder.sensingMode;
        this.cfaPattern = builder.cfaPattern;
        this.autoFocus = builder.autoFocus;
        this.xPrintAspectRatio = builder.xPrintAspectRatio;
        this.yPrintAspectRatio = builder.yPrintAspectRatio;
    }

    public double getApertureValue() {
        return apertureValue;
    }

    public AutoFocus getAutoFocus() {
        return autoFocus;
    }

    public BackLight getBackLight() {
        return backLight;
    }

    public double getBrightnessValue() {
        return brightnessValue;
    }

    public int getCfaPattern() {
        return cfaPattern;
    }

    public ExifVersion getExifVersion() {
        return exifVersion;
    }

    public double getExposeBiasValue() {
        return exposeBiasValue;
    }

    public double getExposureIndex() {
        return exposureIndex;
    }

    public ExposureProgram getExposureProgram() {
        return exposureProgram;
    }

    public double getExposureTime() {
        return exposureTime;
    }

    public Flash getFlash() {
        return flash;
    }

    public double getFlashEnergy() {
        return flashEnergy;
    }

    public double getfNumber() {
        return fNumber;
    }

    public double getFocalLength() {
        return focalLength;
    }

    public int getIsoSpeedRatings() {
        return isoSpeedRatings;
    }

    public LightSource getLightSource() {
        return lightSource;
    }

    public double getMaxApertureValue() {
        return maxApertureValue;
    }

    public MeteringMode getMeteringMode() {
        return meteringMode;
    }

    public double getoECF() {
        return oECF;
    }

    public SensingMode getSensingMode() {
        return sensingMode;
    }

    public double getShutterSpeedValue() {
        return shutterSpeedValue;
    }

    public List<String> getSpectralSensitivity() {
        return spectralSensitivity;
    }

    public double getSubjectDistance() {
        return subjectDistance;
    }

    public double getxPrintAspectRatio() {
        return xPrintAspectRatio;
    }

    public double getyPrintAspectRatio() {
        return yPrintAspectRatio;
    }

    public enum AutoFocus {
        AF_USED, AF_INTERRUPTED, AF_NEAR, AF_SOFT, MANUAL;
    }

    public enum BackLight {
        FRONT_LIGHT, BACK_LIGHT_1, BACK_LIGHT_2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(apertureValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((autoFocus == null) ? 0 : autoFocus.hashCode());
        result = prime * result + ((backLight == null) ? 0 : backLight.hashCode());
        temp = Double.doubleToLongBits(brightnessValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + cfaPattern;
        result = prime * result + ((exifVersion == null) ? 0 : exifVersion.hashCode());
        temp = Double.doubleToLongBits(exposeBiasValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(exposureIndex);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((exposureProgram == null) ? 0 : exposureProgram.hashCode());
        temp = Double.doubleToLongBits(exposureTime);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fNumber);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((flash == null) ? 0 : flash.hashCode());
        temp = Double.doubleToLongBits(flashEnergy);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(focalLength);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + isoSpeedRatings;
        result = prime * result + ((lightSource == null) ? 0 : lightSource.hashCode());
        temp = Double.doubleToLongBits(maxApertureValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((meteringMode == null) ? 0 : meteringMode.hashCode());
        temp = Double.doubleToLongBits(oECF);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((sensingMode == null) ? 0 : sensingMode.hashCode());
        temp = Double.doubleToLongBits(shutterSpeedValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((spectralSensitivity == null) ? 0 : spectralSensitivity.hashCode());
        temp = Double.doubleToLongBits(subjectDistance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(xPrintAspectRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(yPrintAspectRatio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        ImageData other = (ImageData) obj;
        if (Double.doubleToLongBits(apertureValue) != Double.doubleToLongBits(other.apertureValue))
            return false;
        if (autoFocus != other.autoFocus)
            return false;
        if (backLight != other.backLight)
            return false;
        if (Double.doubleToLongBits(brightnessValue) != Double.doubleToLongBits(other.brightnessValue))
            return false;
        if (cfaPattern != other.cfaPattern)
            return false;
        if (exifVersion != other.exifVersion)
            return false;
        if (Double.doubleToLongBits(exposeBiasValue) != Double.doubleToLongBits(other.exposeBiasValue))
            return false;
        if (Double.doubleToLongBits(exposureIndex) != Double.doubleToLongBits(other.exposureIndex))
            return false;
        if (exposureProgram != other.exposureProgram)
            return false;
        if (Double.doubleToLongBits(exposureTime) != Double.doubleToLongBits(other.exposureTime))
            return false;
        if (Double.doubleToLongBits(fNumber) != Double.doubleToLongBits(other.fNumber))
            return false;
        if (flash != other.flash)
            return false;
        if (Double.doubleToLongBits(flashEnergy) != Double.doubleToLongBits(other.flashEnergy))
            return false;
        if (Double.doubleToLongBits(focalLength) != Double.doubleToLongBits(other.focalLength))
            return false;
        if (isoSpeedRatings != other.isoSpeedRatings)
            return false;
        if (lightSource != other.lightSource)
            return false;
        if (Double.doubleToLongBits(maxApertureValue) != Double.doubleToLongBits(other.maxApertureValue))
            return false;
        if (meteringMode != other.meteringMode)
            return false;
        if (Double.doubleToLongBits(oECF) != Double.doubleToLongBits(other.oECF))
            return false;
        if (sensingMode != other.sensingMode)
            return false;
        if (Double.doubleToLongBits(shutterSpeedValue) != Double.doubleToLongBits(other.shutterSpeedValue))
            return false;
        if (spectralSensitivity == null) {
            if (other.spectralSensitivity != null)
                return false;
        } else if (!spectralSensitivity.equals(other.spectralSensitivity))
            return false;
        if (Double.doubleToLongBits(subjectDistance) != Double.doubleToLongBits(other.subjectDistance))
            return false;
        if (Double.doubleToLongBits(xPrintAspectRatio) != Double.doubleToLongBits(other.xPrintAspectRatio))
            return false;
        if (Double.doubleToLongBits(yPrintAspectRatio) != Double.doubleToLongBits(other.yPrintAspectRatio))
            return false;
        return true;
    }

    public static class Builder {
        private double fNumber;
        private double exposureTime;
        private ExposureProgram exposureProgram;
        private List<String> spectralSensitivity;
        private int isoSpeedRatings;
        private double oECF;
        private ExifVersion exifVersion;
        private double shutterSpeedValue;
        private double apertureValue;
        private double brightnessValue;
        private double exposeBiasValue;
        private double maxApertureValue;
        private double subjectDistance;
        private MeteringMode meteringMode;
        private LightSource lightSource;
        private Flash flash;
        private double focalLength;
        private double flashEnergy;
        private BackLight backLight;
        private double exposureIndex;
        private SensingMode sensingMode;
        private int cfaPattern;
        private AutoFocus autoFocus;
        private double xPrintAspectRatio;
        private double yPrintAspectRatio;

        public Builder apertureValue(double apertureValue) {
            this.apertureValue = apertureValue;
            return this;
        }

        public Builder autoFocus(AutoFocus autoFocus) {
            this.autoFocus = autoFocus;
            return this;
        }

        public Builder backLight(BackLight backLight) {
            this.backLight = backLight;
            return this;
        }

        public Builder brightnessValue(double brightnessValue) {
            this.brightnessValue = brightnessValue;
            return this;
        }

        public ImageData build() {
            return new ImageData(this);
        }

        public Builder cfaPattern(int cfaPattern) {
            this.cfaPattern = cfaPattern;
            return this;
        }

        public Builder exifVersion(ExifVersion exifVersion) {
            this.exifVersion = exifVersion;
            return this;
        }

        public Builder exposeBiasValue(double exposeBiasValue) {
            this.exposeBiasValue = exposeBiasValue;
            return this;
        }

        public Builder exposureIndex(double exposureIndex) {
            this.exposureIndex = exposureIndex;
            return this;
        }

        public Builder exposureProgram(ExposureProgram exposureProgram) {
            this.exposureProgram = exposureProgram;
            return this;
        }

        public Builder exposureTime(double exposureTime) {
            this.exposureTime = exposureTime;
            return this;
        }

        public Builder flash(Flash flash) {
            this.flash = flash;
            return this;
        }

        public Builder flashEnergy(double flashEnergy) {
            this.flashEnergy = flashEnergy;
            return this;
        }

        public Builder fNumber(double fNumber) {
            this.fNumber = fNumber;
            return this;
        }

        public Builder focalLength(double focalLength) {
            this.focalLength = focalLength;
            return this;
        }

        public Builder isoSpeedRatings(int isoSpeedRatings) {
            this.isoSpeedRatings = isoSpeedRatings;
            return this;
        }

        public Builder lightSource(LightSource lightSource) {
            this.lightSource = lightSource;
            return this;
        }

        public Builder maxApertureValue(double maxApertureValue) {
            this.maxApertureValue = maxApertureValue;
            return this;
        }

        public Builder meteringMode(MeteringMode meteringMode) {
            this.meteringMode = meteringMode;
            return this;
        }

        public Builder oECF(double oECF) {
            this.oECF = oECF;
            return this;
        }

        public Builder sensingMode(SensingMode sensingMode) {
            this.sensingMode = sensingMode;
            return this;
        }

        public Builder shutterSpeedValue(double shutterSpeedValue) {
            this.shutterSpeedValue = shutterSpeedValue;
            return this;
        }

        public Builder spectralSensitivity(List<String> spectralSensitivity) {
            this.spectralSensitivity = spectralSensitivity;
            return this;
        }

        public Builder subjectDistance(double subjectDistance) {
            this.subjectDistance = subjectDistance;
            return this;
        }

        public Builder xPrintAspectRatio(double xPrintAspectRatio) {
            this.xPrintAspectRatio = xPrintAspectRatio;
            return this;
        }

        public Builder yPrintAspectRatio(double yPrintAspectRatio) {
            this.yPrintAspectRatio = yPrintAspectRatio;
            return this;
        }
    }

    public enum ExifVersion {
        EXIF_2_1, EXIF_2_2;
    }

    public enum ExposureProgram {
        UNDEFINED, MANUAL, NORMAL_PROGRAM, APERTURE_PRIORITY, SHUTTER_PRIORITY, CREATIVE_PROGRAM, ACTION_PROGRAM, PORTRAIT_MODE, LANDSCAPE_MODE;
        public ExposureProgram fromVlue(short value) {
            switch (value) {
            case 0:
                return UNDEFINED;
            case 1:
                return MANUAL;
            case 2:
                return NORMAL_PROGRAM;
            case 3:
                return APERTURE_PRIORITY;
            case 4:
                return SHUTTER_PRIORITY;
            case 5:
                return CREATIVE_PROGRAM;
            case 6:
                return ACTION_PROGRAM;
            case 7:
                return PORTRAIT_MODE;
            case 8:
                return LANDSCAPE_MODE;
            default:
                return null;
            }
        }
    }

    public enum Flash {
        FLASH_NO_FIRE, FLASH_FIRED, STROBE_NO_RETURN, STROBE_RETURN, FLASH_FIRED_COMPULSORY, FLASH_FIRED_COMPULSORY_NO_RETURN, FLASH_FIRED_COMPULSORY_RETURN, FLASH_NO_FIRE_COMPULSORY, FLASH_NO_FIRE_AUTO, FLASH_FIRED_AUTO, FLASH_FIRED_AUTO_NO_RETURN, FLASH_FIRED_AUTO_RETURN, NO_FLASH_FUNCTION, FLASH_FIRED_RED_EYE, FLASH_FIRED_RED_EYE_NO_RETURN, FLASH_FIRED_RED_EYE_RETURN, FLASH_FIRED_COMPULSORY_RED_EYE, FLASH_FIRED_COMPULSORY_RED_EYE_NO_RETURN, FLASH_FIRED_COMPULSORY_RED_EYE_RETURN, FLASH_FIERD_AUTO_RED_EYE, FLASH_FIERD_AUTO_RED_EYE_NO_RETURN, FLASH_FIERD_AUTO_RED_EYE_RETURN
    }

    public enum LightSource {
        DAYLIGHT, FLOURESCENT, TUNGESTEN, FLASH, FINE_WEATHER, CLOUDY_WEATHER, SHADE, DAYLIGHT_FLOURESCENT, DAY_WHITE_FLOURESCENT, COOL_WHITE_FLOURESCENT, WHITE_FLOURESCENT, STANDARD_LIGHT_A, STANDARD_LIGHT_B, STANDARD_LIGHT_C, D55, D66, D75, D50, ISO_STUDIO_TUNGSTEN, OTHER_LIGHT_SOURCE, UNKNOWN;
    }

    public enum MeteringMode {
        AVERAGE, CENTER_WEIGHTED_AVERAGE, SPOT, MULTISPOT, PATTERN, PARTIAL;
    }

    public enum SensingMode {
        NOT_DEFINED, ONE_CHIP_COLOR_AREA, TWO_CHIP_COLOR_AREA, THREE_CHIP_COLOR_AREA, COLOR_SEQUENTIAL_AREA, TRI_LINEAR, COLOR_SEQUENTIAL_LINEAR;
        public SensingMode fromValue(short value) {
            switch (value) {
            case 1:
                return NOT_DEFINED;
            case 2:
                return ONE_CHIP_COLOR_AREA;
            case 3:
                return TWO_CHIP_COLOR_AREA;
            case 4:
                return THREE_CHIP_COLOR_AREA;
            case 5:
                return COLOR_SEQUENTIAL_AREA;
            case 7:
                return TRI_LINEAR;
            case 8:
                return COLOR_SEQUENTIAL_LINEAR;
            default:
                return null;
            }
        }
    }
}
