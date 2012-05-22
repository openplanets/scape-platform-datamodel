package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="track",namespace="http://www.loc.gov/videoMD/")
public class VideoTrack extends MediaDataType {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name="num",namespace="http://www.loc.gov/videoMD/")
    private int num;
    @XmlElement(name="type",namespace="http://www.loc.gov/videoMD/")
    private String type;
    @XmlElement(name="bitspersample",namespace="http://www.loc.gov/videoMD/")
    private int bitsPerSample;
    @XmlElement(name="bitsperpixelstored",namespace="http://www.loc.gov/videoMD/")
    private float bitsPerPixelStored;
    @XmlElement(name="codec",namespace="http://www.loc.gov/videoMD/")
    private VideoCodec codec;
    @XmlElement(name="compressionratio",namespace="http://www.loc.gov/videoMD/")
    private float compressionRatio;
    @XmlElement(name="quality",namespace="http://www.loc.gov/videoMD/")
    private String quality;
    @XmlElement(name="frame",namespace="http://www.loc.gov/videoMD/")
    private VideoFrame frame;
    @XmlElement(name="framerate",namespace="http://www.loc.gov/videoMD/")
    private VideoVariableRate frameRate;
    @XmlElement(name="samplerate",namespace="http://www.loc.gov/videoMD/")
    private VideoVariableRate sampleRate;
    @XmlElement(name="sampling",namespace="http://www.loc.gov/videoMD/")
    private String sampling;
    @XmlElement(name="samplecount",namespace="http://www.loc.gov/videoMD/")
    private int sampleCount;
    @XmlElement(name="signalformat",namespace="http://www.loc.gov/videoMD/")
    private String signalFormat;

    private VideoTrack(){
        super();
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
