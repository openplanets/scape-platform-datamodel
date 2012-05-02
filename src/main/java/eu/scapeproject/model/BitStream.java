package eu.scapeproject.model;

import eu.scapeproject.model.metadata.TechnicalMetadata;

public class BitStream {
    private String title;
    private Type type;
    private TechnicalMetadata technical;

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

    public void setTechnical(TechnicalMetadata technical) {
        this.technical = technical;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        STREAM;
    }
}
