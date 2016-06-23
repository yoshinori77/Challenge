<%-- 
    Document   : jdbc_advance
    Created on : 2016/06/22, 14:03:45
    Author     : yoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="./jdbc_advance" method="post">
            名前：　<input type="text" name="txtName" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  PASSWORD：　<input type="text" name="txtPassword" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br> <input type="submit" name="btnSubmit" value="LOG IN" style="background-color:white; border: 
                    solid 1px #6E6E6E; height: 30px; font-size:18px; vertical-align:9px">
        </form>
    </body>
</html>
