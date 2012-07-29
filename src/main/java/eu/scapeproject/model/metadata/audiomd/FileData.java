package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="filedata",namespace="http://www.loc.gov/AMD/")
public class FileData {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name="audioblocksize",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> audiBlockSizes;
    @XmlElement(name="audiodataencoding",namespace="http://www.loc.gov/AMD/")
    private final List<String> audioDataEncodings;
    @XmlElement(name="bitspersample",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> bitsPerSamples;
    @XmlElement(name="byteorder",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> byteOrders;
    @XmlElement(name="messagedigest",namespace="http://www.loc.gov/AMD/")
    private final List<MessageDigest> messageDigest;
    @XmlElement(name="compression",namespace="http://www.loc.gov/AMD/")
    private final List<Compression> compression;
    @XmlElement(name="datarates",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> dataRates;
    @XmlElement(name="dataratemode",namespace="http://www.loc.gov/AMD/")
    private final List<DataRateMode> dataRateModes;
    @XmlElement(name="firstsamploffset",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> firstSampleOffsets;
    @XmlElement(name="firstvalidbyteblock",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> firstValidByteBlocks;
    @XmlElement(name="formatlocation",namespace="http://www.loc.gov/AMD/")
    private final List<String> formatLocations;
    @XmlElement(name="formatname",namespace="http://www.loc.gov/AMD/")
    private final List<String> formatNames;
    @XmlElement(name="formatversion",namespace="http://www.loc.gov/AMD/")
    private final List<String> formatVersions;
    @XmlElement(name="lastvalidbyteblock",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> lastValidByteBlocks;
    @XmlElement(name="numsampleframe",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> numSampleFrames;
    @XmlElement(name="samplingfrequency",namespace="http://www.loc.gov/AMD/")
    private final List<Float> samplingFrequencies;
    @XmlElement(name="security",namespace="http://www.loc.gov/AMD/")
    private final List<String> securities;
    @XmlElement(name="use",namespace="http://www.loc.gov/AMD/")
    private final List<String> uses;
    @XmlElement(name="otheruse",namespace="http://www.loc.gov/AMD/")
    private final List<String> otherUses;
    @XmlElement(name="wordsize",namespace="http://www.loc.gov/AMD/")
    private final List<Integer> wordSizes;

    private FileData() {
        super();
        this.id=null;
        this.audiBlockSizes = null;
        this.audioDataEncodings = null;
        this.bitsPerSamples = null;
        this.byteOrders = null;
        this.messageDigest = null;
        this.compression = null;
        this.dataRates = null;
        this.dataRateModes = null;
        this.firstSampleOffsets = null;
        this.firstValidByteBlocks = null;
        this.formatLocations = null;
        this.formatNames = null;
        this.formatVersions = null;
        this.lastValidByteBlocks = null;
        this.numSampleFrames = null;
        this.samplingFrequencies = null;
        this.securities = null;
        this.uses = null;
        this.otherUses = null;
        this.wordSizes = null;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((audiBlockSizes == null) ? 0 : audiBlockSizes.hashCode());
        result = prime * result + ((audioDataEncodings == null) ? 0 : audioDataEncodings.hashCode());
        result = prime * result + ((bitsPerSamples == null) ? 0 : bitsPerSamples.hashCode());
        result = prime * result + ((byteOrders == null) ? 0 : byteOrders.hashCode());
        result = prime * result + ((compression == null) ? 0 : compression.hashCode());
        result = prime * result + ((dataRateModes == null) ? 0 : dataRateModes.hashCode());
        result = prime * result + ((dataRates == null) ? 0 : dataRates.hashCode());
        result = prime * result + ((firstSampleOffsets == null) ? 0 : firstSampleOffsets.hashCode());
        result = prime * result + ((firstValidByteBlocks == null) ? 0 : firstValidByteBlocks.hashCode());
        result = prime * result + ((formatLocations == null) ? 0 : formatLocations.hashCode());
        result = prime * result + ((formatNames == null) ? 0 : formatNames.hashCode());
        result = prime * result + ((formatVersions == null) ? 0 : formatVersions.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastValidByteBlocks == null) ? 0 : lastValidByteBlocks.hashCode());
        result = prime * result + ((messageDigest == null) ? 0 : messageDigest.hashCode());
        result = prime * result + ((numSampleFrames == null) ? 0 : numSampleFrames.hashCode());
        result = prime * result + ((otherUses == null) ? 0 : otherUses.hashCode());
        result = prime * result + ((samplingFrequencies == null) ? 0 : samplingFrequencies.hashCode());
        result = prime * result + ((securities == null) ? 0 : securities.hashCode());
        result = prime * result + ((uses == null) ? 0 : uses.hashCode());
        result = prime * result + ((wordSizes == null) ? 0 : wordSizes.hashCode());
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
        FileData other = (FileData) obj;
        if (audiBlockSizes == null) {
            if (other.audiBlockSizes != null)
                return false;
        } else if (!audiBlockSizes.equals(other.audiBlockSizes))
            return false;
        if (audioDataEncodings == null) {
            if (other.audioDataEncodings != null)
                return false;
        } else if (!audioDataEncodings.equals(other.audioDataEncodings))
            return false;
        if (bitsPerSamples == null) {
            if (other.bitsPerSamples != null)
                return false;
        } else if (!bitsPerSamples.equals(other.bitsPerSamples))
            return false;
        if (byteOrders == null) {
            if (other.byteOrders != null)
                return false;
        } else if (!byteOrders.equals(other.byteOrders))
            return false;
        if (compression == null) {
            if (other.compression != null)
                return false;
        } else if (!compression.equals(other.compression))
            return false;
        if (dataRateModes == null) {
            if (other.dataRateModes != null)
                return false;
        } else if (!dataRateModes.equals(other.dataRateModes))
            return false;
        if (dataRates == null) {
            if (other.dataRates != null)
                return false;
        } else if (!dataRates.equals(other.dataRates))
            return false;
        if (firstSampleOffsets == null) {
            if (other.firstSampleOffsets != null)
                return false;
        } else if (!firstSampleOffsets.equals(other.firstSampleOffsets))
            return false;
        if (firstValidByteBlocks == null) {
            if (other.firstValidByteBlocks != null)
                return false;
        } else if (!firstValidByteBlocks.equals(other.firstValidByteBlocks))
            return false;
        if (formatLocations == null) {
            if (other.formatLocations != null)
                return false;
        } else if (!formatLocations.equals(other.formatLocations))
            return false;
        if (formatNames == null) {
            if (other.formatNames != null)
                return false;
        } else if (!formatNames.equals(other.formatNames))
            return false;
        if (formatVersions == null) {
            if (other.formatVersions != null)
                return false;
        } else if (!formatVersions.equals(other.formatVersions))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (lastValidByteBlocks == null) {
            if (other.lastValidByteBlocks != null)
                return false;
        } else if (!lastValidByteBlocks.equals(other.lastValidByteBlocks))
            return false;
        if (messageDigest == null) {
            if (other.messageDigest != null)
                return false;
        } else if (!messageDigest.equals(other.messageDigest))
            return false;
        if (numSampleFrames == null) {
            if (other.numSampleFrames != null)
                return false;
        } else if (!numSampleFrames.equals(other.numSampleFrames))
            return false;
        if (otherUses == null) {
            if (other.otherUses != null)
                return false;
        } else if (!otherUses.equals(other.otherUses))
            return false;
        if (samplingFrequencies == null) {
            if (other.samplingFrequencies != null)
                return false;
        } else if (!samplingFrequencies.equals(other.samplingFrequencies))
            return false;
        if (securities == null) {
            if (other.securities != null)
                return false;
        } else if (!securities.equals(other.securities))
            return false;
        if (uses == null) {
            if (other.uses != null)
                return false;
        } else if (!uses.equals(other.uses))
            return false;
        if (wordSizes == null) {
            if (other.wordSizes != null)
                return false;
        } else if (!wordSizes.equals(other.wordSizes))
            return false;
        return true;
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
