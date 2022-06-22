package vn.edu.hcmuaf.fit.model.productdetail;

import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.io.Serializable;
import java.util.Date;

public class ProductDetail implements Serializable {
    private Long id;
    private String sku;
    private String name;
    private Product product;
    private ProductColor productColor;
    private ProductOption productOption;
    private Integer price;
    private Integer amount;
    private Date createdAt;
    private Date updatedAt;
    private boolean active;

    public ProductDetail() {
    }

    public ProductDetail(Long id, String sku, String name, Product product, ProductColor productColor, ProductOption productOption, Integer price, Integer amount, Date createdAt, Date updatedAt, boolean active) {
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

    public ProductDetail(String sku, String name, Product product, ProductColor productColor, ProductOption productOption, Integer price, Integer amount, Date createdAt, Date updatedAt, boolean active) {
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

    public ProductDetail(String sku, String name, Product product, ProductColor productColor, ProductOption productOption, Integer price, Integer amount) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.product = product;
        this.productColor = productColor;
        this.productOption = productOption;
        this.price = price;
        this.amount = amount;
        this.active = true;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

    public void setProductColor(ProductColor productColor) {
        this.productColor = productColor;
    }

    public ProductOption getProductOption() {
        return productOption;
    }

    public void setProductOption(ProductOption productOption) {
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

