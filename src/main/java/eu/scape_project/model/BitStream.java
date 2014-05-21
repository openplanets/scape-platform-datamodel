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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author frank asseg
*
*/
@XmlRootElement(name = "bitstream", namespace = "http://scape-project.eu/model")
public class BitStream extends Identified{

    @XmlElement(name = "type", namespace = "http://scape-project.eu/model")
    private final Type type;

    @XmlElement(name = "technicals", namespace = "http://scape-project.eu/model")
    private final TechnicalMetadataList technical;

    private BitStream() {
        super(null);
        this.type = null;
        this.technical = null;
    }

    private BitStream(Builder b) {
        super(b.identifier);
        this.type = b.type;
        this.technical = b.technical;
    }

    public TechnicalMetadataList getTechnical() {
        return technical;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "BitStream [type=" + type
                + ", technical=" + technical
                + ", identifier=" + identifier
                + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BitStream)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        BitStream bitStream = (BitStream) o;
        if (technical != null ? !technical.equals(bitStream.technical) : bitStream.technical != null) {
            return false;
        }
        if (type != bitStream.type) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (technical != null ? technical.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private Type type;
        private TechnicalMetadataList technical;
        private Identifier identifier;

        public Builder() {
            super();
        }

        public Builder(BitStream orig) {
            BitStream copy = CopyUtil.deepCopy(BitStream.class, orig);
            this.technical = copy.technical;
            this.type = copy.type;
            this.identifier = copy.identifier;
        }

        public BitStream build() {
            return new BitStream(this);
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
        public Builder type(Type type) {
            this.type = type;
            return this;
        }
    }

    @XmlEnum
    public enum Type {
        STREAM;
    }
}
