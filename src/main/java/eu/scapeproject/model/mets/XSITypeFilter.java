package eu.scapeproject.model.mets;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

public class XSITypeFilter extends XMLFilterImpl {
    public XSITypeFilter(XMLReader reader) {
        super(reader);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (localName.equals("xmlData")) {
            atts = null;
        }
        super.startElement(uri, localName, qName, atts);
    }
}
