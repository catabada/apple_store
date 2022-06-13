package vn.edu.hcmuaf.fit.dto.product;

import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

public class ProductCreate {
    private String sku;
    private String name;
    private Long typeId;
    private Integer price;
    private String urlImage;
    private Double discount;

    public ProductCreate() {

    }

    public ProductCreate(String sku, String name, Long typeId, Integer price, String urlImage, Double discount) {
        this.sku = sku;
        this.name = name;
        this.typeId = typeId;
        this.price = price;
        this.urlImage = urlImage;
        this.discount = discount;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
