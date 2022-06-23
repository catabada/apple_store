package vn.edu.hcmuaf.fit.service.impl.productcolor;

import vn.edu.hcmuaf.fit.dao.color.ColorDAO;
import vn.edu.hcmuaf.fit.dao.impl.color.ColorDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productcolor.ProductColorDAOImpl;
import vn.edu.hcmuaf.fit.dao.product.ProductDAO;
import vn.edu.hcmuaf.fit.dao.productcolor.ProductColorDAO;
import vn.edu.hcmuaf.fit.dto.productcolor.*;
import vn.edu.hcmuaf.fit.mapper.productcolor.ProductColorMapper;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.productcolor.ProductColorService;

import java.util.List;
import java.util.Optional;

public class ProductColorServiceImpl implements ProductColorService {
    private ProductColorDAO productColorDAO;
    private ProductColorMapper productColorMapper;
    private ProductDAO productDAO;
    private ColorDAO colorDAO;

    public ProductColorServiceImpl() {
        this.productColorDAO = ProductColorDAOImpl.getInstance();
        this.productColorMapper = new ProductColorMapper();
        this.productDAO = ProductDAOImpl.getInstance();
        this.colorDAO = ColorDAOImpl.getInstance();
    }

    @Override
    public DataResponse<ProductColorDto> getProductColorById(Long id) {
        Optional<ProductColor> optional = productColorDAO.findById(id);
        return optional.map(productColor -> {
            ProductColorDto productColorDto = productColorMapper.toProductColorDto(productColor);
            return new DataResponse<ProductColorDto>(true, 200, "Success", productColorDto);
        }).orElseGet(() -> new DataResponse<ProductColorDto>(false, 401, "Not found!", null));
    }

    @Override
    public DataResponse<ProductColorDto> getProductColorBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<ProductColorDto> createProductColor(ProductColorCreate create) {
        Product product = productDAO.findById(create.getProductId()).orElse(null);
        Color color = colorDAO.findById(create.getColorId()).orElse(null);
        ProductColor productColor = new ProductColor(product, color, create.getBgImage(), create.getDeImages());
        productColorDAO.save(productColor);
        return new DataResponse<ProductColorDto>(true, 200, "Success!", productColorMapper.toProductColorDto(productColor));
    }

    @Override
    public DataResponse<List<ProductColorDto>> getListProductColor() {
        List<ProductColor> productColors = productColorDAO.findAll();
        return new DataResponse<List<ProductColorDto>>(true, 200, "Success!", productColorMapper.toProductColorDtoList(productColors));
    }

    @Override
    public BaseResponse deleteProductColorById(Long id) {
        Optional<ProductColor> optional = productColorDAO.findById(id);
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        productColorDAO.removeById(id);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public BaseResponse updateProductColor(ProductColorUpdate update) {
        Optional<ProductColor> optional = productColorDAO.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Not found!");
        }
        ProductColor productColor = optional.get();
        Product product = productDAO.findById(update.getProductId()).get();
        Color color = colorDAO.findById(update.getColorId()).get();
        productColor.setProduct(product);
        productColor.setColor(color);
        productColor.setBgImage(update.getBgImage());
        productColor.setDeImages(update.getDeImages());
        productColorDAO.save(productColor);
        return new BaseResponse(true, 200, "Success!");
    }

    @Override
    public DataResponse<List<ProductColorDto>> getListByProductId(Long productId) {
        List<ProductColor> productColors = productColorDAO.findAllByProductId(productId);
        return new DataResponse<List<ProductColorDto>>(true, 200, "Success!", productColorMapper.toProductColorDtoList(productColors));
    }
}
