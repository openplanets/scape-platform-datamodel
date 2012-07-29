package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "digitalCameraCapture", namespace = "http://www.loc.gov/mix/v10")
public class DigitalCameraCapture {
    @XmlElement(name = "digitalCameraManufacturer", namespace = "http://www.loc.gov/mix/v10")
    private final String digitalCameraManufacturer;
    @XmlElement(name = "digitalCameraModelName", namespace = "http://www.loc.gov/mix/v10")
    private final String digitalCameraModelName;
    @XmlElement(name = "digitalCameraModelNumber", namespace = "http://www.loc.gov/mix/v10")
    private final String digitalCameraModelNumber;
    @XmlElement(name = "digitalCameraModelSerialNo", namespace = "http://www.loc.gov/mix/v10")
    private final String digitalCameraModelSerialNo;
    @XmlElement(name = "digitalCameraSensor", namespace = "http://www.loc.gov/mix/v10")
    private final String digitalCameraSensor;
    @XmlElement(name = "imageData", namespace = "http://www.loc.gov/mix/v10")
    private final ImageData imageData;
    @XmlElement(name = "gpsData", namespace = "http://www.loc.gov/mix/v10")
    private final GPSData gpsData;

    private DigitalCameraCapture() {
        super();
        this.digitalCameraManufacturer = null;
        this.digitalCameraModelName = null;
        this.digitalCameraModelNumber = null;
        this.digitalCameraModelSerialNo = null;
        this.digitalCameraSensor = null;
        this.imageData = null;
        this.gpsData = null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((digitalCameraManufacturer == null) ? 0 : digitalCameraManufacturer.hashCode());
        result = prime * result + ((digitalCameraModelName == null) ? 0 : digitalCameraModelName.hashCode());
        result = prime * result + ((digitalCameraModelNumber == null) ? 0 : digitalCameraModelNumber.hashCode());
        result = prime * result + ((digitalCameraModelSerialNo == null) ? 0 : digitalCameraModelSerialNo.hashCode());
        result = prime * result + ((digitalCameraSensor == null) ? 0 : digitalCameraSensor.hashCode());
        result = prime * result + ((gpsData == null) ? 0 : gpsData.hashCode());
        result = prime * result + ((imageData == null) ? 0 : imageData.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DigitalCameraCapture other = (DigitalCameraCapture) obj;
        if (digitalCameraManufacturer == null) {
            if (other.digitalCameraManufacturer != null)
                return false;
        } else if (!digitalCameraManufacturer.equals(other.digitalCameraManufacturer))
            return false;
        if (digitalCameraModelName == null) {
            if (other.digitalCameraModelName != null)
                return false;
        } else if (!digitalCameraModelName.equals(other.digitalCameraModelName))
            return false;
        if (digitalCameraModelNumber == null) {
            if (other.digitalCameraModelNumber != null)
                return false;
        } else if (!digitalCameraModelNumber.equals(other.digitalCameraModelNumber))
            return false;
        if (digitalCameraModelSerialNo == null) {
            if (other.digitalCameraModelSerialNo != null)
                return false;
        } else if (!digitalCameraModelSerialNo.equals(other.digitalCameraModelSerialNo))
            return false;
        if (digitalCameraSensor == null) {
            if (other.digitalCameraSensor != null)
                return false;
        } else if (!digitalCameraSensor.equals(other.digitalCameraSensor))
            return false;
        if (gpsData == null) {
            if (other.gpsData != null)
                return false;
        } else if (!gpsData.equals(other.gpsData))
            return false;
        if (imageData == null) {
            if (other.imageData != null)
                return false;
        } else if (!imageData.equals(other.imageData))
            return false;
        return true;
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
