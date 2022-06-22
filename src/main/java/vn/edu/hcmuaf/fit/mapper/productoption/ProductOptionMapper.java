package vn.edu.hcmuaf.fit.mapper.productoption;

import vn.edu.hcmuaf.fit.dto.productoption.ProductOptionDto;
import vn.edu.hcmuaf.fit.mapper.option.OptionMapper;
import vn.edu.hcmuaf.fit.mapper.product.ProductMapper;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.util.ArrayList;
import java.util.List;

public class ProductOptionMapper {
    private OptionMapper optionMapper;
    private ProductMapper productMapper;

    public ProductOptionMapper() {
        optionMapper = new OptionMapper();
        productMapper = new ProductMapper();
    }

    public ProductOption toProductOption(final ProductOptionDto productOptionDto) {
        return new ProductOption(productOptionDto.getId(), productOptionDto.getSku(), productOptionDto.getName(),
                productMapper.toProduct(productOptionDto.getProduct()),
                optionMapper.toOption(productOptionDto.getOption()));
    }

    public ProductOptionDto toProductOptionDto(final ProductOption productOption) {
        return new ProductOptionDto(productOption.getId(), productOption.getSku(), productOption.getName(),
                productMapper.toProductDto(productOption.getProduct()),
                optionMapper.toOptionDto(productOption.getOption()));
    }

    public List<ProductOption> toProductOptionList(final List<ProductOptionDto> productOptionDtoList) {
        List<ProductOption> listProductOption = new ArrayList<ProductOption>();
        for (ProductOptionDto productOptionDto : productOptionDtoList) {
            ProductOption productOption = new ProductOption(productOptionDto.getId(), productOptionDto.getSku(), productOptionDto.getName(),
                    productMapper.toProduct(productOptionDto.getProduct()),
                    optionMapper.toOption(productOptionDto.getOption()));
            listProductOption.add(productOption);
        }
        return listProductOption;
    }

    public List<ProductOptionDto> toProductOptionDtoList(final List<ProductOption> productoptionList) {
        List<ProductOptionDto> listProductOptionDto = new ArrayList<ProductOptionDto>();
        for (ProductOption productOption : productoptionList) {
            ProductOptionDto productOptionDto = new ProductOptionDto(productOption.getId(), productOption.getSku(), productOption.getName(),
                    productMapper.toProductDto(productOption.getProduct()),
                    optionMapper.toOptionDto(productOption.getOption()));
            listProductOptionDto.add(productOptionDto);
        }
        return listProductOptionDto;
    }
}
