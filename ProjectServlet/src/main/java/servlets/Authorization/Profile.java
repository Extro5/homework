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


            req.setAttribute("Username", user.getName3());
            req.setAttribute("Email", user.getEmail3());
            req.setAttribute("Password", user.getPass3());
            req.setAttribute("Sex", user.getSex3());
            req.setAttribute("Subscribe", user.getLan3());
            req.setAttribute("Comment", user.getComment3());

            getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Profile.jsp").forward(req, resp);
        }
    }
}
