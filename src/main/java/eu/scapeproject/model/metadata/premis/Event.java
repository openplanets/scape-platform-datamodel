package eu.scapeproject.model.metadata.premis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import eu.scapeproject.model.Agent;
import eu.scapeproject.model.IntellectualEntity;
import eu.scapeproject.model.Identifier;

public class Event {
    private Identifier identifier;
    private String type;
    private Date dateTime;
    private String detail;
    private List<Outcome> outcome = new ArrayList<Outcome>();
    private List<Agent> linkingAgents;
    private List<IntellectualEntity> linkingObjects;

    private Event(){
        super();
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

    public static class Builder {
        private Identifier identifier;
        private String type;
        private Date dateTime;
        private String detail;
        private List<Outcome> outcome;
        private List<Agent> linkingAgents;
        private List<IntellectualEntity> linkingObjects;

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

    public class Detail {
        private String note;
        private String extension;

        public Detail(String note, String extension) {
            this.note = note;
            this.extension = extension;
        }
    }

    public class Outcome {
        private String outcome;
        private List<Detail> details = new ArrayList<Event.Detail>();

        public Outcome(String outcome, Detail... details) {
            this.outcome = outcome;
            this.details = Arrays.asList(details);
        }
    }
}
