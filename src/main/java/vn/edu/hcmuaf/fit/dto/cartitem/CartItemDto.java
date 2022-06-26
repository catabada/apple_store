package vn.edu.hcmuaf.fit.dto.cartitem;

import vn.edu.hcmuaf.fit.dto.cart.CartDto;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;

public class CartItemDto {
    private Long id;
    private CartDto cart;
    private ProductDetailDto productDetail;
    private Integer quantity;

    public CartItemDto() {
    }

    public CartItemDto(Long id, CartDto cart, ProductDetailDto productDetail, Integer quantity) {
        this.id = id;
        this.cart = cart;
        this.productDetail = productDetail;
        this.quantity = quantity;
    }

    public CartItemDto(CartDto cart, ProductDetailDto productDetail, Integer quantity) {
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

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    public ProductDetailDto getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailDto productDetail) {
        this.productDetail = productDetail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
