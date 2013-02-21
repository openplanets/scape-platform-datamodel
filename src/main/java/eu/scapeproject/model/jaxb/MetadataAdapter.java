package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.dto.mets.MetsMetadata;

public class MetadataAdapter extends XmlAdapter<MetsMetadata, MetsMetadata> {
	@Override
	public MetsMetadata marshal(MetsMetadata v) throws Exception {
		return v;
	}

	@Override
	public MetsMetadata unmarshal(MetsMetadata v) throws Exception {
		return v;
	}
}
