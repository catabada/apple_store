package vn.edu.hcmuaf.fit.service.impl.color;

import vn.edu.hcmuaf.fit.dao.color.ColorDAO;
import vn.edu.hcmuaf.fit.dao.impl.color.ColorDAOImpl;
import vn.edu.hcmuaf.fit.dto.color.*;
import vn.edu.hcmuaf.fit.mapper.color.ColorMapper;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.color.ColorService;

import java.util.List;
import java.util.Optional;

public class ColorServiceImpl implements ColorService {
    private ColorDAO colorDao;
    private ColorMapper colorMapper;

    public ColorServiceImpl() {
        this.colorDao = ColorDAOImpl.getInstance();
        this.colorMapper = new ColorMapper();
    }

    @Override
    public DataResponse<ColorDto> getColorById(Long id) {
        Optional<Color> optional = colorDao.findById(id);
        return optional.map(
                        color -> new DataResponse<>(true, 200, "Success", colorMapper.toColorDto(color)))
                .orElseGet(() -> new DataResponse<>(false, 401, "Can't find by id = " + id, null));

    }

    @Override
    public DataResponse<ColorDto> getColorBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<ColorDto> getColorByName(String name) {
        return null;
    }

    @Override
    public DataResponse<ColorDto> createColor(ColorCreate create) {
        Color color = new Color(create.getSku(), create.getName(), create.getHex());
        colorDao.save(color);
        return new DataResponse<>(true, 200, "Success!", colorMapper.toColorDto(color));
    }

    @Override
    public DataResponse<List<ColorDto>> getListColor() {
        List<Color> listColor = colorDao.findAll();
        return new DataResponse<List<ColorDto>>(true, 200, "Success!", colorMapper.toColorDtoList(listColor));
    }

    @Override
    public BaseResponse deleteColorById(Long id) {
        if (!colorDao.findById(id).isPresent()) {
            return new BaseResponse(false, 404, "Not found!");
        }
        colorDao.removeById(id);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public BaseResponse updateColor(ColorUpdate update) {
        Optional<Color> optional = colorDao.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 404, "Not found!");
        } else {
            Color color = optional.get();
            color.setSku(update.getSku());
            color.setName(update.getName());
            color.setHex(update.getHex());
            colorDao.save(color);
            return new BaseResponse(true, 200, "Success!");
        }
    }
}
