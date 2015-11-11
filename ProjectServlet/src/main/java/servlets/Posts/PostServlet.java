package servlets.Posts;


import entities.EnterForm.Post;
import entities.EnterForm.User;
import exceptions.DbException;
import org.json.JSONObject;
import repositories.EnterForm.PostRep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static repositories.EnterForm.UserRep.searchLogin;

public class PostServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("login") == null) {
            resp.sendRedirect("/login");
        }

        List<Post> posts = new ArrayList<>();

        try {
            posts = PostRep.getAllPosts();

        } catch (SQLException e) {
            req.setAttribute("message", "Sorry, some problems with server(");
            e.printStackTrace();
        } catch (DbException e) {
            e.printStackTrace();
        }

        req.setAttribute("posts", posts);

        getServletContext().getRequestDispatcher("/WEB-INF/Posts/Posts.jsp").forward(req, resp);

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String login = (String) session.getAttribute("login");

        if (searchLogin(login) != null) {
            User user = searchLogin(login);
            assert user != null;
            // User user = (User) session.getAttribute("login");   А вот и не ясно, почему так не работает... (по сути должно)
            String textForPost = req.getParameter("post");

            if ("".equals(textForPost) || textForPost == null) {
                return;
            }


            Post post = new Post(textForPost, user.getId3());


            post.setUserName(user.getEmail());

            try {
                PostRep.addPost(post);
                String data = getJSON(post);
                if ("".equals(data)) {
                    return;
                }
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("application/json");
                resp.getWriter().write(data);

            } catch (SQLException e) {
                req.setAttribute("message", "problems in server");
                e.printStackTrace();
            } catch (DbException e) {
                e.printStackTrace();
            }


        }
    }

    private static String getJSON(Post post) {


        try (StringWriter sWriter = new StringWriter()) {

            JSONObject obj = new JSONObject();

            obj.put("userName", post.getUserName());
            obj.put("postText", post.getText());
            obj.put("pTime", post.getPublishedTime());
            obj.put("idq", post.getId());

            obj.write(sWriter);

            return sWriter.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}