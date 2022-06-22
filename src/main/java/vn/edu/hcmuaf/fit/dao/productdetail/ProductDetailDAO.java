package vn.edu.hcmuaf.fit.dao.productdetail;

import vn.edu.hcmuaf.fit.dao.BaseDAO;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;
import vn.edu.hcmuaf.fit.response.BaseResponse;

import java.util.List;

public interface ProductDetailDAO extends BaseDAO<ProductDetail> {
    public boolean checkExistColorAndOption(final Long productColorId, final Long productOptionId);

    public List<ProductDetail> findAllByProductId(Long productId);

    public List<ProductDetail> findAllByProductColorId(Long productOptionId);

    List<ProductDetail> findAllByProductOptionId(Long productOptionId);
}
