<%-- 
    Document   : jdbc_kadai11
    Created on : 2016/06/21, 11:35:36
    Author     : yoshi
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
        // 課題11
            Connection db_con = null;
            PreparedStatement db_st = null;
            
            request.setCharacterEncoding("UTF-8");

            // データの受け取り
            String id = request.getParameter("txtID");
            String name = request.getParameter("txtName");
            String tell = request.getParameter("txtTell");
            String age = request.getParameter("txtAge");
            String birthday = request.getParameter("txtBirthday");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");
            
            // パース
            db_st = db_con.prepareStatement("update profiles set name=?, tell=?, age=?, birthday=? where profilesID=?;");
            Integer db_id = Integer.parseInt(id);
            String db_name = name;
            String db_tell = tell;
            Integer db_age = Integer.parseInt(age);
            Date db_birthday = dateFormat.parse(birthday);
            
            // insert文にパラメータをセット
            db_st.setInt(5, db_id);
            db_st.setString(1, db_name);
            db_st.setString(2, db_tell);
            db_st.setInt(3, db_age);
            db_st.setDate(4,new java.sql.Date(db_birthday.getTime()));
            
            // SQLを実行
            db_st.executeUpdate();
       
            db_con.close();
        %>
    </body>
</html>
