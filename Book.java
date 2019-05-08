/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
/**
 *
 * @author kristinagoncarenko
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private double price;
    
    public Book (int id,String name,String author,double price ){
    this.id=id;
    this.name=name;
    this.author=author;
    this.price=price;
   
    
    }

    Book(int bid, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Book(double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public int getId() {
	    return id;
     }

     public void setId(int id) {
	    this.id = id;
     }

     public String getName() {
	    return name;
     }

     public void setName(String name) {
	    this.name = name;
     }

     public String getAuthor() {
	    return author;
     }

     public void setAuthor(String author) {
	    this.author = author;
     }

     public double getPrice() {
	    return price;
     }

     public void setPrice(double price) {
	    this.price = price;
     }
    
   
}
