package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.nsbm.model.Student;
import java.util.List;

public final class StudentList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student List</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h2>Student List</h2>\n");
      out.write("\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Name</th>\n");
      out.write("            <th>Course</th>\n");
      out.write("            <th>Email</th>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        ");

            // Retrieve the list of students from the request attribute
            List<Student> students = (List<Student>) request.getAttribute("studentMap");

            // Check if the list is not null and not empty
            if (students != null && !students.isEmpty()) {
                // Loop through the list of students
                for (Student student : students) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( student.getId() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( student.getName() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( student.getCourse() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( student.getEmail() );
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

                }
            } else {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td colspan=\"4\">No students found</td>\n");
      out.write("        </tr>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("</body>\n");
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
