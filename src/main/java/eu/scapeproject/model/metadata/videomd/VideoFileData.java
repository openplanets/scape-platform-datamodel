package eu.scapeproject.model.metadata.videomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "filedata", namespace = "http://www.loc.gov/videoMD/")
public class VideoFileData extends MediaDataType {
    @XmlElement(name = "bitspersample", namespace = "http://www.loc.gov/videoMD/")
    private List<Integer> bitsPerSample;
    @XmlElement(name = "byteorder", namespace = "http://www.loc.gov/videoMD/")
    private List<Integer> byteOrder;
    @XmlElement(name = "color", namespace = "http://www.loc.gov/videoMD/")
    private String color;
    @XmlElement(name = "othercolor", namespace = "http://www.loc.gov/videoMD/")
    private String otherColor;
    @XmlElement(name = "messaegdigest", namespace = "http://www.loc.gov/videoMD/")
    private VideoMessageDigest messageDigest;
    @XmlElement(name = "compression", namespace = "http://www.loc.gov/videoMD/")
    private List<VideoCompression> comressions;
    @XmlElement(name = "track", namespace = "http://www.loc.gov/videoMD/")
    private List<VideoTrack> tracks;
    @XmlElement(name = "datarateunit", namespace = "http://www.loc.gov/videoMD/")
    private List<String> dataRateUnit;
    @XmlElement(name = "dataratemode", namespace = "http://www.loc.gov/videoMD/")
    private List<String> dataRateMode;
    @XmlElement(name = "frame", namespace = "http://www.loc.gov/videoMD/")
    private VideoFrame frame;
    @XmlElement(name = "framerate", namespace = "http://www.loc.gov/videoMD/")
    private VideoVariableRate frameRate;
    @XmlElement(name = "samplerate", namespace = "http://www.loc.gov/videoMD/")
    private VideoVariableRate sampleRate;
    @XmlElement(name = "location", namespace = "http://www.loc.gov/videoMD/")
    private List<String> locations;
    @XmlElement(name = "format", namespace = "http://www.loc.gov/videoMD/")
    private List<VideoFormat> formats;
    @XmlElement(name = "sampling", namespace = "http://www.loc.gov/videoMD/")
    private List<String> sampling;
    @XmlElement(name = "signalformat", namespace = "http://www.loc.gov/videoMD/")
    private List<String> signalFormat;
    @XmlElement(name = "sound", namespace = "http://www.loc.gov/videoMD/")
    private List<String> sound;

    private VideoFileData() {
        super();
    }

    private VideoFileData(Builder builder) {
        this.bitsPerSample = builder.bitsPerSample;
        this.byteOrder = builder.byteOrder;
        this.color = builder.color;
        this.otherColor = builder.otherColor;
        this.messageDigest = builder.messageDigest;
        this.comressions = builder.comressions;
        this.tracks = builder.tracks;
        this.dataRateUnit = builder.dataRateUnit;
        this.dataRateMode = builder.dataRateMode;
        this.frame = builder.frame;
        this.frameRate = builder.frameRate;
        this.sampleRate = builder.sampleRate;
        this.locations = builder.locations;
        this.formats = builder.formats;
        this.sampling = builder.sampling;
        this.signalFormat = builder.signalFormat;
        this.sound = builder.sound;
        this.trackingInfos = builder.trackingInfos;
        this.duration = builder.duration;
        this.language = builder.languages;
        this.security = builder.security;
        this.size = builder.size;
        this.dataRate = builder.dataRate;
        this.otherUses = builder.otherUses;
        this.timeCodes = builder.timeCodes;
        this.uses = builder.uses;

    }

    public List<Integer> getBitsPerSample() {
        return bitsPerSample;
    }

    public List<Integer> getByteOrder() {
        return byteOrder;
    }

    public String getColor() {
        return color;
    }

    public List<VideoCompression> getComressions() {
        return comressions;
    }

    public List<String> getDataRateMode() {
        return dataRateMode;
    }

    public List<String> getDataRateUnit() {
        return dataRateUnit;
    }

    public List<VideoFormat> getFormats() {
        return formats;
    }

    public VideoFrame getFrame() {
        return frame;
    }

    public VideoVariableRate getFrameRate() {
        return frameRate;
    }

    public List<String> getLocations() {
        return locations;
    }

    public VideoMessageDigest getMessageDigest() {
        return messageDigest;
    }

    public String getOtherColor() {
        return otherColor;
    }

    public VideoVariableRate getSampleRate() {
        return sampleRate;
    }

    public List<String> getSampling() {
        return sampling;
    }

    public List<String> getSignalFormat() {
        return signalFormat;
    }

    public List<String> getSound() {
        return sound;
    }

    public List<VideoTrack> getTracks() {
        return tracks;
    }

    public static class Builder {
        private List<Integer> bitsPerSample;
        private List<Integer> byteOrder;
        private String color;
        private String otherColor;
        private VideoMessageDigest messageDigest;
        private List<VideoCompression> comressions;
        private List<VideoTrack> tracks;
        private List<String> dataRateUnit;
        private List<String> dataRateMode;
        private VideoFrame frame;
        private VideoVariableRate frameRate;
        private VideoVariableRate sampleRate;
        private List<String> locations;
        private List<VideoFormat> formats;
        private List<String> sampling;
        private List<String> signalFormat;
        private List<String> sound;
        private List<VideoTrackingInfo> trackingInfos;
        private String duration;
        private List<VideoLanguage> languages;
        private String security;
        private int size;
        private VideoVariableRate dataRate;
        private List<VideoTimeCode> timeCodes;
        private List<String> uses;
        private List<String> otherUses;

        public Builder duration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder trackingInfos(List<VideoTrackingInfo> trackingInfos) {
            this.trackingInfos = trackingInfos;
            return this;
        }

        public Builder language(List<VideoLanguage> languages) {
            this.languages = languages;
            return this;
        }

        public Builder security(String security) {
            this.security = security;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder dataRate(VideoVariableRate dataRate) {
            this.dataRate = dataRate;
            return this;
        }

        public Builder timeCodes(List<VideoTimeCode> timeCodes) {
            this.timeCodes = timeCodes;
            return this;
        }

        public Builder uses(List<String> uses) {
            this.uses = uses;
            return this;
        }
        
        public Builder otherUses(List<String> otherUses){
            this.otherUses=otherUses;
            return this;
        }

        public Builder bitsPerSample(List<Integer> bitsPerSample) {
            this.bitsPerSample = bitsPerSample;
            return this;
        }

        public VideoFileData build() {
            return new VideoFileData(this);
        }

        public Builder byteOrder(List<Integer> byteOrder) {
            this.byteOrder = byteOrder;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder comressions(List<VideoCompression> comressions) {
            this.comressions = comressions;
            return this;
        }

        public Builder dataRateMode(List<String> dataRateMode) {
            this.dataRateMode = dataRateMode;
            return this;
        }

        public Builder dataRateUnit(List<String> dataRateUnit) {
            this.dataRateUnit = dataRateUnit;
            return this;
        }

        public Builder formats(List<VideoFormat> formats) {
            this.formats = formats;
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

        public Builder locations(List<String> locations) {
            this.locations = locations;
            return this;
        }

        public Builder messageDigest(VideoMessageDigest messageDigest) {
            this.messageDigest = messageDigest;
            return this;
        }

        public Builder otherColor(String otherColor) {
            this.otherColor = otherColor;
            return this;
        }

        public Builder sampleRate(VideoVariableRate sampleRate) {
            this.sampleRate = sampleRate;
            return this;
        }

        public Builder sampling(List<String> sampling) {
            this.sampling = sampling;
            return this;
        }

        public Builder signalFormat(List<String> signalFormat) {
            this.signalFormat = signalFormat;
            return this;
        }

        public Builder sound(List<String> sound) {
            this.sound = sound;
            return this;
        }

        public Builder tracks(List<VideoTrack> tracks) {
            this.tracks = tracks;
            return this;
        }
    }
}
