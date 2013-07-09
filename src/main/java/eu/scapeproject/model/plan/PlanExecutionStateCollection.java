package eu.scapeproject.model.plan;

import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan-execution-states", namespace = "http://scapeproject.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanExecutionStateCollection {
    @XmlAttribute(name = "uri")
    private final String uri;
    @XmlElementWrapper(name = "states", namespace = "http://scapeproject.eu/model")
    public final List<PlanExecutionState> executionStates;

    public PlanExecutionStateCollection() {
        this.uri = null;
        this.executionStates = null;
    }

    public PlanExecutionStateCollection(String uri, List<PlanExecutionState> executionStates) {
        super();
        this.uri = uri;
        this.executionStates = executionStates;
    }

    public String getUri() {
        return uri;
    }

    public List<PlanExecutionState> getExecutionStates() {
        return executionStates;
    }

}
