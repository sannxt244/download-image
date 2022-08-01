/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AdminDAO;
import dal.ViewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Stat;
import model.User;

/**
 *
 * @author sannx
 */
public class AdminServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet AdminServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action=\"admin\" method=\"post\">\n"
                + "                    Admin ID: <input type=\"text\" name=\"username\"/><br/>\n"
                + "                    Password: <input type=\"password\" name=\"password\"/><br/>\n"
                + "                    <button type=\"submit\">Login</button>\n"
                + "                </form>");
        out.println("</body>");
        out.println("</html>");
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
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDAO adao = new AdminDAO();
        User admin = adao.getAdmin(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);
        if (admin != null) {
            ArrayList<Stat> list = adao.getStat();
            ArrayList<Stat> newList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                newList.add(list.get(i));
            }
            Stat stat = new Stat(5, "Other", 0);
            for (int i = 4; i < list.size(); i++) {
                stat.setAmount(stat.getAmount() + list.get(i).getAmount());
            }
            newList.add(stat);
            ArrayList<Stat> list2 = adao.getStat2();
            
            request.setAttribute("data1", newList);
            request.setAttribute("data2", list2);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            out.print("access denied!");
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
