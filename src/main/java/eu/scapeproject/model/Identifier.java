package eu.scapeproject.model;


public abstract class Identifier{
    protected String type;
    protected String value;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
