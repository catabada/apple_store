package vn.edu.hcmuaf.fit.service.impl.typeproduct;

import vn.edu.hcmuaf.fit.dao.typeproduct.TypeProductDAO;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.mapper.typeproduct.TypeProductMapper;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.dto.typeproduct.*;
import vn.edu.hcmuaf.fit.service.typeproduct.TypeProductService;

import java.util.List;
import java.util.Optional;

public class TypeProductServiceImpl implements TypeProductService {
    private TypeProductDAO dao;
    private TypeProductMapper mapper;

    public TypeProductServiceImpl() {
        dao = new TypeProductDAOImpl();
        mapper = new TypeProductMapper();
    }

    @Override
    public DataResponse<List<TypeProductDto>> getTypeProductList() {
        return new DataResponse<>(true, 200, "Success", mapper.toListTypeProductDto(dao.findAll()));
    }

    @Override
    public DataResponse<TypeProductDto> getTypeProduct(Long id) {
        Optional<TypeProduct> optional = dao.findById(id);
        return optional.map(
                        typeProduct -> new DataResponse<>(true, 200, "Success", mapper.toTypeProductDto(typeProduct)))
                .orElseGet(() -> new DataResponse<>(false, 401, "Can't find by id = " + id, null));
    }

    @Override
    public DataResponse<TypeProductDto> getTypeProductBySku(String sku) {
        return null;
    }

    @Override
    public DataResponse<TypeProductDto> getTypeProductByName(String name) {
        return null;
    }

    @Override
    public DataResponse<TypeProductDto> createTypeProduct(TypeProductCreate create) {
        if (dao.findBySku(create.getSku()).isPresent()) {
            return new DataResponse<>(false, 401, "Sku already exists", null);
        } else {
            TypeProduct typeProduct = new TypeProduct(create.getSku(), create.getName());
            dao.save(typeProduct);
            TypeProductDto dto = mapper.toTypeProductDto((typeProduct));
            return new DataResponse<>(true, 0, "Success!", dto);
        }
    }

    @Override
    public BaseResponse updateTypeProduct(TypeProductUpdate update) {
        TypeProduct typeProduct = dao.findById(update.getId()).orElse(null);
        if (typeProduct == null) {
            return new BaseResponse(false, 401, "Can't find by id = " + update.getId());
        } else {
            if (typeProduct.getSku().equals(update.getSku())) {
                typeProduct.setSku(update.getSku());
                typeProduct.setName(update.getName());
                typeProduct.setActive(update.isActive());
                dao.save(typeProduct);
                return new BaseResponse(true, 200, "Success!");
            } else {
                if (dao.findBySku(update.getSku()).isPresent()) {
                    return new BaseResponse(false, 401, "Sku already exists");
                } else {
                    typeProduct.setSku(update.getSku());
                    typeProduct.setName(update.getName());
                    typeProduct.setActive(update.isActive());
                    dao.save(typeProduct);
                    return new BaseResponse(true, 200, "Success!");
                }
            }
        }
    }

    @Override
    public BaseResponse deleteTypeProduct(Long id) {
        TypeProduct typeProduct = dao.findById(id).orElse(null);
        if (typeProduct == null) {
            return new BaseResponse(false, 401, "Can't find by id = " + id);
        } else {
            dao.removeById(id);
            return new BaseResponse(true, 200, "Success!");
        }
    }

    @Override
    public DataResponse<TypeProductDto> updateStatus(Long id) {
        return null;
    }
}
