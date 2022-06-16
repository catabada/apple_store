package vn.edu.hcmuaf.fit.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection implements IConnectionPool {
    private static final int MAX_TIMEOUT = 30;
    private static final int MAX_POOL_SIZE = 10;
    private final String uid;
    private final String pwd;
    private final String database;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();

    public static DbConnection init(String uid, String pwd, String database) {
        List<Connection> pool = new ArrayList<>(MAX_POOL_SIZE);
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            pool.add(createConnection());
        }
        return new DbConnection(uid, pwd, database, pool);
    }

    private DbConnection(String uid, String pwd, String database, List<Connection> pool) {
        this.uid = uid;
        this.pwd = pwd;
        this.database = database;
        this.connectionPool = pool;
    }

    @Override
    public Connection getConnection() {
        try {
            if (connectionPool.isEmpty()) {
                if (usedConnections.size() < MAX_POOL_SIZE) {
                    connectionPool.add(createConnection());
                } else {
                    throw new RuntimeException("Maximum pool size reached, no available connections!");
                }
            }
            Connection connection = connectionPool.remove(connectionPool.size() - 1);
            if (!connection.isValid(MAX_TIMEOUT)) {
                connection = createConnection();
            }
            usedConnections.add(connection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/" + "apple_store", "root", "");
        } catch (Exception e) {
            return null;
        }
    }
}
