package eu.scapeproject.model;

import gov.loc.mets.MetsType;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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