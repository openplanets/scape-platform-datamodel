package eu.scapeproject.model;

import eu.scapeproject.model.metadata.TechnicalMetadata;

public class BitStream {
    private final String title;
    private final Type type;
    private final TechnicalMetadata technical;

    private BitStream(){
        this.title=null;
        this.type=null;
        this.technical=null;
    }
    
    public BitStream(String title, Type type, TechnicalMetadata technical) {
        super();
        this.title = title;
        this.type = type;
        this.technical = technical;
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
        if (type != other.type)
            return false;
        return true;
    }
    
}
