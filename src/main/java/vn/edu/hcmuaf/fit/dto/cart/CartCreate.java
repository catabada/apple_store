package vn.edu.hcmuaf.fit.dto.cart;

public class CartCreate {
    private Long userId;

    public CartCreate(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
