package eu.scapeproject.model.metadata.videomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filedata", namespace = "http://www.loc.gov/videoMD/")
public class VideoFileData extends MediaDataType {
	@XmlElement(name = "bitspersample", namespace = "http://www.loc.gov/videoMD/")
	private final List<Integer> bitsPerSample;
	@XmlElement(name = "byteorder", namespace = "http://www.loc.gov/videoMD/")
	private final List<Integer> byteOrder;
	@XmlElement(name = "color", namespace = "http://www.loc.gov/videoMD/")
	private final String color;
	@XmlElement(name = "othercolor", namespace = "http://www.loc.gov/videoMD/")
	private final String otherColor;
	@XmlElement(name = "messaegdigest", namespace = "http://www.loc.gov/videoMD/")
	private final VideoMessageDigest messageDigest;
	@XmlElement(name = "compression", namespace = "http://www.loc.gov/videoMD/")
	private final List<VideoCompression> comressions;
	@XmlElement(name = "track", namespace = "http://www.loc.gov/videoMD/")
	private final List<VideoTrack> tracks;
	@XmlElement(name = "datarateunit", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> dataRateUnit;
	@XmlElement(name = "dataratemode", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> dataRateMode;
	@XmlElement(name = "frame", namespace = "http://www.loc.gov/videoMD/")
	private final VideoFrame frame;
	@XmlElement(name = "framerate", namespace = "http://www.loc.gov/videoMD/")
	private final VideoVariableRate frameRate;
	@XmlElement(name = "samplerate", namespace = "http://www.loc.gov/videoMD/")
	private final VideoVariableRate sampleRate;
	@XmlElement(name = "location", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> locations;
	@XmlElement(name = "format", namespace = "http://www.loc.gov/videoMD/")
	private final List<VideoFormat> formats;
	@XmlElement(name = "sampling", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> sampling;
	@XmlElement(name = "signalformat", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> signalFormat;
	@XmlElement(name = "sound", namespace = "http://www.loc.gov/videoMD/")
	private final List<String> sound;

	private VideoFileData() {
		super();
		this.bitsPerSample = null;
		this.byteOrder = null;
		this.color = null;
		this.otherColor = null;
		this.messageDigest = null;
		this.comressions = null;
		this.tracks = null;
		this.dataRateUnit = null;
		this.dataRateMode = null;
		this.frame = null;
		this.frameRate = null;
		this.sampleRate = null;
		this.locations = null;
		this.formats = null;
		this.sampling = null;
		this.signalFormat = null;
		this.sound = null;
	}

	private VideoFileData(Builder builder) {
		super(builder.trackingInfos, builder.duration, builder.languages, builder.security, builder.size, builder.dataRate,
				builder.timeCodes, builder.uses, builder.otherUses);
		this.bitsPerSample = builder.bitsPerSample;
		this.byteOrder = builder.byteOrder;
		this.color = builder.color;
		this.otherColor = builder.otherColor;
		this.messageDigest = builder.messageDigest;
		this.comressions = builder.comressions;
		this.tracks = builder.tracks;
		this.dataRateUnit = builder.dataRateUnit;
		this.dataRateMode = builder.dataRateMode;
		this.frame = builder.frame;
		this.frameRate = builder.frameRate;
		this.sampleRate = builder.sampleRate;
		this.locations = builder.locations;
		this.formats = builder.formats;
		this.sampling = builder.sampling;
		this.signalFormat = builder.signalFormat;
		this.sound = builder.sound;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoFileData other = (VideoFileData) obj;
		if (bitsPerSample == null) {
			if (other.bitsPerSample != null)
				return false;
		} else if (!bitsPerSample.equals(other.bitsPerSample))
			return false;
		if (byteOrder == null) {
			if (other.byteOrder != null)
				return false;
		} else if (!byteOrder.equals(other.byteOrder))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (comressions == null) {
			if (other.comressions != null)
				return false;
		} else if (!comressions.equals(other.comressions))
			return false;
		if (dataRateMode == null) {
			if (other.dataRateMode != null)
				return false;
		} else if (!dataRateMode.equals(other.dataRateMode))
			return false;
		if (dataRateUnit == null) {
			if (other.dataRateUnit != null)
				return false;
		} else if (!dataRateUnit.equals(other.dataRateUnit))
			return false;
		if (formats == null) {
			if (other.formats != null)
				return false;
		} else if (!formats.equals(other.formats))
			return false;
		if (frame == null) {
			if (other.frame != null)
				return false;
		} else if (!frame.equals(other.frame))
			return false;
		if (frameRate == null) {
			if (other.frameRate != null)
				return false;
		} else if (!frameRate.equals(other.frameRate))
			return false;
		if (locations == null) {
			if (other.locations != null)
				return false;
		} else if (!locations.equals(other.locations))
			return false;
		if (messageDigest == null) {
			if (other.messageDigest != null)
				return false;
		} else if (!messageDigest.equals(other.messageDigest))
			return false;
		if (otherColor == null) {
			if (other.otherColor != null)
				return false;
		} else if (!otherColor.equals(other.otherColor))
			return false;
		if (sampleRate == null) {
			if (other.sampleRate != null)
				return false;
		} else if (!sampleRate.equals(other.sampleRate))
			return false;
		if (sampling == null) {
			if (other.sampling != null)
				return false;
		} else if (!sampling.equals(other.sampling))
			return false;
		if (signalFormat == null) {
			if (other.signalFormat != null)
				return false;
		} else if (!signalFormat.equals(other.signalFormat))
			return false;
		if (sound == null) {
			if (other.sound != null)
				return false;
		} else if (!sound.equals(other.sound))
			return false;
		if (tracks == null) {
			if (other.tracks != null)
				return false;
		} else if (!tracks.equals(other.tracks))
			return false;
		return true;
	}

	public List<Integer> getBitsPerSample() {
		return bitsPerSample;
	}

	public List<Integer> getByteOrder() {
		return byteOrder;
	}

	public String getColor() {
		return color;
	}

	public List<VideoCompression> getComressions() {
		return comressions;
	}

	public List<String> getDataRateMode() {
		return dataRateMode;
	}

	public List<String> getDataRateUnit() {
		return dataRateUnit;
	}

	public List<VideoFormat> getFormats() {
		return formats;
	}

	public VideoFrame getFrame() {
		return frame;
	}

	public VideoVariableRate getFrameRate() {
		return frameRate;
	}

	public List<String> getLocations() {
		return locations;
	}

	public VideoMessageDigest getMessageDigest() {
		return messageDigest;
	}

	public String getOtherColor() {
		return otherColor;
	}

	public VideoVariableRate getSampleRate() {
		return sampleRate;
	}

	public List<String> getSampling() {
		return sampling;
	}

	public List<String> getSignalFormat() {
		return signalFormat;
	}

	public List<String> getSound() {
		return sound;
	}

	public List<VideoTrack> getTracks() {
		return tracks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bitsPerSample == null) ? 0 : bitsPerSample.hashCode());
		result = prime * result + ((byteOrder == null) ? 0 : byteOrder.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((comressions == null) ? 0 : comressions.hashCode());
		result = prime * result + ((dataRateMode == null) ? 0 : dataRateMode.hashCode());
		result = prime * result + ((dataRateUnit == null) ? 0 : dataRateUnit.hashCode());
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
		result = prime * result + ((frame == null) ? 0 : frame.hashCode());
		result = prime * result + ((frameRate == null) ? 0 : frameRate.hashCode());
		result = prime * result + ((locations == null) ? 0 : locations.hashCode());
		result = prime * result + ((messageDigest == null) ? 0 : messageDigest.hashCode());
		result = prime * result + ((otherColor == null) ? 0 : otherColor.hashCode());
		result = prime * result + ((sampleRate == null) ? 0 : sampleRate.hashCode());
		result = prime * result + ((sampling == null) ? 0 : sampling.hashCode());
		result = prime * result + ((signalFormat == null) ? 0 : signalFormat.hashCode());
		result = prime * result + ((sound == null) ? 0 : sound.hashCode());
		result = prime * result + ((tracks == null) ? 0 : tracks.hashCode());
		return result;
	}

	public static class Builder {
		private List<Integer> bitsPerSample;
		private List<Integer> byteOrder;
		private String color;
		private String otherColor;
		private VideoMessageDigest messageDigest;
		private List<VideoCompression> comressions;
		private List<VideoTrack> tracks;
		private List<String> dataRateUnit;
		private List<String> dataRateMode;
		private VideoFrame frame;
		private VideoVariableRate frameRate;
		private VideoVariableRate sampleRate;
		private List<String> locations;
		private List<VideoFormat> formats;
		private List<String> sampling;
		private List<String> signalFormat;
		private List<String> sound;
		private List<VideoTrackingInfo> trackingInfos;
		private String duration;
		private List<VideoLanguage> languages;
		private String security;
		private int size;
		private VideoVariableRate dataRate;
		private List<VideoTimeCode> timeCodes;
		private List<String> uses;
		private List<String> otherUses;

		public Builder bitsPerSample(List<Integer> bitsPerSample) {
			this.bitsPerSample = bitsPerSample;
			return this;
		}

		public VideoFileData build() {
			return new VideoFileData(this);
		}

		public Builder byteOrder(List<Integer> byteOrder) {
			this.byteOrder = byteOrder;
			return this;
		}

		public Builder color(String color) {
			this.color = color;
			return this;
		}

		public Builder comressions(List<VideoCompression> comressions) {
			this.comressions = comressions;
			return this;
		}

		public Builder dataRate(VideoVariableRate dataRate) {
			this.dataRate = dataRate;
			return this;
		}

		public Builder dataRateMode(List<String> dataRateMode) {
			this.dataRateMode = dataRateMode;
			return this;
		}

		public Builder dataRateUnit(List<String> dataRateUnit) {
			this.dataRateUnit = dataRateUnit;
			return this;
		}

		public Builder duration(String duration) {
			this.duration = duration;
			return this;
		}

		public Builder formats(List<VideoFormat> formats) {
			this.formats = formats;
			return this;
		}

		public Builder frame(VideoFrame frame) {
			this.frame = frame;
			return this;
		}

		public Builder frameRate(VideoVariableRate frameRate) {
			this.frameRate = frameRate;
			return this;
		}

		public Builder language(List<VideoLanguage> languages) {
			this.languages = languages;
			return this;
		}

		public Builder locations(List<String> locations) {
			this.locations = locations;
			return this;
		}

		public Builder messageDigest(VideoMessageDigest messageDigest) {
			this.messageDigest = messageDigest;
			return this;
		}

		public Builder otherColor(String otherColor) {
			this.otherColor = otherColor;
			return this;
		}

		public Builder otherUses(List<String> otherUses) {
			this.otherUses = otherUses;
			return this;
		}

		public Builder sampleRate(VideoVariableRate sampleRate) {
			this.sampleRate = sampleRate;
			return this;
		}

		public Builder sampling(List<String> sampling) {
			this.sampling = sampling;
			return this;
		}

		public Builder security(String security) {
			this.security = security;
			return this;
		}

		public Builder signalFormat(List<String> signalFormat) {
			this.signalFormat = signalFormat;
			return this;
		}

		public Builder size(int size) {
			this.size = size;
			return this;
		}

		public Builder sound(List<String> sound) {
			this.sound = sound;
			return this;
		}

		public Builder timeCodes(List<VideoTimeCode> timeCodes) {
			this.timeCodes = timeCodes;
			return this;
		}

		public Builder trackingInfos(List<VideoTrackingInfo> trackingInfos) {
			this.trackingInfos = trackingInfos;
			return this;
		}

		public Builder tracks(List<VideoTrack> tracks) {
			this.tracks = tracks;
			return this;
		}

		public Builder uses(List<String> uses) {
			this.uses = uses;
			return this;
		}
	}
}
