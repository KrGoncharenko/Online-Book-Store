package bookstore;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
Dersler yazdir gibi
 */

/**
 *
 * @author kristinagoncarenko
 */
public class ShowResultOfBook {
  ShowResultOfBook(Connection conn){
        try{
             PreparedStatement st=conn.prepareStatement("SELECT * FROM book");
          ResultSet rs=st.executeQuery();
          System.out.println("id\t name\t author \t price\t");
           while(rs.next()){
               int id=rs.getInt("bid");
               String ad=rs.getString("bname");
               int price=rs.getInt("price");
               String author=rs.getString("author");
                
                System.out.print(id+"\t");
                System.out.print(ad+"\t");
                System.out.print(price+"\t");
                System.out.print(author+"\t");
                System.out.println("\n");
           }
          }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
  }
}
    

