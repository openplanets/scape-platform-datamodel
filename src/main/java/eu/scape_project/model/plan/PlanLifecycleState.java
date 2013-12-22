/**
 *
 */
package eu.scape_project.model.plan;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


/**
 * @author frank asseg
 *
 */
@XmlRootElement(name="plan-lifecycle-state",namespace="http://scape-project.eu/model")
public class PlanLifecycleState {

    public enum PlanState {
        ENABLED,DISABLED;
    }

    @XmlAttribute(name="plan-state")
    private final PlanState state;
    @XmlValue
    private final String details;

    public PlanLifecycleState(PlanState state, String details) {
        super();
        this.state = state;
        this.details = details;
    }

    private PlanLifecycleState() {
        super();
        this.state = null;
        this.details = null;
    }

    public String getDetails() {
        return details;
    }

    public PlanState getState() {
        return state;
    }

}
