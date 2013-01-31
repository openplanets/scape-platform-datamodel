package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subfield", namespace = "http://www.loc.gov/MARC21/slim")
public class SubField {
	@XmlAttribute(name = "code")
	private final String code;
	@XmlAttribute(name = "id")
	private final String id;

	private SubField(Builder b) {
		this.code = b.code;
		this.id = b.id;
	}
	
	private SubField(){
		super();
		this.code = null;
		this.id = null;
	}

	public static class Builder {
		private String code;
		private String id;

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public SubField build() {
			return new SubField(this);
		}
	}
}
