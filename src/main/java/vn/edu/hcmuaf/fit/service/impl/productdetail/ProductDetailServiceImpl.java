package vn.edu.hcmuaf.fit.service.impl.productdetail;

import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productcolor.ProductColorDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productdetail.ProductDetailDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productoption.ProductOptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.productdetail.ProductDetailDAO;
import vn.edu.hcmuaf.fit.dto.productdetail.*;
import vn.edu.hcmuaf.fit.mapper.productdetail.ProductDetailMapper;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.productdetail.ProductDetailService;

import java.util.List;
import java.util.Optional;

public class ProductDetailServiceImpl implements ProductDetailService {
    private ProductDetailDAO productDetailDao;
    private ProductDetailMapper productDetailMapper;

    public ProductDetailServiceImpl() {
        this.productDetailDao = ProductDetailDAOImpl.getInstance();
        this.productDetailMapper = new ProductDetailMapper();
    }

    @Override
    public DataResponse<ProductDetailDto> getProductDetailById(Long id) {
        Optional<ProductDetail> optional = productDetailDao.findById(id);
        return optional.map(productDetail -> {
            ProductDetailDto productOptionDto = productDetailMapper.toProductDetailDto(productDetail);
            return new DataResponse<ProductDetailDto>(true, 200, "Success", productOptionDto);
        }).orElseGet(() -> new DataResponse<ProductDetailDto>(false, 401, "Not found!", null));
    }

    @Override
    public DataResponse<ProductDetailDto> getProductDetailBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<ProductDetailDto> getProductDetailByProductIdAndProductColorIdAndProductOptionId(Long productId, Long productColorId, Long productOptionId) {
        Optional<ProductDetail> optional = productDetailDao.findByProductIdAndProductColorIdAndProductOptionId(productId, productColorId, productOptionId);
        return optional.map(productDetail -> {
            ProductDetailDto productOptionDto = productDetailMapper.toProductDetailDto(productDetail);
            return new DataResponse<ProductDetailDto>(true, 200, "Success", productOptionDto);
        }).orElseGet(() -> new DataResponse<ProductDetailDto>(false, 401, "Not found!", null));
    }

    @Override
    public DataResponse<ProductDetailDto> createProductDetail(ProductDetailCreate create) {
        if (!productDetailDao.checkExistColorAndOption(create.getProductColorId(), create.getProductOptionId())) {
            Product product = ProductDAOImpl.getInstance().findById(create.getProductId()).orElse(null);
            ProductColor productColor = ProductColorDAOImpl.getInstance().findById(create.getProductColorId()).orElse(null);
            ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(create.getProductOptionId()).orElse(null);
            String sku = product.getSku() + productColor.getColor().getSku() + productOption.getSku();
            String name = product.getName() + " " + productColor.getColor().getName() + " " + productOption.getName();
            ProductDetail productDetail = new ProductDetail(sku, name, product, productColor, productOption, create.getPrice(), create.getAmount());
            productDetailDao.save(productDetail);
            return new DataResponse<ProductDetailDto>(true, 200, "Success!", productDetailMapper.toProductDetailDto(productDetail));
        } else {
            return new DataResponse<ProductDetailDto>(false, 401, "Duplicate color and option!", null);
        }
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListProductDetail() {
        List<ProductDetail> productDetails = productDetailDao.findAll();
        List<ProductDetailDto> productDetailDtos = productDetailMapper.toProductDetailDtoList(productDetails);
        return new DataResponse<List<ProductDetailDto>>(true, 200, "Success!", productDetailDtos);
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListProductDetailByTypeProduct() {
        return null;
    }

    @Override
    public BaseResponse deleteProductDetailById(Long id) {
        Optional<ProductDetail> optional = productDetailDao.findById(id);
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        productDetailDao.removeById(id);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public BaseResponse updateProductDetail(ProductDetailUpdate update) {
        Optional<ProductDetail> optional = productDetailDao.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        ProductDetail productDetail = optional.get();
        Product product = ProductDAOImpl.getInstance().findById(update.getProductId()).get();
        ProductColor productColor = ProductColorDAOImpl.getInstance().findById(update.getProductColorId()).get();
        ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(update.getProductOptionId()).get();
        productDetail.setSku(update.getSku());
        productDetail.setName(update.getName());
        productDetail.setPrice(update.getPrice());
        productDetail.setProduct(product);
        productDetail.setProductColor(productColor);
        productDetail.setProductOption(productOption);
        productDetail.setAmount(update.getAmount());
        productDetail.setActive(update.isActive());
        productDetailDao.save(productDetail);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListByProductId(Long productId) {
        List<ProductDetail> productDetails = productDetailDao.findAllByProductId(productId);
        List<ProductDetailDto> productDetailDtos = productDetailMapper.toProductDetailDtoList(productDetails);
        return new DataResponse<List<ProductDetailDto>>(true, 200, "Success!", productDetailDtos);
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListByProductColorId(Long productColorId) {
        List<ProductDetail> productDetails = productDetailDao.findAllByProductColorId(productColorId);
        List<ProductDetailDto> productDetailDtos = productDetailMapper.toProductDetailDtoList(productDetails);
        return new DataResponse<List<ProductDetailDto>>(true, 200, "Success!", productDetailDtos);
    }

    @Override
    public DataResponse<List<ProductDetailDto>> getListByProductOptionId(Long productOptionId) {
        List<ProductDetail> productDetails = productDetailDao.findAllByProductOptionId(productOptionId);
        List<ProductDetailDto> productDetailDtos = productDetailMapper.toProductDetailDtoList(productDetails);
        return new DataResponse<List<ProductDetailDto>>(true, 200, "Success!", productDetailDtos);
    }


}
