

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


@WebServlet("/Register1Servlet")
public class Register1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
	     String dob =request.getParameter("dob");
	     String pno =request.getParameter("pno");
	     String yearofpass =request.getParameter("yearofpass");
	     
	     String placed =request.getParameter("placed");
	     String email =request.getParameter("email");
	     String dept =request.getParameter("dept");
	     String password =request.getParameter("password");
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
						"insert into register1 values(?,?,?,?,?,?,?,?,?)");  
						ps.setString(1,name);  
						ps.setString(2,dob);  
						ps.setString(3,pno);  
						ps.setString(4,yearofpass);  
						ps.setString(5,placed);  
						ps.setString(6,email);  
						ps.setString(7,dept);
						ps.setString(8,password);  
						ps.setString(9,cfpass);  
						

						          
						int k=ps.executeUpdate();  
						if(k>0)  {
							RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");  
					        rd.forward(request,response);   
						 
						}         
						}catch (Exception e2) {System.out.println(e2);}  
			


	}

}
