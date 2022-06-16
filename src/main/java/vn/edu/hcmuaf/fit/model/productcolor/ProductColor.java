package vn.edu.hcmuaf.fit.model.productcolor;

import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.product.Product;

import java.io.Serializable;

public class ProductColor implements Serializable {
    private Long id;
    private Product product;
    private Color color;
    private String bgImage;
    private String deImages;

    public ProductColor() {

    }

    public ProductColor(Long id, Product product, Color color, String bgImage, String deImages) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.bgImage = bgImage;
        this.deImages = deImages;
    }

    public ProductColor(Product product, Color color, String bgImage, String deImages) {
        this.id = 0L;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

