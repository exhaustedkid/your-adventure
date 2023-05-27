package com.yadv.your_adventure.dao;

import org.postgresql.ds.PGPoolingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
public class ConnectionPool {
    private static final String server_name = "localhost";
    private static final String database_name = "your_adventure";
    private static final String user = "postgres";
    private static final String password = "2281337";
    private static final int MAX_CONNECTIONS = 10;
    private static final DataSource dataSource;
    static {
        PGPoolingDataSource source = new PGPoolingDataSource();
        source.setDataSourceName("A Data Source");
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
