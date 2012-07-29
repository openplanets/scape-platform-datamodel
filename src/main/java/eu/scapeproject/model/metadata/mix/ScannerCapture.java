package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="scannerCapture",namespace="http://www.loc.gov/mix/v10")
public class ScannerCapture {
    @XmlElement(name="scannerManufacturer",namespace="http://www.loc.gov/mix/v10")
    private final String scannerManufacturer;
    @XmlElement(name="scannerModelName",namespace="http://www.loc.gov/mix/v10")
    private final String scannerModelName;
    @XmlElement(name="scannerModelNumber",namespace="http://www.loc.gov/mix/v10")
    private final String scannerModelNumber;
    @XmlElement(name="scannerModelSerialNo",namespace="http://www.loc.gov/mix/v10")
    private final String scannerModelSerialNo;
    @XmlElement(name="maximumOpticalResolution",namespace="http://www.loc.gov/mix/v10")
    private final String maximumOpticalResolution;
    @XmlElement(name="scannerSensor",namespace="http://www.loc.gov/mix/v10")
    private final ScannerSensor scannerSensor;
    @XmlElement(name="scanningSoftwareName",namespace="http://www.loc.gov/mix/v10")
    private final String scanningSoftwareName;
    @XmlElement(name="scanningSoftwareVersionNo",namespace="http://www.loc.gov/mix/v10")
    private final String scanningSoftwareVersionNo;

    private ScannerCapture() {
        super();
        this.scannerManufacturer = null;
        this.scannerModelName = null;
        this.scannerModelNumber = null;
        this.scannerModelSerialNo = null;
        this.maximumOpticalResolution = null;
        this.scannerSensor = null;
        this.scanningSoftwareName = null;
        this.scanningSoftwareVersionNo = null;
   }

    private ScannerCapture(Builder builder) {
        this.scannerManufacturer = builder.scannerManufacturer;
        this.scannerModelName = builder.scannerModelName;
        this.scannerModelNumber = builder.scannerModelNumber;
        this.scannerModelSerialNo = builder.scannerModelSerialNo;
        this.maximumOpticalResolution = builder.maximumOpticalResolution;
        this.scannerSensor = builder.scannerSensor;
        this.scanningSoftwareName = builder.scanningSoftwareName;
        this.scanningSoftwareVersionNo = builder.scanningSoftwareVersionNo;
    }

    public String getMaximumOpticalResolution() {
        return maximumOpticalResolution;
    }

    public String getScannerManufacturer() {
        return scannerManufacturer;
    }

    public String getScannerModelName() {
        return scannerModelName;
    }

    public String getScannerModelNumber() {
        return scannerModelNumber;
    }

    public String getScannerModelSerialNo() {
        return scannerModelSerialNo;
    }

    public ScannerSensor getScannerSensor() {
        return scannerSensor;
    }

    public String getScanningSoftwareName() {
        return scanningSoftwareName;
    }

    public String getScanningSoftwareVersionNo() {
        return scanningSoftwareVersionNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maximumOpticalResolution == null) ? 0 : maximumOpticalResolution.hashCode());
        result = prime * result + ((scannerManufacturer == null) ? 0 : scannerManufacturer.hashCode());
        result = prime * result + ((scannerModelName == null) ? 0 : scannerModelName.hashCode());
        result = prime * result + ((scannerModelNumber == null) ? 0 : scannerModelNumber.hashCode());
        result = prime * result + ((scannerModelSerialNo == null) ? 0 : scannerModelSerialNo.hashCode());
        result = prime * result + ((scannerSensor == null) ? 0 : scannerSensor.hashCode());
        result = prime * result + ((scanningSoftwareName == null) ? 0 : scanningSoftwareName.hashCode());
        result = prime * result + ((scanningSoftwareVersionNo == null) ? 0 : scanningSoftwareVersionNo.hashCode());
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
        ScannerCapture other = (ScannerCapture) obj;
        if (maximumOpticalResolution == null) {
            if (other.maximumOpticalResolution != null)
                return false;
        } else if (!maximumOpticalResolution.equals(other.maximumOpticalResolution))
            return false;
        if (scannerManufacturer == null) {
            if (other.scannerManufacturer != null)
                return false;
        } else if (!scannerManufacturer.equals(other.scannerManufacturer))
            return false;
        if (scannerModelName == null) {
            if (other.scannerModelName != null)
                return false;
        } else if (!scannerModelName.equals(other.scannerModelName))
            return false;
        if (scannerModelNumber == null) {
            if (other.scannerModelNumber != null)
                return false;
        } else if (!scannerModelNumber.equals(other.scannerModelNumber))
            return false;
        if (scannerModelSerialNo == null) {
            if (other.scannerModelSerialNo != null)
                return false;
        } else if (!scannerModelSerialNo.equals(other.scannerModelSerialNo))
            return false;
        if (scannerSensor != other.scannerSensor)
            return false;
        if (scanningSoftwareName == null) {
            if (other.scanningSoftwareName != null)
                return false;
        } else if (!scanningSoftwareName.equals(other.scanningSoftwareName))
            return false;
        if (scanningSoftwareVersionNo == null) {
            if (other.scanningSoftwareVersionNo != null)
                return false;
        } else if (!scanningSoftwareVersionNo.equals(other.scanningSoftwareVersionNo))
            return false;
        return true;
    }

    public static class Builder {
        private String scannerManufacturer;
        private String scannerModelName;
        private String scannerModelNumber;
        private String scannerModelSerialNo;
        private String maximumOpticalResolution;
        private ScannerSensor scannerSensor;
        private String scanningSoftwareName;
        private String scanningSoftwareVersionNo;

        public ScannerCapture build() {
            return new ScannerCapture(this);
        }

        public Builder maximumOpticalResolution(String maximumOpticalResolution) {
            this.maximumOpticalResolution = maximumOpticalResolution;
            return this;
        }

        public Builder scannerManufacturer(String scannerManufacturer) {
            this.scannerManufacturer = scannerManufacturer;
            return this;
        }

        public Builder scannerModelName(String scannerModelName) {
            this.scannerModelName = scannerModelName;
            return this;
        }

        public Builder scannerModelNumber(String scannerModelNumber) {
            this.scannerModelNumber = scannerModelNumber;
            return this;
        }

        public Builder scannerModelSerialNo(String scannerModelSerialNo) {
            this.scannerModelSerialNo = scannerModelSerialNo;
            return this;
        }

        public Builder scannerSensor(ScannerSensor scannerSensor) {
            this.scannerSensor = scannerSensor;
            return this;
        }

        public Builder scanningSoftwareName(String scanningSoftwareName) {
            this.scanningSoftwareName = scanningSoftwareName;
            return this;
        }

        public Builder scanningSoftwareVersionNo(String scanningSoftwareVersionNo) {
            this.scanningSoftwareVersionNo = scanningSoftwareVersionNo;
            return this;
        }
    }

    public enum ScannerSensor {
        UNDEFINED, MONOCHROME_LINEAR, COLOR_TRI_LINEAR, COLOR_SEQUENTIAL_LINEAR;
    }
}
