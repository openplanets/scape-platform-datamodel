package eu.scapeproject.model.mets;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetsWrapAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "amdSec", namespace = "http://www.loc.gov/METS/")
public class MetsAMDSec {
    @XmlAttribute(name = "id")
    private String id;
    @XmlElement(name = "techMD", namespace = "http://www.loc.gov/METS/")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private TechnicalMetadata technicalMetadata;

    @XmlElement(name = "digiProvMD", namespace = "http://www.loc.gov/METS/")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private ProvenanceMetadata provenanceMetadata;

    @XmlElement(name = "sourceMD", namespace = "http://www.loc.gov/METS/")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private DescriptiveMetadata sourceMetadata;

    @XmlElement(name = "rightsMD", namespace = "http://www.loc.gov/METS/")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private RightsMetadata rightsMetadata;

    private MetsAMDSec() {
        super();
    }

    public MetsAMDSec(String id, TechnicalMetadata technicalMetadata, ProvenanceMetadata provenanceMetadata, DescriptiveMetadata sourceMetadata,RightsMetadata rightsMetadata) {
        super();
        this.id = id;
        this.technicalMetadata = technicalMetadata;
        this.provenanceMetadata = provenanceMetadata;
        this.sourceMetadata = sourceMetadata;
        this.rightsMetadata = rightsMetadata;
    }
}
