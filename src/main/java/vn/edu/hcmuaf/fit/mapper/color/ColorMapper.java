package vn.edu.hcmuaf.fit.mapper.color;

import vn.edu.hcmuaf.fit.dto.color.ColorDto;
import vn.edu.hcmuaf.fit.model.color.Color;

import java.util.ArrayList;
import java.util.List;

public class ColorMapper {
    public ColorDto toColorDto(final Color color) {
        return new ColorDto(color.getId(), color.getSku(), color.getName(), color.getHex());
    }

    public Color toColor(final ColorDto colorDto) {
        return new Color(colorDto.getId(), colorDto.getSku(), colorDto.getName(), colorDto.getHex());
    }

    public List<Color> toColorList(final List<ColorDto> colorDtoList) {
        List<Color> listColor = new ArrayList<Color>();
        for (ColorDto colorDto : colorDtoList) {
            Color color = new Color(colorDto.getId(), colorDto.getSku(), colorDto.getName(), colorDto.getHex());
            listColor.add(color);
        }
        return listColor;
    }

    public List<ColorDto> toColorDtoList(final List<Color> colorList) {
        List<ColorDto> listColorDto = new ArrayList<ColorDto>();
        for (Color color : colorList) {
            ColorDto colorDto = new ColorDto(color.getId(), color.getSku(), color.getName(), color.getHex());
            listColorDto.add(colorDto);
        }
        return listColorDto;
    }


}
