

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher; 

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("email");  
	    String p=request.getParameter("password");  
	          
	    if(Loginsenior.validate(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("seniordashboard.html");  
	        rd.forward(request,response);  
	    }  
	    else if(Loginjunior.validate1(n , p)){  
	    	RequestDispatcher rd=request.getRequestDispatcher("juniordashboard.html");  
	        rd.forward(request,response);  
	    }
	    else {	
	    	out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	          out.close();
	}

}
