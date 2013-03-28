package eu.scapeproject.model;

import info.lc.xmlns.premis_v2.CopyrightInformationComplexType;
import info.lc.xmlns.premis_v2.EventComplexType;
import info.lc.xmlns.premis_v2.LinkingAgentIdentifierComplexType;
import info.lc.xmlns.premis_v2.ObjectFactory;
import info.lc.xmlns.premis_v2.PremisComplexType;
import info.lc.xmlns.premis_v2.RightsComplexType;
import info.lc.xmlns.premis_v2.RightsStatementComplexType;
import info.lc.xmlns.textmd_v3.TextMD;
import info.lc.xmlns.textmd_v3.TextMD.Encoding;
import info.lc.xmlns.textmd_v3.TextMD.Encoding.EncodingPlatform;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import org.purl.dc.elements._1.ElementContainer;
import org.purl.dc.elements._1.SimpleLiteral;

import eu.scapeproject.util.ScapeMarshaller;

public abstract class TestUtil {

    public static final Random rand = new Random();
    public static final DateFormat dateFormatter = new SimpleDateFormat("d-M-y hh:mm:ss");

    public static IntellectualEntity createTestEntity() throws JAXBException {
        return ScapeMarshaller.newInstance().deserialize(IntellectualEntity.class, TestUtil.class.getClassLoader().getResourceAsStream("SCAPE_entity_serialized.xml"));
    }
    
    public static TextMD createTextMDRecord(){
        TextMD textMd = new TextMD();
        Encoding enc = new Encoding();
        EncodingPlatform pf = new EncodingPlatform();
        pf.setLinebreak("LF");
        enc.getEncodingPlatform().add(pf);
        textMd.getEncoding().add(enc);
        return textMd;
    }

    public static JAXBElement<PremisComplexType> createPremisDigiProvRecord() {
        ObjectFactory premisFac = new ObjectFactory();
        PremisComplexType premis = premisFac.createPremisComplexType();
        EventComplexType e = premisFac.createEventComplexType();
        e.setEventDetail("inital ingest");
        e.setEventType("INGEST");
        LinkingAgentIdentifierComplexType agentId = premisFac.createLinkingAgentIdentifierComplexType();
        agentId.setRole("CREATOR");
        agentId.setTitle("Testman Testrevicz");
        e.getLinkingAgentIdentifier().add(agentId);
        premis.getEvent().add(e);
        return premisFac.createPremis(premis);
    }

    public static JAXBElement<RightsComplexType> createPremisRightsRecord() {
        ObjectFactory premisFac = new ObjectFactory();
        RightsComplexType rights = premisFac.createRightsComplexType();
        RightsStatementComplexType stat = premisFac.createRightsStatementComplexType();
        CopyrightInformationComplexType cr = premisFac.createCopyrightInformationComplexType();
        cr.setCopyrightJurisdiction("de");
        cr.setCopyrightStatus("no copyright");
        stat.setCopyrightInformation(cr);
        rights.getRightsStatementOrRightsExtensionOrMdSec().add(stat);
        return premisFac.createRights(rights);
    }

    public static ElementContainer createDCSourceRecord() {
        org.purl.dc.elements._1.ObjectFactory dcFac = new org.purl.dc.elements._1.ObjectFactory();
        ElementContainer cnt = dcFac.createElementContainer();
        SimpleLiteral lit_title = new SimpleLiteral();
        lit_title.getContent().add("Source object 1");
        cnt.getAny().add(dcFac.createTitle(lit_title));
        return cnt;
    }

    public static ElementContainer createDCRecord() {
        org.purl.dc.elements._1.ObjectFactory dcFac = new org.purl.dc.elements._1.ObjectFactory();
        ElementContainer cnt = dcFac.createElementContainer();
        SimpleLiteral lit_title = new SimpleLiteral();
        lit_title.getContent().add("Object 1");
        cnt.getAny().add(dcFac.createTitle(lit_title));
        return cnt;
    }

}
