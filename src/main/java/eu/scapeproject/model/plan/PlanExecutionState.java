package eu.scapeproject.model.plan;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="plan-execution-state",namespace="http://scapeproject.eu/model")
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
