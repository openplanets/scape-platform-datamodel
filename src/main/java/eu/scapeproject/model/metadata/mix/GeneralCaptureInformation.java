package eu.scapeproject.model.metadata.mix;

import java.util.Date;
import java.util.List;

public class GeneralCaptureInformation {
    private Date dateTimeCreated;
    private List<String> imageProducers;
    private CaptureDevice captureDevice;

    public enum CaptureDevice {
        TRANSMISSION_SCANNER, REFLCTION_PRINT_SCANNER, DIGITAL_STILL_CAMERA, DIGITAL_VIDEO_STILL;
    }
}
