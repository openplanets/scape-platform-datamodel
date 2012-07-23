package eu.scapeproject.model;

public class Identifier {
    protected final String type;
    protected final String value;

    private Identifier() {
        this.type = null;
        this.value = null;
    }

    public Identifier(String type, String value) {
        super();
        this.type = type;
        this.value = value;
    }

    public Identifier(String value) {
        super();
        this.type = "String";
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Identifier other = (Identifier) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
    
}
