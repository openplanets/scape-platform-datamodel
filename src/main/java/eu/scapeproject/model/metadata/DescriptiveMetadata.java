package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;

@XmlRootElement(name = "descriptive", namespace = "http://scapeproject.eu/model")
public abstract class DescriptiveMetadata extends MetsMetadata {
	
	private MetadataType type;
	
	public DescriptiveMetadata() {
		super();
	}
	
	public DescriptiveMetadata(String id,MetadataType type){
	    super(id);
	    this.type =type;
	}
	
	public MetadataType getType() {
		return type;
	}

	public enum MetadataType {
		DC,MARC21;
	}
	
	

}
