package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="imageMethod",namespace="http://books.google.com/gbs")
public class ImageMethod extends TechnicalMetadata{
	
	@XmlAttribute(name="scanner")
	private final String scanner;
	
	private ImageMethod(Builder b) {
		super(MetadataType.GBS_IMAGE_METHOD);
		this.scanner = b.scanner;
	}
	
	private ImageMethod() {
		super(MetadataType.GBS_IMAGE_METHOD);
		this.scanner = null;
	}

	private static class Builder{
		private String scanner;
		
		
		public Builder scanner(String scanner){
			this.scanner = scanner;
			return this;
		}
		
		public ImageMethod build(){
			return new ImageMethod(this);
		}
	}

}
