<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  
int result=(Integer)request.getAttribute("resultset");
String pdate=(String) request.getAttribute("pdate");
String pdate1=(String) request.getAttribute("pdate1");
out.println("Sum of total from <br>");
out.println(pdate+" to " + pdate1+" is<br>" );
out.println( "  Rs: "+result);
session.invalidate();
%>
<br><a href="home.jsp"><button>Go Back To Home</button></a>
</body>
</html>