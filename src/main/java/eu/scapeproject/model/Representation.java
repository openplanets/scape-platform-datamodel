package eu.scapeproject.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;

public class Representation {
    private DescriptiveMetadata source;
    private ProvenanceMetadata provenance;
    private TechnicalMetadata technical;
    private RightsMetadata rights;
    private Set<File> files;

    private Representation() {
        super();
    }

    private Representation(Builder builder) {
        this.source = builder.source;
        this.provenance = builder.provenance;
        this.technical = builder.technical;
        this.rights = builder.rights;
        this.files = builder.files;
    }

    public Set<File> getFiles() {
        return files;
    }

    public ProvenanceMetadata getProvenance() {
        return provenance;
    }

    public RightsMetadata getRights() {
        return rights;
    }

    public DescriptiveMetadata getSource() {
        return source;
    }

    public TechnicalMetadata getTechnical() {
        return technical;
    }

    public static class Builder {
        private DescriptiveMetadata source;
        private ProvenanceMetadata provenance;
        private TechnicalMetadata technical;
        private RightsMetadata rights;
        private Set<File> files = new HashSet<File>();

        public Representation build() {
            return new Representation(this);
        }

        public Builder file(File file) {
            this.files.add(file);
            return this;
        }

        public Builder files(List<File> files) {
            this.files.addAll(files);
            return this;
        }

        public Builder provenance(ProvenanceMetadata provenance) {
            this.provenance=provenance;
            return this;
        }

        public Builder rights(RightsMetadata rights) {
            this.rights = rights;
            return this;
        }

        public Builder source(DescriptiveMetadata source) {
            this.source = source;
            return this;
        }

        public Builder technical(TechnicalMetadata technical) {
            this.technical = technical;
            return this;
        }
    }
}
