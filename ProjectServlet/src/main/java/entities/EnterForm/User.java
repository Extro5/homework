package entities.EnterForm;

public class User {

    private String Username;
    private String email;
    private String password;
    private boolean sex;
    private boolean radio;
    private String comment;



    public User(String Username, String email, String password, boolean sex, boolean radio, String comment){

        this.email = email;
        this.password = password;
        this.sex = sex;
        this.radio = radio;
        this.Username = Username;
        this.comment = comment;
    }




    public String getUsername(){
        return Username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public boolean getSex(){
        return sex;
    }

    public boolean getRadio(){
        return radio;
    }

    public String getComment(){
        return comment;
    }
}
