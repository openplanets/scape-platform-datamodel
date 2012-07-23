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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((externalReferences == null) ? 0 : externalReferences.hashCode());
        result = prime * result + ((performanceData == null) ? 0 : performanceData.hashCode());
        result = prime * result + ((targetTypes == null) ? 0 : targetTypes.hashCode());
        result = prime * result + ((tergetIds == null) ? 0 : tergetIds.hashCode());
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
        TargetData other = (TargetData) obj;
        if (externalReferences == null) {
            if (other.externalReferences != null)
                return false;
        } else if (!externalReferences.equals(other.externalReferences))
            return false;
        if (performanceData == null) {
            if (other.performanceData != null)
                return false;
        } else if (!performanceData.equals(other.performanceData))
            return false;
        if (targetTypes == null) {
            if (other.targetTypes != null)
                return false;
        } else if (!targetTypes.equals(other.targetTypes))
            return false;
        if (tergetIds == null) {
            if (other.tergetIds != null)
                return false;
        } else if (!tergetIds.equals(other.tergetIds))
            return false;
        return true;
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((targetManufacturer == null) ? 0 : targetManufacturer.hashCode());
            result = prime * result + ((targetMedia == null) ? 0 : targetMedia.hashCode());
            result = prime * result + ((targetNo == null) ? 0 : targetNo.hashCode());
            result = prime * result + ((targetname == null) ? 0 : targetname.hashCode());
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
            TargetId other = (TargetId) obj;
            if (targetManufacturer == null) {
                if (other.targetManufacturer != null)
                    return false;
            } else if (!targetManufacturer.equals(other.targetManufacturer))
                return false;
            if (targetMedia == null) {
                if (other.targetMedia != null)
                    return false;
            } else if (!targetMedia.equals(other.targetMedia))
                return false;
            if (targetNo == null) {
                if (other.targetNo != null)
                    return false;
            } else if (!targetNo.equals(other.targetNo))
                return false;
            if (targetname == null) {
                if (other.targetname != null)
                    return false;
            } else if (!targetname.equals(other.targetname))
                return false;
            return true;
        }
    }

    public enum TargetType {
        EXTERNAL, INTERNAL;
    }
}
