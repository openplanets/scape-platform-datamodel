package eu.scapeproject.model.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

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
import eu.scapeproject.model.metadata.TechnicalMetadata.MetadataType;
import eu.scapeproject.model.metadata.audiomd.Audio;
import eu.scapeproject.model.metadata.audiomd.Audio.AnalogDigitalFlag;
import eu.scapeproject.model.metadata.audiomd.AudioInfo;
import eu.scapeproject.model.metadata.audiomd.AudioMDMetadata;
import eu.scapeproject.model.metadata.audiomd.CalibrationInfo;
import eu.scapeproject.model.metadata.audiomd.ChannelAssignment;
import eu.scapeproject.model.metadata.audiomd.Compression;
import eu.scapeproject.model.metadata.audiomd.Compression.CodecQuality;
import eu.scapeproject.model.metadata.audiomd.Dimension;
import eu.scapeproject.model.metadata.audiomd.FileData;
import eu.scapeproject.model.metadata.audiomd.FileData.DataRateMode;
import eu.scapeproject.model.metadata.audiomd.Material;
import eu.scapeproject.model.metadata.audiomd.MessageDigest;
import eu.scapeproject.model.metadata.audiomd.PhysicalData;
import eu.scapeproject.model.metadata.audiomd.SoundChannelMap;
import eu.scapeproject.model.metadata.audiomd.TrackingInfo;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.fits.FitsFileInfo;
import eu.scapeproject.model.metadata.fits.FitsFileInfo.FileInfoElement;
import eu.scapeproject.model.metadata.fits.FitsFileStatus;
import eu.scapeproject.model.metadata.fits.FitsGeneratedMetadata;
import eu.scapeproject.model.metadata.fits.FitsIdentification;
import eu.scapeproject.model.metadata.fits.FitsIdentity;
import eu.scapeproject.model.metadata.fits.FitsMetadata;
import eu.scapeproject.model.metadata.fits.FitsStatus;
import eu.scapeproject.model.metadata.fits.FitsTool;
import eu.scapeproject.model.metadata.fits.ToolOutput;
import eu.scapeproject.model.metadata.fits.Version;
import eu.scapeproject.model.metadata.mix.ColorProfile;
import eu.scapeproject.model.metadata.mix.DigitalCameraCapture;
import eu.scapeproject.model.metadata.mix.GPSData;
import eu.scapeproject.model.metadata.mix.GeneralCaptureInformation;
import eu.scapeproject.model.metadata.mix.GeneralCaptureInformation.CaptureDevice;
import eu.scapeproject.model.metadata.mix.ImageColorEncoding;
import eu.scapeproject.model.metadata.mix.ImageColorEncoding.BitsPerSampleUnit;
import eu.scapeproject.model.metadata.mix.ImageColorEncoding.ExtraSamples;
import eu.scapeproject.model.metadata.mix.ImageColorEncoding.GrayResponseUnit;
import eu.scapeproject.model.metadata.mix.ImageData;
import eu.scapeproject.model.metadata.mix.ImageData.ExposureProgram;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata.Orientation;
import eu.scapeproject.model.metadata.mix.ReferenceBlackWhite;
import eu.scapeproject.model.metadata.mix.ScannerCapture;
import eu.scapeproject.model.metadata.mix.ScannerCapture.ScannerSensor;
import eu.scapeproject.model.metadata.mix.SourceInformation;
import eu.scapeproject.model.metadata.mix.SourceInformation.SourceDimension;
import eu.scapeproject.model.metadata.mix.SpacialMetrics;
import eu.scapeproject.model.metadata.mix.SpacialMetrics.SamplingFrequencyPane;
import eu.scapeproject.model.metadata.mix.SpacialMetrics.SamplingFrequencyUnit;
import eu.scapeproject.model.metadata.mix.SpecialFormatCharacteristics;
import eu.scapeproject.model.metadata.mix.SpecialFormatCharacteristics.Format;
import eu.scapeproject.model.metadata.mix.TargetData;
import eu.scapeproject.model.metadata.mix.TargetData.TargetType;
import eu.scapeproject.model.metadata.mix.YCbCr;
import eu.scapeproject.model.metadata.mix.YCbCr.YCbCrSubSampling.SubSampling;
import eu.scapeproject.model.metadata.premis.CopyRightInformation;
import eu.scapeproject.model.metadata.premis.Event;
import eu.scapeproject.model.metadata.premis.GrantedRights;
import eu.scapeproject.model.metadata.premis.LicenseInformation;
import eu.scapeproject.model.metadata.premis.LinkingAgent;
import eu.scapeproject.model.metadata.premis.LinkingObject;
import eu.scapeproject.model.metadata.premis.PremisProvenanceMetadata;
import eu.scapeproject.model.metadata.premis.PremisRightsMetadata;
import eu.scapeproject.model.metadata.premis.RightsStatement;
import eu.scapeproject.model.metadata.premis.StatuteInformation;
import eu.scapeproject.model.metadata.premis.TermOfGrant;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.CharacterInfo;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.CharacterInfo.ByteOrder;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.CharacterInfo.Charset;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingAgent;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingAgent.Role;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingPlatform;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.LineBreak;
import eu.scapeproject.model.metadata.videomd.Video;
import eu.scapeproject.model.metadata.videomd.VideoCodec;
import eu.scapeproject.model.metadata.videomd.VideoCompression;
import eu.scapeproject.model.metadata.videomd.VideoFileData;
import eu.scapeproject.model.metadata.videomd.VideoFormat;
import eu.scapeproject.model.metadata.videomd.VideoFrame;
import eu.scapeproject.model.metadata.videomd.VideoLanguage;
import eu.scapeproject.model.metadata.videomd.VideoMDMetadata;
import eu.scapeproject.model.metadata.videomd.VideoMessageDigest;
import eu.scapeproject.model.metadata.videomd.VideoTimeCode;
import eu.scapeproject.model.metadata.videomd.VideoTrack;
import eu.scapeproject.model.metadata.videomd.VideoTrackingInfo;
import eu.scapeproject.model.metadata.videomd.VideoVariableRate;

public abstract class TestUtil {

    public static final Random rand = new Random();
    public static final DateFormat dateFormatter = new SimpleDateFormat("d-M-y hh:mm:ss");

    public static GeneralCaptureInformation createGeneralCaptureInformation() {
        return new GeneralCaptureInformation(new Date(Math.abs(rand.nextLong())), CaptureDevice.DIGITAL_STILL_CAMERA, Arrays.asList("Digital Camera"));
    }


    
    public static IntellectualEntity createMinimalEntity(){
    	return new IntellectualEntity.Builder()
    		.identifier(new Identifier("minimal-1"))
    		.descriptive(createMinimalDC())
    		.representations(Arrays.asList(createMinimalRepresentation()))
    		.build();
    }
    
    public static Representation createMinimalRepresentation() {
    	return new Representation.Builder()
    		.identifier(new Identifier("minimal-representation-1"))
    		.file(createMinimalFile())
    		.build();
    }



	public static File createMinimalFile() {
		return new File.Builder()
			.identifier(new Identifier("minimal-file-1"))
			.uri(URI.create("http://example.com/minimal"))
			.build();
	}



	public static DCMetadata createMinimalDC() {
    	return new DCMetadata.Builder()
    		.title("minimal-entity")
    		.date(new Date())
    		.build();
    }


	public static Agent createRandomAgent() {
        return new Agent.Builder()
                .name("Agent-" + randomAlphabetic(16))
                .note("no notes")
                .role("OTHER")
                .type("INDIVIDUAL")
                .build();
    }

    public static AudioInfo createRandomAudioInfo() {
        return new AudioInfo.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .durations(createRandomTimeStamps())
                .notes(createRandomStrings())
                .numChannnels(createRandomNumerics())
                .soundChannelMaps(createSoundChannelMaps())
                .soundFields(createRandomStrings())
                .build();
    }

    public static List<AudioInfo> createRandomAudioInfos() {
        List<AudioInfo> audioInfos = new ArrayList<AudioInfo>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            audioInfos.add(createRandomAudioInfo());
        }
        return audioInfos;
    }

    public static AudioMDMetadata createRandomAudioMetadata() {
        Audio audioMD = new Audio.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .analogDigitalFlag(AnalogDigitalFlag.ANALOG)
                .audioInfos(createRandomAudioInfos())
                .calibrateInfos(createRandomCalibrateInfos())
                .fileData(createRandomFileDatas())
                .physicalData(createRanomdPhysicalDatas())
                .build();
        Audio audioSrc = new Audio.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .analogDigitalFlag(AnalogDigitalFlag.ANALOG)
                .audioInfos(createRandomAudioInfos())
                .calibrateInfos(createRandomCalibrateInfos())
                .fileData(createRandomFileDatas())
                .physicalData(createRanomdPhysicalDatas())
                .build();
        return new AudioMDMetadata.Builder()
        	.audioMd(audioMD)
        	.audioSrc(audioSrc)
        	.build();
    }

    public static BitStream createRandomBitStream() {
        return new BitStream.Builder()
                .identifier(new Identifier(UUID.randomUUID().toString()))
                .title(randomAlphabetic(16))
                .type(Type.STREAM)
                .technical(createRandomTechnicalMetadata())
                .build();
    }

    public static List<BitStream> createRandomBitStreams() {
        List<BitStream> bitStreams = new ArrayList<BitStream>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            bitStreams.add(createRandomBitStream());
        }
        return bitStreams;
    }

    public static CalibrationInfo createRandomCalibrateInfo() {
        return new CalibrationInfo.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .calibrationExInts(createRandomStrings())
                .calibrationLocations(createRandomStrings())
                .calibrationTimeStamps(createRandomTimeStamps())
                .calibrationTrackTypes(createRandomStrings())
                .build();
    }

    public static List<CalibrationInfo> createRandomCalibrateInfos() {
        List<CalibrationInfo> ci = new ArrayList<CalibrationInfo>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            ci.add(createRandomCalibrateInfo());
        }
        return ci;
    }

    public static List<ChannelAssignment> createRandomChannelAssignments() {
        List<ChannelAssignment> ass = new ArrayList<ChannelAssignment>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            ass.add(new ChannelAssignment(rand.nextInt(32), randomAlphabetic(16)));
        }
        return ass;
    }

    public static CharacterInfo createRandomCharacterInfo() {
        return new CharacterInfo.Builder()
                .byteOrder(ByteOrder.BIG_ENDIAN)
                .byteSize(rand.nextInt())
                .characterSize(String.valueOf(rand.nextInt(8)))
                .charset(Charset.UTF_8)
                .lineBreak(LineBreak.CR_LF)
                .build();
    }

    public static List<CharacterInfo> createRandomCharacterInfos() {
        List<CharacterInfo> characterInfos = new ArrayList<CharacterInfo>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            characterInfos.add(createRandomCharacterInfo());
        }
        return characterInfos;
    }

    public static List<CodecQuality> createRandomCodecQualities() {
        List<CodecQuality> qualities = new ArrayList<Compression.CodecQuality>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            qualities.add(CodecQuality.LOSSY);
        }
        return qualities;
    }

    public static ColorProfile createRandomColorProfile() {
        switch (rand.nextInt(2) + 1) {
        case 0:
            return new ColorProfile(new ColorProfile.ICCProfile(randomAlphabetic(16), "version 0.1-TEST", "http://example.com/"
                    + randomAlphabetic(16)));
        case 1:
            return new ColorProfile(new ColorProfile.LocalProfile("version 0.1-TEST", "file://" + randomAlphabetic(16)));
        case 2:
            return new ColorProfile(new ColorProfile.EmbeddedProfile(
                    Base64.encodeBase64String("An embedded Color profile looks different than this string".getBytes())));
        default:
            return null;
        }
    }

    public static Compression createRandomCompression() {
        return new Compression.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .codecCreatorApps(createRandomStrings())
                .codecCreatorAppVersions(createRandomNumerics())
                .codecNames(createRandomStrings())
                .codecQualities(createRandomCodecQualities())
                .build();
    }

    public static List<Compression> createRandomCompressions() {
        List<Compression> compressions = new ArrayList<Compression>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            compressions.add(createRandomCompression());
        }
        return compressions;
    }

    public static CopyRightInformation createRandomCopyrightInformation() {
        return new CopyRightInformation(randomAlphabetic(2), new Date(), Arrays.asList(randomAlphabetic(16)));
    }

    public static List<DataRateMode> createRandomDataRateModes() {
        List<DataRateMode> modes = new ArrayList<FileData.DataRateMode>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            modes.add(DataRateMode.FIXED);
        }
        return modes;
    }

    public static Date createRandomDate() {
        Random rnd = new Random();
        int month = rnd.nextInt(11);
        int year = rnd.nextInt(2012);
        int day = rnd.nextInt(30);
        return new GregorianCalendar(year, month, day).getTime();
    }

    public static DescriptiveMetadata createRandomDescriptive() {
        DCMetadata.Builder builder = new DCMetadata.Builder();
        Random rnd = new Random();
        int max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.contributor(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.coverage(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.creator(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.contributor(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.date(createRandomDate());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.description(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.format(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.language(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.publisher(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.relations(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.rights(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.sources(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.subject(randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.title(randomAlphabetic(16));
        }
        for (int i = 0; i < max; i++) {
            builder.type(randomAlphabetic(16));
        }
        return builder.build();
    }

    public static DigitalCameraCapture createRandomDigitalCameraCapture() {
        return new DigitalCameraCapture.Builder()
                .digitalCameraManufacturer(randomAlphabetic(16))
                .digitalCameraModelName(randomAlphabetic(16))
                .digitalCameraModelNumber(randomNumeric(2))
                .digitalCameraModelSerialNo(randomNumeric(16))
                .digitalCameraSensor(randomAlphabetic(16))
                .imageData(createRandomImageData())
                .gpsData(createRandomGPSData())
                .build();
    }

    public static Dimension createRandomDimension() {
        return new Dimension.Builder()
                .depth(rand.nextFloat())
                .diameter(rand.nextFloat())
                .gauge(randomAlphabetic(16))
                .height(rand.nextFloat())
                .length(randomAlphabetic(16))
                .note(randomAlphabetic(16))
                .thickness(randomAlphabetic(16))
                .units(randomAlphabetic(16))
                .width(rand.nextFloat())
                .build();
    }

    public static List<Dimension> createRandomDimensions() {
        List<Dimension> dims = new ArrayList<Dimension>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            dims.add(createRandomDimension());
        }
        return dims;

    }

    public static Encoding createRandomEncoding() {
        return new Encoding(new EncodingPlatform(LineBreak.CR_LF), createRandomStrings(), new EncodingAgent(Role.EDITOR));
    }

    public static List<Encoding> createRandomEncodings() {
        List<Encoding> encodings = new ArrayList<TextMDMetadata.Encoding>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            encodings.add(createRandomEncoding());
        }
        return encodings;
    }

    public static IntellectualEntity createRandomEntity() {
        return new IntellectualEntity.Builder()
                .identifier(new Identifier(UUID.randomUUID().toString()))
                .alternativeIdentifiers(createRandomIdentifiers())
                .descriptive(createRandomDescriptive())
                .representations(createRandomRepresentations())
                .build();
    }

    public static Event createRandomEvent() {
        return new Event.Builder()
                .identifier(new Identifier(UUID.randomUUID().toString()))
                .linkingAgents(Arrays.asList(createRandomAgent()))
                .build();
    }

    public static List<Event> createRandomEvents() {
        int num = rand.nextInt(4) + 1;
        List<Event> events = new ArrayList<Event>();
        while (num-- > 0) {
            events.add(createRandomEvent());
        }
        return events;
    }

    public static FileData createRandomFileData() {
        return new FileData.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .audiBlockSizes(createRandomIntegers())
                .audioDataEncodings(createRandomStrings())
                .audioDataEncodings(createRandomStrings())
                .bitsPerSamples(createRandomIntegers())
                .byteOrders(createRandomIntegers())
                .compression(createRandomCompressions())
                .dataRateModes(createRandomDataRateModes())
                .dataRates(createRandomIntegers())
                .firstSampleOffsets(createRandomIntegers())
                .firstValidByteBlocks(createRandomIntegers())
                .formatLocations(createRandomStrings())
                .formatNames(createRandomStrings())
                .formatVersions(createRandomNumerics())
                .lastValidByteBlocks(createRandomIntegers())
                .messageDigest(createRandomMessageDigests())
                .numSampleFrames(createRandomIntegers())
                .otherUses(createRandomStrings())
                .samplingFrequencies(createRandomFloats())
                .securities(createRandomStrings())
                .uses(createRandomStrings())
                .wordSizes(createRandomIntegers())
                .build();
    }

    public static List<FileData> createRandomFileDatas() {
        List<FileData> fileData = new ArrayList<FileData>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            fileData.add(createRandomFileData());
        }
        return fileData;
    }

    public static FileInfoElement createRandomFileInfoElement() {
        return new FileInfoElement(randomAlphabetic(16), randomNumeric(2), randomAlphabetic(16));
    }

    public static List<File> createRandomFiles() {
        int num = rand.nextInt(3) + 1;
        List<File> files = new ArrayList<File>(num);
        while (num-- > 0) {
            File f = new File.Builder()
                    .technical(createRandomTechnicalMetadata())
                    .uri(URI.create("http://example.com/" + randomAlphabetic(16)))
                    .bitStreams(createRandomBitStreams())
                    .identifier(new Identifier(UUID.randomUUID().toString()))
                    .build();
            files.add(f);
        }
        return files;
    }

    public static FitsGeneratedMetadata createRandomFitsGeneratedMetadata() {
        return new FitsGeneratedMetadata.Builder()
                .status(FitsStatus.UNKNOWN)
                .toolName(randomAlphabetic(16))
                .toolVersion(randomNumeric(2))
                .build();
    }

    public static List<FitsIdentity> createRandomFitsIdentities() {
        int max = rand.nextInt(3) + 1;
        List<FitsIdentity> identities = new ArrayList<FitsIdentity>();
        while (max-- > 0) {
            identities.add(createRandomFitsIdentity());
        }
        return identities;
    }

    public static FitsIdentity createRandomFitsIdentity() {
        return new FitsIdentity.Builder()
                .format(randomAlphabetic(16))
                .mimeType(randomAlphabetic(16))
                .tool(createRandomFitsTools())
                .toolName(randomAlphabetic(16))
                .toolVersion(randomNumeric(2))
                .versions(createRandomFitsVersions())
                .build();
    }

    public static FitsMetadata createRandomFitsMetadata() {
        FitsFileInfo fileInfo = new FitsFileInfo.Builder()
                .copyRightBasis(createRandomFileInfoElement())
                .copyRightNote(createRandomFileInfoElement())
                .created(createRandomFileInfoElement())
                .creatingApplicationName(createRandomFileInfoElement())
                .creatingApplicationVersion(createRandomFileInfoElement())
                .creatingOs(createRandomFileInfoElement())
                .fileName(createRandomFileInfoElement())
                .filePath(createRandomFileInfoElement())
                .fsLastModified(createRandomFileInfoElement())
                .inhibitorTarget(createRandomFileInfoElement())
                .inhibitorType(createRandomFileInfoElement())
                .lastModified(createRandomFileInfoElement())
                .md5Checksum(createRandomFileInfoElement())
                .rightsBasis(createRandomFileInfoElement())
                .size(createRandomFileInfoElement())
                .build();
        List<FitsIdentity> identities = createRandomFitsIdentities();
        FitsIdentification ident = new FitsIdentification(identities, FitsStatus.UNKNOWN);
        return new FitsMetadata.Builder()
                .fileInfo(fileInfo)
                .fileStatus(new FitsFileStatus(randomAlphabetic(16), randomAlphabetic(16), randomAlphabetic(16)))
                .identification(ident)
                .metadata(createRandomFitsGeneratedMetadata())
                .timeStamp(randomAlphabetic(16))
                .toolOutput(createRandomToolOutput())
                .build();
    }

    public static FitsTool createRandomFitsTool() {
        return new FitsTool(randomAlphabetic(16), randomAlphabetic(16), randomAlphabetic(16));
    }

    public static List<FitsTool> createRandomFitsTools() {
        List<FitsTool> tools = new ArrayList<FitsTool>();
        int max = rand.nextInt(3) + 1;
        while (max-- > 0) {
            tools.add(createRandomFitsTool());
        }
        return tools;
    }

    public static List<Version> createRandomFitsVersions() {
        List<Version> versions = new ArrayList<Version>();
        int max = rand.nextInt(3) + 1;
        while (max-- > 0) {
            versions.add(createrRandomFitsVersion());
        }
        return versions;
    }

    public static List<Float> createRandomFloats() {
        List<Float> floats = new ArrayList<Float>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            floats.add(rand.nextFloat());
        }
        return floats;
    }

    public static SpecialFormatCharacteristics createRandomFormatCharacteristics() {
        switch (rand.nextInt(2) + 1) {
        case 0:
            return new SpecialFormatCharacteristics(Format.JPG_2000);
        case 1:
            return new SpecialFormatCharacteristics(Format.DJVU);
        case 2:
            return new SpecialFormatCharacteristics(Format.MR_SID);
        default:
            return null;
        }
    }

    public static GPSData createRandomGPSData() {
        return new GPSData.Builder()
                .gpsAreaInformation(randomAlphanumeric(16))
                .gpsDateStamp(dateFormatter.format(new Date(Math.abs(rand.nextLong()))))
                .gpsDestBearing(rand.nextDouble() * 360)
                .gpsDestBearingRef(GPSData.GPSDirectionRef.MAGNETIC_DIRECTION)
                .gpsDestDistance(rand.nextDouble() * 1000)
                .gpsDestDistanceRef(GPSData.GPSDistanceUnitRef.KILOMETERS)
                .gpsDestLatitude("dd/1,mm/1,ss/1")
                .gpsDestLatitudeRef(GPSData.GPSLatitudeRef.NORTH)
                .gpsDestLongitude("ddd/1,mm/1,ss/1")
                .gpsDestLongitudeRef(GPSData.GPSLongitudeRef.EAST)
                .gpsDifferential(GPSData.GPSDifferential.DIFFERENTIAL_CORRENTION_OFF)
                .gpsDOP(rand.nextDouble())
                .gpsImageDirection(rand.nextDouble() * 360)
                .gpsImageDirectionRef(GPSData.GPSDirectionRef.MAGNETIC_DIRECTION)
                .gpsLatitude(rand.nextDouble() * 90)
                .gpsLatitudeRef(GPSData.GPSLatitudeRef.NORTH)
                .gpsLongitude(rand.nextDouble() * 90)
                .gpsLongitudeRef(GPSData.GPSLongitudeRef.EAST)
                .gpsMapDatum(dateFormatter.format(new Date(Math.abs(rand.nextLong()))))
                .gpsMeasureMode(GPSData.GPSMeasureMode.DEFAULT)
                .gpsProcessingMethod("DEFAULT")
                .gpsSatellites("NULL")
                .gpsSpeed(rand.nextDouble() * 1000)
                .gpsSpeedRef(GPSData.GPSDistanceUnitRef.KILOMETERS)
                .gpsStatus(GPSData.GPSStatus.MEASUREMENT_IN_PROGRESS)
                .gpsTimeStamp(String.valueOf(Math.abs(rand.nextLong())))
                .gpsTrack(rand.nextDouble() * 360)
                .gpsTrackRef(GPSData.GPSDirectionRef.MAGNETIC_DIRECTION)
                .gpsVersionId(randomNumeric(3))
                .build();
    }

    public static List<Identifier> createRandomIdentifiers() {
        List<Identifier> identifiers = new ArrayList<Identifier>();
        int amount = rand.nextInt(2) + 1;
        for (int i = 0; i < amount; i++) {
            identifiers.add(new Identifier(UUID.randomUUID().toString()));
        }
        return identifiers;
    }

    public static ImageColorEncoding createRandomImageColorEncoding() {
        return new ImageColorEncoding.Builder()
                .bitsPerSampleUnit(BitsPerSampleUnit.INTEGER)
                .bitsPerSampleValue(randomNumeric(2))
                .colorMapReference(URI.create("http://example.com/" + randomAlphabetic(16)))
                .embeddedColorMap(randomAlphabetic(16).getBytes())
                .extraSamples(ExtraSamples.UNSPECIFIED_DATA)
                .grayResponseCurve((short) rand.nextInt())
                .grayResponseUnit(GrayResponseUnit.TENTH_OF_A_UNIT)
                .samplesPerPixel(rand.nextInt(256))
                .whitePoints(Arrays.asList(new ImageColorEncoding.WhitePoint("256", "256")))
                .build();
    }

    public static ImageData createRandomImageData() {
        return new ImageData.Builder()
                .apertureValue(rand.nextDouble() * 10)
                .autoFocus(ImageData.AutoFocus.AF_USED)
                .backLight(ImageData.BackLight.BACK_LIGHT_1)
                .brightnessValue(rand.nextDouble())
                .cfaPattern(rand.nextInt())
                .exifVersion(ImageData.ExifVersion.EXIF_2_1)
                .exposeBiasValue(rand.nextDouble())
                .exposureIndex(rand.nextDouble())
                .exposureProgram(ExposureProgram.MANUAL)
                .exposureTime(rand.nextDouble() * 100)
                .flash(ImageData.Flash.FLASH_NO_FIRE)
                .flashEnergy(0d)
                .fNumber(rand.nextDouble() * 11)
                .focalLength(rand.nextDouble() * 500)
                .isoSpeedRatings(rand.nextInt(4000))
                .lightSource(ImageData.LightSource.DAYLIGHT)
                .maxApertureValue(rand.nextDouble() * 10)
                .meteringMode(ImageData.MeteringMode.SPOT)
                .oECF(rand.nextDouble())
                .sensingMode(ImageData.SensingMode.NOT_DEFINED)
                .shutterSpeedValue(rand.nextDouble() * 1000)
                .spectralSensitivity(Arrays.asList("<spectralSensitivity>0.015</spectralSensitivity>", "<spectralSensitivity>0.114</spectralSensitivity>"))
                .subjectDistance(rand.nextDouble() * 100)
                .xPrintAspectRatio(rand.nextDouble())
                .yPrintAspectRatio(rand.nextDouble())
                .build();
    }

    public static SourceInformation createRandomImageSource() {
        return new SourceInformation.Builder()
                .sourceIdentifiers(Arrays.asList(new Identifier(UUID.randomUUID().toString())))
                .sourceType("photograph")
                .sourceXDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceXDimension(rand.nextDouble() * 1000)
                .sourceYDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceYDimension(rand.nextDouble() * 1000)
                .sourceZDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceZDimension(rand.nextDouble() * 1000)
                .build();

    }

    public static List<Integer> createRandomIntegers() {
        List<Integer> ints = new ArrayList<Integer>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            ints.add(rand.nextInt());
        }
        return ints;
    }

    public static LicenseInformation createRandomLicenseInformation() {
        return new LicenseInformation(new Identifier(UUID.randomUUID().toString()), randomAlphabetic(16), Arrays.asList(randomAlphabetic(16)));
    }

    public static List<LinkingAgent> createRandomLinkingAgents() {
        List<LinkingAgent> agents = new ArrayList<LinkingAgent>();
        int num = rand.nextInt(2) + 1;
        while (num-- > 0) {
            agents.add(new LinkingAgent(new Identifier(UUID.randomUUID().toString()), Arrays.asList("USER")));

        }
        return agents;
    }

    public static List<LinkingObject> createRandomLinkingObjects() {
        List<LinkingObject> objs = new ArrayList<LinkingObject>();
        int num = rand.nextInt(2) + 1;
        while (num-- > 0) {
            objs.add(new LinkingObject(new Identifier(UUID.randomUUID().toString()), Arrays.asList("SOURCE")));

        }
        return objs;
    }

    public static Material createRandomMaterial() {
        return new Material.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .baseMaterials(createRandomStrings())
                .activeLayers(createRandomStrings())
                .baseMaterials(createRandomStrings())
                .binders(createRandomStrings())
                .discSurfaces(createRandomStrings())
                .methods(createRandomStrings())
                .oxides(createRandomStrings())
                .reflectiveLayers(createRandomStrings())
                .stockBrands(createRandomStrings())
                .usedSides(createRandomNumerics())
                .build();
    }

    public static List<Material> createRandomMaterials() {
        List<Material> mats = new ArrayList<Material>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            mats.add(createRandomMaterial());
        }
        return mats;
    }

    public static MessageDigest createRandomMessageDigest() {
        return new MessageDigest.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .messageDigestAlgorithms(createRandomStrings())
                .messageDigestDateTimes(Arrays.asList(createRandomDate()))
                .messageDigests(createRandomStrings())
                .build();
    }

    public static List<MessageDigest> createRandomMessageDigests() {
        List<MessageDigest> digests = new ArrayList<MessageDigest>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            digests.add(createRandomMessageDigest());
        }
        return digests;
    }

    public static TechnicalMetadata createRandomNisoMixMetadata() {
        NisoMixMetadata mix = new NisoMixMetadata.Builder()
                .height(rand.nextInt(2000))
                .width(rand.nextInt(2000))
                .colorProfile(createRandomColorProfile())
                .colorspace("RGB")
                .digitalCameraCapture(createRandomDigitalCameraCapture())
                .generalCaptureInformation(createGeneralCaptureInformation())
                .imageColorEncoding(createRandomImageColorEncoding())
                .methodology(randomAlphabetic(16))
                .orientation(Orientation.NORMAL)
                .referencedBlackWhite(new ReferenceBlackWhite(new double[] { 0d, 0d, 0d }, new double[] { 256d, 256d, 256d }))
                .scannerCapture(createRandomScannerCapture())
                .source(createRandomImageSource())
                .spacialMetrics(new SpacialMetrics(SamplingFrequencyPane.DEVICE_FOCAL_PLANE, SamplingFrequencyUnit.INCH, rand.nextDouble(), rand.nextDouble()))
                .specialFormatCharacteristics(createRandomFormatCharacteristics())
                .targetData(createRandomTargetData())
                .yCrCb(new YCbCr(new YCbCr.YCbCrSubSampling(SubSampling.EQUAL_SIZE, SubSampling.EQUAL_SIZE)))
                .build();
        return mix;
    }

    public static List<String> createRandomNumerics() {
        List<String> numerics = new ArrayList<String>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            numerics.add(randomNumeric(3));
        }
        return numerics;
    }

    public static PhysicalData createRandomPhysicalData() {
        return new PhysicalData.Builder(new Identifier(UUID.randomUUID().toString()).getValue())
                .conditions(createRandomStrings())
                .dimensions(createRandomDimensions())
                .dispositions(createRandomStrings())
                .ebuStorageMediaCodes(createRandomStrings())
                .equalizations(createRandomStrings())
                .generations(createRandomStrings())
                .grooves(createRandomStrings())
                .materials(createRandomMaterials())
                .noiseReductions(createRandomStrings())
                .notes(createRandomStrings())
                .physFormats(createRandomStrings())
                .speedAdjustments(createRandomNumerics())
                .speedNotes(createRandomStrings())
                .speeds(createRandomNumerics())
                .trackFormats(createRandomStrings())
                .trackings(createRandomTrackingInfos())
                .build();
    }

    public static ProvenanceMetadata createRandomProvenance() {
        return new PremisProvenanceMetadata(createRandomEvents());
    }

    public static Representation createRandomRepresentation(TechnicalMetadata.MetadataType type) {
        Representation.Builder b = new Representation.Builder()
        		.identifier(new Identifier(UUID.randomUUID().toString()))
                .provenance(createRandomProvenance())
                .source(createRandomDescriptive())
                .rights(createRandomRights())
                .files(createRandomFiles())
                .provenance(createRandomProvenance());
        switch (type) {
        case NISO_MIX:
            b.technical(createRandomNisoMixMetadata());
            break;
        case FITS:
            b.technical(createRandomFitsMetadata());
            break;
        case AUDIOMD:
            b.technical(createRandomAudioMetadata());
            break;
        case VIDEOMD:
            b.technical(createRandomVideoMetadata());
            break;
        case TEXTMD:
        default:
            b.technical(createRandomTextMDMetadata());
        }
        return b.build();
    }

    public static TechnicalMetadata createRandomVideoMetadata() {
        VideoFileData fileData = new VideoFileData.Builder()
                .bitsPerSample(createRandomIntegers())
                .byteOrder(createRandomIntegers())
                .color(randomAlphabetic(16))
                .comressions(createRandomVideoCompressions())
                .dataRate(createRandomVideoDataRate())
                .dataRateMode(createRandomStrings())
                .dataRateUnit(createRandomStrings())
                .duration(randomNumeric(4))
                .formats(createRandomVideoFormats())
                .frame(createRandomVideoFrame())
                .frameRate(createRandomVideoDataRate())
                .language(createRandomVideoLanguages())
                .locations(createRandomStrings())
                .messageDigest(createRandomVideoMessageDigest())
                .otherColor(randomAlphabetic(16))
                .otherUses(createRandomStrings())
                .sampleRate(createRandomVideoDataRate())
                .sampling(createRandomStrings())
                .security(randomAlphabetic(16))
                .signalFormat(createRandomStrings())
                .size(rand.nextInt())
                .sound(createRandomStrings())
                .timeCodes(createRandomTimeCodes())
                .trackingInfos(createRandomVideoTrackingInfos())
                .tracks(createRandomVideoTracks())
                .uses(createRandomStrings())
                .build();
        Video videoMD = new Video(Arrays.asList(fileData));
        Video videoSrc = new Video(null);
        return new VideoMDMetadata(videoMD, videoSrc);
    }

    public static List<VideoTrack> createRandomVideoTracks() {
        List<VideoTrack> formats=new ArrayList<VideoTrack>();
        int max=rand.nextInt(2) +1;
        while (max-- > 0){
            formats.add(createRandomVideoTrack());
        }
        return formats;
    }

    public static VideoTrack createRandomVideoTrack() {
        return new VideoTrack.Builder()
            .bitsPerPixelStored(rand.nextFloat())
            .bitsPerSample(rand.nextInt())
            .codec(createRandomVideoCodec())
            .compressionRatio(rand.nextFloat())
            .frame(createRandomVideoFrame())
            .frameRate(createRandomVideoDataRate())
            .id(new Identifier(UUID.randomUUID().toString()).getValue())
            .num(rand.nextInt())
            .quality(randomAlphabetic(16))
            .sampleCount(rand.nextInt())
            .sampleRate(createRandomVideoDataRate())
            .sampling(randomAlphabetic(16))
            .signalFormat(randomAlphabetic(16))
            .build();
    }

    public static VideoCodec createRandomVideoCodec() {
        return new VideoCodec.Builder()
            .channelCount(rand.nextInt())
            .codecId(randomAlphabetic(16))
            .endianess(randomAlphabetic(16))
            .scanOrder(randomAlphabetic(16))
            .scanType(randomAlphabetic(16))
            .sign(randomAlphabetic(16))
            .build();
    }

    public static List<VideoTrackingInfo> createRandomVideoTrackingInfos() {
        List<VideoTrackingInfo> formats=new ArrayList<VideoTrackingInfo>();
        int max=rand.nextInt(2) +1;
        while (max-- > 0){
            formats.add(createRandomVideoTrackingInfo());
        }
        return formats;
    }

    public static VideoTrackingInfo createRandomVideoTrackingInfo() {
        return new VideoTrackingInfo(new Identifier(UUID.randomUUID().toString()).getValue(), randomAlphabetic(16), randomAlphabetic(16));
    }

    public static List<VideoTimeCode> createRandomTimeCodes() {
        List<VideoTimeCode> formats=new ArrayList<VideoTimeCode>();
        int max=rand.nextInt(2) +1;
        while (max-- > 0){
            formats.add(createRandomVideoTimeCode());
        }
        return formats;
    }

    public static VideoTimeCode createRandomVideoTimeCode() {
        return new VideoTimeCode.Builder()
            .id(new Identifier(UUID.randomUUID().toString()).getValue())
            .timeCodeInitialValue(randomAlphabetic(16))
            .timeCodeRecordMethod(randomAlphabetic(16))
            .timeCodeType(randomAlphabetic(16))
            .build();
    }

    public static List<VideoLanguage> createRandomVideoLanguages() {
        List<VideoLanguage> formats=new ArrayList<VideoLanguage>();
        int max=rand.nextInt(2) +1;
        while (max-- > 0){
            formats.add(createRandomVideoLanguage());
        }
        return formats;
    }

    public static VideoLanguage createRandomVideoLanguage() {
        return VideoLanguage.fromString(randomAlphabetic(3));
    }

    public static VideoFrame createRandomVideoFrame() {
        return new VideoFrame.Builder()
            .dar(randomAlphabetic(15))
            .frameRate(rand.nextFloat())
            .id(new Identifier(UUID.randomUUID().toString()).getValue())
            .par(rand.nextFloat())
            .pixelsHorizontal(rand.nextInt())
            .pixelsVertical(rand.nextInt())
            .rotation(rand.nextFloat())
            .build();
}

    public static List<VideoFormat> createRandomVideoFormats() {
        List<VideoFormat> formats=new ArrayList<VideoFormat>();
        int max=rand.nextInt(2) +1;
        while (max-- > 0){
            formats.add(createRandomVideoFormat());
        }
        return formats;
    }

    public static VideoFormat createRandomVideoFormat() {
        return new VideoFormat.Builder()
            .annotation(randomAlphabetic(16))
            .commercialName(randomAlphabetic(16))
            .creatorApp(randomAlphabetic(16))
            .creatorLib(randomAlphabetic(16))
            .creatorLibDate(randomAlphabetic(16))
            .creatorLibSettings(randomAlphabetic(16))
            .encodingDate(randomAlphabetic(16))
            .mimeType(randomAlphabetic(16))
            .name(randomAlphabetic(16))
            .profile(randomAlphabetic(16))
            .settings(randomAlphabetic(16))
            .taggedDate(randomAlphabetic(16))
            .version(randomAlphabetic(16))
            .build();
    }

    public static VideoMessageDigest createRandomVideoMessageDigest() {
        return new VideoMessageDigest.Builder()
            .id(new Identifier(UUID.randomUUID().toString()).getValue())
            .messageDigest(randomAlphabetic(16))
            .messageDigestAlgorithm(randomAlphabetic(16))
            .messageDigestDateTime(new Date())
            .build();
    }

    public static VideoVariableRate createRandomVideoDataRate() {
        return new VideoVariableRate.Builder()
            .maximum(rand.nextFloat())
            .minimum(rand.nextFloat())
            .mode(randomAlphabetic(16))
            .nominal(rand.nextFloat())
            .unit(randomAlphabetic(16))
            .build();
    }

    public static List<VideoCompression> createRandomVideoCompressions() {
        List<VideoCompression> compressions=new ArrayList<VideoCompression>();
        int max=rand.nextInt(2) +1;
        while (max-->0){
            compressions.add(createRandomVideoCompression());
        }
        return compressions;
    }

    public static VideoCompression createRandomVideoCompression() {
        return new VideoCompression.Builder()
            .codecCreatorApp(randomAlphabetic(16))
            .codecCreatorAppVersion(randomNumeric(4))
            .codecName(randomAlphabetic(16))
            .codecQuality(randomAlphabetic(16))
            .id(new Identifier(UUID.randomUUID().toString()).getValue())
            .build();
    }

    public static List<Representation> createRandomRepresentations() {
        int num = 6;
        List<Representation> representations = new ArrayList<Representation>();
        while (num-- > 0) {
            switch (num) {
            case 1:
                representations.add(createRandomRepresentation(TechnicalMetadata.MetadataType.NISO_MIX));
                break;
            case 2:
                representations.add(createRandomRepresentation(TechnicalMetadata.MetadataType.FITS));
                break;
            case 4:
                representations.add(createRandomRepresentation(MetadataType.AUDIOMD));
                break;
            case 5:
                representations.add(createRandomRepresentation(MetadataType.VIDEOMD));
                break;
            default:
            case 3:
                representations.add(createRandomRepresentation(TechnicalMetadata.MetadataType.TEXTMD));
                break;
            }
        }
        return representations;
    }

    public static RightsMetadata createRandomRights() {
        int num = rand.nextInt(3) + 1;
        List<RightsStatement> statements = new ArrayList<RightsStatement>();
        while (num-- > 0) {
            RightsStatement st = new RightsStatement.Builder()
                    .licenseInformation(createRandomLicenseInformation())
                    .copyrightInformation(createRandomCopyrightInformation())
                    .linkingAgents(createRandomLinkingAgents())
                    .linkingObjects(createRandomLinkingObjects())
                    .rightsBasis(randomAlphabetic(16))
                    .rightsGranted(createRandomRightsGranted())
                    .rightsStatementIdentifier(new Identifier(UUID.randomUUID().toString()))
                    .statuteInformation(createRandomStatuteInfomation())
                    .build();
            statements.add(st);
        }
        return new PremisRightsMetadata(statements);
    }

    public static List<GrantedRights> createRandomRightsGranted() {
        List<GrantedRights> grantedRights = new ArrayList<GrantedRights>();
        int num = rand.nextInt(2) + 1;
        while (num-- > 0) {
            grantedRights.add(new GrantedRights(randomAlphabetic(4), "", createRandomTermOfGrant(), Arrays.asList(randomAlphabetic(16))));
        }
        return grantedRights;
    }

    public static ScannerCapture createRandomScannerCapture() {
        return new ScannerCapture.Builder()
                .maximumOpticalResolution("1200x1200")
                .scannerManufacturer(randomAlphabetic(16))
                .scannerModelName(randomAlphabetic(16))
                .scannerModelNumber(randomNumeric(16))
                .scannerModelSerialNo(randomNumeric(16))
                .scannerSensor(ScannerSensor.MONOCHROME_LINEAR)
                .scanningSoftwareName(randomAlphabetic(16))
                .scanningSoftwareVersionNo(randomNumeric(3))
                .build();
    }

    public static List<StatuteInformation> createRandomStatuteInfomation() {
        List<StatuteInformation> si = new ArrayList<StatuteInformation>();
        int num = rand.nextInt(2) + 1;
        while (num-- > 0) {
            si.add(new StatuteInformation(randomAlphabetic(2), randomAlphabetic(16), new Date(), Arrays.asList(randomAlphabetic(16))));
        }
        return si;
    }

    public static List<String> createRandomStrings() {
        List<String> strings = new ArrayList<String>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            strings.add(randomAlphabetic(16));
        }
        return strings;
    }

    public static List<String> createRandomStrings(int stringSize) {
        List<String> strings = new ArrayList<String>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            strings.add(randomAlphabetic(stringSize));
        }
        return strings;
    }

    public static TargetData createRandomTargetData() {
        return new TargetData(Arrays.asList(TargetType.EXTERNAL),
                Arrays.asList(new TargetData.TargetId(randomAlphabetic(16), randomAlphabetic(16),
                        randomNumeric(2), randomAlphabetic(16))),
                Arrays.asList(URI.create("http.//example.com/" + randomAlphabetic(16))),
                Arrays.asList(URI.create("http.//example.com/" + randomAlphabetic(16))));
    }

    public static TechnicalMetadata createRandomTechnicalMetadata() {
        GeneralCaptureInformation cap = new GeneralCaptureInformation(new Date(), CaptureDevice.DIGITAL_STILL_CAMERA, Arrays.asList("Camera"));
        return new NisoMixMetadata.Builder()
                .width(800)
                .height(600)
                .orientation(Orientation.NORMAL)
                .generalCaptureInformation(cap)
                .build();
    }

    public static TermOfGrant createRandomTermOfGrant() {
        return new TermOfGrant(new Date(), new Date());
    }

    public static TechnicalMetadata createRandomTextMDMetadata() {
        return new TextMDMetadata.Builder()
                .altLanguages(createRandomStrings(2))
                .characterInfos(createRandomCharacterInfos())
                .encodings(createRandomEncodings())
                .markupBases(createRandomStrings())
                .fontScripts(createRandomStrings())
                .languages(createRandomStrings(2))
                .markupLanguages(createRandomStrings(2))
                .printRequirements(createRandomStrings())
                .processingNotes(createRandomStrings())
                .textNotes(createRandomStrings())
                .viewingRequirements(createRandomStrings())
                .build();
    }

    public static List<String> createRandomTimeStamps() {
        List<String> timestamps = new ArrayList<String>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            timestamps.add(dateFormatter.format(new Date()));
        }
        return timestamps;
    }

    public static ToolOutput createRandomToolOutput() {
        return new ToolOutput();
    }

    public static TrackingInfo createRandomTrackingInfo() {
        return new TrackingInfo(new Identifier(UUID.randomUUID().toString()).getValue(), createRandomStrings(), createRandomStrings());
    }

    public static List<TrackingInfo> createRandomTrackingInfos() {
        List<TrackingInfo> tis = new ArrayList<TrackingInfo>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            tis.add(createRandomTrackingInfo());
        }
        return tis;
    }

    public static List<PhysicalData> createRanomdPhysicalDatas() {
        List<PhysicalData> data = new ArrayList<PhysicalData>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            data.add(createRandomPhysicalData());
        }
        return data;
    }

    public static Version createrRandomFitsVersion() {
        return new Version.Builder()
                .status(FitsStatus.UNKNOWN)
                .toolName(randomAlphabetic(16))
                .toolVersion(randomNumeric(2))
                .value(randomAlphabetic(16))
                .build();
    }

    public static List<SoundChannelMap> createSoundChannelMaps() {
        List<SoundChannelMap> maps = new ArrayList<SoundChannelMap>();
        int max = rand.nextInt(2) + 1;
        while (max-- > 0) {
            maps.add(new SoundChannelMap(createRandomChannelAssignments()));
        }
        return maps;
    }

}
