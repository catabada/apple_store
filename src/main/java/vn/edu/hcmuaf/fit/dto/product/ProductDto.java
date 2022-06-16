package vn.edu.hcmuaf.fit.dto.product;


import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.Date;

public class ProductDto {
    private Long id;
    private String sku;
    private String name;
    private TypeProductDto typeProduct;
    private Integer price;
    private String urlImage;
    private Integer rate;
    private Double discount;
    private Integer viewed;
    private Date dateCreated;
    private Date lastUpdated;
    private boolean active;

    public ProductDto() {

    }

    public ProductDto(String sku, String name, TypeProductDto typeProduct, Integer price, String urlImage, Integer rate, Double discount, Integer viewed) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
        this.price = price;
        this.urlImage = urlImage;
        this.rate = rate;
        this.discount = discount;
        this.viewed = viewed;
        this.active = true;
    }

    public ProductDto(String sku, String name, TypeProductDto typeProduct, Integer price, String urlImage, Double discount) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
        this.price = price;
        this.urlImage = urlImage;
        this.rate = 5;
        this.discount = discount;
        this.viewed = 0;
        this.active = true;
    }

    public ProductDto(Long id, String sku, String name, TypeProductDto typeProduct, Integer price, String urlImage, Integer rate, Double discount, Integer viewed, Date dateCreated, Date lastUpdated, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
        this.price = price;
        this.urlImage = urlImage;
        this.rate = rate;
        this.discount = discount;
        this.viewed = viewed;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
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

    public TypeProductDto getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProductDto typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
