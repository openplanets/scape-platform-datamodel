package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="material",namespace="http://www.loc.gov/AMD/")
public class Material {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private final String id;
    @XmlElement(name="basematerial",namespace="http://www.loc.gov/AMD/")
    private final List<String> baseMaterials;
    @XmlElement(name="binder",namespace="http://www.loc.gov/AMD/")
    private final List<String> binders;
    @XmlElement(name="discsurface",namespace="http://www.loc.gov/AMD/")
    private final List<String> discSurfaces;
    @XmlElement(name="oxide",namespace="http://www.loc.gov/AMD/")
    private final List<String> oxides;
    @XmlElement(name="activelayer",namespace="http://www.loc.gov/AMD/")
    private final List<String> activeLayers;
    @XmlElement(name="reflectivelayer",namespace="http://www.loc.gov/AMD/")
    private final List<String> reflectiveLayers;
    @XmlElement(name="stockbrand",namespace="http://www.loc.gov/AMD/")
    private final List<String> stockBrands;
    @XmlElement(name="method",namespace="http://www.loc.gov/AMD/")
    private final List<String> methods;
    @XmlElement(name="usedsides",namespace="http://www.loc.gov/AMD/")
    private final List<String> usedSides;
    
    private Material(){
        super();
        this.id = null;
        this.baseMaterials = null;
        this.binders = null;
        this.discSurfaces = null;
        this.oxides = null;
        this.activeLayers = null;
        this.reflectiveLayers = null;
        this.stockBrands = null;
        this.methods = null;
        this.usedSides = null;
    }

    private Material(Builder builder) {
        this.id = builder.id;
        this.baseMaterials = builder.baseMaterials;
        this.binders = builder.binders;
        this.discSurfaces = builder.discSurfaces;
        this.oxides = builder.oxides;
        this.activeLayers = builder.activeLayers;
        this.reflectiveLayers = builder.reflectiveLayers;
        this.stockBrands = builder.stockBrands;
        this.methods = builder.methods;
        this.usedSides = builder.usedSides;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Material other = (Material) obj;
        if (activeLayers == null) {
            if (other.activeLayers != null)
                return false;
        } else if (!activeLayers.equals(other.activeLayers))
            return false;
        if (baseMaterials == null) {
            if (other.baseMaterials != null)
                return false;
        } else if (!baseMaterials.equals(other.baseMaterials))
            return false;
        if (binders == null) {
            if (other.binders != null)
                return false;
        } else if (!binders.equals(other.binders))
            return false;
        if (discSurfaces == null) {
            if (other.discSurfaces != null)
                return false;
        } else if (!discSurfaces.equals(other.discSurfaces))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (methods == null) {
            if (other.methods != null)
                return false;
        } else if (!methods.equals(other.methods))
            return false;
        if (oxides == null) {
            if (other.oxides != null)
                return false;
        } else if (!oxides.equals(other.oxides))
            return false;
        if (reflectiveLayers == null) {
            if (other.reflectiveLayers != null)
                return false;
        } else if (!reflectiveLayers.equals(other.reflectiveLayers))
            return false;
        if (stockBrands == null) {
            if (other.stockBrands != null)
                return false;
        } else if (!stockBrands.equals(other.stockBrands))
            return false;
        if (usedSides == null) {
            if (other.usedSides != null)
                return false;
        } else if (!usedSides.equals(other.usedSides))
            return false;
        return true;
    }

    public List<String> getActiveLayers() {
        return activeLayers;
    }

    public List<String> getBaseMaterials() {
        return baseMaterials;
    }

    public List<String> getBinders() {
        return binders;
    }

    public List<String> getDiscSurfaces() {
        return discSurfaces;
    }

    public String getId() {
        return id;
    }

    public List<String> getMethods() {
        return methods;
    }

    public List<String> getOxides() {
        return oxides;
    }

    public List<String> getReflectiveLayers() {
        return reflectiveLayers;
    }

    public List<String> getStockBrands() {
        return stockBrands;
    }

    public List<String> getUsedSides() {
        return usedSides;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activeLayers == null) ? 0 : activeLayers.hashCode());
        result = prime * result + ((baseMaterials == null) ? 0 : baseMaterials.hashCode());
        result = prime * result + ((binders == null) ? 0 : binders.hashCode());
        result = prime * result + ((discSurfaces == null) ? 0 : discSurfaces.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((methods == null) ? 0 : methods.hashCode());
        result = prime * result + ((oxides == null) ? 0 : oxides.hashCode());
        result = prime * result + ((reflectiveLayers == null) ? 0 : reflectiveLayers.hashCode());
        result = prime * result + ((stockBrands == null) ? 0 : stockBrands.hashCode());
        result = prime * result + ((usedSides == null) ? 0 : usedSides.hashCode());
        return result;
    }

    public static class Builder {
        private final String id;
        private List<String> baseMaterials;
        private List<String> binders;
        private List<String> discSurfaces;
        private List<String> oxides;
        private List<String> activeLayers;
        private List<String> reflectiveLayers;
        private List<String> stockBrands;
        private List<String> methods;
        private List<String> usedSides;
        public Builder(String id) {
            super();
            this.id=id;
        }

        public Builder activeLayers(List<String> activeLayers) {
            this.activeLayers = activeLayers;
            return this;
        }
        public Builder baseMaterials(List<String> baseMaterials) {
            this.baseMaterials = baseMaterials;
            return this;
        }
        public Builder binders(List<String> binders) {
            this.binders = binders;
            return this;
        }
        public Material build() {
            return new Material(this);
        }
        public Builder discSurfaces(List<String> discSurfaces) {
            this.discSurfaces = discSurfaces;
            return this;
        }

        public Builder methods(List<String> methods) {
            this.methods = methods;
            return this;
        }

        public Builder oxides(List<String> oxides) {
            this.oxides = oxides;
            return this;
        }

        public Builder reflectiveLayers(List<String> reflectiveLayers) {
            this.reflectiveLayers = reflectiveLayers;
            return this;
        }

        public Builder stockBrands(List<String> stockBrands) {
            this.stockBrands = stockBrands;
            return this;
        }

        public Builder usedSides(List<String> usedSides) {
            this.usedSides = usedSides;
            return this;
        }
    }
}
