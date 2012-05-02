package eu.scapeproject.model.metadata.mix;

public class SpacialMetrics {
    private SamplingFrequencyPane samplingFrequencyPane;
    private SamplingFrequencyUnit samplingFrequencyUnit;
    private double xSamplingFrequency;
    private double ySamplingFrequency;

    public SpacialMetrics(SamplingFrequencyPane samplingFrequencyPane, SamplingFrequencyUnit samplingFrequencyUnit, double xSamplingFrequency,
            double ySamplingFrequency) {
        super();
        this.samplingFrequencyPane = samplingFrequencyPane;
        this.samplingFrequencyUnit = samplingFrequencyUnit;
        this.xSamplingFrequency = xSamplingFrequency;
        this.ySamplingFrequency = ySamplingFrequency;
    }

    public SamplingFrequencyPane getSamplingFrequencyPane() {
        return samplingFrequencyPane;
    }

    public SamplingFrequencyUnit getSamplingFrequencyUnit() {
        return samplingFrequencyUnit;
    }

    public double getxSamplingFrequency() {
        return xSamplingFrequency;
    }

    public double getySamplingFrequency() {
        return ySamplingFrequency;
    }

    public enum SamplingFrequencyPane {
        DEVICE_FOCAL_PLANE, OBJECT_PLANE, SOURCE_OBJECT_PLANE;
    }

    public enum SamplingFrequencyUnit {
        NO_UNIT, INCH, CENTIMETERS;
    }
}
