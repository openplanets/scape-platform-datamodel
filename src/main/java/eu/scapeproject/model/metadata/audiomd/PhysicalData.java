package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="physicaldata",namespace="http://www.loc.gov/AMD/")
public class PhysicalData {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name="ebustoragemediacode",namespace="http://www.loc.gov/AMD/")
    private final List<String> ebuStorageMediaCodes;
    @XmlElement(name="condition",namespace="http://www.loc.gov/AMD/")
    private final List<String> conditions;
    @XmlElement(name="dimension",namespace="http://www.loc.gov/AMD/")
    private final List<Dimension> dimensions;
    @XmlElement(name="disposition",namespace="http://www.loc.gov/AMD/")
    private final List<String> dispositions;
    @XmlElement(name="equalization",namespace="http://www.loc.gov/AMD/")
    private final List<String> equalizations;
    @XmlElement(name="generation",namespace="http://www.loc.gov/AMD/")
    private final List<String> generations;
    @XmlElement(name="groove",namespace="http://www.loc.gov/AMD/")
    private final List<String> grooves;
    @XmlElement(name="material",namespace="http://www.loc.gov/AMD/")
    private final List<Material> materials;
    @XmlElement(name="noisereduction",namespace="http://www.loc.gov/AMD/")
    private final List<String> noiseReductions;
    @XmlElement(name="physformat",namespace="http://www.loc.gov/AMD/")
    private final List<String> physFormats;
    @XmlElement(name="speed",namespace="http://www.loc.gov/AMD/")
    private final List<String> speeds;
    @XmlElement(name="speedadjustment",namespace="http://www.loc.gov/AMD/")
    private final List<String> speedAdjustments;
    @XmlElement(name="speednote",namespace="http://www.loc.gov/AMD/")
    private final List<String> speedNotes;
    @XmlElement(name="trackformat",namespace="http://www.loc.gov/AMD/")
    private final List<String> trackFormats;
    @XmlElement(name="tracking",namespace="http://www.loc.gov/AMD/")
    private final List<TrackingInfo> trackings;
    @XmlElement(name="note",namespace="http://www.loc.gov/AMD/")
    private final List<String> notes;

    private PhysicalData() {
        super();
        this.id = null;
        this.ebuStorageMediaCodes = null;
        this.conditions = null;
        this.dimensions = null;
        this.dispositions = null;
        this.equalizations = null;
        this.generations = null;
        this.grooves = null;
        this.materials = null;
        this.noiseReductions = null;
        this.physFormats = null;
        this.speeds = null;
        this.speedAdjustments = null;
        this.speedNotes = null;
        this.trackFormats = null;
        this.trackings = null;
        this.notes = null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conditions == null) ? 0 : conditions.hashCode());
        result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
        result = prime * result + ((dispositions == null) ? 0 : dispositions.hashCode());
        result = prime * result + ((ebuStorageMediaCodes == null) ? 0 : ebuStorageMediaCodes.hashCode());
        result = prime * result + ((equalizations == null) ? 0 : equalizations.hashCode());
        result = prime * result + ((generations == null) ? 0 : generations.hashCode());
        result = prime * result + ((grooves == null) ? 0 : grooves.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((materials == null) ? 0 : materials.hashCode());
        result = prime * result + ((noiseReductions == null) ? 0 : noiseReductions.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((physFormats == null) ? 0 : physFormats.hashCode());
        result = prime * result + ((speedAdjustments == null) ? 0 : speedAdjustments.hashCode());
        result = prime * result + ((speedNotes == null) ? 0 : speedNotes.hashCode());
        result = prime * result + ((speeds == null) ? 0 : speeds.hashCode());
        result = prime * result + ((trackFormats == null) ? 0 : trackFormats.hashCode());
        result = prime * result + ((trackings == null) ? 0 : trackings.hashCode());
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
        PhysicalData other = (PhysicalData) obj;
        if (conditions == null) {
            if (other.conditions != null)
                return false;
        } else if (!conditions.equals(other.conditions))
            return false;
        if (dimensions == null) {
            if (other.dimensions != null)
                return false;
        } else if (!dimensions.equals(other.dimensions))
            return false;
        if (dispositions == null) {
            if (other.dispositions != null)
                return false;
        } else if (!dispositions.equals(other.dispositions))
            return false;
        if (ebuStorageMediaCodes == null) {
            if (other.ebuStorageMediaCodes != null)
                return false;
        } else if (!ebuStorageMediaCodes.equals(other.ebuStorageMediaCodes))
            return false;
        if (equalizations == null) {
            if (other.equalizations != null)
                return false;
        } else if (!equalizations.equals(other.equalizations))
            return false;
        if (generations == null) {
            if (other.generations != null)
                return false;
        } else if (!generations.equals(other.generations))
            return false;
        if (grooves == null) {
            if (other.grooves != null)
                return false;
        } else if (!grooves.equals(other.grooves))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (materials == null) {
            if (other.materials != null)
                return false;
        } else if (!materials.equals(other.materials))
            return false;
        if (noiseReductions == null) {
            if (other.noiseReductions != null)
                return false;
        } else if (!noiseReductions.equals(other.noiseReductions))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (physFormats == null) {
            if (other.physFormats != null)
                return false;
        } else if (!physFormats.equals(other.physFormats))
            return false;
        if (speedAdjustments == null) {
            if (other.speedAdjustments != null)
                return false;
        } else if (!speedAdjustments.equals(other.speedAdjustments))
            return false;
        if (speedNotes == null) {
            if (other.speedNotes != null)
                return false;
        } else if (!speedNotes.equals(other.speedNotes))
            return false;
        if (speeds == null) {
            if (other.speeds != null)
                return false;
        } else if (!speeds.equals(other.speeds))
            return false;
        if (trackFormats == null) {
            if (other.trackFormats != null)
                return false;
        } else if (!trackFormats.equals(other.trackFormats))
            return false;
        if (trackings == null) {
            if (other.trackings != null)
                return false;
        } else if (!trackings.equals(other.trackings))
            return false;
        return true;
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
