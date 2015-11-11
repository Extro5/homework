package BD.Singleton;

import exceptions.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMysql {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String CONNECTION_URI = "jdbc:mysql://127.0.0.1:3306/site";
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

/*
    public static Connection getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "1234");


        */
/*
          настройки указывающие о необходимости конвертировать данные из Unicode
	  в UTF-8, который используется в нашей таблице для хранения данных
        *//*

            properties.setProperty("useUnicode", "true");
            properties.setProperty("characterEncoding", "UTF-8");
            return (DriverManager.getConnection("jdbc:mysql://localhost:3306/site",
                    properties));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
*/








