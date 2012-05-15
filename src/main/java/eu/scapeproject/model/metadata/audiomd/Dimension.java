package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dimension",namespace="http://www.loc.gov/AMD/")
public class Dimension {
    @XmlElement(name = "depth",namespace="http://www.loc.gov/AMD/")
    private float depth;
    @XmlElement(name = "diameter",namespace="http://www.loc.gov/AMD/")
    private float diameter;
    @XmlElement(name = "gauge",namespace="http://www.loc.gov/AMD/")
    private String gauge;
    @XmlElement(name = "height",namespace="http://www.loc.gov/AMD/")
    private float height;
    @XmlElement(name = "length",namespace="http://www.loc.gov/AMD/")
    private String length;
    @XmlElement(name = "note",namespace="http://www.loc.gov/AMD/")
    private String note;
    @XmlElement(name = "thickness",namespace="http://www.loc.gov/AMD/")
    private String thickness;
    @XmlElement(name = "units",namespace="http://www.loc.gov/AMD/")
    private String units;
    @XmlElement(name = "width",namespace="http://www.loc.gov/AMD/")
    private float width;

    private Dimension() {
        super();
    }

    private Dimension(Builder builder) {
        this.depth = builder.depth;
        this.diameter = builder.diameter;
        this.gauge = builder.gauge;
        this.height = builder.height;
        this.length = builder.length;
        this.note = builder.note;
        this.thickness = builder.thickness;
        this.units = builder.units;
        this.width = builder.width;
    }

    public float getDepth() {
        return depth;
    }

    public float getDiameter() {
        return diameter;
    }

    public String getGauge() {
        return gauge;
    }

    public float getHeight() {
        return height;
    }

    public String getLength() {
        return length;
    }

    public String getNote() {
        return note;
    }

    public String getThickness() {
        return thickness;
    }

    public String getUnits() {
        return units;
    }

    public float getWidth() {
        return width;
    }

    public static class Builder {
        private float depth;
        private float diameter;
        private String gauge;
        private float height;
        private String length;
        private String note;
        private String thickness;
        private String units;
        private float width;

        public Dimension build() {
            return new Dimension(this);
        }

        public Builder depth(float depth) {
            this.depth = depth;
            return this;
        }

        public Builder diameter(float diameter) {
            this.diameter = diameter;
            return this;
        }

        public Builder gauge(String gauge) {
            this.gauge = gauge;
            return this;
        }

        public Builder height(float height) {
            this.height = height;
            return this;
        }

        public Builder length(String length) {
            this.length = length;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder thickness(String thickness) {
            this.thickness = thickness;
            return this;
        }

        public Builder units(String units) {
            this.units = units;
            return this;
        }

        public Builder width(float width) {
            this.width = width;
            return this;
        }
    }
}
