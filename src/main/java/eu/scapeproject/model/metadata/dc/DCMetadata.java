package eu.scapeproject.model.metadata.dc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Agent;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.jaxb.DateAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.util.CopyUtil;
import eu.scapeproject.model.util.ListUtil;

@XmlRootElement(name = "dublin-core")
public class DCMetadata extends DescriptiveMetadata {
	@XmlElement(name = "date", namespace = "http://purl.org/dc/elements/1.1/")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private final List<Date> dates;
	@XmlElement(name = "title", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> titles;
	@XmlElement(name = "creator", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<Agent> creators;
	@XmlElement(name = "coverage", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> coverages;
	@XmlElement(name = "description", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> descriptions;
	@XmlElement(name = "format", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> formats;
	@XmlElement(name = "language", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> languages;
	@XmlElement(name = "publisher", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> publishers;
	@XmlElement(name = "subject", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> subjects;
	@XmlElement(name = "type", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> types;
	@XmlElement(name = "source", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> sources;
	@XmlElement(name = "relation", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> relations;
	@XmlElement(name = "contributor", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<Agent> contributors;
	@XmlElement(name = "rights", namespace = "http://purl.org/dc/elements/1.1/")
	private final List<String> rights;

	private DCMetadata() {
		super();
		this.dates = null;
		this.titles = null;
		this.creators = null;
		this.coverages = null;
		this.descriptions = null;
		this.formats = null;
		this.languages = null;
		this.publishers = null;
		this.subjects = null;
		this.types = null;
		this.sources = null;
		this.relations = null;
		this.contributors = null;
		this.rights = null;
		this.id=null;
	}

	private DCMetadata(Builder builder) {
		this.dates = builder.dates;
		this.titles = builder.titles;
		this.creators = builder.creators;
		this.coverages = builder.coverages;
		this.descriptions = builder.descriptions;
		this.formats = builder.formats;
		this.languages = builder.languages;
		this.publishers = builder.publishers;
		this.subjects = builder.subjects;
		this.types = builder.types;
		this.sources = builder.sources;
		this.relations = builder.relations;
		this.contributors = builder.contributors;
		this.rights = builder.rights;
		if (builder.identifier != null) {
			this.setId(builder.identifier.getValue());
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DCMetadata other = (DCMetadata) obj;
		if (contributors == null) {
			if (other.contributors != null)
				return false;
		} else if (!contributors.equals(other.contributors))
			return false;
		if (coverages == null) {
			if (other.coverages != null)
				return false;
		} else if (!coverages.equals(other.coverages))
			return false;
		if (creators == null) {
			if (other.creators != null)
				return false;
		} else if (!creators.equals(other.creators))
			return false;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!ListUtil.compareDates(dates, other.dates))
			return false;
		if (descriptions == null) {
			if (other.descriptions != null)
				return false;
		} else if (!descriptions.equals(other.descriptions))
			return false;
		if (formats == null) {
			if (other.formats != null)
				return false;
		} else if (!formats.equals(other.formats))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (publishers == null) {
			if (other.publishers != null)
				return false;
		} else if (!publishers.equals(other.publishers))
			return false;
		if (relations == null) {
			if (other.relations != null)
				return false;
		} else if (!relations.equals(other.relations))
			return false;
		if (rights == null) {
			if (other.rights != null)
				return false;
		} else if (!rights.equals(other.rights))
			return false;
		if (sources == null) {
			if (other.sources != null)
				return false;
		} else if (!sources.equals(other.sources))
			return false;
		if (subjects == null) {
			if (other.subjects != null)
				return false;
		} else if (!subjects.equals(other.subjects))
			return false;
		if (titles == null) {
			if (other.titles != null)
				return false;
		} else if (!titles.equals(other.titles))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	public List<Agent> getConstributors() {
		return contributors;
	}

	public List<String> getCoverages() {
		return coverages;
	}

	public List<Agent> getCreator() {
		return creators;
	}

	public List<Date> getDate() {
		return dates;
	}

	public List<String> getDescription() {
		return descriptions;
	}

	public List<String> getFormat() {
		return formats;
	}

	public List<String> getLanguage() {
		return languages;
	}

	public List<String> getPublisher() {
		return publishers;
	}

	public List<String> getRelations() {
		return relations;
	}

	public List<String> getRights() {
		return rights;
	}

	public List<String> getSources() {
		return sources;
	}

	public List<String> getSubject() {
		return subjects;
	}

	public List<String> getTitle() {
		return titles;
	}

	public List<String> getType() {
		return types;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contributors == null) ? 0 : contributors.hashCode());
		result = prime * result + ((coverages == null) ? 0 : coverages.hashCode());
		result = prime * result + ((creators == null) ? 0 : creators.hashCode());
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		result = prime * result + ((descriptions == null) ? 0 : descriptions.hashCode());
		result = prime * result + ((formats == null) ? 0 : formats.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((publishers == null) ? 0 : publishers.hashCode());
		result = prime * result + ((relations == null) ? 0 : relations.hashCode());
		result = prime * result + ((rights == null) ? 0 : rights.hashCode());
		result = prime * result + ((sources == null) ? 0 : sources.hashCode());
		result = prime * result + ((subjects == null) ? 0 : subjects.hashCode());
		result = prime * result + ((titles == null) ? 0 : titles.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	public static class Builder {
		public Identifier identifier;
		private List<Date> dates;
		private List<String> titles;
		private List<Agent> creators;
		private List<String> coverages;
		private List<String> descriptions;
		private List<String> formats;
		private List<String> languages;
		private List<String> publishers;
		private List<String> subjects;
		private List<String> types;
		private List<String> sources;
		private List<String> relations;
		private List<Agent> contributors;
		private List<String> rights;

		public Builder() {
			super();
		}

		public Builder(DCMetadata orig) {
			orig=CopyUtil.deepCopy(DCMetadata.class, orig);
			this.dates = orig.getDate();
			this.titles = orig.getTitle();
			this.creators = orig.getCreator();
			this.descriptions = orig.getDescription();
			this.formats = orig.getFormat();
			this.languages = orig.getLanguage();
			this.publishers = orig.getPublisher();
			this.subjects = orig.getSubject();
			this.types = orig.getType();
			this.sources = orig.getSources();
			this.relations = orig.getRelations();
			this.contributors = orig.getConstributors();
			this.rights = orig.getRights();
			this.coverages = orig.getCoverages();
			this.identifier=new Identifier(orig.getId());
		}

		public DCMetadata build() {
			return new DCMetadata(this);
		}

		public Builder contributor(Agent constributor) {
			if (contributors == null) {
				contributors = new ArrayList<Agent>();
			}
			this.contributors.add(constributor);
			return this;
		}

		public Builder coverage(String coverage) {
			if (this.coverages == null) {
				this.coverages = new ArrayList<String>();
			}
			this.coverages.add(coverage);
			return this;
		}

		public Builder creator(Agent creator) {
			if (this.creators == null) {
				this.creators = new ArrayList<Agent>();
			}
			this.creators.add(creator);
			return this;
		}

		public Builder date(Date date) {
			if (this.dates == null) {
				this.dates = new ArrayList<Date>();
			}
			this.dates.add(date);
			return this;
		}

		public Builder description(String description) {
			if (this.descriptions == null) {
				this.descriptions = new ArrayList<String>();
			}
			this.descriptions.add(description);
			return this;
		}

		public Builder format(String format) {
			if (this.formats == null) {
				this.formats = new ArrayList<String>();
			}
			this.formats.add(format);
			return this;
		}

		public Builder identifier(Identifier identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder language(String language) {
			if (this.languages == null) {
				this.languages = new ArrayList<String>();
			}
			this.languages.add(language);
			return this;
		}

		public Builder publisher(String publisher) {
			if (this.publishers == null) {
				this.publishers = new ArrayList<String>();
			}
			this.publishers.add(publisher);
			return this;
		}

		public Builder relations(String relations) {
			if (this.relations == null) {
				this.relations = new ArrayList<String>();
			}
			this.relations.add(relations);
			return this;
		}

		public Builder rights(String rights) {
			if (this.rights == null) {
				this.rights = new ArrayList<String>();
			}
			this.rights.add(rights);
			return this;
		}

		public Builder sources(String sources) {
			if (this.sources == null) {
				this.sources = new ArrayList<String>();
			}
			this.sources.add(sources);
			return this;
		}

		public Builder subject(String subject) {
			if (this.subjects == null) {
				this.subjects = new ArrayList<String>();
			}
			this.subjects.add(subject);
			return this;
		}

		public Builder title(String title) {
			if (this.titles == null) {
				this.titles = new ArrayList<String>();
			}
			this.titles.add(title);
			return this;
		}

		public Builder type(String type) {
			if (this.types == null) {
				this.types = new ArrayList<String>();
			}
			this.types.add(type);
			return this;
		}
	}

}
