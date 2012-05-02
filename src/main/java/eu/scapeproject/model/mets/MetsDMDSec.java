package eu.scapeproject.model.mets;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetsWrapAdapter;
import eu.scapeproject.model.metadata.DescriptiveMetadata;

@XmlRootElement(name = "dmdSec")
public class MetsDMDSec {
    @XmlAttribute(name="id")
    private String id;
    @XmlAttribute(name="groupId")
    private String groupId;
    @XmlAttribute(name="admId")
    private String admId;
    @XmlAttribute(name="created")
    private Date created;
    @XmlAttribute(name="status")
    private String status;
    @XmlElement(name="mdWrap")
    @XmlJavaTypeAdapter(MetsWrapAdapter.class)
    private DescriptiveMetadata metadata;

    private MetsDMDSec(){
        super();
    }
    
    private MetsDMDSec(Builder builder) {
        this.id = builder.id;
        this.groupId = builder.groupId;
        this.admId = builder.admId;
        this.created = builder.created;
        this.status = builder.status;
        this.metadata = builder.metadata;
    }

    public String getAdmId() {
        return admId;
    }

    public Date getCreated() {
        return created;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private final String id;
        private String groupId;
        private String admId;
        private Date created;
        private String status;
        private DescriptiveMetadata metadata;

        public Builder(String id) {
            this.id = id;
        }

        public Builder admId(String admId) {
            this.admId = admId;
            return this;
        }

        public MetsDMDSec build() {
            return new MetsDMDSec(this);
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder metadata(DescriptiveMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }
    }
}
