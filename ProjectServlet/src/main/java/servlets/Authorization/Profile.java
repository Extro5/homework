package servlets.Authorization;


import entities.EnterForm.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static repositories.EnterForm.UserRep.searchLogin;

public class Profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if (session.getAttribute("login") == null) {
            resp.sendRedirect("/login");
        }

        String login = (String) session.getAttribute("login");

        if (searchLogin(login) != null) {
            User user = searchLogin(login);
            assert user != null;

            String lol1;
            if (user.getSex()) {
                lol1 = "male";
            } else {
                lol1 = "female";
            }
            String lol2;
            if (user.getRadio()) {
                lol2 = "agree";
            } else {
                lol2 = "not agree";
            }

            req.setAttribute("Username", user.getUsername());
            req.setAttribute("Email", user.getEmail());
            req.setAttribute("Password", user.getPassword());
            req.setAttribute("Sex", lol1);
            req.setAttribute("Subscribe", lol2);
            req.setAttribute("Comment", user.getComment());

            getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Profile.jsp").forward(req, resp);
        }
    }
}
