package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

@XmlRootElement(name = "marc-record")
public class Marc21Metadata extends DescriptiveMetadata {
	
	@XmlElement(name="record")
	private final Marc21Record record;

    
    private Marc21Metadata(){
        super(MetadataType.MARC21);
        this.record = null;
    }

    private Marc21Metadata(Builder b) {
        super(MetadataType.MARC21);
        this.record = b.record;
    }

    public static class Builder {
    	
    	private Marc21Record record;

        public Builder() {

        }

        public Builder record(Marc21Record record) {
            this.record = record;
            return this;
        }

        public Marc21Metadata build() {
            return new Marc21Metadata(this);
        }
    }

}
