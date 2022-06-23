package vn.edu.hcmuaf.fit.dto.productdetail;

public class ProductDetailUpdate {
    private Long id;
    private String sku;
    private String name;
    private Long productId;
    private Long productColorId;
    private Long productOptionId;
    private Integer price;
    private Integer amount;
    private boolean active;

    public ProductDetailUpdate() {
    }

    public ProductDetailUpdate(Long id, String sku, String name, Long productId, Long productColorId, Long productOptionId, Integer price, Integer amount, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.productId = productId;
        this.productColorId = productColorId;
        this.productOptionId = productOptionId;
        this.price = price;
        this.amount = amount;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductColorId() {
        return productColorId;
    }

    public void setProductColorId(Long productColorId) {
        this.productColorId = productColorId;
    }

    public Long getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(Long productOptionId) {
        this.productOptionId = productOptionId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
