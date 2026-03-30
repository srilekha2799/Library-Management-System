package service;

import java.util.List;
import dao.BookDAO;
import dao.UserDAO;
import dao.IssueDAO;
import model.Book;
import model.User;
import model.Issue;

public class LibraryService {

    BookDAO bookDAO = new BookDAO();
    UserDAO userDAO = new UserDAO();
    IssueDAO issueDAO = new IssueDAO();

    public void addBook(Book book) {
        BookDAO dao = new BookDAO();
        dao.addBook(book);
    }

    public java.util.List<Book> getAllBooks() {
        dao.BookDAO dao = new dao.BookDAO();
        return dao.getAllBooks();
    }

    public void addUser(User user) {
        dao.UserDAO dao = new dao.UserDAO();
        dao.addUser(user);
    }

    public java.util.ArrayList<User> getAllUsers() {
        dao.UserDAO dao = new dao.UserDAO();
        return dao.getAllUsers();
    }

    public void issueBook(Issue issue) {
        dao.IssueDAO dao = new dao.IssueDAO();
        dao.issueBook(issue);
    }

    public void viewBooks(){
        bookDAO.viewBooks();
    }

    public void returnBook(int issueID) {
        dao.IssueDAO dao = new dao.IssueDAO();
        dao.returnBook(issueID);
    }

    public boolean validateAdmin(String username, String password) {
        dao.AdminDAO dao = new dao.AdminDAO();
        return dao.validateAdmin(username, password);
    }

    public model.Book getBookById(int bookID) {
        dao.BookDAO dao = new dao.BookDAO();
        return dao.getBookById(bookID);
    }

    public List<Book> searchBook(String title){
        dao.BookDAO dao = new dao.BookDAO();
        return dao.searchBook(title);
    }
}