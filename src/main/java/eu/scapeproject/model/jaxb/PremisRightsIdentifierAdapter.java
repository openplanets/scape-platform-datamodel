package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class PremisRightsIdentifierAdapter extends XmlAdapter<PremisRightsIdentifierAdapter.PremisRightsIdentifier,Identifier> {
    
    @Override
    public PremisRightsIdentifier marshal(Identifier v) throws Exception {
        return new PremisRightsIdentifier(v.getType(), v.getValue());
    }
    
    public Identifier unmarshal(PremisRightsIdentifier v) throws Exception {
        return new Identifier(v.type, v.value);
    };
    
    
    public static class PremisRightsIdentifier{
        @XmlElement(name="rightsStatementIdentifierType",namespace="http://www.loc.gov/standards/premis")
        String type;
        @XmlElement(name="rightsStatementIdentifierValue",namespace="http://www.loc.gov/standards/premis")
        String value;
        
        @SuppressWarnings("unused")
        private PremisRightsIdentifier(){
            super();
        }
        
        public PremisRightsIdentifier(String type, String value) {
            super();
            this.type = type;
            this.value = value;
        }
    }
}
