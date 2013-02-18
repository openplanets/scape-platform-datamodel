package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "controlfield")
public class ControlField {
    @XmlAttribute(name = "id")
    private final String id;

    @XmlAttribute(name = "tag")
    private final String tag;

    @XmlAttribute(name = "xml:space")
    private final String xmlSpace;
    
    @XmlValue
    private final String value;

    private ControlField() {
        super();
        this.id = null;
        this.tag = null;
        this.xmlSpace = null;
        this.value = null;
    }

    private ControlField(Builder b) {
        this.id = b.id;
        this.tag = b.tag;
        this.xmlSpace = b.xmlSpace;
        this.value = b.value;
    }

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getXmlSpace() {
        return xmlSpace;
    }

    public static class Builder {
        private String id;

        private String tag;

        private String xmlSpace;
        
        private String value;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder xmlSpace(String xmlSpace) {
            this.xmlSpace = xmlSpace;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public ControlField build() {
            return new ControlField(this);
        }
    }
}
