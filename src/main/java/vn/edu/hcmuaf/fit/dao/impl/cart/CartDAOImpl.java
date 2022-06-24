package vn.edu.hcmuaf.fit.dao.impl.cart;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.cart.CartDAO;
import vn.edu.hcmuaf.fit.dao.impl.user.UserDAOImpl;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.cart.Cart;
import vn.edu.hcmuaf.fit.model.user.User;

import java.sql.*;
import java.util.*;

public class CartDAOImpl implements CartDAO {
    private IConnectionPool connectionPool;
    private Connection connection;
    private static CartDAOImpl instance;

    private CartDAOImpl() {
        this.connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static CartDAOImpl getInstance() {
        if (instance == null) {
            instance = new CartDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Cart> findAll() {
        connection = connectionPool.getConnection();
        List<Cart> carts = new ArrayList<Cart>();

        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.CART.GET_LIST);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Long userId = resultSet.getLong("user_id");

                User user = UserDAOImpl.getInstance().findById(userId).orElse(null);

                Cart cart = new Cart(id, user);
                carts.add(cart);
            }
            connectionPool.releaseConnection(connection);
            return carts;
        } catch (SQLException e) {
            e.printStackTrace();
            connectionPool.releaseConnection(connection);
            return carts;
        }
    }

    @Override
    public Optional<Cart> findById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.CART.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) return Optional.empty();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("user_id");

                User user = UserDAOImpl.getInstance().findById(userId).orElse(null);

                Cart cart = new Cart(id, user);

                connectionPool.releaseConnection(connection);
                return Optional.of(cart);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public void save(Cart object) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.CART.INSERT : QUERY.CART.UPDATE);
            statement.setLong(1, object.getUser().getId());
            if (object.getId() != 0)
                statement.setLong(2, object.getId());
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
            PreparedStatement statement = connection.prepareStatement(QUERY.CART.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
    }
}
