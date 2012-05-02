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
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.AltLanguage;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.CharacterInfo;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingAgent;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingPlatform;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.Encoding.EncodingSoftware;
import eu.scapeproject.model.metadata.textmd.TextMDMetadata.MarkupBasis;

public abstract class ValidationUtil {
    public static void validateTechMDRecord(TechnicalMetadata technical) {
        assertNotNull(technical);
        if (technical.getMetadataType() == TechnicalMetadata.MetadataType.TEXTMD) {
            TextMDMetadata textmd = (TextMDMetadata) technical;
            validateAltLanguages(textmd.getAltLanguage());
            validateCharacterInfos(textmd.getCharacterInfo());
            validateMarkupBases(textmd.getMarkupBasis());
            validateEncodings(textmd.getEncoding());
            assertNoNulls(textmd.getFontScript());
            assertNoNulls(textmd.getLanguage());
            assertNoNulls(textmd.getPrintRequirements());
            assertNoNulls(textmd.getProcessingNote());
            assertNoNulls(textmd.getTextNote());
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

    private static void validateMarkupBases(List<MarkupBasis> markupBases) {
        for (MarkupBasis b: markupBases){
            validateMarkupBasis(b);
        }
    }

    private static void validateMarkupBasis(MarkupBasis b) {
        assertNotNull(b.getValue());
        assertNotNull(b.getVersion());
    }

    private static void validateCharacterInfos(List<CharacterInfo> characterInfos) {
        for (CharacterInfo ci:characterInfos){
            validateCharacterInfo(ci);
        }
    }

    private static void validateCharacterInfo(CharacterInfo ci) {
        assertNotNull(ci.getByteOrder());
        assertNotNull(ci.getByteSize().getValue());
        assertNotNull(ci.getCharacterSize().getEncoding());
        assertNotNull(ci.getCharacterSize().getValue());
        assertNotNull(ci.getCharset());
        assertNotNull(ci.getLinebreak());
    }

    private static void validateAltLanguages(List<AltLanguage> altLanguages) {
        for (AltLanguage lang : altLanguages) {
            validateAltLanguage(lang);
        }

    }

    private static void validateAltLanguage(AltLanguage lang) {
        assertNotNull(lang.getAuthority());
        assertNotNull(lang.getValue());
    }

    private static void assertNoNulls(List<String> fontScript) {
        for (String s : fontScript) {
            assertNotNull(s);
        }
    }

    public static void validateEncodings(List<Encoding> encodings) {
        for (Encoding enc : encodings) {
            validateEncoding(enc);
        }
    }

    public static void validateEncoding(Encoding enc) {
        validateEncodingAgents(enc.getEncodingAgent());
        validateEncodingPlatforms(enc.getEncodingPlatform());
        validateEncodingSoftwares(enc.getEncodingSoftware());
        assertNotNull(enc.getQUALITY());
    }

    public static void validateEncodingSoftwares(List<EncodingSoftware> encodingSoftwares) {
        for (EncodingSoftware es : encodingSoftwares) {
            validateEncodingSoftware(es);
        }
    }

    public static void validateEncodingSoftware(EncodingSoftware es) {
        assertNotNull(es.getVersion());
        assertNotNull(es.getValue());

    }

    public static void validateEncodingPlatforms(List<EncodingPlatform> encodingPlatforms) {
        for (EncodingPlatform pl : encodingPlatforms) {
            validateEncodingPlatform(pl);
        }
    }

    public static void validateEncodingPlatform(EncodingPlatform pl) {
        assertNotNull(pl.getLinebreak());
        assertNotNull(pl.getValue());

    }

    public static void validateEncodingAgents(List<EncodingAgent> encodingAgents) {
        for (EncodingAgent ag : encodingAgents) {
            validateEncodingAgent(ag);
        }
    }

    public static void validateEncodingAgent(EncodingAgent ag) {
        assertNotNull(ag.getRole());
        assertNotNull(ag.getValue());
    }

    public static void validateRightsRecord(RightsMetadata rights) {

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
}
