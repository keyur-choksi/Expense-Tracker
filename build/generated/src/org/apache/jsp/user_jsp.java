package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.sql.ResultSet;
import org.expensetracker.Connect;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    if(session.getAttribute("uid")==null){
        response.sendRedirect("index.html");
    }   

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link type=\"text/css\" href=\"assets/style.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link type=\"text/css\" href=\"assets/bootstrap.css\" rel=\"stylesheet\"/>\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\" src=\"assets/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/popper.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/bootstrap.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/chart.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $('document').ready(function(e){\n");
      out.write("                $('.userMenu').click(function(){\n");
      out.write("                    $('#menu').slideToggle(\"slow\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("        var ctx = document.getElementById('myChart').getContext('2d');\n");
      out.write("        var myChart = new Chart(ctx, {\n");
      out.write("            type: 'bar',\n");
      out.write("            data: {\n");
      out.write("                labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],\n");
      out.write("                datasets: [{\n");
      out.write("                    label: '# of Votes',\n");
      out.write("                    data: [12, 19, 3, 5, 2, 3],\n");
      out.write("                    backgroundColor: [\n");
      out.write("                        'rgba(255, 99, 132, 0.2)',\n");
      out.write("                        'rgba(54, 162, 235, 0.2)',\n");
      out.write("                        'rgba(255, 206, 86, 0.2)',\n");
      out.write("                        'rgba(75, 192, 192, 0.2)',\n");
      out.write("                        'rgba(153, 102, 255, 0.2)',\n");
      out.write("                        'rgba(255, 159, 64, 0.2)'\n");
      out.write("                    ],\n");
      out.write("                    borderColor: [\n");
      out.write("                        'rgba(255, 99, 132, 1)',\n");
      out.write("                        'rgba(54, 162, 235, 1)',\n");
      out.write("                        'rgba(255, 206, 86, 1)',\n");
      out.write("                        'rgba(75, 192, 192, 1)',\n");
      out.write("                        'rgba(153, 102, 255, 1)',\n");
      out.write("                        'rgba(255, 159, 64, 1)'\n");
      out.write("                    ],\n");
      out.write("                    borderWidth: 1\n");
      out.write("                }]\n");
      out.write("            },\n");
      out.write("            options: {\n");
      out.write("                scales: {\n");
      out.write("                    yAxes: [{\n");
      out.write("                        ticks: {\n");
      out.write("                            beginAtZero: true\n");
      out.write("                        }\n");
      out.write("                    }]\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <title>Expense Tracker</title>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background:#02a2ff;\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"container-fluid m-0 p-0 mt-5\">\n");
      out.write("             <div class=\"row text-light header\" style=\"background: #000; width:100%;\">\n");
      out.write("                <div class=\"col-lg-11 text-center\">\n");
      out.write("                    <h2>Welcome ");

                        
                            Connect c=new Connect();
                            ResultSet rs=c.getData("Select * from user_details where uid='"+session.getAttribute("uid").toString()+"' ");
                            if(rs.next())
                            {
                                out.println(rs.getString("name"));
                            }
                        
      out.write("</h2>\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-1 text-right\" style=\"position: relative;\">\n");
      out.write("                    <img src=\"assets/menu.png\" class=\"userMenu\" width=\"20\" height=\"20\" style=\"transform: translateY(50%);\"/>\n");
      out.write("                    \n");
      out.write("                    <div id=\"menu\" class=\"text-left\">\n");
      out.write("                        <ul style=\"list-style: none; display:block; width: 200px;\" class=\"p-0 m-0\">\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"#\">Profile</a></li>\n");
      out.write("                            <li><a href=\"#\">Log</a></li>\n");
      out.write("                            <li><a href=\"#\">Balance</a></li>\n");
      out.write("                            <li><a href=\"logout\">Log Out</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             \n");
      out.write("            <div class=\"row p-5\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-lg-8\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"p-2 border-light border rounded bg-warning\" style=\"box-shadow: 0px 0px 20px;\">\n");
      out.write("                        <font size=\"30\">ExpenseTracker Wallet ");

                           
                            
                            rs=c.getData("Select * from balance where uid='"+session.getAttribute("uid").toString()+"' ");
                            if(rs.next())
                            {
                            out.println("&emsp; ₹ " +rs.getInt("cur_bal")+"");
                            } 
                        
      out.write("</font>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <div class=\"row h-50\"><div class=\"col-lg-12 p-1\"><button class=\"btn btn-lg\" data-toggle=\"modal\" data-target=\"#addBal\" >+Add Money</button></div></div>\n");
      out.write("                    <div class=\"row h-50\"><div class=\"col-lg-12 p-1\"><button class=\"btn btn-lg\" data-toggle=\"modal\" data-target=\"#addExp\">+Add Expense</button></div></div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <div class=\"row p-5\" >\n");
      out.write("                <div class=\"col-lg-12\">\n");
      out.write("                    <center><font size=\"30\">Recents</font></center><hr>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-12\" style=\"height:400px !important; overflow-y: scroll;\">\n");
      out.write("                    \n");
      out.write("                    <table class=\"table table-dark\">\n");
      out.write("                        <tr>\n");
      out.write("                        <th>Log Id</th>\n");
      out.write("                        <th>Expense Category</th>\n");
      out.write("                        <th>Description</th>\n");
      out.write("                        <th>Timestamp</th>\n");
      out.write("                        </tr>\n");
      out.write("                    \n");
      out.write("                        ");

                            rs=c.getData("select * from log where uid="+session.getAttribute("uid").toString()+" order by timestamp desc");
                            while(rs.next())
                            {
                        
      out.write("\n");
      out.write("                        <tr ");
if(rs.getString("category").equals("AddMoney")){out.println("bgcolor='#006400'");}else{out.println("bgcolor='#8B0000'");}
      out.write(">\n");
      out.write("                            <td>");
out.print(rs.getInt("logid"));
      out.write("</td>\n");
      out.write("                            <td>");
out.print(rs.getString("category"));
      out.write("</td>\n");
      out.write("                            <td>");
out.print(rs.getString("description"));
      out.write("</td>\n");
      out.write("                            <td>");
out.print(rs.getString("timestamp"));
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <canvas id=\"myChart\" width=\"400\" height=\"400\"></canvas>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("            </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <div id=\"addBal\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("                    <div class=\"modal-dialog\">\n");
      out.write("                      <!-- Modal content-->\n");
      out.write("                      <div class=\"modal-content\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form method=\"post\" action=\"BalanceServlet\">\n");
      out.write("                                <input type=\"number\" name=\"bal\" class=\"form-control\"/><br><Br>\n");
      out.write("                                <input type=\"submit\" name=\"submit\" class=\"form-control btn btn-success\" value=\"Add Money\"/>    \n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <div id=\"addExp\" class=\"modal fade\" role=\"dialog\">\n");
      out.write("                    <div class=\"modal-dialog\">\n");
      out.write("                      <!-- Modal content-->\n");
      out.write("                      <div class=\"modal-content\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <form method=\"post\" action=\"ExpenseServlet\">\n");
      out.write("                                <select name=\"expname\" class=\"form-control\" required>\n");
      out.write("                                    <option value=\"\">--Select Expense Name--</option>\n");
      out.write("                                    <option>Food</option>\n");
      out.write("                                    <option>Movie</option>\n");
      out.write("                                    <option>Medicine</option>\n");
      out.write("                                    <option>Car</option>\n");
      out.write("                                    <option>Bike</option>\n");
      out.write("                                    <option>Transport</option>\n");
      out.write("                                    <option>Clothes</option>\n");
      out.write("                                    <option>Fashion</option>\n");
      out.write("                                    <option>House</option>\n");
      out.write("                                    <option>Bills</option>\n");
      out.write("                                    <option>Others</option>\n");
      out.write("                                </select><br><br>\n");
      out.write("                                <input type=\"number\" name=\"expamt\" class=\"form-control\" required/><br><Br>\n");
      out.write("                                <textarea class=\"form-control-plaintext\" name=\"desc\" placeholder=\"Comment\" required></textarea>\n");
      out.write("                                <input type=\"submit\" name=\"submit\" class=\"form-control btn btn-warning\" value=\"Add Expense\"/>    \n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("        </div>\n");
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
