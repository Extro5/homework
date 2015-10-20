package servlets.Authorization;


import entities.EnterForm.User;
import exceptions.DbException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static repositories.EnterForm.UserRep.searchName;

public class Profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals(session.getAttribute("cookie"))) {
                try {
                    if (searchName(cookie.getValue()) != null) {
                        User user = searchName(cookie.getValue());
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

                        return;
                    }
                } catch (DbException e) {
                    e.printStackTrace();
                }
            }
        }
        resp.sendRedirect("/login");
    }
}