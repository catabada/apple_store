package vn.edu.hcmuaf.fit.dto.typeproduct;

public class TypeProductCreate {
    private String sku;
    private String name;

    public TypeProductCreate() {
    }

    public TypeProductCreate(String sku, String name) {
        this.sku = sku;
        this.name = name;
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
}
