package eu.scapeproject.model;

import java.util.UUID;

public class UUIDIdentifier extends Identifier {

    public UUIDIdentifier() {
        super("UUID",UUID.randomUUID().toString());
    }

    public UUIDIdentifier(UUID value) {
        super("UUID",value.toString());
    }
    
    public UUIDIdentifier(String value){
        super("UUID",value);
    }
}
