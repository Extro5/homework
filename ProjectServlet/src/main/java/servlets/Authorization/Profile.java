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
        PrintWriter writer = resp.getWriter();
        String htmlResponse = "<html>";
        for (Cookie cookie : cookies) {
            if (cookie.getValue().equals(session.getAttribute("cookie"))) {
               /* htmlResponse += "<head>\n" +
                        "  <meta charset=\"utf-8\">\n" +
                        "    <title>Users</title>\n" +
                        "   </head>";
                htmlResponse += "<body>";*/


                try {
                    if (searchName(cookie.getValue()) != null) {
                        User user = searchName(cookie.getValue());
                        session.setAttribute("Username", req.getParameter("Username"));
                        /*
                        assert user != null;
                        String Username = user.getUsername();
                        //getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Profile.jsp").forward(req, resp);*/

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
                        /*
                        out.println("Username: " + user.getUsername());
                        out.println("Email: " + user.getEmail());
                        out.println("Password: " + user.getPassword());
                        out.println("Sex: " + lol1);
                        out.println("Subscribe: " + lol2);
                        out.println("Comment " + user.getComment());*/
                        htmlResponse += "<head>\n" +
                                "  <meta charset=\"utf-8\">\n" +
                                "    <title>Users</title>\n" +
                                "   </head>";
                        htmlResponse += "<body>";
                        htmlResponse += "<div class=\"container\">";
                        htmlResponse += "<div class=\"card\">";
                        htmlResponse += "<h2>"+user.getUsername()+"</h2>";
                        htmlResponse += "<p>"+"email: "+user.getEmail()+"</p>";
                        htmlResponse += "<p>"+"Sex: "+lol1+"</p>";
                        htmlResponse += "<p>"+"Subscribe: "+lol2+"</p>";
                        htmlResponse += "<p>"+"Comment: "+user.getComment()+"</p>";
                        htmlResponse +="</div>";
                        htmlResponse += "</div>";
                        htmlResponse += " <form name=\"loginForm\" method=\"get\" action=\"/logout\">\n" +
                                "            <p><input type=\"submit\" value=\"logout\" /></p>\n" +
                                "        </form>";
                        htmlResponse += "</body>";

                        htmlResponse += "</html>";
                        writer.println(htmlResponse);
                        out.close();
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

      /*  _______________________________________________________________________________________*/

/*
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        if (session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
        }
        PrintWriter writer = resp.getWriter();
        String htmlResponse = "<html>";

        htmlResponse +="<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "    <title>Users</title>\n" +
                "   </head>";
        htmlResponse += "<body>";
        try {
            String email = (String) session.getAttribute("user");
            if (searchEmail(email) != null) {
                User user = searchEmail(email);
                String lol1;
                assert user != null;
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
                htmlResponse += "<div class=\"container\">";
                htmlResponse += "<div class=\"card\">";
                htmlResponse += "<h2>"+user.getUsername()+"</h2>";
                htmlResponse += "<p>"+"email:"+user.getEmail()+"</p>";
                htmlResponse += "<p>"+lol1+"</p>";
                htmlResponse += "<p>"+"newsletter:"+lol2+"</p>";
                htmlResponse += "<p>"+"Comment:<br>"+user.getComment()+"</p>";
                htmlResponse +="</div>";
                htmlResponse += "</div>";
                htmlResponse += " <form name=\"loginForm\" method=\"get\" action=\"/logout\">\n" +
                        "            <p><input type=\"submit\" value=\"exit\" /></p>\n" +
                        "        </form>";


            }
        } catch (DbException e) {
            htmlResponse += "<h1>Error!!!</h1>";
        }
        htmlResponse += "</body>";

        htmlResponse += "</html>";
        writer.println(htmlResponse);
        out.close();
    }
}*/