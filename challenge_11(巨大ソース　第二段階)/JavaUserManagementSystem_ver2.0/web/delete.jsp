<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？
    <table border=1 >
                <tr>
                    <th>名前</th>
                    <th>生年月日</th>
                    <th>種別</th>
                    <th>電話番号</th>
                    <th>自己紹介</th>
                    <th>登録日</th>
                </tr>
                <tr>
                    <td width="100" align="center" bgcolor="#eeeeee"><%= udd.getName()%></td>
                    <td width="100" align="center"><%= udd.getBirthday()%></td>
                    <td width="100" align="center" bgcolor="#eeeeee"><%= jh.exTypenum(udd.getType())%></td>
                    <td width="200" align="center"><%= udd.getTell()%></td>
                    <td width="200" align="center" bgcolor="#eeeeee"><%= udd.getComment()%></td>
                    <td width="200" align="center" bgcolor="#eeeeee"><%= udd.getNewDate()%></td>
                </tr>
            </table><br>
    
    <form action="DeleteResult" method="POST">
      <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
      <input type="submit" name="YES" value="はい" style="width:100px">
    </form>
    <form action="ResultDetail" method="POST">
      <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
      <input type="hidden" name="back" value="BACK">
      <input type="submit" name="NO" value="詳細画面に戻る" style="width:100px">
    </form><br>
    
    <%= jh.home() %>
    </body>
</html>
