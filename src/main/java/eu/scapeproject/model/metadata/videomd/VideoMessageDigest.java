package eu.scapeproject.model.metadata.videomd;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="messagedigest",namespace="http://www.loc.gov/videoMD/")
public class VideoMessageDigest {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name="messagedigestdatetime",namespace="http://www.loc.gov/videoMD/")
    private Date messageDigestDateTime;
    @XmlElement(name="messagedigestalgorithm",namespace="http://www.loc.gov/videoMD/")
    private String messageDigestAlgorithm;
    @XmlElement(name="messagedigest",namespace="http://www.loc.gov/videoMD/")
    private String messageDigest;

    private VideoMessageDigest() {
        super();
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
