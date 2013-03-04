package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "bitstream", namespace = "http://scapeproject.eu/model")
public class BitStream {
	

	@XmlElement(name = "title", namespace = "http://scapeproject.eu/model")
	private final String title;
	@XmlElement(name = "type", namespace = "http://scapeproject.eu/model")
	private final Type type;
	@XmlElement(name = "technical", namespace = "http://scapeproject.eu/model")
	private final TechnicalMetadata technical;
	@XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
	private final Identifier identifier;

	private BitStream() {
		this.title = null;
		this.type = null;
		this.technical = null;
		this.identifier = null;
	}

	private BitStream(Builder b) {
		super();
		this.title = b.title;
		this.type = b.type;
		this.technical = b.technical;
		this.identifier = b.identifier;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public TechnicalMetadata getTechnical() {
		return technical;
	}

	public String getTitle() {
		return title;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "BitStream [title=" + title 
				+ ", type=" + type 
				+ ", technical="+ technical 
				+ ", identifier=" + identifier 
				+ "]";
	}

	public static class Builder {
		private String title;
		private Type type;
		private TechnicalMetadata technical;
		private Identifier identifier;

		public Builder() {
			super();
		}

		public BitStream build() {
			return new BitStream(this);
		}

		public Builder identifier(Identifier identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder technical(TechnicalMetadata technical) {
			this.technical = technical;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder type(Type type) {
			this.type = type;
			return this;
		}
	}

	@XmlEnum
	public enum Type {
		STREAM;
	}
}
