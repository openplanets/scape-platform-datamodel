package eu.scapeproject.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eu.scapeproject.model.LifecycleState.State;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;

public class IntellectualEntity {

	private final Identifier identifier;
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
	}

	public IntellectualEntity(Builder builder) {
		this.identifier = builder.identifier;
		this.alternativeIdentifiers = builder.alternativeIdentifiers;
		this.descriptive = builder.descriptive;
		this.representations = builder.representations;
		this.lifeCycleState = builder.lifecycleState;
	}

	public LifecycleState getLifecycleState() {
		return lifeCycleState;
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

	public List<Representation> getRepresentations() {
		return representations;
	}

	public static class Builder {
		private Identifier identifier;
		private List<Identifier> alternativeIdentifiers;
		private DescriptiveMetadata descriptive;
		private List<Representation> representations;
		private LifecycleState lifecycleState;

		public Builder() {
			super();
		}

		public Builder(IntellectualEntity orig) {
			this.identifier = new Identifier(orig.getIdentifier().type, orig.getIdentifier().value) {};
			this.descriptive = new DCMetadata.Builder((DCMetadata) orig.descriptive).build();
			if (orig.alternativeIdentifiers != null) {
				this.alternativeIdentifiers = new ArrayList<Identifier>();
				for (Identifier id : orig.alternativeIdentifiers) {
					this.alternativeIdentifiers.add(new Identifier(new String(id.type), new String(id.value)) {});
				}
			}
			if (orig.representations != null) {
				this.representations = new ArrayList<Representation>();
				for (Representation r:representations){
					this.representations.add(new Representation.Builder(r).build());
				}
			}
			if (orig.lifeCycleState != null){
				this.lifecycleState = new LifecycleState(new String(orig.lifeCycleState.getDetails()), orig.lifeCycleState.getState());
			}
		}

		public Builder identifier(Identifier identifier) {
			this.identifier = identifier;
			return this;
		}

		public Builder alternaticeIdentifiers(List<Identifier> alternativeIdentifiers) {
			this.alternativeIdentifiers = alternativeIdentifiers;
			return this;
		}

		public Builder descriptive(DescriptiveMetadata descriptive) {
			this.descriptive = descriptive;
			return this;
		}

		public Builder representations(List<Representation> representations) {
			this.representations = representations;
			return this;
		}

		public Builder lifecycleState(LifecycleState state) {
			this.lifecycleState = state;
			return this;
		}

		public IntellectualEntity build() {
			return new IntellectualEntity(this);
		}
	}

}
