package eu.scapeproject.model;

import java.net.URI;
import java.util.List;

import eu.scapeproject.model.metadata.TechnicalMetadata;

public class File {
    private final TechnicalMetadata technical;
    private final List<BitStream> bitStreams;
    private final URI uri;

    private File() {
        this.technical=null;
        this.bitStreams=null;
        this.uri=null;
    }

    private File(Builder builder) {
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
        this.uri = builder.uri;
    }

    public List<BitStream> getBitStreams() {
        return bitStreams;
    }

    public TechnicalMetadata getTechnical() {
        return technical;
    }

    public URI getUri() {
        return uri;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bitStreams == null) ? 0 : bitStreams.hashCode());
        result = prime * result + ((technical == null) ? 0 : technical.hashCode());
        result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
        File other = (File) obj;
        if (bitStreams == null) {
            if (other.bitStreams != null)
                return false;
        } else if (!bitStreams.equals(other.bitStreams))
            return false;
        if (technical == null) {
            if (other.technical != null)
                return false;
        } else if (!technical.equals(other.technical))
            return false;
        if (uri == null) {
            if (other.uri != null)
                return false;
        } else if (!uri.equals(other.uri))
            return false;
        return true;
    }

    public static class Builder {
        private TechnicalMetadata technical;
        private List<BitStream> bitStreams;
        private URI uri;

        public Builder bitStreams(List<BitStream> bitStreams) {
            this.bitStreams = bitStreams;
            return this;
        }

        public File build() {
            return new File(this);
        }

        public Builder technical(TechnicalMetadata technical) {
            this.technical = technical;
            return this;
        }

        public Builder uri(URI uri) {
            this.uri = uri;
            return this;
        }
    }
}
