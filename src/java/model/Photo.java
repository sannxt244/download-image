/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sannx
 */
public class Photo {

    private int id;
    private String album_id;
    private String user_id;
    private String title;
    private String description;
    private String privacy;
    private String uploadDate;
    private int view;
    private String imagePath;
    private ArrayList<String> tags = new ArrayList<>();

    public Photo() {
        
    }

    public Photo(int id, String album_id, String user_id, String title, String description, String privacy, String uploadDate, int view, String imagePath) {
        this.id = id;
        this.album_id = album_id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.privacy = privacy;
        this.uploadDate = uploadDate;
        this.view = view;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", album_id=" + album_id + ", user_id=" + user_id + ", title=" + title + ", description=" + description + ", privacy=" + privacy + ", uploadDate=" + uploadDate + ", view=" + view + ", imagePath=" + imagePath + ", tags=" + tags + '}';
    }
    
}
