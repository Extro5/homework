package entities.EnterForm;

public class User {

    private String Username;
    private String email;
    private String password;
    private boolean sex;
    private boolean radio;
    private String comment;

    private String name2;
    private String email2;
    private String pass2;
    private String sex2;
    private String lan2;
    private String comment2;


    public User(String Username, String email, String password, boolean sex, boolean radio, String comment) {

        this.email = email;
        this.password = password;
        this.sex = sex;
        this.radio = radio;
        this.Username = Username;
        this.comment = comment;
    }

    public User(String name2, String email2, String pass2, String sex2, String lan2, String comment2) {

        this.name2 = name2;
        this.email2 = email2;
        this.pass2 = pass2;
        this.sex2 = sex2;
        this.lan2 = lan2;
        this.comment2 = comment2;


    }


    public String getName2() {
        return name2;
    }

    public String getEmail2() {
        return email2;
    }

    public String getPass2() {
        return pass2;
    }

    public String getSex2() {
        return sex2;
    }

    public String getLan2() {
        return lan2;
    }

    public String getComment2() {
        return comment2;
    }


    public String getUsername() {
        return Username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getSex() {
        return sex;
    }

    public boolean getRadio() {
        return radio;
    }

    public String getComment() {
        return comment;
    }
}
