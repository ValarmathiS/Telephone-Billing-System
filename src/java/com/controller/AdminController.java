/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import TelephoneBill.AdminManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class AdminController extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
        String adminuname = request.getParameter("adminuname");
        String adminpwd = request.getParameter("adminpwd");
        
        AdminManager am = new AdminManager();
        
        if(am.Validate(adminuname, adminpwd))
        {
            request.getSession().setAttribute("username", adminuname);
            response.sendRedirect("/TelephoneBill/adminSuccess.jsp");
        }
        else
        {
              response.sendRedirect("/TelephoneBill/Failure.jsp");
        }
        
    }

}
