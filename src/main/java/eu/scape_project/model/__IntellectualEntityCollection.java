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

import gov.loc.mets.Mets;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entity-list", namespace = "http://scape-project.eu/model")
/**
 * For internal use. This is needed for mapping in between scape model and mets model
 * should probably done using an XmlAdapter, but time is of the essence atm...
 * @author fasseg
 *
 */
public class __IntellectualEntityCollection {
	@XmlElement(name = "mets", namespace = "http://www.loc.gov/METS/")
	private final List<Mets> mets;

	public __IntellectualEntityCollection(){
		super();
		this.mets = null;
	}
	public __IntellectualEntityCollection(List<Mets> mets) {
		super();
		this.mets = mets;
	}

	public List<Mets> getMets() {
		return mets;
	}
}
