package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.dto.mets.MetsTechMD;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

public class MetadataAdapter extends XmlAdapter<MetsMetadata, MetsMetadata> {
	@Override
	public MetsMetadata marshal(MetsMetadata v) throws Exception {
		System.out.println(v.getClass().getName());
		return v;
	}

	@Override
	public MetsMetadata unmarshal(MetsMetadata v) throws Exception {
		System.out.println(v.getClass().getName());
		return v;
	}
}
