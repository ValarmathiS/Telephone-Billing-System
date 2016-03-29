<%-- 
    Document   : Success
    Created on : Apr 12, 2015, 4:46:42 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! String username; %>
<% username = session.getAttribute("username").toString();%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
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
            <a href="viewprofile.jsp">View Profile</a><br />
            <a href="paybill.jsp">Pay Bill</a><br />
            
        </p>
           
       <% }
        else
        {%>
    
        
    <h1>Click here to Login again</h1>
            <a href="/TelephoneBill/index.html" >Login</a>
       <% }%>
        
       
        
    </body>
</html>
