package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="focusParameters", namespace="http://books.google.com/gbs")
public class FocusParameters extends TechnicalMetadata{
	@XmlAttribute(name="threshold")
	private final String threshold;
	
	public FocusParameters(Builder b) {
		super(MetadataType.GBS_FOCUS_PARAMETERS);
		this.threshold = b.threshold;
	}

	
	private static class Builder{
		private String threshold;
		
		public Builder threshold(String threshold) {
			this.threshold = threshold;
			return this;
		}
		
		public FocusParameters build(){
			return new FocusParameters(this);
		}
	}
}
