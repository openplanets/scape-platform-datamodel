package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import eu.scapeproject.util.CopyUtil;

@XmlRootElement(name = "representation", namespace = "http://scapeproject.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)    
public class Representation {
    @XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
    private final Identifier identifier;
    @XmlAnyElement
    private final Object source;
    @XmlAnyElement
    private final Object provenance;
    @XmlAnyElement
    private final Object technical;
    @XmlAnyElement
    private final Object rights;
    @XmlElement(name = "files", namespace = "http://scapeproject.eu/model")
    private final List<File> files;
    @XmlElement(name = "title", namespace = "http://scapeproject.eu/model")
    private final String title;
    @XmlElement(name = "usage", namespace = "http://scapeproject.eu/model")
    private final String usage;

    private Representation() {
        super();
        this.source = null;
        this.provenance = null;
        this.technical = null;
        this.rights = null;
        this.files = null;
        this.identifier = null;
        this.title = null;
        this.usage = null;
    }

    private Representation(Builder builder) {
        this.source = builder.source;
        this.provenance = builder.provenance;
        this.technical = builder.technical;
        this.rights = builder.rights;
        this.files = builder.files;
        this.identifier = builder.id;
        this.title = builder.title;
        this.usage = builder.usage;
    }

    public List<File> getFiles() {
        return files;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Object getProvenance() {
        return provenance;
    }

    public Object getRights() {
        return rights;
    }

    public Object getSource() {
        return source;
    }

    public Object getTechnical() {
        return technical;
    }

    public String getTitle() {
        return title;
    }

    public String getUsage() {
        return usage;
    }

    @Override
    public String toString() {
        return "Representation ["
                + "identifier=" + identifier
                + ", source=" + source
                + ", provenance=" + provenance
                + ", technical=" + technical
                + ", rights=" + rights
                + ", files=" + files
                + ", title=" + title
                + ", usage=" + usage
                + "]";
    }

    public static class Builder {
        private Object source;
        private Object provenance;
        private Object technical;
        private Object rights;
        private List<File> files = new ArrayList<File>();
        private Identifier id;
        private String title;
        private String usage;

        public Builder(){
        	super();
        }
        
        public Builder(Identifier id) {
            super();
            this.id = id;
        }

        public Builder(Representation orig) {
            Representation copy = CopyUtil.deepCopy(Representation.class, orig);
            this.source = copy.source;
            this.provenance = copy.provenance;
            this.technical = copy.technical;
            this.rights = copy.rights;
            this.files = copy.files;
            this.id = copy.identifier;
            this.title = copy.title;
            this.usage = copy.usage;
        }

        public Representation build() {
            return new Representation(this);
        }

        public Builder files(List<File> files) {
            this.files = files;
            return this;
        }

        public Builder identifier(Identifier id) {
            this.id = id;
            return this;
        }

        public Builder provenance(Object provenance) {
            this.provenance = provenance;
            return this;
        }

        public Builder rights(Object rights) {
            this.rights = rights;
            return this;
        }

        public Builder source(Object source) {
            this.source = source;
            return this;
        }

        public Builder technical(Object technical) {
            this.technical = technical;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder usage(String usage) {
            this.usage = usage;
            return this;
        }
    }
}
