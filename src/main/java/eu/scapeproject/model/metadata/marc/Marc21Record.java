package eu.scapeproject.model.metadata.marc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.marc.Marc21Metadata.Builder;

@XmlRootElement(name="record",namespace="http://www.loc.gov/MARC21/slim")
public class Marc21Record {
    @XmlElement(name = "leader", namespace = "http://www.loc.gov/MARC21/slim")
    private final Leader leader;

    @XmlElement(name = "controlField", namespace = "http://www.loc.gov/MARC21/slim")
    private final ControlField controlField;

    @XmlElement(name = "dataField", namespace = "http://www.loc.gov/MARC21/slim")
    private final Datafield dataField;
    
    private Marc21Record() {
        this.leader = null;
        this.controlField = null;
        this.dataField = null;
	}

    private Marc21Record(Builder b) {
        this.leader = b.leader;
        this.controlField = b.controlField;
        this.dataField = b.dataField;
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

        public Builder controlField(ControlField controlField) {
            this.controlField = controlField;
            return this;
        }

        public Builder dataField(Datafield dataField) {
            this.dataField = dataField;
            return this;
        }

        public Marc21Record build() {
            return new Marc21Record(this);
        }

    }

}
