package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datafield")
public class Datafield {
    @XmlAttribute(name = "id")
    private final String id;

    @XmlAttribute(name = "id")
    private final String tag;

    @XmlAttribute(name = "id")
    private final String ind1;

    @XmlAttribute(name = "id")
    private final String ind2;

    private Datafield(Builder b) {
        this.id = b.id;
        this.tag = b.tag;
        this.ind1 = b.ind1;
        this.ind2 = b.ind2;
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

    public static class Builder {
        private String id;

        private String tag;

        private String ind1;

        private String ind2;

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

        public Datafield build() {
            return new Datafield(this);
        }
    }

}
