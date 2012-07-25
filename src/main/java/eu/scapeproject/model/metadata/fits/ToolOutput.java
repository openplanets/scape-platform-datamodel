package eu.scapeproject.model.metadata.fits;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tooloutput",namespace="http://hul.harvard.edu/ois/xml/ns/fits/fits_output")
public class ToolOutput {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    @Override
    public int hashCode() {
        return 1;
    }
}
