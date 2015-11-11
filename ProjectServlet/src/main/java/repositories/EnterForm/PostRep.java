package repositories.EnterForm;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import entities.EnterForm.Post;
import entities.EnterForm.User;
import exceptions.DbException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import static BD.Singleton.ConnectionMysql.getDBConnection;

public class PostRep {
    public static void addPost(Post post) throws SQLException, DbException {

        Connection connection = (Connection) getDBConnection();
        assert connection != null;
        PreparedStatement pstmt = (PreparedStatement) connection.prepareStatement("INSERT INTO posts(text,date,user_id) VALUES(?, ?,?);");

        pstmt.setString(1, post.getText());
        pstmt.setString(2, post.getPublishedTime());
        pstmt.setInt(3, post.getUser_id());
        pstmt.executeUpdate();
    }


    public static List<Post> getAllPosts() throws SQLException, DbException {
        Connection connection = (Connection) getDBConnection();
        assert connection != null;
        PreparedStatement pstmt1 = (PreparedStatement) connection.prepareStatement("SELECT * FROM posts");
        ResultSet set = pstmt1.executeQuery();


        List<Post> posts = new LinkedList<>();
        while (set.next()) {
            int id = set.getInt(1);
            String text = set.getNString(2);
            Date date = set.getDate(3);
            Time time = set.getTime(3);
            int user_id = set.getInt(4);

            Post post = new Post(id, text, date.toString() + "  " + time.toString(), user_id);
            User user = UserRep.searchId(user_id);
            assert user != null;
            post.setUserName(user.getName3());
            posts.add(post);

        }
        return posts;
    }

}
