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

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
*
* @author frank asseg
*
*/
@XmlRootElement(name="plan-execution-state",namespace="http://scape-project.eu/model")
public class PlanExecutionState implements Comparable<PlanExecutionState>{
    public enum ExecutionState {
        EXECUTION_IN_PROGRESS, EXECUTION_SUCCESS, EXECUTION_FAIL;
    }

    @XmlAttribute(name="timestamp")
    private final Date timeStamp;
    @XmlAttribute(name="state")
    private final ExecutionState state;

    public PlanExecutionState(Date timeStamp, ExecutionState state) {
        super();
        this.timeStamp = timeStamp;
        this.state = state;
    }

    public PlanExecutionState() {
        this.timeStamp = null;
        this.state = null;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public ExecutionState getState() {
        return state;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(PlanExecutionState o) {
        return (int) (timeStamp.getTime() - o.getTimeStamp().getTime());
    }

}
