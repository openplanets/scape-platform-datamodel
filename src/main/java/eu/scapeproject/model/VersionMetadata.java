/**
 *
 */
package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="versionMD", namespace="http://scapeproject.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class VersionMetadata {
    @XmlAttribute(name="version-number")
    private int versionNumber;

    public VersionMetadata() {
        super();
    }

    public VersionMetadata(int versionNumber) {
        super();
        this.versionNumber = versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }


    public int getVersionNumber() {
        return versionNumber;
    }

}
