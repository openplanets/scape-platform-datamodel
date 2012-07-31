package eu.scapeproject.model.metadata.mix;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="referenceBlackWhite",namespace="http://www.loc.gov/mix/v10")
public class ReferenceBlackWhite {
    @XmlElement(name="referenceBlack",namespace="http://www.loc.gov/mix/v10")
    private final double[] referenceBlack;
    @XmlElement(name="referenceWhite",namespace="http://www.loc.gov/mix/v10")
    private final double[] referenceWhite;
    
    @SuppressWarnings("unused")
    private ReferenceBlackWhite(){
        super();
        this.referenceBlack=null;
        this.referenceWhite=null;
    }

    public ReferenceBlackWhite(double[] referenceBlack, double[] referenceWhite) {
        super();
        this.referenceBlack = referenceBlack;
        this.referenceWhite = referenceWhite;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReferenceBlackWhite other = (ReferenceBlackWhite) obj;
        if (!Arrays.equals(referenceBlack, other.referenceBlack))
            return false;
        if (!Arrays.equals(referenceWhite, other.referenceWhite))
            return false;
        return true;
    }

    public double[] getReferenceBlack() {
        return referenceBlack;
    }

    public double[] getReferenceWhite() {
        return referenceWhite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(referenceBlack);
        result = prime * result + Arrays.hashCode(referenceWhite);
        return result;
    }
    

}
