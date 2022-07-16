package vn.edu.hcmuaf.fit.service.impl.product;

import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.product.ProductDAO;
import vn.edu.hcmuaf.fit.dto.product.*;
import vn.edu.hcmuaf.fit.mapper.product.ProductMapper;
import vn.edu.hcmuaf.fit.constant.Pagination;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;
import vn.edu.hcmuaf.fit.response.BaseResponse;
import vn.edu.hcmuaf.fit.response.DataResponse;
import vn.edu.hcmuaf.fit.service.product.ProductService;

import java.util.*;

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
    public DataResponse<Pagination<ProductDto>> getListProductByTypeProductId(Long typProductId, int pageNumber, String typeSort) {
        List<ProductDto> list = productMapper.toListProductDto(productDao.findAllByTypeProductId(typProductId));
        List<ProductDto> listByPageNumber = new ArrayList<>();
        allSort(typeSort, list);
        for (int i = (pageNumber - 1) * 4; i < (pageNumber - 1) * 4 + 4; i++) {
            if (i < list.size()) {
                listByPageNumber.add(list.get(i));
            }
        }
        int totalPage;
        if (list.size() % Pagination.DEFAULT_PAGE_SIZE == 0) {
            totalPage = list.size() / Pagination.DEFAULT_PAGE_SIZE;
        } else {
            totalPage = list.size() / Pagination.DEFAULT_PAGE_SIZE + 1;
        }
        Pagination<ProductDto> pagination = new Pagination<>(listByPageNumber, pageNumber, totalPage);
        return new DataResponse<Pagination<ProductDto>>(true, 200, "Success!", pagination);
    }

    @Override
    public DataResponse<Pagination<ProductDto>> getListProductByKeyWord(String keyWord, int pageNumber, String typeSort) {
        List<ProductDto> list = productMapper.toListProductDto(productDao.findAllByKeyWord(keyWord));
        List<ProductDto> listByPageNumber = new ArrayList<>();
        allSort(typeSort, list);
        for (int i = (pageNumber - 1) * 4; i < (pageNumber - 1) * 4 + 4; i++) {
            if (i < list.size()) {
                listByPageNumber.add(list.get(i));
            }
        }
        int totalPage;
        if (list.size() % Pagination.DEFAULT_PAGE_SIZE == 0) {
            totalPage = list.size() / Pagination.DEFAULT_PAGE_SIZE;
        } else {
            totalPage = list.size() / Pagination.DEFAULT_PAGE_SIZE + 1;
        }
        Pagination<ProductDto> pagination = new Pagination<>(listByPageNumber, pageNumber, totalPage);
        return new DataResponse<Pagination<ProductDto>>(true, 200, "Success!", pagination);
    }

    @Override
    public DataResponse<Pagination<ProductDto>> getListProductByPageNumber(int pageNumber, String typeSort) {
        List<ProductDto> listAll = productMapper.toListProductDto(productDao.findAll());
        List<ProductDto> listByPageNumber = new ArrayList<>();
        allSort(typeSort, listAll);
        for (int i = (pageNumber - 1) * Pagination.DEFAULT_PAGE_SIZE; i < (pageNumber - 1) * Pagination.DEFAULT_PAGE_SIZE + Pagination.DEFAULT_PAGE_SIZE; i++) {
            if (i < listAll.size()) {
                listByPageNumber.add(listAll.get(i));
            }
        }
        int totalPage;
        if (listAll.size() % Pagination.DEFAULT_PAGE_SIZE == 0) {
            totalPage = listAll.size() / Pagination.DEFAULT_PAGE_SIZE;
        } else {
            totalPage = listAll.size() / Pagination.DEFAULT_PAGE_SIZE + 1;
        }
        Pagination<ProductDto> pagination = new Pagination<>(listByPageNumber, pageNumber, totalPage);
        return new DataResponse<Pagination<ProductDto>>(true, 200, "Success!", pagination);
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
        return new DataResponse<List<ProductDto>>(true, 200, "Success!", list);
    }

    @Override
    public BaseResponse deleteProductById(Long id) {
        if (!productDao.findById(id).isPresent()) {
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
            product.setDiscount(update.getDiscount());
            product.setRate(update.getRate());
            product.setViewed(update.getViewed());
            product.setActive(update.isActive());

            productDao.save(product);
            return new BaseResponse(true, 0, "Success!");
        }
    }

    private void allSort(String type, List<ProductDto> listProduct) {
        switch (type) {
            case "price-up":
                Collections.sort(listProduct, new Comparator<ProductDto>() {
                    @Override
                    public int compare(ProductDto o1, ProductDto o2) {
                        int price1 = (int) (o1.getPrice() - o1.getPrice() * o1.getDiscount());
                        int price2 = (int) (o2.getPrice() - o2.getPrice() * o2.getDiscount());
                        return price1 - price2;
                    }
                });
                break;
            case "price-down":
                Collections.sort(listProduct, new Comparator<ProductDto>() {
                    @Override
                    public int compare(ProductDto o1, ProductDto o2) {
                        int price1 = (int) (o1.getPrice() - o1.getPrice() * o1.getDiscount());
                        int price2 = (int) (o2.getPrice() - o2.getPrice() * o2.getDiscount());
                        return price2 - price1;
                    }
                });
                break;
            case "new":
                Collections.sort(listProduct, new Comparator<ProductDto>() {
                    @Override
                    public int compare(ProductDto o1, ProductDto o2) {
                        return o2.getDateCreated().compareTo(o1.getDateCreated());
                    }
                });
                break;
            case "old":
                Collections.sort(listProduct, new Comparator<ProductDto>() {
                    @Override
                    public int compare(ProductDto o1, ProductDto o2) {
                        return o1.getDateCreated().compareTo(o2.getDateCreated());
                    }
                });
                break;
            case "none":
                break;
        }
    }
}
