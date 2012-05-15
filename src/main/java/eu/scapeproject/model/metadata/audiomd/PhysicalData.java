package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="physicaldata",namespace="http://www.loc.gov/AMD/")
public class PhysicalData {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="ebustoragemediacode",namespace="http://www.loc.gov/AMD/")
    private List<String> ebuStorageMediaCodes;
    @XmlElement(name="condition",namespace="http://www.loc.gov/AMD/")
    private List<String> conditions;
    @XmlElement(name="dimension",namespace="http://www.loc.gov/AMD/")
    private List<Dimension> dimensions;
    @XmlElement(name="disposition",namespace="http://www.loc.gov/AMD/")
    private List<String> dispositions;
    @XmlElement(name="equalization",namespace="http://www.loc.gov/AMD/")
    private List<String> equalizations;
    @XmlElement(name="generation",namespace="http://www.loc.gov/AMD/")
    private List<String> generations;
    @XmlElement(name="groove",namespace="http://www.loc.gov/AMD/")
    private List<String> grooves;
    @XmlElement(name="material",namespace="http://www.loc.gov/AMD/")
    private List<Material> materials;
    @XmlElement(name="noisereduction",namespace="http://www.loc.gov/AMD/")
    private List<String> noiseReductions;
    @XmlElement(name="physformat",namespace="http://www.loc.gov/AMD/")
    private List<String> physFormats;
    @XmlElement(name="speed",namespace="http://www.loc.gov/AMD/")
    private List<String> speeds;
    @XmlElement(name="speedadjustment",namespace="http://www.loc.gov/AMD/")
    private List<String> speedAdjustments;
    @XmlElement(name="speednote",namespace="http://www.loc.gov/AMD/")
    private List<String> speedNotes;
    @XmlElement(name="trackformat",namespace="http://www.loc.gov/AMD/")
    private List<String> trackFormats;
    @XmlElement(name="tracking",namespace="http://www.loc.gov/AMD/")
    private List<TrackingInfo> trackings;
    @XmlElement(name="note",namespace="http://www.loc.gov/AMD/")
    private List<String> notes;

    private PhysicalData() {
        super();
    }

    private PhysicalData(Builder builder) {
        this.id = builder.id;
        this.ebuStorageMediaCodes = builder.ebuStorageMediaCodes;
        this.conditions = builder.conditions;
        this.dimensions = builder.dimensions;
        this.dispositions = builder.dispositions;
        this.equalizations = builder.equalizations;
        this.generations = builder.generations;
        this.grooves = builder.grooves;
        this.materials = builder.materials;
        this.noiseReductions = builder.noiseReductions;
        this.physFormats = builder.physFormats;
        this.speeds = builder.speeds;
        this.speedAdjustments = builder.speedAdjustments;
        this.speedNotes = builder.speedNotes;
        this.trackFormats = builder.trackFormats;
        this.trackings = builder.trackings;
        this.notes = builder.notes;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public List<String> getDispositions() {
        return dispositions;
    }

    public List<String> getEbuStorageMediaCodes() {
        return ebuStorageMediaCodes;
    }

    public List<String> getEqualizations() {
        return equalizations;
    }

    public List<String> getGenerations() {
        return generations;
    }

    public List<String> getGrooves() {
        return grooves;
    }

    public String getId() {
        return id;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public List<String> getNoiseReductions() {
        return noiseReductions;
    }

    public List<String> getNotes() {
        return notes;
    }

    public List<String> getPhysFormats() {
        return physFormats;
    }

    public List<String> getSpeedAdjustments() {
        return speedAdjustments;
    }

    public List<String> getSpeedNotes() {
        return speedNotes;
    }

    public List<String> getSpeeds() {
        return speeds;
    }

    public List<String> getTrackFormats() {
        return trackFormats;
    }

    public List<TrackingInfo> getTrackings() {
        return trackings;
    }

    public static class Builder {
        private final String id;
        private List<String> ebuStorageMediaCodes;
        private List<String> conditions;
        private List<Dimension> dimensions;
        private List<String> dispositions;
        private List<String> equalizations;
        private List<String> generations;
        private List<String> grooves;
        private List<Material> materials;
        private List<String> noiseReductions;
        private List<String> physFormats;
        private List<String> speeds;
        private List<String> speedAdjustments;
        private List<String> speedNotes;
        private List<String> trackFormats;
        private List<TrackingInfo> trackings;
        private List<String> notes;
        public Builder(String id) {
            super();
            this.id=id;
        }

        public PhysicalData build() {
            return new PhysicalData(this);
        }

        public Builder conditions(List<String> conditions) {
            this.conditions = conditions;
            return this;
        }

        public Builder dimensions(List<Dimension> dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder dispositions(List<String> dispositions) {
            this.dispositions = dispositions;
            return this;
        }

        public Builder ebuStorageMediaCodes(List<String> ebuStorageMediaCodes) {
            this.ebuStorageMediaCodes = ebuStorageMediaCodes;
            return this;
        }

        public Builder equalizations(List<String> equalizations) {
            this.equalizations = equalizations;
            return this;
        }

        public Builder generations(List<String> generations) {
            this.generations = generations;
            return this;
        }

        public Builder grooves(List<String> grooves) {
            this.grooves = grooves;
            return this;
        }

        public Builder materials(List<Material> materials) {
            this.materials = materials;
            return this;
        }

        public Builder noiseReductions(List<String> noiseReductions) {
            this.noiseReductions = noiseReductions;
            return this;
        }

        public Builder notes(List<String> notes) {
            this.notes = notes;
            return this;
        }

        public Builder physFormats(List<String> physFormats) {
            this.physFormats = physFormats;
            return this;
        }

        public Builder speedAdjustments(List<String> speedAdjustments) {
            this.speedAdjustments = speedAdjustments;
            return this;
        }

        public Builder speedNotes(List<String> speedNotes) {
            this.speedNotes = speedNotes;
            return this;
        }

        public Builder speeds(List<String> speeds) {
            this.speeds = speeds;
            return this;
        }

        public Builder trackFormats(List<String> trackFormats) {
            this.trackFormats = trackFormats;
            return this;
        }

        public Builder trackings(List<TrackingInfo> trackings) {
            this.trackings = trackings;
            return this;
        }
    }
}
