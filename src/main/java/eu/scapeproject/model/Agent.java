package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agent",namespace="http://www.loc.gov/standards/premis")
public class Agent {
    @XmlElement(name = "name",namespace="http://www.loc.gov/standards/premis")
    private String name;
    @XmlElement(name = "note",namespace="http://www.loc.gov/standards/premis")
    private String note;
    @XmlAttribute(name = "role",namespace="http://www.loc.gov/standards/premis")
    private String role;
    @XmlAttribute(name = "type",namespace="http://www.loc.gov/standards/premis")
    private String type;
    @XmlAttribute(name = "otherrole",namespace="http://www.loc.gov/standards/premis")
    private String otherRole;
    @XmlAttribute(name = "othertype",namespace="http://www.loc.gov/standards/premis")
    private String otherType;

    private Agent() {
        super();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    public String getNote() {
        return note;
    }

    public String getOtherRole() {
        return otherRole;
    }

    public String getOtherType() {
        return otherType;
    }

    public static class Builder {
        private String name;
        private String note;
        private String role;
        private String type;
        private String otherRole;
        private String otherType;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder otherRole(String otherRole) {
            this.otherRole = otherRole;
            return this;
        }

        public Builder otherType(String otherType) {
            this.otherType = otherType;
            return this;
        }

        public Agent build() {
            return new Agent(this);
        }
    }

    private Agent(Builder builder) {
        this.name = builder.name;
        this.note = builder.note;
        this.role = builder.role;
        this.type = builder.type;
        this.otherRole = builder.otherRole;
        this.otherType = builder.otherType;
    }
}
