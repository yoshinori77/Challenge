<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    // セッションに格納したudbオブジェクトを取得
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <!--入力欄が全て空の場合-->
        <% if (udb == null || udb.getName().equals("") && udb.getYear().equals("")  && udb.getMonth().equals("") && udb.getDay().equals("") && udb.getTell().equals("") && udb.getComment().equals("")) { %>
            <h1>入力値が不正です</h1>
        <% } else { %>
            <% if(udb.getName().equals("")) { %>
                <h1>名前が空欄です</h1>
            <% } %>
            <% if (udb.getYear().equals("") || udb.getMonth().equals("") || udb.getDay().equals("")) { %>
                <h1>生年月日が空欄です</h1>
            <% } %>
            <% if (udb.getType() == 0) { %>
                <h1>職業が空欄です</h1>
            <% } %>
            <% if (udb.getTell().equals("")) { %>
                <h1>電話番号が空欄です</h1>
            <% } %>
            <% if (udb.getComment().equals("")) { %>
                <h1>自己紹介文が空欄です</h1>
            <% } %>
            <!-- 全ての項目を埋めた場合-->
            <% if (!udb.getName().equals("") && !udb.getYear().equals("")  && !udb.getMonth().equals("") && !udb.getDay().equals("") && !udb.getTell().equals("") && !udb.getComment().equals("")) { %>
            <h1>登録確認</h1>
            名前:<%= udb.getName()%><br>
            生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
            <!--getType()で取得したint型の返り値をswitch文で条件分岐-->
            種別:<%
                int num = udb.getType(); String message = "  ";
                switch(num) {
                    case 1:
                        message = "エンジニア";
                        break;
                    case 2:
                        message = "営業";
                        break;
                    case 3:
                        message = "その他";
                        break;
                    default:
                        message = "職業が空です";
                        break;
                }
                out.println(message);
            %><br>
            電話番号:<%= udb.getTell()%><br>
            自己紹介:<%= udb.getComment()%><br>
            上記の内容で登録します。よろしいですか？
            <form action="insertresult" method="POST">
                <input type="submit" name="yes" value="はい">
            </form>
            <% } %>
        <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
