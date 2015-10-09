package repositories.EnterForm;


import com.opencsv.CSVWriter;
import entities.EnterForm.User;
import exceptions.DbException;
import exceptions.EmailException;
import exceptions.PasswordException;
import exceptions.UsernameException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRep {

    private static final String USER_P = "^[a-z0-9_-]{3,15}$";
    private static final String EMAIL_P = "^([a-zA-Z0-9]+)([a-zA-Z0-9\\.\\-\\_]*)@([a-zA-Z]+)\\.([a-z]{2,})$";
    private static final String FORM_PATH = "D://apache/Users.csv";

    public static void add(User user) throws DbException, UsernameException, EmailException, PasswordException {

        if (!checkUsername(user.getUsername()) || !checkEmail(user.getEmail()) || checkPassword(user.getPassword())) {

            if (!checkUsername(user.getUsername())) {
                throw new UsernameException();
            }
            if (!checkEmail(user.getEmail())) {
                throw new EmailException();
            }
            if (!checkPassword(user.getPassword())) {
                throw new PasswordException();
            }


        }

        
        try {
            addCsv("users", new String[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getSex() ? "male" : "female", user.getRadio() ? "agree" : "not agree"});
        } catch (DbException e) {
            throw e;
        }
        ;

    }


    public static void addCsv(String db, String[] data) throws DbException {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FORM_PATH, true));
            writer.writeNext(data);
            writer.close();

        } catch (IOException e) {
            throw new DbException();
        }
    }


    private static boolean checkUsername(String name) {
        Pattern pattern = Pattern.compile(USER_P);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_P);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean checkPassword(String password) {
        boolean check = (!password.contains(" ") && password.length() > 5) ? true : false;
        return check;
    }
}