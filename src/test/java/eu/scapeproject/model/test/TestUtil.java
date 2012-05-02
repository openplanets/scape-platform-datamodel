package eu.scapeproject.model.test;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

import com.sun.xml.bind.v2.runtime.output.Encoded;

import eu.scapeproject.model.Agent;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.UUIDIdentifier;
import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.ColorProfile;
import eu.scapeproject.model.metadata.mix.DJVUFormatCharacteristics;
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
import eu.scapeproject.model.metadata.mix.SourceInformation;
import eu.scapeproject.model.metadata.mix.SourceInformation.SourceDimension;
import eu.scapeproject.model.metadata.mix.JPEG2000FormatCharacteristics;
import eu.scapeproject.model.metadata.mix.MRSIDFormatCharacteristics;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata.Orientation;
import eu.scapeproject.model.metadata.mix.ReferencedBlackWhite;
import eu.scapeproject.model.metadata.mix.ScannerCapture;
import eu.scapeproject.model.metadata.mix.ScannerCapture.ScannerSensor;
import eu.scapeproject.model.metadata.mix.SpacialMetrics;
import eu.scapeproject.model.metadata.mix.SpacialMetrics.SamplingFrequencyPane;
import eu.scapeproject.model.metadata.mix.SpacialMetrics.SamplingFrequencyUnit;
import eu.scapeproject.model.metadata.mix.SpecialFormatCharacteristics;
import eu.scapeproject.model.metadata.mix.TargetData;
import eu.scapeproject.model.metadata.mix.TargetData.TargetType;
import eu.scapeproject.model.metadata.mix.YCbCr;
import eu.scapeproject.model.metadata.mix.YCbCr.YCbCrSubSampling.SubSampling;
import eu.scapeproject.model.metadata.premis.Event;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding;

public abstract class TestUtil {

    public static final Random rand = new Random();
    public static final DateFormat dateFormatter = new SimpleDateFormat("d-M-y hh:mm:ss");

    public static IntellectualEntity createRandomEntity() {
        return new IntellectualEntity(new UUIDIdentifier(),createRandomIdentifiers(), createRandomDescriptive(), createRandomRepresentations());
    }

    private static List<Identifier> createRandomIdentifiers() {
        List<Identifier> identifiers=new ArrayList<Identifier>();
        int amount=rand.nextInt(2) + 1;
        for (int i=0;i<amount;i++){
            identifiers.add(new UUIDIdentifier());
        }
        return identifiers;
    }

    private static List<Representation> createRandomRepresentations() {
        int num = rand.nextInt(4) + 1;
        int type = rand.nextInt(1) + 1;
        List<Representation> representations = new ArrayList<Representation>();
        while (num-- > 0) {
            switch (type) {
            case 0:
                representations.add(createRandomRepresentation(TechnicalMetadata.MetadataType.NISO_MIX));
                break;
            case 1:
            default:
                representations.add(createRandomRepresentation(TechnicalMetadata.MetadataType.NISO_MIX));
            }
        }
        return representations;
    }

    private static Representation createRandomRepresentation(TechnicalMetadata.MetadataType type) {
        Representation.Builder b = new Representation.Builder()
                .technical(createRandomTechnicalMetadata())
                .provenance(createRandomEvents())
                .source(createRandomDescriptive())
                .provenance(createRandomEvents());
        switch (type) {
        case NISO_MIX:
            b.technical(createRandomNisoMixMetadata());
            break;
        case TEXTMD:
        default:
            b.technical(createRandomTextMDMetadata());
        }
        return b.build();
    }

    private static TechnicalMetadata createRandomTechnicalMetadata() {
        GeneralCaptureInformation cap=new GeneralCaptureInformation(new Date(), CaptureDevice.DIGITAL_STILL_CAMERA,Arrays.asList("Camera"));
        return new NisoMixMetadata.Builder()
            .width(800)
            .height(600)
            .orientation(Orientation.NORMAL)
            .generalCaptureInformation(cap)
            .build();
    }

    private static TechnicalMetadata createRandomNisoMixMetadata() {
        NisoMixMetadata mix = new NisoMixMetadata.Builder()
                .height(rand.nextInt(2000))
                .width(rand.nextInt(2000))
                .colorProfile(createRandomColorProfile())
                .colorspace("RGB")
                .digitalCameraCapture(createRandomDigitalCameraCapture())
                .generalCaptureInformation(createGeneralCaptureInformation())
                .imageColorEncoding(createRandomImageColorEncoding())
                .methodology(RandomStringUtils.randomAlphabetic(16))
                .orientation(Orientation.NORMAL)
                .referencedBlackWhite(new ReferencedBlackWhite(new double[] { 0d, 0d, 0d }, new double[] { 256d, 256d, 256d }))
                .scannerCapture(createRandomScannerCapture())
                .source(createRandomImageSource())
                .spacialMetrics(new SpacialMetrics(SamplingFrequencyPane.DEVICE_FOCAL_PLANE, SamplingFrequencyUnit.INCH, rand.nextDouble(), rand.nextDouble()))
                .specialFormatCharacteristics(createRandomFormatCharacteristics())
                .targetData(createRandomTargetData())
                .yCrCb(new YCbCr(new YCbCr.YCbCrSubSampling(SubSampling.EQUAL_SIZE, SubSampling.EQUAL_SIZE)))
                .build();
        return mix;
    }

    private static SpecialFormatCharacteristics createRandomFormatCharacteristics() {
        switch (rand.nextInt(2) + 1) {
        case 0:
            return new JPEG2000FormatCharacteristics();
        case 1:
            return new DJVUFormatCharacteristics();
        case 2:
            return new MRSIDFormatCharacteristics();
        default:
            return null;
        }
    }

    private static TargetData createRandomTargetData() {
        return new TargetData(Arrays.asList(TargetType.EXTERNAL),
                Arrays.asList(new TargetData.TargetId(RandomStringUtils.randomAlphabetic(16), RandomStringUtils.randomAlphabetic(16),
                        RandomStringUtils.randomNumeric(2), RandomStringUtils.randomAlphabetic(16))),
                Arrays.asList(URI.create("http.//example.com/" + RandomStringUtils.randomAlphabetic(16))),
                Arrays.asList(URI.create("http.//example.com/" + RandomStringUtils.randomAlphabetic(16))));
    }

    private static SourceInformation createRandomImageSource() {
        return new SourceInformation.Builder()
                .sourceIdentifiers(Arrays.asList(new UUIDIdentifier()))
                .sourceType("photograph")
                .sourceXDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceXDimension(rand.nextDouble() * 1000)
                .sourceYDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceYDimension(rand.nextDouble() * 1000)
                .sourceZDiemnsionUnit(SourceDimension.CENTIMETERS)
                .sourceZDimension(rand.nextDouble() * 1000)
                .build();

    }

    private static ScannerCapture createRandomScannerCapture() {
        return new ScannerCapture.Builder()
                .maximumOpticalResolution("1200x1200")
                .scannerManufacturer(RandomStringUtils.randomAlphabetic(16))
                .scannerModelName(RandomStringUtils.randomAlphabetic(16))
                .scannerModelNumber(RandomStringUtils.randomNumeric(16))
                .scannerModelSerialNo(RandomStringUtils.randomNumeric(16))
                .scannerSensor(ScannerSensor.MONOCHROME_LINEAR)
                .scanningSoftwareName(RandomStringUtils.randomAlphabetic(16))
                .scanningSoftwareVersionNo(RandomStringUtils.randomNumeric(3))
                .build();
    }

    private static ImageColorEncoding createRandomImageColorEncoding() {
        return new ImageColorEncoding.Builder()
                .bitsPerSampleUnit(BitsPerSampleUnit.INTEGER)
                .bitsPerSampleValue(RandomStringUtils.randomNumeric(2))
                .colorMapReference(URI.create("http://example.com/" + RandomStringUtils.randomAlphabetic(16)))
                .embeddedColorMap(RandomStringUtils.randomAlphabetic(16).getBytes())
                .extraSamples(ExtraSamples.UNSPECIFIED_DATA)
                .grayResponseCurve((short) rand.nextInt())
                .grayResponseUnit(GrayResponseUnit.TENTH_OF_A_UNIT)
                .samplesPerPixel(rand.nextInt(256))
                .whitePoints(Arrays.asList(new ImageColorEncoding.WhitePoint("256", "256")))
                .build();
    }

    private static GeneralCaptureInformation createGeneralCaptureInformation() {
        return new GeneralCaptureInformation(new Date(Math.abs(rand.nextLong())), CaptureDevice.DIGITAL_STILL_CAMERA, Arrays.asList("Digital Camera"));
    }

    private static DigitalCameraCapture createRandomDigitalCameraCapture() {
        return new DigitalCameraCapture.Builder()
                .digitalCameraManufacturer(RandomStringUtils.randomAlphabetic(16))
                .digitalCameraModelName(RandomStringUtils.randomAlphabetic(16))
                .digitalCameraModelNumber(RandomStringUtils.randomNumeric(2))
                .digitalCameraModelSerialNo(RandomStringUtils.randomNumeric(16))
                .digitalCameraSensor(RandomStringUtils.randomAlphabetic(16))
                .imageData(createRandomImageData())
                .gpsData(createRandomGPSData())
                .build();
    }

    private static GPSData createRandomGPSData() {
        return new GPSData.Builder()
                .gpsAreaInformation(RandomStringUtils.randomAlphanumeric(16))
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
                .gpsVersionId(RandomStringUtils.randomNumeric(3))
                .build();
    }

    private static ImageData createRandomImageData() {
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

    private static ColorProfile createRandomColorProfile() {
        switch (rand.nextInt(2) + 1) {
        case 0:
            return new ColorProfile(new ColorProfile.ICCProfile(RandomStringUtils.randomAlphabetic(16), "version 0.1-TEST", "http://example.com/"
                    + RandomStringUtils.randomAlphabetic(16)));
        case 1:
            return new ColorProfile(new ColorProfile.LocalProfile("version 0.1-TEST", "file://" + RandomStringUtils.randomAlphabetic(16)));
        case 2:
            return new ColorProfile(new ColorProfile.EmbeddedProfile(
                    Base64.encodeBase64String("An embedded Color profile looks different than this string".getBytes())));
        default:
            return null;
        }
    }

    private static TechnicalMetadata createRandomTextMDMetadata() {
        TechnicalMetadata tech = new TextMDMetadata();
        return tech;
    }

    private static List<Event> createRandomEvents() {
        int num = rand.nextInt(4) + 1;
        List<Event> events = new ArrayList<Event>();
        while (num-- > 0) {
            events.add(createRandomEvent());
        }
        return events;
    }

    private static Event createRandomEvent() {
        return new Event.Builder()
                .identifier(new UUIDIdentifier())
                .linkingAgents(Arrays.asList(createRandomAgent()))
                .build();
    }

    private static DescriptiveMetadata createRandomDescriptive() {
        DCMetadata.Builder builder = new DCMetadata.Builder();
        Random rnd = new Random();
        int max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.constributor(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.coverage(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.creator(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.constributor(createRandomAgent());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.date(createRandomDate());
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.description(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.format(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.language(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.publisher(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.relations(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.rights(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.sources(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.subject(RandomStringUtils.randomAlphabetic(16));
        }
        max = rnd.nextInt(9) + 1;
        for (int i = 0; i < max; i++) {
            builder.title(RandomStringUtils.randomAlphabetic(16));
        }
        for (int i = 0; i < max; i++) {
            builder.type(RandomStringUtils.randomAlphabetic(16));
        }
        return builder.build();
    }

    private static Agent createRandomAgent() {
        return new Agent.Builder()
                .name("Agent-" + RandomStringUtils.randomAlphabetic(16))
                .note("no notes")
                .role("Role-" + RandomStringUtils.randomAlphabetic(16))
                .type("INDIVIDUAL")
                .build();
    }

    private static Date createRandomDate() {
        Random rnd = new Random();
        int month = rnd.nextInt(11);
        int year = rnd.nextInt(2012);
        int day = rnd.nextInt(30);
        return new GregorianCalendar(year, month, day).getTime();
    }

}
