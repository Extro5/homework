package main.Java.GUI;

import main.Java.Utilities.Formater;

import javax.swing.*;

public class ProductList {
    public void start() throws Exception {

        JFrame frame = new JFrame("Product List");
        JPanel panel = new JPanel();

        String[] columns = new String[]{"Id", "Name", "Price", "Weight", "Manufacturer"};
        String[][] data = Formater.getTable();

        JTable table = new JTable(data, columns);

        panel.add(table);
        table.setEnabled(false); // Запрещает редактирование таблицы
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
