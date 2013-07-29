package eu.scapeproject.model;

import gov.loc.mix.v20.Mix;
import info.lc.xmlns.textmd_v3.TextMD;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.books.gbs.GbsType;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scapeproject.util.CopyUtil;

@XmlRootElement(name = "bitstream", namespace = "http://scapeproject.eu/model")
public class BitStream {

    @XmlElement(name = "type", namespace = "http://scapeproject.eu/model")
    private final Type type;
    @XmlAnyElement
    @XmlElementRefs({
        @XmlElementRef(name = "textMD", type = TextMD.class),
        @XmlElementRef(name = "fits", type = Fits.class),
        @XmlElementRef(name = "mix", type = Mix.class),
        @XmlElementRef(name = "gbs", type = GbsType.class),
        @XmlElementRef(name = "VIDEOMD", namespace = "http://www.loc.gov/videoMD/", type = JAXBElement.class),
        @XmlElementRef(name = "AUDIOMD", namespace = "http://www.loc.gov/audioMD/", type = JAXBElement.class)})
    private final Object technical;
    @XmlElement(name = "identifier", namespace = "http://scapeproject.eu/model")
    private final Identifier identifier;

    private BitStream() {
        this.type = null;
        this.technical = null;
        this.identifier = null;
    }

    private BitStream(Builder b) {
        super();
        this.type = b.type;
        this.technical = b.technical;
        this.identifier = b.identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
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
