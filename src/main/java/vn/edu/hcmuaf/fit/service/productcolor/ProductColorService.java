package vn.edu.hcmuaf.fit.service.productcolor;

import vn.edu.hcmuaf.fit.dto.color.*;
import vn.edu.hcmuaf.fit.dto.productcolor.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface ProductColorService {
    public DataResponse<ProductColorDto> getProductColorById(final Long id);

    public DataResponse<ProductColorDto> getProductColorBySku(final String sku);

    public DataResponse<ProductColorDto> createProductColor(final ProductColorCreate create);

    public DataResponse<List<ProductColorDto>> getListProductColor();

    public BaseResponse deleteProductColorById(final Long id);

    public BaseResponse updateProductColor(final ProductColorUpdate update);


}
