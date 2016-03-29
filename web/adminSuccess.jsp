<%-- 
    Document   : adminSuccess
    Created on : Apr 13, 2015, 12:49:48 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String username; %>
<% username = session.getAttribute("username").toString();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
    </head>
    <body>
          <% if(username.equals(username))
        {%>
        
        <center> <h1>Telephone Bill Portal</h1></center>
        <p align="right">
            <b>Welcome <%=username%></b>&nbsp;&nbsp;
             <a href="/TelephoneBill/Logout.jsp">Logout</a>
        </p>
        <p align =" center">
            <a href="viewcust.jsp">View Customer</a><br />
            <a href="generatebill.jsp">Generate Bill</a><br />
            
        </p>
           
       <% }
        else
        {%>
    
        
    <h1>Click here to Login again</h1>
            <a href="/TelephoneBill/admin.html" >Login</a>
       <% }%>
        
    </body>
</html>
