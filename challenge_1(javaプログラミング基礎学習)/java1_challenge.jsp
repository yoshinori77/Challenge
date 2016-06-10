<%-- 
    Document   : newjsp
    Created on : 2016/06/06, 2:27:41
    Author     : yoshi
--%>

<%@page import="java.lang.String"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<!--        課題１-->
        <h1>Hello World!</h1>
        <p>
        <%
            // 課題2
            out.println("groove" + "-" + "gear");
            %>
        </p>
        <p>
        <%  
            // 課題3
            out.println("私の名前は山下慶倫。24才の男です。");
            %>
        </p>
        <p>
        <%  
            // 課題4, 課題5
            final int I = 5;
            int i = 3;
            out.println(I + i);
            out.println(I - i);
            out.println(I * i);
            out.println(I / i);
            out.println(I % i);
            %>
            </p>
        <p>
        <%  
            // 課題6
            int a = 2;
            if (a == 1) {
               out.println("1です!");
            } else if (a == 2) {
               out.println("プログラミングキャンプ！");
            } else {
                out.print("その他です!");
            }
            %>
            </p>
        <p>
        <%  
            // 課題7
            String category1 = request.getParameter("category1");
            String amount1 = request.getParameter("amount1");
            String num1 = request.getParameter("num1");
            int total_amount1 = Integer.parseInt(amount1);
            int number1 = Integer.parseInt(num1);
            int unit_price1 = total_amount1 / number1;
            if (category1.equals("1")) {
                out.println(category1 + "：雑貨");
            } else if (category1.equals("2")) {
                out.println(category1 + "：生鮮食品");
            } else if (category1.equals("3")) {
                out.println(category1 + "：その他");
            } 
            out.println("総額:" + total_amount1);
            out.println("単価:" + unit_price1);
            if (total_amount1 >= 5000) {
                out.println("ポイント:" + total_amount1 / 20);
            } else if (total_amount1 >= 3000) {
                out.println("ポイント:" + total_amount1 / 25);
            }
        %></p>

    </body>
</html>