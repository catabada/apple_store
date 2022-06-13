package vn.edu.hcmuaf.fit.mapper.product;

import vn.edu.hcmuaf.fit.dto.product.ProductDto;
import vn.edu.hcmuaf.fit.dto.typeproduct.TypeProductDto;
import vn.edu.hcmuaf.fit.mapper.typeproduct.TypeProductMapper;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    private TypeProductMapper typeProductMapper;

    public ProductMapper() {
        this.typeProductMapper = new TypeProductMapper();
    }

    public Product toProduct(final ProductDto dto) {
        return new Product(dto.getId(), dto.getSku(), dto.getName(), null, dto.getPrice(), dto.getUrlImage(), dto.getRate(), dto.getDiscount(), dto.getViewed(), dto.getDateCreated(), dto.getLastUpdated(), dto.isActive());
    }

    public ProductDto toProductDto(final Product model) {
        return new ProductDto(model.getId(), model.getSku(), model.getName(), model.getTypeProduct(), model.getPrice(), model.getUrlImage(), model.getRate(), model.getDiscount(), model.getViewed(), model.getDateCreated(), model.getLastUpdated(), model.isActive());
    }

    public List<Product> toListProduct(final List<ProductDto> listDto) {
        List<Product> listModel = new ArrayList<Product>();
        for (ProductDto dto : listDto) {
            listModel.add(new Product(dto.getId(), dto.getSku(), dto.getName(), dto.getTypeProduct(), dto.getPrice(), dto.getUrlImage(), dto.getRate(), dto.getDiscount(), dto.getViewed(), dto.getDateCreated(), dto.getLastUpdated(), dto.isActive()));
        }
        return listModel;
    }

    public List<ProductDto> toListProductDto(final List<Product> listModel) {
        List<ProductDto> listDto = new ArrayList<ProductDto>();
        for (Product model : listModel) {
            listDto.add(new ProductDto(model.getId(), model.getSku(), model.getName(), model.getTypeProduct(), model.getPrice(), model.getUrlImage(), model.getRate(), model.getDiscount(), model.getViewed(), model.getDateCreated(), model.getLastUpdated(), model.isActive()));
        }
        return listDto;
    }
}
