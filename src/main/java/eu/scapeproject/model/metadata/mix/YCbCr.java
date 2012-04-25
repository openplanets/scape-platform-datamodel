package eu.scapeproject.model.metadata.mix;

public class YCbCr {
    private YCbCrSubSampling yCbCrSubSmapling;

    public static class YCbCrSubSampling {
        private SubSampling horiz;;
        private SubSampling vert;

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
