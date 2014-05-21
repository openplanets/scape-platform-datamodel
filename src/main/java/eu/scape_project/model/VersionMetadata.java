/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scape_project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


/**
*
* @author frank asseg
*
*/
@XmlRootElement(name="versionMD", namespace="http://scape-project.eu/model")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VersionMetadata)) {
            return false;
        }
        VersionMetadata that = (VersionMetadata) o;
        if (versionNumber != that.versionNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return versionNumber;
    }
}
