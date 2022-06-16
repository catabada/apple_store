package vn.edu.hcmuaf.fit.service.impl.product;

import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.product.ProductDAO;
import vn.edu.hcmuaf.fit.dto.product.*;
import vn.edu.hcmuaf.fit.mapper.product.ProductMapper;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.product.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDao;
    private ProductMapper productMapper;

    public ProductServiceImpl() {
        this.productDao = ProductDAOImpl.getInstance();
        this.productMapper = new ProductMapper();
    }

    @Override
    public DataResponse<ProductDto> getProductById(Long id) {
        Optional<Product> optional = productDao.findById(id);
        return optional.map(
                        product -> new DataResponse<>(true, 200, "Success", productMapper.toProductDto(product)))
                .orElseGet(() -> new DataResponse<>(false, 401, "Can't find by id = " + id, null));
    }

    @Override
    public DataResponse<ProductDto> getProductBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<ProductDto> getProductByName(String name) {
        return null;
    }

    @Override
    public DataResponse<ProductDto> createProduct(ProductCreate create) {
        TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(create.getTypeId()).orElseGet(null);
        Product product = new Product(create.getSku(), create.getName(), typeProduct, create.getPrice(), create.getUrlImage(), create.getDiscount());
        productDao.save(product);
        return new DataResponse<>(true, 200, "Success!", productMapper.toProductDto(product));
    }

    @Override
    public DataResponse<List<ProductDto>> getListProduct() {
        List<ProductDto> list = productMapper.toListProductDto(productDao.findAll());
//        if (list.isEmpty()) {
//            return new DataResponse<List<ProductDto>>(false, 401, "No data", list);
//        }
        return new DataResponse<List<ProductDto>>(true, 200, "Success!", list);
    }

    @Override
    public BaseResponse deleteProductById(Long id) {
        if (productDao.findById(id).isPresent()) {
            return new BaseResponse(false, 401, "Can't find by id = " + id);
        }
        productDao.removeById(id);
        return new BaseResponse(true, 0, "Success!");
    }

    @Override
    public BaseResponse updateProduct(ProductUpdate update) {
        Product product = productDao.findById(update.getId()).orElse(null);
        if (product == null) {
            return new BaseResponse(false, 401, "Can't find by id = " + update.getId());
        } else {
            TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(update.getTypeId()).orElseGet(null);
            product.setSku(update.getSku());
            product.setName(update.getName());
            product.setTypeProduct(typeProduct);
            product.setPrice(update.getPrice());
            product.setUrlImage(update.getUrlImage());
            product.setRate(update.getRate());
            product.setDiscount(update.getDiscount());
            product.setViewed(update.getViewed());
            product.setActive(update.isActive());

            productDao.save(product);
            return new BaseResponse(true, 0, "Success!");
        }
    }
}
