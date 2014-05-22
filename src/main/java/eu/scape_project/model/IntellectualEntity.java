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

import eu.scape_project.util.CopyUtil;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author frank asseg
 */
@XmlRootElement(name = "entity", namespace = "http://scape-project.eu/model")
public class IntellectualEntity extends Identified {

    private final int versionNumber;
    private final List<Identifier> alternativeIdentifiers;
    private final Object descriptive;
    private final List<Representation> representations;

    private final LifecycleState lifeCycleState;

    @SuppressWarnings("unused")
    private IntellectualEntity() {
        super(null);
        this.alternativeIdentifiers = null;
        this.descriptive = null;
        this.representations = null;
        this.lifeCycleState = null;
        this.versionNumber = 1;
    }

    public IntellectualEntity(Builder builder) {
        super(builder.identifier);
		this.alternativeIdentifiers = builder.alternativeIdentifiers.isEmpty() ? null
				: new ArrayList<Identifier>(builder.alternativeIdentifiers);
        this.descriptive = builder.descriptive;
		this.representations = builder.representations.isEmpty() ? null
				: new ArrayList<Representation>(builder.representations);
        this.lifeCycleState = builder.lifecycleState;
        this.versionNumber = builder.versionNumber;
    }

    public List<Identifier> getAlternativeIdentifiers() {
        return alternativeIdentifiers;
    }

    public Object getDescriptive() {
        return descriptive;
    }

    public LifecycleState getLifecycleState() {
        return lifeCycleState;
    }

    public List<Representation> getRepresentations() {
        return representations;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    @Override
    public String toString() {
        return "IntellectualEntity [identifier=" + identifier + ", versionNumber=" + versionNumber + ", alternativeIdentifiers=" + alternativeIdentifiers + ", descriptive=" + descriptive + ", representations=" + representations + ", lifeCycleState=" + lifeCycleState + "]";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntellectualEntity)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        IntellectualEntity that = (IntellectualEntity) o;
        if (versionNumber != that.versionNumber) {
            return false;
        }
        if (alternativeIdentifiers != null ? !alternativeIdentifiers.equals(that.alternativeIdentifiers) :
            that.alternativeIdentifiers != null) {
            return false;
        }
        if (descriptive != null ? !descriptive.equals(that.descriptive) : that.descriptive != null) {
            return false;
        }
        if (lifeCycleState != null ? !Utils.getValue(lifeCycleState).equals(Utils.getValue(that.lifeCycleState)) : that.lifeCycleState != null) {
            return false;
        }
        if (representations != null ? !representations.equals(that.representations) : that.representations != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + versionNumber;
        result = 31 * result + (alternativeIdentifiers != null ? alternativeIdentifiers.hashCode() : 0);
        result = 31 * result + (descriptive != null ? descriptive.hashCode() : 0);
        result = 31 * result + (representations != null ? representations.hashCode() : 0);
        result = 31 * result + (lifeCycleState != null ? lifeCycleState.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private Identifier identifier;
        private int versionNumber;
        private List<Identifier> alternativeIdentifiers;
        private Object descriptive;
        private List<Representation> representations;
        private LifecycleState lifecycleState;

        public Builder() {
            super();
            this.alternativeIdentifiers = new ArrayList<Identifier>();
            this.representations = new ArrayList<Representation>();
        }

        public Builder(IntellectualEntity orig) {
            IntellectualEntity copy = CopyUtil.deepCopy(IntellectualEntity.class, orig);
            this.identifier = copy.identifier;
            this.descriptive = copy.descriptive;
            this.versionNumber = copy.versionNumber;
			this.alternativeIdentifiers = (copy.alternativeIdentifiers == null ? new ArrayList<Identifier>()
					: new ArrayList<Identifier>(copy.alternativeIdentifiers));
			this.representations = (copy.representations == null ? new ArrayList<Representation>()
					: new ArrayList<Representation>(copy.representations));
            this.lifecycleState = copy.lifeCycleState;
        }

        public Builder alternativeIdentifiers(List<Identifier> alternativeIdentifiers) {
            this.alternativeIdentifiers = new ArrayList<Identifier>(alternativeIdentifiers);
            return this;
        }

        public Builder alternativeIdentifier(Identifier alternativeIdentifier) {
            alternativeIdentifiers.add(alternativeIdentifier);
            return this;
        }

        public IntellectualEntity build() {
            versionNumber = (versionNumber == 0) ? 1 : versionNumber;
            return new IntellectualEntity(this);
        }

        public Builder descriptive(Object descriptive) {
            this.descriptive = descriptive;
            return this;
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder lifecycleState(LifecycleState state) {
            this.lifecycleState = state;
            return this;
        }

        public Builder representations(List<Representation> representations) {
            this.representations = new ArrayList<Representation>(representations);
            return this;
        }

        public Builder representation(Representation representation) {
        	representations.add(representation);
        	return this;
        }

        public Builder versionNumber(int versionNumber) {
            this.versionNumber = versionNumber;
            return this;
        }
    }
}