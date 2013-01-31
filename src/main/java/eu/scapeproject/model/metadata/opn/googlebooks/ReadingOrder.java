package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="readingOrder",namespace="http://books.google.com/gbs")
public class ReadingOrder extends TechnicalMetadata{
	
	@XmlElement(name="pageOrder",namespace="http://books.google.com/gbs")
	private final String pageOrder;
	@XmlElement(name="pageSequence",namespace="http://books.google.com/gbs")
	private final String pageSequence;
	@XmlElement(name="coverTag",namespace="http://books.google.com/gbs")
	private final String coverTag;

	private ReadingOrder(Builder b) {
		super(MetadataType.GBS_READING_ORDER);
		this.pageOrder = b.pageOrder;
		this.coverTag = b.coverTag;
		this.pageSequence = b.pageSequence;
	}
	
	private ReadingOrder() {
		super(MetadataType.GBS_READING_ORDER);
		this.pageOrder = null;
		this.coverTag = null;
		this.pageSequence = null;
	}

	private static class Builder{
		private String pageOrder;
		private String pageSequence;
		private String coverTag;
		
		public Builder pageOrder(String pageOrder){
			this.pageOrder = pageOrder;
			return this;
		}
		
		public Builder pageSequence(String pageSequence){
			this.pageSequence = pageSequence;
			return this;
		}
		public Builder coverTag(String coverTag){
			this.coverTag = coverTag;
			return this;
		}
		
		public ReadingOrder build(){
			return new ReadingOrder(this);
		}
	}

}
