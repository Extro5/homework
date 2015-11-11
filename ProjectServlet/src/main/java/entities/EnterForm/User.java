package entities.EnterForm;

public class User {

    private String Username;
    private String email;
    private String password;
    private boolean sex;
    private boolean radio;
    private String comment;

    private int id3;
    private String name3;
    private String email3;
    private String pass3;
    private String sex3;
    private String lan3;
    private String comment3;

    public User(String Username, String email, String password, boolean sex, boolean radio, String comment) {

        this.setEmail(email);
        this.setPassword(password);
        this.setSex(sex);
        this.setRadio(radio);
        this.setUsername(Username);
        this.setComment(comment);
    }

    public User(int id, String name, String email, String pass, String sex, String lan, String comment) {
        this.setId3(id);
        this.setName3(name);
        this.setEmail3(email);
        this.setPass3(pass);
        this.setSex3(sex);
        this.setLan3(lan);
        this.setComment3(comment);

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
        return isSex();
    }

    public boolean getRadio() {
        return isRadio();
    }

    public String getComment() {
        return comment;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getPass3() {
        return pass3;
    }

    public void setPass3(String pass3) {
        this.pass3 = pass3;
    }

    public String getSex3() {
        return sex3;
    }

    public void setSex3(String sex3) {
        this.sex3 = sex3;
    }

    public String getLan3() {
        return lan3;
    }

    public void setLan3(String lan3) {
        this.lan3 = lan3;
    }

    public String getComment3() {
        return comment3;
    }

    public void setComment3(String comment3) {
        this.comment3 = comment3;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
