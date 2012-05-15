package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="filedata",namespace="http://www.loc.gov/AMD/")
public class FileData {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="audioblocksize",namespace="http://www.loc.gov/AMD/")
    private List<Integer> audiBlockSizes;
    @XmlElement(name="audiodataencoding",namespace="http://www.loc.gov/AMD/")
    private List<String> audioDataEncodings;
    @XmlElement(name="bitspersample",namespace="http://www.loc.gov/AMD/")
    private List<Integer> bitsPerSamples;
    @XmlElement(name="byteorder",namespace="http://www.loc.gov/AMD/")
    private List<Integer> byteOrders;
    @XmlElement(name="messagedigest",namespace="http://www.loc.gov/AMD/")
    private List<MessageDigest> messageDigest;
    @XmlElement(name="compression",namespace="http://www.loc.gov/AMD/")
    private List<Compression> compression;
    @XmlElement(name="datarates",namespace="http://www.loc.gov/AMD/")
    private List<Integer> dataRates;
    @XmlElement(name="dataratemode",namespace="http://www.loc.gov/AMD/")
    private List<DataRateMode> dataRateModes;
    @XmlElement(name="firstsamploffset",namespace="http://www.loc.gov/AMD/")
    private List<Integer> firstSampleOffsets;
    @XmlElement(name="firstvalidbyteblock",namespace="http://www.loc.gov/AMD/")
    private List<Integer> firstValidByteBlocks;
    @XmlElement(name="formatlocation",namespace="http://www.loc.gov/AMD/")
    private List<String> formatLocations;
    @XmlElement(name="formatname",namespace="http://www.loc.gov/AMD/")
    private List<String> formatNames;
    @XmlElement(name="formatversion",namespace="http://www.loc.gov/AMD/")
    private List<String> formatVersions;
    @XmlElement(name="lastvalidbyteblock",namespace="http://www.loc.gov/AMD/")
    private List<Integer> lastValidByteBlocks;
    @XmlElement(name="numsampleframe",namespace="http://www.loc.gov/AMD/")
    private List<Integer> numSampleFrames;
    @XmlElement(name="samplingfrequency",namespace="http://www.loc.gov/AMD/")
    private List<Float> samplingFrequencies;
    @XmlElement(name="security",namespace="http://www.loc.gov/AMD/")
    private List<String> securities;
    @XmlElement(name="use",namespace="http://www.loc.gov/AMD/")
    private List<String> uses;
    @XmlElement(name="otheruse",namespace="http://www.loc.gov/AMD/")
    private List<String> otherUses;
    @XmlElement(name="wordsize",namespace="http://www.loc.gov/AMD/")
    private List<Integer> wordSizes;

    private FileData() {
        super();
    }

    private FileData(Builder builder) {
        this.id = builder.id;
        this.audiBlockSizes = builder.audiBlockSizes;
        this.audioDataEncodings = builder.audioDataEncodings;
        this.bitsPerSamples = builder.bitsPerSamples;
        this.byteOrders = builder.byteOrders;
        this.messageDigest = builder.messageDigest;
        this.compression = builder.compression;
        this.dataRates = builder.dataRates;
        this.dataRateModes = builder.dataRateModes;
        this.firstSampleOffsets = builder.firstSampleOffsets;
        this.firstValidByteBlocks = builder.firstValidByteBlocks;
        this.formatLocations = builder.formatLocations;
        this.formatNames = builder.formatNames;
        this.formatVersions = builder.formatVersions;
        this.lastValidByteBlocks = builder.lastValidByteBlocks;
        this.numSampleFrames = builder.numSampleFrames;
        this.samplingFrequencies = builder.samplingFrequencies;
        this.securities = builder.securities;
        this.uses = builder.uses;
        this.otherUses = builder.otherUses;
        this.wordSizes = builder.wordSizes;
    }

    public List<Integer> getAudiBlockSizes() {
        return audiBlockSizes;
    }

    public List<String> getAudioDataEncodings() {
        return audioDataEncodings;
    }

    public List<Integer> getBitsPerSamples() {
        return bitsPerSamples;
    }

    public List<Integer> getByteOrders() {
        return byteOrders;
    }

    public List<Compression> getCompression() {
        return compression;
    }

    public List<DataRateMode> getDataRateModes() {
        return dataRateModes;
    }

    public List<Integer> getDataRates() {
        return dataRates;
    }

    public List<Integer> getFirstSampleOffsets() {
        return firstSampleOffsets;
    }

    public List<Integer> getFirstValidByteBlocks() {
        return firstValidByteBlocks;
    }

    public List<String> getFormatLocations() {
        return formatLocations;
    }

    public List<String> getFormatNames() {
        return formatNames;
    }

    public List<String> getFormatVersions() {
        return formatVersions;
    }

    public String getId() {
        return id;
    }

    public List<Integer> getLastValidByteBlocks() {
        return lastValidByteBlocks;
    }

    public List<MessageDigest> getMessageDigest() {
        return messageDigest;
    }

    public List<Integer> getNumSampleFrames() {
        return numSampleFrames;
    }

    public List<String> getOtherUses() {
        return otherUses;
    }

    public List<Float> getSamplingFrequencies() {
        return samplingFrequencies;
    }

    public List<String> getSecurities() {
        return securities;
    }

    public List<String> getUses() {
        return uses;
    }

    public List<Integer> getWordSizes() {
        return wordSizes;
    }

    public static class Builder {
        private final String id;
        private List<Integer> audiBlockSizes;
        private List<String> audioDataEncodings;
        private List<Integer> bitsPerSamples;
        private List<Integer> byteOrders;
        private List<MessageDigest> messageDigest;
        private List<Compression> compression;
        private List<Integer> dataRates;
        private List<DataRateMode> dataRateModes;
        private List<Integer> firstSampleOffsets;
        private List<Integer> firstValidByteBlocks;
        private List<String> formatLocations;
        private List<String> formatNames;
        private List<String> formatVersions;
        private List<Integer> lastValidByteBlocks;
        private List<Integer> numSampleFrames;
        private List<Float> samplingFrequencies;
        private List<String> securities;
        private List<String> uses;
        private List<String> otherUses;
        private List<Integer> wordSizes;

        public Builder(String id) {
            super();
            this.id = id;
        }

        public Builder audiBlockSizes(List<Integer> audiBlockSizes) {
            this.audiBlockSizes = audiBlockSizes;
            return this;
        }

        public Builder audioDataEncodings(List<String> audioDataEncodings) {
            this.audioDataEncodings = audioDataEncodings;
            return this;
        }

        public Builder bitsPerSamples(List<Integer> bitsPerSamples) {
            this.bitsPerSamples = bitsPerSamples;
            return this;
        }

        public FileData build() {
            return new FileData(this);
        }

        public Builder byteOrders(List<Integer> byteOrders) {
            this.byteOrders = byteOrders;
            return this;
        }

        public Builder compression(List<Compression> compression) {
            this.compression = compression;
            return this;
        }

        public Builder dataRateModes(List<DataRateMode> dataRateModes) {
            this.dataRateModes = dataRateModes;
            return this;
        }

        public Builder dataRates(List<Integer> dataRates) {
            this.dataRates = dataRates;
            return this;
        }

        public Builder firstSampleOffsets(List<Integer> firstSampleOffsets) {
            this.firstSampleOffsets = firstSampleOffsets;
            return this;
        }

        public Builder firstValidByteBlocks(List<Integer> firstValidByteBlocks) {
            this.firstValidByteBlocks = firstValidByteBlocks;
            return this;
        }

        public Builder formatLocations(List<String> formatLocations) {
            this.formatLocations = formatLocations;
            return this;
        }

        public Builder formatNames(List<String> formatNames) {
            this.formatNames = formatNames;
            return this;
        }

        public Builder formatVersions(List<String> formatVersions) {
            this.formatVersions = formatVersions;
            return this;
        }

        public Builder lastValidByteBlocks(List<Integer> lastValidByteBlocks) {
            this.lastValidByteBlocks = lastValidByteBlocks;
            return this;
        }

        public Builder messageDigest(List<MessageDigest> messageDigest) {
            this.messageDigest = messageDigest;
            return this;
        }

        public Builder numSampleFrames(List<Integer> numSampleFrames) {
            this.numSampleFrames = numSampleFrames;
            return this;
        }

        public Builder otherUses(List<String> otherUses) {
            this.otherUses = otherUses;
            return this;
        }

        public Builder samplingFrequencies(List<Float> samplingFrequencies) {
            this.samplingFrequencies = samplingFrequencies;
            return this;
        }

        public Builder securities(List<String> securities) {
            this.securities = securities;
            return this;
        }

        public Builder uses(List<String> uses) {
            this.uses = uses;
            return this;
        }

        public Builder wordSizes(List<Integer> wordSizes) {
            this.wordSizes = wordSizes;
            return this;
        }
    }

    public enum DataRateMode {
        FIXED, VARIABLE;
    }
}
