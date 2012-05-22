package eu.scapeproject.model.metadata.videomd;

public class VideoCodec extends VideoFormat {
    private String codecId;
    private int channelCount;
    private String endianess;
    private String scanType;
    private String scanOrder;
    private String sign;

    private VideoCodec(){
        super();
    }
    
    private VideoCodec(Builder builder) {
        this.codecId = builder.codecId;
        this.channelCount = builder.channelCount;
        this.endianess = builder.endianess;
        this.scanType = builder.scanType;
        this.scanOrder = builder.scanOrder;
        this.sign = builder.sign;
    }

    public int getChannelCount() {
        return channelCount;
    }

    public String getCodecId() {
        return codecId;
    }

    public String getEndianess() {
        return endianess;
    }

    public String getScanOrder() {
        return scanOrder;
    }

    public String getScanType() {
        return scanType;
    }

    public String getSign() {
        return sign;
    }

    public static class Builder {
        private String codecId;
        private int channelCount;
        private String endianess;
        private String scanType;
        private String scanOrder;
        private String sign;

        public VideoCodec build() {
            return new VideoCodec(this);
        }

        public Builder channelCount(int channelCount) {
            this.channelCount = channelCount;
            return this;
        }

        public Builder codecId(String codecId) {
            this.codecId = codecId;
            return this;
        }

        public Builder endianess(String endianess) {
            this.endianess = endianess;
            return this;
        }

        public Builder scanOrder(String scanOrder) {
            this.scanOrder = scanOrder;
            return this;
        }

        public Builder scanType(String scanType) {
            this.scanType = scanType;
            return this;
        }

        public Builder sign(String sign) {
            this.sign = sign;
            return this;
        }
    }
}
