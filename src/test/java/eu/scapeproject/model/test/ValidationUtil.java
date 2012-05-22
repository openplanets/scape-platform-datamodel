package eu.scapeproject.model.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import eu.scapeproject.model.metadata.DescriptiveMetadata;
import eu.scapeproject.model.metadata.RightsMetadata;
import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.metadata.dc.DCMetadata;
import eu.scapeproject.model.metadata.mix.NisoMixMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.CharacterInfo;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingAgent;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingPlatform;

public abstract class ValidationUtil {
    private static void assertNoNulls(List<String> strings) {
        for (String s : strings) {
            assertNotNull(s);
        }
    }

    private static void validateAltLanguages(List<String> altLanguages) {
        for (String lang:altLanguages){
            assertNotNull(lang);
            assertTrue(lang.length() == 2);
        }

    }

    private static void validateCharacterInfo(CharacterInfo ci) {
        assertNotNull(ci.getByteOrder());
        assertNotNull(ci.getByteSize());
        assertNotNull(ci.getCharacterSize());
        assertNotNull(ci.getCharSet());
        assertNotNull(ci.getLineBreak());
    }

    private static void validateCharacterInfos(List<CharacterInfo> characterInfos) {
        for (CharacterInfo ci:characterInfos){
            validateCharacterInfo(ci);
        }
    }


    public static void validateDescriptiveMetadata(DescriptiveMetadata metadata) {
        DCMetadata dc=(DCMetadata) metadata;
        assertNotNull(dc.getDescription());
        assertTrue(dc.getConstributors().size() > 0);
        assertTrue(dc.getCoverage().size() > 0);
        assertTrue(dc.getCreator().size() > 0);
        assertTrue(dc.getDate().size() > 0);
        assertTrue(dc.getDescription().size() > 0);
        assertTrue(dc.getFormat().size() > 0);
        assertTrue(dc.getLanguage().size() > 0);
        assertTrue(dc.getPublisher().size() > 0);
        assertTrue(dc.getRelations().size() > 0);
        assertTrue(dc.getRights().size() > 0);
        assertTrue(dc.getSources().size() > 0);
        assertTrue(dc.getSubject().size() > 0);
        assertTrue(dc.getTitle().size() > 0);
        assertTrue(dc.getType().size() > 0);
    }

    public static void validateEncoding(Encoding enc) {
        validateEncodingAgent(enc.getAgent());
        validateEncodingPlatform(enc.getPlatform());
        assertNotNull(enc.getSoftware());
    }

    public static void validateEncodingAgent(EncodingAgent ag) {
        assertNotNull(ag.getRole());
    }


    public static void validateEncodingAgents(List<EncodingAgent> encodingAgents) {
        for (EncodingAgent ag : encodingAgents) {
            validateEncodingAgent(ag);
        }
    }

    public static void validateEncodingPlatform(EncodingPlatform pl) {
        assertNotNull(pl.getLineBreak());

    }

    public static void validateEncodingPlatforms(List<EncodingPlatform> encodingPlatforms) {
        for (EncodingPlatform pl : encodingPlatforms) {
            validateEncodingPlatform(pl);
        }
    }

    public static void validateEncodings(List<Encoding> encodings) {
        for (Encoding enc : encodings) {
            validateEncoding(enc);
        }
    }

    public static void validateRightsRecord(RightsMetadata rights) {

    }

    public static void validateTechMDRecord(TechnicalMetadata technical) {
        assertNotNull(technical);
        if (technical.getMetadataType() == TechnicalMetadata.MetadataType.TEXTMD) {
            TextMDMetadata textmd = (TextMDMetadata) technical;
            validateAltLanguages(textmd.getAltLanguages());
            validateCharacterInfos(textmd.getCharacterInfos());
            validateEncodings(textmd.getEncodings());
            assertNoNulls(textmd.getMarkupBases());
            assertNoNulls(textmd.getFontScripts());
            assertNoNulls(textmd.getLanguages());
            assertNoNulls(textmd.getPrintRequirements());
            assertNoNulls(textmd.getProcessingNotes());
            assertNoNulls(textmd.getTextNotes());
            assertNoNulls(textmd.getViewingRequirements());
        } else if (technical.getMetadataType() == TechnicalMetadata.MetadataType.NISO_MIX) {
            NisoMixMetadata niso = (NisoMixMetadata) technical;
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getColorProfile());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getColorSpace());
            assertNotNull(niso.getImageCapture().getDigitalCameraCapture());
            assertNotNull(niso.getImageCapture().getGeneralCaptureInformation());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getWidth());
            assertNotNull(niso.getImageAssessmentMetadata().getImageColorEncoding());
            assertNotNull(niso.getImageCapture().getMethodology());
            assertNotNull(niso.getImageCapture().getOrientation());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getReferencedBlackWhite());
            assertNotNull(niso.getImageCapture().getScannerCapture());
            assertNotNull(niso.getImageCapture().getSourceInformation());
            assertNotNull(niso.getImageAssessmentMetadata().getSpacialMetrics());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getSpecialFormatCharacteristics());
            assertNotNull(niso.getImageAssessmentMetadata().getTargetData());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getHeight());
            assertNotNull(niso.getBasicImageInformation().getBasicImageCharacteristics().getPhotometricInterpretation().getYbCbCr());
        }
    }
}
