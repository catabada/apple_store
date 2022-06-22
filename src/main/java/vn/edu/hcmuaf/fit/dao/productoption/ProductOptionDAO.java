package vn.edu.hcmuaf.fit.dao.productoption;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.util.List;

public interface ProductOptionDAO extends BaseDAO<ProductOption> {
    List<ProductOption> findAllByProductId(Long productId);
}
