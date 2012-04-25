package eu.scapeproject.model.metadata.mix;

import java.net.URI;
import java.util.List;

public class ImageColorEncoding {
    private String bitsPerSampleValue;
    private BitsPerSampleUnit bitsPerSampleUnit;
    private int samplesPerPixel;
    private ExtraSamples extraSamples;
    private URI colorMapReference;
    private byte[] embeddedColorMap;
    private short grayResponseCurve;
    private GrayResponseUnit grayResponseUnit;
    private List<WhitePoint> whitePoints;
    
    public static class PrimaryChromaticies{
        private String primaryChromaticiesRedX; 
        private String primaryChromaticiesRedY; 
        private String primaryChromaticiesGreenX; 
        private String primaryChromaticieGreenY; 
        private String primaryChromaticiesBlueX; 
        private String primaryChromaticiesBlueY; 
    }
    
    public static class WhitePoint{
        private String whitePointXValue;
        private String whitePointYValue;
    }
    public enum GrayResponseUnit{
        TENTH_OF_A_UNIT,HUNDREDS_OF_A_UNIT,THOUSANDS_OF_A_UNIT,TEN_THOUSANDS_OF_A_UNIT,HUNDRED_THOUSANDS_OF_A_UNIT;
    }
    
    public enum ExtraSamples{
        UNSPECIFIED_DATA,ASSOCIATED_ALPHA_DATA,UNASSOCIATED_ALPHA_DATA,RANGE_OR_DEPTH_DATA;
    }
    
    public enum BitsPerSampleUnit{
        FLOAT,INTEGER;
    }
}
