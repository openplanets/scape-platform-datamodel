package eu.scapeproject.model.metadata.mix;

public class ImageAssessmentMetadata {
    private SpacialMetrics spacialMetrics;
    private ImageColorEncoding imageColorEncoding;
    private TargetData targetData;
    
    @SuppressWarnings("unused")
    private ImageAssessmentMetadata(){
        super();
    }

    public ImageAssessmentMetadata(SpacialMetrics spacialMetrics, ImageColorEncoding imageColorEncoding, TargetData targetData) {
        super();
        this.spacialMetrics = spacialMetrics;
        this.imageColorEncoding = imageColorEncoding;
        this.targetData = targetData;
    }

    public ImageColorEncoding getImageColorEncoding() {
        return imageColorEncoding;
    }

    public SpacialMetrics getSpacialMetrics() {
        return spacialMetrics;
    }

    public TargetData getTargetData() {
        return targetData;
    }

}
