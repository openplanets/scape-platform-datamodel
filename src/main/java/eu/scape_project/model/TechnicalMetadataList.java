package eu.scape_project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "technical", namespace = "http://scape-project.eu/model")
@XmlAccessorType(XmlAccessType.FIELD)
public class TechnicalMetadataList {

    private List<TechnicalMetadata> content;

    public TechnicalMetadataList(TechnicalMetadata content) {
        this.content = new ArrayList<TechnicalMetadata>();
        this.content.add(content);
    }

    public TechnicalMetadataList(List<TechnicalMetadata> content) {
        this.content = content;
    }

    public List<TechnicalMetadata> getContent() {
        return content;
    }

    public TechnicalMetadataList() {
        content = new ArrayList<TechnicalMetadata>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TechnicalMetadataList)) {
            return false;
        }
        TechnicalMetadataList that = (TechnicalMetadataList) o;
        if (content != null ? !content.equals(that.content) : that.content != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TechnicalMetadataList{" +
               "content=" + Arrays.deepToString(content.toArray()) +
               '}';
    }
}
