package eu.scapeproject.model.plan;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="plan-execution-state",namespace="http://scapeproject.eu/model")
public class PlanExecutionState {
    public enum ExecutionState {
        ENABLED, DISABLED, EXECUTION_IN_PROGRESS, EXECUTION_SUCCESS, EXECUTION_FAIL;
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

}
