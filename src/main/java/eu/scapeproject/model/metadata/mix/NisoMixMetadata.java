package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.util.CopyUtil;

@XmlRootElement(name = "niso-mix", namespace = "http://www.loc.gov/mix/v10")
public class NisoMixMetadata extends TechnicalMetadata {
    @XmlElement(name = "basicImageInformation", namespace = "http://www.loc.gov/mix/v10")
    private final BasicImageInformation basicImageInformation;
    @XmlElement(name = "imageCaptureMetadata", namespace = "http://www.loc.gov/mix/v10")
    private final ImageCaptureMetadata imageCapture;
    @XmlElement(name = "imageAssessmentMetadata", namespace = "http://www.loc.gov/mix/v10")
    private final ImageAssessmentMetadata imageAssessmentMetadata;

    public NisoMixMetadata() {
        super(TechnicalMetadata.MetadataType.NISO_MIX);
        this.basicImageInformation=null;
        this.imageAssessmentMetadata=null;
        this.imageCapture=null;
    }

    private NisoMixMetadata(Builder builder) {
        super(MetadataType.NISO_MIX);
        PhotometricInterpretation pi = new PhotometricInterpretation.Builder()
                .colorProfile(builder.colorProfile)
                .colorSpace(builder.colorspace)
                .specialFormatCharacteristics(builder.specialFormatCharacteristics)
                .ybCbCr(builder.yCrCb)
                .referencedBlackWhite(builder.referencedBlackWhite)
                .build();
        this.basicImageInformation = new BasicImageInformation(new BasicImageCharateristics(builder.width, builder.height, pi));
        this.imageCapture = new ImageCaptureMetadata.Builder()
                .orientation(builder.orientation)
                .methodology(builder.methodology)
                .scannerCapture(builder.scannerCapture)
                .sourceInformation(builder.source)
                .generalCaptureInformation(builder.generalCaptureInformation)
                .digitalCameraCapture(builder.digitalCameraCapture)
                .build();
        this.imageAssessmentMetadata = new ImageAssessmentMetadata(builder.spacialMetrics, builder.imageColorEncoding, builder.targetData);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NisoMixMetadata other = (NisoMixMetadata) obj;
        if (basicImageInformation == null) {
            if (other.basicImageInformation != null)
                return false;
        } else if (!basicImageInformation.equals(other.basicImageInformation))
            return false;
        if (imageAssessmentMetadata == null) {
            if (other.imageAssessmentMetadata != null)
                return false;
        } else if (!imageAssessmentMetadata.equals(other.imageAssessmentMetadata))
            return false;
        if (imageCapture == null) {
            if (other.imageCapture != null)
                return false;
        } else if (!imageCapture.equals(other.imageCapture))
            return false;
        return true;
    }

    public BasicImageInformation getBasicImageInformation() {
        return basicImageInformation;
    }

    public ImageAssessmentMetadata getImageAssessmentMetadata() {
        return imageAssessmentMetadata;
    }

    public ImageCaptureMetadata getImageCapture() {
        return imageCapture;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((basicImageInformation == null) ? 0 : basicImageInformation.hashCode());
        result = prime * result + ((imageAssessmentMetadata == null) ? 0 : imageAssessmentMetadata.hashCode());
        result = prime * result + ((imageCapture == null) ? 0 : imageCapture.hashCode());
        return result;
    }

    public static class Builder {
        private int width;
        private int height;
        private Orientation orientation;
        private String methodology;
        private String colorspace;
        private ColorProfile colorProfile;
        private YCbCr yCrCb;
        private ReferenceBlackWhite referencedBlackWhite;
        private SpecialFormatCharacteristics specialFormatCharacteristics;
        private SourceInformation source;
        private GeneralCaptureInformation generalCaptureInformation;
        private ScannerCapture scannerCapture;
        private DigitalCameraCapture digitalCameraCapture;
        private SpacialMetrics spacialMetrics;
        private ImageColorEncoding imageColorEncoding;
        private TargetData targetData;

        public Builder(){
        	super();
        }
        
        public Builder(NisoMixMetadata orig) {
			orig=CopyUtil.deepCopy(NisoMixMetadata.class, orig);
        	this.width = orig.getBasicImageInformation().getBasicImageCharacteristics().getWidth();
        	this.height = orig.getBasicImageInformation().getBasicImageCharacteristics().getHeight();
        	this.orientation = orig.getImageCapture().getOrientation();
        	this.methodology = orig.getImageCapture().getMethodology();
        	this.colorspace = orig.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getColorSpace();
        	this.colorProfile = orig.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getColorProfile();
        	this.yCrCb = orig.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getYbCbCr();
        	this.referencedBlackWhite = orig.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getReferencedBlackWhite();
        	this.specialFormatCharacteristics = orig.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getSpecialFormatCharacteristics();
        	this.source = orig.getImageCapture().getSourceInformation();
        	this.generalCaptureInformation = orig.getImageCapture().getGeneralCaptureInformation();
        	this.scannerCapture = orig.getImageCapture().getScannerCapture();
        	this.digitalCameraCapture = orig.getImageCapture().getDigitalCameraCapture();
        	this.spacialMetrics = orig.getImageAssessmentMetadata().getSpacialMetrics();
        	this.imageColorEncoding = orig.getImageAssessmentMetadata().getImageColorEncoding();
        	this.targetData = orig.getImageAssessmentMetadata().getTargetData();
        }

		public NisoMixMetadata build() {
            return new NisoMixMetadata(this);
        }

        public Builder colorProfile(ColorProfile colorProfile) {
            this.colorProfile = colorProfile;
            return this;
        }

        public Builder colorspace(String colorspace) {
            this.colorspace = colorspace;
            return this;
        }

        public Builder digitalCameraCapture(DigitalCameraCapture digitalCameraCapture) {
            this.digitalCameraCapture = digitalCameraCapture;
            return this;
        }

        public Builder generalCaptureInformation(GeneralCaptureInformation generalCaptureInformation) {
            this.generalCaptureInformation = generalCaptureInformation;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder imageColorEncoding(ImageColorEncoding imageColorEncoding) {
            this.imageColorEncoding = imageColorEncoding;
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

        public Builder referencedBlackWhite(ReferenceBlackWhite referencedBlackWhite) {
            this.referencedBlackWhite = referencedBlackWhite;
            return this;
        }

        public Builder scannerCapture(ScannerCapture scannerCapture) {
            this.scannerCapture = scannerCapture;
            return this;
        }

        public Builder source(SourceInformation source) {
            this.source = source;
            return this;
        }

        public Builder spacialMetrics(SpacialMetrics spacialMetrics) {
            this.spacialMetrics = spacialMetrics;
            return this;
        }

        public Builder specialFormatCharacteristics(SpecialFormatCharacteristics specialFormatCharacteristics) {
            this.specialFormatCharacteristics = specialFormatCharacteristics;
            return this;
        }

        public Builder targetData(TargetData targetData) {
            this.targetData = targetData;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder yCrCb(YCbCr yCrCb) {
            this.yCrCb = yCrCb;
            return this;
        }
    }

    public enum Orientation {
        NORMAL, NORMAL_FLIPPED, NORMAL_ROTATED_180, NORMAL_FLIPPED_ROTATED_180, NORMAL_FLIPPED_ROTATED_CW90, NORMAL_ROTATED_CCW90, NORMAL_FLIPPED_ROTATED_CCW90, NORMAL_ROTATED_CW90, UNKNOWN;

        public static Orientation fromValue(int value) {
            switch (value) {
            case 1:
                return NORMAL;
            case 2:
                return NORMAL_FLIPPED;
            case 3:
                return NORMAL_ROTATED_180;
            case 4:
                return NORMAL_FLIPPED_ROTATED_180;
            case 5:
                return NORMAL_FLIPPED_ROTATED_CW90;
            case 6:
                return NORMAL_ROTATED_CCW90;
            case 7:
                return NORMAL_FLIPPED_ROTATED_CCW90;
            case 8:
                return NORMAL_ROTATED_CW90;
            case 9:
                return UNKNOWN;
            default:
                return null;
            }
        }
    }
}
