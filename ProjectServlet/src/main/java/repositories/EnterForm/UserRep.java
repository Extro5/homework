package repositories.EnterForm;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.opencsv.CSVReader;
import entities.EnterForm.User;
import exceptions.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static BD.Singleton.ConnectionMysql.getDBConnection;

public class UserRep {

/*
    // экранирование:
    // String abc = "He said: \"Hi!\"";
*/


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
        Password_P = "^[a-zA-Z0-9]{2,14}$";
    }

    private static final String FORM_PATH = "D://IDEA all//ProjectServlet//csv//users.csv";

    public void add(User user) throws Exception {

        if (!checkUsername(user.getUsername()) || !checkEmail(user.getEmail()) || checkPassword(user.getPassword())) {

            if (!checkUsername(user.getUsername())) {
                throw new UsernameException();
            } else if (!checkEmail(user.getEmail())) {
                throw new EmailException();
            } else if (!checkPassword(user.getPassword())) {
                throw new PasswordException();
            }


        }


        try {
            if (searchEmail(user.getEmail()) != null) {
                throw new RepetitionException();
            } else {


                Connection connection = (Connection) getDBConnection();
                Statement statement = (Statement) connection.createStatement();

                String sex = user.getSex() ? "male" : "female";
                String subscribe = user.getRadio() ? "agree" : "not agree";
                statement.executeUpdate("INSERT INTO users(name, email, password, sex, lan,comment) VALUES  ('" + user.getUsername() + "','" + user.getEmail() + "','" + user.getPassword() + "','" + sex + "','" + subscribe + "','" + user.getComment() + "');");


                //  addCsv("users", new String[]{user.getUsername(), user.getEmail(), user.getPassword(), user.getSex() ? "male" : "female", user.getRadio() ? "agree" : "not agree", user.getComment()});
            }
        } catch (DbException e) {
            throw e;
        }


    }

/*

    private void addCsv(String lol, String[] userform) throws DbException {

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(FORM_PATH, true));
            writer.writeNext(userform);
            writer.close();

        } catch (IOException e) {
            throw new DbException();
        }
    }
*/


    public static boolean checkUsername(String name) {
        Pattern pattern = Pattern.compile(USER_P);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_P);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(Password_P);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }




    public static User searchLogin(String login) {
        try {

            Connection connection = (Connection) getDBConnection();
            Statement statement = (Statement) connection.createStatement();


            if (statement.executeQuery("SELECT email FROM users WHERE email=\"" + login + "\"") != null) {
                ResultSet resultlogin = statement.executeQuery("SELECT name,email,password,sex,lan,comment FROM users WHERE email=\"" + login + "\"");
                while (resultlogin.next()) {
                    return new User(resultlogin.getString("name"), resultlogin.getString("email"), resultlogin.getString("password"), resultlogin.getBoolean("sex"), resultlogin.getBoolean("lan"), resultlogin.getString("comment"));
                }
            } else {
                System.out.print("пользователя не существует");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public static User searchEmail(String Email) throws DbException {
        try {
            CSVReader reader = new CSVReader(new FileReader(FORM_PATH), ',', '"', 1);
            String[] gap;
            while ((gap = reader.readNext()) != null) {
                if (gap[1].equals(Email)) return new User(gap[0], gap[1], gap[2],
                        gap[3].equals("male"), gap[4].equals("agree"), gap[5]);
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
                        gap[3].equals("male"), gap[4].equals("agree"), gap[5]);
            }
            return null;
        } catch (IOException e) {
            throw new DbException();
        }


    }
/*

    public java.sql.Connection getDBConnection() throws Exception {
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
    }
*/


}