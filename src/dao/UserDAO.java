package dao;

import database.DBconnection;
import model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {

    public void addUser(User user) {
        try {
            Connection conn = DBconnection.getConnection();

            String sql = "INSERT INTO User (UserID, Name, Department, Phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getName());
            ps.setString(3, user.getDepartment());
            ps.setString(4, user.getPhone());

            ps.executeUpdate();

            System.out.println("🔥 User Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> list = new ArrayList<>();

        try {
            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM User";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new User(
                        rs.getInt("UserID"),
                        rs.getString("Name"),
                        rs.getString("Department"),
                        rs.getString("Phone")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}