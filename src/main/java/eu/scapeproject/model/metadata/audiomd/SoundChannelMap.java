package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="soundchannelmap",namespace="http://www.loc.gov/AMD/")
public class SoundChannelMap {
    @XmlElement(name="channelassignment",namespace="http://www.loc.gov/AMD/")
    private List<ChannelAssignment> channelAssignments;

    private SoundChannelMap(){
        super();
    }
    
    public SoundChannelMap(List<ChannelAssignment> channelAssignments) {
        super();
        this.channelAssignments = channelAssignments;
    }

}
