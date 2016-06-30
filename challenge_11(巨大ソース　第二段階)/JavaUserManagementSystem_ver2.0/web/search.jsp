<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    boolean backflg = false;
    UserDataBeans udb = null;
    if(request.getParameter("back") != null && request.getParameter("back").equals("BACK")){
        backflg = true;
        udb = (UserDataBeans)session.getAttribute("udb"); 
   }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報検索画面</title>
    </head>
    <body>
        <form action="SearchResult" method="GET">
            名前:
            <input type="text" name="name" value="<% if(backflg){out.print(udb.getName());}%>">
            <br><br>

            生年:　
            <select name="year">
                <option value="">----</option>
                <% for(int i=1950; i<=2010;i ++){ %>
                <option value="<%=i%>" <% if(backflg && udb.getYear() == i){out.print("selected = \"selected\"");}%>><%=i%></option>
                <% } %>
            </select>年生まれ
            <br><br>

            種別:
            <br>
                <% for(int i = 1; i<=3; i++){ %>
                <input type="radio" name="type" value="<%=i%>"<%if(backflg && udb.getType() == i){out.print("checked = \"checked\"");}%>><%=jh.exTypenum(i)%><br>
                <% } %>
            <br>
            <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="検索">
        </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
