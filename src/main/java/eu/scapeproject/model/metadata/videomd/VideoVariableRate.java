package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rate", namespace = "http://www.loc.gov/videoMD/")
public class VideoVariableRate {
    @XmlElement(name = "maximum", namespace = "http://www.loc.gov/videoMD/")
    private float maximum;
    @XmlElement(name = "minimum", namespace = "http://www.loc.gov/videoMD/")
    private float minimum;
    @XmlElement(name = "nominal", namespace = "http://www.loc.gov/videoMD/")
    private float nominal;
    @XmlElement(name = "mode", namespace = "http://www.loc.gov/videoMD/")
    private String mode;
    @XmlElement(name = "unit", namespace = "http://www.loc.gov/videoMD/")
    private String unit;

    private VideoVariableRate() {
        super();
    }

    private VideoVariableRate(Builder builder) {
        this.maximum = builder.maximum;
        this.minimum = builder.minimum;
        this.nominal = builder.nominal;
        this.mode = builder.mode;
        this.unit = builder.unit;
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
