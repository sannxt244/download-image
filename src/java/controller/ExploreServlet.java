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
import model.Photo;
import model.Tag;

/**
 *
 * @author sannx
 */
public class ExploreServlet extends HttpServlet {

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
            out.println("<title>Servlet CategoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryServlet at " + request.getContextPath() + "</h1>");
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
        TagDAO tdao = new TagDAO();
        List<Tag> listTag = tdao.getAll();
        request.setAttribute("listTag", listTag);
        request.getRequestDispatcher("explore.jsp").forward(request, response);

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
        TagDAO tdao = new TagDAO();
        PhotoDAO pdao = new PhotoDAO();

        String selectedCategory[] = request.getParameterValues("tags");
        String search = request.getParameter("search");
        String order = request.getParameter("order");
        
        request.setAttribute("search", search);
        request.setAttribute("order", order);
        
        List<Tag> listTag = tdao.getAll();

        if (search != null) {
            search = "p.title LIKE '%" + search + "%'";
        }
        
        if(order != null && order.equals("Newest")) {
            order = "upload_date DESC";
        } else if(order != null && order.equals("MostView")) {
            order = "[view] DESC";
        }
        request.setAttribute("listTag", listTag);
        List<Photo> listPhoto = pdao.getAll(search, order);

        if (selectedCategory != null) {
            for (String string : selectedCategory) {
                for (Tag tag : listTag) {
                    if (string.equals(tag.getTitle())) {
                        tag.setChecked(true);
                    }
                }
            }
            List<Photo> list = new ArrayList<>();
            for (Photo photo : listPhoto) {
                int countTags = 0;
                for (String tag : photo.getTags()) {
                    for (int i = 0; i < selectedCategory.length; i++) {
                        if (tag.equals(selectedCategory[i])) {
                            countTags++;
                            break;
                        }
                    }
                }
                if (countTags == selectedCategory.length) {
                    list.add(photo);
                }
            }
            listPhoto = list;
        }
        String pageid_raw = request.getParameter("page");
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
        request.setAttribute("pageid", pageid);
        request.setAttribute("totalPage", totalPage);
        ArrayList<String> pageList = pagination(pageid, totalPage);
        request.setAttribute("pageList", pageList);
        request.setAttribute("listPhoto", listPhoto);
        request.getRequestDispatcher("explore.jsp").forward(request, response);
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
            if (l!=-1) {
                if (i - l == 2) {
                    rangeWithDots.add(Integer.toString(l+1));
                } else if (i - l != 1) {
                    rangeWithDots.add("...");
                }
            }
            rangeWithDots.add(Integer.toString(i));
            l = i;
        }

        return rangeWithDots;
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
