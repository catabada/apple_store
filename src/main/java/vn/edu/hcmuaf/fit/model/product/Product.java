package vn.edu.hcmuaf.fit.model.product;

import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.Date;

public class Product {
    private int id;
    private String sku;
    private String productName;
    private TypeProduct type;
    private int price;
    private String urlImage;
    private double rate;
    private double discount;
    private int viewed;
    private int quantityImport;
    private int quantityStock;
    private boolean active;
    private Date dateImport;



    public Product() {

    }
    public int sales() {
        return (int) Math.round(this.price - (this.price * this.discount));
    }

}
