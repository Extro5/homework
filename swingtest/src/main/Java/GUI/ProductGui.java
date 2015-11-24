package main.Java.GUI;


import main.Java.Entities.Product;
import main.Java.Repository.RestRep;
import main.Java.Utilities.EnumManufacturer;

import javax.swing.*;
import java.awt.*;

public class ProductGui extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Product");
        JPanel panel = new JPanel(new GridLayout(16, 20));


        JButton btn1 = new JButton("Send");
        JButton btn2 = new JButton("Get all data");
        JTextField tv1 = new JTextField("", 20);
        JTextField tv2 = new JTextField("", 20);
        JTextField tv3 = new JTextField("", 20);
        JTextField tv4 = new JTextField("", 20);
        JComboBox<String> comboBox = new JComboBox<>(EnumManufacturer.getManufacturers());
        JLabel lb1 = new JLabel("Name: ");
        JLabel lb2 = new JLabel("Price: ");
        JLabel lb3 = new JLabel("Weight: ");
        JLabel lb4 = new JLabel("Manufacturer: ");
        JLabel lb5 = new JLabel("");
        JLabel lb6 = new JLabel("");

        panel.add(lb1);
        panel.add(tv1);

        panel.add(lb2);
        panel.add(tv2);

        panel.add(lb3);
        panel.add(tv3);

        panel.add(lb4);
        panel.add(comboBox);

        panel.add(btn1);

        panel.add(lb5);

        panel.add(btn2);

        panel.add(lb6);


        btn1.addActionListener(e -> {
            String name = tv1.getText();
            String price = tv2.getText();
            String weight = tv3.getText();
            String manufacturer = (String) comboBox.getSelectedItem();

            Product product = new Product(name, Integer.parseInt(price), Integer.parseInt(weight), manufacturer);
            try {
                RestRep.add(product);
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv4.setText("");

                lb5.setText("The product was successfully added to the json-server.");
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        });

        btn2.addActionListener(e -> {
            try {
                SwingUtilities.invokeLater(() -> {
                    try {
                        new ProductList().start();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                });

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        });

        frame.add(panel);
        frame.setBounds(100, 100, 500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
