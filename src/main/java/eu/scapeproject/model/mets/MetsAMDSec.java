package eu.scapeproject.model.mets;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetsWrapAdapter;
import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "amdSec",namespace="http://www.loc.gov/METS/")
public class MetsAMDSec {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "techMD",namespace="http://www.loc.gov/METS/")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private TechnicalMetadata technicalMetadata;

    // private RightsMetadata rightsMetadata;
    // private ProvenanceMetadata provenanceMetadata;
    // private DescriptiveMetadata sourceMetadata;

    private MetsAMDSec() {
        super();
    }

    public MetsAMDSec(String id, TechnicalMetadata technicalMetadata) {
        super();
        this.id = id;
        this.technicalMetadata = technicalMetadata;
    }
}
