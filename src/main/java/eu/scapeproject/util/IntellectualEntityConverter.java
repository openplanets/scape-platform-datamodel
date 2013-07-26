package eu.scapeproject.util;

import javax.xml.bind.JAXBException;

import eu.scapeproject.model.IntellectualEntity;
import gov.loc.mets.MetsType;

public abstract class IntellectualEntityConverter {
    private final String profileName;

    public IntellectualEntityConverter(String profileName) {
        super();
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    public abstract IntellectualEntity convertMets(MetsType mets) throws JAXBException;


    public MetsType convertEntity(IntellectualEntity entity) {
        return this.convertEntity(entity, false);
    }

    public abstract MetsType convertEntity(IntellectualEntity entity, boolean useMdRef);
}
