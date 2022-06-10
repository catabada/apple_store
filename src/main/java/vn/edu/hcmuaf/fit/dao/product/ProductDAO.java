package vn.edu.hcmuaf.fit.dao.product;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.product.Product;

public interface ProductDAO extends BaseDAO<Product> {
    void findBySku(String sku);

}
