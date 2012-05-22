package eu.scapeproject.model;

import java.util.UUID;

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
