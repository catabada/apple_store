package vn.edu.hcmuaf.fit.dto.color;

public class ColorCreate {
    private String sku;
    private String name;
    private String hex;

    public ColorCreate() {

    }

    public ColorCreate(String sku, String name, String hex) {
        this.sku = sku;
        this.name = name;
        this.hex = hex;
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

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
