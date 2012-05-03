package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.RandomStringUtils;

import eu.scapeproject.model.jaxb.MetsWrapAdapter.WrappedObject;
import eu.scapeproject.model.metadata.dc.DCMetadata;

public class MetsWrapDMDAdapter extends XmlAdapter<MetsWrapAdapter.WrappedObject, Object> {
    @Override
    public MetsWrapAdapter.WrappedObject marshal(Object v) throws Exception {
        if (v instanceof DCMetadata) {
            return new WrappedObject("dc", "text/xml", RandomStringUtils.randomAlphabetic(16), v);
        } else {
            return null;
        }

    }

    @Override
    public Object unmarshal(WrappedObject v) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
