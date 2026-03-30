package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import model.Book;
import service.LibraryService;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/searchBook")
public class SearchBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");

        LibraryService service = new LibraryService();
        List<Book> list = service.searchBook(title);

        request.setAttribute("books", list);
        RequestDispatcher rd = request.getRequestDispatcher("searchResult.jsp");
        rd.forward(request, response);
    }
}
