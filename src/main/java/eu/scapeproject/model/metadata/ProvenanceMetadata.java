package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;

@XmlSeeAlso({PremisProvenanceMetadata.class})
public abstract class ProvenanceMetadata {
    private String type;
    
    private ProvenanceMetadata(){
        super();
    }
    
    public ProvenanceMetadata(String type) {
        super();
        this.type = type;
    }
}