package eu.scapeproject.model.metadata.mix;

import java.util.List;

import eu.scapeproject.model.Identifier;

public class SourceInformation {
    private String sourceType;
    private List<? extends Identifier> sourceIdentifiers;
    private double sourceXDimension;
    private SourceDimension sourceXDiemnsionUnit;
    private double sourceYDimension;
    private SourceDimension sourceYDiemnsionUnit;
    private double sourceZDimension;
    private SourceDimension sourceZDiemnsionUnit;

    private SourceInformation(){
        super();
    }
    
    private SourceInformation(Builder builder) {
        this.sourceType = builder.sourceType;
        this.sourceIdentifiers = builder.sourceIdentifiers;
        this.sourceXDimension = builder.sourceXDimension;
        this.sourceXDiemnsionUnit = builder.sourceXDiemnsionUnit;
        this.sourceYDimension = builder.sourceYDimension;
        this.sourceYDiemnsionUnit = builder.sourceYDiemnsionUnit;
        this.sourceZDimension = builder.sourceZDimension;
        this.sourceZDiemnsionUnit = builder.sourceZDiemnsionUnit;
    }

    public List<? extends Identifier> getSourceIdentifiers() {
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
        return sourceZDiemnsionUnit;
    }

    public double getSourceZDimension() {
        return sourceZDimension;
    }

    public static class Builder {
        private String sourceType;
        private List<? extends Identifier> sourceIdentifiers;
        private double sourceXDimension;
        private SourceDimension sourceXDiemnsionUnit;
        private double sourceYDimension;
        private SourceDimension sourceYDiemnsionUnit;
        private double sourceZDimension;
        private SourceDimension sourceZDiemnsionUnit;

        public SourceInformation build() {
            return new SourceInformation(this);
        }

        public Builder sourceIdentifiers(List<? extends Identifier> sourceIdentifiers) {
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
