package eu.scapeproject.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import eu.scapeproject.model.Identifier;

public class PremisLicenseIdentifierAdapter extends XmlAdapter<PremisLicenseIdentifierAdapter.PremisLicenseIdentifier,Identifier> {
    
    @Override
    public PremisLicenseIdentifier marshal(Identifier v) throws Exception {
        return new PremisLicenseIdentifier(v.getType(), v.getValue());
    }
    
    public Identifier unmarshal(PremisLicenseIdentifier v) throws Exception {
        return new Identifier(v.type, v.value);
    };
    
    
    public static class PremisLicenseIdentifier{
        @XmlElement(name="licenseIdentifierType",namespace="http://www.loc.gov/standards/premis")
        String type;
        @XmlElement(name="licenseIdentifierValue",namespace="http://www.loc.gov/standards/premis")
        String value;
        
        @SuppressWarnings("unused")
        private PremisLicenseIdentifier(){
            super();
        }
        
        public PremisLicenseIdentifier(String type, String value) {
            super();
            this.type = type;
            this.value = value;
        }
    }
}
