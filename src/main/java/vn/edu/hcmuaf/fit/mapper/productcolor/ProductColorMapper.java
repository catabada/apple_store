package vn.edu.hcmuaf.fit.mapper.productcolor;

import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.mapper.color.ColorMapper;
import vn.edu.hcmuaf.fit.mapper.product.ProductMapper;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;

import java.util.ArrayList;
import java.util.List;

public class ProductColorMapper {
    private ColorMapper colorMapper;
    private ProductMapper productMapper;

    public ProductColorMapper() {
        colorMapper = new ColorMapper();
        productMapper = new ProductMapper();
    }

    public ProductColor toProductColor(final ProductColorDto productColorDto) {
        return new ProductColor(productColorDto.getId(), productMapper.toProduct(productColorDto.getProduct()), colorMapper.toColor(productColorDto.getColor()),
                productColorDto.getBgImage(), productColorDto.getDeImages());
    }

    public ProductColorDto toProductColorDto(final ProductColor productColor) {
        return new ProductColorDto(productColor.getId(), productMapper.toProductDto(productColor.getProduct()), colorMapper.toColorDto(productColor.getColor()),
                productColor.getBgImage(), productColor.getDeImages());
    }

    public List<ProductColor> toProductColorList(final List<ProductColorDto> productColorDtoList) {
        List<ProductColor> listProductColor = new ArrayList<ProductColor>();
        for (ProductColorDto productColorDto : productColorDtoList) {
            ProductColor productColor = new ProductColor(productColorDto.getId(), productMapper.toProduct(productColorDto.getProduct()), colorMapper.toColor(productColorDto.getColor()),
                    productColorDto.getBgImage(), productColorDto.getDeImages());
            listProductColor.add(productColor);
        }
        return listProductColor;
    }

    public List<ProductColorDto> toProductColorDtoList(final List<ProductColor> productColorList) {
        List<ProductColorDto> listProductColorDto = new ArrayList<ProductColorDto>();
        for (ProductColor productColor : productColorList) {
            ProductColorDto productColorDto = new ProductColorDto(productColor.getId(), productMapper.toProductDto(productColor.getProduct()), colorMapper.toColorDto(productColor.getColor()),
                    productColor.getBgImage(), productColor.getDeImages());
            listProductColorDto.add(productColorDto);
        }
        return listProductColorDto;
    }

}
