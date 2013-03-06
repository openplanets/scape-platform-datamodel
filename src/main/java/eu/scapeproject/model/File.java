package eu.scapeproject.model;

import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.util.CopyUtil;

@XmlRootElement(name = "file", namespace = "http://scapeproject.eu/model")
public class File {

    @XmlElement(name = "technical", namespace = "http://scapeproject.eu/model")
    private final Object technical;
    @XmlElement(name = "bitstream", namespace = "http://scapeproject.eu/model")
    private final List<BitStream> bitStreams;
    @XmlElement(name = "uri", namespace = "http://scapeproject.eu/model")
    private final URI uri;
    @XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
    private final Identifier identifier;

    private File() {
        this.technical = null;
        this.bitStreams = null;
        this.uri = null;
        this.identifier = null;
    }

    private File(Builder builder) {
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
        this.uri = builder.uri;
        this.identifier = builder.identifier;
    }

    public List<BitStream> getBitStreams() {
        return bitStreams;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Object getTechnical() {
        return technical;
    }

    public URI getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "File [technical=" + technical
                + ", bitStreams=" + bitStreams
                + ", uri=" + uri
                + ", identifier=" + identifier
                + "]";
    }

    public static class Builder {
        private Object technical;
        private List<BitStream> bitStreams;
        private URI uri;
        private Identifier identifier;

        public Builder() {
            super();
        }

        public Builder(File orig) {
            File copy = CopyUtil.deepCopy(File.class, orig);
            this.technical = copy.technical;
            this.bitStreams = copy.bitStreams;
            this.uri = copy.uri;
            this.identifier = copy.identifier;
        }

        public Builder bitStream(BitStream bitStream) {
            this.bitStreams.add(bitStream);
            return this;
        }

        public Builder bitStreams(List<BitStream> bitStreams) {
            this.bitStreams = bitStreams;
            return this;
        }

        public File build() {
            if (bitStreams != null && bitStreams.size() == 0) {
                bitStreams = null;
            }
            return new File(this);
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder technical(Object technical) {
            this.technical = technical;
            return this;
        }

        public Builder uri(URI uri) {
            this.uri = uri;
            return this;
        }
    }
}
