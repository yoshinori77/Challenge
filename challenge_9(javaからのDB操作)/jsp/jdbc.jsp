<%-- 
    Document   : jdbc.jsp
    Created on : 2016/06/17, 17:25:51
    Author     : yoshi
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        // 課題8
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            request.setCharacterEncoding("UTF-8");

            // データの受け取り
            String text = request.getParameter("text");
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            db_st = db_con.prepareStatement("select * from profiles where name like ?;");
            String name = "%" + text + "%";
            db_st.setString(1, name);
            db_data = db_st.executeQuery();
            while(db_data.next()) {
                out.print("<br>"+"ID："+db_data.getString("profilesID")+"　名前："+db_data.getString("name")+"　電話番号："+db_data.getString("tell")+"　年齢："+db_data.getString("age")+"　生年月日："+db_data.getDate("birthday")+"<br>");
            }
            
            out.print("<br>");
       
            db_con.close();
        %>
    </body>
</html>
