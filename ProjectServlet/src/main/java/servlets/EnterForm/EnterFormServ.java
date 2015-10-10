package servlets.EnterForm;


import entities.EnterForm.User;
import exceptions.DbException;
import exceptions.EmailException;
import exceptions.PasswordException;
import exceptions.UsernameException;
import repositories.EnterForm.UserRep;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterFormServ extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/Form.jsp").forward(req, resp);
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
            boolean sex = req.getParameter("sex").equals("male") ? true : false;
            boolean subscription = req.getParameter("lan") == null ? false : true;


            User user = new User(username, email, password, sex, subscription);
            UserRep urep = new UserRep();
            try {
                urep.add(user);
                req.setAttribute("head", "User has been created");
                getServletContext().getRequestDispatcher("/Form.jsp").forward(req, resp);

            } catch (UsernameException a) {
                req.setAttribute("UsernameError", "Invalid username");
                getServletContext().getRequestDispatcher("/Form.jsp").forward(req, resp);
            } catch (EmailException b) {
                req.setAttribute("EmailError", "Invalid EmailError");
                getServletContext().getRequestDispatcher("/Form.jsp").forward(req, resp);
            } catch (PasswordException c) {
                req.setAttribute("PasswordError", "invalid Password");
                getServletContext().getRequestDispatcher("/Form").forward(req, resp);
            } catch (DbException e) {
                req.setAttribute("DatabaseError", "Database Error");
                getServletContext().getRequestDispatcher("/Form").forward(req, resp);
            }


        }


    }
}
