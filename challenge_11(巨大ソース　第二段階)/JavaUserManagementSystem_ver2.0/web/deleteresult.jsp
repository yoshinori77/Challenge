<%@page import="jums.JumsHelper"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    hs.setAttribute("ac", request.getAttribute("ac"));
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    
    <form action="SearchResult" method="POST">
        <input type="hidden" name="ac"  value="<%= request.getAttribute("ac")%>">
        <input type="submit" name="no" value="検索結果画面に戻る">
        <input type="hidden" name="back"  value="BACK">
    </form><br>
    
    <%= jh.home() %>
    </body>
</html>
