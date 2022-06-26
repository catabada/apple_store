package vn.edu.hcmuaf.fit.dao.impl.productoption;

import vn.edu.hcmuaf.fit.constant.DbManager;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.option.OptionDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.productoption.ProductOptionDAO;
import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productoption.ProductOption;

import java.sql.*;
import java.util.*;

public class ProductOptionDAOImpl implements ProductOptionDAO {
    private static ProductOptionDAOImpl instance;
    private Connection connection;


    private ProductOptionDAOImpl() {
    }

    public static ProductOptionDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProductOptionDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ProductOption> findAll() {
        List<ProductOption> productOptions = new ArrayList<ProductOption>();
        connection = DbManager.connectionPool.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_OPTION.GET_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                Long productId = resultSet.getLong("product_id");
                Long optionId = resultSet.getLong("option_id");

                Product product = ProductDAOImpl.getInstance().findById(productId).get();
                Option option = OptionDAOImpl.getInstance().findById(optionId).get();
                ProductOption productOption = new ProductOption(id, sku, name, product, option);
                productOptions.add(productOption);
            }
            DbManager.connectionPool.releaseConnection(connection);
            return productOptions;
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return productOptions;
        }
    }

    @Override
    public Optional<ProductOption> findById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_OPTION.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) return Optional.empty();
            if (resultSet.next()) {
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                Long productId = resultSet.getLong("product_id");
                Long optionId = resultSet.getLong("option_id");

                Product product = ProductDAOImpl.getInstance().findById(productId).get();
                Option option = OptionDAOImpl.getInstance().findById(optionId).get();

                ProductOption productOption = new ProductOption(id, sku, name, product, option);

                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(productOption);
            }
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(ProductOption object) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.PRODUCT_OPTION.INSERT : QUERY.PRODUCT_OPTION.UPDATE);
            statement.setString(1, object.getSku());
            statement.setString(2, object.getName());
            statement.setLong(3, object.getProduct().getId());
            statement.setLong(4, object.getOption().getId());
            if (object.getId() != 0)
                statement.setLong(5, object.getId());
            statement.executeUpdate();
            DbManager.connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void removeById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_OPTION.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            DbManager.connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<ProductOption> findAllByProductId(Long productId) {
        List<ProductOption> productOptions = new ArrayList<ProductOption>();
        connection = DbManager.connectionPool.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_OPTION.GET_LIST_BY_PRODUCT_ID);
            statement.setLong(1, productId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                Long optionId = resultSet.getLong("option_id");

                Product product = ProductDAOImpl.getInstance().findById(productId).get();
                Option option = OptionDAOImpl.getInstance().findById(optionId).get();
                ProductOption productOption = new ProductOption(id, sku, name, product, option);
                productOptions.add(productOption);
            }
            DbManager.connectionPool.releaseConnection(connection);
            return productOptions;
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return productOptions;
        }
    }
}
