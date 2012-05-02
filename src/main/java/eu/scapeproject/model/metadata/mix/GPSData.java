package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gpsData", namespace = "http://www.loc.gov/mix/v10")
public class GPSData {
    @XmlElement(name="gpsVersionId", namespace = "http://www.loc.gov/mix/v10")
    private String gpsVersionId;
    @XmlElement(name="gpsLatitudeRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSLatitudeRef gpsLatitudeRef;
    @XmlElement(name="gpsLatitude", namespace = "http://www.loc.gov/mix/v10")
    private double gpsLatitude;
    @XmlElement(name="gpsLongitudeRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSLongitudeRef gpsLongitudeRef;
    @XmlElement(name="gpsLongitude", namespace = "http://www.loc.gov/mix/v10")
    private double gpsLongitude;
    @XmlElement(name="gpsTimeStamp", namespace = "http://www.loc.gov/mix/v10")
    private String gpsTimeStamp;
    @XmlElement(name="gpsSatellites", namespace = "http://www.loc.gov/mix/v10")
    private String gpsSatellites;
    @XmlElement(name="gpsStatus", namespace = "http://www.loc.gov/mix/v10")
    private GPSStatus gpsStatus;
    @XmlElement(name="gpsMeasureMode", namespace = "http://www.loc.gov/mix/v10")
    private GPSMeasureMode gpsMeasureMode;
    @XmlElement(name="gpsDOP", namespace = "http://www.loc.gov/mix/v10")
    private double gpsDOP;
    @XmlElement(name="gpsSpeedRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSDistanceUnitRef gpsSpeedRef;
    @XmlElement(name="gpsSpeed", namespace = "http://www.loc.gov/mix/v10")
    private double gpsSpeed;
    @XmlElement(name="gpsTrackRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSDirectionRef gpsTrackRef;
    @XmlElement(name="gpsTrack", namespace = "http://www.loc.gov/mix/v10")
    private double gpsTrack;
    @XmlElement(name="gpsImageDirectionRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSDirectionRef gpsImageDirectionRef;
    @XmlElement(name="gpsImageDirection", namespace = "http://www.loc.gov/mix/v10")
    private double gpsImageDirection;
    @XmlElement(name="gpsMapDatum", namespace = "http://www.loc.gov/mix/v10")
    private String gpsMapDatum;
    @XmlElement(name="gpsDestLatitudeRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSLatitudeRef gpsDestLatitudeRef;
    @XmlElement(name="gpsDestLatitude", namespace = "http://www.loc.gov/mix/v10")
    private String gpsDestLatitude;
    @XmlElement(name="gpsDestLongitudeRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSLongitudeRef gpsDestLongitudeRef;
    @XmlElement(name="gpsDestLongitude", namespace = "http://www.loc.gov/mix/v10")
    private String gpsDestLongitude;
    @XmlElement(name="gpsDestBearingRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSDirectionRef gpsDestBearingRef;
    @XmlElement(name="gpsDestBearing", namespace = "http://www.loc.gov/mix/v10")
    private double gpsDestBearing;
    @XmlElement(name="gpsDestDistanceRef", namespace = "http://www.loc.gov/mix/v10")
    private GPSDistanceUnitRef gpsDestDistanceRef;
    @XmlElement(name="gpsDestDistance", namespace = "http://www.loc.gov/mix/v10")
    private double gpsDestDistance;
    @XmlElement(name="gpsProcessingMethod", namespace = "http://www.loc.gov/mix/v10")
    private String gpsProcessingMethod;
    @XmlElement(name="gpsAreaInformation", namespace = "http://www.loc.gov/mix/v10")
    private String gpsAreaInformation;
    @XmlElement(name="gpsDateStamp", namespace = "http://www.loc.gov/mix/v10")
    private String gpsDateStamp;
    @XmlElement(name="gpsDifferential", namespace = "http://www.loc.gov/mix/v10")
    private GPSDifferential gpsDifferential;

    private GPSData(){
        super();
    }
    
    private GPSData(Builder builder) {
        this.gpsVersionId = builder.gpsVersionId;
        this.gpsLatitudeRef = builder.gpsLatitudeRef;
        this.gpsLatitude = builder.gpsLatitude;
        this.gpsLongitudeRef = builder.gpsLongitudeRef;
        this.gpsLongitude=builder.gpsLongitude;
        this.gpsTimeStamp = builder.gpsTimeStamp;
        this.gpsSatellites = builder.gpsSatellites;
        this.gpsStatus = builder.gpsStatus;
        this.gpsMeasureMode = builder.gpsMeasureMode;
        this.gpsDOP = builder.gpsDOP;
        this.gpsSpeedRef = builder.gpsSpeedRef;
        this.gpsSpeed = builder.gpsSpeed;
        this.gpsTrackRef = builder.gpsTrackRef;
        this.gpsTrack = builder.gpsTrack;
        this.gpsImageDirectionRef = builder.gpsImageDirectionRef;
        this.gpsImageDirection = builder.gpsImageDirection;
        this.gpsMapDatum = builder.gpsMapDatum;
        this.gpsDestLatitudeRef = builder.gpsDestLatitudeRef;
        this.gpsDestLatitude = builder.gpsDestLatitude;
        this.gpsDestLongitudeRef = builder.gpsDestLongitudeRef;
        this.gpsDestLongitude = builder.gpsDestLongitude;
        this.gpsDestBearingRef = builder.gpsDestBearingRef;
        this.gpsDestBearing = builder.gpsDestBearing;
        this.gpsDestDistanceRef = builder.gpsDestDistanceRef;
        this.gpsDestDistance = builder.gpsDestDistance;
        this.gpsProcessingMethod = builder.gpsProcessingMethod;
        this.gpsAreaInformation = builder.gpsAreaInformation;
        this.gpsDateStamp = builder.gpsDateStamp;
        this.gpsDifferential = builder.gpsDifferential;
    }

    public static class Builder {
        private String gpsVersionId;
        private GPSLatitudeRef gpsLatitudeRef;
        private double gpsLatitude;
        private GPSLongitudeRef gpsLongitudeRef;
        private double gpsLongitude;
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

        public GPSData build() {
            return new GPSData(this);
        }

        public Builder gpsAreaInformation(String gpsAreaInformation) {
            this.gpsAreaInformation = gpsAreaInformation;
            return this;
        }

        public Builder gpsDateStamp(String gpsDateStamp) {
            this.gpsDateStamp = gpsDateStamp;
            return this;
        }
        
        public Builder gpsDestBearing(double gpsDestBearing) {
            this.gpsDestBearing = gpsDestBearing;
            return this;
        }

        public Builder gpsDestBearingRef(GPSDirectionRef gpsDestBearingRef) {
            this.gpsDestBearingRef = gpsDestBearingRef;
            return this;
        }

        public Builder gpsDestDistance(double gpsDestDistance) {
            this.gpsDestDistance = gpsDestDistance;
            return this;
        }

        public Builder gpsDestDistanceRef(GPSDistanceUnitRef gpsDestDistanceRef) {
            this.gpsDestDistanceRef = gpsDestDistanceRef;
            return this;
        }

        public Builder gpsDestLatitude(String gpsDestLatitude) {
            this.gpsDestLatitude = gpsDestLatitude;
            return this;
        }

        public Builder gpsDestLatitudeRef(GPSLatitudeRef gpsDestLatitudeRef) {
            this.gpsDestLatitudeRef = gpsDestLatitudeRef;
            return this;
        }

        public Builder gpsDestLongitude(String gpsDestLongitude) {
            this.gpsDestLongitude = gpsDestLongitude;
            return this;
        }

        public Builder gpsLongitude(double gpsLongitude) {
            this.gpsLongitude = gpsLongitude;
            return this;
        }

        public Builder gpsDestLongitudeRef(GPSLongitudeRef gpsDestLongitudeRef) {
            this.gpsDestLongitudeRef = gpsDestLongitudeRef;
            return this;
        }

        public Builder gpsDifferential(GPSDifferential gpsDifferential) {
            this.gpsDifferential = gpsDifferential;
            return this;
        }

        public Builder gpsDOP(double gpsDOP) {
            this.gpsDOP = gpsDOP;
            return this;
        }

        public Builder gpsImageDirection(double gpsImageDirection) {
            this.gpsImageDirection = gpsImageDirection;
            return this;
        }

        public Builder gpsImageDirectionRef(GPSDirectionRef gpsImageDirectionRef) {
            this.gpsImageDirectionRef = gpsImageDirectionRef;
            return this;
        }

        public Builder gpsLatitude(double gpsLatitude) {
            this.gpsLatitude = gpsLatitude;
            return this;
        }

        public Builder gpsLatitudeRef(GPSLatitudeRef gpsLatitudeRef) {
            this.gpsLatitudeRef = gpsLatitudeRef;
            return this;
        }

        public Builder gpsLongitudeRef(GPSLongitudeRef gpsLongitudeRef) {
            this.gpsLongitudeRef = gpsLongitudeRef;
            return this;
        }

        public Builder gpsMapDatum(String gpsMapDatum) {
            this.gpsMapDatum = gpsMapDatum;
            return this;
        }

        public Builder gpsMeasureMode(GPSMeasureMode gpsMeasureMode) {
            this.gpsMeasureMode = gpsMeasureMode;
            return this;
        }

        public Builder gpsProcessingMethod(String gpsProcessingMethod) {
            this.gpsProcessingMethod = gpsProcessingMethod;
            return this;
        }

        public Builder gpsSatellites(String gpsSatellites) {
            this.gpsSatellites = gpsSatellites;
            return this;
        }

        public Builder gpsSpeed(double gpsSpeed) {
            this.gpsSpeed = gpsSpeed;
            return this;
        }

        public Builder gpsSpeedRef(GPSDistanceUnitRef gpsSpeedRef) {
            this.gpsSpeedRef = gpsSpeedRef;
            return this;
        }

        public Builder gpsStatus(GPSStatus gpsStatus) {
            this.gpsStatus = gpsStatus;
            return this;
        }

        public Builder gpsTimeStamp(String gpsTimeStamp) {
            this.gpsTimeStamp = gpsTimeStamp;
            return this;
        }

        public Builder gpsTrack(double gpsTrack) {
            this.gpsTrack = gpsTrack;
            return this;
        }

        public Builder gpsTrackRef(GPSDirectionRef gpsTrackRef) {
            this.gpsTrackRef = gpsTrackRef;
            return this;
        }

        public Builder gpsVersionId(String gpsVersionId) {
            this.gpsVersionId = gpsVersionId;
            return this;
        }
    }

    public enum GPSAltitudeRef {
        SEALEVEL, SEALEVEL_REFERENCE;
    }

    public enum GPSDifferential {
        DIFFERENTIAL_CORRENTION_ON, DIFFERENTIAL_CORRENTION_OFF;
    }

    public enum GPSDirectionRef {
        TRUE_DIRECTION, MAGNETIC_DIRECTION;
    }

    public enum GPSDistanceUnitRef {
        KILOMETERS, MILES, KNOTS;
    }

    public enum GPSLatitudeRef {
        NORTH, SOUTH;
    }

    public enum GPSLongitudeRef {
        EAST, WEST;
    }

    public enum GPSMeasureMode {
        DEFAULT, TWO_DIMENSIONS, THREE_DIMENSIONS;
    }

    public enum GPSStatus {
        MEASUREMENT_IN_PROGRESS, MEASUREMENT_INTEROPERABILITY;
    }
}
