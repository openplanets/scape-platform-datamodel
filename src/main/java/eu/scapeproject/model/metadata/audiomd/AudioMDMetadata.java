package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "http://www.loc.gov/AMD/")
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

	public Audio getAudioMD() {
		return audioMD;
	};

	public Audio getAudioSrc() {
		return audioSrc;
	}

	public static class Builder {
		private Audio audioMd;
		private Audio audioSrc;

		public Builder() {
			super();
		}

		public Builder(AudioMDMetadata orig) {
			// TODO: deep copy
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
