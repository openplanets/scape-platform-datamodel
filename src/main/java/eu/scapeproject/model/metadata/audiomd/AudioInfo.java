package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="audioinfo",namespace="http://www.loc.gov/AMD/")
public class AudioInfo {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name="duration",namespace="http://www.loc.gov/AMD/")
    private final List<String> durations;
    @XmlElement(name="note",namespace="http://www.loc.gov/AMD/")
    private final List<String> notes;
    @XmlElement(name="numchannel",namespace="http://www.loc.gov/AMD/")
    private final List<String> numChannnels;
    @XmlElement(name="soundchannelmap",namespace="http://www.loc.gov/AMD/")
    private final List<SoundChannelMap> soundChannelMaps;
    @XmlElement(name="soundfields",namespace="http://www.loc.gov/AMD/")
    private final List<String> soundFields;

    private AudioInfo() {
        super();
        this.id=null;
        this.durations=null;
        this.notes=null;
        this.numChannnels=null;
        this.soundChannelMaps=null;
        this.soundFields=null;
    }

    private AudioInfo(Builder builder) {
        this.id = builder.id;
        this.durations = builder.durations;
        this.notes = builder.notes;
        this.numChannnels = builder.numChannnels;
        this.soundChannelMaps = builder.soundChannelMaps;
        this.soundFields = builder.soundFields;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AudioInfo other = (AudioInfo) obj;
        if (durations == null) {
            if (other.durations != null)
                return false;
        } else if (!durations.equals(other.durations))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (numChannnels == null) {
            if (other.numChannnels != null)
                return false;
        } else if (!numChannnels.equals(other.numChannnels))
            return false;
        if (soundChannelMaps == null) {
            if (other.soundChannelMaps != null)
                return false;
        } else if (!soundChannelMaps.equals(other.soundChannelMaps))
            return false;
        if (soundFields == null) {
            if (other.soundFields != null)
                return false;
        } else if (!soundFields.equals(other.soundFields))
            return false;
        return true;
    }

    public List<String> getDurations() {
        return durations;
    }

    public String getId() {
        return id;
    }

    public List<String> getNotes() {
        return notes;
    }

    public List<String> getNumChannnels() {
        return numChannnels;
    }

    public List<SoundChannelMap> getSoundChannelMaps() {
        return soundChannelMaps;
    }

    public List<String> getSoundFields() {
        return soundFields;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((durations == null) ? 0 : durations.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((numChannnels == null) ? 0 : numChannnels.hashCode());
        result = prime * result + ((soundChannelMaps == null) ? 0 : soundChannelMaps.hashCode());
        result = prime * result + ((soundFields == null) ? 0 : soundFields.hashCode());
        return result;
    }

    public static class Builder {
        private final String id;
        private List<String> durations;
        private List<String> notes;
        private List<String> numChannnels;
        private List<SoundChannelMap> soundChannelMaps;
        private List<String> soundFields;

        public Builder(String id) {
            super();
            this.id = id;
        }

        public AudioInfo build() {
            return new AudioInfo(this);
        }

        public Builder durations(List<String> durations) {
            this.durations = durations;
            return this;
        }

        public Builder notes(List<String> notes) {
            this.notes = notes;
            return this;
        }

        public Builder numChannnels(List<String> numChannnels) {
            this.numChannnels = numChannnels;
            return this;
        }

        public Builder soundChannelMaps(List<SoundChannelMap> soundChannelMaps) {
            this.soundChannelMaps = soundChannelMaps;
            return this;
        }

        public Builder soundFields(List<String> soundFields) {
            this.soundFields = soundFields;
            return this;
        }
    }
}
