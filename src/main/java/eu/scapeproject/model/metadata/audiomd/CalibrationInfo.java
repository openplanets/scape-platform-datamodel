package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="calibrationInfo",namespace="http://www.loc.gov/AMD/")
public class CalibrationInfo {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="calibrationExInts",namespace="http://www.loc.gov/AMD/")
    private List<String> calibrationExInts;
    @XmlElement(name="calibrationLocations",namespace="http://www.loc.gov/AMD/")
    private List<String> calibrationLocations;
    @XmlElement(name="calibrationTimeStamps",namespace="http://www.loc.gov/AMD/")
    private List<String> calibrationTimeStamps;
    @XmlElement(name="calibrationTrackTypes",namespace="http://www.loc.gov/AMD/")
    private List<String> calibrationTrackTypes;

    private CalibrationInfo() {
        super();
    }

    private CalibrationInfo(Builder builder) {
        this.id = builder.id;
        this.calibrationExInts = builder.calibrationExInts;
        this.calibrationLocations = builder.calibrationLocations;
        this.calibrationTimeStamps = builder.calibrationTimeStamps;
        this.calibrationTrackTypes = builder.calibrationTrackTypes;
    }

    public List<String> getCalibrationExInts() {
        return calibrationExInts;
    }

    public List<String> getCalibrationLocations() {
        return calibrationLocations;
    }

    public List<String> getCalibrationTimeStamps() {
        return calibrationTimeStamps;
    }

    public List<String> getCalibrationTrackTypes() {
        return calibrationTrackTypes;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((calibrationExInts == null) ? 0 : calibrationExInts.hashCode());
        result = prime * result + ((calibrationLocations == null) ? 0 : calibrationLocations.hashCode());
        result = prime * result + ((calibrationTimeStamps == null) ? 0 : calibrationTimeStamps.hashCode());
        result = prime * result + ((calibrationTrackTypes == null) ? 0 : calibrationTrackTypes.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        CalibrationInfo other = (CalibrationInfo) obj;
        if (calibrationExInts == null) {
            if (other.calibrationExInts != null)
                return false;
        } else if (!calibrationExInts.equals(other.calibrationExInts))
            return false;
        if (calibrationLocations == null) {
            if (other.calibrationLocations != null)
                return false;
        } else if (!calibrationLocations.equals(other.calibrationLocations))
            return false;
        if (calibrationTimeStamps == null) {
            if (other.calibrationTimeStamps != null)
                return false;
        } else if (!calibrationTimeStamps.equals(other.calibrationTimeStamps))
            return false;
        if (calibrationTrackTypes == null) {
            if (other.calibrationTrackTypes != null)
                return false;
        } else if (!calibrationTrackTypes.equals(other.calibrationTrackTypes))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public static class Builder {
        private final String id;
        private List<String> calibrationExInts;
        private List<String> calibrationLocations;
        private List<String> calibrationTimeStamps;
        private List<String> calibrationTrackTypes;

        public Builder(String id) {
            super();
            this.id=id;
        }

        public CalibrationInfo build() {
            return new CalibrationInfo(this);
        }

        public Builder calibrationExInts(List<String> calibrationExInts) {
            this.calibrationExInts = calibrationExInts;
            return this;
        }

        public Builder calibrationLocations(List<String> calibrationLocations) {
            this.calibrationLocations = calibrationLocations;
            return this;
        }

        public Builder calibrationTimeStamps(List<String> calibrationTimeStamps) {
            this.calibrationTimeStamps = calibrationTimeStamps;
            return this;
        }
        public Builder calibrationTrackTypes(List<String> calibrationTrackTypes) {
            this.calibrationTrackTypes = calibrationTrackTypes;
            return this;
        }
    }
}
