package dao;

import model.UserForm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    void create(UserForm userForm);

    List<UserForm> readAll();

    void update(UserForm userForm);

    void delete(UserForm userForm);
}
