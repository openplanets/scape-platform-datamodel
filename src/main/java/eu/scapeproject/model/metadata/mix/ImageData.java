package eu.scapeproject.model.metadata.mix;

import java.util.List;


public class ImageData {
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

    public enum AutoFocus {
        AF_USED, AF_INTERRUPTED, AF_NEAR, AF_SOFT, MANUAL;
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

    public enum BackLight {
        FRONT_LIGHT, BACK_LIGHT_1, BACK_LIGHT_2;
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

}
