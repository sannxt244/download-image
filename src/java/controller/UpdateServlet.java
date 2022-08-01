/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.PhotoDAO;
import dal.TagDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Photo;
import model.Tag;
import model.User;

/**
 *
 * @author sannx
 */
public class UpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
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
        String id_raw = request.getParameter("id");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PhotoDAO pdao = new PhotoDAO();
        TagDAO tdao = new TagDAO();

        if (user == null) {
            response.sendRedirect("login");
        } else {
            int id = Integer.parseInt(id_raw);
            Photo photo = pdao.getImageById(pdao.getImageByUserId(user.getId()), id);
            List<Tag> listTag = tdao.getAll();
            ArrayList<String> selectedTag = photo.getTags();
//            for (String string : selectedTag) {
//                for (Tag tag : listTag) {
//                    if (string.equals(tag.getTitle())) {
//                        tag.setChecked(true);
//                    }
//                }
//            }
            request.setAttribute("selectedTag", photo.getTags());
            request.setAttribute("listTag", listTag);
            request.setAttribute("photo", photo);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
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
        HttpSession session = request.getSession();
        PhotoDAO pdao = new PhotoDAO();
        TagDAO tdao = new TagDAO();

        String id_raw = request.getParameter("id");
        int id = -1;
        try {
            id = Integer.parseInt(id_raw);
        } catch (Exception e) {
        }
        String album_id = request.getParameter("album_id");
        String user_id = request.getParameter("user_id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String imagePath = request.getParameter("imagePath");
        String selectTag[] = request.getParameterValues("tags");
        
        tdao.insert(id, selectTag);
        Photo photo = new Photo(id, album_id, user_id, title, description, "", "", 0, imagePath);
        pdao.update(photo);
        request.getRequestDispatcher("post.jsp").forward(request, response);
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
