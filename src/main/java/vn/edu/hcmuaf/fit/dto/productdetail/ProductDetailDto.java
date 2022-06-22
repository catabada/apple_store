package vn.edu.hcmuaf.fit.dto.productdetail;

import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productoption.ProductOptionDto;
import vn.edu.hcmuaf.fit.model.product.Product;
import java.util.Date;

public class ProductDetailDto {
    private Long id;
    private String sku;
    private String name;
    private ProductDto product;
    private ProductColorDto productColor;
    private ProductOptionDto productOption;
    private Integer price;
    private Integer amount;
    private Date createdAt;
    private Date updatedAt;
    private boolean active;

    public ProductDetailDto() {
    }

    public ProductDetailDto(Long id, String sku, String name, ProductDto product, ProductColorDto productColor, ProductOptionDto productOption, Integer price, Integer amount, Date createdAt, Date updatedAt, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.product = product;
        this.productColor = productColor;
        this.productOption = productOption;
        this.price = price;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public ProductDetailDto(String sku, String name, ProductDto product, ProductColorDto productColor, ProductOptionDto productOption, Integer price, Integer amount, Date createdAt, Date updatedAt, boolean active) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.product = product;
        this.productColor = productColor;
        this.productOption = productOption;
        this.price = price;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ProductColorDto getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColorDto productColor) {
        this.productColor = productColor;
    }

    public ProductOptionDto getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOptionDto productOption) {
        this.productOption = productOption;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
