package eu.scapeproject.model;

import java.util.List;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

public class IntellectualEntity {

    public enum LifeCycleState {
        INGEST, INGESTED, PROCESSING, DELETED;
    }

    private Identifier identifier;
    private List<Identifier> alternativeIdentifiers;
    private DescriptiveMetadata descriptive;
    private List<Representation> representations;
    private LifeCycleState lifeCycleState;

    @SuppressWarnings("unused")
    private IntellectualEntity() {
        super();
    }

    public IntellectualEntity(Identifier identifier, List<Identifier> alternativeIdentifers, DescriptiveMetadata descriptive,
            List<Representation> representations) {
        super();
        this.identifier = identifier;
        this.descriptive = descriptive;
        this.representations = representations;
        this.alternativeIdentifiers = alternativeIdentifers;
    }

    public void setLifeCycleState(LifeCycleState lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    public LifeCycleState getLifeCycleState() {
        return lifeCycleState;
    }

    public List<Identifier> getAlternativeIdentifiers() {
        return alternativeIdentifiers;
    }

    public DescriptiveMetadata getDescriptive() {
        return descriptive;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }
}
