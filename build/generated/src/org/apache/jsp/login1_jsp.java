package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" >\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Log in-Imageram</title>\n");
      out.write("        <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap'><link rel=\"stylesheet\" href=\"./style.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ce672ea6c4.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- partial:index.partial.html -->\n");
      out.write("        <div class=\"screen-1\">\n");
      out.write("            <img src=\"assets/img/logo.png\"/>\n");
      out.write("            <div class=\"email\">\n");
      out.write("                <label for=\"email\">Email Address</label>\n");
      out.write("                <div class=\"sec-2\">\n");
      out.write("                    <i class=\"fa-solid fa-user\"></i>\n");
      out.write("                    <input type=\"text\" name=\"username\" placeholder=\"Enter username\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"password\">\n");
      out.write("                <label for=\"password\">Password</label>\n");
      out.write("                <div class=\"sec-2\">\n");
      out.write("                    <i class=\"fa-solid fa-lock\"></i>\n");
      out.write("                    <input class=\"pas\" type=\"password\" name=\"password\" placeholder=\"············\"/>\n");
      out.write("                    <i class=\"fa-solid fa-eye\"></i>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <button class=\"login\">Login </button>\n");
      out.write("            <div class=\"footer\"><span>Signup</span><span>Forgot Password?</span></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- partial -->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
