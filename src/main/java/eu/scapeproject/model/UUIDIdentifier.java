package eu.scapeproject.model;

import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

public class UUIDIdentifier extends Identifier {

    public UUIDIdentifier() {
        this.type = "UUID";
        this.value = UUID.randomUUID().toString();
    }

    public UUIDIdentifier(UUID value) {
        this.type = "UUID";
        this.value = value.toString();
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value.toString();
    }
}
