package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "timecode", namespace = "http://www.loc.gov/videoMD/")
public class VideoTimeCode {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name = "timecoderecordmethod", namespace = "http://www.loc.gov/videoMD/")
    private String timeCodeRecordMethod;
    @XmlElement(name = "timecodetype", namespace = "http://www.loc.gov/videoMD/")
    private String timeCodeType;
    @XmlElement(name = "timecodeinitialvalue", namespace = "http://www.loc.gov/videoMD/")
    private String timeCodeInitialValue;

    private VideoTimeCode() {
        super();
    }

    private VideoTimeCode(Builder builder) {
        this.id = builder.id;
        this.timeCodeRecordMethod = builder.timeCodeRecordMethod;
        this.timeCodeType = builder.timeCodeType;
        this.timeCodeInitialValue = builder.timeCodeInitialValue;
    }

    public String getId() {
        return id;
    }

    public String getTimeCodeInitialValue() {
        return timeCodeInitialValue;
    }

    public String getTimeCodeRecordMethod() {
        return timeCodeRecordMethod;
    }

    public String getTimeCodeType() {
        return timeCodeType;
    }

    public static class Builder {
        private String id;
        private String timeCodeRecordMethod;
        private String timeCodeType;
        private String timeCodeInitialValue;

        public VideoTimeCode build() {
            return new VideoTimeCode(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder timeCodeInitialValue(String timeCodeInitialValue) {
            this.timeCodeInitialValue = timeCodeInitialValue;
            return this;
        }

        public Builder timeCodeRecordMethod(String timeCodeRecordMethod) {
            this.timeCodeRecordMethod = timeCodeRecordMethod;
            return this;
        }

        public Builder timeCodeType(String timeCodeType) {
            this.timeCodeType = timeCodeType;
            return this;
        }
    }
}
