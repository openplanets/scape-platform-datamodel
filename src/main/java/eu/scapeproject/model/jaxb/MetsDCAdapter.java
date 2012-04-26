package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;

public class MetsDCAdapter extends XmlAdapter<DCMetadata, DescriptiveMetadata> {
    @Override
    public DCMetadata marshal(DescriptiveMetadata v) throws Exception {
        return (DCMetadata) v;
    }

    @Override
    public DescriptiveMetadata unmarshal(DCMetadata v) throws Exception {
        return v;
    }
}
