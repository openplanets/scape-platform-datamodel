package eu.scapeproject.model.jaxb;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

public class ScapeNamespacePrefixMapper extends NamespacePrefixMapper {
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if (namespaceUri.toLowerCase().equals("http://www.loc.gov/mets/")) {
            return "mets";
        } else if (namespaceUri.toLowerCase().equals("http://purl.org/dc/elements/1.1/")) {
            return "dc";
        } else if (namespaceUri.toLowerCase().equals("http://www.loc.gov/standards/premis")) {
            return "premis";
        } else if (namespaceUri.toLowerCase().equals("info:lc/xmlns/textmd-v3")) {
            return "textmd";
        } else if (namespaceUri.toLowerCase().equals("http://www.loc.gov/mix/v10")) {
            return "mix";
        } else if (namespaceUri.toLowerCase().equals("http://www.w3.org/1999/xlink")) {
            return "xlink";
        } else if (namespaceUri.toLowerCase().equals("http://hul.harvard.edu/ois/xml/ns/fits/fits_output")) {
            return "fits";
        } else if (namespaceUri.toLowerCase().equals("http://www.loc.gov/amd/")) {
            return "amd";
        } else if (namespaceUri.toLowerCase().equals("http://www.loc.gov/videomd/")) {
            return "vmd";
        } else if (namespaceUri.toLowerCase().equals("http://www.w3.org/2001/xmlschema-instance")) {
            return "xsi";
        } else if (namespaceUri.toLowerCase().equals("http://scapeproject.eu/model")) {
            return "scape";
        } else if (namespaceUri.toLowerCase().equals("http://www.loc.gov/marc21/slim")) {
            return "marc";
        } else if (namespaceUri.toLowerCase().equals("http://books.google.com/gbs")) {
            return "gbs";
        } else {
            return suggestion;
        }
    }
}
