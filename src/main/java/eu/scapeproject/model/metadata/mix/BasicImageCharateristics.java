package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "basicImageCharateristics",namespace="http://www.loc.gov/mix/v10")
public class BasicImageCharateristics {
    @XmlElement(name = "width",namespace="http://www.loc.gov/mix/v10")
    private final int width;
    @XmlElement(name = "height",namespace="http://www.loc.gov/mix/v10")
    private final int height;
    @XmlElement(name = "photometricInterpretation",namespace="http://www.loc.gov/mix/v10")
    private final PhotometricInterpretation photometricInterpretation;

    public BasicImageCharateristics() {
        super();
        this.width=0;
        this.height=0;
        this.photometricInterpretation=null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + height;
        result = prime * result + ((photometricInterpretation == null) ? 0 : photometricInterpretation.hashCode());
        result = prime * result + width;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BasicImageCharateristics other = (BasicImageCharateristics) obj;
        if (height != other.height)
            return false;
        if (photometricInterpretation == null) {
            if (other.photometricInterpretation != null)
                return false;
        } else if (!photometricInterpretation.equals(other.photometricInterpretation))
            return false;
        if (width != other.width)
            return false;
        return true;
    }

}
