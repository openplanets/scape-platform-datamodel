package eu.scapeproject.model.metadata.audiomd;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="messagedigest",namespace="http://www.loc.gov/AMD/")
public class MessageDigest {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="messagedigestdatetime",namespace="http://www.loc.gov/AMD/")
    private List<Date> messageDigestDateTimes;
    @XmlElement(name="messagedigestalgorithm",namespace="http://www.loc.gov/AMD/")
    private List<String> messageDigestAlgorithms;
    @XmlElement(name="messagedigest",namespace="http://www.loc.gov/AMD/")
    private List<String> messageDigests;

    private MessageDigest() {
        super();
    }

    private MessageDigest(Builder builder) {
        this.id = builder.id;
        this.messageDigestDateTimes = builder.messageDigestDateTimes;
        this.messageDigestAlgorithms = builder.messageDigestAlgorithms;
        this.messageDigests = builder.messageDigests;
    }

    public String getId() {
        return id;
    }

    public List<String> getMessageDigestAlgorithms() {
        return messageDigestAlgorithms;
    }

    public List<Date> getMessageDigestDateTimes() {
        return messageDigestDateTimes;
    }

    public List<String> getMessageDigests() {
        return messageDigests;
    }

    public static class Builder {
        private final String id;
        private List<Date> messageDigestDateTimes;
        private List<String> messageDigestAlgorithms;
        private List<String> messageDigests;

        public Builder(String id) {
            super();
            this.id = id;
        }

        public MessageDigest build() {
            return new MessageDigest(this);
        }

        public Builder messageDigestAlgorithms(List<String> messageDigestAlgorithms) {
            this.messageDigestAlgorithms = messageDigestAlgorithms;
            return this;
        }

        public Builder messageDigestDateTimes(List<Date> messageDigestDateTimes) {
            this.messageDigestDateTimes = messageDigestDateTimes;
            return this;
        }

        public Builder messageDigests(List<String> messageDigests) {
            this.messageDigests = messageDigests;
            return this;
        }
    }
}
