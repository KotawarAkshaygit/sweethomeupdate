<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userdetailsjsp</title>
</head>
<body>

<form action="CalculateBill" method="post">

Enter Customer Name:<input type="text" name="cname" required pattern=".*[^ ].*"><br>
Enter Customer PhoneNumber:<input type="number" name="contact" required pattern=".*[^ ].*" maxlength="10"><br>
<input type="submit" value="submit">

</form>

</body>
</html>