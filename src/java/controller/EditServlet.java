/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author sannx
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {

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
            out.println("<title>Servlet EditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String field = request.getParameter("field");
        if (field.equals("name")) {
            out.print("<form action=\"edit\" method=\"post\">\n"
                    + "                                    <input name=\"name\"/>\n"
                    + "                                    <input type=\"submit\" value=\"save\"/>\n"
                    + "                                </form>");
        } else if (field.equals("phone")) {
            out.print("<form action=\"edit\" method=\"post\">\n"
                    + "                                    <input name=\"phone\"/>\n"
                    + "                                    <input type=\"submit\" value=\"save\"/>\n"
                    + "                                </form>");
        } else if (field.equals("email")) {
            out.print("<form action=\"edit\" method=\"post\">\n"
                    + "                                    <input name=\"email\"/>\n"
                    + "                                    <input type=\"submit\" value=\"save\"/>\n"
                    + "                                </form>");
        } else if (field.equals("address")) {
            out.print("<form action=\"edit\" method=\"post\">\n"
                    + "                                    <input name=\"address\"/>\n"
                    + "                                    <input type=\"submit\" value=\"save\"/>\n"
                    + "                                </form>");
        } else if (field.equals("password")) {
            out.print("<form class=\"login--form\" action=\"edit\" method=\"post\">\n"
                    + "                                <div class=\"password\">\n"
                    + "                                    <label for=\"password\">Old password</label>\n"
                    + "                                    <input type=\"password\" name=\"password\"/>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"password\">\n"
                    + "                                    <label for=\"password\">New password</label>\n"
                    + "                                    <input type=\"password\" name=\"confirm\"/>\n"
                    + "                                </div>\n"
                    + "                                <input type=\"submit\" value=\"save\"> \n"
                    + "                            </form>");
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
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (name != null) {
            user.setName(name);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        if (email != null) {
            user.setEmail(email);
        }
        if (address != null) {
            user.setAddress(address);
        }
        if(password != null && password.equals(user.getPassword())) {
            user.setPassword(confirm);
        }
        UserDAO udao = new UserDAO();
        udao.update(user);
        response.sendRedirect("settings");
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
