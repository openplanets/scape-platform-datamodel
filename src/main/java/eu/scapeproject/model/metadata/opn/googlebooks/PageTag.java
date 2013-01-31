package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="pageTag",namespace="http://books.google.com/gbs")
public class PageTag extends TechnicalMetadata{
	
	private PageTag(Builder b) {
		super(MetadataType.GBS_PAGE_TAG);
	}
	
	private PageTag() {
		super(MetadataType.GBS_PAGE_TAG);
	}

	private static class Builder{
		
		public PageTag build(){
			return new PageTag(this);
		}
	}

}
