package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="basicImageInformation",namespace="http://www.loc.gov/mix/v10")
public class BasicImageInformation {
    @XmlElement(name="basicImageCharacteristics",namespace="http://www.loc.gov/mix/v10")
    private BasicImageCharateristics basicImageCharacteristics;

    private BasicImageInformation() {
        super();
    }

    public BasicImageInformation(BasicImageCharateristics basicImageCharacteristics) {
        super();
        this.basicImageCharacteristics = basicImageCharacteristics;
    }

    public BasicImageCharateristics getBasicImageCharacteristics() {
        return basicImageCharacteristics;
    }
}
