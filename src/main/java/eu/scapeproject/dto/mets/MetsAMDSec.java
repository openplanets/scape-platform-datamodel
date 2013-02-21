package eu.scapeproject.dto.mets;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "amdSec", namespace = "http://www.loc.gov/METS/")
public class MetsAMDSec {
    @XmlAttribute(name = "ID")
    private String id;
    @XmlElements(@XmlElement(name = "techMD", namespace = "http://www.loc.gov/METS/"))
    private List<MetsTechMD> technicalMetadata;
    @XmlElement(name = "rightsMD", namespace = "http://www.loc.gov/METS/")
    private MetsRightsMD rightsMetadata;
    @XmlElement(name = "sourceMD", namespace = "http://www.loc.gov/METS/")
    private MetsSourceMD sourceMetadata;
    @XmlElement(name = "digiprovMD", namespace = "http://www.loc.gov/METS/")
    private MetsDigiProvMD provenanceMetadata;

    private MetsAMDSec() {
        super();
    }

    private MetsAMDSec(Builder builder) {
        this.id = builder.id;
        this.technicalMetadata = builder.technicalMetadata;
        this.provenanceMetadata = builder.provenanceMetadata;
        this.sourceMetadata = builder.sourceMetadata;
        this.rightsMetadata = builder.rightsMetadata;
    }

    public String getId() {
        return id;
    }

    public MetsDigiProvMD getProvenanceMetadata() {
        return provenanceMetadata;
    }

    public MetsRightsMD getRightsMetadata() {
        return rightsMetadata;
    }

    public MetsSourceMD getSourceMetadata() {
        return sourceMetadata;
    }

    public List<MetsTechMD> getTechnicalMetadata() {
        return technicalMetadata;
    }

    public static class Builder {
        private String id;
        private List<MetsTechMD> technicalMetadata;
        private MetsDigiProvMD provenanceMetadata;
        private MetsSourceMD sourceMetadata;
        private MetsRightsMD rightsMetadata;

        public MetsAMDSec build() {
            return new MetsAMDSec(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder provenanceMetadata(MetsDigiProvMD provenanceMetadata) {
            this.provenanceMetadata = provenanceMetadata;
            return this;
        }

        public Builder rightsMetadata(MetsRightsMD rightsMetadata) {
            this.rightsMetadata = rightsMetadata;
            return this;
        }

        public Builder sourceMetadata(MetsSourceMD sourceMetadata) {
            this.sourceMetadata = sourceMetadata;
            return this;
        }

        public Builder technicalMetadata(List<MetsTechMD> technicalMetadata) {
            this.technicalMetadata = technicalMetadata;
            return this;
        }
    }
}
