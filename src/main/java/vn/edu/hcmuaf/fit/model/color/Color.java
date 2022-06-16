package vn.edu.hcmuaf.fit.model.color;

import java.io.Serializable;

public class Color implements Serializable {
    private Long id;
    private String sku;
    private String name;
    private String hex;

    public Color() {
    }

    public Color(Long id, String sku, String name, String hex) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.hex = hex;
    }

    public Color(String sku, String name, String hex) {
        this.id = 0L;
        this.sku = sku;
        this.name = name;
        this.hex = hex;
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

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }
}
