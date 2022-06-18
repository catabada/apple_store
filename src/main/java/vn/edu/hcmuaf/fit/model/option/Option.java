package vn.edu.hcmuaf.fit.model.option;

import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.io.Serializable;

public class Option implements Serializable {
    private Long id;
    private String sku;
    private String name;
    private TypeProduct typeProduct;


    public Option() {

    }

    public Option(String sku, String name, TypeProduct typeProduct) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.typeProduct = typeProduct;
    }

    public Option(Long id, String sku, String name, TypeProduct typeProduct) {
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

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
