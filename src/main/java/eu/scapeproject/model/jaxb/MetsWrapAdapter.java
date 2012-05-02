package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.RandomStringUtils;

import eu.scapeproject.model.jaxb.MetsWrapAdapter.MetsWrapper;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;

public class MetsWrapAdapter extends XmlAdapter<MetsWrapper, Object> {
    @Override
    public MetsWrapper marshal(Object v) throws Exception {
        if (v instanceof NisoMixMetadata) {
            return new MetsWrapper("niso/mix", "text/xml",RandomStringUtils.randomAlphabetic(16), v);
        } else if (v instanceof TextMDMetadata) {
            return new MetsWrapper("textmd", "text/xml",RandomStringUtils.randomAlphabetic(16), v);
        } else if (v instanceof DCMetadata) {
            return new MetsWrapper("dc", "text/xml",RandomStringUtils.randomAlphabetic(16), v);
        } else {
            return null;
        }

    }

    @Override
    public Object unmarshal(MetsWrapper v) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @XmlRootElement(name = "mdWrap", namespace = "http://www.loc.gov/METS/")
    public static class MetsWrapper {
        @XmlAttribute(name = "mdtype", namespace = "http://www.loc.gov/METS/")
        private String type;
        @XmlAttribute(name = "mimetype", namespace = "http://www.loc.gov/METS/")
        private String mimeType;
        @XmlAttribute(name = "label", namespace = "http://www.loc.gov/METS/")
        private String label;
        @XmlElement(name = "xmlData", namespace = "http://www.loc.gov/METS/")
        private Object wrapped;

        private MetsWrapper(){
            super();
        }
        
        public MetsWrapper(String type, String mimeType, String label, Object wrapped) {
            super();
            this.type = type;
            this.mimeType = mimeType;
            this.wrapped = wrapped;
            this.label = label;
        }

    }
}
