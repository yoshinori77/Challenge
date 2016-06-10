/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yoshi
 */
@WebServlet(urlPatterns = {"/java3"})
public class java3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            for(int i = 0; i<10; i++) {
                userInfo(out);
            }
            
            addOrEven(out, 6);
            
            calculation(6, out);
            
            if(userInfo(out) == true) {
                out.print("<br>" + "この処理は正しく実行できました" + "<br>");
            } else {
                out.print("<br>" + "正しく実行できませんでした" + "<br>");
            }
            
            String[] list = memberList();
            out.print("<br>" + "名前: " + list[1]);
            out.print("<br>" + "生年月日: " + list[2]);
            out.print("<br>" + "住所: " + list[3] + "<br>");
           
            String[] mlist = membersList("2");
            out.print("<br>" + "名前: " + mlist[1]);
            out.print("<br>" + "生年月日: " + mlist[2]);
            out.print("<br>" + "住所: " + mlist[3] + "<br>" + "<br>");  
            
            friendList(out);
            
            humanList(out);
        }
    }
    
    // 課題1 課題4
    protected boolean userInfo(PrintWriter out) {
                String name = "山下慶倫";
                String birthday = "1991/06/12";
                String profile = "24歳の男です。";
                out.println(name + "<br>");
                out.println(birthday + "<br>");
                out.println(profile + "<br>");
                
                return true;
            }        
    
    // 課題2
    protected void addOrEven(PrintWriter out, int num) {
        if (num % 2 == 0) {
            out.print("<br>" + num + "は偶数" + "<br>");
        } else {
            out.print("<br>" + num + "は奇数" + "<br>");
        }
    }
    
    // 課題3 デフォルト値
    void calculation(int num1, PrintWriter out) {
        int num2 = 5;
        boolean type = false;
        calculation(num1, num2, type, out);
    }
    
    // 課題3
    protected void calculation(int num1, int num2, boolean type, PrintWriter out) {
        int multi = num1 * num2;
        if (type == true) {
            out.print("<br>" + multi * multi + "<br>" + "<br>");
        } else {
            out.print("<br>" + multi + "<br>" + "<br>");
        }
        
    }
    
    // 課題5
    protected String[] memberList() {
        String listArray[] = {"1", "山田太郎", "1950/01/01", "東京都新宿区1-1"};
        return listArray;
    }
    
    // 課題6
    protected String[] membersList(String id) {
        if (id.equals("1")) {
            String mArray[] = {"1", "山田太郎", "1950/01/01", "東京都新宿区1-1"};
            return mArray;
        } else if (id.equals("2")) {
            String mArray[] = {"2", "鈴木健太", "1975/05/05", null};
            return mArray;
        } else if (id.equals("3")) {
            String mArray[] = {"3", "佐藤和輝", "2000/10/10", "千葉県木更津市3-3"};
            return mArray;
        } else {
            return null;
        }
    }
    
    // 課題7
    // 3人分の情報をそれぞれfArrayに代入し、配列の要素を評価する
    // 配列の要素がnullだったら、処理をスキップして次のループへ進む
    protected void friendList(PrintWriter out) {
        for(int i=1; i<4; i++){
            String id = String.valueOf(i);
            String fArray[] = membersList(id);
            for(int m = 0; m<4; m++) {
                if(fArray[m] == null) {
                    continue;
                } else if(m != 0) {
                    out.println(fArray[m] + "<br>");
                }
            }
        }
        out.print("<br>");
    }
    
    // 課題8
    // 2人目の情報を表示したら、breakでループを抜ける
    protected void humanList(PrintWriter out) {
        for(int i=1; i<4; i++){
            int limit = 2;
            String id = String.valueOf(i);
            String fArray[] = membersList(id);
            for(int m = 0; m<4; m++) {
                if(fArray[m] == null) {
                    continue;

                } else if(m != 0) {
                    out.println(fArray[m] + "<br>");
                }
            }
            if(i == limit) {
                break;
            }
        }
    }
    
    
    
    
    
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
