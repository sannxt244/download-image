package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Photo;
import java.util.List;

public final class app_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>imageram</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/app.css\">\n");
      out.write("        <script type='text/javascript' src='javascript/app.js'></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"app\">\n");
      out.write("            <div class=\"app_header\">\n");
      out.write("                <div class=\"app_headerWrapper\">\n");
      out.write("                    <img\n");
      out.write("                        class=\"app_headerImage\"\n");
      out.write("                        style=\"height: 30px\"\n");
      out.write("                        src=\"image/logo.png\"\n");
      out.write("                        />\n");
      out.write("                    <div class=\"nav_items\">\n");
      out.write("                        <div class=\"icon user_avatar\">\n");
      out.write("                            <img src =\"https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/User-avatar.svg/1024px-User-avatar.svg.png\"/>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <table class=\"feature_images\">\n");
      out.write("                <tr>\n");
      out.write("                    ");

                        List<Photo> listPhotos = (List<Photo>) request.getAttribute("listPhoto");
                        for (Photo photo : listPhotos) {
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <img\n");
      out.write("                            src=\"");
      out.print( photo.getImagePath() );
      out.write("\"\n");
      out.write("                        />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img\n");
      out.write("                            src=\"");
      out.print( photo.getImagePath() );
      out.write("\"\n");
      out.write("                        />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <img\n");
      out.write("                            src=\"");
      out.print( photo.getImagePath() );
      out.write("\"\n");
      out.write("                        />\n");
      out.write("                    </td>\n");
      out.write("                    ");
                        }
                    
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
