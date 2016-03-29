/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBill;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author acer
 */
public class AdminManager 
{
    SessionFactory factory;
    StandardServiceRegistryBuilder sr;
    public boolean flag = false;
    
     public AdminManager()
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
    
      public boolean Validate(String adminuname,String adminpwd)
    {
        Session session=null;
        Transaction tx=null;
        Connection con = null;
        
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            List admin = session.createQuery("from Admin").list();
            for(Iterator iterator = admin.iterator(); iterator.hasNext();)
            {
                Admin ad = (Admin) iterator.next();
                
                String uname = ad.getAdminuname();
                String pwd = ad.getAdminpwd();
                if(adminuname.equals(uname)&&adminpwd.equals(pwd))
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
             tx.commit();
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
        
        return flag;
    }
      
 /*   public void generateBill(String duedate,int callusage,int custid )
    {
        Session session=null;
        Transaction tx=null;
        String paiddate = null;
        int phoneno;
        int charge = 2;
        int amount = 0;
        try
        {
            session = factory.openSession();
            tx = session.beginTransaction();
            
            List customer = session.createQuery("from Customer").list();
            for(Iterator iterator = customer.iterator(); iterator.hasNext();)
            {
                Customer cust = (Customer) iterator.next();
                phoneno = cust.getPhoneno();
                
                amount = callusage*charge;
                
                GenerateBill rg = new GenerateBill(phoneno,duedate,paiddate,callusage,amount,custid);
                session.save(rg);
                tx.commit();
            }
            
        }
        catch(Exception e)
        {
            if(tx!=null)
                tx.rollback();
            e.printStackTrace();
        }
    }*/
}
