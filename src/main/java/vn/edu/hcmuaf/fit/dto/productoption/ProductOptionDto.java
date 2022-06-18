package vn.edu.hcmuaf.fit.dto.productoption;

import vn.edu.hcmuaf.fit.dto.option.OptionDto;
import vn.edu.hcmuaf.fit.dto.product.ProductDto;

public class ProductOptionDto {
    private Long id;
    private String sku;
    private String name;
    private ProductDto product;
    private OptionDto option;

    public ProductOptionDto() {

    }

    public ProductOptionDto(Long id, String sku, String name, ProductDto product, OptionDto option) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.product = product;
        this.option = option;
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

    public OptionDto getOption() {
        return option;
    }

    public void setOption(OptionDto option) {
        this.option = option;
    }
}
