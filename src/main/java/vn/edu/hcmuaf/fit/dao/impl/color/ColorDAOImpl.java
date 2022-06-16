package vn.edu.hcmuaf.fit.dao.impl.color;

import vn.edu.hcmuaf.fit.constant.QUERY;
import vn.edu.hcmuaf.fit.dao.color.ColorDAO;
import vn.edu.hcmuaf.fit.database.DbConnection;
import vn.edu.hcmuaf.fit.database.IConnectionPool;
import vn.edu.hcmuaf.fit.model.color.Color;

import java.sql.*;
import java.util.*;

public class ColorDAOImpl implements ColorDAO {
    private static ColorDAOImpl instance;
    private IConnectionPool connectionPool;
    private Connection connection;

    private ColorDAOImpl() {
        connectionPool = DbConnection.init("root", "", "apple_store");
    }

    public static ColorDAOImpl getInstance() {
        if (instance == null) {
            instance = new ColorDAOImpl();
        }
        return instance;
    }

    @Override
    public List<Color> findAll() {
        List<Color> colors = new ArrayList<Color>();
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.COLOR.GET_LIST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String hex = rs.getString("hex");

                Color color = new Color(id, sku, name, hex);
                colors.add(color);
            }

        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return colors;
        }
        connectionPool.releaseConnection(connection);
        return colors;
    }

    @Override
    public Optional<Color> findById(Long id) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY.COLOR.GET_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (!rs.isBeforeFirst() && rs.getRow() == 0) return Optional.empty();
            if (rs.next()) {
                Long idColor = rs.getLong("id");
                String name = rs.getString("name");
                String sku = rs.getString("sku");
                String hex = rs.getString("hex");

                Color color = new Color(idColor, sku, name, hex);
                connectionPool.releaseConnection(connection);
                return Optional.of(color);
            }
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
            return Optional.empty();
        }
        connectionPool.releaseConnection(connection);
        return Optional.empty();
    }

    @Override
    public void save(Color object) {
        connection = connectionPool.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(object.getId() == 0 ? QUERY.COLOR.INSERT : QUERY.COLOR.UPDATE);
            statement.setString(1, object.getSku());
            statement.setString(2, object.getName());
            statement.setString(3, object.getHex());
            if (object.getId() != 0) statement.setLong(4, object.getId());
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
            PreparedStatement statement = connection.prepareStatement(QUERY.COLOR.DELETE_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            connectionPool.releaseConnection(connection);
        }
        connectionPool.releaseConnection(connection);
    }

    public static void main(String[] args) {
        for (Color color : ColorDAOImpl.getInstance().findAll()) {
            System.out.println(color.getSku());
        }
    }
}
