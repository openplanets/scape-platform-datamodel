package eu.scapeproject.model.metadata.mix;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.jaxb.MixSourceIdentifierAdapter;

@XmlRootElement(name="sourceInformation",namespace="http://www.loc.gov/mix/v10")
public class SourceInformation {
    @XmlElement(name="sourceType",namespace="http://www.loc.gov/mix/v10")
    private final String sourceType;
    @XmlElement(name="sourceIdentifiers",namespace="http://www.loc.gov/mix/v10")
    @XmlJavaTypeAdapter(MixSourceIdentifierAdapter.class)
    private final List<Identifier> sourceIdentifiers;
    @XmlElement(name="sourceXDimension",namespace="http://www.loc.gov/mix/v10")
    private final double sourceXDimension;
    @XmlElement(name="sourceXDiemnsionUnit",namespace="http://www.loc.gov/mix/v10")
    private final SourceDimension sourceXDiemnsionUnit;
    @XmlElement(name="sourceYDimension",namespace="http://www.loc.gov/mix/v10")
    private final double sourceYDimension;
    @XmlElement(name="sourceYDiemnsionUnit",namespace="http://www.loc.gov/mix/v10")
    private final SourceDimension sourceYDiemnsionUnit;
    @XmlElement(name="sourceZDimension",namespace="http://www.loc.gov/mix/v10")
    private final double sourceZDimension;
    @XmlElement(name="sourceZDimensionUnit",namespace="http://www.loc.gov/mix/v10")
    private final SourceDimension sourceZDimensionUnit;

    private SourceInformation(){
        super();
        this.sourceType = null;
        this.sourceIdentifiers = null;
        this.sourceXDimension = 0;
        this.sourceXDiemnsionUnit = null;
        this.sourceYDimension = 0;
        this.sourceYDiemnsionUnit = null;
        this.sourceZDimension = 0;
        this.sourceZDimensionUnit = null;
    }
    
    private SourceInformation(Builder builder) {
        this.sourceType = builder.sourceType;
        this.sourceIdentifiers = builder.sourceIdentifiers;
        this.sourceXDimension = builder.sourceXDimension;
        this.sourceXDiemnsionUnit = builder.sourceXDiemnsionUnit;
        this.sourceYDimension = builder.sourceYDimension;
        this.sourceYDiemnsionUnit = builder.sourceYDiemnsionUnit;
        this.sourceZDimension = builder.sourceZDimension;
        this.sourceZDimensionUnit = builder.sourceZDiemnsionUnit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SourceInformation other = (SourceInformation) obj;
        if (sourceIdentifiers == null) {
            if (other.sourceIdentifiers != null)
                return false;
        } else if (!sourceIdentifiers.equals(other.sourceIdentifiers))
            return false;
        if (sourceType == null) {
            if (other.sourceType != null)
                return false;
        } else if (!sourceType.equals(other.sourceType))
            return false;
        if (sourceXDiemnsionUnit != other.sourceXDiemnsionUnit)
            return false;
        if (Double.doubleToLongBits(sourceXDimension) != Double.doubleToLongBits(other.sourceXDimension))
            return false;
        if (sourceYDiemnsionUnit != other.sourceYDiemnsionUnit)
            return false;
        if (Double.doubleToLongBits(sourceYDimension) != Double.doubleToLongBits(other.sourceYDimension))
            return false;
        if (sourceZDimensionUnit != other.sourceZDimensionUnit)
            return false;
        if (Double.doubleToLongBits(sourceZDimension) != Double.doubleToLongBits(other.sourceZDimension))
            return false;
        return true;
    }

    public List<Identifier> getSourceIdentifiers() {
        return sourceIdentifiers;
    }

    public String getSourceType() {
        return sourceType;
    }

    public SourceDimension getSourceXDiemnsionUnit() {
        return sourceXDiemnsionUnit;
    }

    public double getSourceXDimension() {
        return sourceXDimension;
    }

    public SourceDimension getSourceYDiemnsionUnit() {
        return sourceYDiemnsionUnit;
    }

    public double getSourceYDimension() {
        return sourceYDimension;
    }

    public SourceDimension getSourceZDiemnsionUnit() {
        return sourceZDimensionUnit;
    }

    
    public double getSourceZDimension() {
        return sourceZDimension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sourceIdentifiers == null) ? 0 : sourceIdentifiers.hashCode());
        result = prime * result + ((sourceType == null) ? 0 : sourceType.hashCode());
        result = prime * result + ((sourceXDiemnsionUnit == null) ? 0 : sourceXDiemnsionUnit.hashCode());
        long temp;
        temp = Double.doubleToLongBits(sourceXDimension);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((sourceYDiemnsionUnit == null) ? 0 : sourceYDiemnsionUnit.hashCode());
        temp = Double.doubleToLongBits(sourceYDimension);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((sourceZDimensionUnit == null) ? 0 : sourceZDimensionUnit.hashCode());
        temp = Double.doubleToLongBits(sourceZDimension);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    public static class Builder {
        private String sourceType;
        private List<Identifier> sourceIdentifiers;
        private double sourceXDimension;
        private SourceDimension sourceXDiemnsionUnit;
        private double sourceYDimension;
        private SourceDimension sourceYDiemnsionUnit;
        private double sourceZDimension;
        private SourceDimension sourceZDiemnsionUnit;

        public SourceInformation build() {
            return new SourceInformation(this);
        }

        public Builder sourceIdentifiers(List<Identifier> sourceIdentifiers) {
            this.sourceIdentifiers = sourceIdentifiers;
            return this;
        }

        public Builder sourceType(String sourceType) {
            this.sourceType = sourceType;
            return this;
        }

        public Builder sourceXDiemnsionUnit(SourceDimension sourceXDiemnsionUnit) {
            this.sourceXDiemnsionUnit = sourceXDiemnsionUnit;
            return this;
        }

        public Builder sourceXDimension(double sourceXDimension) {
            this.sourceXDimension = sourceXDimension;
            return this;
        }

        public Builder sourceYDiemnsionUnit(SourceDimension sourceYDiemnsionUnit) {
            this.sourceYDiemnsionUnit = sourceYDiemnsionUnit;
            return this;
        }

        public Builder sourceYDimension(double sourceYDimension) {
            this.sourceYDimension = sourceYDimension;
            return this;
        }

        public Builder sourceZDiemnsionUnit(SourceDimension sourceZDiemnsionUnit) {
            this.sourceZDiemnsionUnit = sourceZDiemnsionUnit;
            return this;
        }

        public Builder sourceZDimension(double sourceZDimension) {
            this.sourceZDimension = sourceZDimension;
            return this;
        }
    }
    public enum SourceDimension{
        METERS,MILLIMETERS,CENTIMETERS;
    }
}
