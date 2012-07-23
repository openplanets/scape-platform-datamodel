package eu.scapeproject.model.metadata.mix;

import java.util.Date;
import java.util.List;

public class GeneralCaptureInformation {
    private Date dateTimeCreated;
    private List<String> imageProducers;
    private CaptureDevice captureDevice;

    @SuppressWarnings("unused")
    private GeneralCaptureInformation() {
        super();
    }

    public GeneralCaptureInformation(Date dateTimeCreated, CaptureDevice captureDevice, List<String> imageProducers) {
        super();
        this.dateTimeCreated = dateTimeCreated;
        this.imageProducers = imageProducers;
        this.captureDevice = captureDevice;
    }

    public CaptureDevice getCaptureDevice() {
        return captureDevice;
    }

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public List<String> getImageProducers() {
        return imageProducers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((captureDevice == null) ? 0 : captureDevice.hashCode());
        result = prime * result + ((dateTimeCreated == null) ? 0 : dateTimeCreated.hashCode());
        result = prime * result + ((imageProducers == null) ? 0 : imageProducers.hashCode());
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
        GeneralCaptureInformation other = (GeneralCaptureInformation) obj;
        if (captureDevice != other.captureDevice)
            return false;
        if (dateTimeCreated == null) {
            if (other.dateTimeCreated != null)
                return false;
        } else if (!dateTimeCreated.equals(other.dateTimeCreated))
            return false;
        if (imageProducers == null) {
            if (other.imageProducers != null)
                return false;
        } else if (!imageProducers.equals(other.imageProducers))
            return false;
        return true;
    }

    public enum CaptureDevice {
        TRANSMISSION_SCANNER, REFLCTION_PRINT_SCANNER, DIGITAL_STILL_CAMERA, DIGITAL_VIDEO_STILL;
    }
}
