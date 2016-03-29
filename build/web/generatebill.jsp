<%-- 
    Document   : generatebill
    Created on : Apr 13, 2015, 12:49:30 AM
    Author     : acer
--%>

<%@page import="TelephoneBill.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder"%>
<%! int custid;String cname; String username;String address; int phoneno;SessionFactory factory;
    StandardServiceRegistryBuilder sr;Session session1; %>
<%! String uname; %>
<% uname = session.getAttribute("username").toString();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Bill</title>
    </head>
    
    
        <form action="/TelephoneBill/GenerateBillController" method="POST">
        
      <br  /><br  /><center>
        <h1>Telephone Bill Portal</h1></center>
        <p align="right">Welcome <%=uname%>&nbsp;&nbsp;&nbsp;
            <a href = "Logout.jsp">Logout</a>
        </p>
        
        <p align="left">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            
            <a href="adminSuccess.jsp">Home</a></p>
        
        <h1><center> Bill Generation</h1><br  /><br  />
        <table align="center" border-spacing = "15px">
         <tr>
            <td><label>Customer id</label></td><td>:</td>
            <td>
                <select name="custid">   
        <%
            try
            {
                Configuration cfg = new Configuration();
            
        cfg.configure("hibernate.cfg.xml");
        sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        factory = cfg.buildSessionFactory(sr.build());
        session1 = factory.openSession();
        
        String SQL_QUERY = "from Customer";
        Query query = session1.createQuery(SQL_QUERY);
        Iterator it = query.iterate();
        while(it.hasNext())
        {
            Customer cust = (Customer) it.next();
            custid = cust.getCustid();
            
        %>
            <option value="<%=custid%>" ><%=custid%></option>
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
        
                </select>
            </td>
        </tr>
        <tr>
            <td><label>Usage</label></td><td>:</td>
            <td><input type="text" name="callusage"/></td>
        </tr>
        <tr>
            <td><label>Due Date </label></td><td>:</td>
            <td><input type="text" name="duedate"/></td>
        </tr>  
        </table><br />
        <center> <input type="submit" name="generatebill" value="Generate Bill"/></center>&nbsp;&nbsp;&nbsp;
    </center>
        </form>
    
</html>
