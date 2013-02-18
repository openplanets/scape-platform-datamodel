package eu.scapeproject.model.metadata.marc;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.util.CopyUtil;

@XmlRootElement(name = "record")
public class Marc21Record extends DescriptiveMetadata {
	@XmlElement(name = "leader")
	private final Leader leader;

	@XmlElements(@XmlElement(name = "controlfield"))
	private final List<ControlField> controlFields;

	@XmlElements(@XmlElement(name = "datafield"))
	private final List<Datafield> dataFields;

	private Marc21Record() {
		super(MetadataType.MARC21);
		this.leader = null;
		this.controlFields = null;
		this.dataFields = null;
		this.id = null;
	}

	private Marc21Record(Builder b) {
		super(MetadataType.MARC21);
		this.leader = b.leader;
		this.controlFields = b.controlFields;
		this.dataFields = b.dataFields;
		this.id = null;
	}

	public List<ControlField> getControlFields() {
		return controlFields;
	}

	public List<Datafield> getDataFields() {
		return dataFields;
	}

	public Leader getLeader() {
		return leader;
	}

	public static class Builder {
		private Leader leader;

		private List<ControlField> controlFields;

		private List<Datafield> dataFields;

		public Builder() {

		}

		public Builder(Marc21Record orig) {
			orig = CopyUtil.deepCopy(Marc21Record.class, orig);
			this.leader = orig.leader;
			this.controlFields = orig.controlFields;
			this.dataFields = orig.dataFields;
		}

		public Builder leader(Leader leader) {
			this.leader = leader;
			return this;
		}

		public Builder controlFields(List<ControlField> controlFields) {
			this.controlFields = controlFields;
			return this;
		}

		public Builder dataField(List<Datafield> dataFields) {
			this.dataFields = dataFields;
			return this;
		}

		public Marc21Record build() {
			return new Marc21Record(this);
		}

	}

}
