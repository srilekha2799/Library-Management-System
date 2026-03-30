package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

import model.Book;
import service.LibraryService;
import javax.servlet.annotation.WebServlet;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println((" SERVLET HIT"));
        int id = Integer.parseInt(request.getParameter("bookID"));
        String title = request.getParameter("title");
        System.out.println(title);
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Book book = new Book(id, title, author, category, quantity);

        LibraryService service = new LibraryService();
        service.addBook(book);
        response.getWriter().println("<h3 style='color:green;'>Book Added Successfully </h3>" + "<a href='dashboard.jsp'>Go to Dashboard</a>");
    }
}