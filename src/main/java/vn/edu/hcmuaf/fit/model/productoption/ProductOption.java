package vn.edu.hcmuaf.fit.model.productoption;

import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.model.product.Product;

import java.io.Serializable;

public class ProductOption implements Serializable {
    private Long id;
    private String sku;
    private String name;
    private Product product;
    private Option option;

    public ProductOption() {

    }

    public ProductOption(String sku, String name, Product product, Option option) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.product = product;
        this.option = option;
    }

    public ProductOption(Long id, String sku, String name, Product product, Option option) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
