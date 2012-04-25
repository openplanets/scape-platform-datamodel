package eu.scapeproject.model.metadata.mix;

public class SpacialMetrics {
    private SamplingFrequencyPane samplingFrequencyPane;
    private SamplingFrequencyUnit samplingFrequencyUnit;
    private double xSamplingFrequency;
    private double ySamplingFrequency;
    
    public enum SamplingFrequencyUnit{
        NO_UNIT,INCH,CENTIMETERS;
    }
    public enum SamplingFrequencyPane{
        DEVICE_FOCAL_PLANE,OBJECT_PLANE,SOURCE_OBJECT_PLANE;
    }
}
