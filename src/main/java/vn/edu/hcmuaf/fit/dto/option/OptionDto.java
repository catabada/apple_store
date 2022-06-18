package vn.edu.hcmuaf.fit.dto.option;

import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;

public class OptionDto {
    private Long id;
    private String sku;
    private String name;
    private TypeProductDto typeProduct;

    public OptionDto() {

    }

    public OptionDto(String sku, String name, TypeProductDto typeProduct) {
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
    }

    public OptionDto(Long id, String sku, String name, TypeProductDto typeProduct) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
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
}
