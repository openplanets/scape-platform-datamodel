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
    
    
    public enum ScannerSensor{
        UNDEFINED,MONOCHROME_LINEAR,COLOR_TRI_LINEAR,COLOR_SEQUENTIAL_LINEAR;
    }
}
