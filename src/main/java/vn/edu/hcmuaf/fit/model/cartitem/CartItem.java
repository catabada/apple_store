package vn.edu.hcmuaf.fit.model.cartitem;

import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Long id;
    private Cart cart;
    private ProductDetail productDetail;
    private Integer quantity;

    public CartItem() {

    }

    public CartItem(Long id, Cart cart, ProductDetail productDetail, Integer quantity) {
        this.id = id;
        this.cart = cart;
        this.productDetail = productDetail;
        this.quantity = quantity;
    }

    public CartItem(Cart cart, ProductDetail productDetail, Integer quantity) {
        this.id = 0L;
        this.cart = cart;
        this.productDetail = productDetail;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
