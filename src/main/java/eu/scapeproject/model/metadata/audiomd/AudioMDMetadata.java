package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.BitStream;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.util.CopyUtil;

@XmlRootElement(name = "audio")
public class AudioMDMetadata extends TechnicalMetadata {
	@XmlElement(name = "audiomd", namespace = "http://www.loc.gov/AMD/")
	private final Audio audioMD;
	@XmlElement(name = "audiosrc", namespace = "http://www.loc.gov/AMD/")
	private final Audio audioSrc;

	private AudioMDMetadata() {
		super(MetadataType.AUDIOMD);
		this.audioMD = null;
		this.audioSrc = null;
	}

	public AudioMDMetadata(Builder b) {
		super(MetadataType.AUDIOMD);
		this.audioMD = b.audioMd;
		this.audioSrc = b.audioSrc;
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AudioMDMetadata other = (AudioMDMetadata) obj;
        if (audioMD == null) {
            if (other.audioMD != null)
                return false;
        } else if (!audioMD.equals(other.audioMD))
            return false;
        if (audioSrc == null) {
            if (other.audioSrc != null)
                return false;
        } else if (!audioSrc.equals(other.audioSrc))
            return false;
        return true;
    };

	public Audio getAudioMD() {
		return audioMD;
	}

	public Audio getAudioSrc() {
		return audioSrc;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((audioMD == null) ? 0 : audioMD.hashCode());
        result = prime * result + ((audioSrc == null) ? 0 : audioSrc.hashCode());
        return result;
    }

    public static class Builder {
		private Audio audioMd;
		private Audio audioSrc;

		public Builder() {
			super();
		}

		public Builder(AudioMDMetadata orig) {
			orig=CopyUtil.deepCopy(AudioMDMetadata.class, orig);
			this.audioMd = orig.audioMD;
			this.audioSrc = orig.audioSrc;
		}

		public Builder audioMd(Audio audioMd) {
			this.audioMd = audioMd;
			return this;
		}

		public Builder audioSrc(Audio audioSrc) {
			this.audioSrc = audioSrc;
			return this;
		}

		public AudioMDMetadata build() {
			return new AudioMDMetadata(this);
		}
	}
}
