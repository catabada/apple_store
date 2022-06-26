package vn.edu.hcmuaf.fit.dao.impl.productdetail;

import vn.edu.hcmuaf.fit.constant.DbManager;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productcolor.ProductColorDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productoption.ProductOptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.productdetail.ProductDetailDAO;
import vn.edu.hcmuaf.fit.database.*;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class ProductDetailDAOImpl implements ProductDetailDAO {
    private static ProductDetailDAOImpl instance;
    private Connection connection;

    private ProductDetailDAOImpl() {
    }

    public static ProductDetailDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProductDetailDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ProductDetail> findAll() {
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long productId = rs.getLong("product_id");
                Long productColorId = rs.getLong("product_color_id");
                Long productOptionId = rs.getLong("product_option_id");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);

                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return null;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return productDetails;
    }

    @Override
    public Optional<ProductDetail> findById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long productId = rs.getLong("product_id");
                Long productColorId = rs.getLong("product_color_id");
                Long productOptionId = rs.getLong("product_option_id");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);
                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(ProductDetail object) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.PRODUCT_DETAIL.INSERT : QUERY.PRODUCT_DETAIL.UPDATE);
            statement.setString(1, object.getSku());
            statement.setString(2, object.getName());
            statement.setLong(3, object.getProduct().getId());
            statement.setLong(4, object.getProductColor().getId());
            statement.setLong(5, object.getProductOption().getId());
            statement.setInt(6, object.getPrice());
            statement.setInt(7, object.getAmount());
            if (object.getId() != 0) {
                statement.setBoolean(8, object.isActive());
                statement.setLong(9, object.getId());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public void removeById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public boolean checkExistColorAndOption(Long productColorId, Long productOptionId) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.CHECK_COLOR_AND_OPTION);
            statement.setLong(1, productColorId);
            statement.setLong(2, productOptionId);
            ResultSet rs = statement.executeQuery();
            return rs.isBeforeFirst() || rs.getRow() != 0;
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return false;
        }
    }

    @Override
    public List<ProductDetail> findAllByProductId(Long productId) {
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_LIST_BY_PRODUCT_ID);
            statement.setLong(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long productColorId = rs.getLong("product_color_id");
                Long productOptionId = rs.getLong("product_option_id");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);

                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return null;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return productDetails;
    }

    @Override
    public List<ProductDetail> findAllByProductColorId(Long productColorId) {
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_LIST_BY_PRODUCT_COLOR_ID);
            statement.setLong(1, productColorId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long productId = rs.getLong("product_id");
                Long productOptionId = rs.getLong("product_option_id");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);

                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return null;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return productDetails;
    }

    @Override
    public List<ProductDetail> findAllByProductOptionId(Long productOptionId) {
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_LIST_BY_PRODUCT_OPTION_ID);
            statement.setLong(1, productOptionId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long productId = rs.getLong("product_id");
                Long productColorId = rs.getLong("product_color_id");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);

                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return null;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return productDetails;
    }

    @Override
    public Optional<ProductDetail> findByProductIdAndProductColorIdAndProductOptionId(Long productId, Long productColorId, Long productOptionId) {
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_DETAIL.GET_LIST_BY_PRODUCT_ID_AND_PRODUCT_COLOR_ID_AND_PRODUCT_OPTION_ID);
            statement.setLong(1, productId);
            statement.setLong(2, productColorId);
            statement.setLong(3, productOptionId);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Integer price = rs.getInt("price");
                Integer amount = rs.getInt("amount");
                Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("created_at"));
                Date updatedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("updated_at"));
                boolean active = rs.getBoolean("active");

                Product product = ProductDAOImpl.getInstance().findById(productId).orElse(null);
                ProductColor productColor = ProductColorDAOImpl.getInstance().findById(productColorId).orElse(null);
                ProductOption productOption = ProductOptionDAOImpl.getInstance().findById(productOptionId).orElse(null);

                ProductDetail productDetail = new ProductDetail(id, sku, name, product, productColor, productOption, price, amount, createdAt, updatedAt, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(productDetail);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }
}
