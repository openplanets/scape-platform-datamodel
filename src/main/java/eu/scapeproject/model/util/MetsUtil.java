package eu.scapeproject.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import eu.scapeproject.dto.mets.MetsAMDSec;
import eu.scapeproject.dto.mets.MetsAgent;
import eu.scapeproject.dto.mets.MetsDMDSec;
import eu.scapeproject.dto.mets.MetsDigiProvMD;
import eu.scapeproject.dto.mets.MetsDiv;
import eu.scapeproject.dto.mets.MetsDocument;
import eu.scapeproject.dto.mets.MetsFile;
import eu.scapeproject.dto.mets.MetsFileGrp;
import eu.scapeproject.dto.mets.MetsFileLocation;
import eu.scapeproject.dto.mets.MetsFileSec;
import eu.scapeproject.dto.mets.MetsHeader;
import eu.scapeproject.dto.mets.MetsMDWrap;
import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.dto.mets.MetsRightsMD;
import eu.scapeproject.dto.mets.MetsSourceMD;
import eu.scapeproject.dto.mets.MetsStructMap;
import eu.scapeproject.dto.mets.MetsTechMD;
import eu.scapeproject.dto.mets.MetsXMLData;
import eu.scapeproject.model.Agent;
import eu.scapeproject.model.File;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.UUIDIdentifier;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

public abstract class MetsUtil {

    public static MetsDocument convertEntity(IntellectualEntity entity) {
        DCMetadata dc = (DCMetadata) entity.getDescriptive();
        MetsDMDSec dmdSec = convertDCMetadata(dc);
        List<MetsAMDSec> amdSecs = getAMDSecs(entity.getRepresentations());
        MetsDocument.Builder docBuilder = new MetsDocument.Builder();
        docBuilder.dmdSec(dmdSec)
                .id(new UUIDIdentifier().getValue())
                .addHeader(getMetsHeader(entity))
                .amdSecs(amdSecs)
                .fileSecs(getFileSecs(entity.getRepresentations()))
                .label(((DCMetadata) entity.getDescriptive()).getTitle().get(0))
                .objId(entity.getIdentifier().getValue())
                .structMaps(getStructMaps(entity, amdSecs, dmdSec.getId()));

        return docBuilder.build();
    }

    private static List<MetsStructMap> getStructMaps(IntellectualEntity entity, List<MetsAMDSec> amdSecs, String dmdId) {
        if (entity == null) {
            return null;
        }
        List<MetsStructMap> maps = new ArrayList<MetsStructMap>();
        MetsDiv.Builder entityDivBuilder = new MetsDiv.Builder()
                .id(new UUIDIdentifier().getValue())
                .dmdId(dmdId)
                .label(((DCMetadata) entity.getDescriptive()).getTitle().get(0))
                .type("IntellectualEntity");

        MetsStructMap.Builder structMapBuilder = new MetsStructMap.Builder();
        for (MetsAMDSec amdSec : amdSecs) {
            MetsDiv.Builder repDivBuilder=new MetsDiv.Builder()
            .id(new UUIDIdentifier().getValue())
            .type("Representation")
            .label("Representation of Intellectual Entity")
            .addSubDiv(getDiv("techMD",amdSec.getId()))
            .addSubDiv(getDiv("digiProvMD",amdSec.getId()))
            .addSubDiv(getDiv("sourceMD",amdSec.getId()))
            .addSubDiv(getDiv("rightsMD",amdSec.getId()));
            entityDivBuilder.addSubDiv(repDivBuilder.build());
        }
        structMapBuilder.addDivision(entityDivBuilder.build());
        maps.add(structMapBuilder.build());
        return maps;
    }

    private static MetsDiv getDiv(String type, String id) {
        return new MetsDiv.Builder()
            .id(new UUIDIdentifier().getValue())
            .type(type)
            .admId(id)
            .build();
    }

    private static List<MetsFileSec> getFileSecs(List<Representation> representations) {
        if (representations == null) {
            return null;
        }
        List<MetsFileSec> fileSecs = new ArrayList<MetsFileSec>();
        for (Representation r : representations) {
            MetsFileGrp group = new MetsFileGrp.Builder(new UUIDIdentifier().getValue()).build();
            List<MetsFile> files = new ArrayList<MetsFile>();
            for (File f : r.getFiles()) {
                files.add(new MetsFile.Builder(new UUIDIdentifier().getValue())
                        .addfileLocation(new MetsFileLocation.Builder(new UUIDIdentifier().getValue())
                                .build())
                        .build());
            }
            fileSecs.add(new MetsFileSec(new UUIDIdentifier().getValue(), Arrays.asList(new MetsFileGrp.Builder(new UUIDIdentifier()
                    .getValue()).files(files).build())));
        }
        return fileSecs;
    }

    private static List<MetsAMDSec> getAMDSecs(List<Representation> representations) {
        if (representations == null) {
            return null;
        }
        List<MetsAMDSec> amdSecs = new ArrayList<MetsAMDSec>();
        for (Representation r : representations) {
            MetsAMDSec.Builder amdBuilder = new MetsAMDSec.Builder();
            amdBuilder.provenanceMetadata(getProvenance(r))
                    .rightsMetadata(getRights(r))
                    .sourceMetadata(getSource(r))
                    .technicalMetadata(getTechnical(r))
                    .id(new UUIDIdentifier().getValue());
            amdSecs.add(amdBuilder.build());
        }
        return amdSecs;
    }

    private static MetsTechMD getTechnical(Representation r) {
        return new MetsTechMD.Builder()
                .metadataWrapper(createMetsWrapper(r.getTechnical()))
                .build();
    }

    private static MetsSourceMD getSource(Representation r) {
        return new MetsSourceMD.Builder()
                .metadataWrapper(createMetsWrapper(r.getTechnical()))
                .build();
    }

    private static MetsRightsMD getRights(Representation r) {
        return new MetsRightsMD.Builder()
                .metadataWrapper(createMetsWrapper(r.getTechnical()))
                .build();
    }

    private static MetsDigiProvMD getProvenance(Representation r) {
        return new MetsDigiProvMD.Builder()
                .metadataWrapper(createMetsWrapper(r.getTechnical()))
                .build();
    }

    private static MetsHeader getMetsHeader(IntellectualEntity entity) {
        MetsHeader.Builder hdrBuilder = new MetsHeader.Builder(new UUIDIdentifier().getValue());
        hdrBuilder.agents(getAgentList((DCMetadata) entity.getDescriptive()));
        return hdrBuilder.build();
    }

    private static MetsMDWrap createMetsWrapper(MetsMetadata data) {
        MetsMDWrap.Builder builder = new MetsMDWrap.Builder(new MetsXMLData(data));
        if (data instanceof DCMetadata) {
            builder.mdType("DC");
        } else if (data instanceof VideoMDMetadata) {
            builder.mdType("OTHER");
            builder.otherMdType("VIDEOMD");
        } else if (data instanceof AudioMDMetadata) {
            builder.mdType("OTHER");
            builder.otherMdType("AudioMD");
        } else if (data instanceof TextMDMetadata) {
            builder.mdType("TEXTMD");
        } else if (data instanceof NisoMixMetadata) {
            builder.mdType("NISOIMG");
        } else if (data instanceof PremisProvenanceMetadata) {
            builder.mdType("PREMIS:EVENT");
        } else if (data instanceof PremisRightsMetadata) {
            builder.mdType("PREMIS:RIGHTS");
        } else if (data instanceof FitsMetadata) {
            builder.mdType("PREMIS:RIGHTS");
        }
        return builder.build();
    }

    public static MetsDMDSec convertDCMetadata(DCMetadata dc) {

        final String dmdId = "dmd-" + new UUIDIdentifier().getValue();
        final String admId = "adm-" + new UUIDIdentifier().getValue();
        final Date created = dc.getDate().get(0);

        return new MetsDMDSec.Builder(dmdId)
                .admId(admId)
                .created(created)
                .metadataWrapper(createMetsWrapper(dc))
                .build();
    }

    public static List<MetsAgent> getAgentList(DCMetadata dc) {
        List<MetsAgent> agents = new ArrayList<MetsAgent>();
        if (dc.getConstributors() != null) {
            for (final Agent contributor : dc.getConstributors()) {
                final MetsAgent agent = new MetsAgent.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .name(contributor.getName())
                        .role(contributor.getRole())
                        .otherRole(contributor.getOtherRole())
                        .type(contributor.getType())
                        .otherType(contributor.getOtherType())
                        .note(contributor.getNote())
                        .build();
                agents.add(agent);
            }
        }
        if (dc.getCreator() != null) {
            for (final Agent creator : dc.getCreator()) {
                final MetsAgent agent = new MetsAgent.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .name(creator.getName())
                        .role(creator.getRole())
                        .otherRole(creator.getOtherRole())
                        .type(creator.getType())
                        .otherType(creator.getOtherType())
                        .note(creator.getNote())
                        .build();
                agents.add(agent);
            }
        }
        return agents;
    }

}
