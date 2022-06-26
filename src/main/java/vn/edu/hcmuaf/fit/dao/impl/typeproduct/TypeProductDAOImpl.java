package vn.edu.hcmuaf.fit.dao.impl.typeproduct;

import vn.edu.hcmuaf.fit.constant.DbManager;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.typeproduct.TypeProductDAO;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;

import java.sql.*;
import java.util.*;

public class TypeProductDAOImpl implements TypeProductDAO {
    private static TypeProductDAOImpl instance;
    private Connection connection;


    private TypeProductDAOImpl() {
    }

    public static TypeProductDAOImpl getInstance() {
        if (instance == null) {
            instance = new TypeProductDAOImpl();
        }
        return instance;
    }

    @Override
    public List<TypeProduct> findAll() {
        List<TypeProduct> typeProducts = new ArrayList<TypeProduct>();
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.TYPE_PRODUCT.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                boolean active = rs.getBoolean("active");
                TypeProduct typeProduct = new TypeProduct(id, sku, name, active);
                typeProducts.add(typeProduct);
            }
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return null;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return typeProducts;
    }

    @Override
    public Optional<TypeProduct> findById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.TYPE_PRODUCT.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                boolean active = rs.getBoolean("active");
                TypeProduct typeProduct = new TypeProduct(id, sku, name, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(typeProduct);
            }
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(TypeProduct typeProduct) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(typeProduct.getId() == 0 ? QUERY.TYPE_PRODUCT.INSERT : QUERY.TYPE_PRODUCT.UPDATE);
            statement.setString(1, typeProduct.getSku());
            statement.setString(2, typeProduct.getName());
            if (typeProduct.getId() != 0) {
                statement.setBoolean(3, typeProduct.isActive());
                statement.setLong(4, typeProduct.getId());
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
            PreparedStatement statement = connection.prepareStatement(QUERY.TYPE_PRODUCT.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public Optional<TypeProduct> findBySku(String sku) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.TYPE_PRODUCT.GET_BY_SKU);
            statement.setString(1, sku);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                boolean active = rs.getBoolean("active");
                TypeProduct typeProduct = new TypeProduct(id, sku, name, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(typeProduct);
            }
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public Optional<TypeProduct> findBySkuExcept(String sku) {
        return Optional.ofNullable(null);
    }

}
