package repositories.EnterForm;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import entities.EnterForm.User;
import exceptions.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRep {

    private static final String USER_P;

    static {
        USER_P = "^[\\w-]{2,14}$";
    }

    private static final String EMAIL_P;

    static {
        EMAIL_P = "^([a-zA-Z0-9]+)([a-zA-Z0-9\\.\\-\\_]*)@([a-zA-Z]+)\\.([a-z]{2,})$";
    }

    private static final String Password_P;

    static {
        Password_P = "^[\\w-]{2,14}$";
    }

    private static final String FORM_PATH = "D://IDEA all//ProjectServlet//csv//users.csv";

    public void add(User user) throws DbException, UsernameException, EmailException, PasswordException, RepetitionException {

        if (!checkUsername(user.getUsername()) || !checkEmail(user.getEmail()) || checkPassword(user.getPassword())) {

            if (!checkUsername(user.getUsername())) {
                throw new UsernameException();
            } else
            if (!checkEmail(user.getEmail())) {
                throw new EmailException();
            }else
            if (!checkPassword(user.getPassword())) {
                throw new PasswordException();
            }


        }


        try {
            if (searchEmail(user.getEmail()) != null) {
                throw new RepetitionException();
            } else {
                addCsv("users", new String[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getSex() ? "male" : "female", user.getRadio() ? "agree" : "not agree"});
            }
        } catch (DbException e) {
            throw e;
        }


    }


    private void addCsv(String lol, String[] userform) throws DbException {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FORM_PATH, true));
            writer.writeNext(userform);
            writer.close();

        } catch (IOException e) {
            throw new DbException();
        }
    }


    public static boolean  checkUsername(String name) {
        Pattern pattern = Pattern.compile(USER_P);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_P);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean  checkPassword(String password) {
        Pattern pattern = Pattern.compile(Password_P);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    private User searchEmail(String Email) throws DbException {
        try {
            CSVReader reader = new CSVReader(new FileReader(FORM_PATH), ',', '"', 1);
            String[] gap;
            while ((gap = reader.readNext()) != null) {
                if (gap[1].equals(Email)) return new User(gap[0], gap[1], gap[2],
                        gap[3].equals("male"), gap[4].equals("agree"));
            }
            return null;
        } catch (IOException e) {
            throw new DbException();
        }


    }

    public static User searchName(String name) throws DbException {
        try {
            CSVReader reader = new CSVReader(new FileReader(FORM_PATH), ',', '"', 1);
            String[] gap;
            while ((gap = reader.readNext()) != null) {
                if (gap[1].equals(name)) return new User(gap[0], gap[1], gap[2],
                        gap[3].equals("male"), gap[4].equals("agree"));
            }
            return null;
        } catch (IOException e) {
            throw new DbException();
        }


    }

}