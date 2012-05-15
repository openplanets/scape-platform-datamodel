package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="compression",namespace="http://www.loc.gov/AMD/")
public class Compression {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="codeccreatorapp",namespace="http://www.loc.gov/AMD/")
    private List<String> codecCreatorApps;
    @XmlElement(name="codeccreatorappversion",namespace="http://www.loc.gov/AMD/")
    private List<String> codecCreatorAppVersions;
    @XmlElement(name="codecname",namespace="http://www.loc.gov/AMD/")
    private List<String> codecNames;
    @XmlElement(name="codecquality",namespace="http://www.loc.gov/AMD/")
    private List<CodecQuality> codecQualities;

    private Compression() {
        super();
    }

    private Compression(Builder builder) {
        this.id = builder.id;
        this.codecCreatorApps = builder.codecCreatorApps;
        this.codecCreatorAppVersions = builder.codecCreatorAppVersions;
        this.codecNames = builder.codecNames;
        this.codecQualities = builder.codecQualities;
    }

    public List<String> getCodecCreatorApps() {
        return codecCreatorApps;
    }

    public List<String> getCodecCreatorAppVersions() {
        return codecCreatorAppVersions;
    }

    public List<String> getCodecNames() {
        return codecNames;
    }

    public List<CodecQuality> getCodecQualities() {
        return codecQualities;
    }

    public String getId() {
        return id;
    }

    public static class Builder {
        private final String id;
        private List<String> codecCreatorApps;
        private List<String> codecCreatorAppVersions;
        private List<String> codecNames;
        private List<CodecQuality> codecQualities;

        public Builder(String id) {
            super();
            this.id = id;
        }

        public Compression build() {
            return new Compression(this);
        }

        public Builder codecCreatorApps(List<String> codecCreatorApps) {
            this.codecCreatorApps = codecCreatorApps;
            return this;
        }

        public Builder codecCreatorAppVersions(List<String> codecCreatorAppVersions) {
            this.codecCreatorAppVersions = codecCreatorAppVersions;
            return this;
        }

        public Builder codecNames(List<String> codecNames) {
            this.codecNames = codecNames;
            return this;
        }

        public Builder codecQualities(List<CodecQuality> codecQualities) {
            this.codecQualities = codecQualities;
            return this;
        }

    }

    public enum CodecQuality {
        LOSSY, LOSSLESS;
    }
}
