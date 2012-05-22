package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="channelassignment",namespace="http://www.loc.gov/AMD/")
public class ChannelAssignment {
    @XmlElement(name="channelnum",namespace="http://www.loc.gov/AMD/")
    private int channelNum;
    @XmlElement(name="maplocation",namespace="http://www.loc.gov/AMD/")
    private String mapLocation;
    
    @SuppressWarnings("unused")
    private ChannelAssignment(){
        super();
    }
    
    public ChannelAssignment(int channelNum, String mapLocation) {
        super();
        this.channelNum = channelNum;
        this.mapLocation = mapLocation;
    }

    public int getChannelNum() {
        return channelNum;
    }

    public String getMapLocation() {
        return mapLocation;
    }
}
