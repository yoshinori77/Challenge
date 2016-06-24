<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
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
<!--        nullあるいはフォームが全て空欄の場合には
        登録できない-->
        <% if (udb == null || udb.getName().equals("") && udb.getYear().equals("")  && udb.getMonth().equals("") && udb.getDay().equals("") && udb.getType() == 0 && udb.getTell().equals("") && udb.getComment().equals("")) { %>
            <h1>入力値が不正です</h1>
        <!--フォームの一部が空欄の場合も登録できない
          それぞれのタグ毎に空欄の警告を出すために、if文を羅列した
          TODO  冗長な記述になってしまったので、改善策があれば修正-->
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
            <!--全てのフォームに値が入っている場合のみ登録可能-->
            <% if (!udb.getName().equals("") && !udb.getYear().equals("")  && !udb.getMonth().equals("") && !udb.getDay().equals("") && udb.getType() != 0 && !udb.getTell().equals("") && !udb.getComment().equals("")) { %>
            <h1>登録確認</h1>
            名前:<%= udb.getName()%><br>
            生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
            
            種別:<%
                // 種別はradioボタン、変数がint
                // 直接表示できないので、switch文で表示させる
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
