<%@page import="jums.UserDataBeans" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <% if (udb == null) {%>
            <input type="text" name="name" value="">
        <% } else { %>
            <input type="text" name="name" value="<%=udb.getName()%>">
        <% } %>
        
        <br><br>

        生年月日:　
        <select name="year">
            <% if (udb == null) { %>
            <option value="">----</option>
              <%  for(int i=1950; i<=2010; i++){ %>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            <% } else { %>
                <option value="<%=udb.getYear()%>"> <%= udb.getYear() %> </option>
                <option value="">----</option>
                <%  for(int i=1950; i<=2010; i++){ %>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            <% }%>
            
        </select>年
        <select name="month">
            <% if (udb == null) { %>
            <option value="">--</option>
                <% for(int i = 1; i<=12; i++){ %>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            <% } else { %>
                <option value="<%=udb.getMonth()%>"> <%= udb.getMonth() %> </option>
                <option value="">--</option>
                <% for(int i = 1; i<=12; i++){ %>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            <% } %>
        </select>月
        <select name="day">
            <% if (udb == null) { %>
            <option value="">--</option>
                <% for(int i = 1; i<=31; i++){ %>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            <% } else { %>
                <option value="<%=udb.getDay()%>"> <%= udb.getDay() %> </option>
                <option value="">--</option>
                 <% for(int i = 1; i<=31; i++){ %>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <% if (udb == null || udb.getType() == 0) { %>
            <input type="radio" name="type" value="1">エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3">その他<br>
        <% } else if (udb.getType() == 1) { %>
            <input type="radio" name="type" value="1" checked="checked">エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3">その他<br>
        <% } else if (udb.getType() == 2) { %>
            <input type="radio" name="type" value="1">エンジニア<br>
            <input type="radio" name="type" value="2" checked="checked">営業<br>
            <input type="radio" name="type" value="3">その他<br>
        <% } else if (udb.getType() == 3) { %>
            <input type="radio" name="type" value="1">エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3" checked="checked">その他<br>
        <% } %>
        <br>

        電話番号:
        <% if (udb == null) { %>
            <input type="text" name="tell" value="">
        <% } else { %>
            <input type="text" name="tell" value="<%= udb.getTell() %>">
        <% } %>
        <br><br>

        自己紹介文
        <br>
        <% if (udb == null) { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"></textarea><br><br>
        <% } else { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%></textarea>
        <% } %><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
