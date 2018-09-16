

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String name1 =request.getParameter("name");
	     String DOB =request.getParameter("dob");
	     String phoneno =request.getParameter("pno");
	     String year =request.getParameter("year");
	     String email =request.getParameter("email");
	     String dept =request.getParameter("dept");
	     String pass =request.getParameter("password");
	     String cfpass =request.getParameter("cpassword");
			
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/interviewfeedback","root","millionaire");  
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();  
			
				PreparedStatement ps=con.prepareStatement(  
						"insert into register values(?,?,?,?,?,?,?,?)");  
						ps.setString(1,name1);  
						ps.setString(2,DOB);  
						ps.setString(3,phoneno);  
						ps.setString(4,year);  
						ps.setString(5,email);  
						ps.setString(6,dept);  
						ps.setString(7,pass);  
						ps.setString(8,cfpass);  
						

						          
						int k=ps.executeUpdate();  
						if(k>0)  
						
						{
							RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");  
					        rd.forward(request,response);   
						}
						      
						          
						}catch (Exception e2) {System.out.println(e2);}  
						          

	}

}
