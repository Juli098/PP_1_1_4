package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String userName = "root";
    public static final String dbName = "test1.1.3";
    public static final String password = "root";
    public static final String hostName = "localhost";
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory;

    public static Connection getConnection()
        throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?allowPublicKeyRetrieval=true&useSSL=false";
        return DriverManager.getConnection(connectionURL, userName,password);
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




