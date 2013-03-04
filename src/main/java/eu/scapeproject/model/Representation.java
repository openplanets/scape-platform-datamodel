package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "representation", namespace = "http://scapeproject.eu/model")
public class Representation {
	@XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
	private final Identifier identifier;
	@XmlElement(name = "source", namespace = "http://scapeproject.eu/model")
	private final DescriptiveMetadata source;
	@XmlElement(name = "provenance", namespace = "http://scapeproject.eu/model")
	private final ProvenanceMetadata provenance;
	@XmlElement(name = "technical", namespace = "http://scapeproject.eu/model")
	private final TechnicalMetadata technical;
	@XmlElement(name = "rights", namespace = "http://scapeproject.eu/model")
	private final RightsMetadata rights;
	@XmlElement(name = "files", namespace = "http://scapeproject.eu/model")
	private final List<File> files;
	@XmlElement(name = "title", namespace = "http://scapeproject.eu/model")
	private final String title;
	@XmlElement(name = "usage", namespace = "http://scapeproject.eu/model")
	private final String usage;

	private Representation() {
		super();
		this.source = null;
		this.provenance = null;
		this.technical = null;
		this.rights = null;
		this.files = null;
		this.identifier = null;
		this.title = null;
		this.usage = null;
	}

	private Representation(Builder builder) {
		this.source = builder.source;
		this.provenance = builder.provenance;
		this.technical = builder.technical;
		this.rights = builder.rights;
		this.files = builder.files;
		this.identifier = builder.id;
		this.title = builder.title;
		this.usage = builder.usage;
	}

	public List<File> getFiles() {
		return files;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public ProvenanceMetadata getProvenance() {
		return provenance;
	}

	public RightsMetadata getRights() {
		return rights;
	}

	public DescriptiveMetadata getSource() {
		return source;
	}

	public TechnicalMetadata getTechnical() {
		return technical;
	}

	

	public String getTitle() {
		return title;
	}

	public String getUsage() {
		return usage;
	}
	
	@Override
	public String toString() {
		return "Representation [" 
				+ "identifier=" + identifier 
				+ ", source=" + source 
				+ ", provenance=" + provenance 
				+ ", technical=" + technical 
				+ ", rights=" + rights 
				+ ", files=" + files
				+ ", title=" + title 
				+ ", usage=" + usage 
				+ "]";
	}

	public static class Builder {
		private DescriptiveMetadata source;
		private ProvenanceMetadata provenance;
		private TechnicalMetadata technical;
		private RightsMetadata rights;
		private List<File> files = new ArrayList<File>();
		private Identifier id;
		private String title;
		private String usage;

		public Builder(Identifier id) {
			super();
			this.id = id;
		}

		public Representation build() {
			return new Representation(this);
		}

		public Builder file(File file) {
			if (this.files == null) {
				this.files = new ArrayList<File>();
			}
			this.files.add(file);
			return this;
		}

		public Builder files(List<File> files) {
			this.files = files;
			return this;
		}

		public Builder identifier(Identifier id) {
			this.id = id;
			return this;
		}

		public Builder provenance(ProvenanceMetadata provenance) {
			this.provenance = provenance;
			return this;
		}

		public Builder rights(RightsMetadata rights) {
			this.rights = rights;
			return this;
		}

		public Builder source(DescriptiveMetadata source) {
			this.source = source;
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

		public Builder usage(String usage) {
			this.usage = usage;
			return this;
		}
	}
}
