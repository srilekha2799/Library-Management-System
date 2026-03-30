package model;

import java.sql.Date;

public class Issue {

    private int issueID;
    private int bookID;
    private int userID;
    private Date issueDate;
    private Date returnDate;

    public Issue(int issueID, int bookID, int userID, Date issueDate, Date returnDate) {
        this.issueID = issueID;
        this.bookID = bookID;
        this.userID = userID;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getIssueID() { return issueID; }
    public int getBookID() { return bookID; }
    public int getUserID() { return userID; }
    public Date getIssueDate() { return issueDate; }
    public Date getReturnDate() { return returnDate; }
}