package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "subfield", namespace = "http://www.loc.gov/MARC21/slim")
public class SubField {
	@XmlAttribute(name = "code")
	private final String code;
	@XmlAttribute(name = "id")
	private final String id;
	@XmlValue
	private final String value;

	private SubField(Builder b) {
		this.code = b.code;
		this.id = b.id;
		this.value = b.value;
	}

	private SubField() {
		super();
		this.code = null;
		this.id = null;
		this.value = null;
	}

	public String getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}

	public static class Builder {
		private String code;
		private String id;
		private String value;

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder value(String value) {
			this.value = value;
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
