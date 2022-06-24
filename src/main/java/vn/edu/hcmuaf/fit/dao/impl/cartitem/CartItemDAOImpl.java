package vn.edu.hcmuaf.fit.dao.impl.cartitem;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.cartitem.CartItemDAO;
import vn.edu.hcmuaf.fit.dao.impl.cart.CartDAOImpl;
import vn.edu.hcmuaf.fit.dao.impl.productdetail.ProductDetailDAOImpl;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.cartitem.CartItem;
import vn.edu.hcmuaf.fit.model.productdetail.ProductDetail;

import java.sql.*;
import java.util.*;

public class CartItemDAOImpl implements CartItemDAO {
    private IConnectionPool connectionPool;
    private Connection connection;
    private static CartItemDAOImpl instance;

    private CartItemDAOImpl() {
        this.connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static CartItemDAOImpl getInstance() {
        if (instance == null) {
            instance = new CartItemDAOImpl();
        }
        return instance;
    }

    @Override
    public List<CartItem> findAll() {
        connection = connectionPool.getConnection();
        List<CartItem> cartItems = new ArrayList<CartItem>();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.CART_ITEM.GET_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long cartId = resultSet.getLong("cart_id");
                Long productDetailId = resultSet.getLong("product_detail_id");
                Integer quantity = resultSet.getInt("quantity");

                Cart cart = CartDAOImpl.getInstance().findById(cartId).orElse(null);
                ProductDetail productDetail = ProductDetailDAOImpl.getInstance().findById(productDetailId).orElse(null);

                CartItem cartItem = new CartItem(id, cart, productDetail, quantity);
                cartItems.add(cartItem);
            }
            connectionPool.releaseConnection(connection);
            return cartItems;
        } catch (SQLException e) {
            e.printStackTrace();
            connectionPool.releaseConnection(connection);
            return cartItems;
        }
    }

    @Override
    public Optional<CartItem> findById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.CART_ITEM.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) return Optional.empty();
            if (resultSet.next()) {
                Long cartId = resultSet.getLong("cart_id");
                Long productDetailId = resultSet.getLong("product_detail_id");
                Integer quantity = resultSet.getInt("quantity");

                Cart cart = CartDAOImpl.getInstance().findById(cartId).orElse(null);
                ProductDetail productDetail = ProductDetailDAOImpl.getInstance().findById(productDetailId).orElse(null);

                CartItem cartItem = new CartItem(id, cart, productDetail, quantity);

                connectionPool.releaseConnection(connection);
                return Optional.of(cartItem);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(CartItem object) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.CART_ITEM.INSERT : QUERY.CART_ITEM.UPDATE);
            statement.setLong(1, object.getCart().getId());
            statement.setLong(2, object.getProductDetail().getId());
            statement.setInt(3, object.getQuantity());
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
            PreparedStatement statement = connection.prepareStatement(QUERY.CART_ITEM.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
    }
}
