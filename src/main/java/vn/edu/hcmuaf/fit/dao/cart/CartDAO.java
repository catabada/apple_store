package vn.edu.hcmuaf.fit.dao.cart;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.cart.Cart;

import java.util.Optional;

public interface CartDAO extends BaseDAO<Cart> {
    Optional<Cart> findByUserId(Long id);
}
