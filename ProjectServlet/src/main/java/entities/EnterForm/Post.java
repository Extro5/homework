package entities.EnterForm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {

    private int id;
    private String text;
    private String publishedTime;
    private int user_id;
    private String user_name;


    public Post(String text, int user_id) {
        this(text, currentDate(), user_id);
    }

    public Post(String text, String publishedTime, int user_id) {
        this.setText(text);
        this.setPublishedTime(publishedTime);
        this.setUser_id(user_id);
    }

    public Post(int id, String text, String publishedTime, int user_id) {
        this.setId(id);
        this.setText(text);
        this.setPublishedTime(publishedTime);
        this.setUser_id(user_id);
    }

    private static String currentDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public int getUser() {
        return getUser_id();
    }

    public void setUser(int user_id) {
        this.setUser_id(user_id);
    }

    public String getUserName() {
        return getUser_name();
    }

    public void setUserName(String user_name) {
        this.setUser_name(user_name);
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


}