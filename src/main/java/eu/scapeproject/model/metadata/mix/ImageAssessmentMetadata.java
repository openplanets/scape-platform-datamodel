package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="imageAssemeentMetadata",namespace="http://www.loc.gov/mix/v10")
public class ImageAssessmentMetadata {
    @XmlElement(name="spacialMetrics",namespace="http://www.loc.gov/mix/v10")
    private final SpacialMetrics spacialMetrics;
    @XmlElement(name="imageColorEncoding",namespace="http://www.loc.gov/mix/v10")
    private final ImageColorEncoding imageColorEncoding;
    @XmlElement(name="targetData",namespace="http://www.loc.gov/mix/v10")
    private final TargetData targetData;
    
    @SuppressWarnings("unused")
    private ImageAssessmentMetadata(){
        super();
        this.spacialMetrics=null;
        this.imageColorEncoding=null;
        this.targetData=null;
    }

    public ImageAssessmentMetadata(SpacialMetrics spacialMetrics, ImageColorEncoding imageColorEncoding, TargetData targetData) {
        super();
        this.spacialMetrics = spacialMetrics;
        this.imageColorEncoding = imageColorEncoding;
        this.targetData = targetData;
    }

    public ImageColorEncoding getImageColorEncoding() {
        return imageColorEncoding;
    }

    public SpacialMetrics getSpacialMetrics() {
        return spacialMetrics;
    }

    public TargetData getTargetData() {
        return targetData;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((imageColorEncoding == null) ? 0 : imageColorEncoding.hashCode());
        result = prime * result + ((spacialMetrics == null) ? 0 : spacialMetrics.hashCode());
        result = prime * result + ((targetData == null) ? 0 : targetData.hashCode());
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
        ImageAssessmentMetadata other = (ImageAssessmentMetadata) obj;
        if (imageColorEncoding == null) {
            if (other.imageColorEncoding != null)
                return false;
        } else if (!imageColorEncoding.equals(other.imageColorEncoding))
            return false;
        if (spacialMetrics == null) {
            if (other.spacialMetrics != null)
                return false;
        } else if (!spacialMetrics.equals(other.spacialMetrics))
            return false;
        if (targetData == null) {
            if (other.targetData != null)
                return false;
        } else if (!targetData.equals(other.targetData))
            return false;
        return true;
    }

}
