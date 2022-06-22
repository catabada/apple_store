package vn.edu.hcmuaf.fit.service.productdetail;

import vn.edu.hcmuaf.fit.dto.productdetail.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface ProductDetailService {
    public DataResponse<ProductDetailDto> getProductDetailById(final Long id);

    public DataResponse<ProductDetailDto> getProductDetailBySku(final String sku);

    public DataResponse<ProductDetailDto> createProductDetail(final ProductDetailCreate create);

    public DataResponse<List<ProductDetailDto>> getListProductDetail();

    public DataResponse<List<ProductDetailDto>> getListProductDetailByTypeProduct();

    public BaseResponse deleteProductDetailById(final Long id);

    public BaseResponse updateProductDetail(final ProductDetailUpdate update);

    public DataResponse<List<ProductDetailDto>> getListByProductId(final Long productId);

    public DataResponse<List<ProductDetailDto>> getListByProductColorId(final Long productColorId);

    public DataResponse<List<ProductDetailDto>> getListByProductOptionId(final Long productOptionId);



}
