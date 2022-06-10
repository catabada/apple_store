package vn.edu.hcmuaf.fit.mapper.typeproduct;

import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class TypeProductMapper {
    public TypeProduct toTypeProduct(final TypeProductDto dto) {
        return new TypeProduct(dto.getId(), dto.getSku(), dto.getName(), dto.isActive());
    }

    public TypeProductDto toTypeProductDto(final TypeProduct model) {
        return new TypeProductDto(model.getId(), model.getSku(), model.getName(), model.isActive());
    }

    public List<TypeProduct> toListTypeProduct(final List<TypeProductDto> listDto) {
        List<TypeProduct> listModel = new ArrayList<TypeProduct>();
        for (TypeProductDto dto : listDto) {
            listModel.add(new TypeProduct(dto.getId(), dto.getSku(), dto.getName(), dto.isActive()));
        }
        return listModel;
    }

    public List<TypeProductDto> toListTypeProductDto(final List<TypeProduct> listModel) {
        List<TypeProductDto> listDto = new ArrayList<TypeProductDto>();
        for (TypeProduct model : listModel) {
            listDto.add(new TypeProductDto(model.getId(), model.getSku(), model.getName(), model.isActive()));
        }
        return listDto;
    }

}
