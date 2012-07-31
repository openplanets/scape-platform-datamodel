package eu.scapeproject.model.metadata.audiomd;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "channelassignment", namespace = "http://www.loc.gov/AMD/")
public class ChannelAssignment {
	@XmlElement(name = "channelnum", namespace = "http://www.loc.gov/AMD/")
	private final int channelNum;
	@XmlElement(name = "maplocation", namespace = "http://www.loc.gov/AMD/")
	private final String mapLocation;

	@SuppressWarnings("unused")
	private ChannelAssignment() {
		super();
		this.channelNum = 0;
		this.mapLocation = null;
	}

	public ChannelAssignment(int channelNum, String mapLocation) {
		super();
		this.channelNum = channelNum;
		this.mapLocation = mapLocation;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChannelAssignment other = (ChannelAssignment) obj;
		if (channelNum != other.channelNum)
			return false;
		if (mapLocation == null) {
			if (other.mapLocation != null)
				return false;
		} else if (!mapLocation.equals(other.mapLocation))
			return false;
		return true;
	}

	public int getChannelNum() {
		return channelNum;
	}

	public String getMapLocation() {
		return mapLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channelNum;
		result = prime * result + ((mapLocation == null) ? 0 : mapLocation.hashCode());
		return result;
	}

}
