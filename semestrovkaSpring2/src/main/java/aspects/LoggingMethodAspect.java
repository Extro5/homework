package aspects;


import model.LoggerTable;
import model.UserForm;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import repository.LoggingRepository;

import java.text.SimpleDateFormat;

import static java.lang.System.currentTimeMillis;


@Aspect
public class LoggingMethodAspect {


    @Autowired
    LoggingRepository loggingRepository;


    @Around("@annotation(AnnoLogging)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object value = null;
        proceedingJoinPoint.proceed();

        //method
        String methodName = proceedingJoinPoint.getSignature().getName();


        //date
        String curStringDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(currentTimeMillis());

        //return value
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        //return LoginUser
        String userForm = null;
        UserForm userFormModel = null;
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser") {
            userForm = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else {
            userFormModel = (UserForm) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }

        String retNameUser = null;
        if (userForm == null) {
            assert userFormModel != null;
            retNameUser = userFormModel.getLogin();
            System.out.println(userFormModel.getLogin());
        } else {
            retNameUser = userForm;
            System.out.println(userForm);
        }
        System.out.println(methodName);
        System.out.println(curStringDate);
        System.out.println(value);


        LoggerTable loggerTable = new LoggerTable(curStringDate, methodName, value.toString(), retNameUser);
        loggingRepository.save(loggerTable);

        return value;
    }
}
