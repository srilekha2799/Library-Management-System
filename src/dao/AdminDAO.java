package dao;

import database.DBconnection;
import java.sql.*;

public class AdminDAO {

    public boolean validateAdmin(String username, String password) {
        boolean status = false;

        try {
            Connection conn = DBconnection.getConnection();

            String sql = "SELECT * FROM Admin WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}