package vn.edu.hcmuaf.fit.dao.impl.productcolor;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.color.ColorDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.product.ProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.productcolor.ProductColorDAO;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.productcolor.ProductColor;

import java.sql.*;
import java.util.*;

import vn.edu.hcmuaf.fit.database.*;

public class ProductColorDAOImpl implements ProductColorDAO {
    private static ProductColorDAOImpl instance;
    private IConnectionPool connectionPool;
    private Connection connection;

    private ProductColorDAOImpl() {
        this.connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static ProductColorDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProductColorDAOImpl();
        }
        return instance;
    }

    @Override
    public List<ProductColor> findAll() {
        List<ProductColor> productColors = new ArrayList<ProductColor>();
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_COLOR.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String bgImage = rs.getString("bg_image");
                String deImages = rs.getString("de_images");

                Product product = ProductDAOImpl.getInstance().findById(rs.getLong("product_id")).orElse(null);
                Color color = ColorDAOImpl.getInstance().findById(rs.getLong("color_id")).orElse(null);

                ProductColor productColor = new ProductColor(id, product, color, bgImage, deImages);
                productColors.add(productColor);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return null;
        }

        connectionPool.releaseConnection(connection);
        return productColors;
    }

    @Override
    public Optional<ProductColor> findById(Long id) {

        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_COLOR.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                String bgImage = rs.getString("bg_image");
                String deImages = rs.getString("de_images");

                Product product = ProductDAOImpl.getInstance().findById(rs.getLong("product_id")).orElse(null);
                Color color = ColorDAOImpl.getInstance().findById(rs.getLong("color_id")).orElse(null);

                ProductColor productColor = new ProductColor(id, product, color, bgImage, deImages);
                connectionPool.releaseConnection(connection);
                return Optional.of(productColor);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }

        connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public void save(ProductColor object) {
        connection = connectionPool.getConnection();
        System.out.println(object.getDeImages() + "" + object.getBgImage());
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.PRODUCT_COLOR.INSERT : QUERY.PRODUCT_COLOR.UPDATE);
            statement.setLong(1, object.getProduct().getId());
            statement.setLong(2, object.getColor().getId());
            statement.setString(3, object.getBgImage());
            statement.setString(4, object.getDeImages());
            System.out.println(object.getDeImages());
            if (object.getId() != 0) {
                statement.setLong(5, object.getId());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
        connectionPool.releaseConnection(connection);
    }

    @Override
    public void removeById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_COLOR.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
        connectionPool.releaseConnection(connection);
    }

    @Override
    public List<ProductColor> findAllByProductId(Long productId) {
        List<ProductColor> productColors = new ArrayList<ProductColor>();
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.PRODUCT_COLOR.GET_LIST_BY_PRODUCT_ID);
            statement.setLong(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String bgImage = rs.getString("bg_image");
                String deImages = rs.getString("de_images");

                Product product = ProductDAOImpl.getInstance().findById(rs.getLong("product_id")).orElse(null);
                Color color = ColorDAOImpl.getInstance().findById(rs.getLong("color_id")).orElse(null);

                ProductColor productColor = new ProductColor(id, product, color, bgImage, deImages);
                productColors.add(productColor);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return null;
        }

        connectionPool.releaseConnection(connection);
        return productColors;
    }
}
