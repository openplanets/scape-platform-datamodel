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
package eu.scape_project.util;

import javax.xml.bind.JAXBException;

import eu.scape_project.model.IntellectualEntity;
import gov.loc.mets.MetsType;

/**
*
* @author frank asseg
*
*/
public abstract class IntellectualEntityConverter {
    private final String profileName;

    public IntellectualEntityConverter(String profileName) {
        super();
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public abstract IntellectualEntity convertMets(MetsType mets) throws JAXBException;


    public MetsType convertEntity(IntellectualEntity entity) {
        return this.convertEntity(entity, false);
    }

    public abstract MetsType convertEntity(IntellectualEntity entity, boolean useMdRef);
}
