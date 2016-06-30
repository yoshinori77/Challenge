<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
    ArrayList<UserDataDTO> memberList= (ArrayList<UserDataDTO>) request.getAttribute("resultData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1 >
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日</th>
            </tr>

            <% for (int i=0; i<memberList.size(); i++) { %>
                <tr>
                    <td width="100" height="20" align="center"><a href="ResultDetail?id=<%= memberList.get(i).getUserID()%>&ac=<%= hs.getAttribute("ac")%>"><%= memberList.get(i).getName()%></a></td>
                    <td width="100" height="20"  align="center" bgcolor="#eeeeee"><%= memberList.get(i).getBirthday()%></td>
                    <td width="100" height="20"  align="center"><%= udb.showType(memberList.get(i).getType())%></td>
                    <td width="100" height="20"  align="center" bgcolor="#eeeeee"><%= udb.parseNewDate(memberList.get(i).getNewDate())%></td>
                </tr>
            <% } %>
        </table><br>
    
        <form action="Search" method="POST">
            <input type="submit" name="no" value="検索画面に戻る">
            <input type="hidden" name="back" value="BACK">
        </form><br>
        
        <%=jh.home()%>
    </body>
</html>
