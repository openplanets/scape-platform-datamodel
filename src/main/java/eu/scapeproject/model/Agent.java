package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "agent",namespace="http://www.loc.gov/standards/premis")
public class Agent {
    @XmlElement(name = "name",namespace="http://www.loc.gov/standards/premis")
    private final String name;
    @XmlElement(name = "note",namespace="http://www.loc.gov/standards/premis")
    private final String note;
    @XmlAttribute(name = "role",namespace="http://www.loc.gov/standards/premis")
    private final String role;
    @XmlAttribute(name = "type",namespace="http://www.loc.gov/standards/premis")
    private final String type;
    @XmlAttribute(name = "otherrole",namespace="http://www.loc.gov/standards/premis")
    private final String otherRole;
    @XmlAttribute(name = "othertype",namespace="http://www.loc.gov/standards/premis")
    private final String otherType;

    private Agent() {
        super();
        this.name=null;
        this.note=null;
        this.role=null;
        this.type=null;
        this.otherRole=null;
        this.otherType=null;
    }

    private Agent(Builder builder) {
        this.name = builder.name;
        this.note = builder.note;
        this.role = builder.role;
        this.type = builder.type;
        this.otherRole = builder.otherRole;
        this.otherType = builder.otherType;
    }

    public String getName() {
        return name;
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

    public String getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((otherRole == null) ? 0 : otherRole.hashCode());
        result = prime * result + ((otherType == null) ? 0 : otherType.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Agent other = (Agent) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (otherRole == null) {
            if (other.otherRole != null)
                return false;
        } else if (!otherRole.equals(other.otherRole))
            return false;
        if (otherType == null) {
            if (other.otherType != null)
                return false;
        } else if (!otherType.equals(other.otherType))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }


    public static class Builder {
        private String name;
        private String note;
        private String role;
        private String type;
        private String otherRole;
        private String otherType;
        
        public Builder(){
        	super();
        }
        
        public Builder(Agent orig){
        	this.name=new String(orig.name);
        	this.note=new String(orig.note);
        	this.role=new String(orig.role);
        	this.type=new String(orig.type);
        	this.otherRole=new String(orig.otherRole);
        	this.otherType=new String(orig.otherType);
        }

        public Agent build() {
            return new Agent(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
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

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
    }

}
