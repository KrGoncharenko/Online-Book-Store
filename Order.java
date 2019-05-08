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
public class Order {
 private long id;
    private long customerId;
    private long employeeId;
    private long[] books;
    
    public Order(long id,long employeeId,long customerId,long []books){
    this.id=id;
    this.employeeId=employeeId;
    this.customerId=customerId;
    this.books=books;
    }
    public long getId(){
    return id;
    }
    public void setId(long id){
    this.id=id;
    }
    public long getEmployeeId(){
    return id;
    }
    public void setEmployeeId(long employeeId){
    this.employeeId=employeeId;
    }
    public long getCustomerId(){
    return id;
    }
    public void setCustomerId(long customerIdId){
    this.customerId=customerId;
    }
    public long [] getBooks(){
    return books ;
    }
    public void setBooks(long[]books){
    this.books=books;
    
}
}