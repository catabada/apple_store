package vn.edu.hcmuaf.fit.dto.cartitem;

public class CartItemCreate {
    private Long cartId;
    private Long productDetailId;
    private Integer quantity;

    public CartItemCreate(Long cartId, Long productDetailId, Integer quantity) {
        this.cartId = cartId;
        this.productDetailId = productDetailId;
        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
