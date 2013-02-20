package eu.scapeproject.model.metadata.gbs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlRootElement(name = "google-bookscan", namespace = "http://books.google.com/gbs")
public class GoogleBookScanMetadata extends TechnicalMetadata {

    @XmlElement(name="productionNotes", namespace = "http://books.google.com/gbs")
    private final ProductionNotes productionNotes;
    @XmlElement(name="imageMethod", namespace = "http://books.google.com/gbs")
    private final ImageMethod imageMethod;
    @XmlElement(name="focusParameter", namespace = "http://books.google.com/gbs")
    private final FocusParameter focusParameter;
    @XmlElement(name="pageTag", namespace = "http://books.google.com/gbs")
    private final String pageTag;
    @XmlElement(name="pageOrder", namespace = "http://books.google.com/gbs")
    private final String pageOrder;
    @XmlElement(name="pageSequence", namespace = "http://books.google.com/gbs")
    private final String pageSequence;
    @XmlElement(name="coverTag", namespace = "http://books.google.com/gbs")
    private final String coverTag;
    @XmlElement(name="sourceLibrary", namespace = "http://books.google.com/gbs")
    private final String sourceLibrary;
    @XmlElement(name="sourceIdentifier", namespace = "http://books.google.com/gbs")
    private final String sourceIdentifier;

    private GoogleBookScanMetadata(Builder b) {
        super(MetadataType.GOOGLE_BOOK_SCAN);
        this.productionNotes = b.productionNotes;
        this.imageMethod = b.imageMethod;
        this.focusParameter = b.focusParameter;
        this.pageTag = b.pageTag;
        this.pageOrder = b.pageOrder;
        this.pageSequence = b.pageSequence;
        this.coverTag = b.coverTag;
        this.sourceIdentifier = b.sourceIdentifier;
        this.sourceLibrary = b.sourceLibrary;
    }

    private GoogleBookScanMetadata() {
        super(MetadataType.GOOGLE_BOOK_SCAN);
        this.productionNotes = null;
        this.imageMethod = null;
        this.focusParameter = null;
        this.pageOrder = null;
        this.pageTag = null;
        this.pageSequence = null;
        this.coverTag = null;
        this.sourceLibrary = null;
        this.sourceIdentifier = null;
    }

    public ProductionNotes getProductionNotes() {
        return productionNotes;
    }

    public ImageMethod getImageMethod() {
        return imageMethod;
    }

    public FocusParameter getFocusParameter() {
        return focusParameter;
    }

    public String getPageTag() {
        return pageTag;
    }

    public String getPageOrder() {
        return pageOrder;
    }

    public String getPageSequence() {
        return pageSequence;
    }

    public String getCoverTag() {
        return coverTag;
    }

    public String getSourceLibrary() {
        return sourceLibrary;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public static class Builder {
        private ProductionNotes productionNotes;
        private ImageMethod imageMethod;
        private FocusParameter focusParameter;
        private String pageTag;
        private String pageOrder;
        private String pageSequence;
        private String coverTag;
        private String sourceLibrary;
        private String sourceIdentifier;

        public Builder productionNotes(ProductionNotes productionNotes) {
            this.productionNotes = productionNotes;
            return this;
        }

        public Builder imageMethod(ImageMethod imageMethod) {
            this.imageMethod = imageMethod;
            return this;
        }

        public Builder focusParameter(FocusParameter focusParameter) {
            this.focusParameter = focusParameter;
            return this;
        }

        public Builder pageTag(String pageTag) {
            this.pageTag = pageTag;
            return this;
        }

        public Builder pageOrder(String pageOrder) {
            this.pageOrder = pageOrder;
            return this;
        }

        public Builder pageSequence(String pageSequence) {
            this.pageSequence = pageSequence;
            return this;
        }

        public Builder coverTag(String coverTag) {
            this.coverTag = coverTag;
            return this;
        }

        public Builder sourceIdentifier(String sourceIdentifier) {
            this.sourceIdentifier = sourceIdentifier;
            return this;
        }

        public Builder sourceLibrary(String sourceLibrary) {
            this.sourceLibrary = sourceLibrary;
            return this;
        }

        public GoogleBookScanMetadata build() {
            return new GoogleBookScanMetadata(this);
        }

    }

}
