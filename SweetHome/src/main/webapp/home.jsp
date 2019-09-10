<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Is Home Page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form action="Retrive" method="post">
<h2>Enter Your Choice</h2>	
<hr>
<b>1.To Generate Bill and Insert Data to DataBase</b><br>
<b>2.To Retrive Data From DataBase</b><br>
<b>3.To Retrive Data By id</b><br>
<div class="col-sm-3"><input type="text" name="opt1" class="form-control"></div>
<input type="submit" value="submit" class="btn btn-primary">
</form></div>
</body>
</html>