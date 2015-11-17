package main.Java.Repository;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import main.Java.Entities.Product;
import main.Java.Exceptions.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static main.Java.Utilities.DBConnection.getDBConnection;


public class ProductRep {

    public static void add(Product product) throws DbException, SQLException {

        Connection connection = (Connection) getDBConnection();
        assert connection != null;

        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO product(name, price, weight, manufacturer) VALUES (?,?,?,?)");
        pstmt.setString(1, product.getName());
        pstmt.setInt(2, product.getPrice());
        pstmt.setInt(3, product.getWeight());
        pstmt.setString(4, product.getManufacturer());
        pstmt.execute();
        pstmt.close();
    }


    public static List<Product> getAllData() throws Exception {
        List<Product> products = new ArrayList<>();

        Connection connection = (Connection) getDBConnection();
        assert connection != null;
        Statement statement = (Statement) connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM product;");


        while (set.next()) {
            products.add(new Product(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4), set.getString(5)));
        }
        return products;
    }
}
