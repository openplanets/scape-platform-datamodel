package eu.scapeproject.dto.mets;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.gbs.GoogleBookScanMetadata;
import eu.scapeproject.model.metadata.gbs.ProductionNotes;
import eu.scapeproject.model.metadata.marc.Marc21Metadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

@XmlRootElement(name = "mets-metadata", namespace = "http::/scapeproject.eu/model")
@XmlSeeAlso({ DCMetadata.class, Marc21Metadata.class, AudioMDMetadata.class, VideoMDMetadata.class, TextMDMetadata.class,
		NisoMixMetadata.class, FitsMetadata.class, PremisRightsMetadata.class, PremisProvenanceMetadata.class, GoogleBookScanMetadata.class, ProductionNotes.class })
public abstract class MetsMetadata {
	@XmlAttribute(name = "identifier", namespace = "http://scapeproject.eu/model")
	protected String id;

	protected MetsMetadata() {
		super();
	}

	protected MetsMetadata(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}
}
