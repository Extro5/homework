package dao;

import exceptions.NotFoundException;
import model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("dataSource")
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(UserForm userForm) {
        try {
            this.jdbcTemplate.update("INSERT INTO user (login, email, password) VALUES (?, ? , ?)", userForm.getLogin(), userForm.getEmail(), userForm.getPassword());
        } catch (Exception a) {
            throw new NotFoundException();
        }
    }

    @Override
    public List<UserForm> readAll() {
        return jdbcTemplate.query("SELECT * FROM user", (rs, rowNum) -> {
            UserForm userForm = new UserForm();
            userForm.setLogin(rs.getString("login"));
            userForm.setPassword(rs.getString("password"));
            userForm.setEmail(rs.getString("email"));
            return userForm;
        });
    }

    @Override
    public void update(UserForm userForm) {
        try {
            this.jdbcTemplate.update("UPDATE user SET password = ? WHERE email = ? AND password = ?", userForm.getPassword(), userForm.getEmail(), userForm.getPassword());
        } catch (Exception a1) {
            throw new NotFoundException();
        }
    }

    @Override
    public void delete(UserForm userForm) {
        try {
            this.jdbcTemplate.update("DELETE FROM user WHERE email=? AND  password=?", userForm.getEmail(), userForm.getPassword());
        } catch (Exception a2) {
            throw new NotFoundException();
        }
    }
}