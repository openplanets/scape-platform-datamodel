/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.model;

import eu.scape_project.util.CopyUtil;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.util.List;

/**
 * @author frank asseg
 */
@XmlRootElement(name = "file", namespace = "http://scape-project.eu/model")
public class File extends Identified {

    @XmlAttribute(name = "mimetype")
    private final String mimetype;
    @XmlAttribute(name = "filename")
    private final String filename;
    @XmlElement(name = "technicals", namespace = "http://scape-project.eu/model")
    private final TechnicalMetadataList technical;
    @XmlElement(name = "bitstream", namespace = "http://scape-project.eu/model")
    private final List<BitStream> bitStreams;
    @XmlElement(name = "uri", namespace = "http://scape-project.eu/model")
    private final URI uri;

    private File() {
        super(null);
        this.filename = null;
        this.mimetype = null;
        this.technical = null;
        this.bitStreams = null;
        this.uri = null;
    }

    private File(Builder builder) {
        super(builder.identifier);
        this.filename = builder.filename;
        this.mimetype = builder.mimetype;
        this.technical = builder.technical;
        this.bitStreams = builder.bitStreams;
        this.uri = builder.uri;
    }

    public List<BitStream> getBitStreams() {
        return bitStreams;
    }

    public TechnicalMetadataList getTechnical() {
        return technical;
    }

    public URI getUri() {
        return uri;
    }

    public String getMimetype() {
        return mimetype;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return "File [technical=" + technical + ", name=" + filename + ", bitStreams=" + bitStreams + ", uri=" + uri + ", identifier=" + identifier + ", mimetype=" + mimetype + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof File)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        File file = (File) o;
        if (bitStreams != null ? !bitStreams.equals(file.bitStreams) : file.bitStreams != null) {
            return false;
        }
        if (filename != null ? !filename.equals(file.filename) : file.filename != null) {
            return false;
        }
        if (mimetype != null ? !mimetype.equals(file.mimetype) : file.mimetype != null) {
            return false;
        }
        if (technical != null ? !technical.equals(file.technical) : file.technical != null) {
            return false;
        }
        if (uri != null ? !uri.equals(file.uri) : file.uri != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (mimetype != null ? mimetype.hashCode() : 0);
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (technical != null ? technical.hashCode() : 0);
        result = 31 * result + (bitStreams != null ? bitStreams.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private TechnicalMetadataList technical;
        private List<BitStream> bitStreams;
        private URI uri;
        private Identifier identifier;
        private String mimetype;
        private String filename;

        public Builder() {
            super();
        }

        public Builder(File orig) {
            File copy = CopyUtil.deepCopy(File.class, orig);
            this.mimetype = copy.mimetype;
            this.technical = copy.technical;
            this.bitStreams = copy.bitStreams;
            this.uri = copy.uri;
            this.identifier = copy.identifier;
            this.filename = copy.filename;
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

        public Builder technical(String id, Object content) {
            return technical(new TechnicalMetadata(id,content));
        }


        public Builder technical(TechnicalMetadata technical) {
            if (this.technical == null){
                this.technical = new TechnicalMetadataList();
            }
            this.technical.getContent().add(technical);
            return this;

        }

        public Builder technical(TechnicalMetadataList technical) {
            this.technical = technical;
            return this;
        }

        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }

        public Builder mimetype(String mimetype) {
            this.mimetype = mimetype;
            return this;
        }

        public Builder uri(URI uri) {
            this.uri = uri;
            return this;
        }
    }
}
