package eu.scapeproject.model.metadata.mix;

public class ImageAssessmentMetadata {
    private SpacialMetrics spacialMetrics;
    private ImageColorEncoding imageColorEncoding;
    private TargetData targetData;
    
    private ImageAssessmentMetadata(){
        super();
    }

    public ImageAssessmentMetadata(SpacialMetrics spacialMetrics, ImageColorEncoding imageColorEncoding, TargetData targetData) {
        super();
        this.spacialMetrics = spacialMetrics;
        this.imageColorEncoding = imageColorEncoding;
        this.targetData = targetData;
    }

    public SpacialMetrics getSpacialMetrics() {
        return spacialMetrics;
    }

    public ImageColorEncoding getImageColorEncoding() {
        return imageColorEncoding;
    }

    public TargetData getTargetData() {
        return targetData;
    }

}
