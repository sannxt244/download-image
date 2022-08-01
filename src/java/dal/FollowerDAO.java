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
public class FollowerDAO extends DBContext {

    public int getFollow(String id) {
        //lenh sql
        String sql = "SELECT COUNT(*) as amount FROM [Followers]\n"
                + "WHERE id = '"+id+"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("amount");
            }

        } catch (SQLException e) {
        }
        return 0;
    }

    public void insert(String userId, String followerId) {
        String sql = "INSERT INTO [Imageram].[dbo].[Followers]\n"
                + "           ([id]\n"
                + "           ,[folower_id])\n"
                + "     VALUES('" + userId + "','" + followerId + "')";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(String userId, String followerId) {
        String sql = "DELETE FROM [Imageram].[dbo].[Followers]\n"
                + "WHERE [id]='" + userId + "' AND [folower_id]='" + followerId + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public boolean isFollow(String userId, String followerId) {
        String sql = "SELECT * FROM [Imageram].[dbo].[Followers] WHERE [id]='" + userId + "' AND [folower_id]='" + followerId + "'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public static void main(String[] args) {
        FollowerDAO fdao = new FollowerDAO();
        //fdao.insert("siget", "sannxt");
        fdao.delete("siget", "sannxt");
        System.out.println(fdao.isFollow("siget", "sannxt"));
    }
}
