package eu.scapeproject.model.mets;

import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import eu.scapeproject.dto.mets.MetsAMDSec;
import eu.scapeproject.dto.mets.MetsAgent;
import eu.scapeproject.dto.mets.MetsAlternativeIdentifer;
import eu.scapeproject.dto.mets.MetsDMDSec;
import eu.scapeproject.dto.mets.MetsDigiProvMD;
import eu.scapeproject.dto.mets.MetsDiv;
import eu.scapeproject.dto.mets.MetsDocument;
import eu.scapeproject.dto.mets.MetsFile;
import eu.scapeproject.dto.mets.MetsFileGrp;
import eu.scapeproject.dto.mets.MetsFileLocation;
import eu.scapeproject.dto.mets.MetsFilePtr;
import eu.scapeproject.dto.mets.MetsFileSec;
import eu.scapeproject.dto.mets.MetsHeader;
import eu.scapeproject.dto.mets.MetsMDWrap;
import eu.scapeproject.dto.mets.MetsRightsMD;
import eu.scapeproject.dto.mets.MetsSourceMD;
import eu.scapeproject.dto.mets.MetsStream;
import eu.scapeproject.dto.mets.MetsStructMap;
import eu.scapeproject.dto.mets.MetsTechMD;
import eu.scapeproject.model.Agent;
import eu.scapeproject.model.BitStream;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.UUIDIdentifier;
import eu.scapeproject.model.jaxb.MetsNamespacePrefixMapper;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.Event;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;

public class MetsFactory {
    private static final String SCAPE_PROFILE = "http://example.com/scape-mets-profile.xml";
    private final Marshaller marshaller;
    private static MetsFactory INSTANCE;

    public static MetsFactory getInstance() throws JAXBException {
        if (INSTANCE == null) {
            INSTANCE = new MetsFactory();
        }
        return INSTANCE;
    }

    private MetsFactory() throws JAXBException {
        super();
        final JAXBContext ctx = JAXBContext.newInstance(MetsDocument.class, DCMetadata.class, TextMDMetadata.class, NisoMixMetadata.class,
                PremisProvenanceMetadata.class, PremisRightsMetadata.class);
        marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
    }

    private MetsDMDSec createMetsDMDSec(final DescriptiveMetadata metadata) {
        final String dmdId = new UUIDIdentifier().getValue();
        final String admId = new UUIDIdentifier().getValue();
        final DCMetadata dc = (DCMetadata) metadata;
        final Date created = dc.getDate().get(0);
        return new MetsDMDSec.Builder(dmdId)
                .admId(admId)
                .created(created)
                .metadataWrapper(new MetsMDWrap(metadata))
                .build();
    }

    public void serialize(final IntellectualEntity entity, final OutputStream out) throws JAXBException {
        // TODO: still have split up this ugly monstrous method into multiple
        // methods
        // It's not 1970 and we're not coding in c ;)
        final Identifier docId = new UUIDIdentifier();
        final Identifier headerId = new UUIDIdentifier();
        final List<MetsAgent> agents = new ArrayList<MetsAgent>();
        final List<MetsAMDSec> amdSecs = new ArrayList<MetsAMDSec>();
        final List<MetsFileGrp> fileGroups = new ArrayList<MetsFileGrp>();

        final DCMetadata dc = (DCMetadata) entity.getDescriptive();
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
        
        final MetsDMDSec dmdSec=createMetsDMDSec(entity.getDescriptive());
                
        MetsDiv.Builder entityDivBuilder=new MetsDiv.Builder()
            .id(new UUIDIdentifier().getValue())
            .dmdId(dmdSec.getId())
            .label(dc.getTitle().get(0))
            .type("IntellectualEntity");
            
        for (final Representation rep : entity.getRepresentations()) {
            final MetsDigiProvMD digiProvMd = new MetsDigiProvMD.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .metadataWrapper(new MetsMDWrap(rep.getProvenance()))
                    .build();
            final MetsTechMD techMd = new MetsTechMD.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .metadataWrapper(new MetsMDWrap(rep.getTechnical()))
                    .build();
            final MetsSourceMD sourceMD = new MetsSourceMD.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .metadataWrapper(new MetsMDWrap(rep.getSource()))
                    .build();
            final MetsRightsMD rightsMD = new MetsRightsMD.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .metadataWrapper(new MetsMDWrap(rep.getRights()))
                    .build();
            final MetsAMDSec entityAmdSec = new MetsAMDSec.Builder()
                    .provenanceMetadata(digiProvMd)
                    .technicalMetadata(techMd)
                    .rightsMetadata(rightsMD)
                    .sourceMetadata(sourceMD)
                    .build();
            final MetsDiv techDiv = new MetsDiv.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .type("techMD")
                    .admId(techMd.getId())
                    .build();
            final MetsDiv rightsDiv = new MetsDiv.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .type("rightsMD")
                    .admId(rightsMD.getId())
                    .build();
            final MetsDiv digiProvDiv = new MetsDiv.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .type("digiProvMD")
                    .admId(rightsMD.getId())
                    .build();
            final MetsDiv sourceDiv = new MetsDiv.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .type("sourceMD")
                    .admId(rightsMD.getId())
                    .build();
            final MetsDiv.Builder divBuilder = new MetsDiv.Builder()
                    .id(new UUIDIdentifier().getValue())
                    .type("Representation")
                    .label("Representation of Intellectuall entity " + entity.getIdentifier().getValue())
                    .addSubDiv(techDiv)
                    .addSubDiv(rightsDiv)
                    .addSubDiv(digiProvDiv)
                    .addSubDiv(sourceDiv);
            
            amdSecs.add(entityAmdSec);
            entityDivBuilder.admId(entityAmdSec.getId());
            
            if (rep.getProvenance() instanceof PremisProvenanceMetadata) {
                for (final Event e : ((PremisProvenanceMetadata) rep.getProvenance()).getEvents()) {
                    for (final Agent a : e.getLinkingAgents()) {
                        final MetsAgent agent = new MetsAgent.Builder()
                                .id(new UUIDIdentifier().getValue())
                                .name(a.getName())
                                .role(a.getRole())
                                .otherRole(a.getOtherRole())
                                .type(a.getType())
                                .otherType(a.getOtherType())
                                .note(a.getNote())
                                .build();
                        agents.add(agent);
                    }
                }
            }
            final List<MetsFile> files = new ArrayList<MetsFile>();
            final List<MetsFilePtr> pointers = new ArrayList<MetsFilePtr>();
            for (final File f : rep.getFiles()) {
                final List<MetsFileLocation> locations = new ArrayList<MetsFileLocation>();
                for (final URI uri : f.getUris()) {
                    MetsFileLocation loc = new MetsFileLocation.Builder(new UUIDIdentifier().getValue())
                            .href(uri)
                            .build();
                    locations.add(loc);
                }
                String fileBuilderId=new UUIDIdentifier().getValue();
                final MetsFile.Builder fileBuilder = new MetsFile.Builder(fileBuilderId)
                        .fileLocations(locations);

                final MetsFilePtr p = new MetsFilePtr.Builder()
                        .fileId(fileBuilderId)
                        .id(new UUIDIdentifier().getValue())
                        .build();
                pointers.add(p);

                final MetsTechMD fileTechMD = new MetsTechMD.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .metadataWrapper(new MetsMDWrap(f.getTechnical()))
                        .build();

                final MetsAMDSec fileAmdSec = new MetsAMDSec.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .technicalMetadata(fileTechMD)
                        .build();
                amdSecs.add(fileAmdSec);
                
                final MetsDiv fileTechDiv = new MetsDiv.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .type("techMD")
                        .admId(fileTechMD.getId())
                        .build();

                final MetsDiv fileDiv = new MetsDiv.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .admId(fileBuilderId)
                        .addSubDiv(fileTechDiv)
                        .type("File")
                        .build();
                divBuilder.addSubDiv(fileDiv);
                
                for (BitStream bs:f.getBitStreams()){
                    final MetsTechMD bsTechMd=new MetsTechMD.Builder()
                        .id(new UUIDIdentifier().getValue())
                        .metadataWrapper(new MetsMDWrap(bs.getTechnical()))
                        .build();
                    final MetsStream stream=new MetsStream.Builder()
                        .amdMdId(bsTechMd.getId())
                        .build();
                    fileBuilder.addStream(stream);
                }
                
                files.add(fileBuilder.build());
            }
            final MetsFileGrp group = new MetsFileGrp.Builder(new UUIDIdentifier().getValue())
                    .files(files)
                    .build();
            fileGroups.add(group);
            entityDivBuilder.addSubDiv(divBuilder.build());
        }

        final MetsHeader.Builder hdrBuilder = new MetsHeader.Builder(headerId.getValue())
                .createdDate(new Date())
                .agents(agents);
        final List<MetsAlternativeIdentifer> alternativeIdentifiers = new ArrayList<MetsAlternativeIdentifer>();
        for (final Identifier i : entity.getAlternativeIdentifiers()) {
            alternativeIdentifiers.add(new MetsAlternativeIdentifer(i.getType(), i.getValue()));
        }
        hdrBuilder.alternativeIdentifiers(alternativeIdentifiers);

        final MetsStructMap structMap = new MetsStructMap.Builder()
                .divisions(Arrays.asList(entityDivBuilder.build()))
                .id(new UUIDIdentifier().getValue())
                .build();

        final MetsDocument doc = new MetsDocument.Builder()
                .id(docId.getValue())
                .label(dc.getTitle().get(0))
                .objId(entity.getIdentifier().getValue())
                .profile(SCAPE_PROFILE)
                .dmdSec(dmdSec)
                .amdSecs(amdSecs)
                .fileSecs(Arrays.asList(new MetsFileSec(new UUIDIdentifier().getValue(), fileGroups)))
                .structMaps(Arrays.asList(structMap))
                .headers(Arrays.asList(hdrBuilder.build()))
                .build();
        marshaller.marshal(doc, out);
    }
}
