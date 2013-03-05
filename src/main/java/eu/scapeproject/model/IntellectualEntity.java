package eu.scapeproject.model;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "entity", namespace = "http://scapeproject.eu/model")
public class IntellectualEntity {

    private final Identifier identifier;
    private final int versionNumber;
    private final List<Identifier> alternativeIdentifiers;
    private final Object descriptive;
    private final List<Representation> representations;
    private final LifecycleState lifeCycleState;

    @SuppressWarnings("unused")
    private IntellectualEntity() {
        super();
        this.identifier = null;
        this.alternativeIdentifiers = null;
        this.descriptive = null;
        this.representations = null;
        this.lifeCycleState = null;
        this.versionNumber = 1;
    }

    public IntellectualEntity(Builder builder) {
        this.identifier = builder.identifier;
        this.alternativeIdentifiers = builder.alternativeIdentifiers;
        this.descriptive = builder.descriptive;
        this.representations = builder.representations;
        this.lifeCycleState = builder.lifecycleState;
        this.versionNumber = builder.versionNumber;
    }


    public List<Identifier> getAlternativeIdentifiers() {
        return alternativeIdentifiers;
    }

    public Object getDescriptive() {
        return descriptive;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public LifecycleState getLifecycleState() {
        return lifeCycleState;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    @Override
    public String toString() {
        return "IntellectualEntity [identifier=" + identifier
                + ", versionNumber=" + versionNumber
                + ", alternativeIdentifiers=" + alternativeIdentifiers
                + ", descriptive=" + descriptive
                + ", representations=" + representations
                + ", lifeCycleState=" + lifeCycleState
                + "]";
    }

    public static class Builder {
        private Identifier identifier;
        private int versionNumber;
        private List<Identifier> alternativeIdentifiers;
        private Object descriptive;
        private List<Representation> representations;
        private LifecycleState lifecycleState;

        public Builder() {
            super();
        }

        public Builder alternativeIdentifiers(List<Identifier> alternativeIdentifiers) {
            this.alternativeIdentifiers = alternativeIdentifiers;
            return this;
        }

        public IntellectualEntity build() {
            versionNumber = (versionNumber == 0) ? 1 : versionNumber;
            return new IntellectualEntity(this);
        }

        public Builder descriptive(Object descriptive) {
            this.descriptive = descriptive;
            return this;
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder lifecycleState(LifecycleState state) {
            this.lifecycleState = state;
            return this;
        }

        public Builder representations(List<Representation> representations) {
            this.representations = representations;
            return this;
        }

        public Builder versionNumber(int versionNumber) {
            this.versionNumber = versionNumber;
            return this;
        }

    }

}