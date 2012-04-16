package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.metadata.premis.Event;

public class Representation {
    private DescriptiveMetadata source;
    private List<Event> provenance;
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

    public List<Event> getProvenance() {
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
        private List<Event> provenance = new ArrayList<Event>();
        private TechnicalMetadata technical;
        private RightsMetadata rights;
        private Set<File> files = new HashSet<File>();

        public Representation build() {
            return new Representation(this);
        }

        public Builder files(File file) {
            this.files.add(file);
            return this;
        }

        public Builder provenance(Event event) {
            this.provenance.add(event);
            return this;
        }

        public Builder provenance(List<Event> events) {
            this.provenance.addAll(events);
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
