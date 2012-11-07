package eu.scapeproject.model.metadata;

import eu.scapeproject.dto.mets.MetsMetadata;

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

	@Override
	public String toString() {
		return "ProvenanceMetadata [type=" + type + "]";
	}
    
    
}
