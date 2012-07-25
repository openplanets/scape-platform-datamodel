package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class MixSourceIdentifierAdapter extends XmlAdapter<MixSourceIdentifierAdapter.MixSourceIdentifier, Identifier> {
	@Override
	public MixSourceIdentifier marshal(Identifier v) throws Exception {
		return new MixSourceIdentifier(v.getType(), v.getValue());
	}

	@Override
	public Identifier unmarshal(MixSourceIdentifier v) throws Exception {
		return new Identifier(v.type,v.value);
	}

	@XmlRootElement(name="sourceIdentifier",namespace="http://www.loc.gov/mix/v10")
	public static class MixSourceIdentifier {
        @XmlElement(name="type",namespace="http://www.loc.gov/mix/v10")
        private String type;
        @XmlElement(name="value",namespace="http://www.loc.gov/mix/v10")
        private String value;
		
		@SuppressWarnings("unused")
		private MixSourceIdentifier() {
			super();
		}

		public MixSourceIdentifier(String type, String value) {
			super();
			this.type = type;
			this.value = value;
		}
	}
}
