package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.util.CopyUtil;
import eu.scapeproject.model.util.ListUtil;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Representation other = (Representation) obj;
		if (files == null) {
			if (other.files != null)
				return false;
		} else if (!ListUtil.compareFiles(files, other.files))
			return false;
		if (provenance == null) {
			if (other.provenance != null)
				return false;
		} else if (!provenance.equals(other.provenance))
			return false;
		if (rights == null) {
			if (other.rights != null)
				return false;
		} else if (!rights.equals(other.rights))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (technical == null) {
			if (other.technical != null)
				return false;
		} else if (!technical.equals(other.technical))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (usage == null) {
			if (other.usage != null)
				return false;
		} else if (!usage.equals(other.usage))
			return false;
		return true;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((files == null) ? 0 : files.hashCode());
		result = prime * result
				+ ((provenance == null) ? 0 : provenance.hashCode());
		result = prime * result + ((rights == null) ? 0 : rights.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((technical == null) ? 0 : technical.hashCode());
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((usage == null) ? 0 : usage.hashCode());
		return result;
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

		public Builder(Representation orig) {
			orig = CopyUtil.deepCopy(Representation.class, orig);
			this.source = orig.source;
			this.provenance = orig.provenance;
			this.technical = orig.technical;
			this.rights = orig.rights;
			this.files = orig.files;
			this.id = orig.identifier;
			this.title = orig.title;
			this.usage = orig.usage;
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
