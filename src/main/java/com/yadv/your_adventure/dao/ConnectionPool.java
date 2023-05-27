package com.yadv.your_adventure.dao;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.sql.DataSource;
public class ConnectionPool {
    private static final String server_name;
    private static final String database_name;
    private static final String user;
    private static final String password;
    private static final int MAX_CONNECTIONS;

    static {
        ResourceBundle resource = ResourceBundle.getBundle("config");
        server_name = resource.getString("db.server_name");
        database_name = resource.getString("db.database_name");
        user = resource.getString("db.user");
        password = resource.getString("db.password");
        MAX_CONNECTIONS = Integer.parseInt(resource.getString("db.MAX_CONNECTIONS"));
    }
    private static final DataSource dataSource;
    static {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("postgre connection pool");
        source.setServerNames(new String[]{
                server_name
        });
        source.setDatabaseName(database_name);
        source.setUser(user);
        source.setPassword(password);
        source.setMaxConnections(MAX_CONNECTIONS);
        dataSource = source;
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
