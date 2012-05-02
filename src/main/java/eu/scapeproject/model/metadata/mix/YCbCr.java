package eu.scapeproject.model.metadata.mix;

public class YCbCr {
    private YCbCrSubSampling yCbCrSubSmapling;

    public YCbCr(YCbCrSubSampling yCbCrSubSmapling) {
        super();
        this.yCbCrSubSmapling = yCbCrSubSmapling;
    }

    public YCbCrSubSampling getyCbCrSubSmapling() {
        return yCbCrSubSmapling;
    }

    public static class YCbCrSubSampling {
        private SubSampling horiz;;
        private SubSampling vert;

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

        public enum SubSampling {
            EQUAL_SIZE, HALF_SIZE, QUARTER_SIZE;
            private SubSampling fromValue(short value) {
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
