package vn.edu.hcmuaf.fit.dao.cartitem;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.cartitem.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemDAO extends BaseDAO<CartItem> {
    Optional<CartItem> findByCartIdAndProductDetailId(Long cartId, Long productDetailId);

    List<CartItem> findAllByCartId(Long cartId);
}
