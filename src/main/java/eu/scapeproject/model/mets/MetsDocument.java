package eu.scapeproject.model.mets;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eu.scapeproject.model.Identifier;

@XmlRootElement(name = "mets", namespace = "http://www.loc.gov/METS/")
@XmlType(namespace = "http://www.loc.gov/METS/")
public class MetsDocument {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "objid")
    private String objId;
    @XmlAttribute(name = "label")
    private String label;
    @XmlAttribute(name = "type")
    private String type;
    @XmlAttribute(name = "profile")
    private String profile;
    @XmlElement(name = "metsHdr", namespace = "http://www.loc.gov/METS/")
    private List<MetsHeader> headers;
    @XmlElement(name = "dmdSec", namespace = "http://www.loc.gov/METS/")
    private MetsDMDSec dmdSec;
    @XmlElement(name = "amdSec", namespace = "http://www.loc.gov/METS/")
    private MetsAMDSec amdSec;
    @XmlElement(name = "fileGrp", namespace = "http://www.loc.gov/METS/")
    private List<MetsFileGrp> fileGrps;

    private MetsDocument() {
        super();
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getObjId() {
        return objId;
    }

    public String getProfile() {
        return profile;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private String id;
        private String objId;
        private String label;
        private String type;
        private String profile;
        private List<MetsHeader> headers;
        private MetsDMDSec dmdSec;
        private MetsAMDSec amdSec;
        private List<MetsFileGrp> fileGrps;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder objId(String objId) {
            this.objId = objId;
            return this;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder profile(String profile) {
            this.profile = profile;
            return this;
        }

        public Builder headers(List<MetsHeader> headers) {
            this.headers = headers;
            return this;
        }

        public Builder dmdSec(MetsDMDSec dmdSec) {
            this.dmdSec = dmdSec;
            return this;
        }

        public Builder amdSec(MetsAMDSec amdSec) {
            this.amdSec = amdSec;
            return this;
        }

        public Builder fileGrps(List<MetsFileGrp> fileGrps) {
            this.fileGrps = fileGrps;
            return this;
        }

        public MetsDocument build() {
            return new MetsDocument(this);
        }
    }

    private MetsDocument(Builder builder) {
        this.id = builder.id;
        this.objId = builder.objId;
        this.label = builder.label;
        this.type = builder.type;
        this.profile = builder.profile;
        this.headers = builder.headers;
        this.dmdSec = builder.dmdSec;
        this.amdSec = builder.amdSec;
        this.fileGrps = builder.fileGrps;
    }
}
