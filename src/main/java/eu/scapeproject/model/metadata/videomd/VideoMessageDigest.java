package eu.scapeproject.model.metadata.videomd;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="messagedigest",namespace="http://www.loc.gov/videoMD/")
public class VideoMessageDigest {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/videoMD/")
    private final String id;
    @XmlElement(name="messagedigestdatetime",namespace="http://www.loc.gov/videoMD/")
    private final Date messageDigestDateTime;
    @XmlElement(name="messagedigestalgorithm",namespace="http://www.loc.gov/videoMD/")
    private final String messageDigestAlgorithm;
    @XmlElement(name="messagedigest",namespace="http://www.loc.gov/videoMD/")
    private final String messageDigest;

    private VideoMessageDigest() {
        super();
        this.id=null;
        this.messageDigestDateTime=null;
        this.messageDigestAlgorithm=null;
        this.messageDigest=null;
    }

    private VideoMessageDigest(Builder builder) {
        this.id = builder.id;
        this.messageDigestDateTime = builder.messageDigestDateTime;
        this.messageDigestAlgorithm = builder.messageDigestAlgorithm;
        this.messageDigest = builder.messageDigest;
    }

    public String getId() {
        return id;
    }

    public String getMessageDigest() {
        return messageDigest;
    }

    public String getMessageDigestAlgorithm() {
        return messageDigestAlgorithm;
    }

    public Date getMessageDigestDateTime() {
        return messageDigestDateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((messageDigest == null) ? 0 : messageDigest.hashCode());
        result = prime * result + ((messageDigestAlgorithm == null) ? 0 : messageDigestAlgorithm.hashCode());
        result = prime * result + ((messageDigestDateTime == null) ? 0 : messageDigestDateTime.hashCode());
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
        VideoMessageDigest other = (VideoMessageDigest) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (messageDigest == null) {
            if (other.messageDigest != null)
                return false;
        } else if (!messageDigest.equals(other.messageDigest))
            return false;
        if (messageDigestAlgorithm == null) {
            if (other.messageDigestAlgorithm != null)
                return false;
        } else if (!messageDigestAlgorithm.equals(other.messageDigestAlgorithm))
            return false;
        if (messageDigestDateTime == null) {
            if (other.messageDigestDateTime != null)
                return false;
        } else if (!messageDigestDateTime.equals(other.messageDigestDateTime))
            return false;
        return true;
    }

    public static class Builder {
        private String id;
        private Date messageDigestDateTime;
        private String messageDigestAlgorithm;
        private String messageDigest;

        public VideoMessageDigest build() {
            return new VideoMessageDigest(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder messageDigest(String messageDigest) {
            this.messageDigest = messageDigest;
            return this;
        }

        public Builder messageDigestAlgorithm(String messageDigestAlgorithm) {
            this.messageDigestAlgorithm = messageDigestAlgorithm;
            return this;
        }

        public Builder messageDigestDateTime(Date messageDigestDateTime) {
            this.messageDigestDateTime = messageDigestDateTime;
            return this;
        }
    }
}
