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
}
