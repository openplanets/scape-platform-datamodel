package eu.scapeproject.model;

import java.util.List;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

public class IntellectualEntity {
    private Identifier identifier;
    private List<Identifier> alternativeIdentifiers;
    private DescriptiveMetadata descriptive;
    private List<Representation> representations;

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
