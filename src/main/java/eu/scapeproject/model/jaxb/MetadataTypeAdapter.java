package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.mets.MetaWrapper;

public class MetadataTypeAdapter extends XmlAdapter<MetaWrapper, DescriptiveMetadata>{
    
    @Override
    public DescriptiveMetadata unmarshal(MetaWrapper v) throws Exception {
        return v.getDescriptiveMetadata();
    }
    
    @Override
    public MetaWrapper marshal(DescriptiveMetadata v) throws Exception {
        return new MetaWrapper(v);
    };
}
