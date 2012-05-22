package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "audioMD", namespace = "http://www.loc.gov/AMD/")
public class Audio {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/AMD/")
    private String id;

    @XmlElement(name = "filedata", namespace = "http://www.loc.gov/AMD/")
    private List<FileData> fileData;
    @XmlElement(name = "physicaldata", namespace = "http://www.loc.gov/AMD/")
    private List<PhysicalData> physicalData;
    @XmlElement(name = "audioinfo", namespace = "http://www.loc.gov/AMD/")
    private List<AudioInfo> audioInfos;
    @XmlElement(name = "calibrateinfo", namespace = "http://www.loc.gov/AMD/")
    private List<CalibrationInfo> calibrateInfos;
    @XmlElement(name = "analogdigitalflag", namespace = "http://www.loc.gov/AMD/")
    private AnalogDigitalFlag analogDigitalFlag;
    private Audio() {
        super();
    }

    private Audio(Builder b) {
        this.analogDigitalFlag = b.analogDigitalFlag;
        this.audioInfos = b.audioInfos;
        this.calibrateInfos = b.calibrateInfos;
        this.fileData = b.fileData;
        this.id = b.id;
        this.physicalData = b.physicalData;
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
