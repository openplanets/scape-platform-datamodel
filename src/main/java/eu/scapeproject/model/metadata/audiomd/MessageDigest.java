package eu.scapeproject.model.metadata.audiomd;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.jaxb.DateAdapter;

@XmlRootElement(name="messagedigest",namespace="http://www.loc.gov/AMD/")
public class MessageDigest {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="messagedigestdatetime",namespace="http://www.loc.gov/AMD/")
    @XmlJavaTypeAdapter(DateAdapter.class)
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((messageDigestAlgorithms == null) ? 0 : messageDigestAlgorithms.hashCode());
        result = prime * result + ((messageDigestDateTimes == null) ? 0 : messageDigestDateTimes.hashCode());
        result = prime * result + ((messageDigests == null) ? 0 : messageDigests.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MessageDigest other = (MessageDigest) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (messageDigestAlgorithms == null) {
            if (other.messageDigestAlgorithms != null)
                return false;
        } else if (!messageDigestAlgorithms.equals(other.messageDigestAlgorithms))
            return false;
        if (messageDigestDateTimes == null) {
            if (other.messageDigestDateTimes != null)
                return false;
        } else if (!messageDigestDateTimes.equals(other.messageDigestDateTimes))
            return false;
        if (messageDigests == null) {
            if (other.messageDigests != null)
                return false;
        } else if (!messageDigests.equals(other.messageDigests))
            return false;
        return true;
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
