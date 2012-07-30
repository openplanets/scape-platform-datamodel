package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="bitstream",namespace="http://scapeproject.eu/model")
public class BitStream {
	@XmlElement(name="title",namespace="http://scapeproject.eu/model")
    private final String title;
	@XmlElement(name="type",namespace="http://scapeproject.eu/model")
    private final Type type;
	@XmlElement(name="technical",namespace="http://scapeproject.eu/model")
    private final TechnicalMetadata technical;
	@XmlElement(name="identifier",namespace="http://scapeproject.eu/model")
    private final Identifier identifier;

    private BitStream() {
        this.title = null;
        this.type = null;
        this.technical = null;
        this.identifier = null;
    }

    private BitStream(Builder b) {
        super();
        this.title = b.title;
        this.type = b.type;
        this.technical = b.technical;
        this.identifier = b.identifier;
    }

    public TechnicalMetadata getTechnical() {
        return technical;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @XmlEnum
    public enum Type {
        STREAM;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((technical == null) ? 0 : technical.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
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
        BitStream other = (BitStream) obj;
        if (technical == null) {
            if (other.technical != null)
                return false;
        } else if (!technical.equals(other.technical))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (identifier == null) {
            if (other.identifier != null)
                return false;
        } else if (!identifier.equals(other.identifier))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    public static class Builder {
        private  String title;
        private  Type type;
        private  TechnicalMetadata technical;
        private  Identifier identifier;

        public Builder title(String title){
            this.title=title;
            return this;
        }
        
        public Builder type(Type type){
            this.type=type;
            return this;
        }
        
        public Builder technical(TechnicalMetadata technical){
            this.technical=technical;
            return this;
        }
        
        public Builder identifier(Identifier identifier){
            this.identifier=identifier;
            return this;
        }
        
        public BitStream build() {
            return new BitStream(this);
        }
    }
}
