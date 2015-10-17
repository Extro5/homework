package servlets.Authorization;


import entities.EnterForm.User;
import exceptions.DbException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static repositories.EnterForm.UserRep.searchName;

public class Profile extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        PrintWriter out = resp.getWriter();
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

                        out.println("Username: " + user.getUsername());
                        out.println("Email: " + user.getEmail());
                        out.println("Password: " + user.getPassword());
                        out.println("Sex: " + lol1);
                        out.println("Subscribe: " + lol2);
                        return;
                    }
                } catch (DbException e) {
                    out.print("VERY BAD");
                }


            }
        }
        resp.sendRedirect("/login");
    }
}


