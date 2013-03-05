package eu.scapeproject.util;

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

    public abstract IntellectualEntity convertMets(MetsType mets);
}
