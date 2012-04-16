package eu.scapeproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

public class Entity {
    private Identifier identifier;
    private DescriptiveMetadata descriptive;
    private Set<Representation> representations;

    private Entity() {
        super();
    }

    private Entity(Builder builder) {
        this.identifier = builder.identifier;
        this.descriptive = builder.descriptive;
        this.representations = builder.representations;
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

    public static class Builder {
        private Identifier identifier;
        private DescriptiveMetadata descriptive;
        private Set<Representation> representations=new HashSet<Representation>();

        public Entity build() {
            return new Entity(this);
        }

        public Builder descriptive(DescriptiveMetadata descriptive) {
            this.descriptive = descriptive;
            return this;
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder representation(Representation representation) {
            this.representations.add(representation);
            return this;
        }
        public Builder representations(List<Representation> representations) {
            this.representations.addAll(representations);
            return this;
        }
    }
}
