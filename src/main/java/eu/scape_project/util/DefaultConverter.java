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

package eu.scape_project.util;

import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scape_project.model.BitStream;
import eu.scape_project.model.File;
import eu.scape_project.model.Identifier;
import eu.scape_project.model.IntellectualEntity;
import eu.scape_project.model.LifecycleState;
import eu.scape_project.model.Representation;
import eu.scape_project.model.VersionMetadata;
import gov.loc.audiomd.AudioType;
import gov.loc.mets.AmdSecType;
import gov.loc.mets.DivType;
import gov.loc.mets.DivType.Fptr;
import gov.loc.mets.FileType;
import gov.loc.mets.FileType.FLocat;
import gov.loc.mets.FileType.Stream;
import gov.loc.mets.MdSecType;
import gov.loc.mets.MdSecType.MdRef;
import gov.loc.mets.MdSecType.MdWrap;
import gov.loc.mets.MdSecType.MdWrap.XmlData;
import gov.loc.mets.Mets;
import gov.loc.mets.MetsType;
import gov.loc.mets.MetsType.FileSec;
import gov.loc.mets.MetsType.FileSec.FileGrp;
import gov.loc.mets.MetsType.MetsHdr;
import gov.loc.mets.MetsType.MetsHdr.AltRecordID;
import gov.loc.mets.StructMapType;
import gov.loc.mix.v20.Mix;
import gov.loc.videomd.VideoType;
import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;
import info.lc.xmlns.textmd_v3.TextMD;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.purl.dc.elements._1.ElementContainer;
import uk.org.taverna.ns._2014.scape.Measures;

/**
*
* @author frank asseg
*
*/
public class DefaultConverter extends IntellectualEntityConverter {

    public DefaultConverter() {
        super("scape");
    }

    @Override
    public MetsType convertEntity(IntellectualEntity entity, boolean useMdRef) {
        Mets mets = new Mets();
        if (entity.getIdentifier() != null) {
            mets.setID(entity.getIdentifier().getValue());
            mets.setOBJID(entity.getIdentifier().getValue());
        }
        mets.setPROFILE("scape");

        /* the header part of the mets document */
        addMetsHeader(mets, entity);

        /* create the dmdSec part holding the descriptive metadata */
        addDmdSec(mets, entity, useMdRef);
        addVersionDmdSec(mets, entity.getVersionNumber());

        /* create the interlocked filesec, structmap and amdsec part */
        AmdSecType amdSec = new AmdSecType();
        FileSec fileSec = new FileSec();
        FileGrp fileGrp = new FileGrp();
        fileSec.getFileGrp().add(fileGrp);
        StructMapType structMap = new StructMapType();
        DivType mainDiv = new DivType();
        mainDiv.setTYPE("Intellectual entity");

        /* handle all representations of the intellectual entity */
        if (entity.getRepresentations() != null) {
            for (Representation r : entity.getRepresentations()) {
                String repId =
                        (r.getIdentifier() != null) ? r.getIdentifier()
                                .getValue() : "METS_ID:" +
                                UUID.randomUUID().toString();
                DivType repDiv = new DivType();
                repDiv.setTYPE("Representation");
                repDiv.setID(repId);
                if (r.getTitle() != null) {
                    repDiv.setLabel(r.getTitle());
                }

                /* convert the technical metadata of this representation */
                if (r.getTechnical() != null) {
                    addMetadata(repDiv.getADMID(), amdSec.getTechMD(), r
                            .getTechnical(), useMdRef);
                }

                if (r.getProvenance() != null) {
                    /* convert the provenance metadata of this representation */
                    addMetadata(repDiv.getADMID(), amdSec.getDigiprovMD(), r
                            .getProvenance(), useMdRef);
                }

                if (r.getSource() != null) {
                    /* convert the source metadata of this representation */
                    addMetadata(repDiv.getADMID(), amdSec.getSourceMD(), r
                            .getSource(), useMdRef);
                }

                if (r.getRights() != null) {
                    /* convert the rights metadata of this representation */
                    addMetadata(repDiv.getADMID(), amdSec.getRightsMD(), r
                            .getRights(), useMdRef);
                }

                /* handle all files of this representation */
                if (r.getFiles() != null) {
                	for (File f : r.getFiles()) {
                		/* add each file to the file and Fptr sets */
                		addFile(amdSec, repDiv.getFptr(), fileGrp.getFile(), f,
                				useMdRef);
                	}
                }
                mainDiv.getDiv().add(repDiv);
            }
        }
        structMap.setDiv(mainDiv);
        mets.getStructMap().add(structMap);
        mets.setFileSec(fileSec);
        mets.getAmdSec().add(amdSec);

        return mets;
    }

    private void addFile(AmdSecType amdSec, List<Fptr> pointerList,
            List<FileType> fileList, File f, boolean useMdRef) {
        Fptr ptr = new Fptr();
        FileType metsFile = new FileType();
        String fileId =
                (f.getIdentifier() != null) ? f.getIdentifier().getValue()
                        : "FILE-" + UUID.randomUUID().toString();
        metsFile.setID(fileId);
        metsFile.setSEQ(0);
        metsFile.setMIMETYPE(f.getMimetype());
        FLocat locat = new FLocat();
        locat.setTitle(f.getFilename());
        if (f.getUri() != null) {
            locat.setLOCTYPE("URL");
            locat.setHref(f.getUri().toASCIIString());
        }
        Object filemd = f.getTechnical();
        if (filemd != null) {
            MdSecType filemdsec = createMdSec(filemd, useMdRef);
            amdSec.getTechMD().add(filemdsec);
            metsFile.getADMID().add(filemdsec);
        }
        metsFile.getFLocat().add(locat);

        /*
         * iterate over and add the bitstreams to the mets file and amdsec
         * elements
         */
        if (f.getBitStreams() != null) {
            for (BitStream bs : f.getBitStreams()) {
                Object md = bs.getTechnical();
                FileType.Stream stream = new FileType.Stream();
                if (md != null) {
                    MdSecType mdsec = createMdSec(md, useMdRef);
                    amdSec.getTechMD().add(mdsec);
                    stream.getADMID().add(mdsec);
                }
                String bsId =
                        (bs.getIdentifier() != null) ? bs.getIdentifier()
                                .getValue() : "BITSTREAM-" +
                                UUID.randomUUID().toString();
                stream.setID(bsId);
                metsFile.getStream().add(stream);
            }
        }
        ptr.setFILEID(metsFile);
        pointerList.add(ptr);
        fileList.add(metsFile);
    }

    private MdSecType createMdSec(Object metadata, boolean useMdRef) {
        MdSecType mdSec = new MdSecType();
        mdSec.setID("MD-" + UUID.randomUUID().toString());
        if (useMdRef) {
            MdRef ref = new MdRef();
            ref.setType(metadata.getClass().getSimpleName());
            mdSec.setMdRef(ref);
        } else {

            MdWrap wrap = new MdWrap();
            XmlData data = new XmlData();
            data.getAny().add(metadata);
            wrap.setXmlData(data);
            mdSec.setMdWrap(wrap);
        }
        return mdSec;
    }

    private void addMetadata(List<Object> adm, List<MdSecType> mdSet,
            Object metadata, boolean useMdRef) {
        String mdId = "MD-" + UUID.randomUUID().toString();
        MdSecType mdSec = new MdSecType();
        mdSec.setID(mdId);
        if (useMdRef) {
            MdRef ref = new MdRef();
            ref.setType(metadata.getClass().getSimpleName());
            mdSec.setMdRef(ref);
            adm.add(mdSec);
            mdSet.add(mdSec);
        } else {
            MdWrap mdWrap = new MdWrap();
            XmlData data = new XmlData();
            data.getAny().add(metadata);
            mdWrap.setXmlData(data);
            mdSec.setMdWrap(mdWrap);
            adm.add(mdSec);
            mdSet.add(mdSec);
        }
    }

    private void addVersionDmdSec(Mets mets, int versionNumber) {
        MdSecType dmdSec = new MdSecType();
        MdWrap wrap = new MdWrap();
        XmlData data = new XmlData();
        data.getAny().add(new VersionMetadata(versionNumber));
        wrap.setXmlData(data);
        dmdSec.setMdWrap(wrap);
        mets.getDmdSec().add(dmdSec);
    }

    private void addDmdSec(Mets mets, IntellectualEntity entity,
            boolean useMdRef) {
        MdSecType dmdSec = new MdSecType();
        if (useMdRef) {
            String mdId = "MD-" + UUID.randomUUID().toString();
            MdRef ref = new MdRef();
            ref.setID(mdId);;
            ref.setType(entity.getDescriptive().getClass().getSimpleName());
            dmdSec.setMdRef(ref);
        } else {
            MdWrap wrap = new MdWrap();
            XmlData data = new XmlData();
            Object md = entity.getDescriptive();
            data.getAny().add(entity.getDescriptive());
            wrap.setXmlData(data);
            dmdSec.setMdWrap(wrap);
        }
        mets.getDmdSec().add(dmdSec);
    }

    private void addMetsHeader(Mets mets, IntellectualEntity entity) {
        MetsHdr header = new MetsHdr();

        /*
         * add the alternative identifiers of the entity to the header if they
         * exist
         */
        if (entity.getAlternativeIdentifiers() != null) {
            for (Identifier altId : entity.getAlternativeIdentifiers()) {
                AltRecordID idRec = new AltRecordID();
                idRec.setID(altId.getValue());
                idRec.setTYPE(altId.getType());
                header.getAltRecordID().add(idRec);
            }
        }
        if (entity.getLifecycleState() == null) {
            header.setRECORDSTATUS(LifecycleState.State.NEW.toString());
        } else {
            header.setRECORDSTATUS(entity.getLifecycleState().getState()
                    .toString());
        }
        mets.setMetsHdr(header);
    }

    @Override
    public IntellectualEntity convertMets(MetsType mets) throws JAXBException {
        /* create a SCAPE entity */
        List<Representation> reps = createScapeRepresentations(mets);
        LifecycleState lifecycle = createLifecycleState(mets);
        IntellectualEntity.Builder entity =
                new IntellectualEntity.Builder().identifier(
                        new Identifier(mets.getOBJID())).descriptive(
                        createDC(mets)).lifecycleState(lifecycle)
                        .representations(reps).versionNumber(
                                getVersionNumber(mets));

        /* read the alt IDs from the MetsHeader if they exist */
        if (mets.getMetsHdr().getAltRecordID().size() > 0) {
            List<Identifier> altIds = new ArrayList<Identifier>();
            for (AltRecordID recId : mets.getMetsHdr().getAltRecordID()) {
                altIds.add(new Identifier(recId.getTYPE(), recId.getValue()));
            }
            entity.alternativeIdentifiers(altIds);
        }

        return entity.build();
    }

    private int getVersionNumber(MetsType mets) {
        for (MdSecType dmd : mets.getDmdSec()) {
            final List<Object> mds = dmd.getMdWrap().getXmlData().getAny();
            if (!mds.isEmpty() &&
                    mds.get(0).getClass() == VersionMetadata.class) {
                VersionMetadata data =
                        (VersionMetadata) dmd.getMdWrap().getXmlData().getAny()
                                .get(0);
                return data.getVersionNumber();
            }
        }
        return 1;
    }

    private LifecycleState createLifecycleState(MetsType mets) {
        String state = mets.getMetsHdr().getRECORDSTATUS();
        if (state == null || state.length() == 0) {
            state = "NEW";
        }
        return new LifecycleState("", LifecycleState.State.valueOf(state));
    }

    private Object createDC(MetsType mets) {
        /* use the first dmdSec as the descriptive metadata */
        MdSecType dmdSec = mets.getDmdSec().get(0);
        if (dmdSec.getMdWrap().getXmlData().getAny().size() > 0) {
            return dmdSec.getMdWrap().getXmlData().getAny().get(0);
        }
        return null;
    }

    private List<Representation> createScapeRepresentations(MetsType mets)
            throws JAXBException {
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

    private Representation
            createScapeRepresentation(DivType div, MetsType mets)
                    throws JAXBException {
        String repId =
                (div.getID() != null) ? div.getID() : "rep" +
                        UUID.randomUUID().toString();
        Representation.Builder rep =
                new Representation.Builder(new Identifier(repId));
        if (div.getLabel() != null) {
            rep.title(div.getLabel());
        }
        for (Object o : div.getADMID()) {
            if (o instanceof AmdSecType) {
                AmdSecType amdSec = (AmdSecType) o;
                if (amdSec.getTechMD().size() > 0) {
                    rep.technical(amdSec.getTechMD().get(0).getMdWrap()
                            .getXmlData().getAny().get(0));
                }
                if (amdSec.getSourceMD().size() > 0) {
                    rep.source(amdSec.getSourceMD().get(0).getMdWrap()
                            .getXmlData().getAny().get(0));
                }
                if (amdSec.getRightsMD().size() > 0) {
                    rep.rights(amdSec.getRightsMD().get(0).getMdWrap()
                            .getXmlData().getAny().get(0));
                }
                if (amdSec.getDigiprovMD().size() > 0) {
                    rep.provenance(amdSec.getDigiprovMD().get(0).getMdWrap()
                            .getXmlData().getAny().get(0));
                }
            } else if (o instanceof MdSecType) {
                MdSecType mdSec = (MdSecType) o;
                if (mdSec.getMdWrap().getXmlData().getAny().size() == 0) {
                    continue;
                }
                Object mdObj = mdSec.getMdWrap().getXmlData().getAny().get(0);
                if (mdObj instanceof TextMD || mdObj instanceof Fits ||
                        mdObj instanceof Mix || mdObj instanceof VideoType ||
                        mdObj instanceof AudioType || mdObj instanceof Measures) {
                    /* it's tech md */
                    rep.technical(mdObj);
                } else if (mdObj instanceof JAXBElement<?>) {
                    JAXBElement<?> jaxb = (JAXBElement<?>) mdObj;
                    if (jaxb.getDeclaredType() == PremisComplexType.class) {
                        /* it's provenance md */
                        rep.provenance(jaxb.getValue());
                    } else if (jaxb.getDeclaredType() == RightsComplexType.class) {
                        /* it's rights md */
                        rep.rights(jaxb.getValue());
                    }
                } else if (mdObj instanceof ElementContainer) {
                    /*
                     * it's dc metadata in the representation therefore it's
                     * source md
                     */
                    rep.source(mdObj);
                } else {
                    throw new JAXBException(
                            "Unable to deserialize objects of type " +
                                    ((JAXBElement<?>) mdObj).getDeclaredType()
                                            .getName());
                }
            }
        }
        List<File> files = new ArrayList<File>();
        for (Fptr ptr : div.getFptr()) {
            File.Builder f = new File.Builder();
            FileType metsFile = (FileType) ptr.getFILEID();
            f.identifier(new Identifier(metsFile.getID()));
            if (metsFile.getADMID() != null && metsFile.getADMID().size() > 0) {
                Object o = metsFile.getADMID().get(0);
                if (o instanceof MdSecType) {
                    MdSecType mdSec = (MdSecType) o;
                    if (mdSec.getMdWrap().getXmlData().getAny().size() > 0) {
                        f.technical(mdSec.getMdWrap().getXmlData().getAny()
                                .get(0));
                    }
                } else if (o instanceof AmdSecType) {
                    MdSecType mdsec = ((AmdSecType) o).getTechMD().get(0);
                    f.technical(mdsec);
                }
            }
            List<BitStream> bitstreams = new ArrayList<BitStream>();
            for (Stream stream : metsFile.getStream()) {
                MdSecType mdSec = (MdSecType) stream.getADMID().get(0);
                BitStream.Builder bs =
                        new BitStream.Builder().identifier(new Identifier(
                                stream.getID()));
                if (mdSec.getMdWrap().getXmlData().getAny().size() > 0) {
                    bs.technical(mdSec.getMdWrap().getXmlData().getAny().get(0));
                }
                bitstreams.add(bs.build());
            }
            f.bitStreams(bitstreams);
            if (metsFile.getFLocat().get(0).getHref() != null) {
                f.uri(URI.create(metsFile.getFLocat().get(0).getHref()));
            }
            if (metsFile.getFLocat().get(0).getTitle() != null) {
                f.filename(metsFile.getFLocat().get(0).getTitle());
            }
            f.mimetype(metsFile.getMIMETYPE());
            files.add(f.build());
        }
        rep.files(files);
        return rep.build();
    }
}
