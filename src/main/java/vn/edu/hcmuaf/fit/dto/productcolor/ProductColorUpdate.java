package vn.edu.hcmuaf.fit.dto.productcolor;


public class ProductColorUpdate {
    private Long id;
    private Long productId;
    private Long colorId;
    private String bgImage;
    private String deImages;

    public ProductColorUpdate() {

    }

    public ProductColorUpdate(Long id, Long productId, Long colorId, String bgImage, String deImages) {
        this.id = id;
        this.productId = productId;
        this.colorId = colorId;
        this.bgImage = bgImage;
        this.deImages = deImages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }

    public String getDeImages() {
        return deImages;
    }

    public void setDeImages(String deImages) {
        this.deImages = deImages;
    }
}
