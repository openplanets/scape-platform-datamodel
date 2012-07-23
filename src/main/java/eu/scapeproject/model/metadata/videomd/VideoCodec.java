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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + channelCount;
        result = prime * result + ((codecId == null) ? 0 : codecId.hashCode());
        result = prime * result + ((endianess == null) ? 0 : endianess.hashCode());
        result = prime * result + ((scanOrder == null) ? 0 : scanOrder.hashCode());
        result = prime * result + ((scanType == null) ? 0 : scanType.hashCode());
        result = prime * result + ((sign == null) ? 0 : sign.hashCode());
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
        VideoCodec other = (VideoCodec) obj;
        if (channelCount != other.channelCount)
            return false;
        if (codecId == null) {
            if (other.codecId != null)
                return false;
        } else if (!codecId.equals(other.codecId))
            return false;
        if (endianess == null) {
            if (other.endianess != null)
                return false;
        } else if (!endianess.equals(other.endianess))
            return false;
        if (scanOrder == null) {
            if (other.scanOrder != null)
                return false;
        } else if (!scanOrder.equals(other.scanOrder))
            return false;
        if (scanType == null) {
            if (other.scanType != null)
                return false;
        } else if (!scanType.equals(other.scanType))
            return false;
        if (sign == null) {
            if (other.sign != null)
                return false;
        } else if (!sign.equals(other.sign))
            return false;
        return true;
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
