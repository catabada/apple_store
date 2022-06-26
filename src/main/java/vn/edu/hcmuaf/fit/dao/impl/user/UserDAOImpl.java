package vn.edu.hcmuaf.fit.dao.impl.user;

import vn.edu.hcmuaf.fit.constant.DbManager;
import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.user.UserDAO;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.model.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private static UserDAOImpl instance;
    private Connection connection;


    private UserDAOImpl() {
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
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer role = rs.getInt("role");
                Date createdDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date_created"));
                boolean active = rs.getBoolean("active");
                User user = new User(id, username, password, firstName, lastName, phone, email, address, role, createdDate, active);
                users.add(user);
            }

        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return users;
        }
        DbManager.connectionPool.releaseConnection(connection);
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer role = rs.getInt("role");
                Date createdDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date_created"));
                boolean active = rs.getBoolean("active");
                User user = new User(id, username, password, firstName, lastName, phone, email, address, role, createdDate, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(user);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        DbManager.connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public void save(User object) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.USER.INSERT : QUERY.USER.UPDATE);
            statement.setString(1, object.getUsername());
            statement.setString(2, object.getPassword());
            statement.setString(3, object.getFirstName());
            statement.setString(4, object.getLastName());
            statement.setString(5, object.getPhone());
            statement.setString(6, object.getEmail());
            statement.setString(7, object.getAddress());

            if (object.getId() != 0) {
                statement.setBoolean(8, object.isActive());
                statement.setInt(9, object.getRole());
                statement.setLong(10, object.getId());

            }
            statement.executeUpdate();
            DbManager.connectionPool.releaseConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            DbManager.connectionPool.releaseConnection(connection);
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public void removeById(Long id) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            DbManager.connectionPool.releaseConnection(connection);
        }
        DbManager.connectionPool.releaseConnection(connection);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void signUp(User user) {
        save(user);
    }

    @Override
    public Optional<User> signIn(String username, String password) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.SIGN_IN);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer role = rs.getInt("role");
                Date createdDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date_created"));
                boolean active = rs.getBoolean("active");
                User user = new User(id, username, password, firstName, lastName, phone, email, address, role, createdDate, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(user);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        DbManager.connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public Optional<User> checkUsername(String username) {
        connection = DbManager.connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.USER.CHECK_USERNAME);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                Long id = rs.getLong("id");
                String password = rs.getString("password");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Integer role = rs.getInt("role");
                Date createdDate = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("date_created"));
                boolean active = rs.getBoolean("active");
                User user = new User(id, username, password, firstName, lastName, phone, email, address, role, createdDate, active);
                DbManager.connectionPool.releaseConnection(connection);
                return Optional.of(user);
            }
        } catch (Exception e) {
            DbManager.connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        DbManager.connectionPool.releaseConnection(connection);
        return Optional.empty();
    }
}