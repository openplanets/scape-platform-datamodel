package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class PremisLinkingAgentIdentifierAdapter extends XmlAdapter<PremisLinkingAgentIdentifierAdapter.PremisLinkingAgentIdentifier,Identifier> {
    
    @Override
    public PremisLinkingAgentIdentifier marshal(Identifier v) throws Exception {
        return new PremisLinkingAgentIdentifier(v.getType(), v.getValue());
    }
    
    public Identifier unmarshal(PremisLinkingAgentIdentifier v) throws Exception {
        return new Identifier(v.type, v.value);
    };
    
    
    public static class PremisLinkingAgentIdentifier{
        @XmlElement(name="linkingAgentIdentifierType",namespace="http://www.loc.gov/standards/premis")
        String type;
        @XmlElement(name="linkingAgentIdentifierValue",namespace="http://www.loc.gov/standards/premis")
        String value;
        
        @SuppressWarnings("unused")
        private PremisLinkingAgentIdentifier(){
            super();
        }
        
        public PremisLinkingAgentIdentifier(String type, String value) {
            super();
            this.type = type;
            this.value = value;
        }
    }
}
