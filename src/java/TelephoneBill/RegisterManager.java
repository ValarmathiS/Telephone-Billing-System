/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import org.hibernate.cfg.*;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author acer
 */
public class RegisterManager 
{
    SessionFactory factory;
    StandardServiceRegistryBuilder sr;

    /**
     *
     */
    public boolean flag;
    
    public RegisterManager()
    {
        try
        {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
            factory = cfg.buildSessionFactory(sr.build());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:: Session not Created");
        }
    }
    
    public void regCustomer(String cname,String username,String password,String address,String phoneno)
    {
        Session session=null;
        Transaction tx=null;
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            Customer rg = new Customer(cname, username,password,address, phoneno);
            session.save(rg);
            
            tx.commit();
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
    }
    
    public boolean Validate(String username,String password)
    {
        Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            //Customer custid= (Customer)session.get(Customer.class, custid);
          //  Customer custpwd = (Customer)session.get(Customer.class, password);
          //  Customer cust = (Customer)session.get(Customer.class,1);
            
          // String custname= cust.getUsername();
          //String custpwd=  cust.getPassword();
            
            List customer = session.createQuery("from Customer").list();
            for(Iterator iterator = customer.iterator(); iterator.hasNext();)
            {
                Customer cust = (Customer) iterator.next();
                
                String uname = cust.getUsername();
                String pwd = cust.getPassword();
                
               // System.out.println("User :"+uname);
                //System.out.println("Pwd :"+pwd);*/
            
          /*  Query query1 = session.createQuery("Select username from customer");
            Query query2 = session.createQuery("select password from customer");
            query1.executeUpdate();
            query2.executeUpdate();
            */
          /*  Class.forName("oracle.jdbc.driver.OracleDriver");
            con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from customer");
            while(rs.next())
            {*/
              if(username.equals(uname)&&password.equals(pwd))
             //  if((username.equals("valar"))&& (password.equals("mathi")))
                {
                    flag = true;
                    break;
                }
                else
                {
                    flag = false;
                }
            }
                
           // }
            
            
            tx.commit();
           // rs.close();
            //stmt.close();
            //con.close();
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public void viewProfile()
    {
         Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from customer");
            
            
            
            tx.commit();
            rs.close();
            stmt.close();
            con.close();
            
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
    }
    
   
    
}
