package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.RandomStringUtils;

import eu.scapeproject.model.jaxb.MetsWrapAdapter.MetsWrapper;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;

public class MetsWrapAdapter extends XmlAdapter<MetsWrapper, Object> {
    @Override
    public MetsWrapper marshal(Object v) throws Exception {
        if (v instanceof NisoMixMetadata) {
            return new MetsWrapper(new WrappedObject("niso/mix", "text/xml", RandomStringUtils.randomAlphabetic(16), v));
        } else if (v instanceof TextMDMetadata) {
            return new MetsWrapper(new WrappedObject("textmd", "text/xml", RandomStringUtils.randomAlphabetic(16), v));
        } else if (v instanceof DCMetadata) {
            return new MetsWrapper(new WrappedObject("dc", "text/xml", RandomStringUtils.randomAlphabetic(16), v));
        } else if (v instanceof PremisProvenanceMetadata) {
            return new MetsWrapper(new WrappedObject("premis", "text/xml", RandomStringUtils.randomAlphabetic(16), v));
        }else if (v instanceof PremisRightsMetadata){
            return new MetsWrapper(new WrappedObject("premis","text/xml",RandomStringUtils.randomAlphabetic(16),v));
        } else {
            return null;
        }

    }

    @Override
    public Object unmarshal(MetsWrapper v) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @XmlRootElement(name = "metswrapper")
    public static class MetsWrapper {
        @XmlElement(name = "mdWrap", namespace = "http://www.loc.gov/METS/")
        private WrappedObject wrapper;

        private MetsWrapper() {
            super();
        }

        public MetsWrapper(WrappedObject wrapped) {
            super();
            this.wrapper = wrapped;
        }
    }

    @XmlRootElement(name = "mdWrap")
    public static class WrappedObject {
        @XmlAttribute(name = "mdtype", namespace = "http://www.loc.gov/METS/")
        private String type;
        @XmlAttribute(name = "mimetype", namespace = "http://www.loc.gov/METS/")
        private String mimeType;
        @XmlAttribute(name = "label", namespace = "http://www.loc.gov/METS/")
        private String label;
        @XmlElement(name = "xmldata", namespace = "http://www.loc.gov/METS/")
        private Object wrapped;

        private WrappedObject() {
            super();
        }

        public WrappedObject(String type, String mimeType, String label, Object wrapped) {
            super();
            this.type = type;
            this.mimeType = mimeType;
            this.label = label;
            this.wrapped = wrapped;
        }
    }
}
