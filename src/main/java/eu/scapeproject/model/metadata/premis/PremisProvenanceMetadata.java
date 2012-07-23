package eu.scapeproject.model.metadata.premis;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import eu.scapeproject.model.metadata.ProvenanceMetadata;

@XmlRootElement(name = "digiprovMD", namespace = "http://www.loc.gov/standards/premis")
public class PremisProvenanceMetadata extends ProvenanceMetadata {
    @XmlElement(name = "event",namespace="http://www.loc.gov/standards/premis")
    private List<Event> events;

    public PremisProvenanceMetadata(Builder b){
    	super("premis");
    	this.events=b.events;
    }
    
    private PremisProvenanceMetadata() {
        super("premis");
    }

    public PremisProvenanceMetadata(List<Event> events) {
        super("premis");
        this.events = events;
    }

    public List<Event> getEvents() {
        return events;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((events == null) ? 0 : events.hashCode());
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
        PremisProvenanceMetadata other = (PremisProvenanceMetadata) obj;
        if (events == null) {
            if (other.events != null)
                return false;
        } else if (!events.equals(other.events))
            return false;
        return true;
    }

    public static class Builder{
    	private List<Event> events;
    	
    	public Builder(){
    		super();
    	}
    
    	public Builder(PremisProvenanceMetadata orig){
    		if (orig.events != null){
    			this.events = new ArrayList<Event>();
    			for (Event e:orig.events){
    				this.events.add(new Event.Builder(e).build());
    			}
    		}
    	}
    	
    	public Builder events(List<Event> events) {
    		this.events=events;
    		return this;
    	}
    	
    	public PremisProvenanceMetadata build() {
    		return new PremisProvenanceMetadata(this);
    	}
    }
}
