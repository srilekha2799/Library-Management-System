package controller;

import service.LibraryService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(" LOGIN SERVLET HIT");

        LibraryService service = new LibraryService();

        if (service.validateAdmin(username, password)) {
            response.sendRedirect("dashboard.jsp");
        } else {
            response.getWriter().println("<h3 style='color:red;'>Invalid Login </h3>");
        }
    }
}