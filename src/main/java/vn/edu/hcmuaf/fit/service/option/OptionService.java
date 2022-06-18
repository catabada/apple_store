package vn.edu.hcmuaf.fit.service.option;

import vn.edu.hcmuaf.fit.dto.color.*;
import vn.edu.hcmuaf.fit.dto.option.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface OptionService {
    public DataResponse<OptionDto> getOptionById(final Long id);

    public DataResponse<OptionDto> getOptionBySku(final String sku);

    public DataResponse<OptionDto> getOptionByName(final String name);

    public DataResponse<OptionDto> createOption(final OptionCreate create);

    public DataResponse<List<OptionDto>> getListOption();

    public DataResponse<List<OptionDto>> getListOptionByTypeProductId(final Long typeProductId);

    public BaseResponse deleteOptionById(final Long id);

    public BaseResponse updateOption(final OptionUpdate update);
}
