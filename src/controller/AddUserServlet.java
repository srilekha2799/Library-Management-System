package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import model.User;
import service.LibraryService;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userID = Integer.parseInt(request.getParameter("userID"));
        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String phone = request.getParameter("phone");

        System.out.println(" USER SERVLET HIT");

        LibraryService service = new LibraryService();
        service.addUser(new User(userID, name, department, phone));

        response.getWriter().println("<h3 style='color:green;'>User Added Successfully </h3>");
        if(name == null || name.isEmpty()){
            response.getWriter().println("Name cannot be empty ");
            return;
        }
    }
}