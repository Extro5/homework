package main.Java.Utilities;


import main.Java.Entities.Product;
import main.Java.Repository.RestRep;

import java.util.ArrayList;
import java.util.List;

public class Formater {
    public static String[][] getTable() {       // Заформатили под таблицу
        List<Product> products = new ArrayList<>();
        try {
            products = RestRep.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[][] result = new String[products.size()][5];
        int i = 0;
        for (Product p : products) {
            result[i][0] = String.valueOf(p.getId1());
            result[i][1] = p.getName1();
            result[i][2] = String.valueOf(p.getPrice1());
            result[i][3] = String.valueOf(p.getWeight1());
            result[i][4] = p.getManufacturer1();
            i++;
        }
        return result;
    }
}
