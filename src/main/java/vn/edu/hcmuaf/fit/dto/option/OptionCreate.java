package vn.edu.hcmuaf.fit.dto.option;

public class OptionCreate {
    private String sku;
    private String name;
    private Long typeProductId;

    public OptionCreate() {

    }

    public OptionCreate(String sku, String name, Long typeProductId) {
        this.sku = sku;
        this.name = name;
        this.typeProductId = typeProductId;
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

    public Long getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Long typeProductId) {
        this.typeProductId = typeProductId;
    }
}
