package eu.scapeproject.model.metadata.mix;

public class ScannerCapture {
    private String scannerManufacturer;
    private String scannerModelName;
    private String scannerModelNumber;
    private String scannerModelSerialNo;
    private String maximumOpticalResolution;
    private ScannerSensor scannerSensor;
    private String scanningSoftwareName;
    private String scanningSoftwareVersionNo;

    private ScannerCapture() {
        super();
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
