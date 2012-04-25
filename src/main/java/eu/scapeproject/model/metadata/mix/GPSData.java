package eu.scapeproject.model.metadata.mix;

public class GPSData {
    private String gpsVersionId;
    private GPSLatitudeRef gpsLatitudeRef;
    private double gpsLatitude;
    private GPSLongitudeRef gpsLongitudeRef;
    private String gpsTimeStamp;
    private String gpsSatellites;
    private GPSStatus gpsStatus;
    private GPSMeasureMode gpsMeasureMode;
    private double gpsDOP;
    private GPSDistanceUnitRef gpsSpeedRef;
    private double gpsSpeed;
    private GPSDirectionRef gpsTrackRef;
    private double gpsTrack;
    private GPSDirectionRef gpsImageDirectionRef;
    private double gpsImageDirection;
    private String gpsMapDatum;
    private GPSLatitudeRef gpsDestLatitudeRef;
    private String gpsDestLatitude;
    private GPSLongitudeRef gpsDestLongitudeRef;
    private String gpsDestLongitude;
    private GPSDirectionRef gpsDestBearingRef;
    private double gpsDestBearing;
    private GPSDistanceUnitRef gpsDestDistanceRef;
    private double gpsDestDistance;
    private String gpsProcessingMethod;
    private String gpsAreaInformation;
    private String gpsDateStamp;
    private GPSDifferential gpsDifferential;

    public enum GPSDifferential {
        DIFFERENTIAL_CORRENTION_ON, DIFFERENTIAL_CORRENTION_OFF;
    }

    public enum GPSDirectionRef {
        TRUE_DIRECTION, MAGNETIC_DIRECTION;
    }

    public enum GPSDistanceUnitRef {
        KILOMETERS, MILES, KNOTS;
    }

    public enum GPSMeasureMode {
        DEFAULT, TWO_DIMENSIONS, THREE_DIMENSIONS;
    }

    public enum GPSStatus {
        MEASUREMENT_IN_PROGRESS, MEASUREMENT_INTEROPERABILITY;
    }

    public enum GPSAltitudeRef {
        SEALEVEL, SEALEVEL_REFERENCE;
    }

    public enum GPSLongitudeRef {
        EAST, WEST;
    }

    public enum GPSLatitudeRef {
        NORTH, SOUTH;
    }
}
