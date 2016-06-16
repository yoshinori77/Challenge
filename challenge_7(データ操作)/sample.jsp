<%-- 
    Document   : sample
    Created on : 2016/06/15, 17:43:41
    Author     : yoshi
--%>

<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
        // 課題2
        
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        
        // データの受け取り
        String txtName = request.getParameter("txtName");
        out.print(txtName);
        if (request.getParameter("man") == null) {
        } else if (request.getParameter("man").equals("on")) {
            String man = request.getParameter("man");
            out.print(man);
            out.print("<br>" + "男性");
        }
        
        if (request.getParameter("woman") == null) {
        } else if (request.getParameter("woman").equals("on")) {
            String woman = request.getParameter("woman");
            out.print(woman);
            out.print("<br>" + "女性");
        } 
        String mulText = request.getParameter("mulText");
        out.print("<br>" + mulText);
        %>
        
        <%
            // 課題3
            Date time = new Date();
            Cookie c = new Cookie("LastLogin", time.toString());
            response.addCookie(c);

            // 次の訪問で。。。
            Cookie cs[] = request.getCookies();
            if (cs != null) {
                for (int i=0; i<cs.length; i++) {
                    if (cs[i].getName().equals("LastLogin")) {
                        out.print("<br>" + "最後のログインは、"+cs[i].getValue() + "(cookie)");
                        break;
                    }
                }
            }
        %>
        
        <%
            // 課題4
            Date last = new Date();
            HttpSession hs = request.getSession(true);
            hs.setAttribute("LastLogin", last.toString());

            // 次の訪問で。。。
            out.print("<br>" + "最後のログインは、"+hs.getAttribute("LastLogin") + "(session)");
        %>
        
        <%
            hs = request.getSession(true);
            hs.setAttribute("name", txtName.toString());
            if (request.getParameter("man") != null) {
                hs.setAttribute("man", "on");
            }
            if (request.getParameter("woman") != null) {
                hs.setAttribute("woman", "on");
            }
            
            hs.setAttribute("mulText", mulText.toString());
        %>
        
    </body>
</html>
