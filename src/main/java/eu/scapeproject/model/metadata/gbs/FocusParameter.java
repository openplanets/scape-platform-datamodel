package eu.scapeproject.model.metadata.gbs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "focusParameter", namespace = "http://books.google.com/gbs")
public class FocusParameter {
    @XmlAttribute(name = "threshold")
    private final String threshold;
    @XmlValue
    private final String parameter;

    private FocusParameter(){
        this.threshold = null;
        this.parameter = null;
    }
    
    public FocusParameter(String threshold, String parameter) {
        super();
        this.threshold = threshold;
        this.parameter = parameter;
    }

    public String getThreshold() {
        return threshold;
    }

    public String getParameter() {
        return parameter;
    }
}
