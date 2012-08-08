package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.List;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.util.CopyUtil;

public class IntellectualEntity {

	private final Identifier identifier;
	private final int versionNumber;
	private final List<Identifier> alternativeIdentifiers;
	private final DescriptiveMetadata descriptive;
	private final List<Representation> representations;
	private final LifecycleState lifeCycleState;

	@SuppressWarnings("unused")
	private IntellectualEntity() {
		super();
		this.identifier = null;
		this.alternativeIdentifiers = null;
		this.descriptive = null;
		this.representations = null;
		this.lifeCycleState = null;
		this.versionNumber = 1;
	}

	public IntellectualEntity(Builder builder) {
		this.identifier = builder.identifier;
		this.alternativeIdentifiers = builder.alternativeIdentifiers;
		this.descriptive = builder.descriptive;
		this.representations = builder.representations;
		this.lifeCycleState = builder.lifecycleState;
		this.versionNumber = builder.versionNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntellectualEntity other = (IntellectualEntity) obj;
		if (alternativeIdentifiers == null) {
			if (other.alternativeIdentifiers != null)
				return false;
		} else if (!alternativeIdentifiers.equals(other.alternativeIdentifiers))
			return false;
		if (descriptive == null) {
			if (other.descriptive != null)
				return false;
		} else if (!descriptive.equals(other.descriptive))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (lifeCycleState == null) {
			if (other.lifeCycleState != null)
				return false;
		} else if (!lifeCycleState.equals(other.lifeCycleState))
			return false;
		if (representations == null) {
			if (other.representations != null)
				return false;
		} else if (!representations.equals(other.representations))
			return false;
		if (versionNumber != other.versionNumber)
			return false;
		return true;
	}

	public List<Identifier> getAlternativeIdentifiers() {
		return alternativeIdentifiers;
	}

	public DescriptiveMetadata getDescriptive() {
		return descriptive;
	}

	public Identifier getIdentifier() {
		return identifier;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativeIdentifiers == null) ? 0 : alternativeIdentifiers.hashCode());
		result = prime * result + ((descriptive == null) ? 0 : descriptive.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((lifeCycleState == null) ? 0 : lifeCycleState.hashCode());
		result = prime * result + ((representations == null) ? 0 : representations.hashCode());
		result = prime * result + versionNumber;
		return result;
	}

	public static class Builder {
		private Identifier identifier;
		private int versionNumber;
		private List<Identifier> alternativeIdentifiers;
		private DescriptiveMetadata descriptive;
		private List<Representation> representations;
		private LifecycleState lifecycleState;

		public Builder() {
			super();
		}

		public Builder(IntellectualEntity orig) {
			orig=CopyUtil.deepCopy(IntellectualEntity.class, orig);
			this.identifier = orig.getIdentifier();
			this.descriptive = orig.descriptive;
			this.alternativeIdentifiers = orig.alternativeIdentifiers;
			this.representations = orig.representations;
			this.lifecycleState = orig.lifeCycleState;
			this.versionNumber = orig.versionNumber;
		}

		public Builder alternativeIdentifiers(List<Identifier> alternativeIdentifiers) {
			this.alternativeIdentifiers = alternativeIdentifiers;
			return this;
		}

		public IntellectualEntity build() {
			versionNumber = (versionNumber == 0) ? 1 : versionNumber;
			return new IntellectualEntity(this);
		}

		public Builder descriptive(DescriptiveMetadata descriptive) {
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
			this.representations = representations;
			return this;
		}

		public Builder versionNumber(int versionNumber) {
			this.versionNumber = versionNumber;
			return this;
		}
	}

}
