<%-- 
    Document   : java2
    Created on : 2016/06/08, 10:52:46
    Author     : yoshi
--%>

<%@ page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><%
           // 課題1
           int num = 2;
           String message = "";
           switch(num) {
               case 1:
                   message = "one";
                   break;
               case 2:
                   message = "two";
                   break;
               default:
                   message = "想定外";
                   break;
           }
           out.println(message);
        %></p>
           
           <p><%
           // 課題2
           String str = "A";
           String language = "";
           switch(str) {
               case "A":
                   language = "英語";
                   break;
               case "あ":
                   language = "日本語";
                   break;
               default:
                   language = "";
                   break;
           }
           out.println(language);
           %></p>
           
            <p><%
               // 課題3
               long number = 1;
               for(int i = 1; i<21; i++) {
                   number = number * 8;
               }
               out.println(number);
               %></p>
           
            <p><%
                // 課題4
               String s = "";
               for(int i =1; i<31; i++) {
                   s = s + "a";
               }
               out.print(s);               
               %></p>
           
            <p><%
                // 課題5
               int sum = 0;
               for(int n = 0; n<101; ++n) {
                   sum = sum + n;
               }
               out.print(sum);
              %></p>
           
            <p><%
                // 課題6
               int number1 = 1000;
               while(number1 >= 100) {
                   number1 = number1 / 2;
                   out.println(number1 + "<br>");
               }
              %></p>
            
            <p><%
                // 課題7
                String Arr[] = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};
                out.println(Arrays.toString(Arr) + "<br>");
                // 課題8
                Arr[2] = "33";
                out.println(Arrays.toString(Arr));
              %></p>
            
            <p><%
                // 課題9
                HashMap<String, String> hMap = new HashMap<String, String>();
                hMap.put("1","AAA");
                hMap.put("hello","world");
                hMap.put("soeda","33");
                hMap.put("20", "20");
                out.println(hMap);
             %></p>
            
            <p><%
                // 課題10 
                int hoge = 25;
                int k = 0;
                out.print("元の値: " + hoge + " ");
                int numArray[] = {2,3,5,7};
                out.print("素数: ");
                for (int i=0;i<numArray.length;i++) {
                  // 素数なら割って、カウントをプラス1を繰り返す
                  while(hoge % numArray[i] == 0) {
                      hoge /= numArray[i];
                      k++;
                  }   
                      // カウントがゼロなら処理をせずに次のループへ飛ばす
                      if (k == 0) {
                          continue;
                      } else {
                          out.print(numArray[i] +"で"+  k + "回割れる ");   
                      }
                      // カウントを0に戻す
                      k = k - k;
                }
                if (hoge > 1){
                    out.print("その他: " + hoge);
                }
            %></p>
    </body>
</html>
