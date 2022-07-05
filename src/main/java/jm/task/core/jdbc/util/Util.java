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

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String connectionURL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DBNAME + "?allowPublicKeyRetrieval=true&useSSL=false";
        conn.setAutoCommit(false);
        return DriverManager.getConnection(connectionURL, USERNAME, PASSWORD);


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




