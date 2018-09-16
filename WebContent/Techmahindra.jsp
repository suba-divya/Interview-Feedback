<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%@ page import= "java.sql.Connection" %>
<%@  page import= " java.sql.DriverManager" %>
 <%@ page import = "java.sql.ResultSet" %> 
<%@ page import = "java.sql.ResultSetMetaData"  %>
<%@ page import = "java.sql.Statement"  %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.w3-sidebar a {font-family: 'Josefin Sans', sans-serif;}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: 'Josefin Sans', sans-serif;}
</style>
<body>
<h3>Q/A Zone</h3>
<p>
<%
    
	String query = "select question from seniordashboard where company='techmahindra' ";
	  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/interviewfeedback","root","millionaire");  
	Statement stmt = con.createStatement();       
	ResultSet rs= stmt.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
	int col = rsmd.getColumnCount();
	rs.next();%>
	<h2> Tech Mahindra UPDATES</h2>
	<br>
	<br>
	
	
<% 	while(rs.next())
      {%>
	<div class="w3-container"  style="text-align:left;padding: 8%;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);background-color:#DDD; margin-left: 30px; margin-right :30px;"> 	
	 
	 <% out.println(rs.getString("question")+"\n");%>
	 <i class="fa fa-download" style="margin-left:30px;"></i>
	 <i class="fa fa-check"  style="margin-left:30px;"></i>
	</div>
	<br>
	<br>
  <%  }
	
%>
</body>
</html>