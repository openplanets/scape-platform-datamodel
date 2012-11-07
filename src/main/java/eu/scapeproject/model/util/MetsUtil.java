package eu.scapeproject.model.util;

import java.util.ArrayList;
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
import eu.scapeproject.model.BitStream.Type;
import eu.scapeproject.model.File;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.ProvenanceMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;

public abstract class MetsUtil {

	private static void addBitstreams(File f, MetsFile.Builder metsFile, Map<Object, MetsAMDSec> amdSecs) {
		if (f.getBitStreams() == null) {
			return;
		}
		for (BitStream bs : f.getBitStreams()) {
			String admId = "BS-" + UUID.randomUUID();
			MetsAMDSec.Builder adm = new MetsAMDSec.Builder()
					.id(admId);
			amdSecs.put(bs, adm.build());
			// add a MetsStream object to the MetsFile
			MetsStream stream = new MetsStream.Builder()
					.amdMdId(admId)
					.id(bs.getIdentifier().getValue())
					.type(bs.getType().name())
					.build();
			metsFile.addStream(stream);
		}
	}

	private static void addFileGroups(Representation r, Map<Object, MetsAMDSec> amdSecs, List<MetsFileGrp> fileGroups) {
		MetsFileGrp.Builder group = new MetsFileGrp.Builder(new Identifier("GRP-" + UUID.randomUUID().toString()).getValue())
				.admId(amdSecs.get(r).getId());
		for (File f : r.getFiles()) {
			String admId = "FILE-" + UUID.randomUUID();
			MetsAMDSec.Builder adm = new MetsAMDSec.Builder()
					.id(admId);
			if (f.getTechnical() != null) {
				MetsMDWrap wrap = createMetsWrapper(f.getTechnical());
				MetsTechMD metsTech = new MetsTechMD.Builder()
						.id("TECH-" + UUID.randomUUID())
						.metadataWrapper(wrap)
						.build();
				adm.technicalMetadata(metsTech);
			}

			amdSecs.put(f, adm.build());
			MetsFile.Builder metsFile = new MetsFile.Builder(f.getIdentifier().getValue());
			MetsFileLocation loc = new MetsFileLocation.Builder(new Identifier("FLOC-" + UUID.randomUUID().toString()).getValue())
					.href(f.getUri())
					.locType("URL")
					.build();
			metsFile.addFileLocation(loc)
					.admId(admId);
			addBitstreams(f, metsFile, amdSecs);
			group.addFile(metsFile.build());
		}
		fileGroups.add(group.build());
	}

	private static void addRepresentations(IntellectualEntity entity, MetsDiv.Builder entityDiv, Map<Object, MetsAMDSec> amdSecs,
			List<MetsFileGrp> fileGroups) {
		if (entity.getRepresentations() != null) {
			for (Representation r : entity.getRepresentations()) {
				MetsAMDSec.Builder amdBuilder = new MetsAMDSec.Builder();
				amdBuilder.provenanceMetadata(getProvenance(r))
						.rightsMetadata(getRights(r))
						.sourceMetadata(getSource(r))
						.technicalMetadata(getTechnical(r))
						.id(r.getIdentifier().getValue());
				amdSecs.put(r, amdBuilder.build());
				addFileGroups(r, amdSecs, fileGroups);
				addSubDivs(r, entityDiv, amdSecs);
			}
		}
	}

	private static void addSubDivs(Representation r, MetsDiv.Builder entityDiv, Map<Object, MetsAMDSec> amdSecs) {
		MetsDiv.Builder repDiv = new MetsDiv.Builder()
				.label(r.getTitle())
				.type("Representation")
				.id(new Identifier("DIV-" + UUID.randomUUID().toString()).getValue())
				.admId(amdSecs.get(r).getId());
		for (File f : r.getFiles()) {
			repDiv.addFilePointer(new MetsFilePtr.Builder().fileId(amdSecs.get(f).getId()).build());
		}
		entityDiv.addSubDiv(repDiv.build());
	}

	public static MetsDMDSec convertDCMetadata(DCMetadata dc) {

		final Date created = dc.getDate().get(0);

		return new MetsDMDSec.Builder(dc.getId())
				.created(created)
				.metadataWrapper(createMetsWrapper(dc))
				.build();
	}

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
		List<MetsFileGrp> fileGroups = new ArrayList<MetsFileGrp>();
		List<MetsStructMap> structMaps = new ArrayList<MetsStructMap>();

		// take care! since order is important here, this sucks but is due to
		// METS format, since somehow Structmap has to be linked to AmdSecs
		MetsDiv.Builder entityDiv = new MetsDiv.Builder()
				.type("Intellectual entity");
		addRepresentations(entity, entityDiv, amdSecs, fileGroups);
		structMaps.add(new MetsStructMap.Builder().addDivision(entityDiv.build()).build());

		// finally build the MetsDocument
		docBuilder.dmdSec(dmdSec)
				.id(new Identifier("DMD-" + UUID.randomUUID().toString()).getValue())
				.addHeader(getMetsHeader(entity))
				.amdSecs(new ArrayList<MetsAMDSec>(amdSecs.values()))
				.fileSec(new MetsFileSec("FILE-" + UUID.randomUUID(), fileGroups))
				.structMaps(structMaps)
				.label(((DCMetadata) entity.getDescriptive()).getTitle().get(0))
				.objId(entity.getIdentifier() == null ? null : entity.getIdentifier().getValue());
		return docBuilder.build();
	}

	public static MetsFile convertFile(File file) {
		return new MetsFile.Builder(file.getIdentifier().getValue())
				.addFileLocation(new MetsFileLocation.Builder(file.getIdentifier().getValue()).href(file.getUri()).build())
				.build();
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

	public static MetsAMDSec getAdmSec(String amdId, List<MetsAMDSec> amdSecs) {
		if (amdSecs == null) {
			return null;
		}
		for (MetsAMDSec amd : amdSecs) {
			if (amd.getId().equals(amdId)) {
				return amd;
			}
		}
		return null;
	}

	public static List<MetsAgent> getAgentList(DCMetadata dc) {
		List<MetsAgent> agents = new ArrayList<MetsAgent>();
		if (dc.getConstributors() != null) {
			for (final Agent contributor : dc.getConstributors()) {
				final MetsAgent agent = new MetsAgent.Builder()
						.id(new Identifier("AGENT-" + UUID.randomUUID().toString()).getValue())
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
						.id(new Identifier("AGENT-" + UUID.randomUUID().toString()).getValue())
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

	public static List<Identifier> getAlternativeIdentifiers(List<MetsHeader> headers) {
		if (headers == null) {
			return null;
		}
		List<Identifier> altIds = new ArrayList<Identifier>();
		for (MetsHeader hdr : headers) {
			if (hdr.getAlternativeIdentifiers() != null) {
				for (MetsAlternativeIdentifer metsAltId : hdr.getAlternativeIdentifiers()) {
					altIds.add(new Identifier(metsAltId.getType(), metsAltId.getValue()));
				}
			}
		}
		if (altIds.size() == 0) {
			return null;
		}
		return altIds;
	}

	public static List<MetsAMDSec> getAMDSecs(List<Representation> representations, Map<Representation, String> idMap) {
		if (representations == null) {
			return null;
		}
		List<MetsAMDSec> amdSecs = new ArrayList<MetsAMDSec>();
		for (Representation r : representations) {
			Identifier id = new Identifier("REP-" + UUID.randomUUID().toString());
			idMap.put(r, id.getValue());
		}
		return amdSecs;
	}

	public static DescriptiveMetadata getDescriptiveMetadadata(MetsDMDSec dmdSec) {
		DCMetadata.Builder dc = new DCMetadata.Builder((DCMetadata) dmdSec.getMetadataWrapper().getXmlData().getData());
		dc.identifier = new Identifier(dmdSec.getId());
		return dc.build();
	}

	public static MetsDiv getDiv(String type, String id) {
		return new MetsDiv.Builder()
				.id(new Identifier("DIV-" + UUID.randomUUID().toString()).getValue())
				.type(type)
				.admId(id)
				.build();
	}

	public static List<File> getFiles(List<MetsFilePtr> pointers, MetsDocument doc) {
		if (pointers == null) {
			return null;
		}

		List<File> files = new ArrayList<File>();
		for (MetsFilePtr ptr : pointers) {
			files.add(getMetsFile(ptr.getFileId(), doc));
		}
		return files;
	}

	public static File getMetsFile(String fileId, MetsDocument doc) {
		for (MetsFileGrp grp : doc.getFileSec().getFileGroups()) {
			for (MetsFile metsFile : grp.getFiles()) {
				if (metsFile.getId().equals(fileId)) {
					File.Builder f = new File.Builder()
							.identifier(new Identifier(metsFile.getId()))
							.uri(metsFile.getFileLocations().get(0).getHref());
					for (MetsAMDSec amd : doc.getAmdSecs()) {
						if (amd.getId().equals(metsFile.getAdmId())) {
							if (amd.getTechnicalMetadata() != null) {
								f.technical((TechnicalMetadata) amd.getTechnicalMetadata().getMetadataWrapper().getXmlData().getData());
							}
						}
					}
					if (metsFile.getStreams() != null) {
						f.bitStreams(getBitStreams(metsFile.getStreams(), doc));
					}
					return f.build();
				}
			}
		}
		return null;
	}

	private static List<BitStream> getBitStreams(List<MetsStream> streams, MetsDocument doc) {
		List<BitStream> bitstreams = new ArrayList<BitStream>();
		for (MetsStream st : streams) {
			BitStream.Builder bs = new BitStream.Builder();
			for (MetsAMDSec amd : doc.getAmdSecs()) {
				if (amd.getId().equals(st.getId())) {
					if (amd.getTechnicalMetadata() != null) {
						bs.technical((TechnicalMetadata) amd.getTechnicalMetadata().getMetadataWrapper().getXmlData().getData());
					}
				}
			}
			bs.identifier(new Identifier(st.getId()))
					.type(Type.valueOf(st.getType()));
			bitstreams.add(bs.build());
		}
		if (bitstreams.size() == 0) {
			return null;
		}
		return bitstreams;
	}

	public static MetsHeader getMetsHeader(IntellectualEntity entity) {
		MetsHeader.Builder hdrBuilder = new MetsHeader.Builder(new Identifier("HDR-" + UUID.randomUUID().toString()).getValue())
				.agents(getAgentList((DCMetadata) entity.getDescriptive()))
				.alternativeIdentifiers(getAlternativeIdentifiers(entity));
		if (entity.getLifecycleState() != null) {
			hdrBuilder.recordStatus(entity.getLifecycleState().getState().name());
		}
		return hdrBuilder.build();
	}

	public static MetsDigiProvMD getProvenance(Representation r) {
		return new MetsDigiProvMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getProvenance()))
				.id("DP-" + UUID.randomUUID())
				.build();
	}

	private static ProvenanceMetadata getProvenance(String admId, MetsDocument doc) {
		MetsAMDSec amd = getAdmSec(admId, doc.getAmdSecs());
		return (ProvenanceMetadata) amd.getProvenanceMetadata().getMetadataWrapper().getXmlData().getData();
	}

	public static List<Representation> getRepresentations(MetsDiv div, MetsDocument doc) {
		List<Representation> reps = new ArrayList<Representation>();
		if (div.getType().equals("Representation")) {
			Representation.Builder repBuilder = new Representation.Builder()
					.identifier(new Identifier(div.getAdmId()))
					.files(getFiles(div.getFilePointers(), doc))
					.title(div.getLabel())
					.provenance(getProvenance(div.getAdmId(), doc))
					.technical(getTechnical(div.getAdmId(), doc))
					.rights(getRights(div.getAdmId(), doc))
					.source(getSource(div.getAdmId(), doc));
			reps.add(repBuilder.build());
		}
		if (div.getSubDivs() != null) {
			for (MetsDiv subDiv : div.getSubDivs()) {
				reps.addAll(getRepresentations(subDiv, doc));
			}
		}
		return reps;
	}

	public static List<Representation> getRepresentations(MetsDocument doc) {
		List<Representation> reps = new ArrayList<Representation>();
		for (MetsStructMap structMap : doc.getStructMaps()) {
			for (MetsDiv div : structMap.getDivisions()) {
				if (div.getType().equals("Intellectual entity")) {
					reps.addAll(getRepresentations(div, doc));
				}
			}
		}
		if (reps.size() == 0) {
			return null;
		}
		return reps;
	}

	public static MetsRightsMD getRights(Representation r) {
		return new MetsRightsMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getRights()))
				.id("RIGHTS-" + UUID.randomUUID())
				.build();
	}

	private static RightsMetadata getRights(String admId, MetsDocument doc) {
		MetsAMDSec amd = getAdmSec(admId, doc.getAmdSecs());
		return (RightsMetadata) amd.getRightsMetadata().getMetadataWrapper().getXmlData().getData();
	}

	public static MetsSourceMD getSource(Representation r) {
		return new MetsSourceMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getSource()))
				.id("SOURCE-" + UUID.randomUUID())
				.build();
	}

	private static DescriptiveMetadata getSource(String admId, MetsDocument doc) {
		MetsAMDSec amd = getAdmSec(admId, doc.getAmdSecs());
		return (DescriptiveMetadata) amd.getSourceMetadata().getMetadataWrapper().getXmlData().getData();
	}

	public static MetsTechMD getTechnical(Representation r) {
		return new MetsTechMD.Builder()
				.metadataWrapper(createMetsWrapper(r.getTechnical()))
				.id("TECH-" + UUID.randomUUID())
				.build();
	}

	private static TechnicalMetadata getTechnical(String admId, MetsDocument doc) {
		MetsAMDSec amd = getAdmSec(admId, doc.getAmdSecs());
		return (TechnicalMetadata) amd.getTechnicalMetadata().getMetadataWrapper().getXmlData().getData();
	}
}
