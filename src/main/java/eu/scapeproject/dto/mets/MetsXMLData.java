package eu.scapeproject.dto.mets;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.MetadataAdapter;

@XmlRootElement(name = "xmlData", namespace = "http://www.loc.gov/METS/")
public class MetsXMLData {
    
    @XmlAnyElement(lax=true)
    private MetsMetadata data;

    @SuppressWarnings("unused")
    private MetsXMLData() {
        super();
    }

    public MetsXMLData(MetsMetadata data) {
        super();
        this.data = data;
    }

    public Object getData() {
        return data;
    }

}
