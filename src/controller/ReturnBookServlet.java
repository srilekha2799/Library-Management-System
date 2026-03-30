package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import service.LibraryService;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int issueID = Integer.parseInt(request.getParameter("issueID"));

        System.out.println(" RETURN SERVLET HIT");

        LibraryService service = new LibraryService();
        service.returnBook(issueID);

        response.getWriter().println("<h3 style='color:green;'>Book Returned Successfully </h3>");
    }
}