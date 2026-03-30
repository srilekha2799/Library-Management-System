package model;

public class User {

    private int userID;
    private String name;
    private String department;
    private String phone;

    public User(int userID, String name, String department, String phone) {
        this.userID = userID;
        this.name = name;
        this.department = department;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPhone() {
        return phone;
    }
}