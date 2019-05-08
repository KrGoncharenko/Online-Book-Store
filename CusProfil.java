/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kristinagoncarenko
 */
public abstract class CusProfil implements Profil {
    public boolean isTrueCid(int cid,Connection conn){
	   
	   boolean isTrue=false;
	   try{
      
            String SQL="SELECT cid FROM customer ";
            
            PreparedStatement st=conn.prepareStatement(SQL);
            
            ResultSet rs=st.executeQuery();
        while(rs.next()){
       
            int idsi=rs.getInt("cid");
		if(cid==idsi)
		     isTrue=true;	     
        }
	  
        }catch(SQLException err){
            System.out.println(err.getMessage());
        }
	   return isTrue;
    }


public void updateCustomer(Customer newCustomer,Connection conn){
     try{
        String SQL="UPDATE bookstore.`customer` SET name=?, mail=? WHERE cid=?";
        PreparedStatement st=conn.prepareStatement(SQL);
        st.setString(1,newCustomer.getName());
        st.setString(2,newCustomer.getMail());
	st.setInt(3, newCustomer.getId());
        st.executeUpdate();
        }
     catch(SQLException err){
         System.out.println(err.getMessage());
     }
}
}
