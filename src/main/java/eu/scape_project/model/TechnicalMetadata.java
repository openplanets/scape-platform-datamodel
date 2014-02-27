package eu.scape_project.model;

import com.google.books.gbs.GbsType;
import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import generated.Jpylyzer;
import gov.loc.mix.v20.Mix;
import info.lc.xmlns.textmd_v3.TextMD;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="versionMD", namespace="http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class TechnicalMetadata {

    @XmlAttribute(name = "id")
    private String id;

    @XmlAnyElement(lax = true)
    @XmlElementRefs({
                     @XmlElementRef(name = "textMD", type = TextMD.class),
                     @XmlElementRef(name = "fits", type = Fits.class),
                     @XmlElementRef(name = "mix", type = Mix.class),
                     @XmlElementRef(name = "gbs", type = GbsType.class),

                     @XmlElementRef(name = "jpylyzer", type = Jpylyzer.class),
                     @XmlElementRef(name = "VIDEOMD", namespace = "http://www.loc.gov/videoMD/", type = JAXBElement.class),
                     @XmlElementRef(name = "AUDIOMD", namespace = "http://www.loc.gov/audioMD/", type = JAXBElement.class)})
    private Object contents;

    public TechnicalMetadata(String id, Object contents) {
        this.id = id;
        this.contents = contents;
    }

    public TechnicalMetadata() {
    }


    public String getId() {
        return id;
    }

    public Object getContents() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TechnicalMetadata)) {
            return false;
        }

        TechnicalMetadata that = (TechnicalMetadata) o;

        if (!contents.equals(that.contents)) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + contents.hashCode();
        return result;
    }
}
