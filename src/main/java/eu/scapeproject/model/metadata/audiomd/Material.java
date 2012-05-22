package eu.scapeproject.model.metadata.audiomd;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="material",namespace="http://www.loc.gov/AMD/")
public class Material {
    @XmlAttribute(name="id",namespace="http://www.loc.gov/AMD/")
    private String id;
    @XmlElement(name="basematerial",namespace="http://www.loc.gov/AMD/")
    private List<String> baseMaterials;
    @XmlElement(name="binder",namespace="http://www.loc.gov/AMD/")
    private List<String> binders;
    @XmlElement(name="discsurface",namespace="http://www.loc.gov/AMD/")
    private List<String> discSurfaces;
    @XmlElement(name="oxide",namespace="http://www.loc.gov/AMD/")
    private List<String> oxides;
    @XmlElement(name="activelayer",namespace="http://www.loc.gov/AMD/")
    private List<String> activeLayers;
    @XmlElement(name="reflectivelayer",namespace="http://www.loc.gov/AMD/")
    private List<String> reflectiveLayers;
    @XmlElement(name="stockbrand",namespace="http://www.loc.gov/AMD/")
    private List<String> stockBrands;
    @XmlElement(name="method",namespace="http://www.loc.gov/AMD/")
    private List<String> methods;
    @XmlElement(name="usedsides",namespace="http://www.loc.gov/AMD/")
    private List<String> usedSides;
    
    private Material(){
        super();
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
