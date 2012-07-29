package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="track",namespace="http://www.loc.gov/videoMD/")
public class VideoTrack extends MediaDataType {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/videoMD/")
    private final String id;
    @XmlElement(name="num",namespace="http://www.loc.gov/videoMD/")
    private final int num;
    @XmlElement(name="type",namespace="http://www.loc.gov/videoMD/")
    private final String type;
    @XmlElement(name="bitspersample",namespace="http://www.loc.gov/videoMD/")
    private final int bitsPerSample;
    @XmlElement(name="bitsperpixelstored",namespace="http://www.loc.gov/videoMD/")
    private final float bitsPerPixelStored;
    @XmlElement(name="codec",namespace="http://www.loc.gov/videoMD/")
    private final VideoCodec codec;
    @XmlElement(name="compressionratio",namespace="http://www.loc.gov/videoMD/")
    private final float compressionRatio;
    @XmlElement(name="quality",namespace="http://www.loc.gov/videoMD/")
    private final String quality;
    @XmlElement(name="frame",namespace="http://www.loc.gov/videoMD/")
    private final VideoFrame frame;
    @XmlElement(name="framerate",namespace="http://www.loc.gov/videoMD/")
    private final VideoVariableRate frameRate;
    @XmlElement(name="samplerate",namespace="http://www.loc.gov/videoMD/")
    private final VideoVariableRate sampleRate;
    @XmlElement(name="sampling",namespace="http://www.loc.gov/videoMD/")
    private final String sampling;
    @XmlElement(name="samplecount",namespace="http://www.loc.gov/videoMD/")
    private final int sampleCount;
    @XmlElement(name="signalformat",namespace="http://www.loc.gov/videoMD/")
    private final String signalFormat;

    private VideoTrack(){
        super();
        this.id = null;
        this.num = 0;
        this.type = null;
        this.bitsPerSample = 0;
        this.bitsPerPixelStored = 0;
        this.codec = null;
        this.compressionRatio = 0;
        this.quality = null;
        this.frame = null;
        this.frameRate = null;
        this.sampleRate = null;
        this.sampling = null;
        this.sampleCount = 0;
        this.signalFormat = null;
    }
    
    private VideoTrack(Builder builder) {
        this.id = builder.id;
        this.num = builder.num;
        this.type = builder.type;
        this.bitsPerSample = builder.bitsPerSample;
        this.bitsPerPixelStored = builder.bitsPerPixelStored;
        this.codec = builder.codec;
        this.compressionRatio = builder.compressionRatio;
        this.quality = builder.quality;
        this.frame = builder.frame;
        this.frameRate = builder.frameRate;
        this.sampleRate = builder.sampleRate;
        this.sampling = builder.sampling;
        this.sampleCount = builder.sampleCount;
        this.signalFormat = builder.signalFormat;
    }

    public float getBitsPerPixelStored() {
        return bitsPerPixelStored;
    }

    public int getBitsPerSample() {
        return bitsPerSample;
    }

    public VideoCodec getCodec() {
        return codec;
    }

    public float getCompressionRatio() {
        return compressionRatio;
    }

    public VideoFrame getFrame() {
        return frame;
    }

    public VideoVariableRate getFrameRate() {
        return frameRate;
    }

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getQuality() {
        return quality;
    }

    public int getSampleCount() {
        return sampleCount;
    }

    public VideoVariableRate getSampleRate() {
        return sampleRate;
    }

    public String getSampling() {
        return sampling;
    }

    public String getSignalFormat() {
        return signalFormat;
    }
    

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Float.floatToIntBits(bitsPerPixelStored);
        result = prime * result + bitsPerSample;
        result = prime * result + ((codec == null) ? 0 : codec.hashCode());
        result = prime * result + Float.floatToIntBits(compressionRatio);
        result = prime * result + ((frame == null) ? 0 : frame.hashCode());
        result = prime * result + ((frameRate == null) ? 0 : frameRate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + num;
        result = prime * result + ((quality == null) ? 0 : quality.hashCode());
        result = prime * result + sampleCount;
        result = prime * result + ((sampleRate == null) ? 0 : sampleRate.hashCode());
        result = prime * result + ((sampling == null) ? 0 : sampling.hashCode());
        result = prime * result + ((signalFormat == null) ? 0 : signalFormat.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        VideoTrack other = (VideoTrack) obj;
        if (Float.floatToIntBits(bitsPerPixelStored) != Float.floatToIntBits(other.bitsPerPixelStored))
            return false;
        if (bitsPerSample != other.bitsPerSample)
            return false;
        if (codec == null) {
            if (other.codec != null)
                return false;
        } else if (!codec.equals(other.codec))
            return false;
        if (Float.floatToIntBits(compressionRatio) != Float.floatToIntBits(other.compressionRatio))
            return false;
        if (frame == null) {
            if (other.frame != null)
                return false;
        } else if (!frame.equals(other.frame))
            return false;
        if (frameRate == null) {
            if (other.frameRate != null)
                return false;
        } else if (!frameRate.equals(other.frameRate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (num != other.num)
            return false;
        if (quality == null) {
            if (other.quality != null)
                return false;
        } else if (!quality.equals(other.quality))
            return false;
        if (sampleCount != other.sampleCount)
            return false;
        if (sampleRate == null) {
            if (other.sampleRate != null)
                return false;
        } else if (!sampleRate.equals(other.sampleRate))
            return false;
        if (sampling == null) {
            if (other.sampling != null)
                return false;
        } else if (!sampling.equals(other.sampling))
            return false;
        if (signalFormat == null) {
            if (other.signalFormat != null)
                return false;
        } else if (!signalFormat.equals(other.signalFormat))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    public static class Builder {
        private String id;
        private int num;
        private String type;
        private int bitsPerSample;
        private float bitsPerPixelStored;
        private VideoCodec codec;
        private float compressionRatio;
        private String quality;
        private VideoFrame frame;
        private VideoVariableRate frameRate;
        private VideoVariableRate sampleRate;
        private String sampling;
        private int sampleCount;
        private String signalFormat;

        public Builder bitsPerPixelStored(float bitsPerPixelStored) {
            this.bitsPerPixelStored = bitsPerPixelStored;
            return this;
        }

        public Builder bitsPerSample(int bitsPerSample) {
            this.bitsPerSample = bitsPerSample;
            return this;
        }

        public VideoTrack build() {
            return new VideoTrack(this);
        }

        public Builder codec(VideoCodec codec) {
            this.codec = codec;
            return this;
        }

        public Builder compressionRatio(float compressionRatio) {
            this.compressionRatio = compressionRatio;
            return this;
        }

        public Builder frame(VideoFrame frame) {
            this.frame = frame;
            return this;
        }

        public Builder frameRate(VideoVariableRate frameRate) {
            this.frameRate = frameRate;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder num(int num) {
            this.num = num;
            return this;
        }

        public Builder quality(String quality) {
            this.quality = quality;
            return this;
        }

        public Builder sampleCount(int sampleCount) {
            this.sampleCount = sampleCount;
            return this;
        }

        public Builder sampleRate(VideoVariableRate sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        public Builder sampling(String sampling) {
            this.sampling = sampling;
            return this;
        }

        public Builder signalFormat(String signalFormat) {
            this.signalFormat = signalFormat;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
    }
}
