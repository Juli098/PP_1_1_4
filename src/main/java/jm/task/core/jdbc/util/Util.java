package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String USERNAME = "root";
    public static final String DBNAME = "test1.1.3";
    public static final String PASSWORD = "root";
    public static final String HOSTNAME = "localhost";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

   /* public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBNAME, USERNAME, PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME + "?allowPublicKeyRetrieval=true&useSSL=false";
        conn.setAutoCommit(false);
        return DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);


    }*/
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME + "?allowPublicKeyRetrieval=true&useSSL=false";
            Connection connection = DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
            return connection;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


/*
    

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();

            }
        }
    */
    }




