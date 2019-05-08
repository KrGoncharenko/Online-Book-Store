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
public class CusMember extends Person {
    

 CusMember(int id,String name,String mail){
        super(id,name,mail);
	  
	  
    }
  
   public void buyBook(int bid,int cid,Connection conn){
	  try{
             PreparedStatement st=conn.prepareStatement("INSERT INTO bookstore.`order` (bid, cid) VALUES (?, ?)");
            st.setInt(1, bid);
             st.setInt(2,cid);
             st.executeUpdate();
          }catch(SQLException err){
            System.out.println(err.getMessage());
        }
   }
   public void seeOrders(int cid,Connection conn){
	   try{
            String SQL="SELECT * FROM `order`,`book` where `order`.bid=`book`.bid and cid=? ";
            PreparedStatement st=conn.prepareStatement(SQL);
            st.setInt(1,cid);
            ResultSet rs=st.executeQuery();
                while(rs.next()){
                    String name=rs.getString("bname");
                    System.out.println(name);

                }
            }
           catch(SQLException err){
            System.out.println(err.getMessage());
           } 
    }
}

  

