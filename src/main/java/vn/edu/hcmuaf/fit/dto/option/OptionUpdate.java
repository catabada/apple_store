package vn.edu.hcmuaf.fit.dto.option;

public class OptionUpdate {
    private Long id;
    private String sku;
    private String name;
    private Long typeProductId;

    public OptionUpdate() {

    }

    public OptionUpdate(Long id, String sku, String name, Long typeProductId) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.typeProductId = typeProductId;
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

    public Long getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(Long typeProductId) {
        this.typeProductId = typeProductId;
    }
}
