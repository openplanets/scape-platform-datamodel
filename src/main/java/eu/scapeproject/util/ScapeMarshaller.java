/*
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package eu.scapeproject.util;

import info.lc.xmlns.premis_v2.Bitstream;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import eu.scapeproject.model.File;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.IntellectualEntityCollection;
import eu.scapeproject.model.Representation;
import eu.scapeproject.model.__IntellectualEntityCollection;
import eu.scapeproject.model.jaxb.ScapeNamespacePrefixMapper;
import eu.scapeproject.model.plan.PlanExecutionState;
import eu.scapeproject.model.plan.PlanExecutionStateCollection;
import gov.loc.mets.Mets;
import gov.loc.mets.MetsType;

/**
*
* @author frank asseg
*
*/
public class ScapeMarshaller {

    private final Map<String, IntellectualEntityConverter> converters = new HashMap<String, IntellectualEntityConverter>();
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final JAXBContext context;

    private ScapeMarshaller(IntellectualEntityConverter[] converter) throws JAXBException {
        this.context = JAXBContext
                .newInstance("eu.scapeproject.model:eu.scapeproject.model.plan:com.google.books.gbs:edu.harvard.hul.ois.xml.ns.fits.fits_output:info.lc.xmlns.textmd_v3:gov.loc.audiomd:gov.loc.marc21.slim:gov.loc.mets:gov.loc.mix.v20:gov.loc.videomd:info.lc.xmlns.premis_v2:org.purl.dc.elements._1");
        this.marshaller = context.createMarshaller();
        this.marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new ScapeNamespacePrefixMapper());
        this.marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        this.unmarshaller = context.createUnmarshaller();

        /*
         * create and add a default converter which is used by the scape marshaller to convert MetsTypes to
         * IntellectualEntities
         */
        DefaultConverter dc = new DefaultConverter();
        this.converters.put(dc.getProfileName(), dc);

        /*
         * create and add the ONB mets converter to convert ONB mets files into IntellectualEntities
         */
        ONBConverter onb = new ONBConverter();
        this.converters.put(onb.getProfileName(), onb);

        /*
         * add the user supplied converters for later availability for the ScapeMarshaller
         */
        if (converter != null) {
            for (IntellectualEntityConverter c : converter) {
                if (this.converters.containsKey(c.getProfileName())) {
                    throw new IllegalArgumentException("The profile " + c.getProfileName() + " already has a converter associated");
                }
                this.converters.put(c.getProfileName(), c);
            }
        }
    }

    public Marshaller getJaxbMarshaller() {
        return marshaller;
    }

    public Unmarshaller getJaxbUnmarshaller() {
        return unmarshaller;
    }

    public static ScapeMarshaller newInstance() throws JAXBException {
        return new ScapeMarshaller(null);
    }

    public static ScapeMarshaller newInstance(IntellectualEntityConverter... converter) throws JAXBException {
        return new ScapeMarshaller(converter);
    }

    public Object deserialize(InputStream src) throws JAXBException {
        return unmarshaller.unmarshal(src);
    }

    public void serialize(Object obj, OutputStream sink, boolean useMdRef) throws JAXBException{
        if (obj instanceof IntellectualEntity) {
            marshaller.marshal(this.converters.get("scape").convertEntity((IntellectualEntity) obj, useMdRef), sink);
        } else if (obj instanceof IntellectualEntityCollection) {
            IntellectualEntityCollection coll = (IntellectualEntityCollection) obj;
            List<Mets> mets = new ArrayList<Mets>();
            for (IntellectualEntity e : coll.getEntities()) {
                mets.add((Mets) this.converters.get("scape").convertEntity(e, useMdRef));
            }
            __IntellectualEntityCollection _int = new __IntellectualEntityCollection(mets);
            marshaller.marshal(_int, sink);
        } else {
            marshaller.marshal(obj, sink);
        }
    }

    public void serialize(Object obj, OutputStream sink) throws JAXBException {
        this.serialize(obj, sink, false);
    }

    public void setMarshallerProperty(String property, Object value) throws PropertyException {
        this.marshaller.setProperty(property, value);
    }

    public void setUnmarshallerProperty(String property, Object value) throws PropertyException {
        this.unmarshaller.setProperty(property, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> type, InputStream src) throws JAXBException {
        if (type == IntellectualEntity.class) {
            MetsType mets = (MetsType) unmarshaller.unmarshal(src);

            /*
             * get the corresponding converter for the mets profile which handles the MetsType and returns an entity
             */
            IntellectualEntityConverter conv;
            if (mets.getPROFILE() == null) {
                /* no profile given try the default entity converter */
                conv = converters.get("scape");
            } else {
                conv = converters.get(mets.getPROFILE());
            }

            /* can not convert the used profile so an exception is thrown */
            if (conv == null) {
                throw new IllegalArgumentException("Unable to deseriliaze mets profile " + mets.getPROFILE());
            }
            return (T) conv.convertMets(mets);
        } else if (type == IntellectualEntityCollection.class) {
            __IntellectualEntityCollection coll = (__IntellectualEntityCollection) unmarshaller.unmarshal(src);
            List<IntellectualEntity> entities = new ArrayList<IntellectualEntity>();
            for (Mets m : coll.getMets()) {
                IntellectualEntityConverter conv;
                if (m.getPROFILE() == null) {
                    /* no profile given try the default entity converter */
                    conv = converters.get("scape");
                } else {
                    conv = converters.get(m.getPROFILE());
                }
                entities.add(conv.convertMets(m));
            }
            return (T) new IntellectualEntityCollection(entities);
        } else if (isScapeObject(type)) {
            return (T) unmarshaller.unmarshal(src);
        }
        else {
            throw new IllegalArgumentException("Unable to deserilialize type " + type.getName());
        }
    }

    private boolean isScapeObject(final Class type) {
        return type == Representation.class ||
                type == File.class ||
                type == Bitstream.class ||
                type == PlanExecutionState.class ||
                type == PlanExecutionStateCollection.class;
    }

    public void addConverter(IntellectualEntityConverter conv) {
        if (conv.getProfileName() == null || conv.getProfileName().length() == 0) {
            throw new IllegalArgumentException("Please set a profile name for the custom converter");
        }
        if (converters.containsKey(conv.getProfileName())) {
            throw new IllegalArgumentException("The profile " + conv.getProfileName() + " has already a converter associated with it");
        }
        this.converters.put(conv.getProfileName(), conv);
    }

    public <T> List<T> parseCollection(String xmlString, Class<T> rootClass, String tagName) throws JAXBException, XMLStreamException {
        XMLInputFactory inFac = XMLInputFactory.newFactory();
        XMLStreamReader reader = inFac.createXMLStreamReader(
                new StringReader("<" + tagName + ">" + xmlString + "</" + tagName + ">"));
        reader.nextTag(); // move to the <root> tag
        reader.nextTag(); // move to the first child
        List<T> list = new ArrayList<T>();
        while (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
            list.add(rootClass.cast(unmarshaller.unmarshal(reader)));

            // unmarshal leaves the reader pointing at the event *after* the
            // closing tag, not the END_ELEMENT event itself, so we can't just
            // do nextTag unconditionally. We may already be on the next opening
            // tag or the closing </root> but we might need to advance if there
            // is whitespace between tags
            if (reader.getEventType() != XMLStreamConstants.START_ELEMENT &&
                    reader.getEventType() != XMLStreamConstants.END_ELEMENT) {
                reader.nextTag();
            }
        }
        reader.close();
        return list;
    }

}
