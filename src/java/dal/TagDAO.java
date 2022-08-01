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
import model.Photo;
import model.Tag;

/**
 *
 * @author sannx
 */
public class TagDAO extends DBContext {

    public List<Tag> getAll() {
        List<Tag> list = new ArrayList<>();
        //lenh sql
        String sql = "SELECT * FROM Tags";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setId(rs.getString("id"));
                tag.setTitle(rs.getString("title"));

                list.add(tag);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public void insert(int id, String[] selectTag_raw) {
        List<Integer> selectTag = new ArrayList<>();

        for (String selectTag_raw1 : selectTag_raw) {
            try {
                selectTag.add(Integer.parseInt(selectTag_raw1));
            } catch (NumberFormatException e) {
            }
        }

        String sql = "INSERT INTO [Imageram].[dbo].[Tag_Photo]\n"
                + "([tag_id],[photo_id])\n"
                + "VALUES(?," + id + ")";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            for (int i : selectTag) {
                if (!checkTag(i, id)) {
                    st.setInt(1, i);
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Tag> getTrendingTag() {
        List<Tag> list = new ArrayList<>();
        //lenh sql
        String sql = "select TOP 5 tag_id, title, COUNT(*) as amount from (select tp.tag_id, tp.photo_id, t.title from Tag_Photo tp\n"
                + "JOIN Tags t ON tp.tag_id = t.id) t\n"
                + "GROUP BY tag_id, title\n"
                + "ORDER BY amount DESC";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setId(rs.getString("tag_id"));
                tag.setTitle(rs.getString("title"));
                list.add(tag);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public boolean checkTag(int tag_id, int photo_id) {
        String sql = "SELECT * FROM Tag_Photo\n"
                + "WHERE tag_id = " + tag_id + " AND photo_id = " + photo_id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;

    }

    public static void main(String args[]) {
        TagDAO tdao = new TagDAO();
        System.out.println(tdao.checkTag(18, 29));
    }

}
