<%-- 
    Document   : viewcust
    Created on : Apr 13, 2015, 12:49:16 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%@ page import="java.util.*,TelephoneBill.*,org.hibernate.*,org.hibernate.cfg.*" %>
<%! int custid;String cname; String username;String address; String phoneno;SessionFactory factory;
    StandardServiceRegistryBuilder sr;Session session1; %>
<%! String uname; %>
<% uname = session.getAttribute("username").toString();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
    </head>
    <body>
         <br  /><br  /><center>
        <h1>Telephone Bill Portal</h1></center>
        <p align="right">Welcome <%=uname%>&nbsp;&nbsp;&nbsp;
            <a href = "Logout.jsp">Logout</a>
        </p>
        
        <p align="left">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="adminSuccess.jsp">Home</a></p>
        
        <h1><center> Customer Details</h1><br  /><br  />
        
        <table align="center" border-spacing = "15px">
            
           
            <tr><th>CustID</th><th>Customer name</th><th>Address</th><th>Phone no</th></tr>
            
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
            
            
        %>  
        
        
        <tr>
            
            <td><label><%=custid%></label></td>       
            <td><label><%=cname%></label></td>
            <td><label><%=address%></label></td>
            <td><label><%=phoneno%></label></td>
        </tr>
        <%
              
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
