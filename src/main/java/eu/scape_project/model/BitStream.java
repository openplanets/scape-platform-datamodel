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

import com.google.books.gbs.GbsType;
import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scape_project.util.CopyUtil;
import gov.loc.mix.v20.Mix;
import info.lc.xmlns.textmd_v3.TextMD;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
    @XmlAnyElement(lax = true)
    @XmlElementRefs({
        @XmlElementRef(name = "textMD", type = TextMD.class),
        @XmlElementRef(name = "fits", type = Fits.class),
        @XmlElementRef(name = "mix", type = Mix.class),
        @XmlElementRef(name = "gbs", type = GbsType.class),
        @XmlElementRef(name = "VIDEOMD", namespace = "http://www.loc.gov/videoMD/", type = JAXBElement.class),
        @XmlElementRef(name = "AUDIOMD", namespace = "http://www.loc.gov/audioMD/", type = JAXBElement.class)})
    private final Object technical;

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

    public Object getTechnical() {
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

    public static class Builder {
        private Type type;
        private Object technical;
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

        public Builder technical(Object technical) {
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
