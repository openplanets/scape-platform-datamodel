package eu.scapeproject.model.metadata;

public abstract class ProvenanceMetadata {
    private String type;
    private String id;

    @SuppressWarnings("unused")
    private ProvenanceMetadata() {
        super();
    }

    public ProvenanceMetadata(String id, String type) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProvenanceMetadata [type=" + type + "]";
    }

}
