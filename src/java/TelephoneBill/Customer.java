/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelephoneBill;

/**
 *
 * @author acer
 */
public class Customer {
    
    private int custid;
    private String cname;
    private String username;
    private String password;
    private String address;
    private String phoneno;
    
    public Customer(){
        
    }

    public Customer(String cname, String username, String password, String address, String phoneno) {
        this.cname = cname;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phoneno = phoneno;
    }
    
    

    public int getCustid() {
        return custid;
    }

    private void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
    
    
}
