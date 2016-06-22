<%-- 
    Document   : ｊｄｂc_kadai11
    Created on : 2016/06/21, 11:24:09
    Author     : yoshi
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        // 課題10
            Connection db_con = null;
            PreparedStatement db_st = null;
            
            request.setCharacterEncoding("UTF-8");

            // データの受け取り
            String id = request.getParameter("txtID");
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            // パース
            db_st = db_con.prepareStatement("delete from profiles where profilesID=?;");
            Integer db_id = Integer.parseInt(id);
            
            // insert文にパラメータをセット
            db_st.setInt(1, db_id);
            
            // SQLを実行
            db_st.executeUpdate();
       
            db_con.close();
        %>
    </body>
</html>
