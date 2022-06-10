package vn.edu.hcmuaf.fit.service.typeproduct;

import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.dto.typeproduct.*;

import java.util.List;

public interface TypeProductService<TypeProduct> {
    DataResponse<List<TypeProductDto>> getTypeProductList();

    DataResponse<TypeProductDto> getTypeProduct(Long id);

    DataResponse<TypeProductDto> getTypeProductBySku(String sku);

    DataResponse<TypeProductDto> getTypeProductByName(String name);

    DataResponse<TypeProductDto> createTypeProduct(TypeProductCreate create);

    BaseResponse updateTypeProduct(TypeProductUpdate category);

    BaseResponse deleteTypeProduct(Long id);

    DataResponse<TypeProductDto> updateStatus(Long id);
}
