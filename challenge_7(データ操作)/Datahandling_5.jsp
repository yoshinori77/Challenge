<%-- 
    Document   : Datahandling_5
    Created on : 2016/06/16, 12:04:16
    Author     : yoshi
--%>
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
            // 課題5
            request.setCharacterEncoding("UTF-8");

            // データの受け取り
            String txtName = request.getParameter("txtName");
            String mulText = request.getParameter("mulText");
        
            HttpSession hs = request.getSession(true);
            hs.setAttribute("mulText", mulText.toString());
            hs.setAttribute("name", txtName.toString());
            // nullでなければセッションに保存する
            if (request.getParameter("man") != null) {
                String man = request.getParameter("man");
                hs.setAttribute("man", "on");
            }
            
            // nullでなければセッションに保存する
            if (request.getParameter("woman") != null) {
                String woman = request.getParameter("woman");
                hs.setAttribute("woman", "on");
            } 
            
        %>
        
        <form action="" method="post">
            名前: <input type="text" name="txtName" value="<% out.print(hs.getAttribute("name")); %>">
            性別: 男性<input type="radio" name="man" <%
                // nullでなければチェックする
                if (request.getParameter("man") != null) {
                    out.print("checked=\"checked\"");
                } %>>
            女性<input type="radio" name="woman" <% 
                // nullでなければチェックする
                if (request.getParameter("woman") != null) {
                    out.print("checked=\"checked\"");
                } %>>
            趣味: <textarea name="mulText"><% out.print(hs.getAttribute("mulText")); %></textarea>
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
