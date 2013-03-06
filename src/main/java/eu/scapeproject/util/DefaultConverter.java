package eu.scapeproject.util;

import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.LifecycleState;
import eu.scapeproject.model.Representation;
import gov.loc.mets.AmdSecType;
import gov.loc.mets.DivType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mets.FileType;
import gov.loc.mets.FileType.FLocat;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MdSecType.MdWrap;
import gov.loc.mets.MdSecType.MdWrap.XmlData;
import gov.loc.mets.Mets;
import gov.loc.mets.MetsType;
import gov.loc.mets.MetsType.FileSec;
import gov.loc.mets.MetsType.FileSec.FileGrp;
import gov.loc.mets.MetsType.MetsHdr;
import gov.loc.mets.MetsType.StructLink;
import gov.loc.mets.StructMapType;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefaultConverter extends IntellectualEntityConverter {
    public DefaultConverter() {
        super("scape");
    }

    @Override
    public MetsType convertEntity(IntellectualEntity entity) {
        Mets mets = new Mets();
        mets.setID(entity.getIdentifier().getValue());
        mets.setOBJID(entity.getIdentifier().getValue());
        mets.setPROFILE("scape");

        /* the header part of the mets document */
        MetsHdr header = new MetsHdr();
        if (entity.getLifecycleState() == null){
            header.setRECORDSTATUS(LifecycleState.State.NEW.toString());
        }else{
            header.setRECORDSTATUS(entity.getLifecycleState().getState().toString());
        }
        mets.setMetsHdr(header);

        /* create the dmdSec part holding the descriptive metadata */
        MdSecType dmdSec = new MdSecType();
        MdWrap wrap = new MdWrap();
        XmlData data = new XmlData();
        System.out.println(entity.getDescriptive().getClass());
        data.getAny().add(entity.getDescriptive());
        wrap.setXmlData(data);
        dmdSec.setMdWrap(wrap);
        mets.getDmdSec().add(dmdSec);
        
        /* create the interlocked filesec, structmap and amdsec part */
        AmdSecType amdSec = new AmdSecType();
        FileSec fileSec = new FileSec();
        FileGrp fileGrp = new FileGrp();
        fileSec.getFileGrp().add(fileGrp);
        StructMapType structMap = new StructMapType();
        DivType mainDiv = new DivType();
        mainDiv.setTYPE("Intellectual entity");
        int fileCount = 0;
        int repCount = 0;
        
        /* handle all representations of the intellectual entity */
        for (Representation r : entity.getRepresentations()) {
            String repId = "REP-" + repCount;
            DivType repDiv = new DivType();
            repDiv.setTYPE("Representation");
            repDiv.setID(repId);
            
            /* convert the technical metadata of this representation */
            String techId = "TECH-REP-" + ++repCount;
            MdSecType techMd= new MdSecType();
            MdWrap techWrap = new MdWrap();
            XmlData techData = new XmlData();
            techData.getAny().add(r.getTechnical());
            techWrap.setXmlData(techData);
            techMd.setMdWrap(techWrap);
            techMd.setID(techId);
            repDiv.getADMID().add(techMd);
            amdSec.getTechMD().add(techMd);

            /* convert the provenance metadata of this representation */
            String provId = "PROV-REP-" + ++repCount;
            MdSecType provMd= new MdSecType();
            MdWrap provWrap = new MdWrap();
            XmlData provData = new XmlData();
            provData.getAny().add(r.getProvenance());
            provWrap.setXmlData(provData);
            provMd.setMdWrap(provWrap);
            provMd.setID(provId);
            repDiv.getADMID().add(provMd);
            amdSec.getDigiprovMD().add(provMd);
            
            /* convert the source metadata of this representation */
            String sourceId = "SOURCE-REP-" + ++repCount;
            MdSecType sourceMd= new MdSecType();
            MdWrap sourceWrap = new MdWrap();
            XmlData sourceData = new XmlData();
            sourceData.getAny().add(r.getSource());
            sourceWrap.setXmlData(sourceData);
            sourceMd.setMdWrap(sourceWrap);
            sourceMd.setID(sourceId);
            repDiv.getADMID().add(sourceMd);
            amdSec.getSourceMD().add(sourceMd);

            /* convert the rights metadata of this representation */
            String rightsId = "RIGHTS-REP-" + ++repCount;
            MdSecType rightsMd= new MdSecType();
            MdWrap rightsWrap = new MdWrap();
            XmlData rightsData = new XmlData();
            rightsData.getAny().add(r.getRights());
            rightsWrap.setXmlData(rightsData);
            rightsMd.setMdWrap(rightsWrap);
            rightsMd.setID(rightsId);
            repDiv.getADMID().add(rightsMd);
            amdSec.getRightsMD().add(rightsMd);

            /* handle all files of this representation */
            for (File f : r.getFiles()) {
                String fileId = "file-" + ++fileCount;
                Fptr ptr = new Fptr();
                FileType metsFile = new FileType();
                metsFile.setID(fileId);
                metsFile.setSEQ(0);
                FLocat locat = new FLocat();
                locat.setLOCTYPE("URL");
                locat.setHref(f.getUri().toASCIIString());
                metsFile.getFLocat().add(locat);
                ptr.setFILEID(metsFile);
                repDiv.getFptr().add(ptr);
                fileGrp.getFile().add(metsFile);
            }
            mainDiv.getDiv().add(repDiv);
        }
        structMap.setDiv(mainDiv);
        mets.getStructMap().add(structMap);
        mets.setFileSec(fileSec);
        mets.getAmdSec().add(amdSec);

        return mets;
    }



    @Override
    public IntellectualEntity convertMets(MetsType mets) {
        /* create a SCAPE entity */
        List<Representation> reps = createScapeRepresentations(mets);
        IntellectualEntity.Builder entity = new IntellectualEntity.Builder()
                .identifier(new Identifier(mets.getOBJID()))
                .descriptive(createDC(mets))
                .representations(reps);
        return entity.build();
    }

    private Object createDC(MetsType mets) {
        /* use the firs dmdSec as the descriptive metadata */
        MdSecType dmdSec = mets.getDmdSec().get(0);
        return dmdSec.getMdWrap().getXmlData().getAny().get(0);
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
                rep.technical(amdSec.getTechMD().get(0).getMdWrap().getXmlData().getAny().get(0));
            }
            if (amdSec.getSourceMD().size() > 0) {
                rep.source(amdSec.getSourceMD().get(0).getMdWrap().getXmlData().getAny().get(0));
            }
            if (amdSec.getRightsMD().size() > 0) {
                rep.rights(amdSec.getRightsMD().get(0).getMdWrap().getXmlData().getAny().get(0));
            }
            if (amdSec.getDigiprovMD().size() > 0) {
                rep.provenance(amdSec.getDigiprovMD().get(0).getMdWrap().getXmlData().getAny().get(0));
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
