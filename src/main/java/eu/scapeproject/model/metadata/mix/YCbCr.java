package eu.scapeproject.model.metadata.mix;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="yCbCr",namespace="http://www.loc.gov/mix/v10")
public class YCbCr {
    @XmlElement(name="yCbCrSubSampling",namespace="http://www.loc.gov/mix/v10")
    private YCbCrSubSampling yCbCrSubSampling;

    @SuppressWarnings("unused")
    private YCbCr(){
        super();
    }
    
    public YCbCr(YCbCrSubSampling yCbCrSubSmapling) {
        super();
        this.yCbCrSubSampling = yCbCrSubSmapling;
    }

    public YCbCrSubSampling getyCbCrSubSmapling() {
        return yCbCrSubSampling;
    }
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((yCbCrSubSampling == null) ? 0 : yCbCrSubSampling.hashCode());
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
        YCbCr other = (YCbCr) obj;
        if (yCbCrSubSampling == null) {
            if (other.yCbCrSubSampling != null)
                return false;
        } else if (!yCbCrSubSampling.equals(other.yCbCrSubSampling))
            return false;
        return true;
    }



    @XmlRootElement(name="yCbCrSubSampling",namespace="http://www.loc.gov/mix/v10")
    public static class YCbCrSubSampling {
        @XmlElement(name="horiz",namespace="http://www.loc.gov/mix/v10")
        private SubSampling horiz;;
        @XmlElement(name="vert",namespace="http://www.loc.gov/mix/v10")
        private SubSampling vert;

        @SuppressWarnings("unused")
        private YCbCrSubSampling(){
            super();
        }
        
        public YCbCrSubSampling(SubSampling horiz, SubSampling vert) {
            super();
            this.horiz = horiz;
            this.vert = vert;
        }

        public SubSampling getHoriz() {
            return horiz;
        }

        public SubSampling getVert() {
            return vert;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((horiz == null) ? 0 : horiz.hashCode());
            result = prime * result + ((vert == null) ? 0 : vert.hashCode());
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
            YCbCrSubSampling other = (YCbCrSubSampling) obj;
            if (horiz != other.horiz)
                return false;
            if (vert != other.vert)
                return false;
            return true;
        }

        public enum SubSampling {
            EQUAL_SIZE, HALF_SIZE, QUARTER_SIZE;
            public SubSampling fromValue(short value) {
                switch (value) {
                case 1:
                    return EQUAL_SIZE;
                case 2:
                    return HALF_SIZE;
                case 4:
                    return QUARTER_SIZE;
                default:
                    return null;
                }
            }
        }
    }
}
