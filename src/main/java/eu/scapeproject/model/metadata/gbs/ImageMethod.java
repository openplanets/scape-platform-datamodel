package eu.scapeproject.model.metadata.gbs;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "imageMethod", namespace = "http://books.google.com/gbs")
public class ImageMethod {
    @XmlAttribute(name = "scanner")
    private final String scanner;
    @XmlValue
    private final String method;

    private ImageMethod() {
        this.scanner = null;
        this.method = null;
    }

    public ImageMethod(String scanner, String method) {
        super();
        this.scanner = scanner;
        this.method = method;
    }

    public String getScanner() {
        return scanner;
    }

    public String getMethod() {
        return method;
    }

}
