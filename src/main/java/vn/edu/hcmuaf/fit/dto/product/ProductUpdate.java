package vn.edu.hcmuaf.fit.dto.product;


public class ProductUpdate {
    private Long id;
    private String sku;
    private String name;
    private Long typeId;
    private Integer price;
    private String urlImage;
    private Double discount;
    private Integer rate;
    private Integer viewed;
    private boolean active;

    public ProductUpdate() {

    }

    public ProductUpdate(Long id, String sku, String name, Long typeId, Integer price, String urlImage, Double discount, Integer rate, Integer viewed, boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.typeId = typeId;
        this.price = price;
        this.urlImage = urlImage;
        this.rate = rate;
        this.discount = discount;
        this.viewed = viewed;
        this.active = active;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long type) {
        this.typeId = type;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
