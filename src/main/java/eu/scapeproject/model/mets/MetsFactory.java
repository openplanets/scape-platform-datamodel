package eu.scapeproject.model.mets;

import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import eu.scapeproject.model.Agent;
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
    private Marshaller marshaller;
    private static MetsFactory INSTANCE;

    private MetsFactory() throws JAXBException {
        super();
        JAXBContext ctx = JAXBContext.newInstance(MetsDocument.class,DCMetadata.class,TextMDMetadata.class,NisoMixMetadata.class,PremisProvenanceMetadata.class,PremisRightsMetadata.class);
        marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MetsNamespacePrefixMapper());
    }

    public static MetsFactory getInstance() throws JAXBException {
        if (INSTANCE == null) {
            INSTANCE = new MetsFactory();
        }
        return INSTANCE;
    }

    public void serialize(IntellectualEntity entity, OutputStream out) throws JAXBException {
        final Identifier docId = new UUIDIdentifier();
        final Identifier headerId=new UUIDIdentifier();
        final List<Agent> agents=new ArrayList<Agent>();
        final List<MetsAMDSec> amdSecs=new ArrayList<MetsAMDSec>();
        final List<MetsFileGrp> fileGroups=new ArrayList<MetsFileGrp>();
        final List<MetsDiv> divisions=new ArrayList<MetsDiv>();
        
        DCMetadata dc=(DCMetadata) entity.getDescriptive();
        agents.addAll(dc.getConstributors());
        agents.addAll(dc.getCreator());
        for (Representation rep:entity.getRepresentations()){
                
            amdSecs.add(new MetsAMDSec(new UUIDIdentifier().getValue(), rep.getTechnical(),rep.getProvenance(),rep.getSource(),rep.getRights()));
            if (rep.getProvenance() instanceof PremisProvenanceMetadata){
                for (Event e : ((PremisProvenanceMetadata)rep.getProvenance()).getEvents()){
                    for (Agent a : e.getLinkingAgents()){
                        agents.add(a);
                    }
                }
            }
            final List<MetsFile> files=new ArrayList<MetsFile>();
            final List<MetsFilePtr> pointers=new ArrayList<MetsFilePtr>();
            for (File f:rep.getFiles()){
                List<MetsFileLocation> locations=new ArrayList<MetsFileLocation>();
                for (URI uri:f.getUris()){
                    MetsFileLocation loc=new MetsFileLocation.Builder(new UUIDIdentifier().getValue())
                    .href(uri)
                    .build();
                    locations.add(loc);
                }
                MetsFile file=new MetsFile.Builder(new UUIDIdentifier().getValue())
                    .fileLocations(locations)
                    .build();
                files.add(file);
                
                MetsFilePtr p=new MetsFilePtr.Builder()
                    .fileId(file.getId())
                    .id(new UUIDIdentifier().getValue())
                    .build();
                pointers.add(p);
            }
            MetsDiv div=new MetsDiv.Builder()
                .filePointers(pointers)
                .type("section")
                .build();
            MetsFileGrp group=new MetsFileGrp.Builder(new UUIDIdentifier().getValue())
                .files(files)
                .build();
            fileGroups.add(group);
            divisions.add(div);
        }

        MetsHeader.Builder hdrBuilder=new MetsHeader.Builder(headerId.getValue())
            .createdDate(new Date())
            .agents(agents);
        List<MetsAlternativeIdentifer> alternativeIdentifiers=new ArrayList<MetsAlternativeIdentifer>();
        for (Identifier i:entity.getAlternativeIdentifiers()){
            alternativeIdentifiers.add(new MetsAlternativeIdentifer(i.getType(), i.getValue()));
        }
        hdrBuilder.alternativeIdentifiers(alternativeIdentifiers);
        
        MetsStructMap structMap=new MetsStructMap.Builder()
            .divisions(divisions)
            .id(new UUIDIdentifier().getValue())
            .build();
        
        MetsDocument doc = new MetsDocument.Builder()
                .id(docId.getValue())
                .label(dc.getTitle().get(0))
                .objId(entity.getIdentifier().getValue())
                .profile(SCAPE_PROFILE)
                .dmdSec(createMetsDMDSec(entity.getDescriptive()))
                .amdSecs(amdSecs)
                .fileSecs(Arrays.asList(new MetsFileSec(new UUIDIdentifier().getValue(),fileGroups)))
                .structMaps(Arrays.asList(structMap))
                .headers(Arrays.asList(hdrBuilder.build()))
                .build();
        marshaller.marshal(doc, out);
    }

    private MetsDMDSec createMetsDMDSec(DescriptiveMetadata metadata) {
        String dmdId=new UUIDIdentifier().getValue();
        String admId=new UUIDIdentifier().getValue();
        DCMetadata dc=(DCMetadata) metadata;
        Date created=dc.getDate().get(0);
        return new MetsDMDSec.Builder(dmdId)
            .admId(admId)
            .created(created)
            .metadata(metadata)
            .build();
    }
}
