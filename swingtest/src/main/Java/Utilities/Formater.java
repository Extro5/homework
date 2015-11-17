package main.Java.Utilities;


import main.Java.Entities.Product;
import main.Java.Repository.ProductRep;

import java.sql.SQLException;
import java.util.List;

public class Formater {
    public static String[][] getTable() throws Exception {
        try {

            List<Product> products = ProductRep.getAllData();
            String[][] data = new String[products.size()][5];
            int i = 0;
            for (Product product : products) {
                data[i][0] = String.valueOf(product.getId1());
                data[i][1] = product.getName1();
                data[i][2] = String.valueOf(product.getPrice1());
                data[i][3] = String.valueOf(product.getWeight1());
                data[i][4] = product.getManufacturer1();
                i++;
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new String[][]{};
    }


}
