package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class PremisEventIdentifierAdapter extends XmlAdapter<PremisEventIdentifierAdapter.PremisEventIdentifier,Identifier> {
    
    @Override
    public PremisEventIdentifier marshal(Identifier v) throws Exception {
        return new PremisEventIdentifier(v.getType(), v.getValue());
    }
    
    public Identifier unmarshal(PremisEventIdentifier v) throws Exception {
        return new Identifier(v.type, v.value);
    };
    
    
    public static class PremisEventIdentifier{
        @XmlElement(name="eventIdentifierType",namespace="http://www.loc.gov/standards/premis")
        String type;
        @XmlElement(name="eventIdentifierValue",namespace="http://www.loc.gov/standards/premis")
        String value;
        
        @SuppressWarnings("unused")
        private PremisEventIdentifier(){
            super();
        }
        
        public PremisEventIdentifier(String type, String value) {
            super();
            this.type = type;
            this.value = value;
        }
    }
}
