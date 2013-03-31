package eu.scapeproject.model;

import gov.loc.mets.Mets;
import gov.loc.mets.MetsType;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entity-list", namespace = "http://scapeproject.eu/model")
public class __IntellectualEntityCollection {
	@XmlElement(name = "mets", namespace = "http://www.loc.gov/METS/")
	private final List<Mets> mets;

	public __IntellectualEntityCollection(){
		super();
		this.mets = null;
	}
	public __IntellectualEntityCollection(List<Mets> mets) {
		super();
		this.mets = mets;
	}

	public List<Mets> getMets() {
		return mets;
	}
}
