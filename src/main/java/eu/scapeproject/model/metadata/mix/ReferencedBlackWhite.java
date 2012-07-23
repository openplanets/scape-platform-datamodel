package eu.scapeproject.model.metadata.mix;

import java.util.Arrays;

public class ReferencedBlackWhite {
    private double[] referenceBlack;
    private double[] referenceWhite;

    public ReferencedBlackWhite(double[] referenceBlack, double[] referenceWhite) {
        super();
        this.referenceBlack = referenceBlack;
        this.referenceWhite = referenceWhite;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReferencedBlackWhite other = (ReferencedBlackWhite) obj;
        if (!Arrays.equals(referenceBlack, other.referenceBlack))
            return false;
        if (!Arrays.equals(referenceWhite, other.referenceWhite))
            return false;
        return true;
    }
    

}
