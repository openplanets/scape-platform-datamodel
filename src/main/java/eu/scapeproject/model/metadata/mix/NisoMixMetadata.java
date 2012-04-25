package eu.scapeproject.model.metadata.mix;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.metadata.TechnicalMetadata;

public class NisoMixMetadata extends TechnicalMetadata {

    private int width;

    private int height;
    private Orientation orientation;
    private String methodology;
    private String colorspace;
    private ColorProfile colorProfile;
    private YCbCr yCrCb;
    private ReferencedBlackWhite referencedBlackWhite;
    private SpecialFormatCharacteristics specialFormatCharacteristics;
    private ImageSource source;
    private GeneralCaptureInformation generalCaptureInformation;
    private ScannerCapture scannerCapture;
    private DigitalCameraCapture digitalCameraCapture;
    private SpacialMetrics spacialMetrics;
    private ImageColorEncoding imageColorEncoding;
    private TargetData targetData;

    public NisoMixMetadata() {
        super(TechnicalMetadata.Type.NISO_MIX);
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
