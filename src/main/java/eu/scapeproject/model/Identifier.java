package eu.scapeproject.model;

public abstract class Identifier {
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

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
    
}
