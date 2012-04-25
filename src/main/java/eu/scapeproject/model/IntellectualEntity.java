package eu.scapeproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

public class IntellectualEntity {
    private Identifier identifier;
    private DescriptiveMetadata descriptive;
    private Set<Representation> representations;

    private IntellectualEntity() {
        super();
    }

    public IntellectualEntity(Identifier identifier, DescriptiveMetadata descriptive, Set<Representation> representations) {
        super();
        this.identifier = identifier;
        this.descriptive = descriptive;
        this.representations = representations;
    }

    public DescriptiveMetadata getDescriptive() {
        return descriptive;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Set<Representation> getRepresentations() {
        return representations;
    }
}
