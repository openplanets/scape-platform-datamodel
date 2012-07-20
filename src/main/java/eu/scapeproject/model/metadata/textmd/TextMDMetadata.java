package eu.scapeproject.model.metadata.textmd;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ListUI;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.TechnicalMetadata;
import eu.scapeproject.model.util.ListUtil;

@XmlRootElement(name = "textMD", namespace = "info:lc/xmlns/textmd-v3")
public class TextMDMetadata extends TechnicalMetadata {
	@XmlElement(name = "encoding", namespace = "info:lc/xmlns/textmd-v3")
	private List<Encoding> encodings;
	@XmlElement(name = "character_info", namespace = "info:lc/xmlns/textmd-v3")
	private List<CharacterInfo> characterInfos;
	@XmlElement(name = "language", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> languages;
	@XmlElement(name = "alt_language", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> altLanguages;
	@XmlElement(name = "font_script", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> fontScripts;
	@XmlElement(name = "markup_basis", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> markupBases;
	@XmlElement(name = "markup_language", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> markupLanguages;
	@XmlElement(name = "processingNote", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> processingNotes;
	@XmlElement(name = "printRequirements", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> printRequirements;
	@XmlElement(name = "viewingRequirements", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> viewingRequirements;
	@XmlElement(name = "textNote", namespace = "info:lc/xmlns/textmd-v3")
	private List<String> textNotes;

	private TextMDMetadata() {
		super(MetadataType.TEXTMD);
	}

	private TextMDMetadata(Builder builder) {
		this();
		this.encodings = builder.encodings;
		this.characterInfos = builder.characterInfos;
		this.languages = builder.languages;
		this.altLanguages = builder.altLanguages;
		this.fontScripts = builder.fontScripts;
		this.markupBases = builder.markupBases;
		this.markupLanguages = builder.markupLanguages;
		this.processingNotes = builder.processingNotes;
		this.printRequirements = builder.printRequirements;
		this.viewingRequirements = builder.viewingRequirements;
		this.textNotes = builder.textNotes;
	}

	public List<String> getAltLanguages() {
		return altLanguages;
	}

	public List<CharacterInfo> getCharacterInfos() {
		return characterInfos;
	}

	public List<Encoding> getEncodings() {
		return encodings;
	}

	public List<String> getFontScripts() {
		return fontScripts;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public List<String> getMarkupBases() {
		return markupBases;
	}

	public List<String> getMarkupLanguages() {
		return markupLanguages;
	}

	public List<String> getPrintRequirements() {
		return printRequirements;
	}

	public List<String> getProcessingNotes() {
		return processingNotes;
	}

	public List<String> getTextNotes() {
		return textNotes;
	}

	public List<String> getViewingRequirements() {
		return viewingRequirements;
	}

	public static class Builder {
		private List<Encoding> encodings;
		private List<CharacterInfo> characterInfos;
		private List<String> languages;
		private List<String> altLanguages;
		private List<String> fontScripts;
		private List<String> markupBases;
		private List<String> markupLanguages;
		private List<String> processingNotes;
		private List<String> printRequirements;
		private List<String> viewingRequirements;
		private List<String> textNotes;

		public Builder() {
			super();
		}

		public Builder(TextMDMetadata orig) {
			// TODO: deep copy for encodings
			this.encodings = orig.encodings;
			this.characterInfos = orig.characterInfos;

			this.languages = ListUtil.copyList(orig.languages);
			this.altLanguages = ListUtil.copyList(orig.altLanguages);
			this.fontScripts = ListUtil.copyList(orig.fontScripts);
			this.markupBases = ListUtil.copyList(orig.markupBases);
			this.markupLanguages = ListUtil.copyList(orig.markupLanguages);
			this.processingNotes = ListUtil.copyList(orig.processingNotes);
			this.printRequirements = ListUtil.copyList(orig.printRequirements);
			this.viewingRequirements = ListUtil.copyList(orig.viewingRequirements);
			this.textNotes = ListUtil.copyList(orig.textNotes);
		}

		public Builder altLanguages(List<String> altLanguages) {
			this.altLanguages = altLanguages;
			return this;
		}

		public TextMDMetadata build() {
			return new TextMDMetadata(this);
		}

		public Builder characterInfos(List<CharacterInfo> characterInfos) {
			this.characterInfos = characterInfos;
			return this;
		}

		public Builder encodings(List<Encoding> encodings) {
			this.encodings = encodings;
			return this;
		}

		public Builder fontScripts(List<String> fontScripts) {
			this.fontScripts = fontScripts;
			return this;
		}

		public Builder languages(List<String> languages) {
			this.languages = languages;
			return this;
		}

		public Builder markupBases(List<String> markupBases) {
			this.markupBases = markupBases;
			return this;
		}

		public Builder markupLanguages(List<String> markupLanguages) {
			this.markupLanguages = markupLanguages;
			return this;
		}

		public Builder printRequirements(List<String> printRequirements) {
			this.printRequirements = printRequirements;
			return this;
		}

		public Builder processingNotes(List<String> processingNotes) {
			this.processingNotes = processingNotes;
			return this;
		}

		public Builder textNotes(List<String> textNotes) {
			this.textNotes = textNotes;
			return this;
		}

		public Builder viewingRequirements(List<String> viewingRequirements) {
			this.viewingRequirements = viewingRequirements;
			return this;
		}
	}

	@XmlRootElement(name = "character_info", namespace = "info:lc/xmlns/textmd-v3")
	public static class CharacterInfo {
		@XmlElement(name = "charset", namespace = "info:lc/xmlns/textmd-v3")
		private Charset charSet;
		@XmlElement(name = "byte_order", namespace = "info:lc/xmlns/textmd-v3")
		private ByteOrder byteOrder;
		@XmlElement(name = "byte_size", namespace = "info:lc/xmlns/textmd-v3")
		private int byteSize;
		@XmlElement(name = "character_size", namespace = "info:lc/xmlns/textmd-v3")
		private String characterSize;
		@XmlElement(name = "line_break", namespace = "info:lc/xmlns/textmd-v3")
		private LineBreak lineBreak;

		private CharacterInfo() {
			super();
		}

		private CharacterInfo(Builder b) {
			this.byteOrder = b.byteOrder;
			this.byteSize = b.byteSize;
			this.characterSize = b.characterSize;
			this.charSet = b.charSet;
			this.lineBreak = b.lineBreak;
		}

		public ByteOrder getByteOrder() {
			return byteOrder;
		}

		public int getByteSize() {
			return byteSize;
		}

		public String getCharacterSize() {
			return characterSize;
		}

		public Charset getCharSet() {
			return charSet;
		}

		public LineBreak getLineBreak() {
			return lineBreak;
		}

		public static class Builder {
			private Charset charSet;
			private ByteOrder byteOrder;
			private int byteSize;
			private String characterSize;
			private LineBreak lineBreak;

			public CharacterInfo build() {
				return new CharacterInfo(this);
			}

			public Builder byteOrder(ByteOrder order) {
				this.byteOrder = order;
				return this;
			}

			public Builder byteSize(int size) {
				this.byteSize = size;
				return this;
			}

			public Builder characterSize(String characterSize) {
				this.characterSize = characterSize;
				return this;
			}

			public Builder charset(Charset charset) {
				this.charSet = charset;
				return this;
			}

			public Builder lineBreak(LineBreak lineBreak) {
				this.lineBreak = lineBreak;
				return this;
			}
		}

		public enum ByteOrder {
			LITTLE_ENDIAN, BIG_ENDIAN, MIDDLE_ENDIAN;
		}

		public enum Charset {
			ANSI_X3_4_1968, ISO_10646_UTF_1, ISO_646_BASIC_1983, INVARIANT, ISO_646_IRV_1983, BS_4730, NATS_SEFI, NATS_SEFI_ADD, NATS_DANO, NATS_DANO_ADD, SEN_850200_B, SEN_850200_C, KS_C_5601_1987, ISO_2022_KR, EUC_KR, ISO_2022_JP, ISO_2022_JP_2, ISO_2022_CN, ISO_2022_CN_EXT, JIS_C6220_1969_JP, JIS_C6220_1969_RO, IT, PT, ES, GREEK7_OLD, LATIN_GREEK, DIN_66003, NF_Z_62_010_1973, LATIN_GREEK_1, ISO_5427, JIS_C6226_1978, BS_VIEWDATA, INIS, INIS_8, INIS_CYRILLIC, ISO_5427_1981, ISO_5428_1980, GB_1988_80, GB_2312_80, NS_4551_1, NS_4551_2, NF_Z_62_010, VIDEOTEX_SUPPL, PT2, ES2, MSZ_7795_3, JIS_C6226_1983, GREEK7, ASMO_449, ISO_IR_90, JIS_C6229_1984_A, JIS_C6229_1984_B, JIS_C6229_1984_B_ADD, JIS_C6229_1984_HAND, JIS_C6229_1984_HAND_ADD, JIS_C6229_1984_KANA, ISO_2033_1983, ANSI_X3_110_1983, ISO_8859_1_1987, ISO_8859_2_1987, ISO_8859_3_1988, ISO_8859_4_1988, T_61_7BIT, ECMA_CYRILLIC, CSA_Z243_4_1985_1, CSA_Z243_4_1985_2, CSA_Z243_4_1985_GR, ISO_8859_6_1987, ISO_8859_6_E, ISO_8859_6_I, ISO_8859_7_1987, T_101_G2, ISO_8859_8_1988, ISO_8859_8_E, ISO_8859_8_I, CSN_369103, JUS_I_B1_002, ISO_6937_2_ADD, IEC_P27_1, ISO_8859_5_1988, JUS_I_B1_003_SERB, JUS_I_B1_003_MAC, ISO_8859_9_1989, GREEK_CCITT, NC_NC00_10_81, ISO_6937_2_25, GOST_19768_74, ISO_8859_SUPP, ISO_10367_BOX, ISO_8859_10, LATIN_LAP, JIS_X0212_1990, DS_2089, US_DK, DK_US, JIS_X0201, KSC5636, ISO_10646_UCS_2, ISO_10646_UCS_4, DEC_MCS, HP_ROMAN8, MACINTOSH, IBM037, IBM038, IBM273, IBM274, IBM275, IBM277, IBM278, IBM280, IBM281, IBM284, IBM285, IBM290, IBM297, IBM420, IBM423, IBM424, IBM437, IBM500, IBM775, IBM850, IBM851, IBM852, IBM855, IBM857, IBM860, IBM861, IBM862, IBM863, IBM864, IBM865, IBM866, IBM869, IBM870, IBM871, IBM880, IBM891, IBM903, IBM904, IBM905, IBM918, IBM1026, EBCDIC_AT_DE, EBCDIC_AT_DE_A, EBCDIC_CA_FR, EBCDIC_DK_NO, EBCDIC_DK_NO_A, EBCDIC_FI_SE, EBCDIC_FI_SE_A, EBCDIC_FR, EBCDIC_IT, EBCDIC_PT, EBCDIC_ES, EBCDIC_ES_A, EBCDIC_ES_S, EBCDIC_UK, EBCDIC_US, UNKNOWN_8BIT, MNEMONIC, MNEM, VISCII, VIQR, KOI8_R, KOI8_U, IBM00858, IBM00924, IBM01140, IBM01141, IBM01142, IBM01143, IBM01144, IBM01145, IBM01146, IBM01147, IBM01148, IBM01149, BIG5_HKSCS, UNICODE_1_1, SCSU, UTF_7, UTF_16BE, UTF_16LE, UTF_16, CESU_8, UTF_32, UTF_32BE, UTF_32LE, UNICODE_1_1_UTF_7, UTF_8, ISO_8859_13, ISO_8859_14, ISO_8859_15, ISO_8859_16, JIS_ENCODING, SHIFT_JIS, EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE, EXTENDED_UNIX_CODE_FIXED_WIDTH_FOR_JAPANESE, ISO_10646_UCS_BASIC, ISO_10646_UNICODE_LATIN1, ISO_10646_J_1, ISO_UNICODE_IBM_1268, ISO_UNICODE_IBM_1276, ISO_UNICODE_IBM_1264, ISO_UNICODE_IBM_1265, ISO_8859_1_WINDOWS_3_0_LATIN_1, ISO_8859_1_WINDOWS_3_1_LATIN_1, ISO_8859_2_WINDOWS_LATIN_2, ISO_8859_9_WINDOWS_LATIN_5, ADOBE_STANDARD_ENCODING, VENTURA_US, VENTURA_INTERNATIONAL, PC8_DANISH_NORWEGIAN, PC8_TURKISH, IBM_SYMBOLS, IBM_THAI, HP_LEGAL, HP_PI_FONT, HP_MATH8, ADOBE_SYMBOL_ENCODING, HP_DESKTOP, VENTURA_MATH, MICROSOFT_PUBLISHING, WINDOWS_31J, GB2312, BIG5, WINDOWS_1250, WINDOWS_1251, WINDOWS_1252, WINDOWS_1253, WINDOWS_1254, WINDOWS_1255, WINDOWS_1256, WINDOWS_1257, WINDOWS_1258, TIS_620, HZ_GB_2312;
		}

	}

	@XmlRootElement(name = "encoding", namespace = "info:lc/xmlns/textmd-v3")
	public static class Encoding {
		@XmlElement(name = "encoding_platform", namespace = "info:lc/xmlns/textmd-v3")
		private EncodingPlatform platform;
		@XmlElement(name = "encoding_software", namespace = "info:lc/xmlns/textmd-v3")
		private List<String> software;
		@XmlElement(name = "encoding_agent", namespace = "info:lc/xmlns/textmd-v3")
		private EncodingAgent agent;

		@SuppressWarnings("unused")
		private Encoding() {
			super();
		}

		public Encoding(EncodingPlatform platform, List<String> software, EncodingAgent agent) {
			super();
			this.platform = platform;
			this.software = software;
			this.agent = agent;
		}

		public EncodingAgent getAgent() {
			return agent;
		}

		public EncodingPlatform getPlatform() {
			return platform;
		}

		public List<String> getSoftware() {
			return software;
		}

		@XmlRootElement(name = "encoding_agent", namespace = "info:lc/xmlns/textmd-v3")
		public static class EncodingAgent {
			@XmlElement(name = "role", namespace = "info:lc/xmlns/textmd-v3")
			private Role role;

			@SuppressWarnings("unused")
			private EncodingAgent() {
				super();
			}

			public EncodingAgent(Role role) {
				this.role = role;
			}

			public Role getRole() {
				return role;
			}

			public enum Role {
				OCR, TRANSCRIBER, MARKUP, EDITOR;
			}
		}

		@XmlRootElement(name = "encoding_platform")
		public static class EncodingPlatform {
			@XmlElement(name = "line_break", namespace = "info:lc/xmlns/textmd-v3")
			private LineBreak lineBreak;

			@SuppressWarnings("unused")
			private EncodingPlatform() {
				super();
			}

			public EncodingPlatform(LineBreak lineBreak) {
				this.lineBreak = lineBreak;
			}

			public LineBreak getLineBreak() {
				return lineBreak;
			}
		}
	}

	@XmlEnum
	public enum LineBreak {
		CR, LF, CR_LF;
	}
}
