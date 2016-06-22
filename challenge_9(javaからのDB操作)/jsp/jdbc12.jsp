<%-- 
    Document   : jdbc12
    Created on : 2016/06/21, 15:11:27
    Author     : yoshi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./jdbc12" method="post">
            名前：　<input type="text" name="txtName" size="60" style="border: 1px solid; padding: 2px; background: url(http://www.google.com/cse/static/ja/google_custom_search_watermark.gif\") left center no-repeat"> <br>
            <br>  年齢：　<input type="text" name="txtAge" size="60" style="border: 1px solid; padding: 2px; background: url(http://www.google.com/cse/static/ja/google_custom_search_watermark.gif\") left center no-repeat"> <br>
            <br>  生年月日：　<input type="text" name="txtBirthday" size="60" style="border: 1px solid; padding: 2px; background: url(http://www.google.com/cse/static/ja/google_custom_search_watermark.gif\") left center no-repeat"> <br>
            <br> <input type="submit" name="btnSubmit" value="検索">
        </form>
    </body>
</html>
