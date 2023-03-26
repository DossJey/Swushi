package model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionPool {

        private static DataSource datasource;

    public static Connection getConnection() throws SQLException {

     if(datasource == null){
         PoolProperties p = new PoolProperties();
         p.setUrl("jdbc:mysql://localhost:3306/Swushi?user=root&password=admin&autoReconnect=true&useSSL=false&serverTimezone=" + TimeZone.getDefault().getID());
         p.setDriverClassName("com.mysql.cj.jdbc.Driver");
         p.setUsername("root");
         p.setPassword("admin");
         p.setMaxActive(100);
         p.setInitialSize(10);
         p.setMinIdle(10);
         p.setRemoveAbandonedTimeout(60);
         p.setRemoveAbandoned(true);
         datasource = new DataSource();
         datasource.setPoolProperties(p);
     }

        return datasource.getConnection();
    }

    public static synchronized void releaseConnection(Connection connection)
            throws SQLException {
        if(connection != null) connection.close();
    }


}