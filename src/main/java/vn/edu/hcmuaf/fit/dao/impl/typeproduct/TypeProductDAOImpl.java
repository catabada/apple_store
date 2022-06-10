package vn.edu.hcmuaf.fit.dao.impl.typeproduct;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.typeproduct.TypeProductDAO;
import vn.edu.hcmuaf.fit.database.JDBIConnection;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TypeProductDAOImpl implements TypeProductDAO {

    @Override
    public List<TypeProduct> findAll() {
        return JDBIConnection.get().withHandle(h -> {
            return h.createQuery(QUERY.TYPE_PRODUCT.GET_LIST)
                    .mapToBean(TypeProduct.class)
                    .stream()
                    .collect(Collectors.toList());
        });
    }

    @Override
    public Optional<TypeProduct> findById(Long id) {
        return JDBIConnection.get().withHandle(h -> {
            return h.createQuery(QUERY.TYPE_PRODUCT.GET_BY_ID)
                    .bind(0, id)
                    .mapToBean(TypeProduct.class)
                    .findFirst();
        });
    }

    @Override
    public boolean save(TypeProduct object) {
        if (object.getId() == 0) {
            return JDBIConnection.get().withHandle(h -> {
                return h.createUpdate(QUERY.TYPE_PRODUCT.INSERT)
                        .bind(0, object.getSku())
                        .bind(1, object.getName())
                        .execute();
            }) != -1;
        } else {
            return JDBIConnection.get().withHandle(h -> {
                return h.createUpdate(QUERY.TYPE_PRODUCT.UPDATE)
                        .bind(0, object.getSku())
                        .bind(1, object.getName())
                        .bind(2, object.getId())
                        .execute();
            }) != -1;
        }

    }

    @Override
    public boolean removeById(Long id) {
        return JDBIConnection.get().withHandle(h -> {
            return h.createUpdate(QUERY.TYPE_PRODUCT.DELETE_BY_ID)
                    .bind(0, id)
                    .execute();
        }) != -1;
    }

    @Override
    public Optional<TypeProduct> findBySku(String sku) {
        return JDBIConnection.get().withHandle(h -> {
            return h.createQuery(QUERY.TYPE_PRODUCT.GET_BY_SKU)
                    .bind(0, sku)
                    .mapToBean(TypeProduct.class)
                    .findFirst();
        });
    }

    @Override
    public Optional<TypeProduct> findBySkuExcept(String sku) {
        return JDBIConnection.get().withHandle(h -> {
            return h.createQuery(QUERY.TYPE_PRODUCT.GET_BY_SKU_EXCEPT)
                    .bind(0, sku)
                    .mapToBean(TypeProduct.class)
                    .findFirst();
        });
    }

//    public static void main(String[] args) {
//        TypeProductDAOImpl dao = new TypeProductDAOImpl();
//
//        for(TypeProduct type: dao.findAll()) {
//            System.out.println(type.getSku());
//        }
//    }
}
