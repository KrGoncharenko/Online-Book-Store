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
public class Person {
    private int  id;
    private String name;
    private String mail;
    
    public Person(int id,String name, String mail){
    setId(id);
    setName(name);
    setMail(mail);

    }
    public int getId(){
    return id;
    }
    public void setId(int id){
    this.id=id;
    }
    public String getName(){
    return name;
    }
    public void setName(String name){
    this.name=name;
    }
     public String getMail(){
    return mail;
    }
    public void setMail(String mail){
    this.mail=mail;
    }
}
