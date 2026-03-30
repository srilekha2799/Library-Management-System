package ui;

import model.Book;
import model.User;
import model.Issue;
import service.LibraryService;

import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {

            System.out.println("\n1 Add Book");
            System.out.println("2 Add User");
            System.out.println("3 Issue Book");
            System.out.println("4 Return Book");
            System.out.println("5 View Book");
            System.out.println("6 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Book ID:");
                    int bid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Title:");
                    String title = sc.nextLine();

                    System.out.println("Enter Author:");
                    String author = sc.nextLine();

                    System.out.println("Enter Category:");
                    String category = sc.nextLine();

                    System.out.println("Enter Quantity:");
                    int qty = sc.nextInt();

                    service.addBook(new Book(bid, title, author, category, qty));
                    break;

                case 2:
                    System.out.println("Enter User ID:");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Name:");
                    String name = sc.nextLine();

                    System.out.println("Enter Department:");
                    String dept = sc.nextLine();

                    System.out.println("Enter Phone:");
                    String phone = sc.nextLine();

                    service.addUser(new User(uid, name, dept, phone));
                    break;

                case 3:
                    System.out.println("Enter Issue ID:");
                    int iid = sc.nextInt();

                    System.out.println("Enter Book ID:");
                    int bookid = sc.nextInt();

                    System.out.println("Enter User ID:");
                    int userid = sc.nextInt();

                    Date issueDate = new Date(System.currentTimeMillis());
                    Date returnDate = new Date(System.currentTimeMillis());

                    service.issueBook(new Issue(iid, bookid, userid, issueDate, returnDate));
                    break;

                case 4:

                    System.out.println("Enter Issue ID to return:");

                    int issueID = sc.nextInt();

                    service.returnBook(issueID);

                    break;

                case 5:

                    service.viewBooks();

                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}