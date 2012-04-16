package eu.scapeproject.model;

import java.util.UUID;

public class UUIDIdentifier implements Identifier {
    private String type = "UUID";
    private UUID value;

    public UUIDIdentifier() {
        this.value = UUID.randomUUID();
    }

    public UUIDIdentifier(UUID value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value.toString();
    }
}
