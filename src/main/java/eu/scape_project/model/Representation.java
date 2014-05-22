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

import eu.scape_project.util.CopyUtil;
import org.purl.dc.elements._1.ElementContainer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

import static eu.scape_project.model.Utils.*;

/**
 * @author frank asseg
 */
@XmlRootElement(name = "representation", namespace = "http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class Representation extends Identified {

 
    @XmlAnyElement(lax = true)
    @XmlElementRef(name = "sourceMD", type = ElementContainer.class)
    private final Object source;

    @XmlAnyElement(lax = true)
    @XmlElementRef(name = "premis", namespace = "info:lc/xmlns/premis-v2", type = JAXBElement.class)
    private final Object provenance;

    @XmlElement(name = "technicals", namespace = "http://scape-project.eu/model")
    private final TechnicalMetadataList technical;

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
		this.files = builder.files.isEmpty() ? null : new ArrayList<File>(
				builder.files);
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

    public TechnicalMetadataList getTechnical() {
        return technical;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Representation [" + "identifier=" + identifier + ", source=" +
               getValue(source) + ", provenance=" + getValue(provenance) + ", technical=" +
               getValue(technical) + ", rights=" + getValue(rights) + ", files=" + files +
               ", title=" + title + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Representation)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Representation that = (Representation) o;
        if (files != null ? !files.equals(that.files) : that.files != null) {
            return false;
        }
        if (provenance != null ? !getValue(provenance).equals(getValue(that.provenance)) : that.provenance != null) {
            return false;
        }
        if (rights != null ? !getValue(rights).equals(getValue(that.rights)) : that.rights != null) {
            return false;
        }
        if (source != null ? !getValue(source).equals(getValue(that.source)) : that.source != null) {
            return false;
        }
        if (technical != null ? !getValue(technical).equals(getValue(that.technical)) : that.technical != null) {
            return false;
        }
        if (title != null ? !title.equals(that.title) : that.title != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (source != null ? getValue(source).hashCode() : 0);
        result = 31 * result + (provenance != null ? getValue(provenance).hashCode() : 0);
        result = 31 * result + (technical != null ? getValue(technical).hashCode() : 0);
        result = 31 * result + (rights != null ? getValue(rights).hashCode() : 0);
        result = 31 * result + (files != null ? files.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public static class Builder {

        private Object source;

        private Object provenance;

        private TechnicalMetadataList technical;

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
			this.files = copy.files == null ? new ArrayList<File>()
					: new ArrayList<File>(copy.files);
            this.id = copy.identifier;
            this.title = copy.title;
        }

        public Representation build() {
            return new Representation(this);
        }

        public Builder files(List<File> files) {
            this.files = new ArrayList<File>(files);
            return this;
        }

        public Builder file(File file) {
            files.add(file);
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

        public Builder technical(String id, Object content) {
            return technical(new TechnicalMetadata(id, content));
        }

        public Builder technical(TechnicalMetadata technical) {
            if (this.technical == null) {
                this.technical = new TechnicalMetadataList();
            }
            this.technical.getContent().add(technical);
            return this;
        }

        public Builder technical(TechnicalMetadataList technical) {
            this.technical = technical;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

    }
}
