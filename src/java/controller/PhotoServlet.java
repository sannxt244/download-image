/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FollowerDAO;
import dal.PhotoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Photo;
import model.User;

/**
 *
 * @author sannx
 */
public class PhotoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PhotoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PhotoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id_raw = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
        }
        User user = (User) session.getAttribute("user");
        PhotoDAO pdao = new PhotoDAO();
        pdao.increaseView(id);
        List<Photo> list = pdao.getAll(null, null);
        Photo photo = pdao.getImageById(list, id);
        if (user != null) {
            FollowerDAO fdao = new FollowerDAO();
            request.setAttribute("isfollow", fdao.isFollow(photo.getUser_id(), user.getId())); 
            request.setAttribute("userid", user.getId());
        }
        if (photo.getTags().size() > 0) {
            List<Photo> relatePhoto = new ArrayList<>();
            List<Photo> temp;
            for (String tag : photo.getTags()) {
                temp = pdao.getImageByTag(tag);
                relatePhoto.addAll(temp);
            }
            relatePhoto = removeDuplicates(relatePhoto, photo.getId());
            
            request.setAttribute("relatePhoto", relatePhoto);
        }
        request.setAttribute("photo", photo);
        request.getRequestDispatcher("photo.jsp").forward(request, response);

    }

    public ArrayList<Photo> removeDuplicates(List<Photo> list, int id) {
        LinkedHashMap<Integer, Photo> linkedHashMap = new LinkedHashMap<>();
        for (Photo photo : list) {
            linkedHashMap.put(photo.getId(), photo);
        }
        linkedHashMap.remove(id);
        return new ArrayList<Photo>(linkedHashMap.values());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
