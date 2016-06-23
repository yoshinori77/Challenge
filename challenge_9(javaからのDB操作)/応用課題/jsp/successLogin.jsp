<%-- 
    Document   : jdbc_advance2
    Created on : 2016/06/22, 15:03:05
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
        <form action="./successLogin" method="post">
            アイテムID：　<input type="text" name="txtID" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  商品名：　<input type="text" name="txtName" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  価格：　<input type="text" name="txtPrice" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  生産地：　<input type="text" name="txtArea" size="60" style="border: 1px solid; padding: 3px;"> <br>
<!--            <br>  生年月日：　<input type="text" name="txtBirthday" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  メールアドレス：　<input type="text" name="txtAddress" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  商品番号：　<input type="text" name="txtItemID" size="60" style="border: 1px solid; padding: 3px;"> <br>
            <br>  パスワード：　<input type="text" name="txtPassword" size="60" style="border: 1px solid; padding: 3px;"> <br>-->
            <br> <input type="submit" name="btnSubmit" value="登録" style="background-color:white; border: 
                    solid 1px #6E6E6E; height: 30px; font-size:18px; vertical-align:9px">
        </form>
        
        <form action="jdbc_advance.jsp" method="post">
            <br> <input type="submit" name="btnSubmit" value="LOG OUT >>" style="background-color:white; border: 
                    solid 1px #6E6E6E; height: 30px; font-size:18px; vertical-align:9px">
        </form>
    </body>
</html>
