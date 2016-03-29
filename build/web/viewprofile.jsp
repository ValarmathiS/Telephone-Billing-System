<%-- 
    Document   : viewprofile
    Created on : Apr 12, 2015, 8:29:21 PM
    Author     : acer
--%>

<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,TelephoneBill.*,org.hibernate.*,org.hibernate.cfg.*" %>
<%! int custid;String cname; String username;String address; String phoneno;SessionFactory factory;
    StandardServiceRegistryBuilder sr;Session session1; %>
<%! String uname; %>
<% uname = session.getAttribute("username").toString();%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Profile Details </title>
    </head>
    <body>
        
       
        
        <br  /><br  /><center>
        <h1>Telephone Bill Portal</h1></center>
        <p align="right">Welcome <%=uname%>&nbsp;&nbsp;&nbsp;
            <a href = "Logout.jsp">Logout</a>
        </p>
        
        <p align="left">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="Success.jsp">Home</a></p>
        
        <h1><center> Profile Details</h1><br  /><br  />
        
        <table align="center" border-spacing = "15px">
            
        <%
            try
            {
                Configuration cfg = new Configuration();
            
        cfg.configure("hibernate.cfg.xml");
        sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        factory = cfg.buildSessionFactory(sr.build());
        session1 = factory.openSession();
        
        //using from clause
        
        String SQL_QUERY = "from Customer";
        Query query = session1.createQuery(SQL_QUERY);
        Iterator it = query.iterate();
        while(it.hasNext())
        {
            Customer cust = (Customer) it.next();
            custid = cust.getCustid();
            cname = cust.getCname();
            address = cust.getAddress();
            phoneno = cust.getPhoneno();
            username = cust.getUsername();
            
        if(username.equals(uname))
        {
        %>  
        
        
        <tr>
            <td><label>Customer id</label></td><td>:</td>
            <td><label><%=custid%></label></td>
        </tr>
        <tr>
            <td><label>Customer name</label></td><td>:</td>
            <td><label><%=cname%></label></td>
        </tr>
        <tr>
            <td><label>Address </label></td><td>:</td>
            <td><label><%=address%></label></td>
        </tr>
        <tr>
            <td><label>Phone no <td>:</td></label></td>
            <td><label><%=phoneno%></label></td>
        </tr>
        <%
        break;
        }
        }
            }
            catch(Exception e)
            {         
               e.printStackTrace();
            }
            finally
            {
                session1.close();
            }
            
        %>
        </table>
    </center>
    </body>
</html>
