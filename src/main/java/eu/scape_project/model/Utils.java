package eu.scape_project.model;

import javax.xml.bind.JAXBElement;

public class Utils {

    public static Object getValue(Object possibleJaxbElement){
        if (possibleJaxbElement instanceof JAXBElement) {
            JAXBElement jaxbElement = (JAXBElement) possibleJaxbElement;
            return jaxbElement.getValue();
        } else {
            return possibleJaxbElement;
        }
    }
}
