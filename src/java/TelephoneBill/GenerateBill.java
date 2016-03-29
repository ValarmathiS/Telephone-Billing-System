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
public class GenerateBill 
{
    private int billno,callusage,amount,custid;
    private String duedate,paiddate,phoneno;

    public GenerateBill()
    {
        
    }
    public GenerateBill(String phoneno,String duedate, String paiddate, int callusage, int amount, int custid ) {
        this.phoneno = phoneno;
        this.callusage = callusage;
        this.amount = amount;
        this.custid = custid;
        this.duedate = duedate;
        this.paiddate = paiddate;
    }

    public int getBillno() {
        return billno;
    }

    private void setBillno(int billno) {
        this.billno = billno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public int getCallusage() {
        return callusage;
    }

    public void setCallusage(int callusage) {
        this.callusage = callusage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getPaiddate() {
        return paiddate;
    }

    public void setPaiddate(String paiddate) {
        this.paiddate = paiddate;
    }
    
}
