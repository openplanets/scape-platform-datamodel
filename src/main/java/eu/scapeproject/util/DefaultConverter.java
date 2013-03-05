package eu.scapeproject.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import gov.loc.mets.AmdSecType;
import gov.loc.mets.DivType;
import gov.loc.mets.FileType;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MetsType;
import gov.loc.mets.StructMapType;
import gov.loc.mets.DivType.Fptr;

public class DefaultConverter extends IntellectualEntityConverter {
    public DefaultConverter() {
        super("scape");
    }

    @Override
    public IntellectualEntity convertMets(MetsType mets) {
        /* create a SCAPE entity */
        List<Representation> reps = createScapeRepresentations(mets);
        IntellectualEntity.Builder entity = new IntellectualEntity.Builder()
                .identifier(new Identifier(mets.getOBJID()))
                .representations(reps);
        return entity.build();
    }

    private List<Representation> createScapeRepresentations(MetsType mets) {
        List<Representation> reps = new ArrayList<Representation>();
        for (StructMapType structmap : mets.getStructMap()) {
            DivType div = structmap.getDiv();
            if (div.getTYPE().equals("Intellectual entity")) {
                for (DivType subDiv : div.getDiv()) {
                    reps.add(createScapeRepresentation(subDiv, mets));
                }
            }
        }
        return reps;
    }

    private Representation createScapeRepresentation(DivType div, MetsType mets) {
        Representation.Builder rep = new Representation.Builder(new Identifier("rep" + UUID.randomUUID().toString()));
        for (Object o : div.getADMID()) {
            AmdSecType amdSec = (AmdSecType) o;
            if (amdSec.getTechMD().size() > 0) {
                rep.technical(amdSec.getTechMD().get(0));
            }
            if (amdSec.getSourceMD().size() > 0) {
                rep.source(amdSec.getSourceMD().get(0));
            }
            if (amdSec.getRightsMD().size() > 0) {
                rep.rights(amdSec.getRightsMD().get(0));
            }
            if (amdSec.getDigiprovMD().size() > 0) {
                rep.provenance(amdSec.getDigiprovMD().get(0));
            }
        }
        for (Fptr ptr : div.getFptr()) {
            File.Builder f = new File.Builder();
            FileType metsFile = (FileType) ptr.getFILEID();
            f.identifier(new Identifier(metsFile.getID()));
            if (metsFile.getADMID() != null && metsFile.getADMID().size() > 0) {
                AmdSecType amd = (AmdSecType) metsFile.getADMID().get(0);
                if (amd.getTechMD() != null && amd.getTechMD().size() > 0) {
                    MdSecType mdSec = (MdSecType) amd.getTechMD().get(0);
                    f.technical(mdSec.getMdWrap().getXmlData());
                }
            }
            f.uri(URI.create(metsFile.getFLocat().get(0).getHref()));
            rep.file(f.build());
        }
        return rep.build();
    }
}
