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
            if (password.equals(user.getPassword())) {
                Cookie cookie = new Cookie("login", login);
                HttpSession session = req.getSession();
                resp.addCookie(cookie);
                session.setAttribute("cookie", login);
                resp.sendRedirect("/profile ");
            }
        } else {
            PrintWriter out = resp.getWriter();
            out.print("Invalid invalid");
        }


    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals(session.getAttribute("cookie"))) {
                resp.sendRedirect("/profile");
                return;
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Login.jsp").forward(req, resp);
    }
}
