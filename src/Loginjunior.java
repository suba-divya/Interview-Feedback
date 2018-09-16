import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
  
public class Loginjunior{  
public static boolean validate1(String email,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/interviewfeedback","root","millionaire");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from register where email=? and cfpass=?");  
ps.setString(1,email);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
 
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  