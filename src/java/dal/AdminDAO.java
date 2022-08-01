/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import model.Stat;
import model.User;

/**
 *
 * @author sannx
 */
public class AdminDAO extends DBContext {

    public User getAdmin(String id, String password) {
        User user = null;
        String sql = "SELECT * FROM [Admin] WHERE id=? AND [password]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public ArrayList<Stat> getStat() {
        ArrayList<Stat> list = new ArrayList<>();
        String sql = "SELECT tag_id, title, COUNT(*) as amount FROM Tag_Photo tp\n"
                + "JOIN Tags t ON tp.tag_id = t.id\n"
                + "GROUP BY tag_id, title\n"
                + "ORDER BY amount DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("tag_id");
                String title = rs.getString("title");
                int amount = rs.getInt("amount");
                list.add(new Stat(id, title, amount));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public int getPhotoPerMonth(int month, int year) {
        String sql = "SELECT COUNT(*) as amount FROM Photos\n"
                + "WHERE MONTH(upload_date) = "+month+" AND YEAR(upload_date) = "+year;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("amount");
                return id;
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public ArrayList<Stat> getStat2() {
        ArrayList<Stat> list = new ArrayList<>();
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 12; i++) {
            int amount = getPhotoPerMonth(currentMonth,currentYear);
            list.add(new Stat(0, String.valueOf(currentMonth), amount));
            currentMonth--;
            if(currentMonth<=0) {
                currentYear--;
                currentMonth = 12;
            }
        }
        Collections.reverse(list);
        return list;
    }
    
    public static void main(String[] args) {
        AdminDAO adao = new AdminDAO();
        ArrayList<Stat> list = adao.getStat2();
        for (Stat stat : list) {
            System.out.println(stat.getTitle()+","+stat.getAmount());
        }
    }
}
