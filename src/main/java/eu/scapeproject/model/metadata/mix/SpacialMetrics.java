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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((samplingFrequencyPane == null) ? 0 : samplingFrequencyPane.hashCode());
        result = prime * result + ((samplingFrequencyUnit == null) ? 0 : samplingFrequencyUnit.hashCode());
        long temp;
        temp = Double.doubleToLongBits(xSamplingFrequency);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ySamplingFrequency);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        SpacialMetrics other = (SpacialMetrics) obj;
        if (samplingFrequencyPane != other.samplingFrequencyPane)
            return false;
        if (samplingFrequencyUnit != other.samplingFrequencyUnit)
            return false;
        if (Double.doubleToLongBits(xSamplingFrequency) != Double.doubleToLongBits(other.xSamplingFrequency))
            return false;
        if (Double.doubleToLongBits(ySamplingFrequency) != Double.doubleToLongBits(other.ySamplingFrequency))
            return false;
        return true;
    }

    public enum SamplingFrequencyPane {
        DEVICE_FOCAL_PLANE, OBJECT_PLANE, SOURCE_OBJECT_PLANE;
    }

    public enum SamplingFrequencyUnit {
        NO_UNIT, INCH, CENTIMETERS;
    }
}
