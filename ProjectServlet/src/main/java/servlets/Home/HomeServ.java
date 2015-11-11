package servlets.Home;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/Authorization/Home.jsp").forward(req, resp);

    }
}

