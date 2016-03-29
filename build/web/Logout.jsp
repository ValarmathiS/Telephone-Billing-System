<%-- 
    Document   : Logout
    Created on : Apr 12, 2015, 4:52:57 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%session.invalidate();%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <h1>Logged out Successfully</h1>
        <p>Click here to 
            <a href="index.html">Login</a> again</p>
    </body>
</html>
