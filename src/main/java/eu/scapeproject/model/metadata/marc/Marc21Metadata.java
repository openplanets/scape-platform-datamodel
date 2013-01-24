package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.DescriptiveMetadata;

@XmlRootElement(name = "record")
public class Marc21Metadata extends DescriptiveMetadata {

    @XmlElement(name = "leader", namespace = "http://www.loc.gov/MARC21/slim")
    private final Leader leader;

    @XmlElement(name = "controlField", namespace = "http://www.loc.gov/MARC21/slim")
    private final ControlField controlField;

    @XmlElement(name = "dataField", namespace = "http://www.loc.gov/MARC21/slim")
    private final Datafield dataField;

    private Marc21Metadata(Builder b) {
        super(MetadataType.MARC21);
        this.leader = b.leader;
        this.controlField = b.controlField;
        this.dataField = b.dataField;
    }

    public ControlField getControlField() {
        return controlField;
    }

    public Datafield getDataField() {
        return dataField;
    }

    public Leader getLeader() {
        return leader;
    }

    public static class Builder {
        private Leader leader;

        private ControlField controlField;

        private Datafield dataField;

        public Builder() {

        }

        public Builder leader(Leader leader) {
            this.leader = leader;
            return this;
        }

        public Builder controlFiled(ControlField controlFiled) {
            this.controlField = controlFiled;
            return this;
        }

        public Builder dataField(Datafield dataField) {
            this.dataField = dataField;
            return this;
        }

        public Marc21Metadata build() {
            return new Marc21Metadata(this);
        }
    }

}
