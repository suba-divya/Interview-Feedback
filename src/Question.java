

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
import javax.servlet.RequestDispatcher; 


@WebServlet("/Question")
public class Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company =request.getParameter("company");
	     String question =request.getParameter("question");
			
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/interviewfeedback","root","millionaire");  
				//here sonoo is database name, root is username and password  
				Statement stmt=con.createStatement();  
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();  
			
				PreparedStatement ps=con.prepareStatement(  
						"insert into seniordashboard values(?,?)");  
						ps.setString(1,company);  
						ps.setString(2,question);  
						          
						int k=ps.executeUpdate();  
						if(k>0)  {
				        RequestDispatcher rd=request.getRequestDispatcher("que.jsp");  
				        rd.forward(request,response);    
						}
						          
						}catch (Exception e2) {System.out.println(e2);}  
						          

	}

}
