package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="pageTag",namespace="http://books.google.com/gbs")
public class PageTag extends TechnicalMetadata{
	@XmlValue
	private final String text;
	
	public PageTag(Builder b) {
		super(MetadataType.GBS_PAGE_TAG);
		this.text = b.text;
	}
	
	private static class Builder{
		private String text;
		
		public Builder text(String text){
			this.text = text;
			return this;
		}
		
		public PageTag build(){
			return new PageTag(this);
		}
	}

}
