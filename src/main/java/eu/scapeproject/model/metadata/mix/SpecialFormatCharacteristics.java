package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "specialFormatCharateristics", namespace = "http://www.loc.gov/mix/v10")
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialFormatCharacteristics {
	@XmlElement(name = "format", namespace = "http://www.loc.gov/mix/v10")
	private final  Format format;

	@SuppressWarnings("unused")
	private SpecialFormatCharacteristics() {
		super();
		this.format=null;
	}

	public SpecialFormatCharacteristics(Format format) {
		super();
		this.format = format;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialFormatCharacteristics other = (SpecialFormatCharacteristics) obj;
		if (format != other.format)
			return false;
		return true;
	}

	public Format getFormat() {
		return format;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		return result;
	}

	@XmlEnum
	public enum Format {
		JPG_2000, MR_SID, DJVU;
	}

}
