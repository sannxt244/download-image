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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "ListServlet", urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {

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
            out.println("<title>Servlet ListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListServlet at " + request.getContextPath() + "</h1>");
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
        PhotoDAO pdao = new PhotoDAO();
        FollowerDAO fdao = new FollowerDAO();
        List<Photo> listPhoto = pdao.getAll(null, null);
        String pageid_raw = request.getParameter("page");
        String tagTitle = request.getParameter("tagTitle");
        User user = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();
        if(tagTitle != null) {
            listPhoto = pdao.getImageByTag(tagTitle);
        } 
        if(tagTitle.equals("all")) {
            listPhoto = pdao.getAll(null, null);
        }
        if(tagTitle.equals("follow") && user != null) {
            listPhoto = pdao.getFollowerPhotos(user.getId(), null, null);
        }
        
        int pageid = 1;
        if (pageid_raw != null) {
            try {
                pageid = Integer.parseInt(pageid_raw);
            } catch (NumberFormatException e) {
            }
        }
        int total = 3;
        int totalPage = listPhoto.size() % total == 0 ? listPhoto.size() / total : listPhoto.size() / total + 1;
        listPhoto = pdao.getRecord(listPhoto, pageid, total);
        for (Photo photo : listPhoto) {
            out.println("<a href=\"photo?id="+photo.getId()+"\" class=\"image\">\n"
                    + "       <img src=\""+photo.getImagePath()+"\">\n"
                    + "  </a>");
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
