/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import static bookstore.BookStore.host;
import static bookstore.BookStore.pass;
import static bookstore.BookStore.uname;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mocktar Issa
 */
public class booksearch {
    public String keyword;
    public void searchBook(String keyword){
        try{
            Connection conn=DriverManager.getConnection(host, uname, pass);
            String SQL="SELECT * FROM bookstore.`bookinfo`,bookstore.`book` where bookname=? or bookgenre=? and book.bid=bookinfo.bid";
            PreparedStatement st=conn.prepareStatement(SQL);
            st.setString(1,keyword);
            st.setString(2,keyword);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                int id=rs.getInt("bid");
                String name=rs.getString("bname");
                String author=rs.getString("author");
                double price=rs.getDouble("price");
                System.out.println(id+name+author+price);
            }
	}
        catch(SQLException err){
            System.out.println(err.getMessage());
        }  
    }
}
