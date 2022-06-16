package vn.edu.hcmuaf.fit.dto.productcolor;

import vn.edu.hcmuaf.fit.dto.color.ColorDto;
import vn.edu.hcmuaf.fit.dto.product.ProductDto;

public class ProductColorDto {
    private Long id;
    private ProductDto product;
    private ColorDto color;
    private String bgImage;
    private String deImages;

    public ProductColorDto() {

    }

    public ProductColorDto(Long id, ProductDto product, ColorDto color, String bgImage, String deImages) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.bgImage = bgImage;
        this.deImages = deImages;
    }

    public ProductColorDto(ProductDto product, ColorDto color, String bgImage, String deImages) {
        this.product = product;
        this.color = color;
        this.bgImage = bgImage;
        this.deImages = deImages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public ColorDto getColor() {
        return color;
    }

    public void setColor(ColorDto color) {
        this.color = color;
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
