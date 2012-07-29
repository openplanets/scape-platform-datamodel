package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dimension",namespace="http://www.loc.gov/AMD/")
public class Dimension {
    @XmlElement(name = "depth",namespace="http://www.loc.gov/AMD/")
    private final float depth;
    @XmlElement(name = "diameter",namespace="http://www.loc.gov/AMD/")
    private final float diameter;
    @XmlElement(name = "gauge",namespace="http://www.loc.gov/AMD/")
    private final String gauge;
    @XmlElement(name = "height",namespace="http://www.loc.gov/AMD/")
    private final float height;
    @XmlElement(name = "length",namespace="http://www.loc.gov/AMD/")
    private final String length;
    @XmlElement(name = "note",namespace="http://www.loc.gov/AMD/")
    private final String note;
    @XmlElement(name = "thickness",namespace="http://www.loc.gov/AMD/")
    private final String thickness;
    @XmlElement(name = "units",namespace="http://www.loc.gov/AMD/")
    private final String units;
    @XmlElement(name = "width",namespace="http://www.loc.gov/AMD/")
    private final float width;

    private Dimension() {
        super();
        this.depth=0f;
        this.diameter=0f;
        this.gauge=null;
        this.height=0f;
        this.length=null;
        this.note=null;
        this.thickness=null;
        this.units=null;
        this.width=0f;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(depth);
        result = prime * result + Float.floatToIntBits(diameter);
        result = prime * result + ((gauge == null) ? 0 : gauge.hashCode());
        result = prime * result + Float.floatToIntBits(height);
        result = prime * result + ((length == null) ? 0 : length.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((thickness == null) ? 0 : thickness.hashCode());
        result = prime * result + ((units == null) ? 0 : units.hashCode());
        result = prime * result + Float.floatToIntBits(width);
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
        Dimension other = (Dimension) obj;
        if (Float.floatToIntBits(depth) != Float.floatToIntBits(other.depth))
            return false;
        if (Float.floatToIntBits(diameter) != Float.floatToIntBits(other.diameter))
            return false;
        if (gauge == null) {
            if (other.gauge != null)
                return false;
        } else if (!gauge.equals(other.gauge))
            return false;
        if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
            return false;
        if (length == null) {
            if (other.length != null)
                return false;
        } else if (!length.equals(other.length))
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (thickness == null) {
            if (other.thickness != null)
                return false;
        } else if (!thickness.equals(other.thickness))
            return false;
        if (units == null) {
            if (other.units != null)
                return false;
        } else if (!units.equals(other.units))
            return false;
        if (Float.floatToIntBits(width) != Float.floatToIntBits(other.width))
            return false;
        return true;
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
