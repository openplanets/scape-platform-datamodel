package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.mix.NisoMixMetadata.Orientation;

@XmlRootElement(name = "imageCaptureMetadata", namespace = "http://www.loc.gov/mix/v10")
public class ImageCaptureMetadata {
    @XmlElement(name = "sourceInformation", namespace = "http://www.loc.gov/mix/v10")
    private SourceInformation sourceInformation;
    @XmlElement(name = "generalCaptureInformation", namespace = "http://www.loc.gov/mix/v10")
    private GeneralCaptureInformation generalCaptureInformation;
    @XmlElement(name = "scannerCapture", namespace = "http://www.loc.gov/mix/v10")
    private ScannerCapture scannerCapture;
    @XmlElement(name = "orientation", namespace = "http://www.loc.gov/mix/v10")
    private Orientation orientation;
    @XmlElement(name = "methodology", namespace = "http://www.loc.gov/mix/v10")
    private String methodology;
    @XmlElement(name = "digitalCameraCapture", namespace = "http://www.loc.gov/mix/v10")
    private DigitalCameraCapture digitalCameraCapture;

    private ImageCaptureMetadata() {
        super();
    }

    private ImageCaptureMetadata(Builder builder) {
        this.sourceInformation = builder.sourceInformation;
        this.generalCaptureInformation = builder.generalCaptureInformation;
        this.scannerCapture = builder.scannerCapture;
        this.orientation = builder.orientation;
        this.methodology = builder.methodology;
        this.digitalCameraCapture = builder.digitalCameraCapture;
    }

    public DigitalCameraCapture getDigitalCameraCapture() {
        return digitalCameraCapture;
    }

    public GeneralCaptureInformation getGeneralCaptureInformation() {
        return generalCaptureInformation;
    }

    public String getMethodology() {
        return methodology;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public ScannerCapture getScannerCapture() {
        return scannerCapture;
    }

    public SourceInformation getSourceInformation() {
        return sourceInformation;
    }

    public static class Builder {
        private SourceInformation sourceInformation;
        private GeneralCaptureInformation generalCaptureInformation;
        private ScannerCapture scannerCapture;
        private Orientation orientation;
        private String methodology;
        private DigitalCameraCapture digitalCameraCapture;

        public ImageCaptureMetadata build() {
            return new ImageCaptureMetadata(this);
        }

        public Builder digitalCameraCapture(DigitalCameraCapture digitalCameraCapture){
            this.digitalCameraCapture=digitalCameraCapture;
            return this;
        }

        public Builder generalCaptureInformation(GeneralCaptureInformation generalCaptureInformation) {
            this.generalCaptureInformation = generalCaptureInformation;
            return this;
        }

        public Builder methodology(String methodology) {
            this.methodology = methodology;
            return this;
        }

        public Builder orientation(Orientation orientation) {
            this.orientation = orientation;
            return this;
        }

        public Builder scannerCapture(ScannerCapture scannerCapture) {
            this.scannerCapture = scannerCapture;
            return this;
        }
        
        public Builder sourceInformation(SourceInformation sourceInformation) {
            this.sourceInformation = sourceInformation;
            return this;
        }
    }
}
