package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import model.Book;
import service.LibraryService;

@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LibraryService service = new LibraryService();

        List<Book> list = service.getAllBooks();

        request.setAttribute("books", list);
        System.out.println("Books size: " + list.size());
        RequestDispatcher rd = request.getRequestDispatcher("viewBooks.jsp");
        rd.forward(request, response);
    }
}