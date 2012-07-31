package eu.scapeproject.model.metadata.premis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import eu.scapeproject.model.Agent;
import eu.scapeproject.model.Identifier;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.jaxb.PremisEventIdentifierAdapter;

@XmlRootElement(name = "event", namespace = "info:lc/xmlns/premis-v2")
public class Event {
    @XmlElement(name = "eventIdentifier", namespace = "http://www.loc.gov/standards/premis")
    @XmlJavaTypeAdapter(PremisEventIdentifierAdapter.class)
    private final Identifier identifier;
    @XmlElement(name = "type", namespace = "http://www.loc.gov/standards/premis")
    private final String type;
    @XmlElement(name = "dateTime", namespace = "http://www.loc.gov/standards/premis")
    private final Date dateTime;
    @XmlElement(name = "detail", namespace = "http://www.loc.gov/standards/premis")
    private final String detail;
    @XmlElement(name = "outcome", namespace = "http://www.loc.gov/standards/premis")
    private final List<Outcome> outcome;
    @XmlElement(name = "linkingAgent", namespace = "http://www.loc.gov/standards/premis")
    private final List<Agent> linkingAgents;
    @XmlElement(name = "linkingObject", namespace = "http://www.loc.gov/standards/premis")
    private final List<IntellectualEntity> linkingObjects;

    private Event() {
        super();
        this.identifier=null;
        this.type=null;
        this.dateTime=null;
        this.detail=null;
        this.outcome=null;
        this.linkingAgents=null;
        this.linkingObjects=null;
    }

    private Event(Builder builder) {
        this.identifier = builder.identifier;
        this.type = builder.type;
        this.dateTime = builder.dateTime;
        this.detail = builder.detail;
        this.outcome = builder.outcome;
        this.linkingAgents = builder.linkingAgents;
        this.linkingObjects = builder.linkingObjects;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (dateTime == null) {
            if (other.dateTime != null)
                return false;
        } else if (!dateTime.equals(other.dateTime))
            return false;
        if (detail == null) {
            if (other.detail != null)
                return false;
        } else if (!detail.equals(other.detail))
            return false;
        if (identifier == null) {
            if (other.identifier != null)
                return false;
        } else if (!identifier.equals(other.identifier))
            return false;
        if (linkingAgents == null) {
            if (other.linkingAgents != null)
                return false;
        } else if (!linkingAgents.equals(other.linkingAgents))
            return false;
        if (linkingObjects == null) {
            if (other.linkingObjects != null)
                return false;
        } else if (!linkingObjects.equals(other.linkingObjects))
            return false;
        if (outcome == null) {
            if (other.outcome != null)
                return false;
        } else if (!outcome.equals(other.outcome))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getDetail() {
        return detail;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public List<Agent> getLinkingAgents() {
        return linkingAgents;
    }

    public List<IntellectualEntity> getLinkingObjects() {
        return linkingObjects;
    }

    public List<Outcome> getOutcome() {
        return outcome;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
        result = prime * result + ((detail == null) ? 0 : detail.hashCode());
        result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
        result = prime * result + ((linkingAgents == null) ? 0 : linkingAgents.hashCode());
        result = prime * result + ((linkingObjects == null) ? 0 : linkingObjects.hashCode());
        result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    public static class Builder {
        private Identifier identifier;
        private String type;
        private Date dateTime;
        private String detail;
        private List<Outcome> outcome;
        private List<Agent> linkingAgents;
        private List<IntellectualEntity> linkingObjects;
        
        public Builder(){
        	super();
        }
        
        public Builder(Event ev){
        	this.identifier = new Identifier(new String(ev.identifier.getType()),new String(ev.getIdentifier().getValue())) {};
        	this.type = new String(ev.type);
        	this.dateTime = new Date(ev.getDateTime().getTime());
        	this.detail = new String(ev.detail);
        	if (ev.outcome != null){
        		this.outcome = new ArrayList<Event.Outcome>();
        		for (Outcome oc:ev.outcome){
        			Detail[] details=new Detail[oc.getDetails().size()];
        			for (int i=0;i<oc.getDetails().size();i++){
        				Detail d=oc.getDetails().get(i);
        				details[i] = new Detail(new String(d.note), new String(d.extension));
        			}
        			this.outcome.add(new Outcome(new String(oc.outcome),details));
        		}
        	}
        	if (ev.linkingAgents != null){
        		this.linkingAgents = new ArrayList<Agent>();
        		for (Agent la:ev.linkingAgents){
        			this.linkingAgents.add(new Agent.Builder(la).build());
        		}
        	}
        	if (ev.linkingObjects != null){
        		this.linkingObjects = new ArrayList<IntellectualEntity>();
        		for (IntellectualEntity lo:ev.linkingObjects){
        			this.linkingObjects.add(new IntellectualEntity.Builder(lo).build());
        		}
        	}
        }

        public Event build() {
            return new Event(this);
        }

        public Builder dateTime(Date dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder identifier(Identifier identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder linkingAgents(List<Agent> linkingAgents) {
            this.linkingAgents = linkingAgents;
            return this;
        }

        public Builder linkingObjects(List<IntellectualEntity> linkingObjects) {
            this.linkingObjects = linkingObjects;
            return this;
        }

        public Builder outcome(List<Outcome> outcome) {
            this.outcome = outcome;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }
    }

    @XmlRootElement(name = "detail", namespace = "http://www.loc.gov/standards/premis")
    public static class Detail {
        @XmlElement(name = "note", namespace = "http://www.loc.gov/standards/premis")
        private String note;
        @XmlElement(name = "extension", namespace = "http://www.loc.gov/standards/premis")
        private String extension;

        @SuppressWarnings("unused")
        private Detail() {
            super();
        }

        public Detail(String note, String extension) {
            this.note = note;
            this.extension = extension;
        }

        public String getExtension() {
            return extension;
        }

        public String getNote() {
            return note;
        }

    }

    public static class Outcome {
        @XmlElement(name = "outcome", namespace = "http://www.loc.gov/standards/premis")
        private String outcome;
        @XmlElement(name = "outcomeDetail", namespace = "http://www.loc.gov/standards/premis")
        private List<Detail> details = new ArrayList<Event.Detail>();

        @SuppressWarnings("unused")
        private Outcome() {
            super();
        }

        public Outcome(String outcome, Detail... details) {
            this.outcome = outcome;
            this.details = Arrays.asList(details);
        }

        public List<Detail> getDetails() {
            return details;
        }

        public String getOutcome() {
            return outcome;
        }

    }
}
