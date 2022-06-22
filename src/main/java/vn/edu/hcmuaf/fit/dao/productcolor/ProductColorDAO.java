package vn.edu.hcmuaf.fit.dao.productcolor;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;

import java.util.List;

public interface ProductColorDAO extends BaseDAO<ProductColor> {
    List<ProductColor> findAllByProductId(Long productId);
}
