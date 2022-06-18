package vn.edu.hcmuaf.fit.mapper.option;


import vn.edu.hcmuaf.fit.dto.option.OptionDto;
import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;
import vn.edu.hcmuaf.fit.mapper.typeproduct.TypeProductMapper;
import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class OptionMapper {
    private TypeProductMapper typeProductMapper;

    public OptionMapper() {
        this.typeProductMapper = new TypeProductMapper();
    }

    public OptionDto toOptionDto(final Option option) {
        TypeProduct typeProduct = option.getTypeProduct();
        return new OptionDto(option.getId(), option.getSku(), option.getName(), typeProductMapper.toTypeProductDto(typeProduct));
    }

    public Option toOption(final OptionDto optionDto) {
        TypeProductDto typeProductDto = optionDto.getTypeProduct();
        return new Option(optionDto.getId(), optionDto.getSku(), optionDto.getName(), typeProductMapper.toTypeProduct(typeProductDto));
    }

    public List<Option> toOptionList(final List<OptionDto> optionDtoList) {
        List<Option> listOption = new ArrayList<Option>();
        for (OptionDto optionDto : optionDtoList) {
            Option Option = new Option(optionDto.getId(), optionDto.getSku(), optionDto.getName(), typeProductMapper.toTypeProduct(optionDto.getTypeProduct()));
            listOption.add(Option);
        }
        return listOption;
    }

    public List<OptionDto> toOptionDtoList(final List<Option> optionList) {
        List<OptionDto> listOptionDto = new ArrayList<OptionDto>();
        for (Option option : optionList) {
            OptionDto OptionDto = new OptionDto(option.getId(), option.getSku(), option.getName(), typeProductMapper.toTypeProductDto(option.getTypeProduct()));
            listOptionDto.add(OptionDto);
        }
        return listOptionDto;
    }
}
