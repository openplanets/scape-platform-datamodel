package eu.scapeproject.model.metadata;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;

@XmlSeeAlso({ DCMetadata.class })
@XmlRootElement(name = "descriptive", namespace = "http://scapeproject.eu/model")
public abstract class DescriptiveMetadata extends MetsMetadata {
	public DescriptiveMetadata() {
		super();
	}

	public enum MetadataType {
		DC;
	}
	
	

}
