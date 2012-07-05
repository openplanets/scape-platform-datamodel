package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class LifecycleState {
    @XmlValue
    private final String details;
    @XmlAttribute(name="lifecyclestate")
    private final State state;

    public LifecycleState(String details, State state) {
        super();
        this.details = details;
        this.state = state;
    }
    
    private LifecycleState(){
        this.details=null;
        this.state=null;
    }

    public enum State {
        INGESTED, INGEST_FAILED, OTHER;
    }

    public State getState() {
        return state;
    }

    public String getDetails() {
        return details;
    }
}
