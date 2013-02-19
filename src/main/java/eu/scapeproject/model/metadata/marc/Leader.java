package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "leader")
public class Leader {
    @XmlAttribute(name = "id")
    private final String id;

    @XmlAttribute(name = "name")
    private final String name;
    
    @XmlValue
    private final String value;
    
    private Leader(){
        super();
        this.id=null;
        this.name=null;
        this.value = null;
    }

    private Leader(Builder b) {
        this.id = b.id;
        this.name = b.name;
        this.value = b.value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getValue() {
		return value;
	}

    public static class Builder {
        private String name;

        private String id;
        
        private String value;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Leader build() {
            return new Leader(this);
        }
    }

}
