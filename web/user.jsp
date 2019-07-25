<%-- 
    Document   : user
    Created on : Apr 7, 2019, 10:32:14 PM
    Author     : Piyu bhanderi
--%>



<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.expensetracker.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<%
    if(session.getAttribute("uid")==null){
        response.sendRedirect("index.html");
    }   
%>


<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="assets/style.css" rel="stylesheet"/>
        <link type="text/css" href="assets/bootstrap.css" rel="stylesheet"/>
        
        <script type="text/javascript" src="assets/jquery.min.js"></script>
        <script type="text/javascript" src="assets/popper.min.js"></script>
        <script type="text/javascript" src="assets/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/Chart.min.js"></script>
        <script>
            $('document').ready(function(e){
                $('.userMenu').click(function(){
                    $('#menu').slideToggle("slow");
                });
                
                
                var chartdata={
                        labels:[<%Connect con=new Connect();
                                ResultSet r=con.getData("select eid from expense where uid="+session.getAttribute("uid").toString()+" order by eid desc");
                                    while(r.next()){out.print(r.getInt("eid")+",");}
                                    out.println("0");
                                        
                        %>],
                        datasets :[
                                {
                                        label : 'Expense',
                                        backgroundColor:'rgba(0, 0, 0,0)',	
                                        borderColor: 'rgba(255,0,0,.8)',
                                        borderWidth:4,
                                        hoverBackgroundColor:'rgba(244, 67, 54,1)',
                                        hoverBorderColor:'rgba(200,200,200,1)',
                                        data : [<% 
                                                   r=con.getData("select expense_amt from expense where uid="+session.getAttribute("uid").toString()+" order by eid desc");
                                                   while(r.next()){out.print(r.getInt("expense_amt")+",");}
                                                   out.println("0");
                                        
                                        %>]
                                }
                        ]	
                };

                var ctx = $('#myChart');
                var barGraph = new Chart(ctx , {
                        type:'line',
                        data:chartdata,
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                });

            });
        </script>
        
        
        
        <title>Expense Tracker</title>
    </head>
    <body style="background:url('assets/back.png');">
        
        
        <div class="container-fluid m-0 p-0 mt-5">
             <div class="row text-light header" style="background: #000; width:100%;">
                <div class="col-lg-11 text-center">
                    <h2>Welcome <%
                        
                            Connect c=new Connect();
                            ResultSet rs=c.getData("Select * from user_details where uid='"+session.getAttribute("uid").toString()+"' ");
                            if(rs.next())
                            {
                                out.println(rs.getString("name"));
                            }
                        %></h2>
                    
                </div>
                <div class="col-lg-1 text-right" style="position: relative;">
                    <img src="assets/menu.png" class="userMenu" width="20" height="20" style="transform: translateY(50%);"/>
                    
                    <div id="menu" class="text-left">
                        <ul style="list-style: none; display:block; width: 200px;" class="p-0 m-0">
                            <li class="bg-dark"><a href="logout" class="p-2 text-light text-center font-weight-bold">Log Out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
             
            <div class="row p-5">
                
                <div class="col-lg-8">
                    
                    <div class="p-3 border-light border rounded bg-warning" style="box-shadow: 0px 0px 20px;">
                        <font size="30">ExpenseTracker Wallet <%
                           
                            
                            rs=c.getData("Select * from balance where uid='"+session.getAttribute("uid").toString()+"' ");
                            if(rs.next())
                            {
                            out.println("&emsp; ₹ " +rs.getInt("cur_bal")+"");
                            } 
                        %></font>
                    </div>
                    
                    
                        
                        
                </div>
                <div class="col-lg-4">
                    <div class="row h-50"><div class="col-lg-12 p-1"><button class="btn btn-lg btn-success" data-toggle="modal" data-target="#addBal">+Add Money</button></div></div>
                    <div class="row h-50"><div class="col-lg-12 p-1"><button class="btn btn-lg btn-danger" data-toggle="modal" data-target="#addExp">+Add Expense</button></div></div>
                </div>

                        
                
                
            </div>
            <div class="row p-5" >
                <div class="col-lg-12">
                    <center><font size="30">Recents</font></center><hr>
                </div>
                <div class="col-lg-12 p-0" style="height:400px !important; overflow-y: scroll; box-shadow: 0px 0px 20px;" >
                    
                    <table class="table table-dark">
                        <tr>
                        <th>Log Id</th>
                        <th>Expense Category</th>
                        <th>Description</th>
                        <th>Timestamp</th>
                        </tr>
                    
                        <%
                            rs=c.getData("select * from log where uid="+session.getAttribute("uid").toString()+" order by timestamp desc");
                            while(rs.next())
                            {
                        %>
                        <tr <%if(rs.getString("category").equals("AddMoney")){out.println("bgcolor='#006400'");}else{out.println("bgcolor='#8B0000'");}%>>
                            <td><%out.print(rs.getInt("logid"));%></td>
                            <td><%out.print(rs.getString("category"));%></td>
                            <td><%out.print(rs.getString("description"));%></td>
                            <td><%out.print(rs.getString("timestamp"));%></td>
                        </tr>
                        <%}%>
                    </table>
                </div>
                    
                    <div class="col-lg-12 mt-5">
                    <center><font size="30">Expense Chart</font></center><hr>
                </div>
                    
                    <div class="col-lg-12 pt-5" align="center" style="background-color: #fff; box-shadow: 0px 0px 10px;">
                        <div style="width:50%;" align="center">
                            <canvas id="myChart"></canvas>
                        </div>
                            
                    </div>    
                    
                    
                    
                    
                    
            </div>
                    
                    
                    
                    
                    
                    <div id="addBal" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                      <!-- Modal content-->
                      <div class="modal-content">
                        
                        <div class="modal-body">
                            <form method="post" action="BalanceServlet">
                                <input type="number" name="bal" class="form-control"/><br><Br>
                                <input type="submit" name="submit" class="form-control btn btn-success" value="Add Money"/>    
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                      </div>
                    </div>
                    </div>
                    
                    
                    <div id="addExp" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                      <!-- Modal content-->
                      <div class="modal-content">
                        
                        <div class="modal-body">
                            <form method="post" action="ExpenseServlet">
                                <select name="expname" class="form-control" required>
                                    <option value="">--Select Expense Name--</option>
                                    <option>Food</option>
                                    <option>Movie</option>
                                    <option>Medicine</option>
                                    <option>Car</option>
                                    <option>Bike</option>
                                    <option>Transport</option>
                                    <option>Clothes</option>
                                    <option>Fashion</option>
                                    <option>House</option>
                                    <option>Bills</option>
                                    <option>Others</option>
                                </select><br><br>
                                <input type="number" name="expamt" class="form-control" required/><br><Br>
                                <textarea class="form-control-plaintext" name="desc" placeholder="Comment" required></textarea>
                                <input type="submit" name="submit" class="form-control btn btn-warning" value="Add Expense"/>    
                            </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                      </div>
                    </div>
                    </div>
        </div>
    </body>
</html>
