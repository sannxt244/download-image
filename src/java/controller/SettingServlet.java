/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.PhotoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SettingServlet extends HttpServlet {

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
            out.println("<title>Servlet SettingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingServlet at " + request.getContextPath() + "</h1>");
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
        String tab = "general";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
        } else {
            request.setAttribute("tab", tab);
            request.setAttribute("username", user);
            request.getRequestDispatcher("setting.jsp").forward(request, response);
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
        String tab = request.getParameter("tab");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login");
        } 
        if (tab.equals("general")) {
            out.print("<h3>General setting</h3>\n"
                    + "                    <table>\n"
                    + "                        <tr>\n"
                    + "                            <td>Name</td>\n"
                    + "                            <td id=\"name\">\n"
                    + "                                <div>\n"
                    + user.getName()
                    + "                            </div>\n"
                    + "                            <div>\n"
                    + "                                <a onclick=\"makeInput('name')\">Edit</a>\n"
                    + "                            </div>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Phone</td>\n"
                    + "                        <td id=\"phone\">\n"
                    + "                            <div>\n"
                    + user.getPhone()
                    + "                            </div>\n"
                    + "                            <div>\n"
                    + "                                <a onclick=\"makeInput('phone')\">Edit</a>\n"
                    + "                            </div>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Contact</td>\n"
                    + "                        <td id=\"email\">\n"
                    + "                            <div>\n"
                    + user.getEmail()
                    + "                            </div>\n"
                    + "                            <div>\n"
                    + "                                <a onclick=\"makeInput('email')\">Edit</a>\n"
                    + "                            </div>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td>Address</td>\n"
                    + "                        <td id=\"address\">\n"
                    + "                            <div>\n"
                    + user.getAddress()
                    + "                            </div>\n"
                    + "                            <div>\n"
                    + "                                <a onclick=\"makeInput('address')\">Edit</a>\n"
                    + "                            </div>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                </table>");
        } else if (tab.equals("security")) {
            out.print("<h3>Security setting</h3>\n" +
"                <table style=\"width:100%\">\n" +
"                    <tr>\n" +
"                        <td>Change your password</td>\n" +
"                        <td id=\"password\">\n" +
"                            <div>\n" +
"                                ******************\n" +
"                            </div>\n" +
"                            <div>\n" +
"                                <a onclick=\"makeInput('password')\">Edit</a>\n" +
"                            </div>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </table>   ");
        }
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
