package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;

@XmlSeeAlso({ PremisProvenanceMetadata.class })
public abstract class ProvenanceMetadata extends MetsMetadata{
    private String type;

    @SuppressWarnings("unused")
    private ProvenanceMetadata() {
        super();
    }

    public ProvenanceMetadata(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
