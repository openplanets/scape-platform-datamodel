package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "audioMD", namespace = "http://www.loc.gov/AMD/")
public class Audio {
	@XmlAttribute(name = "id", namespace = "http://www.loc.gov/AMD/")
	private final String id;
	@XmlElement(name = "filedata", namespace = "http://www.loc.gov/AMD/")
	private final List<FileData> fileData;
	@XmlElement(name = "physicaldata", namespace = "http://www.loc.gov/AMD/")
	private final List<PhysicalData> physicalData;
	@XmlElement(name = "audioinfo", namespace = "http://www.loc.gov/AMD/")
	private final List<AudioInfo> audioInfos;
	@XmlElement(name = "calibrateinfo", namespace = "http://www.loc.gov/AMD/")
	private final List<CalibrationInfo> calibrateInfos;
	@XmlElement(name = "analogdigitalflag", namespace = "http://www.loc.gov/AMD/")
	private final AnalogDigitalFlag analogDigitalFlag;

	private Audio() {
		super();
		this.id = null;
		this.fileData = null;
		this.physicalData = null;
		this.audioInfos = null;
		this.calibrateInfos = null;
		this.analogDigitalFlag = null;
	}

	private Audio(Builder b) {
		this.analogDigitalFlag = b.analogDigitalFlag;
		this.audioInfos = b.audioInfos;
		this.calibrateInfos = b.calibrateInfos;
		this.fileData = b.fileData;
		this.id = b.id;
		this.physicalData = b.physicalData;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		if (analogDigitalFlag != other.analogDigitalFlag)
			return false;
		if (audioInfos == null) {
			if (other.audioInfos != null)
				return false;
		} else if (!audioInfos.equals(other.audioInfos))
			return false;
		if (calibrateInfos == null) {
			if (other.calibrateInfos != null)
				return false;
		} else if (!calibrateInfos.equals(other.calibrateInfos))
			return false;
		if (fileData == null) {
			if (other.fileData != null)
				return false;
		} else if (!fileData.equals(other.fileData))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (physicalData == null) {
			if (other.physicalData != null)
				return false;
		} else if (!physicalData.equals(other.physicalData))
			return false;
		return true;
	}

	public AnalogDigitalFlag getAnalogDigitalFlag() {
		return analogDigitalFlag;
	}

	public List<AudioInfo> getAudioInfos() {
		return audioInfos;
	}

	public List<CalibrationInfo> getCalibrateInfos() {
		return calibrateInfos;
	}

	public List<FileData> getFileData() {
		return fileData;
	}

	public String getId() {
		return id;
	}

	public List<PhysicalData> getPhysicalData() {
		return physicalData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((analogDigitalFlag == null) ? 0 : analogDigitalFlag.hashCode());
		result = prime * result + ((audioInfos == null) ? 0 : audioInfos.hashCode());
		result = prime * result + ((calibrateInfos == null) ? 0 : calibrateInfos.hashCode());
		result = prime * result + ((fileData == null) ? 0 : fileData.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((physicalData == null) ? 0 : physicalData.hashCode());
		return result;
	}

	@XmlEnum
	public enum AnalogDigitalFlag {
		ANALOG, PHYS_DIGITAL, FILE_DIGITAL;
	}

	public static class Builder {
		private final String id;
		private List<FileData> fileData;
		private List<PhysicalData> physicalData;
		private List<AudioInfo> audioInfos;
		private List<CalibrationInfo> calibrateInfos;
		private AnalogDigitalFlag analogDigitalFlag;

		public Builder(String id) {
			super();
			this.id = id;
		}

		public Builder analogDigitalFlag(AnalogDigitalFlag analogDigitalFlag) {
			this.analogDigitalFlag = analogDigitalFlag;
			return this;
		}

		public Builder audioInfos(List<AudioInfo> audioInfos) {
			this.audioInfos = audioInfos;
			return this;
		}

		public Audio build() {
			return new Audio(this);
		}

		public Builder calibrateInfos(List<CalibrationInfo> calibrateInfos) {
			this.calibrateInfos = calibrateInfos;
			return this;
		}

		public Builder fileData(List<FileData> fileData) {
			this.fileData = fileData;
			return this;
		}

		public Builder physicalData(List<PhysicalData> physicalData) {
			this.physicalData = physicalData;
			return this;
		}

	}

}
