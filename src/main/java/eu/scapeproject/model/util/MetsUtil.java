package eu.scapeproject.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import eu.scapeproject.dto.mets.MetsMetadata;
import eu.scapeproject.dto.mets.MetsRightsMD;
import eu.scapeproject.dto.mets.MetsSourceMD;
import eu.scapeproject.dto.mets.MetsStream;
import eu.scapeproject.dto.mets.MetsStructMap;
import eu.scapeproject.dto.mets.MetsTechMD;
import eu.scapeproject.dto.mets.MetsXMLData;
import eu.scapeproject.model.Agent;
import eu.scapeproject.model.BitStream;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

public abstract class MetsUtil {

	/**
	 * Convert an {@link IntellectualEntity} to a {@link MetsDocument}
	 * 
	 * @param entity
	 *            the {@link IntellectualEntity} to be converted
	 * @return a {@link MetsDocument}
	 */
	public static MetsDocument convertEntity(IntellectualEntity entity) {
		DCMetadata dc = (DCMetadata) entity.getDescriptive();
		MetsDMDSec dmdSec = convertDCMetadata(dc);
		Map<Object, MetsAMDSec> amdSecs = new HashMap<Object, MetsAMDSec>();
		MetsDocument.Builder docBuilder = new MetsDocument.Builder();
		// add representations, files and bitstreams to the MetsAmdSec
		List<MetsFileSec> fileSecs = new ArrayList<MetsFileSec>();
		List<MetsStructMap> structMaps = new ArrayList<MetsStructMap>();
		// take care! since order is important here, this sucks but is due to
		// METS format, since somehow Structmap has to be linked to AmdSecs
		MetsDiv.Builder entityDiv = new MetsDiv.Builder()
			.type("Intellectual entity");
		addRepresentations(entity, entityDiv, amdSecs, fileSecs);
		structMaps.add(new MetsStructMap.Builder().addDivision(entityDiv.build()).build());

		docBuilder.dmdSec(dmdSec)
				.id(new Identifier(UUID.randomUUID().toString()).getValue())
				.addHeader(getMetsHeader(entity))
				.amdSecs(new ArrayList<MetsAMDSec>(amdSecs.values()))
				.fileSecs(fileSecs)
				.structMaps(structMaps)
				.label(((DCMetadata) entity.getDescriptive()).getTitle().get(0))
				.objId(entity.getIdentifier().getValue());
		return docBuilder.build();
	}

	private static void addRepresentations(IntellectualEntity entity, MetsDiv.Builder entityDiv, Map<Object, MetsAMDSec> amdSecs,
			List<MetsFileSec> fileSecs) {
	    if (entity.getRepresentations() != null){
    		for (Representation r : entity.getRepresentations()) {
    			MetsAMDSec.Builder amdBuilder = new MetsAMDSec.Builder();
    			amdBuilder.provenanceMetadata(getProvenance(r))
    					.rightsMetadata(getRights(r))
    					.sourceMetadata(getSource(r))
    					.technicalMetadata(getTechnical(r))
    					.id(r.getIdentifier().getValue());
    			amdSecs.put(r, amdBuilder.build());
    			addFileSecs(r, amdSecs, fileSecs);
    			addSubDivs(r, entityDiv, amdSecs);
    		}
	    }
	}

	private static void addSubDivs(Representation r, MetsDiv.Builder entityDiv, Map<Object, MetsAMDSec> amdSecs) {
		MetsDiv.Builder repDiv = new MetsDiv.Builder()
				.label(r.getTitle())
				.type("Representation")
				.id(new Identifier(UUID.randomUUID().toString()).getValue())
				.admId(amdSecs.get(r).getId());
		for (File f:r.getFiles()){
			repDiv.addFilePointer(new MetsFilePtr.Builder().fileId(amdSecs.get(f).getId()).build());
		}
		entityDiv.addSubDiv(repDiv.build());
	}

	private static void addFileSecs(Representation r, Map<Object, MetsAMDSec> amdSecs, List<MetsFileSec> fileSecs) {
		MetsFileGrp.Builder group = new MetsFileGrp.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
				.admId(amdSecs.get(r).getId());
		for (File f : r.getFiles()) {
			MetsAMDSec.Builder adm = new MetsAMDSec.Builder()
					.id(f.getIdentifier().getValue());
			amdSecs.put(f, adm.build());
			MetsFile.Builder metsFile = new MetsFile.Builder(f.getIdentifier().getValue());
			MetsFileLocation loc = new MetsFileLocation.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
					.href(f.getUri())
					.build();
			metsFile.addFileLocation(loc);
			addBitstreams(f, metsFile, amdSecs);
			group.addFile(metsFile.build());
		}
		fileSecs.add(new MetsFileSec(new Identifier(UUID.randomUUID().toString()).getValue(), Arrays.asList(group.build())));
	}

	private static void addBitstreams(File f, MetsFile.Builder metsFile, Map<Object, MetsAMDSec> amdSecs) {
		if (f.getBitStreams() == null) {
			return;
		}
		for (BitStream bs : f.getBitStreams()) {
			MetsAMDSec.Builder adm = new MetsAMDSec.Builder()
					.id(bs.getIdentifier().getValue());
			amdSecs.put(bs, adm.build());
			// add a MetsStream object to the MetsFile
			MetsStream stream = new MetsStream.Builder()
					.amdMdId(bs.getIdentifier().getValue())
					.id(new Identifier(UUID.randomUUID().toString()).getValue())
					.type(bs.getType().name())
					.build();
			metsFile.addStream(stream);
		}
	}

	public static MetsDiv getDiv(String type, String id) {
		return new MetsDiv.Builder()
				.id(new Identifier(UUID.randomUUID().toString()).getValue())
				.type(type)
				.admId(id)
				.build();
	}

	public static List<MetsAMDSec> getAMDSecs(List<Representation> representations, Map<Representation, String> idMap) {
		if (representations == null) {
			return null;
		}
		List<MetsAMDSec> amdSecs = new ArrayList<MetsAMDSec>();
		for (Representation r : representations) {
			Identifier id = new Identifier(UUID.randomUUID().toString());
			idMap.put(r, id.getValue());
		}
		return amdSecs;
	}

	public static MetsTechMD getTechnical(Representation r) {
		return new MetsTechMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getTechnical()))
				.build();
	}

	public static MetsSourceMD getSource(Representation r) {
		return new MetsSourceMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getSource()))
				.build();
	}

	public static MetsRightsMD getRights(Representation r) {
		return new MetsRightsMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getRights()))
				.build();
	}

	public static MetsDigiProvMD getProvenance(Representation r) {
		return new MetsDigiProvMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getProvenance()))
				.build();
	}

	public static MetsHeader getMetsHeader(IntellectualEntity entity) {
		MetsHeader.Builder hdrBuilder = new MetsHeader.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
				.agents(getAgentList((DCMetadata) entity.getDescriptive()))
				.alternativeIdentifiers(getAlternativeIdentifiers(entity));
		if (entity.getLifecycleState() != null){
		    hdrBuilder.recordStatus(entity.getLifecycleState().getState().name());
		}
		return hdrBuilder.build();
	}

	public static List<Identifier> getAlternativeIdentifiers(List<MetsHeader> headers) {
		if (headers == null) {
			return null;
		}
		List<Identifier> altIds = new ArrayList<Identifier>();
		for (MetsHeader hdr : headers) {
			if (hdr.getAlternativeIdentifiers() != null){
				for (MetsAlternativeIdentifer metsAltId : hdr.getAlternativeIdentifiers()) {
					altIds.add(new Identifier(metsAltId.getType(), metsAltId.getValue()));
				}
			}
		}
		if (altIds.size() == 0){
			return null;
		}
		return altIds;
	}

	public static List<MetsAlternativeIdentifer> getAlternativeIdentifiers(IntellectualEntity entity) {
		if (entity.getAlternativeIdentifiers() == null) {
			return null;
		}
		List<MetsAlternativeIdentifer> altIds = new ArrayList<MetsAlternativeIdentifer>();
		for (Identifier i : entity.getAlternativeIdentifiers()) {
			altIds.add(new MetsAlternativeIdentifer(i.getType(), i.getValue()));
		}
		return altIds;
	}

	public static MetsMDWrap createMetsWrapper(MetsMetadata data) {
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

		final String dmdId = "dmd-" + new Identifier(UUID.randomUUID().toString()).getValue();
		final String admId = "adm-" + new Identifier(UUID.randomUUID().toString()).getValue();
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
						.id(new Identifier(UUID.randomUUID().toString()).getValue())
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
						.id(new Identifier(UUID.randomUUID().toString()).getValue())
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

	public static List<Representation> getRepresentations(MetsDocument doc) {
		List<Representation> reps = new ArrayList<Representation>();
		for (MetsStructMap structMap : doc.getStructMaps()) {
			for (MetsDiv div : structMap.getDivisions()) {
				if (div.getType().equals("Intellectual entity")) {
					reps.addAll(getRepresentations(div,doc));
				}
			}
		}
		return reps;
	}
	
	public static List<File> getFiles(List<MetsFilePtr> pointers,MetsDocument doc){
		if (pointers == null) {
			return null;
		}
		List<File> files=new ArrayList<File>();
		for (MetsFilePtr ptr:pointers){
		    files.add(getMetsFile(ptr.getFileId(),doc));
		}
		return files;
	}
	
	private static File getMetsFile(String fileId, MetsDocument doc) {
        for (MetsFileSec fileSec:doc.getFileSecs()){
            for (MetsFileGrp grp:fileSec.getFileGroups()){
                for (MetsFile metsFile:grp.getFiles()){
                    if (metsFile.getId().equals(fileId)){
                        return new File.Builder()
                            .identifier(new Identifier(fileId))
                            .uri(metsFile.getFileLocations().get(0).getHref())
                            .build();
                    }
                }
            }
        }
        return null;
    }

    public static List<Representation> getRepresentations(MetsDiv div,MetsDocument doc){
		List<Representation> reps=new ArrayList<Representation>();
		if (div.getType().equals("Representation")){
			Representation.Builder repBuilder = new Representation.Builder()
			    .identifier(new Identifier(div.getAdmId()))
			    .files(getFiles(div.getFilePointers(), doc))
			    .title(div.getLabel());
			reps.add(repBuilder.build());
		}
		if (div.getSubDivs() != null){
			for (MetsDiv subDiv:div.getSubDivs()){
				reps.addAll(getRepresentations(subDiv,doc));
			}
		}
		return reps;
	}
}
