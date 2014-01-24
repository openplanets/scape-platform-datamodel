package eu.scape_project.model;

import javax.xml.bind.annotation.XmlElement;

public class Identified {


    protected Identified(Identifier identifier) {
        this.identifier = identifier;
    }

    @XmlElement(name = "identifier", namespace = "http://scape-project.eu/model")
    protected final Identifier identifier;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Identified)) {
            return false;
        }

        Identified that = (Identified) o;

        if (!identifier.equals(that.identifier)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    public Identifier getIdentifier() {
        return identifier;
    }
}
