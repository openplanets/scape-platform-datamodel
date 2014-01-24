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

package eu.scape_project.model;

import com.google.books.gbs.GbsType;
import edu.harvard.hul.ois.xml.ns.fits.fits_output.Fits;
import eu.scape_project.util.CopyUtil;
import gov.loc.mix.v20.Mix;
import info.lc.xmlns.textmd_v3.TextMD;
import org.purl.dc.elements._1.ElementContainer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author frank asseg
*
*/
@XmlRootElement(name = "representation", namespace = "http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class Representation extends Identified{


    @XmlAnyElement(lax = true)
    @XmlElementRef(name = "sourceMD", type = ElementContainer.class)
    private final Object source;

    @XmlAnyElement(lax = true)
    @XmlElementRef(name = "premis", namespace = "info:lc/xmlns/premis-v2", type = JAXBElement.class)
    private final Object provenance;

    @XmlAnyElement(lax = true)
    @XmlElementRefs({
            @XmlElementRef(name = "textMD", type = TextMD.class),
            @XmlElementRef(name = "fits", type = Fits.class),
            @XmlElementRef(name = "mix", type = Mix.class),
            @XmlElementRef(name = "gbs", type = GbsType.class),
            @XmlElementRef(name = "VIDEOMD", namespace = "http://www.loc.gov/videoMD/", type = JAXBElement.class),
            @XmlElementRef(name = "AUDIOMD", namespace = "http://www.loc.gov/audioMD/", type = JAXBElement.class)})
    private final Object technical;

    @XmlAnyElement(lax = true)
    @XmlElementRef(name = "rights", namespace = "info:lc/xmlns/premis-v2", type = JAXBElement.class)
    private final Object rights;

    @XmlElement(name = "files", namespace = "http://scape-project.eu/model")
    private final List<File> files;

    @XmlElement(name = "title", namespace = "http://scape-project.eu/model")
    private final String title;

    private Representation() {
        super(null);
        this.source = null;
        this.provenance = null;
        this.technical = null;
        this.rights = null;
        this.files = null;

        this.title = null;
    }

    private Representation(Builder builder) {
        super(builder.id);
        this.source = builder.source;
        this.provenance = builder.provenance;
        this.technical = builder.technical;
        this.rights = builder.rights;
        this.files = builder.files;
        this.title = builder.title;
    }

    public List<File> getFiles() {
        return files;
    }

    public Object getProvenance() {
        return provenance;
    }

    public Object getRights() {
        return rights;
    }

    public Object getSource() {
        return source;
    }

    public Object getTechnical() {
        return technical;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Representation [" + "identifier=" + identifier + ", source=" +
                source + ", provenance=" + provenance + ", technical=" +
                technical + ", rights=" + rights + ", files=" + files +
                ", title=" + title + "]";
    }

    public static class Builder {

        private Object source;

        private Object provenance;

        private Object technical;

        private Object rights;

        private List<File> files = new ArrayList<File>();

        private Identifier id;

        private String title;

        public Builder() {
            super();
        }

        public Builder(Identifier id) {
            super();
            this.id = id;
        }

        public Builder(Representation orig) {
            Representation copy = CopyUtil.deepCopy(Representation.class, orig);
            this.source = copy.source;
            this.provenance = copy.provenance;
            this.technical = copy.technical;
            this.rights = copy.rights;
            this.files = copy.files;
            this.id = copy.identifier;
            this.title = copy.title;
        }

        public Representation build() {
            return new Representation(this);
        }

        public Builder files(List<File> files) {
            this.files = files;
            return this;
        }

        public Builder identifier(Identifier id) {
            this.id = id;
            return this;
        }

        public Builder provenance(Object provenance) {
            this.provenance = provenance;
            return this;
        }

        public Builder rights(Object rights) {
            this.rights = rights;
            return this;
        }

        public Builder source(Object source) {
            this.source = source;
            return this;
        }

        public Builder technical(Object technical) {
            this.technical = technical;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

    }
}
