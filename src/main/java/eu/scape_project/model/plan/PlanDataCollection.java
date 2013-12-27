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

package eu.scape_project.model.plan;

import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan-data-collection", namespace = "http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanDataCollection {

    @XmlElement(name = "plan-data", namespace = "http://scape-project.eu/model")
    private final Collection<PlanData> planData;

    @XmlAttribute(name = "size")
    private final int size;

    public PlanDataCollection(Collection<PlanData> planData) {
        super();
        this.planData = planData;
        this.size = (planData == null) ? 0 : planData.size();
    }

    private PlanDataCollection() {
        super();
        this.planData = null;
        this.size = 0;
    }

    public Collection<PlanData> getPlanData() {
        return planData;
    }

    public int getSize() {
        return size;
    }

}
