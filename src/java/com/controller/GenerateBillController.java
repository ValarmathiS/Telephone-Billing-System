/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;


import TelephoneBill.BillManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 * @author acer
 */
public class GenerateBillController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String duedate;
        int callusage,custid;
        PrintWriter out = response.getWriter();
        //custid = 1;
        custid = Integer.parseInt(request.getParameter("custid"));
        duedate = request.getParameter("duedate");
        callusage = Integer.parseInt(request.getParameter("callusage"));
        
        BillManager am = new BillManager();
        am.generateBill(duedate,callusage,custid);
        out.println("Bill Generated");
        
    }

}
