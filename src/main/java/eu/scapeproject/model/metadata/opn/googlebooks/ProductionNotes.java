package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "productionNotes", namespace = "http://books.google.com/gbs")
public class ProductionNotes extends TechnicalMetadata {

	@XmlElement(name = "badPages", namespace = "http://books.google.com/gbs")
	private final String badPages;
	@XmlElement(name = "missingPages", namespace = "http://books.google.com/gbs")
	private final String missingPages;
	@XmlElement(name = "tightBoundPages", namespace = "http://books.google.com/gbs")
	private final String tightBoundPages;

	public ProductionNotes(Builder b) {
		super(MetadataType.GBS_PRODUCTION_NOTES);
		this.badPages = b.badPages;
		this.missingPages = b.missingPages;
		this.tightBoundPages = b.tightBoundPages;
	}

	private static class Builder {
		private String badPages;
		private String missingPages;
		private String tightBoundPages;

		public Builder badPages(String badPages) {
			this.badPages = badPages;
			return this;
		}

		public Builder missingPages(String missingPages) {
			this.missingPages = missingPages;
			return this;
		}

		public Builder tightBoundPages(String tightBoundPages) {
			this.tightBoundPages = tightBoundPages;
			return this;
		}

		public ProductionNotes build() {
			return new ProductionNotes(this);
		}
	}

}
