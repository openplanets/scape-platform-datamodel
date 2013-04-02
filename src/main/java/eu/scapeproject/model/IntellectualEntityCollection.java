package eu.scapeproject.model;

import java.util.List;

public class IntellectualEntityCollection {
	private final List<IntellectualEntity> entities;

	public IntellectualEntityCollection(List<IntellectualEntity> entities) {
		super();
		this.entities = entities;
	}

	@SuppressWarnings("unused")
	private IntellectualEntityCollection() {
		this.entities = null;
	}

	public List<IntellectualEntity> getEntities() {
		return entities;
	}
}