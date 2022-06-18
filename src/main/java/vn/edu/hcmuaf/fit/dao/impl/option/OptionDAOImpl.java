package vn.edu.hcmuaf.fit.dao.impl.option;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.option.OptionDAO;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.option.Option;
import vn.edu.hcmuaf.fit.database.*;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.sql.*;
import java.util.*;

public class OptionDAOImpl implements OptionDAO {
    private IConnectionPool connectionPool;
    private static OptionDAOImpl instance;
    private Connection connection;


    private OptionDAOImpl() {
        connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static OptionDAOImpl getInstance() {
        if (instance == null) {
            instance = new OptionDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Option> findAll() {
        connection = connectionPool.getConnection();
        List<Option> options = new ArrayList<Option>();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.OPTION.GET_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(resultSet.getLong("type_product_id")).get();

                Option option = new Option(id, sku, name, typeProduct);
                options.add(option);
            }
            connectionPool.releaseConnection(connection);
            return options;
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return options;
        }
    }

    @Override
    public Optional<Option> findById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.OPTION.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) return Optional.empty();
            if (resultSet.next()) {
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(resultSet.getLong("type_product_id")).get();

                Option option = new Option(id, sku, name, typeProduct);

                connectionPool.releaseConnection(connection);
                return Optional.of(option);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(Option object) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.OPTION.INSERT : QUERY.OPTION.UPDATE);
            statement.setString(1, object.getSku());
            statement.setString(2, object.getName());
            statement.setLong(3, object.getTypeProduct().getId());
            if (object.getId() != 0)
                statement.setLong(4, object.getId());
            statement.executeUpdate();
            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }

    }

    @Override
    public void removeById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.OPTION.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Option> findAllByTypeProductId(Long typeProductId) {
        connection = connectionPool.getConnection();
        List<Option> options = new ArrayList<Option>();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.OPTION.GET_LIST_BY_TYPE_PRODUCT_ID);
            statement.setLong(1, typeProductId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String sku = resultSet.getString("sku");
                String name = resultSet.getString("name");
                TypeProduct typeProduct = TypeProductDAOImpl.getInstance().findById(typeProductId).get();

                Option option = new Option(id, sku, name, typeProduct);
                options.add(option);
            }
            connectionPool.releaseConnection(connection);
            return options;
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return options;
        }
    }
}
