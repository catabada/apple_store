package vn.edu.hcmuaf.fit.service.impl.option;

import vn.edu.hcmuaf.fit.dao.impl.option.OptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.option.OptionDAO;
import vn.edu.hcmuaf.fit.dto.option.*;
import vn.edu.hcmuaf.fit.mapper.option.OptionMapper;
import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.option.OptionService;

import java.util.List;
import java.util.Optional;

public class OptionServiceImpl implements OptionService {
    private OptionDAO optionDao;
    private OptionMapper optionMapper;

    public OptionServiceImpl() {
        this.optionDao = OptionDAOImpl.getInstance();
        this.optionMapper = new OptionMapper();
    }

    @Override
    public DataResponse<OptionDto> getOptionById(Long id) {
        Optional<Option> optional = optionDao.findById(id);
        return optional.map(option -> {
            OptionDto optionDto = optionMapper.toOptionDto(option);
            return new DataResponse<OptionDto>(true, 200, "Success", optionDto);
        }).orElseGet(() -> new DataResponse<OptionDto>(false, 401, "Option not found", null));


//        Option option = optionDao.findById(id).orElse(null);
//        if (option == null) {
//            return new DataResponse<OptionDto>(false, 401, "Option not found", null);
//        }
//        return new DataResponse<OptionDto>(true, 200, "Success", optionMapper.toOptionDto(option));
    }

    @Override
    public DataResponse<OptionDto> getOptionBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<OptionDto> getOptionByName(String name) {
        return null;
    }

    @Override
    public DataResponse<OptionDto> createOption(OptionCreate create) {
        TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(create.getTypeProductId()).orElse(null);
        Option option = new Option(create.getSku(), create.getName(), typeProduct);
        optionDao.save(option);
        return new DataResponse<OptionDto>(true, 200, "Success", optionMapper.toOptionDto(option));
    }

    @Override
    public DataResponse<List<OptionDto>> getListOption() {
        List<Option> options = optionDao.findAll();
        return new DataResponse<List<OptionDto>>(true, 200, "Success!", optionMapper.toOptionDtoList(options));
    }

    @Override
    public DataResponse<List<OptionDto>> getListOptionByTypeProductId(Long productId) {
        Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
        List<Option> options = optionDao.findAllByTypeProductId(product.getTypeProduct().getId());
        return new DataResponse<List<OptionDto>>(true, 200, "Success!", optionMapper.toOptionDtoList(options));
    }

    @Override
    public BaseResponse deleteOptionById(Long id) {
        if (!optionDao.findById(id).isPresent()) {
            return new BaseResponse(false, 401, "Option not found");
        }
        optionDao.removeById(id);
        return new BaseResponse(true, 200, "Success");
    }

    @Override
    public BaseResponse updateOption(OptionUpdate update) {
        Optional<Option> optional = optionDao.findById(update.getId());
        if (!optional.isPresent()) {
            return new BaseResponse(false, 401, "Option not found");
        } else {
            Option option = optional.get();
            TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(update.getTypeProductId()).orElse(null);
            option.setSku(update.getSku());
            option.setName(update.getName());
            option.setTypeProduct(typeProduct);
            optionDao.save(option);
            return new BaseResponse(true, 200, "Success");
        }
    }
}
