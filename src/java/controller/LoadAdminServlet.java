/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.FollowerDAO;
import dal.PhotoDAO;
import dal.UserDAO;
import dal.ViewDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Photo;
import model.User;

/**
 *
 * @author sannx
 */
@WebServlet(name = "LoadAdminServlet", urlPatterns = {"/loadadmin"})
public class LoadAdminServlet extends HttpServlet {

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
        String action = request.getParameter("action");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (action.equals("loadadmin")) {
                out.print("<div class=\"row\">\n"
                        + "                        <div class=\"col-sm-12\">\n"
                        + "                            <div class=\"tab-content tab-content-basic\">\n"
                        + "                                <div class=\"tab-pane fade show active\" id=\"overview\" role=\"tabpanel\" aria-labelledby=\"overview\"> \n"
                        + "                                    <div class=\"row\">\n"
                        + "                                        <div class=\"col-sm-12\">\n"
                        + "                                            <div class=\"statistics-details d-flex align-items-center justify-content-between\">\n"
                        + "                                                <div>\n"
                        + "                                                    <p class=\"statistics-title\">Bounce Rate</p>\n"
                        + "                                                    <h3 class=\"rate-percentage\">32.53%</h3>\n"
                        + "                                                    <p class=\"text-danger d-flex\"><i class=\"mdi mdi-menu-down\"></i><span>-0.5%</span></p>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div> \n"
                        + "                                    <div class=\"row\">\n"
                        + "                                        <div class=\"col-lg-8 d-flex flex-column\">\n"
                        + "                                            <div class=\"row flex-grow\">\n"
                        + "                                                <div class=\"col-12 col-lg-4 col-lg-12 grid-margin stretch-card\">\n"
                        + "                                                    <div class=\"card card-rounded\">\n"
                        + "                                                        <div class=\"card-body\">\n"
                        + "                                                            <div class=\"d-sm-flex justify-content-between align-items-start\">\n"
                        + "                                                                <div>\n"
                        + "                                                                    <h4 class=\"card-title card-title-dash\">Performance Line Chart</h4>\n"
                        + "                                                                    <h5 class=\"card-subtitle card-subtitle-dash\">Lorem Ipsum is simply dummy text of the printing</h5>\n"
                        + "                                                                </div>\n"
                        + "                                                                <div id=\"performance-line-legend\"></div>\n"
                        + "                                                            </div>\n"
                        + "                                                            <div class=\"chartjs-wrapper mt-5\">\n"
                        + "                                                                <canvas id=\"performaneLine\"></canvas>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                        <div class=\"col-lg-4 d-flex flex-column\">\n"
                        + "                                            <div class=\"row flex-grow\">\n"
                        + "                                                <div class=\"col-md-6 col-lg-12 grid-margin stretch-card\">\n"
                        + "                                                    <div class=\"card card-rounded\">\n"
                        + "                                                        <div class=\"card-body\">\n"
                        + "                                                            <div class=\"row\">\n"
                        + "                                                                <div class=\"col-sm-6\">\n"
                        + "                                                                    <div class=\"d-flex justify-content-between align-items-center mb-2 mb-sm-0\">\n"
                        + "                                                                        <div class=\"circle-progress-width\">\n"
                        + "                                                                            <div id=\"totalVisitors\" class=\"progressbar-js-circle pr-2\"></div>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div>\n"
                        + "                                                                            <p class=\"text-small mb-2\">Total Visitors</p>\n"
                        + "                                                                            <h4 class=\"mb-0 fw-bold\">26.80%</h4>\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </div>\n"
                        + "                                                                </div>\n"
                        + "                                                                <div class=\"col-sm-6\">\n"
                        + "                                                                    <div class=\"d-flex justify-content-between align-items-center\">\n"
                        + "                                                                        <div class=\"circle-progress-width\">\n"
                        + "                                                                            <div id=\"visitperday\" class=\"progressbar-js-circle pr-2\"></div>\n"
                        + "                                                                        </div>\n"
                        + "                                                                        <div>\n"
                        + "                                                                            <p class=\"text-small mb-2\">Visits per day</p>\n"
                        + "                                                                            <h4 class=\"mb-0 fw-bold\">9065</h4>\n"
                        + "                                                                        </div>\n"
                        + "                                                                    </div>\n"
                        + "                                                                </div>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                    <div class=\"row\">\n"
                        + "                                        <div class=\"row flex-grow\">\n"
                        + "                                            <div class=\"col-md-6 col-lg-6 grid-margin stretch-card\">\n"
                        + "                                                <div class=\"card card-rounded\">\n"
                        + "                                                    <div class=\"card-body\">\n"
                        + "                                                        <div class=\"d-flex align-items-center justify-content-between mb-3\">\n"
                        + "                                                            <h4 class=\"card-title card-title-dash\">Activities</h4>\n"
                        + "                                                        </div>\n"
                        + "                                                        <ul class=\"bullet-line-list\">\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Ben Tossell</span> assign you a task</div>\n"
                        + "                                                                    <p>Just now</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Oliver Noah</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Jack William</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Leo Lucas</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Thomas Henry</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Ben Tossell</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                            <li>\n"
                        + "                                                                <div class=\"d-flex justify-content-between\">\n"
                        + "                                                                    <div><span class=\"text-light-green\">Ben Tossell</span> assign you a task</div>\n"
                        + "                                                                    <p>1h</p>\n"
                        + "                                                                </div>\n"
                        + "                                                            </li>\n"
                        + "                                                        </ul>\n"
                        + "                                                        <div class=\"list align-items-center pt-3\">\n"
                        + "                                                            <div class=\"wrapper w-100\">\n"
                        + "                                                                <p class=\"mb-0\">\n"
                        + "                                                                    <a href=\"#\" class=\"fw-bold text-primary\">Show all <i class=\"mdi mdi-arrow-right ms-2\"></i></a>\n"
                        + "                                                                </p>\n"
                        + "                                                            </div>\n"
                        + "                                                        </div>\n"
                        + "                                                    </div>\n"
                        + "                                                </div>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>");
            }
            if (action.equals("table")) {
                UserDAO udao = new UserDAO();
                FollowerDAO fdao = new FollowerDAO();
                PhotoDAO pdao = new PhotoDAO();
                List<User> list = udao.getAll();

                out.println("<div class=\"content-wrapper\">\n"
                        + "          <div class=\"row\">\n"
                        + "            <div class=\"col-lg-12 grid-margin stretch-card\">\n"
                        + "              <div class=\"card\">\n"
                        + "                <div class=\"card-body\">\n"
                        + "                  <h4 class=\"card-title\">Users Manager</h4>\n"
                        + "                  <div class=\"table-responsive\">\n"
                        + "                    <table class=\"table\">\n"
                        + "                      <thead>\n"
                        + "                        <tr>\n"
                        + "                          <th>Id</th>\n"
                        + "                          <th>Name</th>\n"
                        + "                          <th>Follower</th>\n"
                        + "                          <th>Post</th>\n"
                        + "                          <th>Action</th>\n"
                        + "                        </tr>\n"
                        + "                      </thead>\n"
                        + "                      <tbody>\n");
                for (User user : list) {
                    List<Photo> listPhoto = pdao.getImageByUserId(user.getId());
                    out.println("                        <tr>\n"
                            + "                          <td>" + user.getId() + "</td>\n"
                            + "                          <td>" + user.getName() + "</td>\n"
                            + "                          <td>" + fdao.getFollow(user.getId()) + "</td>\n"
                            + "                          <td>" + listPhoto.size() + "</td>\n"
                            + "                          <td><label class=\"badge badge-danger\" onclick=\"deleteUser('" + user.getId() + "')\">Delete</label></td>\n"
                            + "                        </tr>\n");
                }
                out.println("                      </tbody>\n"
                        + "                    </table>\n"
                        + "                  </div>\n"
                        + "                </div>\n"
                        + "              </div>\n"
                        + "            </div>\n"
                        + "          </div>\n"
                        + "        </div>");
            }
            if (action.equals("chart")) {
                ViewDAO viewDAO = new ViewDAO();
                int view = viewDAO.getviews();
                String formatted = String.format("%05d", view);
                out.println("<canvas id=\"myChart\"></canvas>");
                out.println("<canvas id=\"myChart1\"></canvas>");
                out.println("<div style=\"margin-left:60px\">Total views page: "+formatted+"</div>");
            }
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
        processRequest(request, response);
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
