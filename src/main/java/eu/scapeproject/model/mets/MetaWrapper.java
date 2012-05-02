package eu.scapeproject.model.mets;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetsWrapAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;

@XmlRootElement(name = "mdWrap")
@XmlSeeAlso({NisoMixMetadata.class,TextMDMetadata.class,DCMetadata.class})
public class MetaWrapper {
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private Object metadata;

    public Object getMetadata() {
        return metadata;
    }

    private MetaWrapper() {
        super();
    }

    public MetaWrapper(DescriptiveMetadata metadata) {
        super();
        this.metadata = metadata;
    }

}
