package eu.scapeproject.model.mets;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetsDCAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;

@XmlRootElement(name = "mdWrap")
public class MetaWrapper {
    @XmlJavaTypeAdapter(MetsDCAdapter.class)
    private DescriptiveMetadata metadata;

    public DescriptiveMetadata getDescriptiveMetadata() {
        return metadata;
    }

    private MetaWrapper(){
        super();
    }
    
    public MetaWrapper(DescriptiveMetadata metadata) {
        super();
        this.metadata = metadata;
    }

}
