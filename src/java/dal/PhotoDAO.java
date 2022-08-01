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

/**
 *
 * @author sannx
 */
public class PhotoDAO extends DBContext {

    public static void main(String[] args) {
        PhotoDAO pdao = new PhotoDAO();
        List<Photo> get = pdao.getImageByTag("nature");
        for (Photo photo : get) {
            System.out.println(photo);
        }
    }

    public List<Photo> getAll(String search, String sort) {
        List<Photo> list = new ArrayList<>();
        String sql = "SELECT p.*, t.title as ttitle FROM Photos p \n"
                + "LEFT JOIN Tag_Photo tp ON p.id = tp.photo_id\n"
                + "LEFT JOIN Tags t ON tp.tag_id = t.id\n";
        if (search != null) {
            sql += "WHERE " + search + "\n";
        }
        if (sort != null) {
            sql += "ORDER BY " + sort + "\n";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Photo photo = getImageById(list, id);
                if (photo != null) {
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                } else {
                    photo = new Photo();
                    photo.setId(id);
                    photo.setAlbum_id(rs.getString("album_id"));
                    photo.setUser_id(rs.getString("user_id"));
                    photo.setTitle(rs.getString("title"));
                    photo.setDescription(rs.getString("description"));
                    photo.setPrivacy(rs.getString("privacy"));
                    photo.setUploadDate(rs.getString("upload_date"));
                    photo.setView(rs.getInt("view"));
                    photo.setImagePath(rs.getString("image_path"));
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                    list.add(photo);
                }
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public Photo getImageById(List<Photo> list, int id) {
        for (Photo photo : list) {
            if (photo.getId() == id) {
                return photo;
            }
        }
        return null;
    }

    public List<Photo> getImageByTag(String tag) {
        List<Photo> list = new ArrayList<>();
        //lenh sql
        String sql = "SELECT p.*, t.title as ttitle FROM Photos p \n"
                + "JOIN Tag_Photo tp ON p.id = tp.photo_id\n"
                + "JOIN Tags t ON tp.tag_id = t.id\n"
                + "where t.title = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tag);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Photo photo = getImageById(list, id);
                if (photo != null) {
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                } else {
                    photo = new Photo();
                    photo.setId(id);
                    photo.setAlbum_id(rs.getString("album_id"));
                    photo.setUser_id(rs.getString("user_id"));
                    photo.setTitle(rs.getString("title"));
                    photo.setDescription(rs.getString("description"));
                    photo.setPrivacy(rs.getString("privacy"));
                    photo.setUploadDate(rs.getString("upload_date"));
                    photo.setView(rs.getInt("view"));
                    photo.setImagePath(rs.getString("image_path"));
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                    list.add(photo);
                }
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Photo> getImageByTitle(String title) {
        List<Photo> list = new ArrayList<>();
        //lenh sql
        String sql = "select * from Photos Where title LIKE ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + title + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Photo photo = new Photo();
                photo.setId(rs.getInt("id"));
                photo.setAlbum_id(rs.getString("album_id"));
                photo.setUser_id(rs.getString("user_id"));
                photo.setTitle(rs.getString("title"));
                photo.setDescription(rs.getString("description"));
                photo.setPrivacy(rs.getString("privacy"));
                photo.setUploadDate(rs.getString("upload_date"));
                photo.setView(rs.getInt("view"));
                photo.setImagePath(rs.getString("image_path"));
                list.add(photo);
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public List<Photo> getImageByUserId(String username) {
        List<Photo> list = new ArrayList<>();
        //lenh sql
        String sql = "select p.*, t.title as ttitle from Photos p \n"
                + "left join Tag_Photo tp on p.id = tp.photo_id\n"
                + "left join Tags t on tp.tag_id = t.id Where p.user_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Photo photo = getImageById(list, id);
                if (photo != null) {
                    photo.getTags().add(rs.getString("ttitle"));
                } else {
                    photo = new Photo();
                    photo.setId(id);
                    photo.setAlbum_id(rs.getString("album_id"));
                    photo.setUser_id(rs.getString("user_id"));
                    photo.setTitle(rs.getString("title"));
                    photo.setDescription(rs.getString("description"));
                    photo.setPrivacy(rs.getString("privacy"));
                    photo.setUploadDate(rs.getString("upload_date"));
                    photo.setView(rs.getInt("view"));
                    photo.setImagePath(rs.getString("image_path"));
                    photo.getTags().add(rs.getString("ttitle"));
                    list.add(photo);
                }
            }

        } catch (SQLException e) {
        }
        return list;
    }

    public void insert(Photo photo) {
        String sql = "INSERT INTO [Imageram].[dbo].[Photos]\n"
                + "           ([album_id]\n"
                + "           ,[user_id]\n"
                + "           ,[title]\n"
                + "           ,[description]\n"
                + "           ,[privacy]\n"
                + "           ,[upload_date]\n"
                + "           ,[image_path])\n"
                + "     VALUES (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,GETDATE()\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, photo.getAlbum_id());
            st.setString(2, photo.getUser_id());
            st.setString(3, photo.getTitle());
            st.setString(4, photo.getDescription());
            st.setString(5, photo.getPrivacy());
            st.setString(6, photo.getImagePath());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Photo photo) {
        String sql = "UPDATE [Imageram].[dbo].[Photos]\n"
                + "   SET [album_id] = ?\n"
                + "      ,[user_id] = ?\n"
                + "      ,[title] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[image_path] = ?\n"
                + " WHERE [id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, photo.getAlbum_id());
            st.setString(2, photo.getUser_id());
            st.setString(3, photo.getTitle());
            st.setString(4, photo.getDescription());
            st.setString(5, photo.getImagePath());
            st.setInt(6, photo.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [Imageram].[dbo].[Photos]\n"
                + "      WHERE [id]=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Photo> getImageByPage(int page, List<Photo> listPhoto) {
        List<Photo> list = new ArrayList<>();
        int numberImg = 6;
        int start = numberImg * (page - 1) + 1;
        int end = numberImg * (page - 1) + numberImg;
        for (int i = start; i <= end; i++) {
            list.add(listPhoto.get(i));
        }
        return list;
    }

    public List<Photo> getRecord(List<Photo> list, int page, int total) {
        page--;
        List<Photo> listPhoto = new ArrayList<>();
        int start = page * total;
        int end = start + total;
        if (start + total - 1 >= list.size()) {
            end = list.size();
        }
        for (int i = start; i < end; i++) {
            listPhoto.add(list.get(i));
        }
        return listPhoto;
    }

    public void increaseView(int id) {
        String sql_getView = "SELECT [view] FROM [Imageram].[dbo].[Photos] \n"
                + "WHERE id = " + id;
        String sql = "UPDATE [Imageram].[dbo].[Photos]\n"
                + "SET [view] = ?\n"
                + "WHERE id = " + id;
        try {
            PreparedStatement st1 = connection.prepareStatement(sql_getView);
            PreparedStatement st2 = connection.prepareStatement(sql);
            ResultSet rs1 = st1.executeQuery();
            int view;
            if (rs1.next()) {
                if (rs1.getString("view") == null) {
                    view = 0;
                } else {
                    view = Integer.parseInt(rs1.getString("view"));
                }
                st2.setInt(1, ++view);
            }
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Photo> getFollowerPhotos(String userid, String search, String sort) {
        List<Photo> list = new ArrayList<>();
        String sql = "SELECT p.*, t.title as ttitle FROM Photos p\n"
                + "LEFT JOIN Tag_Photo tp ON p.id = tp.photo_id\n"
                + "LEFT JOIN Tags t ON tp.tag_id = t.id\n"
                + "LEFT JOIN [Followers] f ON f.id = p.user_id\n"
                + "WHERE f.folower_id = '"+userid+"'";
        if (search != null) {
            sql += "WHERE " + search + "\n";
        }
        if (sort != null) {
            sql += "ORDER BY " + sort + "\n";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                Photo photo = getImageById(list, id);
                if (photo != null) {
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                } else {
                    photo = new Photo();
                    photo.setId(id);
                    photo.setAlbum_id(rs.getString("album_id"));
                    photo.setUser_id(rs.getString("user_id"));
                    photo.setTitle(rs.getString("title"));
                    photo.setDescription(rs.getString("description"));
                    photo.setPrivacy(rs.getString("privacy"));
                    photo.setUploadDate(rs.getString("upload_date"));
                    photo.setView(rs.getInt("view"));
                    photo.setImagePath(rs.getString("image_path"));
                    if (rs.getString("ttitle") != null) {
                        photo.getTags().add(rs.getString("ttitle"));
                    }
                    list.add(photo);
                }
            }

        } catch (SQLException e) {
        }
        return list;
    }
}
