package eu.scapeproject.model;

import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.util.CopyUtil;

@XmlRootElement(name = "file", namespace = "http://scapeproject.eu/model")
public class File {

	@XmlAttribute(name = "mimetype")
	private final String mimetype;
	@XmlAttribute(name = "filename")
	private final String filename;
	@XmlElement(name = "technical", namespace = "http://scapeproject.eu/model")
	private final Object technical;
	@XmlElement(name = "bitstream", namespace = "http://scapeproject.eu/model")
	private final List<BitStream> bitStreams;
	@XmlElement(name = "uri", namespace = "http://scapeproject.eu/model")
	private final URI uri;
	@XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
	private final Identifier identifier;

	private File() {
		this.filename = null;
		this.mimetype = null;
		this.technical = null;
		this.bitStreams = null;
		this.uri = null;
		this.identifier = null;
	}

	private File(Builder builder) {
		this.filename = builder.filename;
		this.mimetype = builder.mimetype;
		this.technical = builder.technical;
		this.bitStreams = builder.bitStreams;
		this.uri = builder.uri;
		this.identifier = builder.identifier;
	}

	public List<BitStream> getBitStreams() {
		return bitStreams;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public Object getTechnical() {
		return technical;
	}

	public URI getUri() {
		return uri;
	}

	public String getMimetype() {
		return mimetype;
	}

	public String getFilename() {
		return filename;
	}

	@Override
	public String toString() {
		return "File [technical=" + technical
				+ ", name=" + filename
				+ ", bitStreams=" + bitStreams
				+ ", uri=" + uri
				+ ", identifier=" + identifier
				+ ", mimetype=" + mimetype
				+ "]";
	}

	public static class Builder {
		private Object technical;
		private List<BitStream> bitStreams;
		private URI uri;
		private Identifier identifier;
		private String mimetype;
		private String filename;

		public Builder() {
			super();
		}

		public Builder(File orig) {
			File copy = CopyUtil.deepCopy(File.class, orig);
			this.mimetype = copy.mimetype;
			this.technical = copy.technical;
			this.bitStreams = copy.bitStreams;
			this.uri = copy.uri;
			this.identifier = copy.identifier;
			this.filename = copy.filename;
		}

		public Builder bitStreams(List<BitStream> bitStreams) {
			this.bitStreams = bitStreams;
			return this;
		}

		public File build() {
			if (bitStreams != null && bitStreams.size() == 0) {
				bitStreams = null;
			}
			return new File(this);
		}

		public Builder identifier(Identifier identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder technical(Object technical) {
			this.technical = technical;
			return this;
		}

		public Builder filename(String filename) {
			this.filename = filename;
			return this;
		}

		public Builder mimetype(String mimetype) {
			this.mimetype = mimetype;
			return this;
		}

		public Builder uri(URI uri) {
			this.uri = uri;
			return this;
		}
	}
}
