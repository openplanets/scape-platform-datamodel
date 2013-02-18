package eu.scapeproject.model.metadata.marc;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datafield")
public class Datafield {
    @XmlAttribute(name = "id")
    private final String id;

    @XmlAttribute(name = "tag")
    private final String tag;

    @XmlAttribute(name = "ind1")
    private final String ind1;

    @XmlAttribute(name = "ind2")
    private final String ind2;
    
    @XmlElements(@XmlElement(name="subfield"))
    private List<SubField> subfields;
    
    private Datafield(){
        this.id = null;
        this.tag = null;
        this.ind1 = null;
        this.ind2 = null;
        this.subfields = null;
    }

    private Datafield(Builder b) {
        this.id = b.id;
        this.tag = b.tag;
        this.ind1 = b.ind1;
        this.ind2 = b.ind2;
        this.subfields = b.subfields;
    }

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getInd1() {
        return ind1;
    }

    public String getInd2() {
        return ind2;
    }

    public List<SubField> getSubfields() {
		return subfields;
	}
    
    public static class Builder {
        private String id;

        private String tag;

        private String ind1;

        private String ind2;
        
        private List<SubField> subfields;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder ind1(String ind1) {
            this.ind1 = ind1;
            return this;
        }

        public Builder ind2(String ind2) {
            this.ind2 = ind2;
            return this;
        }

        public Builder subfields(List<SubField> subfields) {
            this.subfields = subfields;
            return this;
        }

        public Datafield build() {
            return new Datafield(this);
        }
    }

}
