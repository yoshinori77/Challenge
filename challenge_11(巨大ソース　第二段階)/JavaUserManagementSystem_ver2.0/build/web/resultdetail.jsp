<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans) session.getAttribute("udb");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <form action="Update" method="POST">
            <h1>詳細情報</h1>
            <table border=1 >
                <tr>
                    <th>ユーザーID</th>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>種別</th>
                    <th>電話番号</th>
                    <th>自己紹介</th>
                    <th>登録日時</th>
                </tr>
                <tr>
                    <td name="userID" width="100" align="center"><%= udd.getUserID()%></td>
                    <td name="name" width="100" align="center" bgcolor="#eeeeee"><%= udd.getName()%></td>
                    <td name="birthday" width="100" align="center"><%= udd.getBirthday()%></td>
                    <td name="type" width="100" align="center" bgcolor="#eeeeee"><%= udb.showType(udd.getType())%></td>
                    <td name="tell" width="200" align="center"><%= udd.getTell()%></td>
                    <td name="comment" width="200" align="center" bgcolor="#eeeeee"><%= udd.getComment()%></td>
                    <td name="newDate" width="100" align="center"><%= udb.parseNewDate(udd.getNewDate())%></td>
                </tr>
            </table><br>
            <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="update" value="変更" style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="delete" value="削除" style="width:100px">
        </form><br>
        <form action="SearchResult" method="POST">
            <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
            <input type="submit" name="no" value="検索結果画面に戻る">
            <input type="hidden" name="back"  value="BACK">
        </form><br>
        
        <%=jh.home()%>
    </body>
</html>
