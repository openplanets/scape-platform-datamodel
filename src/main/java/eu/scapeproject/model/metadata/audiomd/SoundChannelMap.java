package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "soundchannelmap", namespace = "http://www.loc.gov/AMD/")
public class SoundChannelMap {
    @XmlElement(name = "channelassignment", namespace = "http://www.loc.gov/AMD/")
    private final List<ChannelAssignment> channelAssignments;

    @SuppressWarnings("unused")
    private SoundChannelMap() {
        super();
        this.channelAssignments=null;
    }

    public SoundChannelMap(List<ChannelAssignment> channelAssignments) {
        super();
        this.channelAssignments = channelAssignments;
    }

    public List<ChannelAssignment> getChannelAssignments() {
        return channelAssignments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((channelAssignments == null) ? 0 : channelAssignments.hashCode());
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
        SoundChannelMap other = (SoundChannelMap) obj;
        if (channelAssignments == null) {
            if (other.channelAssignments != null)
                return false;
        } else if (!channelAssignments.equals(other.channelAssignments))
            return false;
        return true;
    }
    
}
