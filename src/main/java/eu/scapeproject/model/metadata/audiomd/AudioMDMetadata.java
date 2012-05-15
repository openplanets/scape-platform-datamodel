package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "http://www.loc.gov/AMD/")
public class AudioMDMetadata extends TechnicalMetadata {
    @XmlElement(name = "audiomd", namespace = "http://www.loc.gov/AMD/")
    private Audio audioMD;
    @XmlElement(name = "audiosrc", namespace = "http://www.loc.gov/AMD/")
    private Audio audioSrc;

    private AudioMDMetadata() {
        super(MetadataType.AUDIOMD);
    }

    public AudioMDMetadata(Audio audioMD, Audio audioSrc) {
        this();
        this.audioMD = audioMD;
        this.audioSrc = audioSrc;
    }

    public Audio getAudioMD() {
        return audioMD;
    };

    public Audio getAudioSrc() {
        return audioSrc;
    }
}
