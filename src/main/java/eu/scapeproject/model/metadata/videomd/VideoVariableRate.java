package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate", namespace = "http://www.loc.gov/videoMD/")
public class VideoVariableRate {
    @XmlElement(name = "maximum", namespace = "http://www.loc.gov/videoMD/")
    private final float maximum;
    @XmlElement(name = "minimum", namespace = "http://www.loc.gov/videoMD/")
    private final float minimum;
    @XmlElement(name = "nominal", namespace = "http://www.loc.gov/videoMD/")
    private final float nominal;
    @XmlElement(name = "mode", namespace = "http://www.loc.gov/videoMD/")
    private final String mode;
    @XmlElement(name = "unit", namespace = "http://www.loc.gov/videoMD/")
    private final String unit;

    private VideoVariableRate() {
        super();
        this.maximum = 0;
        this.minimum = 0;
        this.nominal = 0;
        this.mode = null;
        this.unit = null;
    }

    private VideoVariableRate(Builder builder) {
        this.maximum = builder.maximum;
        this.minimum = builder.minimum;
        this.nominal = builder.nominal;
        this.mode = builder.mode;
        this.unit = builder.unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoVariableRate other = (VideoVariableRate) obj;
        if (Float.floatToIntBits(maximum) != Float.floatToIntBits(other.maximum))
            return false;
        if (Float.floatToIntBits(minimum) != Float.floatToIntBits(other.minimum))
            return false;
        if (mode == null) {
            if (other.mode != null)
                return false;
        } else if (!mode.equals(other.mode))
            return false;
        if (Float.floatToIntBits(nominal) != Float.floatToIntBits(other.nominal))
            return false;
        if (unit == null) {
            if (other.unit != null)
                return false;
        } else if (!unit.equals(other.unit))
            return false;
        return true;
    }

    public float getMaximum() {
        return maximum;
    }

    public float getMinimum() {
        return minimum;
    }

    public String getMode() {
        return mode;
    }

    public float getNominal() {
        return nominal;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(maximum);
        result = prime * result + Float.floatToIntBits(minimum);
        result = prime * result + ((mode == null) ? 0 : mode.hashCode());
        result = prime * result + Float.floatToIntBits(nominal);
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        return result;
    }



    public static class Builder {
        private float maximum;
        private float minimum;
        private float nominal;
        private String mode;
        private String unit;

        public VideoVariableRate build() {
            return new VideoVariableRate(this);
        }

        public Builder maximum(float maximum) {
            this.maximum = maximum;
            return this;
        }

        public Builder minimum(float minimum) {
            this.minimum = minimum;
            return this;
        }

        public Builder mode(String mode) {
            this.mode = mode;
            return this;
        }

        public Builder nominal(float nominal) {
            this.nominal = nominal;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }
    }
}
