package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.mix.NisoMixMetadata.Orientation;

@XmlRootElement(name = "imageCaptureMetadata", namespace = "http://www.loc.gov/mix/v10")
public class ImageCaptureMetadata {
    @XmlElement(name = "sourceInformation", namespace = "http://www.loc.gov/mix/v10")
    private final SourceInformation sourceInformation;
    @XmlElement(name = "generalCaptureInformation", namespace = "http://www.loc.gov/mix/v10")
    private final GeneralCaptureInformation generalCaptureInformation;
    @XmlElement(name = "scannerCapture", namespace = "http://www.loc.gov/mix/v10")
    private final ScannerCapture scannerCapture;
    @XmlElement(name = "orientation", namespace = "http://www.loc.gov/mix/v10")
    private final Orientation orientation;
    @XmlElement(name = "methodology", namespace = "http://www.loc.gov/mix/v10")
    private final String methodology;
    @XmlElement(name = "digitalCameraCapture", namespace = "http://www.loc.gov/mix/v10")
    private final DigitalCameraCapture digitalCameraCapture;

    private ImageCaptureMetadata() {
        super();
        this.sourceInformation = null;
        this.generalCaptureInformation = null;
        this.scannerCapture = null;
        this.orientation = null;
        this.methodology = null;
        this.digitalCameraCapture = null;
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((digitalCameraCapture == null) ? 0 : digitalCameraCapture.hashCode());
        result = prime * result + ((generalCaptureInformation == null) ? 0 : generalCaptureInformation.hashCode());
        result = prime * result + ((methodology == null) ? 0 : methodology.hashCode());
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        result = prime * result + ((scannerCapture == null) ? 0 : scannerCapture.hashCode());
        result = prime * result + ((sourceInformation == null) ? 0 : sourceInformation.hashCode());
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
        ImageCaptureMetadata other = (ImageCaptureMetadata) obj;
        if (digitalCameraCapture == null) {
            if (other.digitalCameraCapture != null)
                return false;
        } else if (!digitalCameraCapture.equals(other.digitalCameraCapture))
            return false;
        if (generalCaptureInformation == null) {
            if (other.generalCaptureInformation != null)
                return false;
        } else if (!generalCaptureInformation.equals(other.generalCaptureInformation))
            return false;
        if (methodology == null) {
            if (other.methodology != null)
                return false;
        } else if (!methodology.equals(other.methodology))
            return false;
        if (orientation != other.orientation)
            return false;
        if (scannerCapture == null) {
            if (other.scannerCapture != null)
                return false;
        } else if (!scannerCapture.equals(other.scannerCapture))
            return false;
        if (sourceInformation == null) {
            if (other.sourceInformation != null)
                return false;
        } else if (!sourceInformation.equals(other.sourceInformation))
            return false;
        return true;
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
