package vn.edu.hcmuaf.fit.dao.impl.user;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.impl.typeproduct.TypeProductDAOImpl;
import vn.edu.hcmuaf.fit.dao.user.UserDAO;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.database.*;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.color.Color;
import vn.edu.hcmuaf.fit.model.product.Product;
import vn.edu.hcmuaf.fit.model.typeproduct.TypeProduct;
import vn.edu.hcmuaf.fit.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO{
    private final IConnectionPool connectionPool;
    private static UserDAOImpl instance;
    private Connection connection;


    public UserDAOImpl() {
        this.connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            instance = new UserDAOImpl();
        }
        return instance;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("user_name");
                String password = rs.getString("password");
                boolean active = rs.getBoolean("active");
                Date dateUpdated = rs.getDate("date_created");
                String role = rs.getString("role");
                String sku = rs.getString("sku");
                User user = new User(id, username, password, active, dateUpdated, role, sku);
                users.add(user);
            }

        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return users;
        }
        connectionPool.releaseConnection(connection);
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                Long idUser = rs.getLong("id");
                String username = rs.getString("user_name");
                String password = rs.getString("password");
                boolean active = rs.getBoolean("active");
                Date dateUpdated = rs.getDate("date_created");
                String role = rs.getString("role");
                String sku = rs.getString("sku");

                User user = new User(idUser, username, password, active, dateUpdated, role, sku);
                connectionPool.releaseConnection(connection);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public void save(User object) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.USER.INSERT : QUERY.USER.UPDATE);
            statement.setString(1, object.getName());
            statement.setString(2, object.getPassword());
            statement.setString(3, object.getRole());
            if (object.getId() != 0) {
                statement.setBoolean(4, object.isActive());
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
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
        connectionPool.releaseConnection(connection);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }
}
