package vn.edu.hcmuaf.fit.dto.productdetail;

import java.util.Date;

public class ProductDetailCreate {
    private Long productId;
    private Long productColorId;
    private Long productOptionId;
    private Integer price;
    private Integer amount;

    public ProductDetailCreate() {
    }

    public ProductDetailCreate(Long productId, Long productColorId, Long productOptionId, Integer price, Integer amount) {
        this.productId = productId;
        this.productColorId = productColorId;
        this.productOptionId = productOptionId;
        this.price = price;
        this.amount = amount;
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

}
