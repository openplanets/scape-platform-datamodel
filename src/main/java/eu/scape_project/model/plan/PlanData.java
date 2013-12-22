/**
 *
 */

package eu.scape_project.model.plan;

import java.util.SortedSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scape_project.model.Identifier;
import eu.scape_project.model.LifecycleState;

@XmlRootElement(name = "plan-data", namespace = "http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanData {

    @XmlAttribute(name = "title")
    private final String title;

    @XmlElement(name = "identifier", namespace = "http://scape-project.eu/model")
    private final Identifier identifier;

    @XmlElement(name = "description", namespace = "http://scape-project.eu/model")
    private final String description;

    @XmlElement(name = "execution-state")
    private final SortedSet<PlanExecutionState> executionStates;

    @XmlElement(name = "lifecycle-state")
    private final LifecycleState lifecycleState;

    private PlanData() {
        // default constructor for JAX-B
        super();
        this.title = null;
        this.identifier = null;
        this.description = null;
        this.executionStates = null;
        this.lifecycleState = null;
    }

    private PlanData(Builder b) {
        this.description = b.description;
        this.executionStates = b.executionStates;
        this.identifier = b.identifier;
        this.lifecycleState = b.lifecycleState;
        this.title = b.title;
    }

    public String getTitle() {
        return title;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public SortedSet<PlanExecutionState> getExecutionStates() {
        return executionStates;
    }

    public LifecycleState getLifecycleState() {
        return lifecycleState;
    }

    public static class Builder {

        private String title;

        private Identifier identifier;

        private String description;

        private SortedSet<PlanExecutionState> executionStates;

        private LifecycleState lifecycleState;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder executionStates(SortedSet<PlanExecutionState> executionStates) {
            this.executionStates = executionStates;
            return this;
        }
        public Builder lifecycleState(LifecycleState lifecycleState) {
            this.lifecycleState = lifecycleState;
            return this;
        }

        public PlanData build() {
            return new PlanData(this);
        }
    }

}
