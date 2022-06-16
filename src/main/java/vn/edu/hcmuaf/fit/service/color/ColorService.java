package vn.edu.hcmuaf.fit.service.color;

import vn.edu.hcmuaf.fit.dto.color.*;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;

import java.util.List;

public interface ColorService {
    public DataResponse<ColorDto> getColorById(final Long id);

    public DataResponse<ColorDto> getColorBySku(final String sku);

    public DataResponse<ColorDto> getColorByName(final String name);

    public DataResponse<ColorDto> createColor(final ColorCreate create);

    public DataResponse<List<ColorDto>> getListColor();

    public BaseResponse deleteColorById(final Long id);

    public BaseResponse updateColor(final ColorUpdate update);
}
