package eu.scapeproject.model;

import java.net.URI;
import java.util.List;
import java.util.Set;

import eu.scapeproject.model.metadata.TechnicalMetadata;

public class File {
    private TechnicalMetadata technical;
    private List<BitStream> bitStreams;
    private List<URI> uris;

    private File() {
        super();
    }

    private File(Builder builder) {
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
        this.uris = builder.uris;
    }

    public List<BitStream> getBitStreams() {
        return bitStreams;
    }

    public TechnicalMetadata getTechnical() {
        return technical;
    }

    public List<URI> getUris() {
        return uris;
    }

    public static class Builder {
        private TechnicalMetadata technical;
        private List<BitStream> bitStreams;
        private List<URI> uris;

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

        public Builder uri(List<URI> uris) {
            this.uris = uris;
            return this;
        }
    }
}
