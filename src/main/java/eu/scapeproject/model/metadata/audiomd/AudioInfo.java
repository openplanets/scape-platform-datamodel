package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="audioinfo",namespace="http://www.loc.gov/AMD/")
public class AudioInfo {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="duration",namespace="http://www.loc.gov/AMD/")
    private List<String> durations;
    @XmlElement(name="note",namespace="http://www.loc.gov/AMD/")
    private List<String> notes;
    @XmlElement(name="numchannel",namespace="http://www.loc.gov/AMD/")
    private List<String> numChannnels;
    @XmlElement(name="soundchannelmap",namespace="http://www.loc.gov/AMD/")
    private List<SoundChannelMap> soundChannelMaps;
    @XmlElement(name="soundfields",namespace="http://www.loc.gov/AMD/")
    private List<String> soundFields;

    private AudioInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public List<String> getDurations() {
        return durations;
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

    private AudioInfo(Builder builder) {
        this.id = builder.id;
        this.durations = builder.durations;
        this.notes = builder.notes;
        this.numChannnels = builder.numChannnels;
        this.soundChannelMaps = builder.soundChannelMaps;
        this.soundFields = builder.soundFields;
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
