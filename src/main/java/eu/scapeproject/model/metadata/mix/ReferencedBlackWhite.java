package eu.scapeproject.model.metadata.mix;

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

}
