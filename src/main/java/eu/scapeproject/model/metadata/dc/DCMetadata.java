package eu.scapeproject.model.metadata.dc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Agent;
import eu.scapeproject.model.jaxb.DateAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;

@XmlRootElement(name="dublin-core")
public class DCMetadata extends DescriptiveMetadata {
    @XmlElement(name="date",namespace="http://purl.org/dc/elements/1.1/")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private List<Date> dates;
    @XmlElement(name="title",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> titles;
    @XmlElement(name="creator",namespace="http://purl.org/dc/elements/1.1/")
    private List<Agent> creators;
    @XmlElement(name="coverage",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> coverages;
    @XmlElement(name="description",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> descriptions;
    @XmlElement(name="format",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> formats;
    @XmlElement(name="language",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> languages;
    @XmlElement(name="publisher",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> publishers;
    @XmlElement(name="subject",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> subjects;
    @XmlElement(name="type",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> types;
    @XmlElement(name="source",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> sources;
    @XmlElement(name="relation",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> relations;
    @XmlElement(name="contributor",namespace="http://purl.org/dc/elements/1.1/")
    private List<Agent> contributors;
    @XmlElement(name="rights",namespace="http://purl.org/dc/elements/1.1/")
    private List<String> rights;

    private DCMetadata() {
        super();
    }

    private DCMetadata(Builder builder) {
        this();
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
        this.sources = builder.sources;
        this.relations = builder.relations;
        this.contributors = builder.constributors;
        this.rights = builder.rights;
    }

    public List<Agent> getConstributors() {
        return contributors;
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
        return sources;
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((contributors == null) ? 0 : contributors.hashCode());
        result = prime * result + ((coverages == null) ? 0 : coverages.hashCode());
        result = prime * result + ((creators == null) ? 0 : creators.hashCode());
        result = prime * result + ((dates == null) ? 0 : dates.hashCode());
        result = prime * result + ((descriptions == null) ? 0 : descriptions.hashCode());
        result = prime * result + ((formats == null) ? 0 : formats.hashCode());
        result = prime * result + ((languages == null) ? 0 : languages.hashCode());
        result = prime * result + ((publishers == null) ? 0 : publishers.hashCode());
        result = prime * result + ((relations == null) ? 0 : relations.hashCode());
        result = prime * result + ((rights == null) ? 0 : rights.hashCode());
        result = prime * result + ((sources == null) ? 0 : sources.hashCode());
        result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
        result = prime * result + ((titles == null) ? 0 : titles.hashCode());
        result = prime * result + ((types == null) ? 0 : types.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DCMetadata other = (DCMetadata) obj;
        if (contributors == null) {
            if (other.contributors != null)
                return false;
        } else if (!contributors.equals(other.contributors))
            return false;
        if (coverages == null) {
            if (other.coverages != null)
                return false;
        } else if (!coverages.equals(other.coverages))
            return false;
        if (creators == null) {
            if (other.creators != null)
                return false;
        } else if (!creators.equals(other.creators))
            return false;
        if (dates == null) {
            if (other.dates != null)
                return false;
        } else if (!dates.equals(other.dates))
            return false;
        if (descriptions == null) {
            if (other.descriptions != null)
                return false;
        } else if (!descriptions.equals(other.descriptions))
            return false;
        if (formats == null) {
            if (other.formats != null)
                return false;
        } else if (!formats.equals(other.formats))
            return false;
        if (languages == null) {
            if (other.languages != null)
                return false;
        } else if (!languages.equals(other.languages))
            return false;
        if (publishers == null) {
            if (other.publishers != null)
                return false;
        } else if (!publishers.equals(other.publishers))
            return false;
        if (relations == null) {
            if (other.relations != null)
                return false;
        } else if (!relations.equals(other.relations))
            return false;
        if (rights == null) {
            if (other.rights != null)
                return false;
        } else if (!rights.equals(other.rights))
            return false;
        if (sources == null) {
            if (other.sources != null)
                return false;
        } else if (!sources.equals(other.sources))
            return false;
        if (subjects == null) {
            if (other.subjects != null)
                return false;
        } else if (!subjects.equals(other.subjects))
            return false;
        if (titles == null) {
            if (other.titles != null)
                return false;
        } else if (!titles.equals(other.titles))
            return false;
        if (types == null) {
            if (other.types != null)
                return false;
        } else if (!types.equals(other.types))
            return false;
        return true;
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

        public Builder() {
        	super();
		}
        
        public Builder(DCMetadata md){
        	//TODO:deep copy
        	this.dates=md.getDate();
        	this.titles=md.getTitle();
        	this.creators=md.getCreator();
        	this.descriptions=md.getDescription();
        	this.formats=md.getFormat();
        	this.languages=md.getLanguage();
        	this.publishers=md.getPublisher();
        	this.subjects=md.getSubject();
        	this.types=md.getType();
        	this.sources=md.getSources();
        	this.relations=md.getRelations();
        	this.constributors=md.getConstributors();
        	this.rights=md.getRights();
        }
        
        public DCMetadata build() {
            return new DCMetadata(this);
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
