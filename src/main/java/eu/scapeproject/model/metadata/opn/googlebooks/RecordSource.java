package eu.scapeproject.model.metadata.opn.googlebooks;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "recordSource", namespace = "http://books.google.com/gbs")
public class RecordSource extends TechnicalMetadata {
	@XmlElement(name = "sourceLibrary", namespace = "http://books.google.com/gbs")
	private final String sourceLibrary;
	@XmlElement(name = "sourceLibrary", namespace = "http://books.google.com/gbs")
	private final String sourceIdentifier;

	public RecordSource(Builder b) {
		super(MetadataType.GBS_RECORD_SOURCE);
		this.sourceLibrary = b.sourceLibrary;
		this.sourceIdentifier = b.sourceIdentifier;
	}

	private static class Builder {
		private String sourceLibrary;
		private String sourceIdentifier;

		public Builder sourceLibrary(String sourceLibrary) {
			this.sourceLibrary = sourceLibrary;
			return this;
		}

		public Builder sourceIdentifer(String sourceIdentifier) {
			this.sourceIdentifier = sourceIdentifier;
			return this;
		}

		public RecordSource build() {
			return new RecordSource(this);
		}
	}

}
