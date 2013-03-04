package eu.scapeproject.model.metadata;


public abstract class RightsMetadata {
    private Type type;
    private String id;

    @SuppressWarnings("unused")
    private RightsMetadata() {
        super();
    }

    public RightsMetadata(String id, Type type) {
        super();
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        PREMIS;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RightsMetadata [type=" + type + "]";
    }

}
