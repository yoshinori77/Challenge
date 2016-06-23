<%-- 
    Document   : index
    Created on : 2016/06/17, 13:15:10
    Author     : yoshi
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><font size="6" color="#00ff00">登録しました</font></p>
        <form action="./index1" method="post">
            <br> <input type="submit" name="btnSubmit" value="商品の一覧を見る >>" style="background-color:white; border: 
                    solid 1px #6E6E6E; height: 30px; font-size:18px; vertical-align:9px">
        </form>
        
        <form action="./jdbc_advance.jsp" method="post">
            <br> <input type="submit" name="btnSubmit" value="LOG OUT >>" style="background-color:white; border: 
                    solid 1px #6E6E6E; height: 30px; font-size:18px; vertical-align:9px">
        </form>
    </body>
</html>
