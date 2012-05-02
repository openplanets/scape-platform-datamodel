package eu.scapeproject.model.metadata.textmd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import eu.scapeproject.model.metadata.TechnicalMetadata;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "encoding",
        "characterInfo",
        "language",
        "altLanguage",
        "fontScript",
        "markupBasis",
        "markupLanguage",
        "processingNote",
        "printRequirements",
        "viewingRequirements",
        "textNote"
})
@XmlRootElement(name = "textMD")
public class TextMDMetadata extends TechnicalMetadata {

    protected List<TextMDMetadata.Encoding> encoding;
    @XmlElement(name = "character_info")
    protected List<TextMDMetadata.CharacterInfo> characterInfo;
    protected List<String> language;
    @XmlElement(name = "alt_language")
    protected List<TextMDMetadata.AltLanguage> altLanguage;
    @XmlElement(name = "font_script")
    protected List<String> fontScript;
    @XmlElement(name = "markup_basis")
    protected List<TextMDMetadata.MarkupBasis> markupBasis;
    @XmlElement(name = "markup_language")
    protected List<TextMDMetadata.MarkupLanguage> markupLanguage;
    protected List<String> processingNote;
    protected List<String> printRequirements;
    protected List<String> viewingRequirements;
    protected List<String> textNote;

    public TextMDMetadata() {
        super(TechnicalMetadata.MetadataType.TEXTMD);
    }

    private TextMDMetadata(Builder builder) {
        this();
        this.encoding = builder.encoding;
        this.characterInfo = builder.characterInfo;
        this.language = builder.language;
        this.altLanguage = builder.altLanguage;
        this.fontScript = builder.fontScript;
        this.markupBasis = builder.markupBasis;
        this.markupLanguage = builder.markupLanguage;
        this.processingNote = builder.processingNote;
        this.printRequirements = builder.printRequirements;
        this.viewingRequirements = builder.viewingRequirements;
        this.textNote = builder.textNote;
    }

    /**
     * Gets the value of the altLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the altLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAltLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMDMetadata.AltLanguage }
     * 
     * 
     */
    public List<TextMDMetadata.AltLanguage> getAltLanguage() {
        if (altLanguage == null) {
            altLanguage = new ArrayList<TextMDMetadata.AltLanguage>();
        }
        return this.altLanguage;
    }

    /**
     * Gets the value of the characterInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characterInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacterInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMDMetadata.CharacterInfo }
     * 
     * 
     */
    public List<TextMDMetadata.CharacterInfo> getCharacterInfo() {
        if (characterInfo == null) {
            characterInfo = new ArrayList<TextMDMetadata.CharacterInfo>();
        }
        return this.characterInfo;
    }

    /**
     * Gets the value of the encoding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the encoding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEncoding().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMDMetadata.Encoding }
     * 
     * 
     */
    public List<TextMDMetadata.Encoding> getEncoding() {
        if (encoding == null) {
            encoding = new ArrayList<TextMDMetadata.Encoding>();
        }
        return this.encoding;
    }

    /**
     * Gets the value of the fontScript property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fontScript property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFontScript().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFontScript() {
        if (fontScript == null) {
            fontScript = new ArrayList<String>();
        }
        return this.fontScript;
    }

    /**
     * Gets the value of the language property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the language property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLanguage() {
        if (language == null) {
            language = new ArrayList<String>();
        }
        return this.language;
    }

    /**
     * Gets the value of the markupBasis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markupBasis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkupBasis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMDMetadata.MarkupBasis }
     * 
     * 
     */
    public List<TextMDMetadata.MarkupBasis> getMarkupBasis() {
        if (markupBasis == null) {
            markupBasis = new ArrayList<TextMDMetadata.MarkupBasis>();
        }
        return this.markupBasis;
    }

    /**
     * Gets the value of the markupLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markupLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkupLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextMDMetadata.MarkupLanguage }
     * 
     * 
     */
    public List<TextMDMetadata.MarkupLanguage> getMarkupLanguage() {
        if (markupLanguage == null) {
            markupLanguage = new ArrayList<TextMDMetadata.MarkupLanguage>();
        }
        return this.markupLanguage;
    }

    /**
     * Gets the value of the printRequirements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the printRequirements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrintRequirements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPrintRequirements() {
        if (printRequirements == null) {
            printRequirements = new ArrayList<String>();
        }
        return this.printRequirements;
    }

    /**
     * Gets the value of the processingNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processingNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessingNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProcessingNote() {
        if (processingNote == null) {
            processingNote = new ArrayList<String>();
        }
        return this.processingNote;
    }

    /**
     * Gets the value of the textNote property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textNote property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTextNote() {
        if (textNote == null) {
            textNote = new ArrayList<String>();
        }
        return this.textNote;
    }

    /**
     * Gets the value of the viewingRequirements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewingRequirements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewingRequirements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getViewingRequirements() {
        if (viewingRequirements == null) {
            viewingRequirements = new ArrayList<String>();
        }
        return this.viewingRequirements;
    }

    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="authority" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class AltLanguage {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "authority")
        protected String authority;

        /**
         * Gets the value of the authority property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAuthority() {
            return authority;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the authority property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAuthority(String value) {
            this.authority = value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }

    public static class Builder {
        private List<TextMDMetadata.Encoding> encoding;
        private List<TextMDMetadata.CharacterInfo> characterInfo;
        private List<String> language;
        private List<TextMDMetadata.AltLanguage> altLanguage;
        private List<String> fontScript;
        private List<TextMDMetadata.MarkupBasis> markupBasis;
        private List<TextMDMetadata.MarkupLanguage> markupLanguage;
        private List<String> processingNote;
        private List<String> printRequirements;
        private List<String> viewingRequirements;
        private List<String> textNote;

        public Builder altLanguage(List<TextMDMetadata.AltLanguage> altLanguage) {
            this.altLanguage = altLanguage;
            return this;
        }

        public TextMDMetadata build() {
            return new TextMDMetadata(this);
        }

        public Builder characterInfo(List<TextMDMetadata.CharacterInfo> characterInfo) {
            this.characterInfo = characterInfo;
            return this;
        }

        public Builder encoding(List<TextMDMetadata.Encoding> encoding) {
            this.encoding = encoding;
            return this;
        }

        public Builder fontScript(List<String> fontScript) {
            this.fontScript = fontScript;
            return this;
        }

        public Builder language(List<String> language) {
            this.language = language;
            return this;
        }

        public Builder markupBasis(List<TextMDMetadata.MarkupBasis> markupBasis) {
            this.markupBasis = markupBasis;
            return this;
        }

        public Builder markupLanguage(List<TextMDMetadata.MarkupLanguage> markupLanguage) {
            this.markupLanguage = markupLanguage;
            return this;
        }

        public Builder printRequirements(List<String> printRequirements) {
            this.printRequirements = printRequirements;
            return this;
        }

        public Builder processingNote(List<String> processingNote) {
            this.processingNote = processingNote;
            return this;
        }

        public Builder textNote(List<String> textNote) {
            this.textNote = textNote;
            return this;
        }

        public Builder viewingRequirements(List<String> viewingRequirements) {
            this.viewingRequirements = viewingRequirements;
            return this;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "charset",
            "byteOrder",
            "byteSize",
            "characterSize",
            "linebreak"
    })
    public static class CharacterInfo {

        protected String charset;
        @XmlElement(name = "byte_order", required = true)
        protected String byteOrder;
        @XmlElement(name = "byte_size", required = true)
        protected TextMDMetadata.CharacterInfo.ByteSize byteSize;
        @XmlElement(name = "character_size", required = true)
        protected TextMDMetadata.CharacterInfo.CharacterSize characterSize;
        @XmlElement(required = true)
        protected String linebreak;

        /**
         * Gets the value of the byteOrder property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getByteOrder() {
            return byteOrder;
        }

        /**
         * Gets the value of the byteSize property.
         * 
         * @return
         *     possible object is
         *     {@link TextMDMetadata.CharacterInfo.ByteSize }
         *     
         */
        public TextMDMetadata.CharacterInfo.ByteSize getByteSize() {
            return byteSize;
        }

        /**
         * Gets the value of the characterSize property.
         * 
         * @return
         *     possible object is
         *     {@link TextMDMetadata.CharacterInfo.CharacterSize }
         *     
         */
        public TextMDMetadata.CharacterInfo.CharacterSize getCharacterSize() {
            return characterSize;
        }

        /**
         * Gets the value of the charset property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCharset() {
            return charset;
        }

        /**
         * Gets the value of the linebreak property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLinebreak() {
            return linebreak;
        }

        /**
         * Sets the value of the byteOrder property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setByteOrder(String value) {
            this.byteOrder = value;
        }

        /**
         * Sets the value of the byteSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link TextMDMetadata.CharacterInfo.ByteSize }
         *     
         */
        public void setByteSize(TextMDMetadata.CharacterInfo.ByteSize value) {
            this.byteSize = value;
        }

        /**
         * Sets the value of the characterSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link TextMDMetadata.CharacterInfo.CharacterSize }
         *     
         */
        public void setCharacterSize(TextMDMetadata.CharacterInfo.CharacterSize value) {
            this.characterSize = value;
        }

        /**
         * Sets the value of the charset property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCharset(String value) {
            this.charset = value;
        }

        /**
         * Sets the value of the linebreak property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLinebreak(String value) {
            this.linebreak = value;
        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>integer">
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class ByteSize {

            @XmlValue
            protected BigInteger value;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setValue(BigInteger value) {
                this.value = value;
            }

        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="encoding" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class CharacterSize {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "encoding")
            protected String encoding;

            /**
             * Gets the value of the encoding property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEncoding() {
                return encoding;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the encoding property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEncoding(String value) {
                this.encoding = value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "encodingPlatform",
            "encodingSoftware",
            "encodingAgent"
    })
    public static class Encoding {

        @XmlElement(name = "encoding_platform")
        protected List<TextMDMetadata.Encoding.EncodingPlatform> encodingPlatform;
        @XmlElement(name = "encoding_software")
        protected List<TextMDMetadata.Encoding.EncodingSoftware> encodingSoftware;
        @XmlElement(name = "encoding_agent")
        protected List<TextMDMetadata.Encoding.EncodingAgent> encodingAgent;
        @XmlAttribute(name = "QUALITY")
        protected String quality;

        /**
         * Gets the value of the encodingAgent property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the encodingAgent property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEncodingAgent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextMDMetadata.Encoding.EncodingAgent }
         * 
         * 
         */
        public List<TextMDMetadata.Encoding.EncodingAgent> getEncodingAgent() {
            if (encodingAgent == null) {
                encodingAgent = new ArrayList<TextMDMetadata.Encoding.EncodingAgent>();
            }
            return this.encodingAgent;
        }

        /**
         * Gets the value of the encodingPlatform property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the encodingPlatform property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEncodingPlatform().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextMDMetadata.Encoding.EncodingPlatform }
         * 
         * 
         */
        public List<TextMDMetadata.Encoding.EncodingPlatform> getEncodingPlatform() {
            if (encodingPlatform == null) {
                encodingPlatform = new ArrayList<TextMDMetadata.Encoding.EncodingPlatform>();
            }
            return this.encodingPlatform;
        }

        /**
         * Gets the value of the encodingSoftware property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the encodingSoftware property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEncodingSoftware().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TextMDMetadata.Encoding.EncodingSoftware }
         * 
         * 
         */
        public List<TextMDMetadata.Encoding.EncodingSoftware> getEncodingSoftware() {
            if (encodingSoftware == null) {
                encodingSoftware = new ArrayList<TextMDMetadata.Encoding.EncodingSoftware>();
            }
            return this.encodingSoftware;
        }

        /**
         * Gets the value of the quality property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getQUALITY() {
            return quality;
        }

        /**
         * Sets the value of the quality property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setQUALITY(String value) {
            this.quality = value;
        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="role" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="OCR"/>
         *             &lt;enumeration value="TRANSCRIBER"/>
         *             &lt;enumeration value="MARKUP"/>
         *             &lt;enumeration value="EDITOR"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class EncodingAgent {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "role", required = true)
            protected String role;

            /**
             * Gets the value of the role property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRole() {
                return role;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the role property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRole(String value) {
                this.role = value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="linebreak">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;enumeration value="CR"/>
         *             &lt;enumeration value="CR/LF"/>
         *             &lt;enumeration value="LF"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class EncodingPlatform {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "linebreak")
            protected String linebreak;

            /**
             * Gets the value of the linebreak property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLinebreak() {
                return linebreak;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the linebreak property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLinebreak(String value) {
                this.linebreak = value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "value"
        })
        public static class EncodingSoftware {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "version")
            protected String version;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Gets the value of the version property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVersion() {
                return version;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Sets the value of the version property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVersion(String value) {
                this.version = value;
            }

        }

    }

    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class MarkupBasis {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "version")
        protected String version;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }

    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class MarkupLanguage {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "version")
        protected String version;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Gets the value of the version property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Sets the value of the version property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }
}
