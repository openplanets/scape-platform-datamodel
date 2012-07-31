package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="compression",namespace="http://www.loc.gov/AMD/")
public class Compression {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name="codeccreatorapp",namespace="http://www.loc.gov/AMD/")
    private final List<String> codecCreatorApps;
    @XmlElement(name="codeccreatorappversion",namespace="http://www.loc.gov/AMD/")
    private final List<String> codecCreatorAppVersions;
    @XmlElement(name="codecname",namespace="http://www.loc.gov/AMD/")
    private final List<String> codecNames;
    @XmlElement(name="codecquality",namespace="http://www.loc.gov/AMD/")
    private final List<CodecQuality> codecQualities;

    private Compression() {
        super();
        this.id=null;
        this.codecCreatorApps=null;
        this.codecCreatorAppVersions=null;
        this.codecNames=null;
        this.codecQualities=null;
    }

    private Compression(Builder builder) {
        this.id = builder.id;
        this.codecCreatorApps = builder.codecCreatorApps;
        this.codecCreatorAppVersions = builder.codecCreatorAppVersions;
        this.codecNames = builder.codecNames;
        this.codecQualities = builder.codecQualities;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Compression other = (Compression) obj;
        if (codecCreatorAppVersions == null) {
            if (other.codecCreatorAppVersions != null)
                return false;
        } else if (!codecCreatorAppVersions.equals(other.codecCreatorAppVersions))
            return false;
        if (codecCreatorApps == null) {
            if (other.codecCreatorApps != null)
                return false;
        } else if (!codecCreatorApps.equals(other.codecCreatorApps))
            return false;
        if (codecNames == null) {
            if (other.codecNames != null)
                return false;
        } else if (!codecNames.equals(other.codecNames))
            return false;
        if (codecQualities == null) {
            if (other.codecQualities != null)
                return false;
        } else if (!codecQualities.equals(other.codecQualities))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codecCreatorAppVersions == null) ? 0 : codecCreatorAppVersions.hashCode());
        result = prime * result + ((codecCreatorApps == null) ? 0 : codecCreatorApps.hashCode());
        result = prime * result + ((codecNames == null) ? 0 : codecNames.hashCode());
        result = prime * result + ((codecQualities == null) ? 0 : codecQualities.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
