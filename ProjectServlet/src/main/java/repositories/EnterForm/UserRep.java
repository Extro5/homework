package repositories.EnterForm;


import com.opencsv.CSVWriter;
import entities.EnterForm.User;

import java.io.FileWriter;
import java.io.IOException;

public class UserRep {

    private static final String USER_P = "^[a-z0-9_-]{3,15}$";
    private static final String EMAIL_P = "^([a-zA-Z0-9]+)([a-zA-Z0-9\\.\\-\\_]*)@([a-zA-Z]+)\\.([a-z]{2,})$";
    private static final String FORM_PATH = "D://apache/Users.csv";

    public static void add(User user) {
        addCsv("users", new String[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getSex() ? "female" : "male", user.getRadio() ? "agree" : "not agree"});

    }





    public static void addCsv(String db, String[] data) {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FORM_PATH, true));
            writer.writeNext(data);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
