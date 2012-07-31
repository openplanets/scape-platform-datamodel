package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="basicImageInformation",namespace="http://www.loc.gov/mix/v10")
public class BasicImageInformation {
    @XmlElement(name="basicImageCharacteristics",namespace="http://www.loc.gov/mix/v10")
    private final BasicImageCharateristics basicImageCharacteristics;

    @SuppressWarnings("unused")
    private BasicImageInformation() {
        super();
        this.basicImageCharacteristics=null;
    }

    public BasicImageInformation(BasicImageCharateristics basicImageCharacteristics) {
        super();
        this.basicImageCharacteristics = basicImageCharacteristics;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasicImageInformation other = (BasicImageInformation) obj;
        if (basicImageCharacteristics == null) {
            if (other.basicImageCharacteristics != null)
                return false;
        } else if (!basicImageCharacteristics.equals(other.basicImageCharacteristics))
            return false;
        return true;
    }

    public BasicImageCharateristics getBasicImageCharacteristics() {
        return basicImageCharacteristics;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((basicImageCharacteristics == null) ? 0 : basicImageCharacteristics.hashCode());
        return result;
    }
    
}
