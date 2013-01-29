package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "leader")
public class Leader {
    @XmlAttribute(name = "id")
    private final String id;

    @XmlAttribute(name = "name")
    private final String name;
    
    private Leader(){
        super();
        this.id=null;
        this.name=null;
    }

    private Leader(Builder b) {
        this.id = b.id;
        this.name = b.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private String name;

        private String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Leader build() {
            return new Leader(this);
        }
    }

}
