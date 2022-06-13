package vn.edu.hcmuaf.fit.service.product;

import vn.edu.hcmuaf.fit.dto.product.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface ProductService {
    public DataResponse<ProductDto> getProductById(final Long id);

    public DataResponse<ProductDto> getProductBySku(final String sku);

    public DataResponse<ProductDto> getProductByName(final String name);

    public DataResponse<ProductDto> createProduct(final ProductCreate create);

    public DataResponse<List<ProductDto>> getListProduct();

    public BaseResponse deleteProductById(final Long id);

    public BaseResponse updateProduct(final ProductUpdate update);
}
