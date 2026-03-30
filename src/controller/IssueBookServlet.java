package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Date;

import model.Issue;
import service.LibraryService;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int issueID = Integer.parseInt(request.getParameter("issueID"));
            int bookID = Integer.parseInt(request.getParameter("bookID"));
            int userID = Integer.parseInt(request.getParameter("userID"));

            Date issueDate = new Date(System.currentTimeMillis());
            Date returnDate = null;


            System.out.println(" ISSUE SERVLET HIT");

            Issue issue = new Issue(issueID, bookID, userID, issueDate, returnDate);

            LibraryService service = new LibraryService();
            model.Book book = service.getBookById(bookID);

            if (book.getQuantity() <= 0) {
                response.getWriter().println("Book not available ");
                return;
            }
            service.issueBook(issue);

            response.getWriter().println("<h3 style='color:green;'>Book Issued Successfully </h3>");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error occurred ");
        }
    }
}