package main.Java.Utilities;


import main.Java.Exceptions.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/mydbgui";
    private final static String LOGIN = "root";
    private final static String PASSWORD = "1234";

    private static Connection conn;


    public static Connection getDBConnection() throws DbException {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);
            } catch (ClassNotFoundException ex) {
                throw new DbException("Can't find DB driver.");
            } catch (SQLException ex) {
                throw new DbException("Can't connect to DB (" + ex.getErrorCode() + ": " + ex.getMessage() + ").");
            }

        }
        return conn;
    }
}
