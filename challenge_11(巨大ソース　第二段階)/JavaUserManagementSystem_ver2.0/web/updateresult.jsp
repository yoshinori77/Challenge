<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) request.getAttribute("udb");
    Integer ac = (Integer)request.getAttribute("ac");
    HttpSession hs = request.getSession();
    hs.setAttribute("ac", ac);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        <table border=1 >
                <tr>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>種別</th>
                    <th>電話番号</th>
                    <th>自己紹介</th>
                </tr>
                <tr>
                    <td width="100" align="center" bgcolor="#eeeeee"><%= udb.getName()%></td>
                    <td width="100" align="center"><%= udb.getYear()+"-"+udb.parseMonth(udb.getMonth())+"-"+udb.parseDay(udb.getDay())%></td>
                    <td width="100" align="center" bgcolor="#eeeeee"><%= jh.exTypenum(udb.getType())%></td>
                    <td width="200" align="center"><%= udb.getTell()%></td>
                    <td width="200" align="center" bgcolor="#eeeeee"><%= udb.getComment()%></td>
                </tr>
            </table><br>
            
        以上の内容で登録しました。<br><br>
        
        <form action="ResultDetail" method="POST">
            <input type="hidden" name="ac"  value="<%= request.getAttribute("ac")%>">
            <input type="hidden" name="back" value="BACK">
            <input type="submit" name="no" value="詳細画面へ戻る">
        </form><br>
    </body>
    <%=jh.home()%>
</html>
