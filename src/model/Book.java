package model;

public class Book {

    private int bookID;
    private String title;
    private String author;
    private String category;
    private int quantity;

    public Book(int bookID, String title, String author, String category, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}