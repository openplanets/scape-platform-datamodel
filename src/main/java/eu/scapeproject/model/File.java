package eu.scapeproject.model;

import java.util.Set;

import eu.scapeproject.model.metadata.TechnicalMetadata;

public class File {
    private TechnicalMetadata technical;
    private Set<BitStream> bitStreams;

    private File(){
        super();
    }
    
    private File(Builder builder) {
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
    }

    public Set<BitStream> getBitStreams() {
        return bitStreams;
    }

    public TechnicalMetadata getTechnical() {
        return technical;
    }

    public static class Builder {
        private TechnicalMetadata technical;
        private Set<BitStream> bitStreams;

        public Builder bitStreams(Set<BitStream> bitStreams) {
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
    }
}
