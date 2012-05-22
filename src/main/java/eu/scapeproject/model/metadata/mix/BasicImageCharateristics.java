package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "basicImageCharateristics",namespace="http://www.loc.gov/mix/v10")
public class BasicImageCharateristics {
    @XmlElement(name = "width",namespace="http://www.loc.gov/mix/v10")
    private int width;
    @XmlElement(name = "height",namespace="http://www.loc.gov/mix/v10")
    private int height;
    @XmlElement(name = "photometricInterpretation",namespace="http://www.loc.gov/mix/v10")
    private PhotometricInterpretation photometricInterpretation;

    public BasicImageCharateristics() {
        super();
    }

    public BasicImageCharateristics(int width, int height, PhotometricInterpretation photometricInterpretation) {
        super();
        this.width = width;
        this.height = height;
        this.photometricInterpretation = photometricInterpretation;
    }

    public int getHeight() {
        return height;
    }

    public PhotometricInterpretation getPhotometricInterpretation() {
        return photometricInterpretation;
    }

    public int getWidth() {
        return width;
    }

}
