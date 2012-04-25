package eu.scapeproject.model.metadata.mix;

import java.net.URI;
import java.util.List;

public class TargetData {
    private List<TargetType> targetTypes;
    private List<TargetId> tergetIds;
    private List<URI> externalReferences;
    private List<URI> performanceData;
    
    public class TargetId{
        private String targetManufacturer;
        private String targetname;
        private String targetNo;
        private String targetMedia;
    }
    
    public enum TargetType{
        EXTERNAL,INTERNAL;
    }
}
