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

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author frank asseg
*
*/
@XmlRootElement(name = "version-list", namespace = "http://scape-project.eu/model")
public class VersionList {

    @XmlAttribute(name = "id")
    private final String entityId;
    @XmlElement(name = "version", namespace = "http://scape-project.eu/model")
    private final List<String> versionIdentifiers;

    @SuppressWarnings("unused")
    private VersionList() {
        this.versionIdentifiers = null;
        this.entityId = null;
    }

    public VersionList(String entitiyId, List<String> versionIdentifiers) {
        this.versionIdentifiers = versionIdentifiers;
        this.entityId = entitiyId;
    }

    public String getEntityId() {
        return entityId;
    };

    public List<String> getVersionIdentifiers() {
        return versionIdentifiers;
    }

    @Override
    public String toString() {
        return "VersionList ["
                + "entityId=" + entityId
                + ", versionIdentifiers=" + versionIdentifiers
                + "]";
    }

}