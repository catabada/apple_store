package vn.edu.hcmuaf.fit.dto.productoption;

public class ProductOptionUpdate {
    private Long id;
    private String sku;
    private String name;
    private Long productId;
    private Long optionId;

    public ProductOptionUpdate() {

    }

    public ProductOptionUpdate(Long id, String sku, String name, Long productId, Long optionId) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.productId = productId;
        this.optionId = optionId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
}
