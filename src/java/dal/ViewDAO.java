/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sannx
 */
public class ViewDAO extends DBContext {

    public int getviews() {
        String sql = "SELECT * FROM [Imageram].[dbo].[PageView]";
        int count = -1;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                count = rs.getInt("view");
            }
            return count;

        } catch (SQLException e) {
        }
        return count;
    }

    public void update() {
        String sql = "UPDATE [PageView]\n"
                + "SET [view] = [view] + 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ViewDAO vdao = new ViewDAO();
        System.out.println(vdao.getviews());
    }
}
