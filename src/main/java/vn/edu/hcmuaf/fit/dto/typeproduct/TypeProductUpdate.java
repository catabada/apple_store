package vn.edu.hcmuaf.fit.dto.typeproduct;

public class TypeProductUpdate {
    private Long id;
    private String sku;
    private String name;
    private boolean active;

    public TypeProductUpdate() {
    }

    public TypeProductUpdate(Long id, String sku, String name, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
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
}
