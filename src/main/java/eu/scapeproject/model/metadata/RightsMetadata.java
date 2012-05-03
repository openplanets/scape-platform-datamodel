package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;

@XmlSeeAlso({ PremisRightsMetadata.class })
public abstract class RightsMetadata {
    public enum Type {
        PREMIS;
    }

    private Type type;

    private RightsMetadata(){
        super();
    }

    public RightsMetadata(Type type) {
        super();
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
