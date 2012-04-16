package eu.scapeproject.model.metadata;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import eu.scapeproject.model.Agent;

public class DescriptiveMetadata {
    private List<Date> dates;
    private List<String> titles;
    private List<Agent> creators;
    private List<String> coverages;
    private List<String> descriptions;
    private List<String> formats;
    private List<String> languages;
    private List<String> publishers;
    private List<String> subjects;
    private List<String> types;
    private List<String> sourcess;
    private List<String> relations;
    private List<Agent> constributors;
    private List<String> rights;

    private DescriptiveMetadata() {
        // private default constructor for JAX-B
        super();
    }

    private DescriptiveMetadata(Builder builder) {
        this.dates = builder.dates;
        this.titles = builder.titles;
        this.creators = builder.creators;
        this.coverages = builder.coverages;
        this.descriptions = builder.descriptions;
        this.formats = builder.formats;
        this.languages = builder.languages;
        this.publishers = builder.publishers;
        this.subjects = builder.subjects;
        this.types = builder.types;
        this.sourcess = builder.sources;
        this.relations = builder.relations;
        this.constributors = builder.constributors;
        this.rights = builder.rights;
    }

    public List<Agent> getConstributors() {
        return constributors;
    }

    public List<String> getCoverage() {
        return coverages;
    }

    public List<Agent> getCreator() {
        return creators;
    }

    public List<Date> getDate() {
        return dates;
    }

    public List<String> getDescription() {
        return descriptions;
    }

    public List<String> getFormat() {
        return formats;
    }

    public List<String> getLanguage() {
        return languages;
    }

    public List<String> getPublisher() {
        return publishers;
    }

    public List<String> getRelations() {
        return relations;
    }

    public List<String> getRights() {
        return rights;
    }

    public List<String> getSources() {
        return sourcess;
    }

    public List<String> getSubject() {
        return subjects;
    }

    public List<String> getTitle() {
        return titles;
    }

    public List<String> getType() {
        return types;
    }

    public static class Builder {
        private List<Date> dates = new ArrayList<Date>();
        private List<String> titles = new ArrayList<String>();
        private List<Agent> creators = new ArrayList<Agent>();
        private List<String> coverages = new ArrayList<String>();;
        private List<String> descriptions = new ArrayList<String>();;
        private List<String> formats = new ArrayList<String>();;
        private List<String> languages = new ArrayList<String>();;
        private List<String> publishers = new ArrayList<String>();;
        private List<String> subjects = new ArrayList<String>();;
        private List<String> types = new ArrayList<String>();;
        private List<String> sources = new ArrayList<String>();;
        private List<String> relations = new ArrayList<String>();;
        private List<Agent> constributors = new ArrayList<Agent>();;
        private List<String> rights = new ArrayList<String>();;

        public DescriptiveMetadata build() {
            return new DescriptiveMetadata(this);
        }

        public Builder constributor(Agent constributor) {
            this.constributors.add(constributor);
            return this;
        }

        public Builder coverage(String coverage) {
            this.coverages.add(coverage);
            return this;
        }

        public Builder creator(Agent creator) {
            this.creators.add(creator);
            return this;
        }

        public Builder date(Date date) {
            this.dates.add(date);
            return this;
        }

        public Builder description(String description) {
            this.descriptions.add(description);
            return this;
        }

        public Builder format(String format) {
            this.formats.add(format);
            return this;
        }

        public Builder language(String language) {
            this.languages.add(language);
            return this;
        }

        public Builder publisher(String publisher) {
            this.publishers.add(publisher);
            return this;
        }

        public Builder relations(String relations) {
            this.relations.add(relations);
            return this;
        }

        public Builder rights(String rights) {
            this.rights.add(rights);
            return this;
        }

        public Builder sources(String sources) {
            this.sources.add(sources);
            return this;
        }

        public Builder subject(String subject) {
            this.subjects.add(subject);
            return this;
        }

        public Builder title(String title) {
            this.titles.add(title);
            return this;
        }

        public Builder type(String type) {
            this.types.add(type);
            return this;
        }
    }
}
