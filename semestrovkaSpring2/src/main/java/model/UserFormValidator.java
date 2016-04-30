package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserFormValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserForm a = (UserForm) obj;

        //Ругялярка логина
        String UserLogin = a.getLogin();
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher(UserLogin);
        boolean b = matcher.matches();

        //Ругялярка Email`a
        String UserEmail = a.getEmail();
        Pattern pattern1 = Pattern.compile("\\w*");
        Matcher matcher1 = pattern1.matcher(UserEmail);
        boolean c = matcher1.matches();

        //Ругялярка пароля
        String UserPassword = a.getPassword();
        Pattern pattern2 = Pattern.compile("\\w*");
        Matcher matcher2 = pattern2.matcher(UserPassword);
        boolean d = matcher2.matches();


        ValidationUtils.rejectIfEmpty(errors, "login", "Empty.field");
        ValidationUtils.rejectIfEmpty(errors, "email", "Empty.field");
        ValidationUtils.rejectIfEmpty(errors, "password", "Empty.field");


        if (!b) {
            errors.rejectValue("login", "Incorrect.login");
        }
        if (!c) {
            errors.rejectValue("email", "Invalid.email");
        }
        if (!d) {
            errors.rejectValue("password", "Invalid.password");
        }

    }

}
