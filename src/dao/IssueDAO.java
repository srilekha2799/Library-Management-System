package dao;

import database.DBconnection;
import model.Issue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueDAO {

    public void issueBook(Issue issue) {

        try {
            Connection conn = DBconnection.getConnection();

            // Check quantity first
            String check = "SELECT Quantity FROM Book WHERE BookID = ?";
            PreparedStatement psCheck = conn.prepareStatement(check);
            psCheck.setInt(1, issue.getBookID());

            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                int qty = rs.getInt("Quantity");

                if (qty <= 0) {
                    System.out.println("❌ Book not available");
                    return;
                }
            } else {
                System.out.println("❌ Book not found");
                return;
            }

            // Insert into Issue table
            String sql1 = "INSERT INTO Issue (IssueID, BookID, UserID, IssueDate, ReturnDate) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps1 = conn.prepareStatement(sql1);

            ps1.setInt(1, issue.getIssueID());
            ps1.setInt(2, issue.getBookID());
            ps1.setInt(3, issue.getUserID());
            ps1.setDate(4, issue.getIssueDate());
            ps1.setNull(5, java.sql.Types.DATE);

            ps1.executeUpdate();

            // 🔹 Reduce quantity
            String sql2 = "UPDATE Book SET Quantity = Quantity - 1 WHERE BookID = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);

            ps2.setInt(1, issue.getBookID());
            ps2.executeUpdate();

            System.out.println("🔥 Issue inserted + quantity updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int issueID) {

        try {
            Connection conn = DBconnection.getConnection();

            // 1. Get BookID from Issue table
            String getBook = "SELECT BookID FROM Issue WHERE IssueID = ?";
            PreparedStatement ps1 = conn.prepareStatement(getBook);
            ps1.setInt(1, issueID);

            ResultSet rs = ps1.executeQuery();

            int bookID = 0;

            if (rs.next()) {
                bookID = rs.getInt("BookID");
            } else {
                System.out.println("❌ Issue not found");
                return;
            }

            // 2. Update return date
            String updateIssue = "UPDATE Issue SET ReturnDate = CURDATE() WHERE IssueID = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateIssue);
            ps2.setInt(1, issueID);
            ps2.executeUpdate();

            // 3. Increase quantity
            String updateBook = "UPDATE Book SET Quantity = Quantity + 1 WHERE BookID = ?";
            PreparedStatement ps3 = conn.prepareStatement(updateBook);
            ps3.setInt(1, bookID);
            ps3.executeUpdate();

            System.out.println("🔥 Book Returned Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}