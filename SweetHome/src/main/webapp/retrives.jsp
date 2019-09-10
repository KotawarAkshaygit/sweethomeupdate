<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Date Picker</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
                $("#datepicker1").datepicker();
            });
        </script>
    </head>
    <body>
        <Pre>
       
        <form action="RetriveDB" method="post">
           <center> <label for="datepicker"><b>Enter The Date you want to get total sale on that Day:</b></label><br>
          From:     <input type="text" name="pdate" id="datepicker"><br>
          To:     <input type="text" name="pdate1" id="datepicker1">
            
                <input type="submit" value="Submit">
            </center>
        </form>
        </pre>    
    </body>

</html>