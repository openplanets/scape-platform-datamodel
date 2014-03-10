package eu.scape_project.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import generated.Jpylyzer;
import gov.loc.mix.v20.Mix;
import info.lc.xmlns.textmd_v3.TextMD;
import org.ffmpeg.schema.ffprobe.FfprobeType;
import com.google.books.gbs.GbsType;

@XmlRootElement(name="technical")
public class TechnicalMetadataList {
    @XmlAnyElement(lax = true)
    @XmlElementRefs({
            @XmlElementRef(name = "textMD", type = TextMD.class),
            @XmlElementRef(name = "fits", type = Fits.class),
            @XmlElementRef(name = "mix", type = Mix.class),
            @XmlElementRef(name = "gbs", type = GbsType.class),
            @XmlElementRef(name = "jpylyzer", type = Jpylyzer.class),
            @XmlElementRef(name = "ffprobe", type = FfprobeType.class),
            @XmlElementRef(name = "VIDEOMD", namespace = "http://www.loc.gov/videoMD/", type = JAXBElement.class),
            @XmlElementRef(name = "AUDIOMD", namespace = "http://www.loc.gov/audioMD/", type = JAXBElement.class)})
	private final List<Object> records;

    private TechnicalMetadataList() {
    	this.records = null;
    }
    
	private TechnicalMetadataList(Builder b) {
		this.records = b.records;
	}

	public List<Object> getRecords() {
		return records;
	}
	
	public static class Builder {
		List<Object> records = new ArrayList<Object>();

		public Builder records(Collection<Object> records) {
			this.records.addAll(records);
			return this;
		}

		public Builder record(Object record) {
			this.records.add(record);
			return this;
		}

		public TechnicalMetadataList build() {
			return new TechnicalMetadataList(this);
		}
	}

}
