package eu.scapeproject.model.metadata;

import eu.scapeproject.dto.mets.MetsMetadata;






public abstract class DescriptiveMetadata extends MetsMetadata{

    public DescriptiveMetadata() {
        super();
    }

    public enum MetadataType {
        DC;
    }
    
}
