package vn.edu.hcmuaf.fit.service.productoption;

import vn.edu.hcmuaf.fit.dto.productoption.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface ProductOptionService {
    public DataResponse<ProductOptionDto> getProductOptionById(final Long id);

    public DataResponse<ProductOptionDto> getProductOptionBySku(final String sku);

    public DataResponse<ProductOptionDto> createProductOption(final ProductOptionCreate create);

    public DataResponse<List<ProductOptionDto>> getListProductOption();

    public DataResponse<List<ProductOptionDto>> getListProductOptionByTypeProduct();

    public BaseResponse deleteProductOptionById(final Long id);

    public BaseResponse updateProductOption(final ProductOptionUpdate update);
}
