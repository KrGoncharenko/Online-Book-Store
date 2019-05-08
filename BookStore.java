package bookstore;




import static java.lang.Boolean.TRUE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



/**
 *
 * @author kristinagoncarenko
 */
public class BookStore {
public static Scanner sc=new Scanner(System.in);
            
static final String host="jdbc:mysql://localhost:3306/bookstore?zeroDateTimeBehavior=convertToNull";
	    static final String uname="root";
	    static final  String pass="";

public static int secim;
public static String name,author,mail,cname;
public static int bid,cid;
public static double price;
            /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {

    try{
            //bağlantı kurma
    Connection conn=DriverManager.getConnection(host, uname, pass);
            //ifade değişkeni oluşturma
    Statement st=conn.createStatement();
    Scanner input;
    input=new Scanner (System.in);
    System.out.println("Please choose one of them:");
    System.out.println("1-Customer menu"+"        "+
                       "2-Employee menu");
    secim=sc.nextInt();
         
    switch(secim){
        case 1:  
            switchCustomer();
        break;
        case 2:  //employee
            switchEmployee();
            System.out.println("");
        break;
        case 3:
        return ;
    }
    }catch(SQLException err){
    System.out.println(err.getMessage());
    }
    
}
    public static void switchCustomer() throws SQLException{
    CusProfil cusProfil=new CusProfil() {};
    int cid;
    Connection conn=DriverManager.getConnection(host, uname, pass);
    System.out.println("Please enter customer ID which you took from employee");  //örnek customer idsi: 1
    cid = sc.nextInt();
	        //boolean varMı=cusProfil.isTrueCid(cid,conn);
		  //if(varMı==true){
				
    CusMember mem=new CusMember(cid,"Krıstına Goncharenko","blabla@mail.ru");
    System.out.println("choose one of actions:");
    System.out.println("1-List of book\n"+
    "2-Buy book\n"+
    "3-See orders\n"+
    "4- Update Profil\n"+
    "5-Find the book by keyword\n");
    secim=sc.nextInt();
    switch(secim){
	case 1:
            ShowResultOfBook books=new ShowResultOfBook(conn);
            System.out.println(" ");
        break;

        case 2:
            System.out.println("Please enter the id of book which you want to buy");
            int bid = sc.nextInt();
            mem.buyBook(bid,cid,conn);
            break;

        case 3:
            mem.seeOrders(cid,conn);
	break;
        
	case 4:
            System.out.println("Update customer name :");
            sc.nextLine();
            cname=sc.nextLine();
            System.out.println("Update mail :");
            mail=sc.nextLine();
            Customer newCustomer=new Customer(cid,cname,mail);		   
            cusProfil.updateCustomer(newCustomer,conn);
	break;
        
        case 5:
            sc.nextLine();
            System.out.println("enter keyword to search : Genre,Name");
            String keyword=sc.nextLine();
            booksearch bn= new booksearch();
            bn.searchBook(keyword);
        break;
        }
     System.out.println("");

    }
    public static void switchEmployee() throws SQLException{
        Connection conn=DriverManager.getConnection(host, uname, pass);
        Employee admin=new Employee(223,"kristina Goncharenko","bbbbb@gmail.com");
	EmployeeProfil empProfil=new EmployeeProfil();
        System.out.println("Please choose one of action:");
        System.out.println(
        "1-Add book\n"+
        "2-Delete Book\n"+
        "3-Delete customer\n" +
	"4-Update book price\n"+
        "5-Add Customer\n");
        secim=sc.nextInt();
                       
        switch(secim){
            case 1: 
		System.out.println("Enter bid :");
		bid=sc.nextInt();
                sc.nextLine();
		System.out.println("Enter books name :");
		name=sc.nextLine();
		System.out.println("Enter author :");
		author=sc.nextLine();
		System.out.println("Enter price :");
		price=sc.nextDouble();
		Book newBook=new Book(bid,name,author,price);		   
                empProfil.addBook(newBook,conn);
            break;
                               
            case 2: 
                System.out.println("Enter the id of book which you want to delete:");
		bid=sc.nextInt();
                empProfil.deleteBook(bid, conn);
             break;
                               
            case 3:  
                System.out.println("Enter the id of customer which you want to delete :");
                cid=sc.nextInt();
                empProfil.deleteCustomer(cid, conn);
            break;
					  
            case 4:
		System.out.println("Enter book id for updating:");
		bid=sc.nextInt();
		System.out.println("enter new price:");
		price=sc.nextDouble();		   
                empProfil.updateBookPrice(price,conn,bid);
		    // updatePrice(bid,price,conn);
            break;
		
            case 5:
		   System.out.println("Enter cid :");
		   cid=sc.nextInt();	
                   sc.nextLine();
		   System.out.println("Enter customer name :");
		   name=sc.nextLine();
		   System.out.println("Enter mail :");
		   mail=sc.nextLine();
		   Customer newCustomer=new Customer(cid,name,mail);	
                   	   		   
                   empProfil.addCustomer(newCustomer,conn);
                               
       }
    }
    
    
 
      
}