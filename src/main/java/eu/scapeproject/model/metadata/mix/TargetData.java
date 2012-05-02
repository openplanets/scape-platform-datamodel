package eu.scapeproject.model.metadata.mix;

import java.net.URI;
import java.util.List;

public class TargetData {
    private List<TargetType> targetTypes;
    private List<TargetId> tergetIds;
    private List<URI> externalReferences;
    private List<URI> performanceData;

    public TargetData(List<TargetType> targetTypes, List<TargetId> tergetIds, List<URI> externalReferences, List<URI> performanceData) {
        super();
        this.targetTypes = targetTypes;
        this.tergetIds = tergetIds;
        this.externalReferences = externalReferences;
        this.performanceData = performanceData;
    }

    public List<URI> getExternalReferences() {
        return externalReferences;
    }

    public List<URI> getPerformanceData() {
        return performanceData;
    }

    public List<TargetType> getTargetTypes() {
        return targetTypes;
    }

    public List<TargetId> getTergetIds() {
        return tergetIds;
    }

    public static class TargetId {
        private String targetManufacturer;
        private String targetname;
        private String targetNo;
        private String targetMedia;

        public TargetId(String targetManufacturer, String targetname, String targetNo, String targetMedia) {
            super();
            this.targetManufacturer = targetManufacturer;
            this.targetname = targetname;
            this.targetNo = targetNo;
            this.targetMedia = targetMedia;
        }

        public String getTargetManufacturer() {
            return targetManufacturer;
        }

        public String getTargetMedia() {
            return targetMedia;
        }

        public String getTargetname() {
            return targetname;
        }

        public String getTargetNo() {
            return targetNo;
        }

    }

    public enum TargetType {
        EXTERNAL, INTERNAL;
    }
}
