/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author sannx
 */
public class UserDAO extends DBContext {

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        //lenh sql
        String sql = "SELECT * FROM [Imageram].[dbo].[Users]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setAvatar(rs.getString("avatar"));
                list.add(user);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public void insert(User user) {
        String sql = "INSERT INTO [Imageram].[dbo].[Users]([id],[password])VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getId());
            st.setString(2, user.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(User user) {
        String sql = "UPDATE [Imageram].[dbo].[Users]\n"
                + "   SET [password] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[avatar] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user.getPassword());
            st.setString(2, user.getName());
            st.setString(3, user.getPhone());
            st.setString(4, user.getEmail());
            st.setString(5, user.getAddress());
            st.setString(6, user.getAvatar());
            st.setString(7, user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User getUser(String id, String password) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE id=? AND [password]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setAvatar(rs.getString("avatar"));
            }

        } catch (SQLException e) {
        }
        return user;
    }

    public void delete(String id) {
        String sql = "DELETE FROM [Imageram].[dbo].[Users]\n"
                + "      WHERE [id]=?";
        String sql1 = "DELETE FROM [Imageram].[dbo].[Photos]\n"
                + "      WHERE [user_id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st.setString(1, id);
            st1.setString(1, id);
            st.executeUpdate();
            st1.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        UserDAO udao = new UserDAO();
        udao.delete("abc");
    }

    public ArrayList<String> pagination(int page, int total) {
        int current = page, last = total, delta = 2, left = current - delta, right = current + delta + 1, l = -1;
        ArrayList<Integer> range = new ArrayList<>();
        ArrayList<String> rangeWithDots = new ArrayList<>();

        for (int i = 1; i <= last; i++) {
            if (i == 1 || i == last || i >= left && i < right) {
                range.add(i);
            }
        }

        for (Integer i : range) {
            if (l != -1) {
                if (i - l == 2) {
                    rangeWithDots.add(Integer.toString(l + 1));
                } else if (i - l != 1) {
                    rangeWithDots.add("...");
                }
            }
            rangeWithDots.add(Integer.toString(i));
            l = i;
        }

        return rangeWithDots;
    }

    public void updateAvatar(String id, String string) {
        String sql = "UPDATE [Imageram].[dbo].[Users]\n"
                + "   SET [avatar] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, id);
            st.setString(1, string);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
