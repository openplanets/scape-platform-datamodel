package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class PremisLinkingObjectIdentifierAdapter extends XmlAdapter<PremisLinkingObjectIdentifierAdapter.PremisLinkingObjectdentifier,Identifier> {
    
    @Override
    public PremisLinkingObjectdentifier marshal(Identifier v) throws Exception {
        return new PremisLinkingObjectdentifier(v.getType(), v.getValue());
    }
    
    public Identifier unmarshal(PremisLinkingObjectdentifier v) throws Exception {
        return new Identifier(v.type, v.value);
    };
    
    
    public static class PremisLinkingObjectdentifier{
        @XmlElement(name="linkingObjectIdentifierType",namespace="http://www.loc.gov/standards/premis")
        String type;
        @XmlElement(name="linkingObjectIdentifierValue",namespace="http://www.loc.gov/standards/premis")
        String value;
        
        @SuppressWarnings("unused")
        private PremisLinkingObjectdentifier(){
            super();
        }
        
        public PremisLinkingObjectdentifier(String type, String value) {
            super();
            this.type = type;
            this.value = value;
        }
    }
}
