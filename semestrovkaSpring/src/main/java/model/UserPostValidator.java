package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserPostValidator implements Validator {
    @Override
    public boolean supports(Class aClass) {
        return UserPost.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserPost a = (UserPost) obj;


        //Ругялярка логина
        String UserLogin = a.getDescription();
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher(UserLogin);
        boolean b = matcher.matches();

        //Ругялярка Email`a
        String UserEmail = a.getTag();
        Pattern pattern1 = Pattern.compile("\\w*");
        Matcher matcher1 = pattern1.matcher(UserEmail);
        boolean c = matcher1.matches();

        //Ругялярка пароля
        String UserPassword = a.getTopic();
        Pattern pattern2 = Pattern.compile("\\w*");
        Matcher matcher2 = pattern2.matcher(UserPassword);
        boolean d = matcher2.matches();


        ValidationUtils.rejectIfEmpty(errors, "topic", "", "Данное поле не может оставаться пустым");
        ValidationUtils.rejectIfEmpty(errors, "tag", "", "Данное поле не может оставаться пустым");
        ValidationUtils.rejectIfEmpty(errors, "description", "", "Данное поле не может оставаться пустым");


        if (!d) {
            errors.rejectValue("topic", "Invalid.theme");
        }
        if (!c) {
            errors.rejectValue("tag", "Invalid.tag");
        }
        if (!b) {
            errors.rejectValue("description", "Invalid.description");
        }


    }

}
