package servlets.EnterForm;


import entities.EnterForm.User;
import exceptions.*;
import repositories.EnterForm.UserRep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EnterFormServ extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login") != null) {
            resp.sendRedirect("/profile");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);


    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (
                req.getParameter("email") != null &&
                        req.getParameter("password") != null &&
                        req.getParameter("sex") != null &&
                        req.getParameter("username") != null
                ) {
            String username = req.getParameter("username");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            boolean sex = req.getParameter("sex").equals("male");
            boolean subscription = req.getParameter("lan") != null;
            String comment = req.getParameter("comment");


            User user = new User(username, email, password, sex, subscription, comment);

            UserRep urep = new UserRep();
            try {
                urep.add(user);
                req.setAttribute("head", "User has been created");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);

            } catch (UsernameException a) {
                req.setAttribute("UsernameError", "Invalid username");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);
            } catch (EmailException b) {
                req.setAttribute("EmailError", "Invalid EmailError");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);
            } catch (PasswordException c) {
                req.setAttribute("PasswordError", "invalid Password");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);
            } catch (DbException e) {
                req.setAttribute("DatabaseError", "Database Error");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);
            } catch (RepetitionException d) {
                req.setAttribute("RepeatError", "Invalid User");
                getServletContext().getRequestDispatcher("/WEB-INF/Registration/Form.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}
