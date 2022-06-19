package vn.edu.hcmuaf.fit.dao.product;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.product.Product;

import java.util.List;

public interface ProductDAO extends BaseDAO<Product> {
    void findBySku(String sku);
    List<Product> findAllByTypeProductId(Long typeProductId);
}
