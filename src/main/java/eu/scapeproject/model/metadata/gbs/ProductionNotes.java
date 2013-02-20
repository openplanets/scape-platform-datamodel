package eu.scapeproject.model.metadata.gbs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productionNotes", namespace = "http://books.google.com/gbs")
public class ProductionNotes {
    @XmlElement(name = "badPages")
    private final String badPages;
    @XmlElement(name = "missingPages")
    private final String missingPages;
    @XmlElement(name = "tightBoundPages")
    private final String tightBoundPages;

    private ProductionNotes(){
        this.badPages = null;
        this.missingPages = null;
        this.tightBoundPages = null;
    }
    
    private ProductionNotes(Builder b) {
        this.badPages = b.badPages;
        this.missingPages = b.missingPages;
        this.tightBoundPages = b.tightBoundPages;
    }

    public String getBadPages() {
        return badPages;
    }

    public String getMissingPages() {
        return missingPages;
    }

    public String getTightBoundPages() {
        return tightBoundPages;
    }

    public static class Builder {
        private String badPages;
        private String missingPages;
        private String tightBoundPages;

        public Builder badPages(String badPages) {
            this.badPages = badPages;
            return this;
        }

        public Builder tightBoundPages(String tightBoundPages) {
            this.tightBoundPages = tightBoundPages;
            return this;
        }

        public Builder missingPages(String missingPages) {
            this.missingPages = missingPages;
            return this;
        }
        
        public ProductionNotes build(){
            return new ProductionNotes(this);
        }
    }
}
