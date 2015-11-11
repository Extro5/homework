package servlets.Authorization;

import entities.EnterForm.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static repositories.EnterForm.UserRep.searchLogin;


public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = searchLogin(login);

        if (user != null) {
            if (password.equals(user.getPass3())) {
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                resp.sendRedirect("/profile ");
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.print("Invalid User");
        }


    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("login") != null) {
            resp.sendRedirect("/profile");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Login.jsp").forward(req, resp);
    }
}
