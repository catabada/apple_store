package vn.edu.hcmuaf.fit.dao.impl.product;

import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import vn.edu.hcmuaf.fit.constant.DbManager;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.product.ProductDAO;
import vn.edu.hcmuaf.fit.dao.typeproduct.TypeProductDAO;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

public class ProductDAOImpl implements ProductDAO {
    private static ProductDAOImpl instance;
    private Connection connection;

    private ProductDAOImpl() {
    }

    public static ProductDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProductDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String urlImage = rs.getString("url_image");
                Long typeProductId = rs.getLong("type_id");
                Integer price = rs.getInt("price");
                Double discount = rs.getDouble("discount");
                Integer rate = rs.getInt("rate");
                Integer viewed = rs.getInt("viewed");
                Date dateUpdated = rs.getDate("date_created");
                Date lastUpdated = rs.getDate("last_updated");
                boolean active = rs.getBoolean("active");

                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(typeProductId).orElseGet(null);
                Product product = new Product(id, sku, name, typeProduct, price, urlImage, rate, discount, viewed, dateUpdated, lastUpdated, active);
                products.add(product);
            }

        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return products;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String urlImage = rs.getString("url_image");
                long typeProductId = rs.getLong("type_id");
                Integer price = rs.getInt("price");
                Double discount = rs.getDouble("discount");
                Integer rate = rs.getInt("rate");
                Integer viewed = rs.getInt("viewed");
                Date dateCreated = rs.getDate("date_created");
                Date lastUpdated = rs.getDate("last_updated");
                boolean active = rs.getBoolean("active");

                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(typeProductId).orElseGet(null);
                Product product = new Product(id, sku, name, typeProduct, price, urlImage, rate, discount, viewed, dateCreated, lastUpdated, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(product);
            }
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        DbManager.connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public void save(Product object) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.PRODUCT.INSERT : QUERY.PRODUCT.UPDATE);
            statement.setString(1, object.getSku());
            statement.setString(2, object.getName());
            statement.setLong(3, object.getTypeProduct().getId());
            statement.setInt(4, object.getPrice());
            statement.setString(5, object.getUrlImage());
            statement.setDouble(6, object.getDiscount());
            if (object.getId() != 0) {
                statement.setInt(7, object.getRate());
                statement.setInt(8, object.getViewed());
                statement.setBoolean(9, object.isActive());
                statement.setLong(10, object.getId());
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return;
        }
        DbManager.connectionPool.releaseConnection(connection);

    }

    @Override
    public void removeById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            DbManager.connectionPool.releaseConnection(connection);
            return;
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public void findBySku(String sku) {

    }

    @Override
    public List<Product> findAllByTypeProductId(Long typeProductId) {
        List<Product> products = new ArrayList<Product>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT.GET_LIST_BY_TYPE_PRODUCT_ID);
            statement.setLong(1, typeProductId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String urlImage = rs.getString("url_image");
                Integer price = rs.getInt("price");
                Double discount = rs.getDouble("discount");
                Integer rate = rs.getInt("rate");
                Integer viewed = rs.getInt("viewed");
                Date dateUpdated = rs.getDate("date_created");
                Date lastUpdated = rs.getDate("last_updated");
                boolean active = rs.getBoolean("active");

                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(typeProductId).orElseGet(null);
                Product product = new Product(id, sku, name, typeProduct, price, urlImage, rate, discount, viewed, dateUpdated, lastUpdated, active);
                products.add(product);
            }

        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return products;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return products;
    }

    @Override
    public List<Product> findAllByKeyWord(String keyWord) {
        List<Product> products = new ArrayList<Product>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT.GET_LIST_BY_KEY_WORD);
            statement.setString(1, "%" + keyWord + "%");
            System.out.println("%" + keyWord + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                Long typeProductId = rs.getLong("type_id");
                String urlImage = rs.getString("url_image");
                Integer price = rs.getInt("price");
                Double discount = rs.getDouble("discount");
                Integer rate = rs.getInt("rate");
                Integer viewed = rs.getInt("viewed");
                Date dateUpdated = rs.getDate("date_created");
                Date lastUpdated = rs.getDate("last_updated");
                boolean active = rs.getBoolean("active");

                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(typeProductId).orElseGet(null);
                Product product = new Product(id, sku, name, typeProduct, price, urlImage, rate, discount, viewed, dateUpdated, lastUpdated, active);
                products.add(product);
            }

        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return products;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return products;
    }

}
