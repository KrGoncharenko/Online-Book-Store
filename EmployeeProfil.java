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
class EmployeeProfil {
    public boolean isTrueCid(int cid,Connection conn){
	boolean isTrue=false;
	try{
            String SQL="SELECT cid FROM customer";
            PreparedStatement st=conn.prepareStatement(SQL);
            ResultSet rs=st.executeQuery();
        while(rs.next()){
            int idsi=rs.getInt("cid");
            if(cid==idsi)
            isTrue=true;	     
        }
	  
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
	   return isTrue;
    }
    
    public boolean isTrueBid(int bid,Connection conn){
        boolean isTrue=false;
             try{
                String SQL="SELECT bid FROM book";
                PreparedStatement st=conn.prepareStatement(SQL);
                ResultSet rs=st.executeQuery();
                while(rs.next()){
                    int idsi=rs.getInt("bid");
                    if(bid==idsi)
                        isTrue=true;	     
                    }
                }
             catch(SQLException err){
                System.out.println(err.getMessage());
             }
	   return isTrue;
    }
     
    public void addBook(Book newBook,Connection conn){
	try{
            PreparedStatement st=conn.prepareStatement("insert into bookstore.`book`(bid,bname,author,price) values(?,?,?,?)");
            st.setInt(1, newBook.getId());
            st.setString(2,newBook.getName());
            st.setString(3,newBook.getAuthor());
            st.setDouble(4, newBook.getPrice());
            st.executeUpdate();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
     }
     
    public void updateBookPrice(double price,Connection conn,int bid){
        try{
            String SQL="UPDATE bookstore.`book` SET price=?  WHERE bid=?";
            PreparedStatement st=conn.prepareStatement(SQL);
            st.setDouble(1,price);
            st.setInt(2, bid);
            st.executeUpdate();
         }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
    
    public void addCustomer(Customer newCustomer,Connection conn){
	try{
            PreparedStatement st=conn.prepareStatement("insert into bookstore.`customer`(cid,name,mail) values(?,?,?)");
            st.setInt(1, newCustomer.getId());
            st.setString(2,newCustomer.getName());
            st.setString(3,newCustomer.getMail());
            st.executeUpdate();
         }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
     }
    
    public void deleteCustomer(int cid,Connection conn){ 
        try{
            PreparedStatement st=conn.prepareStatement("DELETE FROM bookstore.customer WHERE cid = ?");
            st.setInt(1, cid);
            st.executeUpdate();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
     
    public void deleteBook(int bid,Connection conn){ 
	try{
            PreparedStatement st=conn.prepareStatement("DELETE FROM  bookstore.`book` WHERE bid=?");
            st.setInt(1, bid);
            st.executeUpdate();
                
         }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }
}
    

