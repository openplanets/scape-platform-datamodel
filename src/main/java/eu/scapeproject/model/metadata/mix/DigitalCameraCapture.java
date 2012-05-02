package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "digitalCameraCapture", namespace = "http://www.loc.gov/mix/v10")
public class DigitalCameraCapture {
    @XmlElement(name = "digitalCameraManufacturer", namespace = "http://www.loc.gov/mix/v10")
    private String digitalCameraManufacturer;
    @XmlElement(name = "digitalCameraModelName", namespace = "http://www.loc.gov/mix/v10")
    private String digitalCameraModelName;
    @XmlElement(name = "digitalCameraModelNumber", namespace = "http://www.loc.gov/mix/v10")
    private String digitalCameraModelNumber;
    @XmlElement(name = "digitalCameraModelSerialNo", namespace = "http://www.loc.gov/mix/v10")
    private String digitalCameraModelSerialNo;
    @XmlElement(name = "digitalCameraSensor", namespace = "http://www.loc.gov/mix/v10")
    private String digitalCameraSensor;
    @XmlElement(name = "imageData", namespace = "http://www.loc.gov/mix/v10")
    private ImageData imageData;
    @XmlElement(name = "gpsData", namespace = "http://www.loc.gov/mix/v10")
    private GPSData gpsData;

    private DigitalCameraCapture() {
        super();
    }

    private DigitalCameraCapture(Builder builder) {
        this.digitalCameraManufacturer = builder.digitalCameraManufacturer;
        this.digitalCameraModelName = builder.digitalCameraModelName;
        this.digitalCameraModelNumber = builder.digitalCameraModelNumber;
        this.digitalCameraModelSerialNo = builder.digitalCameraModelSerialNo;
        this.digitalCameraSensor = builder.digitalCameraSensor;
        this.imageData = builder.imageData;
        this.gpsData = builder.gpsData;
    }

    public String getDigitalCameraManufacturer() {
        return digitalCameraManufacturer;
    }

    public String getDigitalCameraModelName() {
        return digitalCameraModelName;
    }

    public String getDigitalCameraModelNumber() {
        return digitalCameraModelNumber;
    }

    public String getDigitalCameraModelSerialNo() {
        return digitalCameraModelSerialNo;
    }

    public String getDigitalCameraSensor() {
        return digitalCameraSensor;
    }

    public GPSData getGpsData() {
        return gpsData;
    }

    public ImageData getImageData() {
        return imageData;
    }

    public static class Builder {
        private String digitalCameraManufacturer;
        private String digitalCameraModelName;
        private String digitalCameraModelNumber;
        private String digitalCameraModelSerialNo;
        private String digitalCameraSensor;
        private ImageData imageData;
        private GPSData gpsData;

        public DigitalCameraCapture build() {
            return new DigitalCameraCapture(this);
        }

        public Builder digitalCameraManufacturer(String digitalCameraManufacturer) {
            this.digitalCameraManufacturer = digitalCameraManufacturer;
            return this;
        }

        public Builder digitalCameraModelName(String digitalCameraModelName) {
            this.digitalCameraModelName = digitalCameraModelName;
            return this;
        }

        public Builder digitalCameraModelNumber(String digitalCameraModelNumber) {
            this.digitalCameraModelNumber = digitalCameraModelNumber;
            return this;
        }

        public Builder digitalCameraModelSerialNo(String digitalCameraModelSerialNo) {
            this.digitalCameraModelSerialNo = digitalCameraModelSerialNo;
            return this;
        }

        public Builder digitalCameraSensor(String digitalCameraSensor) {
            this.digitalCameraSensor = digitalCameraSensor;
            return this;
        }

        public Builder gpsData(GPSData gpsData) {
            this.gpsData = gpsData;
            return this;
        }

        public Builder imageData(ImageData imageData) {
            this.imageData = imageData;
            return this;
        }
    }
}
