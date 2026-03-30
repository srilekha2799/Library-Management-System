package dao;

import java.util.*;
import database.DBconnection;
import model.Book;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {

    public void addBook(Book book) {

        try {
            Connection conn = DBconnection.getConnection();
            System.out.println("Connection: " + conn);
            conn.setAutoCommit(true);
            String sql = "INSERT INTO Book VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, book.getBookID());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getCategory());
            ps.setInt(5, book.getQuantity());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewBooks() {

        try {

            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM Book";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("BookID | Title | Author | Category | Quantity");

            while(rs.next()){

                System.out.println(
                        rs.getInt("BookID") + " | " +
                                rs.getString("Title") + " | " +
                                rs.getString("Author") + " | " +
                                rs.getString("Category") + " | " +
                                rs.getInt("Quantity")
                );
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {

        List<Book> list = new ArrayList<>();

        try {
            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM Book";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Book book = new Book(
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Category"),
                        rs.getInt("Quantity")
                );

                list.add(book);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Book getBookById(int bookID) {
        Book book = null;

        try {
            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM Book WHERE BookID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Category"),
                        rs.getInt("Quantity")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    public List<Book> searchBook(String title) {
        List<Book> list = new ArrayList<>();

        try {
            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM Book WHERE Title LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getString("Category"),
                        rs.getInt("Quantity")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}