package vn.edu.hcmuaf.fit.mapper.productdetail;

import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.product.ProductDAO;
import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;
import vn.edu.hcmuaf.fit.dto.productoption.ProductOptionDto;
import vn.edu.hcmuaf.fit.mapper.product.ProductMapper;
import vn.edu.hcmuaf.fit.mapper.productcolor.ProductColorMapper;
import vn.edu.hcmuaf.fit.mapper.productoption.ProductOptionMapper;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailMapper {
    private ProductMapper productMapper;
    private ProductColorMapper productColorMapper;
    private ProductOptionMapper productOptionMapper;

    public ProductDetailMapper() {
        productMapper = new ProductMapper();
        productColorMapper = new ProductColorMapper();
        productOptionMapper = new ProductOptionMapper();
    }

    public ProductDetail toProductDetail(final ProductDetailDto productDetailDto) {
        Product product = productMapper.toProduct(productDetailDto.getProduct());
        ProductColor productColor = productColorMapper.toProductColor(productDetailDto.getProductColor());
        ProductOption productOption = productOptionMapper.toProductOption(productDetailDto.getProductOption());
        return new ProductDetail(productDetailDto.getId(), productDetailDto.getSku(), productDetailDto.getName(), product, productColor, productOption, productDetailDto.getPrice(), productDetailDto.getAmount(), productDetailDto.getCreatedAt(), productDetailDto.getUpdatedAt(), productDetailDto.isActive());
    }

    public ProductDetailDto toProductDetailDto(final ProductDetail model) {
        ProductDto productDto = productMapper.toProductDto(model.getProduct());
        ProductColorDto productColorDto = productColorMapper.toProductColorDto(model.getProductColor());
        ProductOptionDto productOptionDto = productOptionMapper.toProductOptionDto(model.getProductOption());
        return new ProductDetailDto(model.getId(), model.getSku(), model.getName(), productDto, productColorDto, productOptionDto, model.getPrice(), model.getAmount(), model.getCreatedAt(), model.getUpdatedAt(), model.isActive());
    }

    public List<ProductDetail> toProductDetailList(final List<ProductDetailDto> productDetailDtoList) {
        List<ProductDetail> productDetailList = new ArrayList<ProductDetail>();
        for (ProductDetailDto productDetailDto : productDetailDtoList) {
            ProductDetail productDetail = toProductDetail(productDetailDto);
            productDetailList.add(productDetail);
        }
        return productDetailList;
    }

    public List<ProductDetailDto> toProductDetailDtoList(final List<ProductDetail> productDetailList) {
        List<ProductDetailDto> productDetailDtoList = new ArrayList<ProductDetailDto>();
        for (ProductDetail productDetail : productDetailList) {
            ProductDetailDto productDetailDto = toProductDetailDto(productDetail);
            productDetailDtoList.add(productDetailDto);
        }
        return productDetailDtoList;
    }

}
