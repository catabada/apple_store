package vn.edu.hcmuaf.fit.model.typeproduct;

import java.io.Serializable;

public class TypeProduct implements Serializable {
    private Long id;
    private String sku;
    private String name;
    private boolean active;

    public TypeProduct() {

    }

    public TypeProduct(String sku, String name) {
        this.id = 0l;
        this.sku = sku;
        this.name = name;
        this.active = true;
    }

    public TypeProduct(Long id, String sku, String name, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


}
