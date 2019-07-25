/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.expensetracker;
import java.sql.Connection;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Piyu bhanderi
 */
public class Connect {
            Connection con;
            Statement st;
            

    public Connect() throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker?zeroDateTimeBehavior=convertToNull","root", null);
        this.st=con.createStatement();
    }
    
    public ResultSet getData(String query) throws SQLException{
        return st.executeQuery(query);
        
    }
    
    public Boolean setData(String query) throws SQLException{
        return st.execute(query);
    }
    
    public void insertBal(String uid,String bal) throws SQLException{
        ResultSet rs=this.getData("select * from balance where uid="+uid);
        rs.next();
        int i=rs.getInt("cur_bal")+Integer.parseInt(bal);
        st.execute("Update balance set cur_bal="+i+" where uid="+uid+"");

    }
    
    public void insertLog(String uid, String cat, String desc) throws SQLException{
        
        Date d=new Date();
        Timestamp timestamp=new Timestamp(d.getTime());
        
        st.execute("insert into log values(0,"+uid+",'"+cat+"','"+desc+"','"+timestamp+"')");
    }
    
    public void insertExp(String uid, String name,String amt, String desc) throws SQLException{
        st.execute("insert into expense values(0,"+uid+",'"+name+"',"+amt+",'"+desc+"')");
        ResultSet rs=this.getData("select * from balance where uid="+uid);
        rs.next();
        int i=rs.getInt("cur_bal")-Integer.parseInt(amt);
        st.execute("Update balance set cur_bal="+i+" where uid="+uid+"");
        
    }
            
            
}
