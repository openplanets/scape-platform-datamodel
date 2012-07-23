package eu.scapeproject.model.metadata.videomd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "frame", namespace = "http://www.loc.gov/videoMD/")
public class VideoFrame {
    @XmlAttribute(name = "id", namespace = "http://www.loc.gov/videoMD/")
    private String id;
    @XmlElement(name = "pixelshorizontal", namespace = "http://www.loc.gov/videoMD/")
    private int pixelsHorizontal;
    @XmlElement(name = "pixelsvertical", namespace = "http://www.loc.gov/videoMD/")
    private int pixelsVertical;
    @XmlElement(name = "framerate", namespace = "http://www.loc.gov/videoMD/")
    private float frameRate;
    @XmlElement(name = "par", namespace = "http://www.loc.gov/videoMD/")
    private float par;
    @XmlElement(name = "dar", namespace = "http://www.loc.gov/videoMD/")
    private String dar;
    @XmlElement(name = "rotation", namespace = "http://www.loc.gov/videoMD/")
    private float rotation;

    private VideoFrame() {
        super();
    }

    private VideoFrame(Builder builder) {
        this.id = builder.id;
        this.pixelsHorizontal = builder.pixelsHorizontal;
        this.pixelsVertical = builder.pixelsVertical;
        this.frameRate = builder.frameRate;
        this.par = builder.par;
        this.dar = builder.dar;
        this.rotation = builder.rotation;
    }

    public String getDar() {
        return dar;
    }

    public float getFrameRate() {
        return frameRate;
    }

    public String getId() {
        return id;
    }

    public float getPar() {
        return par;
    }

    public int getPixelsHorizontal() {
        return pixelsHorizontal;
    }

    public int getPixelsVertical() {
        return pixelsVertical;
    }

    public float getRotation() {
        return rotation;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dar == null) ? 0 : dar.hashCode());
        result = prime * result + Float.floatToIntBits(frameRate);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + Float.floatToIntBits(par);
        result = prime * result + pixelsHorizontal;
        result = prime * result + pixelsVertical;
        result = prime * result + Float.floatToIntBits(rotation);
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
        VideoFrame other = (VideoFrame) obj;
        if (dar == null) {
            if (other.dar != null)
                return false;
        } else if (!dar.equals(other.dar))
            return false;
        if (Float.floatToIntBits(frameRate) != Float.floatToIntBits(other.frameRate))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Float.floatToIntBits(par) != Float.floatToIntBits(other.par))
            return false;
        if (pixelsHorizontal != other.pixelsHorizontal)
            return false;
        if (pixelsVertical != other.pixelsVertical)
            return false;
        if (Float.floatToIntBits(rotation) != Float.floatToIntBits(other.rotation))
            return false;
        return true;
    }

    public static class Builder {
        private String id;
        private int pixelsHorizontal;
        private int pixelsVertical;
        private float frameRate;
        private float par;
        private String dar;
        private float rotation;

        public VideoFrame build() {
            return new VideoFrame(this);
        }

        public Builder dar(String dar) {
            this.dar = dar;
            return this;
        }

        public Builder frameRate(float frameRate) {
            this.frameRate = frameRate;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder par(float par) {
            this.par = par;
            return this;
        }

        public Builder pixelsHorizontal(int pixelsHorizontal) {
            this.pixelsHorizontal = pixelsHorizontal;
            return this;
        }

        public Builder pixelsVertical(int pixelsVertical) {
            this.pixelsVertical = pixelsVertical;
            return this;
        }

        public Builder rotation(float rotation) {
            this.rotation = rotation;
            return this;
        }
    }
}
