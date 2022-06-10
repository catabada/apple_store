package vn.edu.hcmuaf.fit.dao.typeproduct;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.Optional;

public interface TypeProductDAO extends BaseDAO<TypeProduct> {
    Optional<TypeProduct> findBySku(String sku);

    Optional<TypeProduct> findBySkuExcept(String sku);

}
