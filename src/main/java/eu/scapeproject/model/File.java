package eu.scapeproject.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name="file",namespace="http://scapeproject.eu/model")
public class File {
	@XmlElement(name="technical",namespace="http://scapeproject.eu/model")
    private final TechnicalMetadata technical;
	@XmlElement(name="bitstream",namespace="http://scapeproject.eu/model")
    private final List<BitStream> bitStreams;
	@XmlElement(name="uri",namespace="http://scapeproject.eu/model")
    private final URI uri;
	@XmlElement(name="identifier",namespace="http://scapeproject.eu/model")
    private final Identifier identifier;

    private File() {
        this.technical=null;
        this.bitStreams=null;
        this.uri=null;
        this.identifier=null;
    }

    private File(Builder builder) {
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
        this.uri = builder.uri;
        this.identifier=builder.identifier;
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
        if (identifier == null) {
            if (other.identifier != null)
                return false;
        } else if (!identifier.equals(other.identifier))
            return false;
        return true;
    }

    public List<BitStream> getBitStreams() {
        return bitStreams;
    }

    public Identifier getIdentifier() {
        return identifier;
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
        result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
        return result;
    }

    public static class Builder {
        private TechnicalMetadata technical;
        private List<BitStream> bitStreams;
        private URI uri;
        private Identifier identifier;

        public Builder(){
        	super();
        }
        
        public Builder(File orig){
        	//TODO: deep copy
        	this.technical = orig.technical;
        	this.bitStreams=orig.bitStreams;
        	this.uri=orig.uri;
        	this.identifier=orig.identifier;
        }
        
        public Builder bitStream(BitStream bitStream) {
        	if (this.bitStreams == null){
        		this.bitStreams=new ArrayList<BitStream>();
        	}
            this.bitStreams.add(bitStream);
            return this;
        }

        public Builder bitStreams(List<BitStream> bitStreams) {
            this.bitStreams = bitStreams;
            return this;
        }

        public File build() {
        	if (bitStreams != null && bitStreams.size() == 0){
        		bitStreams = null;
        	}
            return new File(this);
        }

        public Builder identifier(Identifier identifier){
            this.identifier=identifier;
            return this;
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
