package vn.edu.hcmuaf.fit.service.impl.productoption;

import vn.edu.hcmuaf.fit.dao.impl.option.OptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productoption.ProductOptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.productoption.ProductOptionDAO;
import vn.edu.hcmuaf.fit.dto.productcolor.ProductColorDto;
import vn.edu.hcmuaf.fit.dto.productdetail.ProductDetailDto;
import vn.edu.hcmuaf.fit.dto.productoption.*;
import vn.edu.hcmuaf.fit.mapper.productoption.ProductOptionMapper;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.productoption.ProductOptionService;

import java.util.List;
import java.util.Optional;

public class ProductOptionServiceImpl implements ProductOptionService {
    private ProductOptionDAO productOptionDao;
    private ProductOptionMapper productOptionMapper;

    public ProductOptionServiceImpl() {
        this.productOptionDao = ProductOptionDAOImpl.getInstance();
        this.productOptionMapper = new ProductOptionMapper();
    }

    @Override
    public DataResponse<ProductOptionDto> getProductOptionById(Long id) {
        Optional<ProductOption> optional = productOptionDao.findById(id);
        return optional.map(productOption -> {
            ProductOptionDto productOptionDto = productOptionMapper.toProductOptionDto(productOption);
            return new DataResponse<ProductOptionDto>(true, 200, "Success", productOptionDto);
        }).orElseGet(() -> new DataResponse<ProductOptionDto>(false, 401, "Not found!", null));
    }

    @Override
    public DataResponse<ProductOptionDto> getProductOptionBySku(String sku) {

        return null;
    }

    @Override
    public DataResponse<ProductOptionDto> createProductOption(ProductOptionCreate create) {
        Product product = ProductDAOImpl.getInstance().findById(create.getProductId()).orElse(null);
        Option option = OptionDAOImpl.getInstance().findById(create.getOptionId()).orElse(null);
        ProductOption productOption = new ProductOption(create.getSku(), create.getName(), product, option);
        productOptionDao.save(productOption);
        return new DataResponse<ProductOptionDto>(true, 200, "Success!", productOptionMapper.toProductOptionDto(productOption));
    }

    @Override
    public DataResponse<List<ProductOptionDto>> getListProductOption() {
        List<ProductOption> productOptions = productOptionDao.findAll();
        return new DataResponse<List<ProductOptionDto>>(true, 200, "Success!", productOptionMapper.toProductOptionDtoList(productOptions));
    }

    @Override
    public DataResponse<List<ProductOptionDto>> getListProductOptionByTypeProduct() {
        return null;
    }

    @Override
    public BaseResponse deleteProductOptionById(Long id) {
        Optional<ProductOption> optional = productOptionDao.findById(id);
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        productOptionDao.removeById(id);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public BaseResponse updateProductOption(ProductOptionUpdate update) {
        Optional<ProductOption> optional = productOptionDao.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        ProductOption productOption = optional.get();
        Product product = ProductDAOImpl.getInstance().findById(update.getProductId()).get();
        Option option = OptionDAOImpl.getInstance().findById(update.getOptionId()).get();
        productOption.setName(update.getName());
        productOption.setSku(update.getSku());
        productOption.setOption(option);
        productOption.setProduct(product);
        productOptionDao.save(productOption);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public DataResponse<List<ProductOptionDto>> getListByProductId(Long productId) {
        List<ProductOption> productOptions = productOptionDao.findAllByProductId(productId);
        return new DataResponse<List<ProductOptionDto>>(true, 200, "Success!", productOptionMapper.toProductOptionDtoList(productOptions));
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListByProductColorId(Long productColorId) {
        return null;
    }
}
